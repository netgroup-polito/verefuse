//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:19 PM CEST 
//


package it.polito.verifuse.jaxb.chainfunctionality;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Applications complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Applications">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Application" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Regex" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="ConfigField" type="{http://www.verifuse.polito.it/chainfunctionality}configFieldType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Applications", propOrder = {
    "application"
})
public class Applications {

    @XmlElement(name = "Application", required = true)
    protected List<Applications.Application> application;
    @XmlAttribute(name = "ConfigField")
    protected ConfigFieldType configField;

    /**
     * Gets the value of the application property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the application property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplication().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Applications.Application }
     * 
     * 
     */
    public List<Applications.Application> getApplication() {
        if (application == null) {
            application = new ArrayList<Applications.Application>();
        }
        return this.application;
    }

    /**
     * Recupera il valore della proprietà configField.
     * 
     * @return
     *     possible object is
     *     {@link ConfigFieldType }
     *     
     */
    public ConfigFieldType getConfigField() {
        return configField;
    }

    /**
     * Imposta il valore della proprietà configField.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfigFieldType }
     *     
     */
    public void setConfigField(ConfigFieldType value) {
        this.configField = value;
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
     *       &lt;attribute name="Type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Regex" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Application {

        @XmlAttribute(name = "Type", required = true)
        protected String type;
        @XmlAttribute(name = "Regex")
        protected String regex;

        /**
         * Recupera il valore della proprietà type.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * Imposta il valore della proprietà type.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

        /**
         * Recupera il valore della proprietà regex.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRegex() {
            return regex;
        }

        /**
         * Imposta il valore della proprietà regex.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRegex(String value) {
            this.regex = value;
        }

    }

}
