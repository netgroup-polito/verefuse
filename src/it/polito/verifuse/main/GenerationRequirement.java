package it.polito.verifuse.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import it.polito.verifuse.jaxb.requirementslist.ObjectFactory;
import it.polito.verifuse.jaxb.requirementslist.Requirement;
import it.polito.verifuse.jaxb.requirementslist.RequirementsList;
import it.polito.verifuse.utility.consts.Consts;

public class GenerationRequirement {

	private static String pathSave="test/it/polito/verifuse/framework/test/scalability/";
	/**
	 * 
	 * Generation of requirement given a set of requirments
	 * @param args
	 */
	public static void main(String[] args) {
		it.polito.verifuse.utility.classes.Unmarshaller m 	= new it.polito.verifuse.utility.classes.Unmarshaller();
		String pathXmlRequirement 		= Consts.PATH_XML_REQUIREMENTSLIST;
		RequirementsList requirements 	= m.unmarshallRequirements(pathXmlRequirement, Consts.PACKAGE_REQUIREMENTSLIST);
		
		ArrayList<Integer> arraynum = new ArrayList<>();
		for(int i=10;i<100;i=i+10)
			arraynum.add(i);
		for(int i=100;i<1000;i=i+100)
			arraynum.add(i);
		for(int i=1000;i<10000;i=i+1000)
			arraynum.add(i);
		for(int i=10000;i<100000;i=i+10000)
			arraynum.add(i);
		for(int i=100000;i<1000000;i=i+100000)
			arraynum.add(i);
	
		for(Integer number: arraynum){
			int id=1;
			int dimmax=number/10;
			ObjectFactory r = new ObjectFactory();
			RequirementsList rl= r.createRequirementsList();

			for(int i=0 ;i<dimmax;i++){
				for(Requirement jaxb_req :requirements.getRequirement()){
					Requirement req= r.createRequirement();
					req.setActions(jaxb_req.getActions());
					req.setFields(jaxb_req.getFields());
					req.setInfo(jaxb_req.getInfo());
					req.setReqID(BigInteger.valueOf(id));
					id++;
					rl.getRequirement().add(req);
				}
			}

			JAXBContext jaxbContext	=null;
			Marshaller marshaller	=null;
			try
			{

				jaxbContext 	= JAXBContext.newInstance(RequirementsList.class);
				marshaller 		= jaxbContext.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				
				OutputStream os= new FileOutputStream(new File(pathSave+"NOT_Order_Requirement_"+String.valueOf(number/10)+"0"+".xml"));
				marshaller.marshal( rl, os );

			}catch (NullPointerException e) {
				System.out.println("Error: path file not exist");
				e.printStackTrace();
				return;
			}catch (JAXBException e) {
				System.out.println("Error: Jaxb can not unmarshall");
				e.printStackTrace();
				return;
			}catch (Exception e) {
				System.out.println("Error");
				e.printStackTrace();
				return;
			}

		}
	}

}
