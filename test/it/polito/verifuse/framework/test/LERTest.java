package it.polito.verifuse.framework.test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.BeforeClass;
import org.junit.Test;


import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import it.polito.verifuse.functionality.ChainOfFunctionality;
import it.polito.verifuse.jaxb.manifestvnfs.ManifestVNFs;
import it.polito.verifuse.jaxb.requirementslist.RequirementsList;
import it.polito.verifuse.jaxb.tools.Tools;
import it.polito.verifuse.modules.LER;
import it.polito.verifuse.modules.RDF;
import it.polito.verifuse.neo4j.client.Neo4jClient;
import it.polito.verifuse.utility.classes.*;
import it.polito.verifuse.utility.consts.Consts;

public class LERTest {

	/*
	 * TESTING module LER 1 requirement and 1 VNFS
	 * 
	 */
	
	static String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test1.xml";
	static String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test1.xml";
	static String pathXmlTools 	   	   		= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
	static it.polito.verifuse.utility.classes.Requirement requirement			= null;
	static ConcurrentHashMap<String, ManifestVNF> VNFs	= null; 
	static Tools tools							= null;
	static ManifestVNFs manifest				= null;
	static RequirementsList requirements 		= null;

	@BeforeClass
	static public void preapareDataForTesting() 
    { 
		try{
			VNFs	= new ConcurrentHashMap<>();
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
		}catch (Exception e) {
			return;
		}
    }
	
	/**
	 * Tests null set functionality.
	 */
	@Test
	public void testNullSetFunctionality() {

		try {
			LER ler= new LER(null, requirement);
			assertFalse(ler.searchForChainGivenFunctionality());
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	
	/**
	 * Tests null requirement and set of functionality
	 * 
	 */
	public void testNullRequirementAndSetFunctionality() {
		try{
			LER ler= new LER(null, null);
			if(!ler.searchForChainGivenFunctionality())
				fail("The response should be false.\n");
		}catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	
	/**
	 * Tests time execution is setted
	 */
	@Test
	public void testTimeExecutionSetted() {
		try {
			RDF rdf = new RDF(requirement,VNFs);
			rdf.findMappingFunctionality();
			LER lertest = new LER(new ArrayList<>(rdf.getMapToFunctionality().values()), requirement);
			lertest.searchForChainGivenFunctionality();
			if(lertest.getTime()==0)
				fail("Time should be different from zero");
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}



	/**
	 * Tests if create chain of functionality
	 */
	@Test
	public void testSearchFunctionalitySuccess() {
		try {
			RDF rdf = new RDF(requirement,VNFs);
			rdf.findMappingFunctionality();
			LER lertest = new LER(new ArrayList<>(rdf.getMapToFunctionality().values()), requirement);
			lertest.searchForChainGivenFunctionality();
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	
	/**
	 * Tests the size of the solution found
	 */
	@Test
	public void testSizeChain() {
		try {
			RDF rdf = new RDF(requirement,VNFs);
			rdf.findMappingFunctionality();
			LER lertest = new LER(new ArrayList<>(rdf.getMapToFunctionality().values()), requirement);
			lertest.searchForChainGivenFunctionality();
			assertEquals(1, lertest.getOverallChain().size());
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	
	/**
	 * Tests the size of the Satisfability Chain
	 */
	@Test
	public void testSizeSatisfabilityChain() {
		try {
			RDF rdf = new RDF(requirement,VNFs);
			rdf.findMappingFunctionality();
			LER lertest = new LER(new ArrayList<>(rdf.getMapToFunctionality().values()), requirement);
			lertest.searchForChainGivenFunctionality();
			assertEquals(1, lertest.getMapSolSatisfiability().size());
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	
	/**
	 * Tests output of Satisfability Chain
	 */
	@Test
	public void testSatisfabilityChain() {
		try {
			RDF rdf = new RDF(requirement,VNFs);
			rdf.findMappingFunctionality();
			LER lertest = new LER(new ArrayList<>(rdf.getMapToFunctionality().values()), requirement);
			lertest.searchForChainGivenFunctionality();
			assertEquals(1, lertest.getMapSolSatisfiability().size());
        	for(Entry<String , ArrayList<ChainOfFunctionality>> entry : lertest.getOverallChain().entrySet()){
    			assertEquals(Consts.PARTIAL,lertest.getMapSolSatisfiability().get(entry.getKey()));
        	}
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	
	/**
	 * Tests if it is possible to post the scenario on Neo4J.
	 */
	@Test
	public void testPerformPostScenarioOnNeo4j() {
		try {
			Neo4jClient client= new Neo4jClient();
			RDF rdf = new RDF(requirement,VNFs);
			rdf.findMappingFunctionality();
			LER lertest= new LER(new ArrayList<>(rdf.getMapToFunctionality().values()), requirement);
			lertest.searchForChainGivenFunctionality();
			assertTrue(lertest.graphDBNeo4j(null,client));
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
			RDF rdf = new RDF(requirement,VNFs);
			rdf.findMappingFunctionality();
			LER lertest= new LER(new ArrayList<>(rdf.getMapToFunctionality().values()), 
					requirement);
			assertFalse(lertest.graphDBNeo4j(null,null));
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	/**
	 * Tests to check if each field has the correct value associated.
	 */
	@Test
	public void testCheckActionAssignAndFieldConfig() {
		try {
			HashSet<String> hs= new HashSet<>();
			hs.add("LOG_TRAFFIC");
			hs.add("DENY_TRAFFIC");
			hs.add("COUNT");
			HashMap<String,HashSet<String>> hsf= new HashMap<>();
			hsf.put(Consts.URLS, new HashSet<>(Arrays.asList(Consts.NOT_CONF_MAKE_DEC)));
			hsf.put(Consts.PORTDST, new HashSet<>(Arrays.asList("100-10500")));
			hsf.put(Consts.PROTOCOL, new HashSet<>(Arrays.asList("TCP")));
			hsf.put(Consts.CONTENTDOCUMENT, new HashSet<>(Arrays.asList(Consts.NOT_CONF_MAKE_DEC)));
			hsf.put(Consts.IPSRC_v4, new HashSet<>(Arrays.asList("10.0.3.21/24")));
			hsf.put(Consts.DAYS, new HashSet<>(Arrays.asList("Sunday;00:10:33;12:15:22", "Monday;01:10:33;12:15:22")));
			hsf.put(Consts.TIME, new HashSet<>(Arrays.asList("Monday", "Friday", "Sunday")));
			
			RDF rdf = new RDF(requirement,VNFs);
			rdf.findMappingFunctionality();
			LER lertest= new LER(new ArrayList<>(rdf.getMapToFunctionality().values()), 
					requirement);
			lertest.searchForChainGivenFunctionality();
        	for(Entry<String , ArrayList<ChainOfFunctionality>> entry : lertest.getOverallChain().entrySet()){
        		for(ChainOfFunctionality cf: entry.getValue()){
        			assertTrue(cf.getApplyActionSet().stream().map(m-> m.split("@")[0]).collect(Collectors.toList()).containsAll(hs));
        			assertTrue(cf.getFunction().getFields_functionality().keySet().containsAll(hsf.keySet()));
        			assertTrue(cf.getFunction().getFields_functionality().values().containsAll(hsf.values()));
        		}
        	}
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	
	/**
	 * Tests to check if each field has the correct value associated.
	 */

	@Test
	public void testMarshallingChain() {
		try {
			RDF rdf = new RDF(requirement,VNFs);
			rdf.findMappingFunctionality();
			LER lertest= new LER(new ArrayList<>(rdf.getMapToFunctionality().values()), 
					requirement);
			lertest.searchForChainGivenFunctionality();
			assertNotNull(requirements.getRequirement().get(0));
			
			MarshallerChainFunctionality marshall= new MarshallerChainFunctionality(
					requirement, 
					requirements.getRequirement().get(0), 
					String.valueOf("resultTest/LERTest/LerTestChain.xml"), 
					lertest.getOverallChain(), 
					lertest.getMapSolSatisfiability());
			
			marshall.run();
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	
}
