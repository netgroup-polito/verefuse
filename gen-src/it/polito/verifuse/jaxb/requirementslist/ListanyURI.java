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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per listanyURI complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="listanyURI">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Url" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="URLvalue" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
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
@XmlType(name = "listanyURI", propOrder = {
    "url"
})
public class ListanyURI {

    @XmlElement(name = "Url", required = true)
    protected List<ListanyURI.Url> url;

    /**
     * Gets the value of the url property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the url property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUrl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListanyURI.Url }
     * 
     * 
     */
    public List<ListanyURI.Url> getUrl() {
        if (url == null) {
            url = new ArrayList<ListanyURI.Url>();
        }
        return this.url;
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
     *       &lt;attribute name="URLvalue" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Url {

        @XmlAttribute(name = "URLvalue")
        @XmlSchemaType(name = "anyURI")
        protected String urLvalue;

        /**
         * Recupera il valore della proprietà urLvalue.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getURLvalue() {
            return urLvalue;
        }

        /**
         * Imposta il valore della proprietà urLvalue.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setURLvalue(String value) {
            this.urLvalue = value;
        }

    }

}
