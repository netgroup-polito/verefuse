//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:17 PM CEST 
//


package it.polito.verifuse.jaxb.manifestvnfs;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Delay complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Delay">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="unit" use="required" type="{http://www.verifuse.polito.it/manifestvnfs}MaxDelay_Unit" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Delay")
public class Delay {

    @XmlAttribute(name = "value", required = true)
    protected BigInteger value;
    @XmlAttribute(name = "unit", required = true)
    protected MaxDelayUnit unit;

    /**
     * Recupera il valore della proprietà value.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValue() {
        return value;
    }

    /**
     * Imposta il valore della proprietà value.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValue(BigInteger value) {
        this.value = value;
    }

    /**
     * Recupera il valore della proprietà unit.
     * 
     * @return
     *     possible object is
     *     {@link MaxDelayUnit }
     *     
     */
    public MaxDelayUnit getUnit() {
        return unit;
    }

    /**
     * Imposta il valore della proprietà unit.
     * 
     * @param value
     *     allowed object is
     *     {@link MaxDelayUnit }
     *     
     */
    public void setUnit(MaxDelayUnit value) {
        this.unit = value;
    }

}
