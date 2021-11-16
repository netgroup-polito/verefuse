package it.polito.verifuse.framework.test_scalability;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.BeforeClass;
import org.junit.Test;

import it.polito.verifuse.jaxb.manifestvnfs.ManifestVNFs;
import it.polito.verifuse.jaxb.requirementslist.RequirementsList;
import it.polito.verifuse.modules.RDF;
import it.polito.verifuse.utility.classes.GetDataInput;
import it.polito.verifuse.utility.classes.ManifestVNF;
import it.polito.verifuse.utility.classes.Unmarshaller;
import it.polito.verifuse.utility.classes.UtilsFunction;
import it.polito.verifuse.utility.consts.Consts;
import it.polito.verifuse.utility.exceptions.MyExceptions.NotFoundMappingFunctionalityException;

public class Scalability_test_RDF_requirement {
	
	private static void writeOnFile(int testNumber, long time,int numberThread,int n_req,int vnfs) throws IOException {
	    BufferedWriter writer = new BufferedWriter(new FileWriter("test_scalability.out", true));
	    writer.append("REQUIREMENT_TEST_" + testNumber + "\tTime: " + time + " ms\tThreads: "+numberThread+"\tNRequ:"+n_req+"\tVNFS:\t"+vnfs+"\n");
	    writer.close();
	}
	
	@BeforeClass
	static public void set() 
    { 
		Consts.NUMBERTHREAD=4;
    }

	private static void executeTest(String pathXmlRequirement, String pathXmlManifestVnfs){
		try {
			ConcurrentHashMap<String, ManifestVNF> VNFs	= new ConcurrentHashMap<>(); 
			GetDataInput data_requirement		= new GetDataInput();
			Unmarshaller m 						= new Unmarshaller();
			ManifestVNFs manifest				= m.unmarshallManifestVnfs(pathXmlManifestVnfs, Consts.PACKAGE_MANIFEST);
			RequirementsList requirements		= m.unmarshallRequirements(pathXmlRequirement, 	Consts.PACKAGE_REQUIREMENTSLIST);
			UtilsFunction.fillMapVNFs(manifest,VNFs);
			ExecutorService executor = Executors.newFixedThreadPool(Consts.NUMBERTHREAD);
			for(it.polito.verifuse.jaxb.requirementslist.Requirement jaxb_req :requirements.getRequirement()){
				Runnable worker = new Runnable() {
					@Override
					public void run() {
						try{     	
							it.polito.verifuse.utility.classes.Requirement r =data_requirement.getData(jaxb_req); 
							RDF rdf= new RDF(r, VNFs);
							if(!rdf.findMappingFunctionality())
								throw new NotFoundMappingFunctionalityException("Error: is not possibile to find mapping functionality");											
						}catch (NotFoundMappingFunctionalityException e) {
							System.out.println("<!> Requirement - No Functionality are found.");
						}catch (Exception e) {
							e.printStackTrace();
							System.out.println("<!> ECCEZIONE - Requirement will not considered.");
						}
					}
				};		
				executor.execute(worker);
			}		
			executor.shutdown();
			while (!executor.isTerminated()) {}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void requirement10() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(1, totalTime,Consts.NUMBERTHREAD,10,10);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void requirement20() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_20.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(2, totalTime,Consts.NUMBERTHREAD,20,10);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void requirement30() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_30.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(3, totalTime,Consts.NUMBERTHREAD,30,10);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void requirement40() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_40.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(4, totalTime,Consts.NUMBERTHREAD,40,10);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	 public void requirement50() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_50.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(5, totalTime,Consts.NUMBERTHREAD,50,10);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	 public void requirement60() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_60.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(6, totalTime,Consts.NUMBERTHREAD,60,10);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	 public void requirement70() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_70.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(7, totalTime,Consts.NUMBERTHREAD,70,10);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	 public void requirement80() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_80.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(8, totalTime,Consts.NUMBERTHREAD,80,10);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	 public void requirement90() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_90.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(9, totalTime,Consts.NUMBERTHREAD,90,10);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	 public void requirement100() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_100.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(10, totalTime,Consts.NUMBERTHREAD,100,10);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	 public void requirement200() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_200.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(11, totalTime,Consts.NUMBERTHREAD,200,10);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	 public void requirement300() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_300.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(12, totalTime,Consts.NUMBERTHREAD,300,10);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	 public void requirement400() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_400.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(13, totalTime,Consts.NUMBERTHREAD,400,10);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	 public void requirement500() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_500.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(14, totalTime,Consts.NUMBERTHREAD,500,10);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	 public void requirement600() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_600.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(15, totalTime,Consts.NUMBERTHREAD,600,10);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	 public void requirement700() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_700.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(16, totalTime,Consts.NUMBERTHREAD,800,10);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	 public void requirement800() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_800.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(17, totalTime,Consts.NUMBERTHREAD,800,10);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	 public void requirement900() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_900.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(18, totalTime,Consts.NUMBERTHREAD,900,10);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	 public void requirement1000() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_1000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(19, totalTime,Consts.NUMBERTHREAD,1000,10);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	 public void requirement2000() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_2000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(20, totalTime,Consts.NUMBERTHREAD,2000,10);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	 public void requirement3000() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_3000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(21, totalTime,Consts.NUMBERTHREAD,3000,10);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	 public void requirement4000() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_4000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(22, totalTime,Consts.NUMBERTHREAD,4000,10);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	 public void requirement5000() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_5000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(23, totalTime,Consts.NUMBERTHREAD,5000,10);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	 public void requirement6000() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_6000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(24, totalTime,Consts.NUMBERTHREAD,6000,10);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	 public void requirement7000() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_7000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(25, totalTime,Consts.NUMBERTHREAD,7000,10);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	 public void requirement8000() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_8000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(26, totalTime,Consts.NUMBERTHREAD,8000,10);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	 public void requirement9000() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_9000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(27, totalTime,Consts.NUMBERTHREAD,9000,10);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	 public void requirement10000() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_10000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(28, totalTime,Consts.NUMBERTHREAD,10000,10);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	 public void requirement100000() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_100000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(29, totalTime,Consts.NUMBERTHREAD,100000,10);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	 public void requirement1000000() 
	{ 
		try {
			String pathXmlRequirement 		= "test/it/polito/verifuse/framework/test/scalability/Requirement_1000000.xml";
			String pathXmlManifestVnfs 	   	= "test/it/polito/verifuse/framework/test/scalability/Manifest_10.xml";
			long startTime= System.currentTimeMillis();
			
			executeTest(pathXmlRequirement, pathXmlManifestVnfs);
			
			long totalTime = System.currentTimeMillis() - startTime;
			writeOnFile(30, totalTime,Consts.NUMBERTHREAD,1000000,10);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}





}
