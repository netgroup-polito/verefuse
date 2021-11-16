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
 * <p>Classe Java per DaysAndTimesType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DaysAndTimesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DayAndTime" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Day" use="required" type="{http://www.verifuse.polito.it/fields}Day" />
 *                 &lt;attribute name="TimeStart" type="{http://www.verifuse.polito.it/fields}regExrTime" />
 *                 &lt;attribute name="TimeEnd" type="{http://www.verifuse.polito.it/fields}regExrTime" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
@XmlType(name = "DaysAndTimesType", propOrder = {
    "dayAndTime"
})
public class DaysAndTimesType {

    @XmlElement(name = "DayAndTime", required = true)
    protected List<DaysAndTimesType.DayAndTime> dayAndTime;
    @XmlAttribute(name = "TimeZone", required = true)
    protected String timeZone;

    /**
     * Gets the value of the dayAndTime property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dayAndTime property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDayAndTime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DaysAndTimesType.DayAndTime }
     * 
     * 
     */
    public List<DaysAndTimesType.DayAndTime> getDayAndTime() {
        if (dayAndTime == null) {
            dayAndTime = new ArrayList<DaysAndTimesType.DayAndTime>();
        }
        return this.dayAndTime;
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


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="Day" use="required" type="{http://www.verifuse.polito.it/fields}Day" />
     *       &lt;attribute name="TimeStart" type="{http://www.verifuse.polito.it/fields}regExrTime" />
     *       &lt;attribute name="TimeEnd" type="{http://www.verifuse.polito.it/fields}regExrTime" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class DayAndTime {

        @XmlAttribute(name = "Day", required = true)
        protected String day;
        @XmlAttribute(name = "TimeStart")
        protected String timeStart;
        @XmlAttribute(name = "TimeEnd")
        protected String timeEnd;

        /**
         * Recupera il valore della proprietà day.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDay() {
            return day;
        }

        /**
         * Imposta il valore della proprietà day.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDay(String value) {
            this.day = value;
        }

        /**
         * Recupera il valore della proprietà timeStart.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTimeStart() {
            return timeStart;
        }

        /**
         * Imposta il valore della proprietà timeStart.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTimeStart(String value) {
            this.timeStart = value;
        }

        /**
         * Recupera il valore della proprietà timeEnd.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTimeEnd() {
            return timeEnd;
        }

        /**
         * Imposta il valore della proprietà timeEnd.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTimeEnd(String value) {
            this.timeEnd = value;
        }

    }

}
