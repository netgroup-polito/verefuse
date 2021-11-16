package it.polito.verifuse.modules;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import it.polito.verifuse.functionality.BuildFunctionality;
import it.polito.verifuse.functionality.Functionality;
import it.polito.verifuse.jaxb.node.Node;
import it.polito.verifuse.jaxb.node.ObjectFactory;
import it.polito.verifuse.neo4j.client.Neo4jClient;
import it.polito.verifuse.utility.classes.ManifestVNF;
import it.polito.verifuse.utility.classes.Requirement;
import it.polito.verifuse.utility.consts.Consts;
import it.polito.verifuse.utility.exceptions.MyExceptions.*;
import it.polito.verifuse.utility.exceptions.MyExceptions.IllegalArgumentException;

public class RDF {
	private ConcurrentHashMap<String,HashSet<String>> mapToVnfSupport 		= new ConcurrentHashMap<>();
	private ConcurrentHashMap<String,Functionality> mapToFunctionality		= new ConcurrentHashMap<>();
	private Requirement requirement											= null;
	private ConcurrentHashMap<String, ManifestVNF> VNFs						= null; 
	private long timeExecution												= 0;
	private Map<String, Node> nodeOfFunctionality							= null;

	
	/**
	 * Constructor of RDF module 
	 * 
	 * @param Requirement object
	 * @param Map Key:name of Manifest Value: Manifest Object
	 */
	public RDF(Requirement requirement,ConcurrentHashMap<String, ManifestVNF> vNFs) {
		super();
		this.requirement = requirement;
		this.VNFs = vNFs;
	}
	
	/**
	 * Check if it possible find a Functionlity
	 * 
	 * 
	 * @return true if success , false otherwise
	 */
	public boolean findMappingFunctionality() throws IllegalArgumentException{
		if(this.requirement==null || this.VNFs==null)
			throw new IllegalArgumentException("Requirement or Catalog VNFs are null object");
		
		try{
			// manage constraint on DENY- ALLOW ACTION è implicito
			if(requirement.getMapActionToOrder().get(Consts.CONSTRAINT_DENY)==null){
				requirement.setHaveConstraintAllow(true);
			}
			
			// Distribute the work on threads - thread pool with size 3 - default value
			ExecutorService executor = Executors.newFixedThreadPool(Consts.NUMBERTHREAD);
			timeExecution=System.currentTimeMillis();
	        for (String nameFunction: VNFs.keySet()) {
	            Runnable worker = new BuildFunctionality(nameFunction,requirement,VNFs.get(nameFunction),mapToVnfSupport,mapToFunctionality);
	            executor.execute(worker);
	        }
	        executor.shutdown();
	        while (!executor.isTerminated()) {}
	        timeExecution=System.currentTimeMillis()-timeExecution;
	        
	        // if i find one or more functionality, can go to next step, otherwise no
	        if(mapToFunctionality.isEmpty())  
	        	return false;
	    	return true;
	        
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
	}

	public boolean isAllowConstraint(){
		return requirement.getMapActionToOrder().containsKey("ALLOW_TRAFFIC");
		
	}
	
	/**
	 * Return the time spent to build a set of functionality
	 * 
	 * 
	 * @return time in milliseconds 
	 */

	public long getTimeExectution() {
		return timeExecution;
	}

	/**
	 * Return a map where is it summaries 
	 * key:  	configuration of functionality 
	 * Value: 	Name vnfs that has the same configuration of functionality 
	 * 
	 * @return  ConcurrentHashMap
	 */

	public ConcurrentHashMap<String, HashSet<String>> getMapToVnfSupport() {
		return mapToVnfSupport;
	}

	/**
	 * Return a map where is it summaries 
	 * key:  	configuration of functionality 
	 * Value: 	functionality object
	 * 
	 * @return  ConcurrentHashMap
	 */

	public ConcurrentHashMap<String, Functionality> getMapToFunctionality() {
		return mapToFunctionality;
	}
	
	/**
	 * Print for each functionality which vnf support 
	 */
	
	public void printVnfsSupport(){
        mapToVnfSupport.forEach((k, v) -> System.out.println(k+"\t"+v));

	}
	
	/**
	 * Print information about functionality
	 */
	public void printFunctionality(){
        mapToFunctionality.values().forEach((k) -> 
        	System.out.println("ID= "+k.getId()+"\tFields= "+k.getFields_functionality()+"\tAction= "+k.getAction_functionality()+"\tVNFS= "+k.getReferToVnfs())
        );

	}
	
	/**
	 * Post node on neo4j db 
	 * 
	 * @param  Neo4jClient object
	 * @return true if success , false otherwise
	 */

	public boolean graphDBNeo4j(Neo4jClient client) {
		if(client==null)
			return false;
		try{
			// inserimento radice RDF -
			ObjectFactory of= new ObjectFactory();
			
			Node noderequirement=of.createNode();
			noderequirement.setName(String.valueOf("REQUIREMENT_"+this.requirement.getRequirementID()));
			noderequirement.getElement().add("no-field");
			client.performPost(noderequirement, "Requirement");
			
			Node root=of.createNode();
			root.setName("Root-RDF");
			root.getElement().add("no-field");
			client.performPost(root, "root");

			client.createRelationship(noderequirement.getName(), root.getName(),"Analisys_requirement_"+String.valueOf(this.requirement.getRequirementID()));
			
			nodeOfFunctionality= new HashMap<>();
			//Inserimento delle functionality ottenute
			for (Functionality f : mapToFunctionality.values()){
				Node node=of.createNode();
				node.setName("F-" + f.getId());
				node.getElement().addAll(f.getReferToVnfs());
				client.performPost(node, "Functionality");
				
				client.createRelationship(root.getName(), node.getName(), "mapping");
				nodeOfFunctionality.put(node.getName(), node);
			}
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Retrive all node posted on neo4j  
	 * 
	 * 
	 * @return Map where key: Name of node , Value: Node posted 
	 */

	public Map<String, Node> getNodeOfFunctionality() {
		return nodeOfFunctionality;
	}

	
	
}
