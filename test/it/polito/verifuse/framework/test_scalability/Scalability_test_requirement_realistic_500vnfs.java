package it.polito.verifuse.framework.test_scalability;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.core.config.Order;
import org.junit.BeforeClass;
import org.junit.Test;

import it.polito.verifuse.main.Main;
import it.polito.verifuse.main.Main2;
import it.polito.verifuse.utility.consts.Consts;

public class Scalability_test_requirement_realistic_500vnfs {
	private static String pathSaveOutput= "resultTest/MainTest/";
	
	private void writeOnFile(int testNumber, long time,int numberThread,int n_req,int vnfs) throws IOException {
	    BufferedWriter writer = new BufferedWriter(new FileWriter("test_scalability.out", true));
	    writer.append("REAL_REQUIREMENT_TEST_" + testNumber + "\tTime: " + time + " ms\tThreads: "+numberThread+"\tNRequ:"+n_req+"\tVNFS:\t"+vnfs+"\n");
	    writer.close();
	}
	
	@BeforeClass
	static public void set() 
    { 
		Consts.NUMBERTHREAD=8;
    }


	/*
	 * TESTING the main class whit multiple input
	 * 10 Requirement - 10 VNF
	 */
	@Test
	public void testScalability10()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(1, totalTime,Consts.NUMBERTHREAD,10,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	
	@Test
	public void testScalability20()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_20.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(2, totalTime,Consts.NUMBERTHREAD,20,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalability30()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_30.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(3, totalTime,Consts.NUMBERTHREAD,30,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalability40()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_40.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(4, totalTime,Consts.NUMBERTHREAD,40,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalability50()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_50.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(5, totalTime,Consts.NUMBERTHREAD,50,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	@Test
	public void testScalability60()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_60.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(6, totalTime,Consts.NUMBERTHREAD,60,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	@Test
	public void testScalability70()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_70.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(7, totalTime,Consts.NUMBERTHREAD,70,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	@Test
	public void testScalability80()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_80.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(8, totalTime,Consts.NUMBERTHREAD,80,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalability90()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_90.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(9, totalTime,Consts.NUMBERTHREAD,90,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	/*
	 * TESTING the main class whit multiple input
	 * 10 Requirement - 100 VNF
	 */
	
	@Test
	public void testScalbility100()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_100.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(10, totalTime,Consts.NUMBERTHREAD,100,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility200()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_200.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(11, totalTime,Consts.NUMBERTHREAD,200,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility300()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_300.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(12, totalTime,Consts.NUMBERTHREAD,300,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility400()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_400.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(13, totalTime,Consts.NUMBERTHREAD,400,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility500()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_500.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(14, totalTime,Consts.NUMBERTHREAD,500,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility600()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_600.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(15, totalTime,Consts.NUMBERTHREAD,600,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility700()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_700.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(16, totalTime,Consts.NUMBERTHREAD,700,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility800()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_800.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(17, totalTime,Consts.NUMBERTHREAD,800,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility900()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_900.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(18, totalTime,Consts.NUMBERTHREAD,900,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	
	/*
	 * TESTING the main class whit multiple input
	 * 10 Requirement - 1000 VNF
	 */
	
	@Test
	public void testScalbility1000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_1000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(19, totalTime,Consts.NUMBERTHREAD,1000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	
	@Test
	public void testScalbility2000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_2000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(20, totalTime,Consts.NUMBERTHREAD,2000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility3000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_3000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(21, totalTime,Consts.NUMBERTHREAD,3000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility4000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_4000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(22, totalTime,Consts.NUMBERTHREAD,4000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility5000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_5000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(23, totalTime,Consts.NUMBERTHREAD,5000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility6000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_6000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(24, totalTime,Consts.NUMBERTHREAD,6000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility7000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_7000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(25, totalTime,Consts.NUMBERTHREAD,7000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility8000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_8000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(26, totalTime,Consts.NUMBERTHREAD,8000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility9000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_9000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(27, totalTime,Consts.NUMBERTHREAD,9000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	

	@Test
	public void testScalbility10000(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(28, totalTime,Consts.NUMBERTHREAD,10000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	/******/

	@Test
	public void testScalbility20000(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_20000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(29, totalTime,Consts.NUMBERTHREAD,20000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	@Test
	public void testScalbility30000(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_30000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(30, totalTime,Consts.NUMBERTHREAD,30000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	@Test
	public void testScalbility40000(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_40000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(31, totalTime,Consts.NUMBERTHREAD,40000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility50000(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_50000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(32, totalTime,Consts.NUMBERTHREAD,50000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility60000(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_60000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(33, totalTime,Consts.NUMBERTHREAD,60000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility70000(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_70000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(34, totalTime,Consts.NUMBERTHREAD,70000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility80000(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_80000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(35, totalTime,Consts.NUMBERTHREAD,80000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility90000(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_90000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(36, totalTime,Consts.NUMBERTHREAD,90000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	/*******/
	@Test
	public void testScalbility100000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_100000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(37, totalTime,Consts.NUMBERTHREAD,100000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility200000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_200000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(38, totalTime,Consts.NUMBERTHREAD,200000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility300000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_300000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(39, totalTime,Consts.NUMBERTHREAD,300000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility400000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_400000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(40, totalTime,Consts.NUMBERTHREAD,400000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility500000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_500000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(41, totalTime,Consts.NUMBERTHREAD,500000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility600000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_600000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(42, totalTime,Consts.NUMBERTHREAD,600000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility700000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_700000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(43, totalTime,Consts.NUMBERTHREAD,700000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	@Test
	public void testScalbility800000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_800000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(44, totalTime,Consts.NUMBERTHREAD,800000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	@Test
	public void testScalbility900000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_900000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(45, totalTime,Consts.NUMBERTHREAD,900000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility1000000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_1000000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"Req_test1_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(46, totalTime,Consts.NUMBERTHREAD,1000000,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	
}
