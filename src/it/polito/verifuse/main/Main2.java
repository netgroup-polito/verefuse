/**
 * 
 */
package it.polito.verifuse.main;


import it.polito.verifuse.functionality.BuildFunctionality;
import it.polito.verifuse.functionality.ChainOfFunctionality;
import it.polito.verifuse.functionality.ChainingProcess;
import it.polito.verifuse.functionality.FunctionalitiesSelection;
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
public class Main2 {

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
				pathXmlRequirement 		= Consts.PATH_XML_REQUIREMENTSLIST;
				pathXmlManifestVnfs 	= Consts.PATH_XML_MANIFEST;
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
			/*
			System.out.println("************* TOOL ENABLED by tools.xml file *************");
			System.out.println(UtilsFunction.makeLine('-'));
			System.out.println("Neo4jDB status="			+tools.getGrapghNeo4J().isEnable());
			System.out.println("Marshall on file status="	+tools.getMarshallOnfile().isEnable());
			System.out.println("Output on file status="		+tools.getOutputOnFile().isEnable());
			System.out.println(UtilsFunction.makeLine('-'));
			*/
			
			if( manifest == null ){
				throw new UnmarshalFileXMLException("Unmarshall MANIFEST operations can not be completed due to some problem : "+Consts.PATH_XML_MANIFEST);
			}
			/*
			System.out.println("> Unmarshall MANIFEST ended - Find =  "+manifest.getManifestVNF().size() );
			System.out.println(UtilsFunction.makeLine('-'));*/
			/**
			 * VNFS 
			 */
			UtilsFunction.fillMapVNFs(manifest,VNFs);

			/*
			for(it.polito.verifuse.jaxb.manifestvnfs.ManifestVNFs.ManifestVNF vnf :manifest.getManifestVNF()){
				VNFs.put(vnf.getManifestID(), data_manifest.getData(vnf));
			}

			VNFs.forEach((k, v) -> System.out.println(v.PrintAllInformation()));*/
			
			/**
			 * REQUIREMENT unmarshalling operation 
			 */
			start=System.currentTimeMillis();
			RequirementsList requirements 	= m.unmarshallRequirements(pathXmlRequirement, Consts.PACKAGE_REQUIREMENTSLIST);
			end=System.currentTimeMillis();

			if( requirements ==null ){
				throw new UnmarshalFileXMLException("Unmarshall REQUIREMENTS operations can not be completed due to some problem: "+Consts.PATH_XML_REQUIREMENTSLIST);
			}
			/*
			System.out.println("> Unmarshall REQUIREMENTS ended in :"+(end-start)+"ms Element: "+requirements.getRequirement().size() );
			System.out.println(UtilsFunction.makeLine('-'));*/
			
			startProg=System.currentTimeMillis();		
			
			/**
			 * Navigation inside the file RequirementsList.xml -
			 * 1)  Given the requirement object, try if it possible build a functionality
			 * 2)  If we have more than one functionality the LER BLOCK is activated and try
			 * 		identify how they can be combined together
			 **/
			FunctionalitiesSelection fs= new FunctionalitiesSelection(requirements, VNFs,tools);
			fs.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}


}
