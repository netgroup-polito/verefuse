//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:19 PM CEST 
//


package it.polito.verifuse.jaxb.chainfunctionality;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Position complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Position">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Country" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ConfigField" type="{http://www.verifuse.polito.it/chainfunctionality}configFieldType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Position")
public class Position {

    @XmlAttribute(name = "Country", required = true)
    protected String country;
    @XmlAttribute(name = "ConfigField")
    protected ConfigFieldType configField;

    /**
     * Recupera il valore della proprietà country.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Imposta il valore della proprietà country.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
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

}
