package it.polito.verifuse.functionality;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import gurobi.GRB;
import gurobi.GRBEnv;
import gurobi.GRBException;
import gurobi.GRBLinExpr;
import gurobi.GRBModel;
import gurobi.GRBVar;
import it.polito.verifuse.utility.classes.Requirement;
import it.polito.verifuse.utility.exceptions.MyExceptions.SolverGurobiException;

public class SolverChain {
	private ArrayList<Functionality> chainBase 										= null;
	private Requirement requirement 												= null;
	private ConcurrentHashMap<String,ArrayList<ChainOfFunctionality>> accumulator	= null;
	private String baseID															= null;
	
	public SolverChain(ArrayList<Functionality> chain, 
			Requirement SingleRequirement,
			ConcurrentHashMap<String,ArrayList<ChainOfFunctionality>> overallChain,
			String baseID) {
		this.chainBase = chain;
		this.requirement = SingleRequirement;
		this.accumulator=overallChain;
		this.baseID=baseID;
	}

	public void run() throws SolverGurobiException {
		if(this.chainBase==null || this.requirement==null || this.accumulator==null || this.baseID==null)
			return ;
		try {
			searchChain();
		} catch (SolverGurobiException e) {
			e.printStackTrace();
			throw new SolverGurobiException("Exception Solver Gurobi raised!");
		}
	}

	public void searchChain() throws SolverGurobiException{
		
		try {
			
			// Model
			
			GRBEnv env = new GRBEnv();
			env.set(GRB.IntParam.OutputFlag, 0);
			env.set(GRB.IntParam.LogToConsole, 0);
			env.set(GRB.IntParam.Threads, 0); 					// 0 = automatic number thread to perform the calculation
			GRBModel model = new GRBModel(env);
			model.set(GRB.StringAttr.ModelName, "assignment");
			model.set(GRB.IntParam.PoolSolutions, Integer.MAX_VALUE);    
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
			
			boolean isPassed=false;
			// prevedere un ordinamento già a priori
			for(String entry : sortedMapActionRequirement.keySet()){
				for(Functionality f: chainBase){
		    		if(f.getAction_functionality().contains(entry)){
		    			/** add for manage the possibility to find only a subset of field parametric
		    			 * ACTION;FIELD_PARAM:FUCNTIONALITY_ID
		    			 */
		    			if(requirement.getMapActionToFieldsP().get(entry)!=null && copyOfActionConcurrent.stream().noneMatch(k-> k.contains(entry))){
		    				isPassed=true;
		    				HashSet<String> hsr= new HashSet<>(requirement.getMapActionToFieldsP().get(entry));
		    				Set<String> hsf=new HashSet<>(f.getFields_functionality().keySet());
		    				hsf.retainAll(hsr);
		    				for ( String s : hsf) {
		    					String key=entry+";"+s+"@"+f.getId();
				    			linkActionFunctinality.put(key,f);
				    			try {
									GRBVar var= model.addVar(0.0, 1.0, 0.0, GRB.BINARY, key);
									mapGurobiObjFunction.put(key, var);
									mapGurobiObjRevers.put(var, key);
					    			mapGurobi.computeIfPresent(entry+";"+s, (k,value)-> {
					    				value.add(var);
					    				return value;
					    			} );
					    			mapGurobi.putIfAbsent(entry+";"+s, new ArrayList<>(Arrays.asList(var)));
		
								} catch (GRBException e) {
									e.printStackTrace();
								}
		    				}
		    			}else{
			    		/** manage when we not have the dependecies from paramterici field
			    		 * ACTION:FUCNTIONALITY_ID
		    			*/
			    			String key=entry+"@"+f.getId();
			    			linkActionFunctinality.put(key,f);
			    			try {
								GRBVar var= model.addVar(0.0, 1.0, 0.0, GRB.BINARY, key);
								mapGurobiObjFunction.put(key, var);
								mapGurobiObjRevers.put(var, key);
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
			}

			model.update();

			/**
			 * settaggio di constraint generici , la presenza di una azione concorrente implica la presenza della sua concorrente e viceversa
			 * se a1 e a2 sono conocorrenti o li prendo insieme o non li prendo affatto
			 * r = and { A1:FID1 A2:FID1 }  OK 
			 *  r = and { A1:FID2 A2:FID2 }  OK
			 *   r = and { A1:FID1 A2:FID2 }  NO
			 */
			if(!copyOfActionConcurrent.isEmpty()){
				for(Functionality f: chainBase){
					for(HashSet<String> entry : copyOfActionConcurrent){
			    		if(f.getAction_functionality().containsAll(entry)){
			    			ArrayList<GRBVar> l_var= new ArrayList<>();
			    			for(String s: entry){
			    				String key=s+"@"+f.getId();
				    			l_var.add(mapGurobiObjFunction.get(key));
			    			}
			    			for(GRBVar var :l_var){
			    				model.addGenConstrAnd (var, l_var.toArray( new GRBVar[l_var.size()]), "AndConstr");
			    			}
			    		}else{ 
			    			HashSet<String> result = new HashSet<>(entry);
			    			result.retainAll(f.getAction_functionality());
			    			for(String s: result){		    				
			    				GRBVar r=mapGurobiObjFunction.get(s+"@"+f.getId());
			    				r.set(GRB.DoubleAttr.UB, 0);
			    			} 
			    		}
	
					}
		    	}
			}

			model.update();
			
			 
			/**
			 * Constraint generici -
			 * Ogni azione pur soddisfabile da piu funzionalità puo essere presa una volta sola 
			 * A1 - (F1 F2 F3) -> quando viene viene selezionata l'azione A1 puo essere associata solo ad una delle tre 
			 * Non posso avere A1-F1 e A1-F2 
			 */

			for(Entry<String, List<GRBVar>> entry : mapGurobi.entrySet()){
				List<GRBVar> lv=entry.getValue();
				GRBLinExpr lhs = new GRBLinExpr();
				for(GRBVar v: lv){
					lhs.addTerm(1.0, v);	
				}
				model.addConstr(lhs, GRB.EQUAL, 1, "Condition_"+entry.getKey());
			}			

			/**
			 * Constraint generici -
			 * Il numero massimo di azione che devo andare a ottenere nella soluzione è pari al numero di azioni che il requisito impone
			 * Se il requisito impone 5 requisiti , nelle mie soluzione devo avere esattamente 5 azioni, non una di più non una di meno.
			 * Facendo attenzione nel momento in cui abbiamo azione che dipendo dai campi , li il numero aumenta di un numero pari alla somma dei field parametrici
			 * 
			 */

			GRBLinExpr obj = new GRBLinExpr();
			for(GRBVar entry : mapGurobiObjRevers.keySet()){
				obj.addTerm(1.0, entry);	
			}
			
			int dimFieldParm=0;
			if(isPassed)	
				dimFieldParm=requirement.getMapActionToFieldsP().values().stream().map(k-> k.size()).mapToInt(Integer::intValue).sum()-requirement.getMapActionToFieldsP().size();			
			model.addConstr(obj, GRB.EQUAL, sortedMapActionRequirement.size()+dimFieldParm, "Condition_max_element");									
		
			/**
			 * FINE
			 */
			// Optimize - Solver start to find a solution to LP problem
			model.optimize();
			int status = model.get(GRB.IntAttr.Status);

			if (status != GRB.Status.OPTIMAL) {
				if (status == GRB.Status.INF_OR_UNBD ) {
					System.out.println("Optimization was stopped with status inf or unbounded");
					return;
				}
				if (status == GRB.Status.INFEASIBLE    ) {
					System.out.println("Optimization was stopped with status infeasible");
					return;
				}
				if (status == GRB.Status.UNBOUNDED) {
					System.out.println("The model cannot be solved because it is unbounded");
					return;
				}
				return; 
			}

			int nSolutions = model.get(GRB.IntAttr.SolCount);
			// solutions found during the optimization
			for (int e = 0; e < nSolutions; e++) {
				model.set(GRB.IntParam.SolutionNumber, e);
				boolean isMixSet=requirement.isMixSet();
				boolean changeSet=false;
				ArrayList<ChainOfFunctionality> arraychain = new ArrayList<>();
				for(GRBVar v :mapGurobiObjFunction.values()){

					if(v.get(GRB.DoubleAttr.Xn)!=0){
						
						String att_name=v.get(GRB.StringAttr.VarName);
						
						if(isMixSet){
							// Ordinamenti misti - parzialmente ordinato
							String splitcorrect_name= splitAction_Field_IdFunctionality(mapGurobiObjRevers.get(v));
							
							if(arraychain.isEmpty()){
								ChainOfFunctionality cf = new ChainOfFunctionality(linkActionFunctinality.get(att_name));
								cf.getApplyActionSet().add(mapGurobiObjRevers.get(v));
								arraychain.add(cf);
							}else{
								if(sortedMapActionRequirement.get(splitcorrect_name).compareTo(BigInteger.ZERO)<0){
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
							//System.out.println(sortedMapActionRequirement);

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
				if(isMixSet){  // the set is composed of mixed set of partially ordered and not 
						
					String part="-SET_";
		        	ArrayList<ChainOfFunctionality> topermute= arraychain
		        			.stream()
		        			.filter(f -> sortedMapActionRequirement.get(splitAction_Field_IdFunctionality(f.getApplyActionSet().get(0))).compareTo(BigInteger.ZERO)<=0)
		        			.collect(Collectors.toCollection(ArrayList::new));
		        			        	
		        	ArrayList<ChainOfFunctionality> notpermute= arraychain
		        			.stream()
		        			.filter(f -> sortedMapActionRequirement.get(splitAction_Field_IdFunctionality(f.getApplyActionSet().get(0))).compareTo(BigInteger.ZERO)>0)
		        			.collect(Collectors.toCollection(ArrayList::new));

		        	// add functionality dummy - it represent the block action ordered
		        	if(!notpermute.isEmpty())
		        		topermute.add(new ChainOfFunctionality(null));
		        	ArrayList<ArrayList<ChainOfFunctionality>> acc = new ArrayList<>();
		        	

	        		permute(topermute, 0, topermute.size()-1, acc);
	        		int num=0;
	        		for(ArrayList<ChainOfFunctionality> al : acc){
	        			//al.forEach(k -> System.out.println(baseID+relativename+part+" "+k.getApplyActionSet()) );
	        			num++;
	        			ArrayList<ChainOfFunctionality> new_arraychain= new ArrayList<>();
	        			for(ChainOfFunctionality cf : al){
	        				if(cf.getApplyActionSet().isEmpty()) 
	        					new_arraychain.addAll(notpermute);
	        				else
	        					new_arraychain.add(cf);
	        			}
	        			accumulator.put(baseID+relativename+part+num, new_arraychain);
	        		}
		        	
				}else{
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
	private String splitAction_Field_IdFunctionality(String s){
		return s.split("@")[0].split(";")[0].toString();
	}
}
