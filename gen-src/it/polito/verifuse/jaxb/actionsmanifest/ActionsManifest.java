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
 *         &lt;element name="ActionSupport" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Support" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Action" use="required" type="{http://www.verifuse.polito.it/actionsmanifest}typeAction" />
 *                 &lt;attribute name="importSuite" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    "actionSupport"
})
@XmlRootElement(name = "ActionsManifest")
public class ActionsManifest {

    @XmlElement(name = "ActionSupport", required = true)
    protected List<ActionsManifest.ActionSupport> actionSupport;

    /**
     * Gets the value of the actionSupport property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actionSupport property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActionSupport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActionsManifest.ActionSupport }
     * 
     * 
     */
    public List<ActionsManifest.ActionSupport> getActionSupport() {
        if (actionSupport == null) {
            actionSupport = new ArrayList<ActionsManifest.ActionSupport>();
        }
        return this.actionSupport;
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
     *         &lt;element name="Support" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="Action" use="required" type="{http://www.verifuse.polito.it/actionsmanifest}typeAction" />
     *       &lt;attribute name="importSuite" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "support"
    })
    public static class ActionSupport {

        @XmlElement(name = "Support")
        protected List<String> support;
        @XmlAttribute(name = "Action", required = true)
        protected TypeAction action;
        @XmlAttribute(name = "importSuite")
        protected String importSuite;

        /**
         * Gets the value of the support property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the support property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSupport().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getSupport() {
            if (support == null) {
                support = new ArrayList<String>();
            }
            return this.support;
        }

        /**
         * Recupera il valore della proprietà action.
         * 
         * @return
         *     possible object is
         *     {@link TypeAction }
         *     
         */
        public TypeAction getAction() {
            return action;
        }

        /**
         * Imposta il valore della proprietà action.
         * 
         * @param value
         *     allowed object is
         *     {@link TypeAction }
         *     
         */
        public void setAction(TypeAction value) {
            this.action = value;
        }

        /**
         * Recupera il valore della proprietà importSuite.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getImportSuite() {
            return importSuite;
        }

        /**
         * Imposta il valore della proprietà importSuite.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setImportSuite(String value) {
            this.importSuite = value;
        }

    }

}
