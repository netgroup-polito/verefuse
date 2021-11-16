package it.polito.verifuse.framework.test_scalability;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.core.config.Order;
import org.junit.BeforeClass;
import org.junit.Test;

import it.polito.verifuse.main.Main;
import it.polito.verifuse.utility.classes.GetDataInput;
import it.polito.verifuse.utility.classes.Unmarshaller;
import it.polito.verifuse.utility.consts.Consts;

public class Scalability_test_vnfs_t8 {
	private static String pathSaveOutput= "resultTest/MainTest/";
	
	private void writeOnFile(int testNumber, long time,int numberThread,int n_req,int vnfs) throws IOException {
	    BufferedWriter writer = new BufferedWriter(new FileWriter("test_scalability.out", true));
	    writer.append("VNFS_TEST_" + testNumber + "\tTime: " + time + " ms\tThreads: "+numberThread+"\tNRequ:"+n_req+"\tVNFS:\t"+vnfs+"\n");
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
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(1, totalTime,Consts.NUMBERTHREAD,10,10);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalability20()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_20.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(2, totalTime,Consts.NUMBERTHREAD,10,20);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalability30()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_30.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(3, totalTime,Consts.NUMBERTHREAD,10,30);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalability40()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_40.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(4, totalTime,Consts.NUMBERTHREAD,10,40);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalability50()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_50.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(5, totalTime,Consts.NUMBERTHREAD,10,50);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	@Test
	public void testScalability60()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_60.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(6, totalTime,Consts.NUMBERTHREAD,10,60);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	@Test
	public void testScalability70()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_70.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(7, totalTime,Consts.NUMBERTHREAD,10,70);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	@Test
	public void testScalability80()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_80.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(8, totalTime,Consts.NUMBERTHREAD,10,80);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalability90()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_90.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(9, totalTime,Consts.NUMBERTHREAD,10,90);
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
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_100.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(10, totalTime,Consts.NUMBERTHREAD,10,100);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility200()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_200.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(11, totalTime,Consts.NUMBERTHREAD,10,200);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility300()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_300.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(12, totalTime,Consts.NUMBERTHREAD,10,300);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility400()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_400.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(13, totalTime,Consts.NUMBERTHREAD,10,400);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility500()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_500.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(14, totalTime,Consts.NUMBERTHREAD,10,500);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility600()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_600.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(15, totalTime,Consts.NUMBERTHREAD,10,600);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility700()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_700.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(16, totalTime,Consts.NUMBERTHREAD,10,700);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility800()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_800.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(17, totalTime,Consts.NUMBERTHREAD,10,800);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility900()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_900.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(18, totalTime,Consts.NUMBERTHREAD,10,900);
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
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_1000.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(19, totalTime,Consts.NUMBERTHREAD,10,1000);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	
	@Test
	public void testScalbility2000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_2000.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(20, totalTime,Consts.NUMBERTHREAD,10,2000);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility3000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_3000.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(21, totalTime,Consts.NUMBERTHREAD,10,3000);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility4000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_4000.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(22, totalTime,Consts.NUMBERTHREAD,10,4000);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility5000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_5000.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(23, totalTime,Consts.NUMBERTHREAD,10,5000);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility6000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_6000.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(24, totalTime,Consts.NUMBERTHREAD,10,6000);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility7000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_7000.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(25, totalTime,Consts.NUMBERTHREAD,10,7000);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility8000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_8000.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(26, totalTime,Consts.NUMBERTHREAD,10,8000);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	@Test
	public void testScalbility9000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_9000.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(27, totalTime,Consts.NUMBERTHREAD,10,9000);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	

	@Test
	public void testScalbility10000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10000.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(28, totalTime,Consts.NUMBERTHREAD,10,10000);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	@Test
	public void testScalbility100000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_100000.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(29, totalTime,Consts.NUMBERTHREAD,10,100000);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	@Test
	public void testScalbility1000000()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_1000000.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test0.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"vnfs_t8_";
			
			long startTime = System.currentTimeMillis();
			Main.main(args);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			writeOnFile(30, totalTime,Consts.NUMBERTHREAD,10,1000000);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	
}
