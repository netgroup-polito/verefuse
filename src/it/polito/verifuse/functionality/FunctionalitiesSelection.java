package it.polito.verifuse.functionality;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import it.polito.verifuse.jaxb.tools.Tools.*;
import it.polito.verifuse.utility.classes.*;
import it.polito.verifuse.utility.classes.ManifestVNF;
import it.polito.verifuse.utility.consts.Consts;
import it.polito.verifuse.utility.exceptions.MyExceptions.*;
import it.polito.verifuse.jaxb.manifestvnfs.ManifestVNFs.*;
import it.polito.verifuse.jaxb.requirementslist.RequirementsList;
import it.polito.verifuse.jaxb.tools.Tools;
import it.polito.verifuse.modules.LER;
import it.polito.verifuse.modules.RDF;
import it.polito.verifuse.neo4j.client.Neo4jClient;

public class FunctionalitiesSelection {
	private RequirementsList requirements=null;
	private ConcurrentHashMap<String, ManifestVNF> VNFs= null;
	private Tools tools;
	public FunctionalitiesSelection(RequirementsList requirements, ConcurrentHashMap<String, ManifestVNF> vNFs,Tools tools) {
		this.requirements = requirements;
		this.VNFs = vNFs;
		this.tools=tools;
	}
	
	public void execute(){
		GetDataInput data_requirement	= new GetDataInput();
		ExecutorService executor = Executors.newFixedThreadPool(Consts.NUMBERTHREAD);
		
		for(it.polito.verifuse.jaxb.requirementslist.Requirement jaxb_req :requirements.getRequirement()){
			Runnable worker = new Runnable() {
					@Override
					public void run() {
						Neo4jClient client= new Neo4jClient();	
						int id_requrement=0;
						String savePath=null;
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
							/*********************************
							 * LER BLOCK - combination logic 
							 *********************************/
							
							//System.out.println(UtilsFunction.makeLine('-'));
							LER ler= new LER(new ArrayList<>(rdf.getMapToFunctionality().values()), r);
							
							long start=System.currentTimeMillis();
							boolean status=ler.searchForChainGivenFunctionality();
							long end=System.currentTimeMillis();
							//System.out.println("<"+id_requrement+">Finding chaining = "+(end-start)+"ms");


							if(!status){
								throw new FindChainFunctionalityException("No Chaining are find - the set is empty - no reason to proceed");
							}
							
							// print solution chain found 
							//ler.printAllSolutionChain();
							
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
								MarshallerChainFunctionality mc= new MarshallerChainFunctionality(r, jaxb_req, finalPath,ler.getOverallChain(), ler.getMapSolSatisfiability());
								mc.run();
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
			};		
			executor.execute(worker);
		}
		
		//System.out.println("ALL REQUIREMENT HAS BEEN PROCESSED AND ARE TERMINATED IN = "+(endProg-startProg)+"ms");
		
		//ATTENDI eventuali thread di marshalling che non hanno ancora terminato;
		executor.shutdown();
        while (!executor.isTerminated()) {}


	}
	
}
