package it.polito.verifuse.neo4j.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.polito.verifuse.jaxb.node.Node;
import it.polito.verifuse.jaxb.node.NodeResponse;
import it.polito.verifuse.jaxb.node.ObjectFactory;
import it.polito.verifuse.jaxb.node.Relationship;
import it.polito.verifuse.utility.exceptions.MyExceptions;

/**
 * This class implements the REST Client for the Neo4J server
 */
public class Neo4jClient {
	private final String SERVER_PATH = "http://localhost:7474";
	private final String NODE_PATH = "http://localhost:7474/db/data/node";
	private final String LABELS_PATH = "/labels";
	private final String RELATIONSHIPS_PATH = "/relationships";
	
	private Client client;			// the Client object
	private WebTarget target;		// the WebTarget of the main resource
	
	private Map<String, NodeResponse> nodes;	// a local map to access created resources
	
	
	/**
	 * Constructor
	 */
	public Neo4jClient()	{
		// create the Client object
		client = ClientBuilder.newClient();
		
		// create a web target for the main URI
		target = client.target(NODE_PATH);
		
		this.nodes = new HashMap<String, NodeResponse>();
	}
	
	/**
	 * Closes the connection.
	 */
	public void close()	{
		client.close();
	}
	
	/**
	 * Performs a POST to create a new node object in the service
	 * and stores the URI and the node object in the local map
	 * @param node the Node object of the resource to be created
	 * @return the URI of the resource created
	 * @throws NullArgumentException 
	 * @throws GeneralException 
	 */
	public URI performPost(Node node, String label) throws MyExceptions.NullArgumentException, MyExceptions.GeneralException {
		if(node == null)	{
			throw new MyExceptions.NullArgumentException("The [Node node] is null");
		}
		try {
			// Check if the node is just posted
			if(nodes.containsKey(node.getName()))	{
				try {
					return new URI(nodes.get(node.getName()).getSelf());
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
			
		    Response response = target.request(MediaType.APPLICATION_JSON)
		    		                   .post(Entity.entity(node, MediaType.APPLICATION_JSON));
			
		    if (response.getStatus()==201) {
		    	System.out.println();
		    	System.out.println("--- Post of " + node.getName() +" executed correctly ---");
	
		    	// Store the Node internally
		    	URI uri = response.getLocation();	
		    	NodeResponse nodeResponse = response.readEntity(NodeResponse.class);
		    	
		    	nodes.put(node.getName(), nodeResponse);
		    	try {
			    	if(label != null)	{
				        URI labelsURI = new URI(SERVER_PATH.concat(uri.getPath()).concat(LABELS_PATH));
				        String jarray = Json.createArrayBuilder().add(label).build().toString();
						List<String> list = new LinkedList<String>();
						list.add(label);
						client.target(labelsURI)
								.request(MediaType.APPLICATION_JSON)
								.post(Entity.json(jarray));
			    	}
			    	return uri;
		    	} catch (URISyntaxException e) {
					e.printStackTrace();
					return uri;
				}
		    } else {
		    	System.out.println("Post failed with status " + response.getStatus());
		    	return null;
		    }  
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new MyExceptions.GeneralException(e.getMessage());
		}
	}
	
	/**
	 * Performs a GET operation given the URI of node object
	 * @param uri  uri od the Node object 
	 * @throws NullArgumentException 
	 * @throws GeneralException 
	 */

	public void performGet(URI uri) throws MyExceptions.NullArgumentException, MyExceptions.GeneralException{
		if(uri == null)	{
			throw new MyExceptions.NullArgumentException("The [URI uri] is null");
		}
		try	{
			// Get the response in json media type as a string (no unmarshalling)
			WebTarget target = client.target(uri);
		    NodeResponse node = target.request(MediaType.APPLICATION_JSON)
		    								.accept(MediaType.APPLICATION_JSON)
		    								.get(NodeResponse.class);
	    	System.out.println();
	    	System.out.println(" --- Response of GET (json media type) as node: --- ");
	    	
	    	System.out.println("Node_Name:" + node.getData().getName());
	    	System.out.println("Node_Label:" + node.getMetadata().getLabels());
	    	System.out.println("Node_Self:" + node.getSelf());
	    	System.out.println("Node_Data:" + node.getData().getElement());
	    	
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new MyExceptions.GeneralException(e.getMessage());
		}
	}

	
	/**
	 * Create relationship between node source and destination
	 * 
	 * @param source node source
	 * @param destination node destination
	 * @return <code>true</code> if success; <code>false</code> otherwise
	 * @throws NullArgumentException 
	 * @throws GeneralException 
	 */
	public boolean createRelationship(String source, String destination, String nameOfRelation) throws MyExceptions.NullArgumentException, MyExceptions.GeneralException {
		if (source==null || destination==null)
			throw new MyExceptions.NullArgumentException("The [String source] nad/or [String destination] is/are null");
		;
		try	{

			NodeResponse nodeSource = nodes.get(source);
			NodeResponse nodeDestination = nodes.get(destination);
		
			
			ObjectFactory obNode = new ObjectFactory();
			Relationship relationship = obNode.createRelationship();
			relationship.setTo(nodeDestination.getSelf());
			relationship.setType(nameOfRelation);
			
			try {
				URI uri = new URI(nodeSource.getSelf());
				client.target(uri)
					  .path(RELATIONSHIPS_PATH)
				 	  .request(MediaType.APPLICATION_JSON_TYPE)
				 	  .post(Entity.json(relationship));		
				return true;
			} catch (URISyntaxException e) {
				return false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new MyExceptions.GeneralException(e.getMessage());
		}
	}
	
	/**
	 * Gets the node by key
	 * 
	 * @param key of the node
	 * @return the node
	 * @throws NullArgumentException 
	 */
	public NodeResponse getNodeByKey(String key) throws MyExceptions.NullArgumentException	{
		if (key==null)
			throw new MyExceptions.NullArgumentException("The [String key] is null");
		
		return nodes.get(key);
	}
	
	/**
	 * Checks if the node is already posted in the server
	 * 
	 * @param key of the node
	 * @return /<cod/e>true/</code/> if present; /<cod/e>false/</code/> otherwise
	 * @throws NullArgumentException 
	 */
	public boolean isPosted(String key) throws MyExceptions.NullArgumentException	{
		if (key==null)
			throw new MyExceptions.NullArgumentException("The [String key] is null");
		;
		return nodes.containsKey(key);
	}

}
