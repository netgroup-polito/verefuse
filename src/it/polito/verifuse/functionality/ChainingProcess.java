package it.polito.verifuse.functionality;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import gurobi.GRB;
import gurobi.GRBEnv;
import gurobi.GRBException;
import gurobi.GRBLinExpr;
import gurobi.GRBModel;
import gurobi.GRBVar;
import it.polito.verifuse.utility.classes.Requirement;
import it.polito.verifuse.utility.classes.UtilsFunction;
import it.polito.verifuse.utility.exceptions.MyExceptions;
import it.polito.verifuse.utility.exceptions.MyExceptions.SolverGurobiException;

public class ChainingProcess implements Runnable{
	private ArrayList<Functionality> chainBase 										= null;
	private Requirement requirement 												= null;
	private ConcurrentHashMap<String,ArrayList<ChainOfFunctionality>> accumulator	= null;
	private String baseID															= null;
	private ConcurrentHashMap<String,String> checkDuplicate 						= null;
	
	public ChainingProcess(ArrayList<Functionality> chain, Requirement SingleRequirement,
			ConcurrentHashMap<String,ArrayList<ChainOfFunctionality>> overallChain, String baseID,
			ConcurrentHashMap<String,String> checkDuplicate) {
		this.chainBase = chain;
		this.requirement = SingleRequirement;
		this.accumulator=overallChain;
		this.baseID=baseID;
		this.checkDuplicate=checkDuplicate;
	}

	@Override
	public void run() {
		if(this.chainBase==null || this.requirement==null || this.accumulator==null || this.baseID==null)
			return;
		//System.out.println("Thread sganciato  " + Thread.currentThread());
		try {
			searchChain();
		} catch (SolverGurobiException e) {
			e.printStackTrace();
		}
		//System.out.println("Thread terminato  " + Thread.currentThread());
	}
	
	
	public void searchChain() throws SolverGurobiException{
		
		try {
			
			// Model
			GRBEnv env = new GRBEnv();
			env.set(GRB.IntParam.OutputFlag, 0);
			env.set(GRB.StringParam.LogFile, "GurobiLog.txt");
			GRBModel model = new GRBModel(env);
			model.set(GRB.StringAttr.ModelName, "assignment");
			model.set(GRB.IntParam.PoolSolutions, 4096);  // parametro da inserire
			model.set(GRB.IntParam.PoolSearchMode, 2);

			
			/**
			 * INIZIO
			 */
			LinkedHashMap<String,BigInteger> sortedMapActionRequirement = requirement.getMapActionToOrder()
			        .entrySet()
			        .stream()
			        .sorted(Map.Entry.comparingByValue())
			        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,LinkedHashMap::new)); 
			
			List<HashSet<String>> copyOfActionConcurrent= requirement.getMapActionConcurrent()
					.entrySet()
					.stream()
					.map(k-> k.getValue())
					.collect(Collectors.toList());
					
			// Sets of possible data -- ordine importante!
			LinkedHashMap<String, Functionality> 	linkActionFunctinality 	= new LinkedHashMap<>();
			LinkedHashMap<String, List<GRBVar>> 	mapGurobi 				= new LinkedHashMap<>();
			LinkedHashMap<String, GRBVar> 			mapGurobiObjFunction 	= new LinkedHashMap<>();
			LinkedHashMap<GRBVar, String> 			mapGurobiObjRevers		= new LinkedHashMap<>();
			
			
			
			// prevedere un ordinamento già a priori
			for(String entry : sortedMapActionRequirement.keySet()){
				for(Functionality f: chainBase){
		    		if(f.getAction_functionality().contains(entry)){
		    			String key=entry+":"+f.getId();
		    			linkActionFunctinality.put(key,f);
		    			try {
							GRBVar var= model.addVar(0.0, 1.0, 0.0, GRB.BINARY, key);
							mapGurobiObjFunction.put(key, var);
							mapGurobiObjRevers.put(var, entry);
			    			mapGurobi.computeIfPresent(entry, (k,value)-> {
			    				value.add(var);
			    				return value;
			    			} );
			    			mapGurobi.putIfAbsent(entry, new ArrayList<>(Arrays.asList(var)));

						} catch (GRBException e) {
							e.printStackTrace();
						}
		    		}
		    	}
			}
			
			model.update();
			
			// settaggio di constraint generici , la presenza di una azione concorrente implica la presenza della sua concorrente e viceversa
			// se a1 e a2 sono conocorrenti o li prendo insieme o non li prendo affatto
			if(!copyOfActionConcurrent.isEmpty()){
				for(Functionality f: chainBase){
					for(HashSet<String> entry : copyOfActionConcurrent){
			    		if(f.getAction_functionality().containsAll(entry)){
			    			ArrayList<GRBVar> l_var= new ArrayList<>();
			    			for(String s: entry){
			    				String key=s+":"+f.getId();
				    			l_var.add(mapGurobiObjFunction.get(key));
			    			}
			    			for(GRBVar var :l_var){
			    				model.addGenConstrAnd (var, l_var.toArray( new GRBVar[l_var.size()]), "AndConstr");
			    			}
			    		}else{ 
			    			HashSet<String> result = new HashSet<>(entry);
			    			result.retainAll(f.getAction_functionality());
			    			for(String s: result){		    				
			    				GRBVar r=mapGurobiObjFunction.get(s+":"+f.getId());
			    				r.set(GRB.DoubleAttr.UB, 0);
			    			} 
			    		}
	
					}
		    	}
			}

			model.update();
			// ADD constraint  
			for(Entry<String, List<GRBVar>> entry : mapGurobi.entrySet()){
				List<GRBVar> lv=entry.getValue();
				GRBLinExpr lhs = new GRBLinExpr();
				for(GRBVar v: lv){
					lhs.addTerm(1.0, v);	
				}
				model.addConstr(lhs, GRB.EQUAL, 1, "Condition_"+entry.getKey());
			}			
			
			GRBLinExpr obj = new GRBLinExpr();
			for(Entry<String, GRBVar> entry : mapGurobiObjFunction.entrySet()){
				obj.addTerm(1.0, entry.getValue());	
			}
			model.setObjective(obj, GRB.MAXIMIZE);

									
			/**
			 * FINE
			 */
			// Optimize
			model.optimize();
			int status = model.get(GRB.IntAttr.Status);

			if (status != GRB.Status.OPTIMAL) {
				System.out.println("RETURN STATUS "+status);
				if (status == GRB.Status.INF_OR_UNBD && status == GRB.Status.INFEASIBLE    ) {
					System.out.println("Optimization was stopped with status " + status);
					return;
				}
				if (status == GRB.Status.UNBOUNDED) {
					System.out.println("The model cannot be solved because it is unbounded");
					return;
				}
				return; 
			}
			
			int nSolutions = model.get(GRB.IntAttr.SolCount);
			//System.out.println("Number of solutions found: " + nSolutions+"    "+model.get(GRB.DoubleAttr.Runtime));

			// solutions found during the optimization
			for (int e = 0; e < nSolutions; e++) {
				model.set(GRB.IntParam.SolutionNumber, e);
				//System.out.println(model.get(GRB.DoubleAttr.PoolObjVal) +  " NUMBER SOL: " + e);
				boolean isMixSet=requirement.isMixSet();
				boolean changeSet=false;
				ArrayList<ChainOfFunctionality> arraychain = new ArrayList<>();
				
				for(GRBVar v :mapGurobiObjFunction.values()){
					if(v.get(GRB.DoubleAttr.Xn)!=0){
						//System.out.print(y[w].get(GRB.StringAttr.VarName)+ "= " +y[w].get(GRB.DoubleAttr.Xn)+" - ");
						//System.out.print(v.get(GRB.StringAttr.VarName)+"\t");
						String att_name=v.get(GRB.StringAttr.VarName);
						if(isMixSet){
							// Ordinamenti misti - parzialmente ordinato
							
							if(arraychain.isEmpty()){
								ChainOfFunctionality cf = new ChainOfFunctionality(linkActionFunctinality.get(att_name));
								cf.getApplyActionSet().add(mapGurobiObjRevers.get(v));
								arraychain.add(cf);
							}else{
								if(sortedMapActionRequirement.get(mapGurobiObjRevers.get(v)).compareTo(BigInteger.ZERO)<0){
									if(arraychain.get(arraychain.size()-1).getFunction().getId()==linkActionFunctinality.get(att_name).getId() ){
										arraychain.get(arraychain.size()-1).getApplyActionSet().add(mapGurobiObjRevers.get(v));
									}else{
										ChainOfFunctionality cf = new ChainOfFunctionality(linkActionFunctinality.get(att_name));
										cf.getApplyActionSet().add(mapGurobiObjRevers.get(v));
										arraychain.add(cf);
									}
					
								}else{
									if(!changeSet){
										changeSet=true;
										ChainOfFunctionality cf = new ChainOfFunctionality(linkActionFunctinality.get(att_name));
										cf.getApplyActionSet().add(mapGurobiObjRevers.get(v));
										arraychain.add(cf);
									}
									else{
										if(arraychain.get(arraychain.size()-1).getFunction().getId()==linkActionFunctinality.get(att_name).getId() && changeSet ){
											arraychain.get(arraychain.size()-1).getApplyActionSet().add(mapGurobiObjRevers.get(v));
										}else{
											ChainOfFunctionality cf = new ChainOfFunctionality(linkActionFunctinality.get(att_name));
											cf.getApplyActionSet().add(mapGurobiObjRevers.get(v));
											arraychain.add(cf);
										}
									}
								}
							}
						}else{							
							// Aggregation function action on the same functionality // Tutto ordinato
							if(arraychain.isEmpty()){
								ChainOfFunctionality cf = new ChainOfFunctionality(linkActionFunctinality.get(att_name));
								cf.getApplyActionSet().add(mapGurobiObjRevers.get(v));
								arraychain.add(cf);
							}else{
								if(arraychain.get(arraychain.size()-1).getFunction().getId()==linkActionFunctinality.get(att_name).getId() ){
									arraychain.get(arraychain.size()-1).getApplyActionSet().add(mapGurobiObjRevers.get(v));
								}else{
									ChainOfFunctionality cf = new ChainOfFunctionality(linkActionFunctinality.get(att_name));
									cf.getApplyActionSet().add(mapGurobiObjRevers.get(v));
									arraychain.add(cf);
								}
							}
						}
					}

				}
				
				String relativename="SOL_"+e;
				if(isMixSet){   				// the set is composed of mixed set of partially ordered and not 
					String part="-SET_";
		        	ArrayList<ChainOfFunctionality> topermute= arraychain
		        			.stream()
		        			.filter(f -> sortedMapActionRequirement.get(f.getApplyActionSet().get(0)).compareTo(BigInteger.ZERO)<=0)
		        			.collect(Collectors.toCollection(ArrayList::new));
		        	
		        	ArrayList<ChainOfFunctionality> notpermute= arraychain
		        			.stream()
		        			.filter(f -> sortedMapActionRequirement.get(f.getApplyActionSet().get(0)).compareTo(BigInteger.ZERO)>0)
		        			.collect(Collectors.toCollection(ArrayList::new));
		        	
		        	// add functionality dummy - it represent the block action ordered
		        	topermute.add(new ChainOfFunctionality(null));
		        	ArrayList<ArrayList<ChainOfFunctionality>> acc = new ArrayList<>();
		        	
		        	permute(topermute, 0, topermute.size()-1, acc);
		        	int num=0;
		        	for(ArrayList<ChainOfFunctionality> al : acc){
		        		//al.forEach(k -> System.out.println(baseID+relativename+part+" "+k.getApplyActionSet()) );
		        		num++;
			        	ArrayList<ChainOfFunctionality> new_arraychain= new ArrayList<>();
		        		for(ChainOfFunctionality cf : al){
		        			if(cf.getApplyActionSet().isEmpty()){ 
		        				new_arraychain.addAll(notpermute);
		        			}else
		        				new_arraychain.add(cf);
		        		}
		        		accumulator.put(baseID+relativename+part+num, new_arraychain);
		        		
		        	}
		        	
				}else{
					//accumulator.put(baseID+relativename, arraychain);
					
					// modifica
					String serial=serializeChain(arraychain);
					if(checkDuplicate.put(serial, baseID+relativename)==null)
						accumulator.put(baseID+relativename, arraychain);
					
				}
			}
			
			// Dispose of model and environment
			model.dispose();
			env.dispose();

		} catch (GRBException e) {
			System.out.println("Error code: " + e.getErrorCode() + ". " + e.getMessage());
			throw new SolverGurobiException("Exception during the execution of gurobi tool");
		}
		catch (Exception e) {
			throw new SolverGurobiException("Exception during the execution of gurobi tool");
		}

	}

	public void swap(ArrayList<ChainOfFunctionality> a, int l, int r) {
		ChainOfFunctionality temp = a.get(l);
		a.set(l, a.get(r));
		a.set(r, temp);
	}

	public void permute(ArrayList<ChainOfFunctionality> a, int l, int r,ArrayList<ArrayList<ChainOfFunctionality>> acc) {
		if (l==r){
			acc.add(new ArrayList<>(a));
		}
		else {
			for (int i = l; i <= r ; i++) {
				swap(a, l, i);
				permute(a, l + 1, r,acc);
				swap(a, l, i); // backtrack
			}
		}
	}
	
	private String serializeChain(ArrayList<ChainOfFunctionality> chain){
		String ret="";
		for(ChainOfFunctionality c: chain){
			ret=ret+c.getFunction().getId()+":"+c.getApplyActionSet().toString()+":";
		}
		return ret;
	}

}
