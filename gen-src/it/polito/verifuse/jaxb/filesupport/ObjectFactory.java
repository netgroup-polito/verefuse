//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:21 PM CEST 
//


package it.polito.verifuse.jaxb.filesupport;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.polito.verifuse.jaxb.filesupport package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.polito.verifuse.jaxb.filesupport
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FileSupport }
     * 
     */
    public FileSupport createFileSupport() {
        return new FileSupport();
    }

    /**
     * Create an instance of {@link FileSupport.Suite }
     * 
     */
    public FileSupport.Suite createFileSupportSuite() {
        return new FileSupport.Suite();
    }

    /**
     * Create an instance of {@link FileSupport.Suite.SupportValue }
     * 
     */
    public FileSupport.Suite.SupportValue createFileSupportSuiteSupportValue() {
        return new FileSupport.Suite.SupportValue();
    }

}
