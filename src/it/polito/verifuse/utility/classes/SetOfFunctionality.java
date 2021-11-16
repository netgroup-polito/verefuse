package it.polito.verifuse.utility.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.text.AbstractDocument.BranchElement;
import javax.swing.text.Utilities;
import javax.validation.constraints.AssertTrue;

import org.apache.logging.log4j.core.util.Assert;

import com.google.common.collect.Multiset.Entry;
import com.sun.tools.xjc.addon.code_injector.Const;
import com.sun.xml.xsom.impl.scd.Iterators.Map;

import it.polito.verifuse.functionality.Functionality;
import it.polito.verifuse.utility.consts.Consts;

public class SetOfFunctionality {
	private ArrayList<ArrayList<Functionality>> setComplete	= new ArrayList<>();
	private ArrayList<ArrayList<Functionality>> setPartial	= new ArrayList<>();
	private ArrayList<Functionality> originalSet			= null;
	private int dim_action									= 0;
	private HashSet<String> bindFieldValue					= new HashSet<>();
	

	public SetOfFunctionality(ArrayList<Functionality> set,Requirement requirement) {
		this.originalSet = set;
		this.dim_action=requirement.getMapActionToOrder().size();
		prepareStructureForVerifyChain(requirement);
	}
	
	private void prepareStructureForVerifyChain(Requirement requirement){
		for(java.util.Map.Entry<String, HashSet<String>> entry :requirement.getFields_requirement().entrySet()){
			for(String s:entry.getValue()){
				if(!s.contentEquals(Consts.STAR))
					bindFieldValue.add(entry.getKey()+"="+s);
			}
		}
	}
	
	public ArrayList<ArrayList<Functionality>> getSetPartial() {
		return setPartial;
	}


	public ArrayList<ArrayList<Functionality>> getSetComplete() {
		return setComplete;
	}

	public ArrayList<ArrayList<Functionality>> getSolution(){
		ArrayList<ArrayList<Functionality>> sol= new ArrayList<ArrayList<Functionality>>();
		sol.addAll(setComplete);
		sol.addAll(setPartial);
		return sol;
	}

	public void printSolution(){
		int i =1;
		System.out.println(UtilsFunction.makeLine('-'));
		System.out.println("\t\t\t\t\t\tCOMPLETE");
		System.out.println(UtilsFunction.makeLine('-'));

		for(ArrayList<Functionality> list1 : setComplete) {
			System.out.print((i++) +"\t{");
			for(Functionality ch : list1) {
				System.out.print(ch.getId()+"\t" + ch.getReferToVnfs()+"\t");
			}
			System.out.print("}\n");
		}
		System.out.println(UtilsFunction.makeLine('-'));
		System.out.println("\t\t\t\t\t\tPARTIAL");
		System.out.println(UtilsFunction.makeLine('-'));
		
		for(ArrayList<Functionality> list1 : setPartial) {
			System.out.print((i++)+"\t{");
			for(Functionality ch : list1) {
				System.out.print(ch.getId()+"\t"+ ch.getReferToVnfs()+"\t");
			}
			System.out.print("}\n");
		}

	}
	
	private String satisfaction_v2(ArrayList<Functionality> newSubset){
		HashSet<String> hsaction 				= new HashSet<>();
		HashSet<String> fieldOverall			= new HashSet<String>();
		
		boolean setActionIsChanging	=true;
		boolean setValueIsChanging	=true;
		
		for(Functionality f : newSubset){

			setActionIsChanging=hsaction.addAll(f.getAction_functionality());
			
			int sizebeforevalue=fieldOverall.size();
			for(java.util.Map.Entry<String, HashSet<String>> entry : f.getFields_functionality().entrySet()){
				for(String s:entry.getValue()){
					if(!s.contentEquals(Consts.STAR))
						fieldOverall.add(entry.getKey()+"="+s);
				}
			}
			setValueIsChanging=sizebeforevalue<fieldOverall.size()?true:false;
			if(setActionIsChanging==false  && setValueIsChanging==false ){
				return new String();
			}

		}
		if(hsaction.size()==dim_action && fieldOverall.size()==bindFieldValue.size() ){
			return Consts.COMPLETE;
		}else if(hsaction.size()==dim_action){
			return Consts.PARTIAL;
		}
		return new String();
	}

	public ArrayList <ArrayList<Functionality>> findPowerSet (int pos)
	{
	    if (originalSet == null)
	        return null;
	 
	    if (pos == originalSet.size())
	    {
	        ArrayList<ArrayList<Functionality>> powerSet = new ArrayList <ArrayList<Functionality>>();
	        ArrayList<Functionality> subset = new ArrayList<Functionality>();
	        powerSet.add(subset);
	        return powerSet; 					
	        // return powerset with 1 element as [ [] ]
	    }
	 
	    ArrayList<ArrayList<Functionality>> subPowerSet = findPowerSet(pos+1);
	    
	    Functionality currentVal = originalSet.get(pos);
	    
	    //CHECK SE GIA L'ELEMENTO E' OTTIMO - riducendo lo spazio di esplorazione
	    
	    ArrayList<Functionality> arl= new ArrayList<Functionality>();
	    arl.add(currentVal);
	    String checkCurrent=checkGradeSatisfability_v2(arl); 
	    
	    if(checkCurrent.contentEquals(Consts.COMPLETE)){
		    //System.out.println("LUCKY---"+checkCurrent);
		    setComplete.add(arl);
	    	return subPowerSet;
	    }
	    
	    // copy each subset into a new one, and add current element to it
	    ArrayList<ArrayList<Functionality>> subPowerSet2 = new ArrayList<ArrayList<Functionality>> ();	    
	    for (ArrayList <Functionality> subset : subPowerSet)
	    {
	        ArrayList <Functionality> subset2 = new ArrayList<>(subset);
	        subset2.add(currentVal);
	        
	        /***
	         * INIZIO
	         */
	        if(!setComplete.stream().anyMatch(k-> k.containsAll(subset2)||subset2.containsAll(k) )){  // con contiene elementi completi che non nesecessitatno di ulteriori f
	        	String check=checkGradeSatisfability_v2(subset2);
	        	//System.out.println("RESULT CHECK="+check);

	        	if(check.contentEquals(Consts.COMPLETE)){
	        		setComplete.add(subset2);
	        		
	        	}else if(check.contentEquals(Consts.PARTIAL)){
	        		setPartial.add(subset2);
	        		subPowerSet2.add(subset2);
	        	}else 
	        		subPowerSet2.add(subset2);
	        	
	        }
	        /**
	         * FINE
	         */
	        
	    }
	   
	    // merge the two sub-powersets into one
	    subPowerSet.addAll(subPowerSet2);
	    return subPowerSet;
	}
	
	private String checkGradeSatisfability_v2(ArrayList<Functionality> lf){
		
		String r=satisfaction_v2(lf);
		if(r.contentEquals(Consts.COMPLETE))
			return Consts.COMPLETE;
		if(r.contentEquals(Consts.PARTIAL))
			return Consts.PARTIAL;
		return new String();
	}

}


