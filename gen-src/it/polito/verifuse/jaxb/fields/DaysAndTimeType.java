//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.03.28 alle 08:17:34 PM CEST 
//


package it.polito.verifuse.jaxb.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per DaysAndTimeType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DaysAndTimeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Day" type="{http://www.verifuse.polito.it/fields}Day"/>
 *         &lt;element name="Timer" type="{http://www.verifuse.polito.it/fields}TimePeriod"/>
 *       &lt;/sequence>
 *       &lt;attribute name="TimeZone" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DaysAndTimeType", propOrder = {
    "day",
    "timer"
})
public class DaysAndTimeType {

    @XmlElement(name = "Day", required = true)
    @XmlSchemaType(name = "string")
    protected Day day;
    @XmlElement(name = "Timer", required = true)
    protected TimePeriod timer;
    @XmlAttribute(name = "TimeZone", required = true)
    protected String timeZone;

    /**
     * Recupera il valore della proprietà day.
     * 
     * @return
     *     possible object is
     *     {@link Day }
     *     
     */
    public Day getDay() {
        return day;
    }

    /**
     * Imposta il valore della proprietà day.
     * 
     * @param value
     *     allowed object is
     *     {@link Day }
     *     
     */
    public void setDay(Day value) {
        this.day = value;
    }

    /**
     * Recupera il valore della proprietà timer.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriod }
     *     
     */
    public TimePeriod getTimer() {
        return timer;
    }

    /**
     * Imposta il valore della proprietà timer.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriod }
     *     
     */
    public void setTimer(TimePeriod value) {
        this.timer = value;
    }

    /**
     * Recupera il valore della proprietà timeZone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * Imposta il valore della proprietà timeZone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeZone(String value) {
        this.timeZone = value;
    }

}
