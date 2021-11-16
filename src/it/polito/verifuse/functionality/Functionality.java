package it.polito.verifuse.functionality;

import java.util.HashSet;
import java.util.Map;

public class Functionality {
	
	private Map<String, HashSet<String>> fields_functionality 		= null;
	private HashSet<String> action_functionality					= null;
	private HashSet<String> referToVnfs								= null;
	private int id=this.hashCode();
	
	public Functionality(Map<String, HashSet<String>> fields_functionality, 
			HashSet<String> action_functionality,
			HashSet<String> referToVnfs) {
		this.fields_functionality = fields_functionality;
		this.action_functionality = action_functionality;
		this.referToVnfs=referToVnfs;
	}


	public int getId() {
		return id;
	}


	public HashSet<String> getReferToVnfs() {
		return referToVnfs;
	}


	public Map<String, HashSet<String>> getFields_functionality() {
		return fields_functionality;
	}


	public HashSet<String> getAction_functionality() {
		return action_functionality;
	}
	

	

}
