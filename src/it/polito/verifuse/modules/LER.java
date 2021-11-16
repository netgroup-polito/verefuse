package it.polito.verifuse.modules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import it.polito.verifuse.functionality.ChainOfFunctionality;
import it.polito.verifuse.functionality.ChainingProcess;
import it.polito.verifuse.functionality.Functionality;
import it.polito.verifuse.functionality.SolverChain;
import it.polito.verifuse.jaxb.node.Node;
import it.polito.verifuse.jaxb.node.ObjectFactory;
import it.polito.verifuse.neo4j.client.Neo4jClient;
import it.polito.verifuse.utility.classes.Requirement;
import it.polito.verifuse.utility.classes.SetOfFunctionality;
import it.polito.verifuse.utility.consts.Consts;
import it.polito.verifuse.utility.exceptions.MyExceptions.*;

public class LER {
	private ArrayList<Functionality> setFunctionality 		= null;
	private Requirement requirement							= null;
	private SetOfFunctionality sf							= null;
	private long time										= 0;
	private ArrayList<ArrayList<Functionality>> lf_not_sol	= null;
	private ArrayList<ArrayList<Functionality>> lf_sol		= null;
	private ConcurrentHashMap<String,ArrayList<ChainOfFunctionality>> overallChain = new ConcurrentHashMap<String, ArrayList<ChainOfFunctionality>>();
	private ConcurrentHashMap<String,String> checkDuplicate = new ConcurrentHashMap<>();
	private HashSet<String> bindFieldValue					= new HashSet<>();
	private HashMap<String,String> mapSolSatisfiability		= new HashMap<>();

	/**
	 * Constructor of LER module 
	 * 
	 * @param ArrayList of Functionality discovered by RDF module
	 * @param Requirement that is analyzed
	 */

	public LER(ArrayList<Functionality> setFunctionality, Requirement requirement) {
		
		this.setFunctionality = setFunctionality;
		this.requirement = requirement;
	}
	
	
	public ConcurrentHashMap<String, ArrayList<ChainOfFunctionality>> getOverallChain() {
		return overallChain;
	}


	/**
	 * Time spent during the execution
	 * 
	 * @return time expressed in milliseconds
	 */

	public long getTime() {
		return time;
	}
	
	/**
	 * Start the execution of solver - Gurobi solver is activated 
	 * 
	 * @return true if success , false otherwise
	 */

	public boolean searchForChainGivenFunctionality() throws FindChainFunctionalityException{
		if(this.requirement==null)
			return false;
		if(this.setFunctionality==null )
			return false;

		try{
			this.time=System.currentTimeMillis();
        	String baseName="Requirement_"+this.requirement.getRequirementID()+":";
            SolverChain solveChain = new SolverChain(this.setFunctionality,this.requirement,overallChain,baseName);
            solveChain.run();
            this.time=System.currentTimeMillis()-this.time;

            if(!overallChain.isEmpty()){
        		prepareStructureForVerifyChain();
            	for(Entry<String , ArrayList<ChainOfFunctionality>> entry : overallChain.entrySet()){
            		String sat= verifyChain(entry.getValue());
            		mapSolSatisfiability.put(entry.getKey(), sat);
            	}
            }
	        return true;
	        
		}catch (Exception e) {
			e.printStackTrace();
			throw new FindChainFunctionalityException("Something went wrong during the chaining process");
		}
	}
	
	public HashMap<String, String> getMapSolSatisfiability() {
		return mapSolSatisfiability;
	}


	private  String verifyChain(ArrayList<ChainOfFunctionality> set){
		HashSet<String> bindFieldValueChain= new HashSet<>();		
		set.stream().forEach(f-> {
			for(Entry<String,HashSet<String>> entry: f.getFunction().getFields_functionality().entrySet()){
				for(String s : entry.getValue())
					if(!s.contains(Consts.STAR) && !s.contains(Consts.NOT_CONF_MAKE_DEC) && !s.contains(Consts.NOT_CONF_NOT_DEC))
						bindFieldValueChain.add(entry.getKey()+"="+s);
			}
		});
		return bindFieldValue.equals(bindFieldValueChain)?Consts.COMPLETE:Consts.PARTIAL;
	}

	
	private void prepareStructureForVerifyChain(){
		for(java.util.Map.Entry<String, HashSet<String>> entry :this.requirement.getFields_requirement().entrySet()){
			for(String s:entry.getValue()){
				if(!s.contentEquals(Consts.STAR))
					bindFieldValue.add(entry.getKey()+"="+s);
			}
		}
	}
	
	/**
	 * Print all the solution produced by the searchForChainGivenFunctionality() method
	 */

	public void printAllSolutionChain(){
		this.getOverallChain().entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach((entry)->{
			System.out.println(entry.getKey()+"\t"+" with SAT= "+mapSolSatisfiability.get(entry.getKey()));
			for(ChainOfFunctionality cf: entry.getValue()){
				System.out.println("\tFUNCTION_ID="+cf.getFunction().getId()+"\t"+cf.getApplyActionSet());
			}
		});
	}
	
	/**
	 * Print all the solution produced by the searchForChainGivenFunctionality() method
	 * 
	 * @param numberChain int number of the chain
	 */

	public void printAllSolutionChain(int numberChain){
		if(numberChain<=0)
			return;
		this.getOverallChain().entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach((entry)->{
			if(entry.getKey().contains("SOL_"+numberChain)){
				System.out.println(entry.getKey()+"\t");
				for(ChainOfFunctionality cf: entry.getValue()){
					System.out.println("\t"+cf.getFunction().getId()+"\t"+cf.getApplyActionSet());
				}
			}		
		});
	}

	/**
	 * Post node on neo4j db 
	 * 
	 * @param  nodeFun Map whit key: name node and value: Node Object 
	 * @param  client object for connecting to neo4jdb
	 * @return true if success , false otherwise
	 */
	
	public boolean graphDBNeo4j(Map<String, Node> nodeFun,Neo4jClient client) {
		try{

			if(client==null)
				return false;
			// inserimento radice LER -
			
			ObjectFactory of= new ObjectFactory();
			Node root=of.createNode();
			root.setName("Root-LER");
			root.getElement().add("no-field");
			client.performPost(root, "root");
			
			if(nodeFun!=null){
				for (Entry<String, Node> f : nodeFun.entrySet()){					
					client.createRelationship(f.getKey(), root.getName(), "combined");
				}	
			}
			
			//Inserimento delle functionality ottenute
			for (Entry<String, ArrayList<ChainOfFunctionality>> f : overallChain.entrySet()){

				String[] element= f.getKey().split(":");
				Node nodechain=of.createNode();
				nodechain.setName(element[0]);
				nodechain.getElement().add("no-field");
				
				if(!client.isPosted(nodechain.getName())){
					client.performPost(nodechain, "HeadChain");
					client.createRelationship(root.getName(), nodechain.getName(), "ProduceChain");
				}
				int i=0;
				Node before=null;
				for(ChainOfFunctionality cf : f.getValue()){
					if(i==0)
						before=nodechain;
					i++;
					Node nodeFunction = of.createNode();
					nodeFunction.setName(String.valueOf("F:"+cf.getFunction().getId()));
					nodeFunction.getElement().addAll(cf.getFunction().getReferToVnfs());
					client.performPost(nodeFunction, "Functionality");
					client.createRelationship(before.getName(), nodeFunction.getName(), f.getKey());
					before=nodeFunction;
				}
				
			}
			
			client.close();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
