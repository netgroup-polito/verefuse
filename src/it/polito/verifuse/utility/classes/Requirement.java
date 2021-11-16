package it.polito.verifuse.utility.classes;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import it.polito.verifuse.jaxb.fields.Fields;
import it.polito.verifuse.jaxb.requirementslist.ActionsReq;
import it.polito.verifuse.jaxb.requirementslist.ActionsReq.FieldsParametric;

public class Requirement {

	private Map<String, HashSet<String>> fields_requirement 	= null;
	private Map<String, HashSet<String>> mapActionToFieldsP 	= null;
	private Map<String, BigInteger> mapActionToOrder 			= null;
	private Map<BigInteger,HashSet<String>> mapActionConcurrent	= null;
	private HashSet<String> actionsConcurrent					= null;
	private int RequirementID;
	private boolean mixSet=false;
	private boolean haveConstraintAllow=false;

	public Requirement(Map<String, HashSet<String>> fields_requirement, Map<String, HashSet<String>> mapActionToFieldsP,
			Map<String, BigInteger> mapActionToOrder, int requirementID , Map<BigInteger,HashSet<String>> mapActionConcurrent,
			HashSet<String> actionsConcurrent, boolean isMix) {
		super();
		this.fields_requirement = fields_requirement;
		this.mapActionToFieldsP = mapActionToFieldsP;
		this.mapActionToOrder = mapActionToOrder;
		this.RequirementID = requirementID;
		this.mapActionConcurrent=mapActionConcurrent;
		this.actionsConcurrent=actionsConcurrent;
		this.mixSet=isMix;
	}
	
	
	public boolean isHaveConstraintAllow() {
		return haveConstraintAllow;
	}


	public void setHaveConstraintAllow(boolean haveConstraintAllow) {
		this.haveConstraintAllow = haveConstraintAllow;
	}


	public boolean isMixSet() {
		return mixSet;
	}


	public HashSet<String> getActionsConcurrent() {
		return actionsConcurrent;
	}


	public Map<BigInteger, HashSet<String>> getMapActionConcurrent() {
		return mapActionConcurrent;
	}


	public Map<String, HashSet<String>> getFields_requirement() {
		return fields_requirement;
	}


	public Map<String, HashSet<String>> getMapActionToFieldsP() {
		return mapActionToFieldsP;
	}


	public Map<String, BigInteger> getMapActionToOrder() {
		return mapActionToOrder;
	}


	public int getRequirementID() {
		return RequirementID;
	}


	public void printNameFields() {
		fields_requirement.forEach((k,v)-> System.out.println("FIELD = " + k + "\tVALUE = "+ v));
	}
	public void printNameActions() {
		mapActionToOrder.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach((entry)-> System.out.println("Action in Position = "+ entry.getValue() + "\tis: "+entry.getKey()));
    }
}
	
