//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:19 PM CEST 
//


package it.polito.verifuse.jaxb.chainfunctionality;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Actions complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Actions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Action" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="InfoOnAction" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Name_Action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Constraint_Action" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Priority_Action" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="Update_Value" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "Actions", propOrder = {
    "action"
})
public class Actions {

    @XmlElement(name = "Action", required = true)
    protected List<Actions.Action> action;

    /**
     * Gets the value of the action property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the action property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Actions.Action }
     * 
     * 
     */
    public List<Actions.Action> getAction() {
        if (action == null) {
            action = new ArrayList<Actions.Action>();
        }
        return this.action;
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
     *         &lt;element name="InfoOnAction" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="Name_Action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Constraint_Action" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Priority_Action" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="Update_Value" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "infoOnAction"
    })
    public static class Action {

        @XmlElement(name = "InfoOnAction")
        protected List<String> infoOnAction;
        @XmlAttribute(name = "Name_Action", required = true)
        protected String nameAction;
        @XmlAttribute(name = "Constraint_Action")
        protected String constraintAction;
        @XmlAttribute(name = "Priority_Action")
        protected BigInteger priorityAction;
        @XmlAttribute(name = "Update_Value")
        protected String updateValue;

        /**
         * Gets the value of the infoOnAction property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the infoOnAction property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInfoOnAction().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getInfoOnAction() {
            if (infoOnAction == null) {
                infoOnAction = new ArrayList<String>();
            }
            return this.infoOnAction;
        }

        /**
         * Recupera il valore della proprietà nameAction.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNameAction() {
            return nameAction;
        }

        /**
         * Imposta il valore della proprietà nameAction.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNameAction(String value) {
            this.nameAction = value;
        }

        /**
         * Recupera il valore della proprietà constraintAction.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getConstraintAction() {
            return constraintAction;
        }

        /**
         * Imposta il valore della proprietà constraintAction.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setConstraintAction(String value) {
            this.constraintAction = value;
        }

        /**
         * Recupera il valore della proprietà priorityAction.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getPriorityAction() {
            return priorityAction;
        }

        /**
         * Imposta il valore della proprietà priorityAction.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setPriorityAction(BigInteger value) {
            this.priorityAction = value;
        }

        /**
         * Recupera il valore della proprietà updateValue.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUpdateValue() {
            return updateValue;
        }

        /**
         * Imposta il valore della proprietà updateValue.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUpdateValue(String value) {
            this.updateValue = value;
        }

    }

}
