package it.polito.verifuse.utility.classes;


import java.util.HashSet;
import java.util.Map;


import it.polito.verifuse.jaxb.manifestvnfs.GeneralInfo;
import it.polito.verifuse.jaxb.manifestvnfs.HardwareInfo;
import it.polito.verifuse.jaxb.manifestvnfs.SoftwareInfo;

public class ManifestVNF {
	private String name=null;
	private Map<String, HashSet<String>> manifest_field		=null;
	private HashSet<String> manifest_action					=null;
	private String description								=null;
	private GeneralInfo generalInfo							=null;
	private SoftwareInfo softwareInfo						=null;
	private HardwareInfo hardwareInfo						=null;
	private Map<String, String> fieldToConfig				=null;

	public Map<String, String> getFieldToConfig() {
		return fieldToConfig;
	}

	/**
	 * Constructor for ManifestVnf object 
	 * @param name the name of the file to write out
	 * @param manifest_field set of field that the vnfs is able to recognize
	 * @param manifest_action set of action that the vnfs is able to perform 
	 * @param description description of Vnfs
	 * @param generalInfo general info vnfs
	 * @param softwareInfo software info vnfs
	 * @param hardwareInfo thardware info vnfs
	*/
	public ManifestVNF(String name, Map<String, HashSet<String>> manifest_field, 
			HashSet<String> manifest_action,String description, GeneralInfo generalInfo, 
			SoftwareInfo softwareInfo, HardwareInfo hardwareInfo,Map<String, String> fieldToConfig) {
		this.name = name;
		this.manifest_field = manifest_field;
		this.manifest_action = manifest_action;
		this.description = description;
		this.generalInfo = generalInfo;
		this.softwareInfo = softwareInfo;
		this.hardwareInfo = hardwareInfo;
		this.fieldToConfig= fieldToConfig;
	}

	/**
	 * Return the name of block 
	 * @return name of the vnfs
	*/

	public String getName() {
		return name;
	}

	/**
	 * Return all field involved
	 * @return manifest_field
	*/

	public Map<String, HashSet<String>> getManifest_field() {
		return manifest_field;
	}

	/**
	 * Return all action involved
	 * @return manifest_action
	*/

	public HashSet<String> getManifest_action() {
		return manifest_action;
	}

	/**
	 * Return the description of manifest
	 * @return manifest_field
	*/

	public String getDescription() {
		return description;
	}

	/**
	 * Return generalInfo of vnf
	 * @return genearl_Info
	*/

	public GeneralInfo getGeneralInfo() {
		return generalInfo;
	}
	/**
	 * Return generalInfo of vnf
	 * @return general_Info
	*/


	public SoftwareInfo getSoftwareInfo() {
		return softwareInfo;
	}
	/**
	 * Return hardareInfo of vnf
	 * @return Hardware Info
	*/

	public HardwareInfo getHardwareInfo() {
		return hardwareInfo;
	}
	
	/**
	 * Print all Fields whit the respective value supported
	 * 
	*/
	public void printNameFields() {
		manifest_field.forEach((k,v)-> System.out.println("FIELD = " + k + "\tVALUE = "+ v));
	}
	
	/**
	 * Print all Action  supported
	 * 
	*/
	public void printNameActions() {
		manifest_action.forEach((k)-> System.out.println("ACTION = " + k ));
    }
	 
	/**
	 * Print all Action and Field  supported
	 * @return string content
	*/

	public String PrintAllInformation() {
		StringBuffer s = new StringBuffer();
		s.append(UtilsFunction.makeLine('-'));
		s.append("\nManifest NAME= "+name);
		s.append("\n");
		s.append("FIELD:");
		manifest_field.forEach((k,v) -> s.append("\n\t"+k + "= "+v));
		s.append("\n");
		s.append("ACTION:");
		manifest_action.forEach((k) -> s.append("\n\t"+k));

		return s.toString();
	}
	 
	
}
