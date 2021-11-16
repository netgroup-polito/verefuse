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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per HardwareInfo complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="HardwareInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CPU" type="{http://www.verifuse.polito.it/manifestvnfs}CPU" minOccurs="0"/>
 *         &lt;element name="RAM" type="{http://www.verifuse.polito.it/manifestvnfs}RAM" minOccurs="0"/>
 *         &lt;element name="Disk" type="{http://www.verifuse.polito.it/manifestvnfs}Disk" minOccurs="0"/>
 *         &lt;element name="Bandwidth" type="{http://www.verifuse.polito.it/manifestvnfs}Bandwidth" minOccurs="0"/>
 *         &lt;element name="Cost" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Delay" type="{http://www.verifuse.polito.it/manifestvnfs}Delay" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HardwareInfo", propOrder = {
    "cpu",
    "ram",
    "disk",
    "bandwidth",
    "cost",
    "delay"
})
public class HardwareInfo {

    @XmlElement(name = "CPU")
    protected CPU cpu;
    @XmlElement(name = "RAM")
    protected RAM ram;
    @XmlElement(name = "Disk")
    protected Disk disk;
    @XmlElement(name = "Bandwidth")
    protected Bandwidth bandwidth;
    @XmlElement(name = "Cost")
    protected BigInteger cost;
    @XmlElement(name = "Delay")
    protected Delay delay;

    /**
     * Recupera il valore della proprietà cpu.
     * 
     * @return
     *     possible object is
     *     {@link CPU }
     *     
     */
    public CPU getCPU() {
        return cpu;
    }

    /**
     * Imposta il valore della proprietà cpu.
     * 
     * @param value
     *     allowed object is
     *     {@link CPU }
     *     
     */
    public void setCPU(CPU value) {
        this.cpu = value;
    }

    /**
     * Recupera il valore della proprietà ram.
     * 
     * @return
     *     possible object is
     *     {@link RAM }
     *     
     */
    public RAM getRAM() {
        return ram;
    }

    /**
     * Imposta il valore della proprietà ram.
     * 
     * @param value
     *     allowed object is
     *     {@link RAM }
     *     
     */
    public void setRAM(RAM value) {
        this.ram = value;
    }

    /**
     * Recupera il valore della proprietà disk.
     * 
     * @return
     *     possible object is
     *     {@link Disk }
     *     
     */
    public Disk getDisk() {
        return disk;
    }

    /**
     * Imposta il valore della proprietà disk.
     * 
     * @param value
     *     allowed object is
     *     {@link Disk }
     *     
     */
    public void setDisk(Disk value) {
        this.disk = value;
    }

    /**
     * Recupera il valore della proprietà bandwidth.
     * 
     * @return
     *     possible object is
     *     {@link Bandwidth }
     *     
     */
    public Bandwidth getBandwidth() {
        return bandwidth;
    }

    /**
     * Imposta il valore della proprietà bandwidth.
     * 
     * @param value
     *     allowed object is
     *     {@link Bandwidth }
     *     
     */
    public void setBandwidth(Bandwidth value) {
        this.bandwidth = value;
    }

    /**
     * Recupera il valore della proprietà cost.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCost() {
        return cost;
    }

    /**
     * Imposta il valore della proprietà cost.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCost(BigInteger value) {
        this.cost = value;
    }

    /**
     * Recupera il valore della proprietà delay.
     * 
     * @return
     *     possible object is
     *     {@link Delay }
     *     
     */
    public Delay getDelay() {
        return delay;
    }

    /**
     * Imposta il valore della proprietà delay.
     * 
     * @param value
     *     allowed object is
     *     {@link Delay }
     *     
     */
    public void setDelay(Delay value) {
        this.delay = value;
    }

}
