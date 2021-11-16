//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:21 PM CEST 
//


package it.polito.verifuse.jaxb.tools;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GrapghNeo4j">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Enable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="MarshallOnfile">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Enable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OutputOnFile">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Enable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "grapghNeo4J",
    "marshallOnfile",
    "outputOnFile"
})
@XmlRootElement(name = "Tools")
public class Tools {

    @XmlElement(name = "GrapghNeo4j", required = true)
    protected Tools.GrapghNeo4J grapghNeo4J;
    @XmlElement(name = "MarshallOnfile", required = true)
    protected Tools.MarshallOnfile marshallOnfile;
    @XmlElement(name = "OutputOnFile", required = true)
    protected Tools.OutputOnFile outputOnFile;

    /**
     * Recupera il valore della proprietà grapghNeo4J.
     * 
     * @return
     *     possible object is
     *     {@link Tools.GrapghNeo4J }
     *     
     */
    public Tools.GrapghNeo4J getGrapghNeo4J() {
        return grapghNeo4J;
    }

    /**
     * Imposta il valore della proprietà grapghNeo4J.
     * 
     * @param value
     *     allowed object is
     *     {@link Tools.GrapghNeo4J }
     *     
     */
    public void setGrapghNeo4J(Tools.GrapghNeo4J value) {
        this.grapghNeo4J = value;
    }

    /**
     * Recupera il valore della proprietà marshallOnfile.
     * 
     * @return
     *     possible object is
     *     {@link Tools.MarshallOnfile }
     *     
     */
    public Tools.MarshallOnfile getMarshallOnfile() {
        return marshallOnfile;
    }

    /**
     * Imposta il valore della proprietà marshallOnfile.
     * 
     * @param value
     *     allowed object is
     *     {@link Tools.MarshallOnfile }
     *     
     */
    public void setMarshallOnfile(Tools.MarshallOnfile value) {
        this.marshallOnfile = value;
    }

    /**
     * Recupera il valore della proprietà outputOnFile.
     * 
     * @return
     *     possible object is
     *     {@link Tools.OutputOnFile }
     *     
     */
    public Tools.OutputOnFile getOutputOnFile() {
        return outputOnFile;
    }

    /**
     * Imposta il valore della proprietà outputOnFile.
     * 
     * @param value
     *     allowed object is
     *     {@link Tools.OutputOnFile }
     *     
     */
    public void setOutputOnFile(Tools.OutputOnFile value) {
        this.outputOnFile = value;
    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="Enable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class GrapghNeo4J {

        @XmlAttribute(name = "Enable")
        protected Boolean enable;

        /**
         * Recupera il valore della proprietà enable.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isEnable() {
            if (enable == null) {
                return false;
            } else {
                return enable;
            }
        }

        /**
         * Imposta il valore della proprietà enable.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setEnable(Boolean value) {
            this.enable = value;
        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="Enable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class MarshallOnfile {

        @XmlAttribute(name = "Enable")
        protected Boolean enable;

        /**
         * Recupera il valore della proprietà enable.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isEnable() {
            if (enable == null) {
                return false;
            } else {
                return enable;
            }
        }

        /**
         * Imposta il valore della proprietà enable.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setEnable(Boolean value) {
            this.enable = value;
        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="Enable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class OutputOnFile {

        @XmlAttribute(name = "Enable")
        protected Boolean enable;

        /**
         * Recupera il valore della proprietà enable.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isEnable() {
            if (enable == null) {
                return false;
            } else {
                return enable;
            }
        }

        /**
         * Imposta il valore della proprietà enable.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setEnable(Boolean value) {
            this.enable = value;
        }

    }

}
