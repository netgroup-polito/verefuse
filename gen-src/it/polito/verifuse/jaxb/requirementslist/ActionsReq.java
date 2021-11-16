//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:16 PM CEST 
//


package it.polito.verifuse.jaxb.requirementslist;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ActionsReq complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ActionsReq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FieldsParametric" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Field" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="Ref" use="required" type="{http://www.verifuse.polito.it/fields}ReferField" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Action" use="required" type="{http://www.verifuse.polito.it/actions}typeAction" />
 *       &lt;attribute name="Constraint" type="{http://www.w3.org/2001/XMLSchema}string" default="" />
 *       &lt;attribute name="UpdateValue" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActionsReq", namespace = "http://www.verifuse.polito.it/requirementslist", propOrder = {
    "fieldsParametric"
})
public class ActionsReq {

    @XmlElement(name = "FieldsParametric")
    protected ActionsReq.FieldsParametric fieldsParametric;
    @XmlAttribute(name = "Action", required = true)
    protected TypeAction action;
    @XmlAttribute(name = "Constraint")
    protected String constraint;
    @XmlAttribute(name = "UpdateValue")
    protected String updateValue;

    /**
     * Recupera il valore della proprietà fieldsParametric.
     * 
     * @return
     *     possible object is
     *     {@link ActionsReq.FieldsParametric }
     *     
     */
    public ActionsReq.FieldsParametric getFieldsParametric() {
        return fieldsParametric;
    }

    /**
     * Imposta il valore della proprietà fieldsParametric.
     * 
     * @param value
     *     allowed object is
     *     {@link ActionsReq.FieldsParametric }
     *     
     */
    public void setFieldsParametric(ActionsReq.FieldsParametric value) {
        this.fieldsParametric = value;
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
     * Recupera il valore della proprietà constraint.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConstraint() {
        if (constraint == null) {
            return "";
        } else {
            return constraint;
        }
    }

    /**
     * Imposta il valore della proprietà constraint.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConstraint(String value) {
        this.constraint = value;
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
     *         &lt;element name="Field" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="Ref" use="required" type="{http://www.verifuse.polito.it/fields}ReferField" />
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
        "field"
    })
    public static class FieldsParametric {

        @XmlElement(name = "Field", namespace = "http://www.verifuse.polito.it/requirementslist", required = true)
        protected List<ActionsReq.FieldsParametric.Field> field;

        /**
         * Gets the value of the field property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the field property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getField().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ActionsReq.FieldsParametric.Field }
         * 
         * 
         */
        public List<ActionsReq.FieldsParametric.Field> getField() {
            if (field == null) {
                field = new ArrayList<ActionsReq.FieldsParametric.Field>();
            }
            return this.field;
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
         *       &lt;attribute name="Ref" use="required" type="{http://www.verifuse.polito.it/fields}ReferField" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Field {

            @XmlAttribute(name = "Ref", required = true)
            protected ReferField ref;

            /**
             * Recupera il valore della proprietà ref.
             * 
             * @return
             *     possible object is
             *     {@link ReferField }
             *     
             */
            public ReferField getRef() {
                return ref;
            }

            /**
             * Imposta il valore della proprietà ref.
             * 
             * @param value
             *     allowed object is
             *     {@link ReferField }
             *     
             */
            public void setRef(ReferField value) {
                this.ref = value;
            }

        }

    }

}
