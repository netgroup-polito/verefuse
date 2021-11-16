package it.polito.verifuse.utility.classes;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import it.polito.verifuse.jaxb.filesupport.FileSupport;
import it.polito.verifuse.jaxb.filesupport.FileSupport.Suite;
import it.polito.verifuse.jaxb.manifestvnfs.ManifestVNFs;
import it.polito.verifuse.jaxb.manifestvnfs.ManifestVNFs.ManifestVNF;
import it.polito.verifuse.jaxb.requirementslist.RequirementsList;
import it.polito.verifuse.jaxb.tools.Tools;


public class Unmarshaller {

	/**
	 * Constructor Unmarshaller object for Requirment and Manifest
	 */
	public Unmarshaller() {
	}
	
	/**
	 * Unmarshall the requirement given the file and the package riferiment.
	 * @param pathXml path of the file xml
	 * @param pathpackage package referiment
	 * @return The list of requirement inside the file xml
	 */
	public RequirementsList unmarshallRequirements(String pathXml, String pathpackage)  {
		JAXBContext jaxbContext=null;
		javax.xml.bind.Unmarshaller unmarshaller=null;
		File xmlFile =null;
		RequirementsList out=null;
        try
        {
        	xmlFile 		= new File(pathXml);	        
            jaxbContext 	= JAXBContext.newInstance(pathpackage);
            unmarshaller 	= jaxbContext.createUnmarshaller();
            out 			=(RequirementsList) unmarshaller.unmarshal(xmlFile);
            
        }catch (NullPointerException e) {
        	System.out.println("Error: path file not exist");
            e.printStackTrace();
            return null;
        }catch (JAXBException e) {
        	System.out.println("Error: Jaxb can not unmarshall");
            e.printStackTrace();
            return null;
        }catch (Exception e) {
        	System.out.println("Error");
            e.printStackTrace();
            return null;
		}
		return out;
	}
	
	/**
	 * Unmarshall the VNFs given the file and the package referiment.
	 * @param pathXml path of the file xml
	 * @param pathpackage package referiment
	 * @return The list of requirement inside the file xml
	 */

	public ManifestVNFs unmarshallManifestVnfs(String pathXml, String pathpackage)  {
		JAXBContext jaxbContext					=null;
		javax.xml.bind.Unmarshaller unmarshaller=null;
		File xmlFile							=null;
		ManifestVNFs out						=null;
        try
        {
        	xmlFile 		= new File(pathXml);	        
            jaxbContext 	= JAXBContext.newInstance(pathpackage);
            unmarshaller 	=  jaxbContext.createUnmarshaller();
            out 			=(ManifestVNFs) unmarshaller.unmarshal(xmlFile);
            
        }catch (NullPointerException e) {
        	System.out.println("Error: path file not exist");
            e.printStackTrace();
            return null;
        }catch (JAXBException e) {
        	System.out.println("Error: Jaxb can not unmarshall");
            e.printStackTrace();
            return null;
        }catch (Exception e) {
        	System.out.println("Error");
            e.printStackTrace();
            return null;
		}
		return out;
	}
	
	public Tools unmarshallTools(String pathXml, String pathpackage)  {
		JAXBContext jaxbContext					=null;
		javax.xml.bind.Unmarshaller unmarshaller=null;
		File xmlFile							=null;
		Tools out								=null;
        try
        {
        	xmlFile 		= new File(pathXml);	        
            jaxbContext 	= JAXBContext.newInstance(pathpackage);
            unmarshaller 	=  jaxbContext.createUnmarshaller();
            out 			=(Tools) unmarshaller.unmarshal(xmlFile);
            
        }catch (NullPointerException e) {
        	System.out.println("Error: path file not exist");
            e.printStackTrace();
            return null;
        }catch (JAXBException e) {
        	System.out.println("Error: Jaxb can not unmarshall");
            e.printStackTrace();
            return null;
        }catch (Exception e) {
        	System.out.println("Error");
            e.printStackTrace();
            return null;
		}
		return out;
	}
	
	public HashMap<String, List<String>> unmarshallFileSupport(String pathXml, String pathpackage)  {
		JAXBContext jaxbContext					=null;
		javax.xml.bind.Unmarshaller unmarshaller=null;
		File xmlFile							=null;
		FileSupport out							=null;
		HashMap<String, List<String>> hs= new HashMap<>();
        try
        {
        	xmlFile 		= new File(pathXml);	        
            jaxbContext 	= JAXBContext.newInstance(pathpackage);
            unmarshaller 	=  jaxbContext.createUnmarshaller();
            out 			=(FileSupport) unmarshaller.unmarshal(xmlFile);
            
            for(Suite s: out.getSuite()){
            	hs.put(s.getNameSuite(), s.getSupportValue().stream().map(m-> m.getValue()).collect(Collectors.toList()));
            }
            
        }catch (NullPointerException e) {
        	System.out.println("Error: path file not exist");
            e.printStackTrace();
            return null;
        }catch (JAXBException e) {
        	System.out.println("Error: Jaxb can not unmarshall");
            e.printStackTrace();
            return null;
        }catch (Exception e) {
        	System.out.println("Error");
            e.printStackTrace();
            return null;
		}
		return hs;
	}


}
