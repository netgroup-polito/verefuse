package it.polito.verifuse.utility.classes;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import it.polito.verifuse.jaxb.manifestvnfs.ManifestVNFs;
import it.polito.verifuse.utility.consts.Consts;

public class UtilsFunction {

	public UtilsFunction() {
	}
	
	public static StringBuffer makeLine(char c) {
		StringBuffer line = new StringBuffer(132);
		
		for (int i = 0; i < 132; ++i) {
			line.append(c);
		}
		return line;
	}
	
	public static void fillMapVNFs(ManifestVNFs manifest,ConcurrentHashMap<String, it.polito.verifuse.utility.classes.ManifestVNF> VNFs){
		ExecutorService executor = Executors.newFixedThreadPool(Consts.NUMBERTHREAD);
		GetDataInput data = new GetDataInput();
		for(it.polito.verifuse.jaxb.manifestvnfs.ManifestVNFs.ManifestVNF vnf :manifest.getManifestVNF()){
            executor.execute(new Runnable() {
				@Override
				public void run() {
					VNFs.put(vnf.getManifestID(), data.getData(vnf));
				}
			});
		}
        executor.shutdown();
        while (!executor.isTerminated()) {}
	}
}
