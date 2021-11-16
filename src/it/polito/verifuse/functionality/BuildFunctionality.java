package it.polito.verifuse.functionality;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import it.polito.verifuse.utility.classes.ManifestVNF;
import it.polito.verifuse.utility.classes.Requirement;
import it.polito.verifuse.utility.consts.Consts;

public class BuildFunctionality implements Runnable {

	private String name										=null;
	private Requirement requirement							=null;
	private ManifestVNF manifestVNF							=null;
	private ConcurrentHashMap<String, HashSet<String>> p 	=null;
	private ConcurrentHashMap<String, Functionality> sf		=null;

	
	public BuildFunctionality(String name, Requirement requirement, ManifestVNF manifestVNF,
			ConcurrentHashMap<String, HashSet<String>> p ,ConcurrentHashMap<String,Functionality> sf) {
		this.name = name;
		this.requirement = requirement;
		this.manifestVNF = manifestVNF;
		this.p=p;
		this.sf=sf;
	}

	@Override
	public void run() {
		if(this.name==null || this.requirement==null 
				|| this.manifestVNF==null || this.p==null || this.sf==null)
			return;
		//System.out.println(Thread.currentThread().getName()+" (Start) message = "+name);
        processMappingFunctionality();
        //System.out.println(Thread.currentThread().getName()+" (End)");
		
	}

	private void processMappingFunctionality() {
        try {  
        	
        	Map<String, HashSet<String>> resultfield=new HashMap<>();  
        	
        	// try to find field in common between requirment e manifest	
        	HashSet<String> resultfieldcommon = requirement.getFields_requirement().entrySet().stream()
        						.filter(entry -> manifestVNF.getManifest_field().containsKey(entry.getKey()))
        						.map(k-> k.getKey())
								.collect(Collectors.toCollection(HashSet::new));

        	if(resultfieldcommon.isEmpty())
        		return;
        	
        	// verify if for each field can be support the request of requirement - verifico se per ogni campo riesco a supportare le richeste del requisito 
        	for( String s : resultfieldcommon){
        		
        		HashSet<String> f_val_manifest 		= manifestVNF.getManifest_field().get(s);
        		HashSet<String> f_val_requi			= requirement.getFields_requirement().get(s);
        		
        		if(f_val_requi.contains(Consts.STAR) && manifestVNF.getFieldToConfig().get(s).contains(Consts.CONF_DEC))
    				resultfield.put(s, new HashSet<>(Arrays.asList(Consts.STAR)));

        		if(f_val_manifest==null){
        			// aggiunta 
        			if(manifestVNF.getFieldToConfig().get(s).equals(Consts.NOT_CONF_MAKE_DEC))        				
        				resultfield.put(s, new HashSet<>(Arrays.asList(Consts.NOT_CONF_MAKE_DEC)));
        			else if(manifestVNF.getFieldToConfig().get(s).equals(Consts.NOT_CONF_NOT_DEC))
        				resultfield.put(s, new HashSet<>(Arrays.asList(Consts.NOT_CONF_NOT_DEC)));
        			else  // end aggiunta
        				resultfield.put(s, new HashSet<>(f_val_requi));
        		}
        		else{
        			 
        			 HashSet<String> hs = f_val_requi.stream().
        						filter(entry -> f_val_manifest.contains(entry))
        						.collect(Collectors.toCollection(HashSet::new));
        			 
        			if(!hs.isEmpty())
        				resultfield.put(s, hs);
        		}
        	}
        	
        	
        	// Actions in common  Requirement-VNF
        	HashSet<String> resultactions = requirement.getMapActionToOrder().entrySet().stream()
                    			.filter(entry -> manifestVNF.getManifest_action().contains(entry.getKey()))
                    			.map(k-> k.getKey())
                    			.collect(Collectors.toCollection(HashSet::new));
        	if(resultactions.isEmpty())
        		return;       
        	

        	// check constraint - ALLOW
        	if(requirement.isHaveConstraintAllow() && !constraintAllow(manifestVNF.getManifest_action()))
    			return;
        	
        	
        	// date le azioni supportate verifico se quella azione dipende da campi 
        	// se si mi accerto che è in grado saperne configurare al almeno uno. Facendo attenzione se cade in 
        	// un insieme concorrente oppure no.
        	
        	HashSet<String>	actionDipendent=
        	resultactions.stream()
        			.filter(s-> requirement.getMapActionToFieldsP().containsKey(s))
        			.collect(Collectors.toCollection(HashSet::new));
        	
        	
    		for(String v : actionDipendent){
    			HashSet<String> hs=requirement.getMapActionToFieldsP().get(v);
    			if(requirement.getActionsConcurrent().contains(v))
    			{
    				// concorrente - i campi parametrici li deve soddisfare tutti.
    				if(!manifestVNF.getManifest_field().keySet().containsAll(hs))
    					resultactions.remove(v);    	
    			}
    			else{
					for(String s: hs){
						if(manifestVNF.getManifest_field().containsKey(s)){
							//modifica in seguito ad una dipendeza del contenuto dei campi parametrici
							if(manifestVNF.getManifest_field().get(s)!=null){
								if(!manifestVNF.getManifest_field().get(s)
										.containsAll(requirement.getFields_requirement().get(s))){
									resultactions.remove(v);  
								}
							}
	    					break;
						}
					}
				}
			}
    		
        	//riesco a trovare un elemento che non è concorrente ?
        	long haveOneOrMore= resultactions.stream().
        			filter(k-> !requirement.getActionsConcurrent().contains(k))
        			.count();
        	
        	 if(haveOneOrMore<1){
        		// check ulteriore per vedere se ha almeno una coppia di elementi che ricadono nelle azioni concorrenti
            	boolean canBeValid= requirement.getMapActionConcurrent().entrySet().stream()
    					.anyMatch(k-> resultactions.containsAll(k.getValue()));
            	if(!canBeValid)
            		return;
        	}
            
        	 if(resultactions.isEmpty() || resultfieldcommon.isEmpty())
        		 return;  
        	 
        	 //Vuol dire che mi trovo nella situazione in cui 
        	 //uno degli insiemi è vuoto , quindi funzionalità priva di senso
        	 
         	//L'insieme field+actions è chiave 
        	String endString=buildStringFromFunctionality(resultfield, resultactions);
        	
        	p.computeIfPresent(endString, (key,value)-> { 
    				value.add(name);
	        		return value; 
        		});
        	p.putIfAbsent(endString, new HashSet<>(Arrays.asList(name)));
        	
        	sf.computeIfPresent(endString, (key,value)-> { 
    				value.getReferToVnfs().add(name);
	        		return value; 
        		});
        	sf.putIfAbsent(endString, new Functionality(resultfield, resultactions,new HashSet<>(Arrays.asList(name))));
        	
        } catch (Exception e) {
        	e.printStackTrace(); 
		}
    }
	
	private String buildStringFromFunctionality(Map<String, HashSet<String>> resultfield, HashSet<String> resultactions){
    	StringBuffer sb = new StringBuffer();
    	sb.append("Fields={");
    	resultfield.forEach((k, v) -> sb.append(k+" "+v+" "));
    	sb.append("}");
    	sb.append("Actions={");
    	resultactions.forEach((k) -> sb.append(k+" "));
    	sb.append("}");
    	return sb.toString();
	}
	
	private boolean constraintAllow(HashSet<String> set){
		//System.out.println("SONO NEL CONSTRAINT "+set.contains(Consts.CONSTRAINT_ALLOW));
		// manage the case when functionality make the forward traffic between them
		return set.contains(Consts.CONSTRAINT_ALLOW);
	}
}
