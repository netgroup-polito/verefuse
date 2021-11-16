package it.polito.verifuse.framework.test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.tools.xjc.addon.code_injector.Const;

import static org.junit.Assert.*;

import it.polito.verifuse.functionality.Functionality;
import it.polito.verifuse.jaxb.manifestvnfs.ManifestVNFs;
import it.polito.verifuse.jaxb.requirementslist.Requirement;
import it.polito.verifuse.jaxb.requirementslist.RequirementsList;
import it.polito.verifuse.jaxb.tools.Tools;
import it.polito.verifuse.modules.RDF;
import it.polito.verifuse.neo4j.client.Neo4jClient;
import it.polito.verifuse.utility.classes.GetDataInput;
import it.polito.verifuse.utility.classes.ManifestVNF;
import it.polito.verifuse.utility.classes.Unmarshaller;
import it.polito.verifuse.utility.consts.Consts;


public class RDFTest {
	
	/*
	 * TESTING module RDF 1 requirement and 1 VNFS
	 * 
	 */
	static String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test1.xml";
	static String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test1.xml";
	static String pathXmlTools 	   	   		= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
	static it.polito.verifuse.utility.classes.Requirement requirement			= null;
	static ConcurrentHashMap<String, ManifestVNF> VNFs	= new ConcurrentHashMap<>(); 
	static Tools tools							= null;
	static ManifestVNFs manifest				= null;
	static RequirementsList requirements 		= null;

	@BeforeClass
	static public void preapareDataForTesting() 
    { 
		GetDataInput data_manifest			= new GetDataInput();
		GetDataInput data_requirement		= new GetDataInput();
		Unmarshaller m 						= new Unmarshaller();
		tools				= m.unmarshallTools(pathXmlTools, Consts.PACKAGE_TOOLS);
		manifest			= m.unmarshallManifestVnfs(pathXmlManifestVnfs, Consts.PACKAGE_MANIFEST);
		requirements 		= m.unmarshallRequirements(pathXmlRequirement, Consts.PACKAGE_REQUIREMENTSLIST);

		for(it.polito.verifuse.jaxb.manifestvnfs.ManifestVNFs.ManifestVNF vnf :manifest.getManifestVNF()){
			VNFs.put(vnf.getManifestID(), data_manifest.getData(vnf));
		}	
		requirement =data_requirement.getData(requirements.getRequirement().get(0)); 
   
    }
	
	/**
	 * Tests marshallinh operation , if it contains one requirement and one VNF.
	 */
	@Test
	public void testRequirmentVNFNumber() {
		try {
			if(requirements.getRequirement().size() == 0)	{
				fail("The Requirment must be present");
			}
			if(manifest.getManifestVNF().size() == 0)	{
				fail("The Manifest must be present");
			}
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	/**
	 * Tests marshallinh operation , if it contains one requirement and one VNF.
	 */
	@Test
	public void testNotNullElementRequirment() {
		try {
			Requirement r=requirements.getRequirement().get(0);
			// check if all object are not null
			assertNotNull(r);
			assertNotNull(r.getFields());
			assertNotNull(r.getActions());
			assertNotNull(r.getInfo());
			assertEquals(1, r.getReqID().intValue());
			assertNotNull(r.getActions().getActionSet());
			
			// check content requirment 
			assertNotNull(r.getFields().getIpSrc());
			assertNotNull(r.getFields().getPortDst());
			assertNotNull(r.getFields().getProto());
			assertNotNull(r.getFields().getUrls());
			assertNotNull(r.getFields().getDaysAndTimes());
			assertNotNull(r.getFields().getDocuments());			

			// check if all content is correct as the input 
			assertEquals("LOG_TRAFFIC",r.getActions().getActionSet().get(0).getActionRequired().get(0).getAction().toString());
			assertEquals(1,r.getActions().getActionSet().get(0).getOrder().intValue());

			assertEquals("DENY_TRAFFIC",r.getActions().getActionSet().get(1).getActionRequired().get(0).getAction().toString());
			assertEquals(2,r.getActions().getActionSet().get(1).getOrder().intValue());

			assertEquals("COUNT",r.getActions().getActionSet().get(1).getActionRequired().get(1).getAction().toString());
			assertEquals(2,r.getActions().getActionSet().get(1).getOrder().intValue());
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	@Test
	public void testNotNullElementVNF() {
		try {
			it.polito.verifuse.jaxb.manifestvnfs.ManifestVNFs.ManifestVNF v=manifest.getManifestVNF().get(0);
			// check if all object are not null
			
			assertNotNull(v.getDescription());
			assertNotNull(v.getGeneralInfo());
			assertNotNull(v.getSoftwareInfo());
			assertNotNull(v.getHardwareInfo());
			assertNotNull(v.getManifestInfo());
			assertNotNull(v.getManifestID());
			assertNotNull(v.getManifestInfo().getActionsManifest());
			assertNotNull(v.getManifestInfo().getFieldsManifest());
			
			// check if content it is the same of the expected value
			assertEquals(5,v.getManifestInfo().getActionsManifest().getActionSupport().size());
			ArrayList<String> hs=new ArrayList<>();
			hs.add("LOG_TRAFFIC");
			hs.add("DENY_TRAFFIC");
			hs.add("ALERT");
			hs.add("COUNT");
			hs.add("ALLOW_TRAFFIC");
			assertTrue(hs.containsAll(
					v.getManifestInfo().getActionsManifest()
					.getActionSupport().stream()
					.map(k-> k.getAction().toString())
					.collect(Collectors.toList())));
		
			assertEquals(13,v.getManifestInfo().getFieldsManifest().getField().size());
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	/**
	 * Tests if it is possible to create the module.
	 */
	@Test
	public void testRDF() {
		try {
			new RDF(requirement,VNFs);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());	
		}
	}
	/**
	 * Tests if it is possible find Functionality.
	 */

	@Test
	public void testRDF_FindMappingFunctionality() {
		try {
			RDF rdf=new RDF(requirement,VNFs);
			assertTrue(rdf.findMappingFunctionality());
			
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());		
		}
	}
	/**
	 * Tests size mapping  Functionality.
	 */

	@Test
	public void testRDF_SizeFindMappingFunctionality() {
		try {
			RDF rdf=new RDF(requirement,VNFs);
			rdf.findMappingFunctionality();
			assertEquals(1,rdf.getMapToFunctionality().size());
			
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());		
		}
	}


	/**
	 * Tests if exist constraint on allow.
	 */

	@Test
	public void testRDF_AllowContraint() {
		try {
			RDF rdf=new RDF(requirement,VNFs);
			assertFalse(rdf.isAllowConstraint());
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());	
		}
	}

	/**
	 * Tests if exist constraint on allow.
	 */

	@Test
	public void testRDFWhitNullObject() {
		try {
			RDF rdf=new RDF(null,null);
			rdf.findMappingFunctionality();
			assertTrue(false);			
		}
		catch (Exception e) {
			assertTrue(true);			
		}
	}
	
	
	/**
	 * Tests if it is possible to post the scenario on Neo4J.
	 */
	@Test
	public void testPerformPostScenarioOnNeo4j() {
		try {
			Neo4jClient client= new Neo4jClient();
			RDF rdf=new RDF(requirement,VNFs);
			rdf.findMappingFunctionality();
			rdf.graphDBNeo4j(client);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	/**
	 * Tests if it is possible to post the scenario on Neo4J whit null client
	 */
	@Test
	public void testPerformPostScenarioOnNeo4jNullClient() {
		try {
			
			RDF rdf=new RDF(requirement,VNFs);
			assertFalse(rdf.graphDBNeo4j(null));
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	/**
	 * Tests unsatisfability for requirment - action not supported by vnf
	 */
	@Test
	public void testUnsat() {
		try {
			String pathXmlRequirementUnsat 		= "test/it/polito/verifuse/framework/test/xml/requirement_notsat.xml";
			GetDataInput data_requirement		= new GetDataInput();
			Unmarshaller m 						= new Unmarshaller();
			RequirementsList requirements 		= m.unmarshallRequirements(pathXmlRequirementUnsat, Consts.PACKAGE_REQUIREMENTSLIST);
			it.polito.verifuse.utility.classes.Requirement requirement =data_requirement.getData(requirements.getRequirement().get(0)); 

			RDF rdf=new RDF(requirement,VNFs);
			rdf.findMappingFunctionality();
			assertEquals(0,rdf.getMapToFunctionality().size());
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	/**
	 * Tests unsatisfability for requirment - action not supported by vnf
	 */
	@Test
	public void testFieldStarAndPlus() {
		try {
			HashSet<String> fieldStar= new HashSet<>();
			HashSet<String> fieldStarRefer= new HashSet<>();
			
			RDF rdf=new RDF(requirement,VNFs);
			rdf.findMappingFunctionality();
			int count=0;
			assertEquals(1, rdf.getMapToFunctionality().values().size());
			for(Functionality f: rdf.getMapToFunctionality().values()){
				for(Map.Entry<String, HashSet<String>> entry: f.getFields_functionality().entrySet()){
					if(entry.getValue().contains(Consts.NOT_CONF_MAKE_DEC)){
						count++;
						fieldStar.add(entry.getKey());
					}
				}
			}
			assertEquals(2, count);
			fieldStarRefer.add("URLS");
			fieldStarRefer.add("DOCUMENTS");
			assertTrue(fieldStar.containsAll(fieldStarRefer));
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	/**
	 * Tests building functionality whit different thread ( 5-8-10 ) Functionality.
	 */
	@Test
	public void testRDF5thread() {
		try {
			String pathXmlManifestVnfs_test 	= "test/it/polito/verifuse/framework/test/xml/catalog_test50.xml";
			GetDataInput data_manifest			= new GetDataInput();
			Unmarshaller m 						= new Unmarshaller();
			ManifestVNFs manifest				= null;

			manifest			= m.unmarshallManifestVnfs(pathXmlManifestVnfs_test, Consts.PACKAGE_MANIFEST);
			ConcurrentHashMap<String, ManifestVNF> VNFs_test	= new ConcurrentHashMap<>(); 

			for(it.polito.verifuse.jaxb.manifestvnfs.ManifestVNFs.ManifestVNF vnf :manifest.getManifestVNF()){
				VNFs_test.put(vnf.getManifestID(), data_manifest.getData(vnf));
			}	

			Consts.NUMBERTHREAD=5;
			RDF rdf=new RDF(requirement,VNFs_test);
			rdf.findMappingFunctionality();			
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());		
		}
	}
	@Test
	public void testRDF8thread() {
		try {
			String pathXmlManifestVnfs_test 	= "test/it/polito/verifuse/framework/test/xml/catalog_test50.xml";
			GetDataInput data_manifest			= new GetDataInput();
			Unmarshaller m 						= new Unmarshaller();
			ManifestVNFs manifest				= null;
			manifest			= m.unmarshallManifestVnfs(pathXmlManifestVnfs_test, Consts.PACKAGE_MANIFEST);
			ConcurrentHashMap<String, ManifestVNF> VNFs_test	= new ConcurrentHashMap<>(); 

			for(it.polito.verifuse.jaxb.manifestvnfs.ManifestVNFs.ManifestVNF vnf :manifest.getManifestVNF()){
				VNFs_test.put(vnf.getManifestID(), data_manifest.getData(vnf));
			}	
			
			Consts.NUMBERTHREAD=8;
			RDF rdf=new RDF(requirement,VNFs_test);
			rdf.findMappingFunctionality();			
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());	
		}
	}
	@Test
	public void testRDF10thread() {
		try {
			String pathXmlManifestVnfs_test 	= "test/it/polito/verifuse/framework/test/xml/catalog_test50.xml";
			GetDataInput data_manifest			= new GetDataInput();
			Unmarshaller m 						= new Unmarshaller();
			ManifestVNFs manifest				= null;
			manifest			= m.unmarshallManifestVnfs(pathXmlManifestVnfs_test, Consts.PACKAGE_MANIFEST);
			ConcurrentHashMap<String, ManifestVNF> VNFs_test	= new ConcurrentHashMap<>(); 

			for(it.polito.verifuse.jaxb.manifestvnfs.ManifestVNFs.ManifestVNF vnf :manifest.getManifestVNF()){
				VNFs_test.put(vnf.getManifestID(), data_manifest.getData(vnf));
			}	
			
			Consts.NUMBERTHREAD=10;
			RDF rdf=new RDF(requirement,VNFs_test);
			rdf.findMappingFunctionality();			
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());	
		}
	} 



}
