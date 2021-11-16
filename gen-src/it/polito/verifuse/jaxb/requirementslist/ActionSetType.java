//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:16 PM CEST 
//


package it.polito.verifuse.jaxb.requirementslist;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ActionSetType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ActionSetType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ActionSet" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ActionRequired" type="{http://www.verifuse.polito.it/requirementslist}ActionsReq" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Order" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="Concurrent" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
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
@XmlType(name = "ActionSetType", namespace = "http://www.verifuse.polito.it/requirementslist", propOrder = {
    "actionSet"
})
public class ActionSetType {

    @XmlElement(name = "ActionSet", required = true)
    protected List<ActionSetType.ActionSet> actionSet;

    /**
     * Gets the value of the actionSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actionSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActionSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActionSetType.ActionSet }
     * 
     * 
     */
    public List<ActionSetType.ActionSet> getActionSet() {
        if (actionSet == null) {
            actionSet = new ArrayList<ActionSetType.ActionSet>();
        }
        return this.actionSet;
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
     *         &lt;element name="ActionRequired" type="{http://www.verifuse.polito.it/requirementslist}ActionsReq" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *       &lt;attribute name="Order" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="Concurrent" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "actionRequired"
    })
    public static class ActionSet {

        @XmlElement(name = "ActionRequired", namespace = "http://www.verifuse.polito.it/requirementslist", required = true)
        protected List<ActionsReq> actionRequired;
        @XmlAttribute(name = "Order")
        protected BigInteger order;
        @XmlAttribute(name = "Concurrent")
        protected Boolean concurrent;

        /**
         * Gets the value of the actionRequired property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the actionRequired property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getActionRequired().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ActionsReq }
         * 
         * 
         */
        public List<ActionsReq> getActionRequired() {
            if (actionRequired == null) {
                actionRequired = new ArrayList<ActionsReq>();
            }
            return this.actionRequired;
        }

        /**
         * Recupera il valore della proprietà order.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getOrder() {
            return order;
        }

        /**
         * Imposta il valore della proprietà order.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setOrder(BigInteger value) {
            this.order = value;
        }

        /**
         * Recupera il valore della proprietà concurrent.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isConcurrent() {
            if (concurrent == null) {
                return false;
            } else {
                return concurrent;
            }
        }

        /**
         * Imposta il valore della proprietà concurrent.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setConcurrent(Boolean value) {
            this.concurrent = value;
        }

    }

}
