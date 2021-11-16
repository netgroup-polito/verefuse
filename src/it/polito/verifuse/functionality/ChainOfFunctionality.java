package it.polito.verifuse.functionality;

import java.util.ArrayList;
import java.util.HashSet;

public class ChainOfFunctionality {
	private Functionality function			= null;
	private ArrayList<String> applyActionSet	= null;
	
	
	public ChainOfFunctionality(Functionality function) {
		
		this.function = function;
		this.applyActionSet= new ArrayList<>();
	}


	public Functionality getFunction() {
		return function;
	}


	public ArrayList<String> getApplyActionSet() {
		return applyActionSet;
	}
	
	
	

}
