/**
 * 
 */
package it.polito.verifuse.main;


import it.polito.verifuse.functionality.BuildFunctionality;
import it.polito.verifuse.functionality.ChainOfFunctionality;
import it.polito.verifuse.functionality.ChainingProcess;
import it.polito.verifuse.functionality.Functionality;
import it.polito.verifuse.jaxb.manifestvnfs.ManifestVNFs;
import it.polito.verifuse.jaxb.node.Node;
import it.polito.verifuse.jaxb.node.ObjectFactory;
import it.polito.verifuse.jaxb.requirementslist.Requirement;
import it.polito.verifuse.jaxb.requirementslist.RequirementsList;
import it.polito.verifuse.jaxb.tools.Tools;
import it.polito.verifuse.modules.LER;
import it.polito.verifuse.modules.RDF;
import it.polito.verifuse.neo4j.client.Neo4jClient;
import it.polito.verifuse.utility.classes.*;
import it.polito.verifuse.utility.consts.Consts;
import it.polito.verifuse.utility.exceptions.MyExceptions;
import it.polito.verifuse.utility.exceptions.MyExceptions.*;
import it.polito.verifuse.utility.validator.ValidatorFiles;

import java.io.File;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.codehaus.jackson.map.util.Comparators;

import gurobi.GRB.Status;

/**
 * @author Cosimo MANISI
 *
 */
public class MainUseCases {


	public static void main(String[] args) {
		try{
			it.polito.verifuse.utility.classes.Unmarshaller m 	= new it.polito.verifuse.utility.classes.Unmarshaller();
			GetDataInput data_requirement						= new GetDataInput();
			GetDataInput data_manifest							= new GetDataInput();
			ConcurrentHashMap<String, ManifestVNF> VNFs			= new ConcurrentHashMap<>(); 
			Neo4jClient client									= null;
			HashSet<Thread> listThread							= new HashSet<>();
			long startProg=0;
			long endProg=0;
			long start=0;
			long end=0;

			/** 
			 * PREPARING TO UNMARSHALLING -- VALIDATING FILE XML AGAINST XSD SCHEMA
			 * Modificati per essere passati da riga di comando
			 */
			String pathXmlRequirement 		= null;
			String pathXmlManifestVnfs 	   	= null;
			String pathXmlTools 	   	   	= null;
			String savePath					= null;
			
			if(args.length==4){
				pathXmlRequirement 		= args[0];
				pathXmlManifestVnfs 	= args[1];
				pathXmlTools 	   	   	= args[2];
				savePath				= args[3];
			}else{
				pathXmlRequirement 		= Consts.PATH_XML_REQUIREMENTSLIST_USE_CASES;
				pathXmlManifestVnfs 	= Consts.PATH_XML_MANIFEST_USE_CASES;
				pathXmlTools 	   	   	= Consts.PATH_XML_TOOLS;
			}
			
			ValidatorFiles validateRequirement	= new ValidatorFiles(pathXmlRequirement, 	Consts.PATH_XSD_REQUIREMENTSLIST);
			ValidatorFiles validateManifest		= new ValidatorFiles(pathXmlManifestVnfs, 	Consts.PATH_XSD_MANIFEST);
			ValidatorFiles validateTools		= new ValidatorFiles(pathXmlTools, 			Consts.PATH_XSD_TOOLS);

			if(!validateManifest.validate() || !validateRequirement.validate() || !validateTools.validate())
				throw new ValidationFileException("File Validation Error");

			Tools tools				= m.unmarshallTools(pathXmlTools, Consts.PACKAGE_TOOLS);
			ManifestVNFs manifest	= m.unmarshallManifestVnfs(pathXmlManifestVnfs, Consts.PACKAGE_MANIFEST);

			if(tools.getOutputOnFile().isEnable()){
				System.setOut(new PrintStream(new File("output-file.txt")));
			}
			
			/**
			 * CHECK WHICH TOOL ARE ACTIVATE IN THE TOOLS.XML FILE 
			 */
			
			if( manifest == null ){
				throw new UnmarshalFileXMLException("Unmarshall MANIFEST operations can not be completed due to some problem : "+Consts.PATH_XML_MANIFEST);
			}
			
			/**
			 * VNFS 
			 */
			UtilsFunction.fillMapVNFs(manifest,VNFs);
			/*VNFs.forEach((k, v) -> System.out.println(v.PrintAllInformation()));*/
			
			/**
			 * REQUIREMENT unmarshalling operation 
			 */
			start=System.currentTimeMillis();
			RequirementsList requirements 	= m.unmarshallRequirements(pathXmlRequirement, Consts.PACKAGE_REQUIREMENTSLIST);
			end=System.currentTimeMillis();

			if( requirements ==null ){
				throw new UnmarshalFileXMLException("Unmarshall REQUIREMENTS operations can not be completed due to some problem: "+Consts.PATH_XML_REQUIREMENTSLIST);
			}
			
			
			int id_requrement=0;
			startProg=System.currentTimeMillis();		
			
			/**
			 * Navigation inside the file RequirementsList.xml -
			 * 1)  Given the requirement object, try if it possible build a functionality
			 * 2)  If we have more than one functionality the LER BLOCK is activated and try
			 * 		identify how they can be combined together
			 **/
			ExecutorService executorMarshalling = Executors.newFixedThreadPool(Consts.NUMBERTHREAD);
					
			for(Requirement jaxb_req :requirements.getRequirement()){
				client= new Neo4jClient();
				try{     	
					it.polito.verifuse.utility.classes.Requirement r =data_requirement.getData(jaxb_req); 
					id_requrement=r.getRequirementID();
					String pathreq="outputChain/output_Requirement_"+id_requrement+".xml";
					/*
					System.out.println(UtilsFunction.makeLine('-'));
					System.out.println("\t REQUIREMENT = "+id_requrement);
					
					
					System.out.println(UtilsFunction.makeLine('-'));
					r.printNameFields();
					System.out.println(UtilsFunction.makeLine('-'));
					r.printNameActions();
					System.out.println(UtilsFunction.makeLine('-'));
					*/
					
					/***********************************************
					 * RDF BLOCK - Requirement Driven Functionality 
					 ***********************************************/

					RDF rdf= new RDF(r, VNFs);
					if(!rdf.findMappingFunctionality())
						throw new NotFoundMappingFunctionalityException("Error: is not possibile to find mapping functionality");

					//rdf.printFunctionality();

					/*****************************************************************
					 * NEO4J DB - Save Structure Inside DB - GUI
					 *****************************************************************/

					boolean postSuccess=true;
					if(tools.getGrapghNeo4J().isEnable()){
						postSuccess=rdf.graphDBNeo4j(client);
						if(!postSuccess)
							System.out.println("Error during the allocation node in neo4j db");
					}
					

					/*********************************
					 * LER BLOCK - combination logic 
					 *********************************/
					
					//System.out.println(UtilsFunction.makeLine('-'));
					LER ler= new LER(new ArrayList<>(rdf.getMapToFunctionality().values()), r);
					


					start=System.currentTimeMillis();
					boolean status=ler.searchForChainGivenFunctionality();
					end=System.currentTimeMillis();
					//System.out.println("<"+id_requrement+">Finding chaining = "+(end-start)+"ms");


					if(!status){
						throw new FindChainFunctionalityException("No Chaining are find - the set is empty - no reason to proceed");
					}
					
					// print solution chain found 
					//ler.printAllSolutionChain();

					/*********************************
					 * NEO4J DB 
					 *********************************/

					if(tools.getGrapghNeo4J().isEnable() && postSuccess){
			  			boolean out=ler.graphDBNeo4j(rdf.getNodeOfFunctionality(), client);
						if(!out)
							System.out.println("Error during the allocation node in neo4j db");
					}
					
					/**********************************************************************
					 * Marshal solution into file  
					 * to avoid to lose time for write file xml	- a new thread is dropped 
					 **********************************************************************/
					String finalPath=null;
					if(savePath==null)
						finalPath=pathreq;
					else
						finalPath=savePath+"Requirement.xml";
					if(tools.getMarshallOnfile().isEnable()){ 
						executorMarshalling.execute(new MarshallerChainFunctionality(r, jaxb_req, finalPath,ler.getOverallChain(), ler.getMapSolSatisfiability()));
					}
					
					/********************************************************************************
					 * Close the connection with neo4j - if necessary new connection will be establish
					 ********************************************************************************/


					
				}catch (NotFoundMappingFunctionalityException e) {
					System.out.println("<!> Requirement whit id= "+id_requrement+". No Functionality are found.");
				}catch (FindChainFunctionalityException e) {
					System.out.println("<!> Requirement whit id= "+id_requrement+". Not Chain of functionalities found.");
				}catch (Exception e) {
					client.close();
					e.printStackTrace();
					System.out.println("< ! > ECCEZIONE - Requirement whit id= "+id_requrement+" will not considered.");
				}
				client.close();							

			}
			
			endProg=System.currentTimeMillis();
			//System.out.println("ALL REQUIREMENT HAS BEEN PROCESSED AND ARE TERMINATED IN = "+(endProg-startProg)+"ms");
			
			//ATTENDI eventuali thread di marshalling che non hanno ancora terminato;
			executorMarshalling.shutdown();
	        while (!executorMarshalling.isTerminated()) {}
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}


}
