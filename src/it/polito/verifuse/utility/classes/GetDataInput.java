package it.polito.verifuse.utility.classes;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.sun.tools.xjc.addon.code_injector.Const;

import it.polito.verifuse.jaxb.actionsmanifest.ActionsManifest.ActionSupport;
import it.polito.verifuse.jaxb.chainfunctionality.DaysAndTimesType.DayAndTime;
import it.polito.verifuse.jaxb.fieldsmanifest.SupportType;
import it.polito.verifuse.jaxb.filesupport.FileSupport;
import it.polito.verifuse.jaxb.manifestvnfs.ManifestVNFs.ManifestVNF;
import it.polito.verifuse.jaxb.manifestvnfs.TypeAction;
import it.polito.verifuse.jaxb.requirementslist.ActionSetType.ActionSet;
import it.polito.verifuse.jaxb.requirementslist.ActionsReq;
import it.polito.verifuse.jaxb.requirementslist.ReferField;
import it.polito.verifuse.jaxb.requirementslist.Requirement;
import it.polito.verifuse.jaxb.requirementslist.VersionOfIp;
import it.polito.verifuse.utility.consts.Consts;

public class GetDataInput {

	/**
	 * Constructor for GetDataInput class
	 * 
	*/
	public GetDataInput() {
		
	}
	/**
	 * Retrive all data necessary given the requirement 
	 * @param requirement
	 * @return requirement object, otherwise null object
	*/
	public it.polito.verifuse.utility.classes.Requirement getData(Requirement requirement){
		if(requirement==null)
			return null;
		try{
			int id=	Integer.parseInt(requirement.getReqID().toString());
	
			/**
			 * RETRIVE INFO ABOUT FIELDS INVOLVED INSIDE REQUIREMENTS
			 */
			Map<String,HashSet<String>> fields= manageFieldReq(requirement.getFields());
			if(fields==null)
				return null;
			
			/**
			 * RETRIVE INFO ABOUT ACTIONS INVOLVED INSIDE REQUIREMENTS
			 */
			Map<String, HashSet<String>> mapActionToFieldsP 			= new HashMap<>();
			Map<String, BigInteger> mapActionToOrder 					= new HashMap<>();
			Map<BigInteger, HashSet<String>> mapActionConcurrent 		= new HashMap<>();
			HashSet<String> actionConcurrent 							= new HashSet<>();
	
			int n_negative=-1;
			for(ActionSet a: requirement.getActions().getActionSet()){
				if(a.isConcurrent()==false && a.getActionRequired().size()>1)  // check is well formed 
					return null;
				
				BigInteger orderVal=a.getOrder()==null?BigInteger.valueOf(n_negative--):a.getOrder();
				
				
				if(a.isConcurrent()){
					HashSet<String> hs =a.getActionRequired()
							.stream()
							.map(k-> {
								if(k.getConstraint().isEmpty())
									return k.getAction().toString();
								else
									return k.getConstraint()+":"+k.getConstraint();
							})
							.collect(Collectors.toCollection(HashSet::new));
					mapActionConcurrent.put(orderVal, hs);
					actionConcurrent.addAll(hs);
				}	
				
				for(ActionsReq ar: a.getActionRequired()){
					
					String constraint = "";
					if(!ar.getConstraint().isEmpty())
						constraint=":"+ar.getConstraint();
					
					if(ar.getFieldsParametric()!=null){
						mapActionToFieldsP.put(ar.getAction().toString()+constraint,
								ar.getFieldsParametric().getField().stream().
								map(k->k.getRef().toString()).
								collect(Collectors.toCollection(HashSet::new)));
					}
					mapActionToOrder.put(ar.getAction().toString()+constraint,orderVal); 
				}
			}
			return new it.polito.verifuse.utility.classes.Requirement(fields, 
					mapActionToFieldsP, 
					mapActionToOrder,
					id, 
					mapActionConcurrent,
					actionConcurrent,n_negative<-1?true:false);

		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Retrive all data necessary given the single vnf 
	 * @param vnf
	 * @return vnf object, otherwise null 
	*/

	public it.polito.verifuse.utility.classes.ManifestVNF getData(ManifestVNF vnf){
		if(vnf==null)
			return null;
		try{
		Map<String, HashSet<String>> manifest_field= new HashMap<>();
		Map<String, String> fieldToConfig= new HashMap<>();
		HashSet<String> manifest_action=null;
		Unmarshaller m= new Unmarshaller();
		HashMap<String, List<String>> fs= m.unmarshallFileSupport(Consts.PATH_XML_FILESUPPORT, Consts.PACKAGE_FILESUPPORT);


		for( it.polito.verifuse.jaxb.manifestvnfs.FieldsManifest.Field f : vnf.getManifestInfo().getFieldsManifest().getField()){
			
			if(f.getType().toString().equals(Consts.DAYSANDTIMES)){
				if(f.getSupports()!=null){
					for(String s:f.getSupports().getSupport() ){
						manifest_field.put(s.toUpperCase(), null);
					}
				}
				else{
					manifest_field.put(Consts.DAYS, null);
					manifest_field.put(Consts.TIME, null);
				}
				fieldToConfig.put(Consts.DAYS, f.getTypeConfig().toString());
				fieldToConfig.put(Consts.TIME, f.getTypeConfig().toString());

			}else{
				if(f.getSupports()!=null){
						manifest_field.put(f.getType().toString().toUpperCase(), 
								f.getSupports().getSupport()
								.stream()
								.map(k-> k.toUpperCase())
								.collect(Collectors.toCollection(HashSet::new)));
				}else{
					manifest_field.put(f.getType().toString().toUpperCase(),null);
				}
				
				// manage the import suite for field support
				if(f.getImportSuite()!=null && fs.get(f.getImportSuite())!=null){
					if(manifest_field.get(f.getType().toString().toUpperCase())==null)
						manifest_field.put(f.getType().toString().toUpperCase(),new HashSet<>(fs.get(f.getImportSuite())));
					else
						manifest_field.get(f.getType().toString().toUpperCase()).addAll(fs.get(f.getImportSuite()));
				}
				
				fieldToConfig.put(f.getType().toString(), f.getTypeConfig().toString());				
			}
		}
		// read the xml file for support action constraint

		manifest_action= new HashSet<>();
		for(it.polito.verifuse.jaxb.manifestvnfs.ActionsManifest.ActionSupport as :vnf.getManifestInfo().getActionsManifest().getActionSupport()){
			
			// add constraint on action from xml file
			if(as.getImportSuite()!=null && fs.get(as.getImportSuite())!=null){
				for(String a :fs.get(as.getImportSuite())){
					manifest_action.add(as.getAction().toString()+":"+a);
				}
			}
			
			if(as.getSupport().isEmpty())
				manifest_action.add(as.getAction().toString());
			else{
				for(String s: as.getSupport())
					manifest_action.add(as.getAction().toString()+":"+s);
				manifest_action.add(as.getAction().toString());
			}
		}
		
		return new it.polito.verifuse.utility.classes.ManifestVNF(vnf.getManifestID(),
				manifest_field,
				manifest_action,
				vnf.getDescription(), 
				vnf.getGeneralInfo()==null?null:vnf.getGeneralInfo(), 
				vnf.getSoftwareInfo()==null?null:vnf.getSoftwareInfo(), 
				vnf.getHardwareInfo()==null?null:vnf.getHardwareInfo(),
				fieldToConfig);
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	private Map<String,HashSet<String>> manageFieldReq(it.polito.verifuse.jaxb.requirementslist.Fields f){
		if(f==null)
			return null;
		try{
			Map<String,HashSet<String>> fields = new HashMap<>();
			HashSet<String> hs= new HashSet<>();
			//IP SRC
			if( f.getIpSrc() != null){
				hs=new HashSet<>();
				if(f.getIpSrc().getAddress().toString().contentEquals(Consts.STAR ))
					hs.add(Consts.STAR);
				else
					hs.add(f.getIpSrc().getAddress().toString());
				if(f.getIpSrc().getVersion().equals(VersionOfIp.IPV_4))
					fields.put(Consts.IPSRC_v4, hs);
				else
					fields.put(Consts.IPSRC_v6, hs);
			}
			//IP DST
			if( f.getIpDst() != null){
				hs=new HashSet<>();
				if(f.getIpDst().getAddress().toString().contentEquals(Consts.STAR ))
					hs.add(Consts.STAR);
				else
					hs.add(f.getIpDst().getAddress().toString());
				
				if(f.getIpDst().getVersion().equals(VersionOfIp.IPV_4))
					fields.put(Consts.IPDST_v4, hs);
				else
					fields.put(Consts.IPDST_v6, hs);

			}
			//PORT SRC
			if( f.getPortSrc() != null){
				hs=new HashSet<>();
				if(f.getPortSrc().getRange().toString().contentEquals(Consts.STAR ))
					hs.add(Consts.STAR);
				else
					hs.add(f.getPortSrc().getRange().toString());
				fields.put(Consts.PORTSRC, hs);
			}
			//PORT DST
			if( f.getPortDst() != null){
				hs=new HashSet<>();
				if(f.getPortDst().getRange().toString().contentEquals(Consts.STAR ))
					hs.add(Consts.STAR);
				else
					hs.add(f.getPortDst().getRange().toString());
				fields.put(Consts.PORTDST, hs);
			}
			//PROTOCOLL
			if( f.getProto() != null){
				hs=new HashSet<>();
				if(f.getProto().getTypeProtocol().toString().contentEquals(Consts.STAR ))
					hs.add(Consts.STAR);
				else
					hs.add(f.getProto().getTypeProtocol().toString());
				fields.put(Consts.PROTOCOL, hs);
			}
			//URL
			if( f.getUrls() != null){
				hs=new HashSet<>();
				if(f.getUrls().getUrl().stream().anyMatch(k -> k.getURLvalue().toString().contentEquals(Consts.STAR)))
					hs.add(Consts.STAR);
				else
					hs.addAll(f.getUrls().getUrl().stream().map(k-> k.getURLvalue()).collect(Collectors.toSet()));
				fields.put(Consts.URLS, hs);
			}
			//DOMAINS
			if( f.getDomains() != null){
				hs=new HashSet<>();
				if(f.getDomains().getDomain().stream().anyMatch(k -> k.getDomainValue().toString().contentEquals(Consts.STAR)))
					hs.add(Consts.STAR);
				else
					hs.addAll(f.getDomains().getDomain().stream().map(k-> k.getDomainValue()).collect(Collectors.toSet()));
				fields.put(Consts.DOMAINS, hs);
			}
			//DAYS AND TIME
			if( f.getDaysAndTimes() != null){
				int size = f.getDaysAndTimes().getDayAndTime().size();
				long count_both_star=0;
				long count_day_star=0;
				long count_time_star=0;
				for(it.polito.verifuse.jaxb.requirementslist.DaysAndTimesType.DayAndTime k: f.getDaysAndTimes().getDayAndTime()){
					if(k.getDay().contains(Consts.STAR) && k.getTimeStart()==null && k.getTimeEnd()==null)
						count_both_star++;
					if(k.getDay().contains(Consts.STAR) && k.getTimeStart()!=null && k.getTimeEnd()!=null)
						count_day_star++;
					if(!k.getDay().contains(Consts.STAR) && k.getTimeStart()==null && k.getTimeEnd()==null)
						count_time_star++;
				}
				hs=new HashSet<>();
				if(size==count_both_star){					
					hs.add(Consts.STAR);
					fields.put(Consts.DAYS, hs);
					fields.put(Consts.TIME, hs);
				}else if(size==count_day_star){
					hs.add(Consts.STAR);
					fields.put(Consts.DAYS, hs);
					List<String> lst=f.getDaysAndTimes().getDayAndTime().stream()
							.filter(k-> k.getTimeStart()!=null)
							.filter(k-> k.getTimeEnd()!=null)
							.map(k-> k.getDay()+";"+ k.getTimeStart()+";"+k.getTimeEnd())
							.collect(Collectors.toList());
					fields.put(Consts.TIME, new HashSet<>(lst));
				}else if(size==count_time_star){
					hs.add(Consts.STAR);
					List<String> ls=f.getDaysAndTimes().getDayAndTime().stream()
							.filter(k-> !k.getDay().contains(Consts.STAR))
							.map(k-> k.getDay())
							.collect(Collectors.toList());				
					fields.put(Consts.DAYS, new HashSet<>(ls));
					fields.put(Consts.TIME, hs);
				}else{
					List<String> ls=f.getDaysAndTimes().getDayAndTime().stream()
							.map(k-> k.getDay())
							.collect(Collectors.toList());				
					List<String> lst=f.getDaysAndTimes().getDayAndTime().stream()
							.filter(k-> k.getTimeStart()!=null)
							.filter(k-> k.getTimeEnd()!=null)
							.map(k-> k.getDay()+";"+ k.getTimeStart()+";"+k.getTimeEnd())
							.collect(Collectors.toList());
					fields.put(Consts.DAYS, new HashSet<>(ls));
					fields.put(Consts.TIME, new HashSet<>(lst));

				}
			}
			//DOCUMENTS
			if( f.getDocuments() != null){
				hs=new HashSet<>();
				if(f.getDocuments().getDocument().toString().contentEquals(Consts.STAR))
					hs.add(Consts.STAR);
				else
					hs.addAll(f.getDocuments().getDocument().stream()
							.map(k-> k.getType())
							.collect(Collectors.toList()));
				fields.put(Consts.CONTENTDOCUMENT, hs);
			}
			//SCRIPT
			if( f.getScripts() != null){
				hs=new HashSet<>();
				if(f.getScripts().getScript().toString().contentEquals(Consts.STAR))
					hs.add(Consts.STAR);
				else
					hs.addAll(f.getScripts().getScript().stream()
							.map(k-> k.getType())
							.collect(Collectors.toList()));
				fields.put(Consts.CONTENTSCRIPT, hs);
			}
			//WebPages
			if( f.getWebPages() != null){
				hs=new HashSet<>();
				if(f.getWebPages().getWebPage().toString().contentEquals(Consts.STAR))
					hs.add(Consts.STAR);
				else
					hs.addAll(f.getWebPages().getWebPage().stream()
							.map(k-> k.getType())
							.collect(Collectors.toList()));
				fields.put(Consts.CONTENTWEBPAGES, hs);
			}
			//APPLICATION
			if( f.getApplications() != null){
				hs=new HashSet<>();
				if(f.getApplications().getApplication().toString().contentEquals(Consts.STAR))
					hs.add(Consts.STAR);
				else
					hs.addAll(f.getApplications().getApplication().stream()
							.map(k-> k.getType())
							.collect(Collectors.toList()));
				fields.put(Consts.CONTENTAPPLICATION, hs);
			}
			//MEDIAS
			if( f.getMedias() != null){
				hs=new HashSet<>();
				if(f.getMedias().getMedia().toString().contentEquals(Consts.STAR))
					hs.add(Consts.STAR);
				else
					hs.addAll(f.getMedias().getMedia().stream()
							.map(k-> k.getType())
							.collect(Collectors.toList()));
				fields.put(Consts.CONTENTMEDIAS, hs);
			}
			//ADVERTISING 		
			if( f.getAdvertisings() != null){
				hs=new HashSet<>();
				if(f.getAdvertisings().getAdvertising().toString().contentEquals(Consts.STAR))
					hs.add(Consts.STAR);
				else
					hs.addAll(f.getAdvertisings().getAdvertising().stream()
							.map(k-> k.getType())
							.collect(Collectors.toList()));
				fields.put(Consts.CONTENTADVERTISING, hs);
			}
			//EMAIlS
			if( f.getEmails() != null){
				hs=new HashSet<>();
				if(f.getEmails().getEmail().toString().contentEquals(Consts.STAR))
					hs.add(Consts.STAR);
				else
					hs.addAll(f.getEmails().getEmail().stream()
							.map(k-> k.getType())
							.collect(Collectors.toList()));
				fields.put(Consts.CONTENTEMAIL, hs);
			}
			//PRIORITY
			if( f.getPriority() != null){
				hs=new HashSet<>();
				if(f.getPriority().toString().contentEquals(Consts.STAR))
					hs.add(Consts.STAR);
				else
					hs.add(f.getPriority().toString());
				fields.put(Consts.PRIORITY, hs);
			}
			//Bandwidth
			if( f.getBandwidth() != null){
				hs=new HashSet<>();
				if(f.getBandwidth().toString().contentEquals(Consts.STAR))
					hs.add(Consts.STAR);
				else
					hs.add(f.getBandwidth().toString());
				fields.put(Consts.BANDWIDTH, hs);
			}
			//Body
			if( f.getBody() != null){
				hs=new HashSet<>();
				if(f.getBody().toString().contentEquals(Consts.STAR))
					hs.add(Consts.STAR);
				else
					hs.add(f.getBody().toString());
				fields.put(Consts.BODY, hs);
			}
			//Geoposition
			if( f.getGeoPosition() != null){
				hs=new HashSet<>();
				if(f.getGeoPosition().getCountry().toString().contentEquals(Consts.STAR))
					hs.add(Consts.STAR);
				else
					hs.add(f.getGeoPosition().getCountry().toString());
				fields.put(Consts.GEOPOSITION, hs);
			}
			// Displace
			if( f.getDisplace() != null){
				hs=new HashSet<>();
				if(f.getDisplace().toString().contentEquals(Consts.STAR))
					hs.add(Consts.STAR);
				else
					hs.add(f.getDisplace().toString());
				fields.put(Consts.DISPLACE, hs);
			}
			//REMARK FIELD
			if( f.getRemarkField() != null){
				hs=new HashSet<>();
				hs.add(f.getRemarkField().getFieldName().toString());
				fields.put(Consts.REMARKFIELD, hs);
			}
			//VLAN TAG -  FIELD
			if( f.getVlanTag() != null){
				hs=new HashSet<>();
				hs.add(f.getVlanTag().toString());
				fields.put(Consts.VLANTAG, hs);
			}

			return fields;

		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
