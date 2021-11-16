//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:21 PM CEST 
//


package it.polito.verifuse.jaxb.tools;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.polito.verifuse.jaxb.tools package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.polito.verifuse.jaxb.tools
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Tools }
     * 
     */
    public Tools createTools() {
        return new Tools();
    }

    /**
     * Create an instance of {@link Tools.GrapghNeo4J }
     * 
     */
    public Tools.GrapghNeo4J createToolsGrapghNeo4J() {
        return new Tools.GrapghNeo4J();
    }

    /**
     * Create an instance of {@link Tools.MarshallOnfile }
     * 
     */
    public Tools.MarshallOnfile createToolsMarshallOnfile() {
        return new Tools.MarshallOnfile();
    }

    /**
     * Create an instance of {@link Tools.OutputOnFile }
     * 
     */
    public Tools.OutputOnFile createToolsOutputOnFile() {
        return new Tools.OutputOnFile();
    }

}
