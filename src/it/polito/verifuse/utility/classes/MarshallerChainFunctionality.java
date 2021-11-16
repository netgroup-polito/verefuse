package it.polito.verifuse.utility.classes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.rmi.activation.ActivationSystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.AbstractDocument.BranchElement;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.sun.tools.xjc.addon.code_injector.Const;

import it.polito.verifuse.functionality.ChainOfFunctionality;
import it.polito.verifuse.jaxb.chainfunctionality.*;
import it.polito.verifuse.jaxb.chainfunctionality.Advertisings.Advertising;
import it.polito.verifuse.jaxb.chainfunctionality.Applications.Application;
import it.polito.verifuse.jaxb.chainfunctionality.ChainFunctionalities.Chain;
import it.polito.verifuse.jaxb.chainfunctionality.ChainFunctionalities.Chain.Solution;
import it.polito.verifuse.jaxb.chainfunctionality.DaysAndTimesType.DayAndTime;
import it.polito.verifuse.jaxb.chainfunctionality.Documents.Document;
import it.polito.verifuse.jaxb.chainfunctionality.Emails.Email;
import it.polito.verifuse.jaxb.chainfunctionality.Fields.Bandwidth;
import it.polito.verifuse.jaxb.chainfunctionality.Fields.Body;
import it.polito.verifuse.jaxb.chainfunctionality.Fields.IpDst;
import it.polito.verifuse.jaxb.chainfunctionality.Fields.IpSrc;
import it.polito.verifuse.jaxb.chainfunctionality.Fields.PortDst;
import it.polito.verifuse.jaxb.chainfunctionality.Fields.PortSrc;
import it.polito.verifuse.jaxb.chainfunctionality.Fields.Priority;
import it.polito.verifuse.jaxb.chainfunctionality.Fields.Proto;
import it.polito.verifuse.jaxb.chainfunctionality.Fields.VlanTag;
import it.polito.verifuse.jaxb.chainfunctionality.FunctionExtended.SupportedByVNFS;
import it.polito.verifuse.jaxb.chainfunctionality.FunctionExtended.SupportedByVNFS.Vnf;
import it.polito.verifuse.jaxb.chainfunctionality.Medias.Media;
import it.polito.verifuse.jaxb.chainfunctionality.Scripts.Script;
import it.polito.verifuse.jaxb.chainfunctionality.Webpages.WebPage;
import it.polito.verifuse.jaxb.requirementslist.ActionSetType.ActionSet;
import it.polito.verifuse.jaxb.requirementslist.Requirement;
import it.polito.verifuse.utility.consts.Consts;

public class MarshallerChainFunctionality implements Runnable{
	private it.polito.verifuse.utility.classes.Requirement requirement= null;
	private Requirement requirement_jaxb=null;
	private String filepath=null;
	private Map<String, ArrayList<ChainOfFunctionality>> cof = null;
	private Map<String, String> solSat=null;
	
	/**
	 * Constructor for unmarshall the chain of functionality discovered during the process apply by LER block.
	 * @param requirement object requirment
	 * @param requirement_jaxb jaxb object of the requirement
	 * @param filepath 
	 * @param cof 
	 * @param solSat 
	 */

	public MarshallerChainFunctionality(it.polito.verifuse.utility.classes.Requirement requirement,
			Requirement requirement_jaxb,String filepath,Map<String, ArrayList<ChainOfFunctionality>> cof
			,Map<String, String> solSat) {
		this.requirement		=requirement;
		this.requirement_jaxb	=requirement_jaxb;
		this.cof=cof;
		this.solSat=solSat;
		this.filepath=filepath;
	}

	@Override
	public void run() {
		boolean result_marshall=MarshallChain(this.filepath, this.cof,this.solSat);
		if(!result_marshall)
			System.out.println("Error during the marshall Requirement with ID= "+this.requirement.getRequirementID());

	}
	/**
	 * Perform unmarshall operation on chains of functionalities discovered during the process apply by LER block.
	 * @param nameFile the name of the file to write out
	 * @param cof Map with key: name of chain  values: the functionality that take part of solution
	 * @return true if success , false otherwise
	 */

	private boolean MarshallChain(String nameFile, Map<String, ArrayList<ChainOfFunctionality>> cof
			,Map<String, String> solSat)  {
		JAXBContext jaxbContext	=null;
		Marshaller marshaller	=null;
        try
        {

            jaxbContext 	= JAXBContext.newInstance(ChainFunctionalities.class);
            marshaller 		= jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            
            ChainFunctionalities cf = objReturnedForMarshalling(cof,solSat);
            OutputStream os= new FileOutputStream(new File(filepath));
            marshaller.marshal( cf, os );

        }catch (NullPointerException e) {
        	System.out.println("Error: path file not exist");
            e.printStackTrace();
            return false;
        }catch (JAXBException e) {
        	System.out.println("Error: Jaxb can not unmarshall");
            e.printStackTrace();
            return false;
        }catch (Exception e) {
        	System.out.println("Error");
            e.printStackTrace();
            return false;
		}
		return true;
	}

	private ChainFunctionalities objReturnedForMarshalling(Map<String, ArrayList<ChainOfFunctionality>> cof,Map<String, String> solSat){
        ObjectFactory obj = new ObjectFactory();
        
        Map<String, Chain> mapChainToObj 				= new HashMap<String, ChainFunctionalities.Chain>();
        Map<String, Solution> mapChainToObjSolution 	= new HashMap<>();
        
        ChainFunctionalities cf = obj.createChainFunctionalities();
        
        // sorting just for ordaginzation output
        LinkedHashMap<String, ArrayList<ChainOfFunctionality>> sortedMap = new LinkedHashMap<>();
        cof.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));;

        for(Entry<String, ArrayList<ChainOfFunctionality>> entry: sortedMap.entrySet()){
           
        	Chain 		c= null;
        	Solution 	s= null;

        	if(mapChainToObj.containsKey(entry.getKey().split(":")[0])){
        		c = mapChainToObj.get(entry.getKey().split(":")[0]);
        		
        		if(!mapChainToObjSolution.containsKey(entry.getKey())){
        			s= obj.createChainFunctionalitiesChainSolution();
                    s.setSolID(entry.getKey().split(":")[1]);
                    s.setSatisfiability(solSat.get(entry.getKey()));
                    c.getSolution().add(s);
                    mapChainToObjSolution.put(entry.getKey(), s);
        		}else
        			s = mapChainToObjSolution.get(entry.getKey());
        	}
        	else{
            	c= obj.createChainFunctionalitiesChain();
                c.setChainID(entry.getKey().split(":")[0]);
                mapChainToObj.put(c.getChainID(), c);
                
                s= obj.createChainFunctionalitiesChainSolution();
                s.setSolID(entry.getKey().split(":")[1]);
                s.setSatisfiability(solSat.get(entry.getKey()));
                
                c.getSolution().add(s);
                mapChainToObjSolution.put(entry.getKey(), s);
                cf.getChain().add(c);
        	}
            
        	
        	for(ChainOfFunctionality element : entry.getValue()){
                FunctionExtended fe = obj.createFunctionExtended();
                

                Fields f = obj.createFields();
                completeWhitValueField(f,element);
                fe.setFields(f);

                Actions a = obj.createActions();
                completeWhitValueAction(a,element);
                fe.setActions(a);
                
                SupportedByVNFS support = obj.createFunctionExtendedSupportedByVNFS();
                completeWhitValueVNFs(support,element);
                fe.setSupportedByVNFS(support);
                
                s.getFunctionality().add(fe);

        	}

        }

		return cf;
		
	}
	
	private BigInteger rescalePriorityAction(int val, int min, int max){
		if(min==max)
			return BigInteger.ONE;
		long result =(val-min)/(max-min);
		return BigInteger.valueOf(result+1);   // +1 per partire da una numerazione positiva 
	}
	
	private String returnNameAction(String s){
		Matcher m = Pattern.compile("(.*?);").matcher(s);
		if (m.find())
			return m.group(1);  // The matched substring	
		
		m = Pattern.compile("(.*?)@").matcher(s);
		if (m.find())
			return m.group(1);  // The matched substring	
		
		return null;
	}
	private String returnConstraintAction(String s){
		Matcher m = Pattern.compile(":(.*?);").matcher(s);
		if (m.find())
			return m.group(1);  // The matched substring	
		
		m = Pattern.compile(":(.*?)@").matcher(s);
		if (m.find())
			return m.group(1);  // The matched substring	
		
		return null;

	}
	private String returnFieldParametric(String s){
		Matcher m = Pattern.compile(";(.*?)@").matcher(s);
		if (m.find())
			return m.group(1);  // The matched substring	
		return null;

	}

	
	private void completeWhitValueAction(Actions a,ChainOfFunctionality cf){
		
		ObjectFactory o= new ObjectFactory();

		int min= cf.getApplyActionSet().stream().map(k-> returnNameAction(k)).map(k-> requirement.getMapActionToOrder().get(k).intValue())
				.min(Integer::compareTo).orElse(1);
	
		int max= cf.getApplyActionSet().stream().map(k-> returnNameAction(k)).map(k-> requirement.getMapActionToOrder().get(k).intValue())
				.max(Integer::compareTo).orElse(1);

		for(String s: cf.getApplyActionSet()){
			
			it.polito.verifuse.jaxb.chainfunctionality.Actions.Action single = o.createActionsAction();
			
			String nomeAzione=returnNameAction(s);
			String nomeCampoAzione=returnFieldParametric(s);
			String constraint=returnConstraintAction(s);
			
			if(requirement.getMapActionConcurrent().get(requirement.getMapActionToOrder().get(nomeAzione)) != null){
				HashSet<String> r=requirement.getMapActionToFieldsP().get(nomeAzione);
				if(r!=null)
					single.getInfoOnAction().addAll(r);
			}else{
				single.getInfoOnAction().add(nomeCampoAzione);
			}

			if(constraint!=null)
				single.setNameAction(nomeAzione.split(":")[0]);
			else
				single.setNameAction(nomeAzione);
			
			single.setConstraintAction(constraint);

			// adding priority value on action if it is inside order set
			
			BigInteger priority = requirement.getMapActionToOrder().get(returnNameAction(s));
			if(priority.compareTo(BigInteger.ZERO)>0)
				single.setPriorityAction(rescalePriorityAction(priority.intValue(),min, max));
			
			String updateValue = null;
			for(ActionSet as:requirement_jaxb.getActions().getActionSet()){
				updateValue=as.getActionRequired().stream()
						.filter(l-> s.contains(l.getAction().toString()))
						.filter(f->f.getUpdateValue()!=null)
						.map(m->m.getUpdateValue()).findFirst().orElse(null);
				
				if(updateValue!=null)
					break;
			}	
			single.setUpdateValue(updateValue);

			a.getAction().add(single);
		}
		
		// manage constraint for allow constraint
		/*
		if(requirement.isHaveConstraintAllow() && !cf.getApplyActionSet().contains(Consts.CONSTRAINT_ALLOW)){
			it.polito.verifuse.jaxb.chainfunctionality.Actions.Action single = o.createActionsAction();
			single.setNameAction(Consts.CONSTRAINT_ALLOW);
			a.getAction().add(single);
		}*/
	}
	
	private void completeWhitValueVNFs(SupportedByVNFS s,ChainOfFunctionality cf){
		Vnf v = null;
		for(String vnfname:cf.getFunction().getReferToVnfs()){
			v = new Vnf();
			v.setName(vnfname);
			s.getVnf().add(v);
		}	
		return;
	}

	private String completeConfigField(String field_value){
		if(field_value.contains(Consts.NOT_CONF_MAKE_DEC)){
			return Consts.NOT_CONF_MAKE_DEC;
		}else if(field_value.contains(Consts.NOT_CONF_NOT_DEC)){
			return Consts.NOT_CONF_NOT_DEC;
		}else{
			return Consts.CONF_DEC;
		}
	}
	
	private String insertValueGivenConfig(String field_value,String alter_value){
		if(field_value.contains(Consts.NOT_CONF_MAKE_DEC)){
			return Consts.STAR;
		}else if(field_value.contains(Consts.NOT_CONF_NOT_DEC)){
			return Consts.STAR;
		}else{
			return alter_value;
		}
	}

		
	private void completeWhitValueField(Fields f,ChainOfFunctionality cf){
		for(Entry<String, HashSet<String>> entry: cf.getFunction().getFields_functionality().entrySet()){

			String valueofconfig=completeConfigField(entry.getValue().toString());

			switch (entry.getKey()) {

			case Consts.IPSRC_v4:
				IpSrc ips4= new IpSrc();
				ips4.setAddress(insertValueGivenConfig(entry.getValue().toString(), 
						requirement_jaxb.getFields().getIpSrc().getAddress()));
				ips4.setVersion(VersionOfIp.IPV_4.toString());
				ips4.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				f.setIpSrc(ips4);
				break;
			case Consts.IPDST_v4:
				IpDst ipd4= new IpDst();
				ipd4.setAddress(insertValueGivenConfig(entry.getValue().toString(), 
						requirement_jaxb.getFields().getIpDst().getAddress()));
				ipd4.setVersion(VersionOfIp.IPV_4.toString());
				ipd4.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				f.setIpDst(ipd4);
				break;
			case Consts.IPSRC_v6:
				IpSrc ips6= new IpSrc();
				ips6.setAddress(insertValueGivenConfig(entry.getValue().toString(), 
						requirement_jaxb.getFields().getIpSrc().getAddress()));
				ips6.setVersion(VersionOfIp.IPV_6.toString());
				ips6.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				f.setIpSrc(ips6);
				break;
			case Consts.IPDST_v6:
				IpDst ipd6= new IpDst();
				ipd6.setAddress(insertValueGivenConfig(entry.getValue().toString(), 
						requirement_jaxb.getFields().getIpDst().getAddress()));
				ipd6.setVersion(VersionOfIp.IPV_6.toString());
				ipd6.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				f.setIpDst(ipd6);
				break;
			case Consts.PORTSRC:
				PortSrc ps= new PortSrc();
				ps.setRange(insertValueGivenConfig(entry.getValue().toString(), 
						requirement_jaxb.getFields().getPortSrc().getRange()));
				ps.setRangeSetting(RangeSettings.fromValue(requirement_jaxb.getFields().getPortSrc().getRangeSetting().toString().toLowerCase()).toString());
				ps.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				f.setPortSrc(ps);
				break;
			case Consts.PORTDST:
				PortDst pd = new PortDst();
				pd.setRange(insertValueGivenConfig(entry.getValue().toString(), 
						requirement_jaxb.getFields().getPortDst().getRange()));
				pd.setRangeSetting(RangeSettings.fromValue(requirement_jaxb.getFields().getPortDst().getRangeSetting().toString().toLowerCase()).toString());
				pd.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				f.setPortDst(pd);
				break;
			case Consts.PROTOCOL:
				Proto protocol= new Proto();
				protocol.setTypeProtocol(insertValueGivenConfig(entry.getValue().toString(), 
						requirement_jaxb.getFields().getProto().getTypeProtocol()));
				protocol.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				f.setProto(protocol);
				break;
			case Consts.URLS:
				ListanyURI l= new ListanyURI();
				entry.getValue().stream().forEach(k-> {
					ListanyURI.Url e= new ListanyURI.Url();
					e.setURLvalue(insertValueGivenConfig(valueofconfig, k));
					l.getUrl().add(e);
				});
				l.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				f.setUrls(l);
				break;
			case Consts.DOMAINS:
				DomainlistanyURI domain= new DomainlistanyURI();
				entry.getValue().stream().forEach(k-> {
					DomainlistanyURI.Domain e= new DomainlistanyURI.Domain();
					e.setDomainValue(insertValueGivenConfig(valueofconfig, k));
					domain.getDomain().add(e);
				});
				domain.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				f.setDomains(domain);
				break;
			case Consts.VLANTAG:
				VlanTag vlan= new VlanTag();
				vlan.setTag(insertValueGivenConfig(valueofconfig, entry.getValue().toString()));
				vlan.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				f.setVlanTag(vlan);
				break;
			case Consts.CONTENTDOCUMENT:
				Documents documents= new Documents();
				entry.getValue().stream().forEach(k->{
					Document document= new Document();
					document.setType(insertValueGivenConfig(valueofconfig, k));
					String regex=requirement_jaxb.getFields().getDocuments().getDocument()
							.stream()
							.filter(x -> x.getType().contentEquals(k) && x.getRegex()!=null)
							.map(x-> x.getRegex())
							.findFirst().orElse(null);
					document.setRegex(regex);
					documents.getDocument().add(document);
				});
				documents.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				f.setDocuments(documents);
				break;
			case Consts.CONTENTSCRIPT:
				Scripts scripts= new Scripts();
				entry.getValue().stream().forEach(k->{
					Script script= new Script();
					script.setType(insertValueGivenConfig(valueofconfig, k));
					String regex=requirement_jaxb.getFields().getScripts().getScript()
							.stream()
							.filter(x -> x.getType().contentEquals(k) && x.getRegex()!=null)
							.map(x-> x.getRegex())
							.findFirst().orElse(null);
					script.setRegex(regex);
					scripts.getScript().add(script);
				});
				scripts.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				f.setScripts(scripts);
				break;
			case Consts.CONTENTWEBPAGES:
				Webpages webpages= new Webpages();
				entry.getValue().stream().forEach(k->{
					WebPage webPage= new WebPage();
					webPage.setType(insertValueGivenConfig(valueofconfig, k));
					String regex=requirement_jaxb.getFields().getWebPages().getWebPage()
							.stream()
							.filter(x -> x.getType().contentEquals(k) && x.getRegex()!=null)
							.map(x-> x.getRegex())
							.findFirst().orElse(null);
					webPage.setRegex(regex);
					webpages.getWebPage().add(webPage);
				});
				webpages.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				f.setWebPages(webpages);
				break;
			case Consts.CONTENTAPPLICATION:
				Applications apps= new Applications();
				entry.getValue().stream().forEach(k->{
					Application app= new Application();
					app.setType(insertValueGivenConfig(valueofconfig, k));
					String regex=requirement_jaxb.getFields().getApplications().getApplication()
							.stream()
							.filter(x -> x.getType().contentEquals(k) && x.getRegex()!=null)
							.map(x-> x.getRegex())
							.findFirst().orElse(null);
					app.setRegex(regex);
					apps.getApplication().add(app);
				});
				apps.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				f.setApplications(apps);
				break;
			case Consts.CONTENTMEDIAS:
				Medias medias= new Medias();
				entry.getValue().stream().forEach(k->{
					Media media= new Media();
					media.setType(insertValueGivenConfig(valueofconfig, k));
					String regex=requirement_jaxb.getFields().getMedias().getMedia()
							.stream()
							.filter(x -> x.getType().contentEquals(k) && x.getRegex()!=null)
							.map(x-> x.getRegex())
							.findFirst().orElse(null);
					media.setRegex(regex);
					medias.getMedia().add(media);
				});
				medias.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				f.setMedias(medias);
				break;
			case Consts.CONTENTADVERTISING:
				Advertisings advs= new Advertisings();
				entry.getValue().stream().forEach(k->{
					Advertising adv= new Advertising();
					adv.setType(insertValueGivenConfig(valueofconfig, k));
					advs.getAdvertising().add(adv);
				});
				advs.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				f.setAdvertisings(advs);
				break;
			case Consts.CONTENTEMAIL:
				Emails emails= new Emails();
				entry.getValue().stream().forEach(k->{
					Email email= new Email();
					email.setType(insertValueGivenConfig(valueofconfig, k));
					emails.getEmail().add(email);
				});
				emails.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				f.setEmails(emails);
				break;
			case Consts.PRIORITY:
				Priority priority= new Priority();
				priority.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				priority.setValue(insertValueGivenConfig(valueofconfig, requirement_jaxb.getFields().getPriority().toString()));
				f.setPriority(priority);
				break;
			case Consts.BODY:
				Body body = new Body();
				body.setContent(insertValueGivenConfig(valueofconfig, requirement_jaxb.getFields().getBody()));
				body.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				f.setBody(body);
				break;
			case Consts.GEOPOSITION:
				Position pos= new Position();
				pos.setCountry(insertValueGivenConfig(valueofconfig, requirement_jaxb.getFields().getGeoPosition().toString()));
				pos.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				f.setGeoPosition(pos);
				break;
			case Consts.BANDWIDTH:
				Bandwidth band= new Bandwidth();
				band.setConfigField(ConfigFieldType.valueOf(valueofconfig));
				band.setValue(insertValueGivenConfig(valueofconfig, requirement_jaxb.getFields().getBandwidth().toString()));
				f.setBandwidth(band);
				break;
			case Consts.DAYS:
				if(f.getDaysAndTimes()==null){
					DaysAndTimesType dtt= new DaysAndTimesType();
					dtt.setTimeZone(requirement_jaxb.getFields().getDaysAndTimes().getTimeZone());
					for(it.polito.verifuse.jaxb.requirementslist.DaysAndTimesType.DayAndTime s: requirement_jaxb.getFields().getDaysAndTimes().getDayAndTime()){
						DayAndTime de = new DayAndTime();
						de.setDay(insertValueGivenConfig(valueofconfig, s.getDay()));
						dtt.getDayAndTime().add(de);
					}
					dtt.setConfigField(ConfigFieldType.valueOf(valueofconfig));
					f.setDaysAndTimes(dtt);
				}else{
					DaysAndTimesType dtt= new DaysAndTimesType();
					dtt.setTimeZone(requirement_jaxb.getFields().getDaysAndTimes().getTimeZone());
					for(it.polito.verifuse.jaxb.requirementslist.DaysAndTimesType.DayAndTime s: requirement_jaxb.getFields().getDaysAndTimes().getDayAndTime()){
						DayAndTime de = new DayAndTime();
						de.setDay(insertValueGivenConfig(valueofconfig, s.getDay()));
						de.setTimeEnd(insertValueGivenConfig(valueofconfig, s.getTimeEnd()));
						de.setTimeStart(insertValueGivenConfig(valueofconfig, s.getTimeStart()));
						dtt.getDayAndTime().add(de);
					}
					dtt.setConfigField(ConfigFieldType.valueOf(valueofconfig));
					f.setDaysAndTimes(dtt);

				}
				break;
			case Consts.TIME:
				if(f.getDaysAndTimes()==null){
					DaysAndTimesType dtt= new DaysAndTimesType();
					dtt.setTimeZone(requirement_jaxb.getFields().getDaysAndTimes().getTimeZone());
					for(it.polito.verifuse.jaxb.requirementslist.DaysAndTimesType.DayAndTime s: requirement_jaxb.getFields().getDaysAndTimes().getDayAndTime()){
						if(s.getTimeStart()!=null &&s.getTimeEnd()!=null ){
							DayAndTime de = new DayAndTime();
							de.setDay("*");
							de.setTimeEnd(insertValueGivenConfig(valueofconfig, s.getTimeEnd()));
							de.setTimeStart(insertValueGivenConfig(valueofconfig, s.getTimeStart()));
							dtt.getDayAndTime().add(de);
						}
					}
					dtt.setConfigField(ConfigFieldType.valueOf(valueofconfig));
					f.setDaysAndTimes(dtt);
				}else{
					DaysAndTimesType dtt= new DaysAndTimesType();
					dtt.setTimeZone(requirement_jaxb.getFields().getDaysAndTimes().getTimeZone());
					for(it.polito.verifuse.jaxb.requirementslist.DaysAndTimesType.DayAndTime s: requirement_jaxb.getFields().getDaysAndTimes().getDayAndTime()){
						DayAndTime de = new DayAndTime();
						de.setDay(insertValueGivenConfig(valueofconfig, s.getDay()));
						de.setTimeEnd(insertValueGivenConfig(valueofconfig, s.getTimeEnd()));
						de.setTimeStart(insertValueGivenConfig(valueofconfig, s.getTimeStart()));
						dtt.getDayAndTime().add(de);
					}
					dtt.setConfigField(ConfigFieldType.valueOf(valueofconfig));
					f.setDaysAndTimes(dtt);

				}
				break; 
			default:
				break;
			}
		}
	}

	


}
