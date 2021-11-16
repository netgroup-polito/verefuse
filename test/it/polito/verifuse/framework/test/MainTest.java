package it.polito.verifuse.framework.test;

import static org.junit.Assert.fail; 

import org.junit.Test;

import com.sun.tools.xjc.addon.code_injector.Const;

import it.polito.verifuse.main.Main;
import it.polito.verifuse.utility.consts.Consts;

public class MainTest {
	
	/** Fixed Requirement
	 * 	FixedTool to Marshalfile true; other are set to false
	 *  Fixed number thread to 3 for thread pool for building functionality
	 */

	private static String pathSaveOutput= "resultTest/MainTest/";
	/*
	 * TESTING the main class whit multiple input
	 * 1 Requirement - 1 VNF
	 */
	@Test
	public void testMain1()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test1.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test1.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test1_";
			
			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	/*
	 * TESTING the main class whit multiple input
	 * 1 Requirement - 2 VNF
	 */

	@Test
	public void testMain2()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test1.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test2.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test2_";

			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	/*
	 * TESTING the main class whit multiple input
	 * 1 Requirement - 3 VNF
	 */

	@Test
	public void testMain3()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test1.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test3.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test3_";

			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	/*
	 * TESTING the main class whit multiple input
	 * 1 Requirement - 4 VNF
	 */

	@Test
	public void testMain4()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test1.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test4.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test4_";

			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	/*
	 * TESTING the main class whit multiple input
	 * 1 Requirement -5VNF
	 */

	@Test
	public void testMain5()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test1.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test5.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test5_";

			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	/*
	 * TESTING the main class whit multiple input
	 * 1 Requirement - 3 VNF
	 */

	@Test
	public void testMain6()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test1.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test6.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test6_";

			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	/*
	 * TESTING the main class whit multiple input
	 * 1 Requirement - 7 VNF
	 */

	@Test
	public void testMain7()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test1.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test7.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test7_";

			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	/*
	 * TESTING the main class whit multiple input
	 * 1 Requirement - 8 VNF
	 */

	@Test
	public void testMain8()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test1.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test8.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test8_";

			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	/*
	 * TESTING the main class whit multiple input
	 * 1 Requirement - 9 VNF
	 */

	@Test
	public void testMain9()	{
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test1.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test9.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test9_";

			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	/*
	 * TESTING the main class whit multiple input
	 * 1 Requirement - 10 VNF
	 */
	@Test
	public void testMain10(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test1.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test10.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test10_";

			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	
	/** TESTING REVERS situation 
	 * TESTING the main class whit multiple input
	 * 2 Requirement - 2 VNF
	 */
	@Test
	public void testMain11(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test2.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test2.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test11_";

			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	/*
	 * TESTING the main class whit multiple input
	 * 3 Requirement - 3 VNF
	 */
	@Test
	public void testMain12(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test3.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test3.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test12_";

			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	/*
	 * TESTING the main class whit multiple input
	 * 4 Requirement - 4 VNF
	 */
	@Test
	public void testMain13(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test4.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test4.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test13_";

			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	/*
	 * TESTING the main class whit multiple input
	 * 5 Requirement - 5 VNF
	 */
	@Test
	public void testMain14(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test5.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test5.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test14_";

			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	/*
	 * TESTING the main class whit multiple input
	 * 6 Requirement - 6 VNF
	 */
	@Test
	public void testMain15(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test6.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test6.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test15_";

			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	/*
	 * TESTING the main class whit multiple input
	 * 7 Requirement - 7 VNF
	 */
	@Test
	public void testMain16(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test7.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test7.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test16_";

			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	/*
	 * TESTING the main class whit multiple input
	 * 8 Requirement - 8 VNF
	 */
	@Test
	public void testMain17(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test8.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test8.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test18_";

			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	/*
	 * TESTING the main class whit multiple input
	 * 9 Requirement - 9 VNF
	 */
	@Test
	public void testMain18(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test9.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test9.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test19_";

			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	/*
	 * TESTING the main class whit multiple input
	 * 10 Requirement - 10 VNF
	 */
	@Test
	public void testMain19(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test10.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test19_";

			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	/*
	 * TESTING the main class whit multiple input
	 * 10 Requirement - 10 VNF whit all tools enabled - marshalling - output on file and push on neo4jDB
	 */
	@Test
	public void testMain20(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test10.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test3.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test20_";

			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}

	
	
	
	
	/** Fixed 10 Requirement - 10 VNF
	 * 	FixedTool to Marshalfile true; other are set to false
	 *  Test with 5 for thread pool for building functionality
	 */
	@Test
	public void testMain22(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test10.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test22_";
			
			Consts.NUMBERTHREAD=5;
			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	/** Fixed 10 Requirement - 10 VNF
	 * 	FixedTool to Marshalfile true; other are set to false
	 *  Test with 8 for thread pool for building functionality
	 */
	@Test
	public void testMain23(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test10.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test23_";
			
			Consts.NUMBERTHREAD=8;
			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}
	/** Fixed 10 Requirement - 10 VNF
	 * 	FixedTool to Marshalfile true; other are set to false
	 *  Test with 10 for thread pool for building functionality
	 */
	@Test
	public void testMain24(){
		try	{
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/xml/requirement_test10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/xml/catalog_test10.xml";
			String pathXmlTools 	   	   	= "test/it/polito/verifuse/framework/test/xml/tools_test1.xml";
			
			String args[] = new String[4];
			args[0] = pathXmlRequirement;
			args[1] = pathXmlManifestVnfs;
			args[2] = pathXmlTools;
			args[3] = pathSaveOutput+"test24_";
			
			Consts.NUMBERTHREAD=10;
			Main.main(args);
		}
		catch (Exception e) {
			fail("Exception during the test.\nMsg:" + e.getMessage());
		}
	}



	
}
