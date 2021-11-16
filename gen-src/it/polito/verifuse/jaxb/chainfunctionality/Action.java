//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.11 alle 08:15:15 PM CEST 
//


package it.polito.verifuse.jaxb.chainfunctionality;

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
 *         &lt;element name="SimpleAction">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ExtraInfo" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Type" type="{http://www.verifuse.polito.it/actions}typeAction" />
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
    "simpleAction"
})
@XmlRootElement(name = "Action", namespace = "http://www.verifuse.polito.it/actions")
public class Action {

    @XmlElement(name = "SimpleAction", namespace = "http://www.verifuse.polito.it/actions", required = true)
    protected Action.SimpleAction simpleAction;

    /**
     * Recupera il valore della proprietà simpleAction.
     * 
     * @return
     *     possible object is
     *     {@link Action.SimpleAction }
     *     
     */
    public Action.SimpleAction getSimpleAction() {
        return simpleAction;
    }

    /**
     * Imposta il valore della proprietà simpleAction.
     * 
     * @param value
     *     allowed object is
     *     {@link Action.SimpleAction }
     *     
     */
    public void setSimpleAction(Action.SimpleAction value) {
        this.simpleAction = value;
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
     *         &lt;element name="ExtraInfo" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="Type" type="{http://www.verifuse.polito.it/actions}typeAction" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "extraInfo"
    })
    public static class SimpleAction {

        @XmlElement(name = "ExtraInfo", namespace = "http://www.verifuse.polito.it/actions")
        protected List<String> extraInfo;
        @XmlAttribute(name = "Type")
        protected TypeAction type;

        /**
         * Gets the value of the extraInfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the extraInfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getExtraInfo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getExtraInfo() {
            if (extraInfo == null) {
                extraInfo = new ArrayList<String>();
            }
            return this.extraInfo;
        }

        /**
         * Recupera il valore della proprietà type.
         * 
         * @return
         *     possible object is
         *     {@link TypeAction }
         *     
         */
        public TypeAction getType() {
            return type;
        }

        /**
         * Imposta il valore della proprietà type.
         * 
         * @param value
         *     allowed object is
         *     {@link TypeAction }
         *     
         */
        public void setType(TypeAction value) {
            this.type = value;
        }

    }

}
