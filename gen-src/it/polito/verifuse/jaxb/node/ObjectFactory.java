//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:18 PM CEST 
//


package it.polito.verifuse.jaxb.node;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.polito.verifuse.jaxb.node package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NodeResponse_QNAME = new QName("http://www.verifuse.polito.it/node", "NodeResponse");
    private final static QName _Node_QNAME = new QName("http://www.verifuse.polito.it/node", "Node");
    private final static QName _Relationship_QNAME = new QName("http://www.verifuse.polito.it/node", "Relationship");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.polito.verifuse.jaxb.node
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NodeResponse }
     * 
     */
    public NodeResponse createNodeResponse() {
        return new NodeResponse();
    }

    /**
     * Create an instance of {@link Node }
     * 
     */
    public Node createNode() {
        return new Node();
    }

    /**
     * Create an instance of {@link Relationship }
     * 
     */
    public Relationship createRelationship() {
        return new Relationship();
    }

    /**
     * Create an instance of {@link NodeResponse.Data }
     * 
     */
    public NodeResponse.Data createNodeResponseData() {
        return new NodeResponse.Data();
    }

    /**
     * Create an instance of {@link NodeResponse.Metadata }
     * 
     */
    public NodeResponse.Metadata createNodeResponseMetadata() {
        return new NodeResponse.Metadata();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.verifuse.polito.it/node", name = "NodeResponse")
    public JAXBElement<NodeResponse> createNodeResponse(NodeResponse value) {
        return new JAXBElement<NodeResponse>(_NodeResponse_QNAME, NodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Node }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.verifuse.polito.it/node", name = "Node")
    public JAXBElement<Node> createNode(Node value) {
        return new JAXBElement<Node>(_Node_QNAME, Node.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Relationship }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.verifuse.polito.it/node", name = "Relationship")
    public JAXBElement<Relationship> createRelationship(Relationship value) {
        return new JAXBElement<Relationship>(_Relationship_QNAME, Relationship.class, null, value);
    }

}
