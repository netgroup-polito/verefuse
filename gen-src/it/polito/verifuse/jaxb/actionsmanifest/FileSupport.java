//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:13 PM CEST 
//


package it.polito.verifuse.jaxb.actionsmanifest;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="Suite" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SupportValue" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="NameSuite" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    "suite"
})
@XmlRootElement(name = "fileSupport", namespace = "http://www.verifuse.polito.it/filesupport")
public class FileSupport {

    @XmlElement(name = "Suite", namespace = "http://www.verifuse.polito.it/filesupport")
    protected List<FileSupport.Suite> suite;

    /**
     * Gets the value of the suite property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the suite property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSuite().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FileSupport.Suite }
     * 
     * 
     */
    public List<FileSupport.Suite> getSuite() {
        if (suite == null) {
            suite = new ArrayList<FileSupport.Suite>();
        }
        return this.suite;
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
     *       &lt;sequence>
     *         &lt;element name="SupportValue" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="NameSuite" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "supportValue"
    })
    public static class Suite {

        @XmlElement(name = "SupportValue", namespace = "http://www.verifuse.polito.it/filesupport", required = true)
        protected List<FileSupport.Suite.SupportValue> supportValue;
        @XmlAttribute(name = "NameSuite", required = true)
        protected String nameSuite;

        /**
         * Gets the value of the supportValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the supportValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSupportValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FileSupport.Suite.SupportValue }
         * 
         * 
         */
        public List<FileSupport.Suite.SupportValue> getSupportValue() {
            if (supportValue == null) {
                supportValue = new ArrayList<FileSupport.Suite.SupportValue>();
            }
            return this.supportValue;
        }

        /**
         * Recupera il valore della proprietà nameSuite.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNameSuite() {
            return nameSuite;
        }

        /**
         * Imposta il valore della proprietà nameSuite.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNameSuite(String value) {
            this.nameSuite = value;
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
         *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class SupportValue {

            @XmlAttribute(name = "value", required = true)
            protected String value;

            /**
             * Recupera il valore della proprietà value.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Imposta il valore della proprietà value.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

        }

    }

}
