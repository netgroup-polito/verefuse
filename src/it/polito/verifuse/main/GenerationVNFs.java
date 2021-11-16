package it.polito.verifuse.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import it.polito.verifuse.jaxb.manifestvnfs.ManifestVNFs;
import it.polito.verifuse.jaxb.manifestvnfs.ManifestVNFs.ManifestVNF;
import it.polito.verifuse.jaxb.manifestvnfs.*;
import it.polito.verifuse.utility.consts.Consts;

public class GenerationVNFs {

	private static String pathSave="test/it/polito/verifuse/framework/test/scalability/";
	/**
	 * 
	 * Generation of requirement given a set of requirements
	 * @param args
	 */
	public static void main(String[] args) {
		it.polito.verifuse.utility.classes.Unmarshaller m 	= new it.polito.verifuse.utility.classes.Unmarshaller();
		String pathXmlManifest 		= Consts.PATH_XML_MANIFEST;
		ManifestVNFs manifest 		= m.unmarshallManifestVnfs(pathXmlManifest, Consts.PACKAGE_MANIFEST);
		
		ArrayList<Integer> arraynum=new ArrayList<>();
		for(int i=10;i<=100;i=i+10)
			arraynum.add(i);
		for(int i=100;i<=1000;i=i+100)
			arraynum.add(i);
		for(int i=1000;i<=10000;i=i+1000)
			arraynum.add(i);

		arraynum.add(10000);
		arraynum.add(100000);
		arraynum.add(1000000);
		for(Integer number: arraynum){
			int id=1;
			int dimmax=number/10;
			ObjectFactory r = new ObjectFactory();
			ManifestVNFs rl= r.createManifestVNFs();

			for(int i=0 ;i<dimmax;i++){
				for(ManifestVNF jaxb_vnf :manifest.getManifestVNF()){
					ManifestVNF vnf= r.createManifestVNFsManifestVNF();
					vnf.setDescription(jaxb_vnf.getDescription());
					vnf.setGeneralInfo(jaxb_vnf.getGeneralInfo());
					vnf.setHardwareInfo(jaxb_vnf.getHardwareInfo());
					vnf.setManifestInfo(jaxb_vnf.getManifestInfo());
					vnf.setSoftwareInfo(jaxb_vnf.getSoftwareInfo());
					vnf.setManifestID("VNF_"+String.valueOf(id));
					id++;
					
					rl.getManifestVNF().add(vnf);
				}
			}

			JAXBContext jaxbContext	=null;
			Marshaller marshaller	=null;
			try
			{

				jaxbContext 	= JAXBContext.newInstance(ManifestVNFs.class);
				marshaller 		= jaxbContext.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				
				OutputStream os= new FileOutputStream(new File(pathSave+"Manifest_"+String.valueOf(number/10)+"0"+".xml"));
				marshaller.marshal( rl, os );

			}catch (NullPointerException e) {
				System.out.println("Error: path file not exist");
				e.printStackTrace();
				return ;
			}catch (JAXBException e) {
				System.out.println("Error: Jaxb can not unmarshall");
				e.printStackTrace();
				return ;
			}catch (Exception e) {
				System.out.println("Error");
				e.printStackTrace();
				return ;
			}

		}
	}

}
