//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:16 PM CEST 
//


package it.polito.verifuse.jaxb.requirementslist;

import java.math.BigInteger;
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
 *         &lt;element name="Info">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Administrator" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://www.verifuse.polito.it/fields}Fields"/>
 *         &lt;element name="Actions" type="{http://www.verifuse.polito.it/requirementslist}ActionSetType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Req_ID" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "info",
    "fields",
    "actions"
})
@XmlRootElement(name = "Requirement", namespace = "http://www.verifuse.polito.it/requirementslist")
public class Requirement {

    @XmlElement(name = "Info", namespace = "http://www.verifuse.polito.it/requirementslist", required = true)
    protected Requirement.Info info;
    @XmlElement(name = "Fields", required = true)
    protected Fields fields;
    @XmlElement(name = "Actions", namespace = "http://www.verifuse.polito.it/requirementslist", required = true)
    protected ActionSetType actions;
    @XmlAttribute(name = "Req_ID", required = true)
    protected BigInteger reqID;

    /**
     * Recupera il valore della proprietà info.
     * 
     * @return
     *     possible object is
     *     {@link Requirement.Info }
     *     
     */
    public Requirement.Info getInfo() {
        return info;
    }

    /**
     * Imposta il valore della proprietà info.
     * 
     * @param value
     *     allowed object is
     *     {@link Requirement.Info }
     *     
     */
    public void setInfo(Requirement.Info value) {
        this.info = value;
    }

    /**
     * Recupera il valore della proprietà fields.
     * 
     * @return
     *     possible object is
     *     {@link Fields }
     *     
     */
    public Fields getFields() {
        return fields;
    }

    /**
     * Imposta il valore della proprietà fields.
     * 
     * @param value
     *     allowed object is
     *     {@link Fields }
     *     
     */
    public void setFields(Fields value) {
        this.fields = value;
    }

    /**
     * Recupera il valore della proprietà actions.
     * 
     * @return
     *     possible object is
     *     {@link ActionSetType }
     *     
     */
    public ActionSetType getActions() {
        return actions;
    }

    /**
     * Imposta il valore della proprietà actions.
     * 
     * @param value
     *     allowed object is
     *     {@link ActionSetType }
     *     
     */
    public void setActions(ActionSetType value) {
        this.actions = value;
    }

    /**
     * Recupera il valore della proprietà reqID.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getReqID() {
        return reqID;
    }

    /**
     * Imposta il valore della proprietà reqID.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setReqID(BigInteger value) {
        this.reqID = value;
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
     *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Administrator" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "description",
        "administrator"
    })
    public static class Info {

        @XmlElement(name = "Description", namespace = "http://www.verifuse.polito.it/requirementslist", required = true)
        protected String description;
        @XmlElement(name = "Administrator", namespace = "http://www.verifuse.polito.it/requirementslist", required = true)
        protected String administrator;

        /**
         * Recupera il valore della proprietà description.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription() {
            return description;
        }

        /**
         * Imposta il valore della proprietà description.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription(String value) {
            this.description = value;
        }

        /**
         * Recupera il valore della proprietà administrator.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAdministrator() {
            return administrator;
        }

        /**
         * Imposta il valore della proprietà administrator.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAdministrator(String value) {
            this.administrator = value;
        }

    }

}
