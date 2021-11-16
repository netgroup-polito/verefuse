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
 *         &lt;element name="IpSrc" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Version" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Address" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="ConfigField" type="{http://www.verifuse.polito.it/chainfunctionality}configFieldType" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="IpDst" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Version" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Address" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="ConfigField" type="{http://www.verifuse.polito.it/chainfunctionality}configFieldType" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PortSrc" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Range" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="RangeSetting" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="ConfigField" type="{http://www.verifuse.polito.it/chainfunctionality}configFieldType" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PortDst" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Range" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="RangeSetting" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="ConfigField" type="{http://www.verifuse.polito.it/chainfunctionality}configFieldType" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Proto" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="TypeProtocol" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="ConfigField" type="{http://www.verifuse.polito.it/chainfunctionality}configFieldType" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Urls" type="{http://www.verifuse.polito.it/chainfunctionality}listanyURI" minOccurs="0"/>
 *         &lt;element name="Domains" type="{http://www.verifuse.polito.it/chainfunctionality}DomainlistanyURI" minOccurs="0"/>
 *         &lt;element name="VlanTag" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="ConfigField" type="{http://www.verifuse.polito.it/chainfunctionality}configFieldType" />
 *                 &lt;attribute name="Tag" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DaysAndTimes" type="{http://www.verifuse.polito.it/chainfunctionality}DaysAndTimesType" minOccurs="0"/>
 *         &lt;element name="Documents" type="{http://www.verifuse.polito.it/chainfunctionality}Documents" minOccurs="0"/>
 *         &lt;element name="Scripts" type="{http://www.verifuse.polito.it/chainfunctionality}Scripts" minOccurs="0"/>
 *         &lt;element name="WebPages" type="{http://www.verifuse.polito.it/chainfunctionality}Webpages" minOccurs="0"/>
 *         &lt;element name="Applications" type="{http://www.verifuse.polito.it/chainfunctionality}Applications" minOccurs="0"/>
 *         &lt;element name="Medias" type="{http://www.verifuse.polito.it/chainfunctionality}Medias" minOccurs="0"/>
 *         &lt;element name="Advertisings" type="{http://www.verifuse.polito.it/chainfunctionality}Advertisings" minOccurs="0"/>
 *         &lt;element name="Emails" type="{http://www.verifuse.polito.it/chainfunctionality}Emails" minOccurs="0"/>
 *         &lt;element name="Priority" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="ConfigField" type="{http://www.verifuse.polito.it/chainfunctionality}configFieldType" />
 *                 &lt;attribute name="Value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Body" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="ConfigField" type="{http://www.verifuse.polito.it/chainfunctionality}configFieldType" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="GeoPosition" type="{http://www.verifuse.polito.it/chainfunctionality}Position" minOccurs="0"/>
 *         &lt;element name="Bandwidth" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="ConfigField" type="{http://www.verifuse.polito.it/chainfunctionality}configFieldType" />
 *                 &lt;attribute name="Value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    "ipSrc",
    "ipDst",
    "portSrc",
    "portDst",
    "proto",
    "urls",
    "domains",
    "vlanTag",
    "daysAndTimes",
    "documents",
    "scripts",
    "webPages",
    "applications",
    "medias",
    "advertisings",
    "emails",
    "priority",
    "body",
    "geoPosition",
    "bandwidth"
})
@XmlRootElement(name = "Fields")
public class Fields {

    @XmlElement(name = "IpSrc")
    protected Fields.IpSrc ipSrc;
    @XmlElement(name = "IpDst")
    protected Fields.IpDst ipDst;
    @XmlElement(name = "PortSrc")
    protected Fields.PortSrc portSrc;
    @XmlElement(name = "PortDst")
    protected Fields.PortDst portDst;
    @XmlElement(name = "Proto")
    protected Fields.Proto proto;
    @XmlElement(name = "Urls")
    protected ListanyURI urls;
    @XmlElement(name = "Domains")
    protected DomainlistanyURI domains;
    @XmlElement(name = "VlanTag")
    protected Fields.VlanTag vlanTag;
    @XmlElement(name = "DaysAndTimes")
    protected DaysAndTimesType daysAndTimes;
    @XmlElement(name = "Documents")
    protected Documents documents;
    @XmlElement(name = "Scripts")
    protected Scripts scripts;
    @XmlElement(name = "WebPages")
    protected Webpages webPages;
    @XmlElement(name = "Applications")
    protected Applications applications;
    @XmlElement(name = "Medias")
    protected Medias medias;
    @XmlElement(name = "Advertisings")
    protected Advertisings advertisings;
    @XmlElement(name = "Emails")
    protected Emails emails;
    @XmlElement(name = "Priority")
    protected Fields.Priority priority;
    @XmlElement(name = "Body")
    protected Fields.Body body;
    @XmlElement(name = "GeoPosition")
    protected Position geoPosition;
    @XmlElement(name = "Bandwidth")
    protected Fields.Bandwidth bandwidth;

    /**
     * Recupera il valore della proprietà ipSrc.
     * 
     * @return
     *     possible object is
     *     {@link Fields.IpSrc }
     *     
     */
    public Fields.IpSrc getIpSrc() {
        return ipSrc;
    }

    /**
     * Imposta il valore della proprietà ipSrc.
     * 
     * @param value
     *     allowed object is
     *     {@link Fields.IpSrc }
     *     
     */
    public void setIpSrc(Fields.IpSrc value) {
        this.ipSrc = value;
    }

    /**
     * Recupera il valore della proprietà ipDst.
     * 
     * @return
     *     possible object is
     *     {@link Fields.IpDst }
     *     
     */
    public Fields.IpDst getIpDst() {
        return ipDst;
    }

    /**
     * Imposta il valore della proprietà ipDst.
     * 
     * @param value
     *     allowed object is
     *     {@link Fields.IpDst }
     *     
     */
    public void setIpDst(Fields.IpDst value) {
        this.ipDst = value;
    }

    /**
     * Recupera il valore della proprietà portSrc.
     * 
     * @return
     *     possible object is
     *     {@link Fields.PortSrc }
     *     
     */
    public Fields.PortSrc getPortSrc() {
        return portSrc;
    }

    /**
     * Imposta il valore della proprietà portSrc.
     * 
     * @param value
     *     allowed object is
     *     {@link Fields.PortSrc }
     *     
     */
    public void setPortSrc(Fields.PortSrc value) {
        this.portSrc = value;
    }

    /**
     * Recupera il valore della proprietà portDst.
     * 
     * @return
     *     possible object is
     *     {@link Fields.PortDst }
     *     
     */
    public Fields.PortDst getPortDst() {
        return portDst;
    }

    /**
     * Imposta il valore della proprietà portDst.
     * 
     * @param value
     *     allowed object is
     *     {@link Fields.PortDst }
     *     
     */
    public void setPortDst(Fields.PortDst value) {
        this.portDst = value;
    }

    /**
     * Recupera il valore della proprietà proto.
     * 
     * @return
     *     possible object is
     *     {@link Fields.Proto }
     *     
     */
    public Fields.Proto getProto() {
        return proto;
    }

    /**
     * Imposta il valore della proprietà proto.
     * 
     * @param value
     *     allowed object is
     *     {@link Fields.Proto }
     *     
     */
    public void setProto(Fields.Proto value) {
        this.proto = value;
    }

    /**
     * Recupera il valore della proprietà urls.
     * 
     * @return
     *     possible object is
     *     {@link ListanyURI }
     *     
     */
    public ListanyURI getUrls() {
        return urls;
    }

    /**
     * Imposta il valore della proprietà urls.
     * 
     * @param value
     *     allowed object is
     *     {@link ListanyURI }
     *     
     */
    public void setUrls(ListanyURI value) {
        this.urls = value;
    }

    /**
     * Recupera il valore della proprietà domains.
     * 
     * @return
     *     possible object is
     *     {@link DomainlistanyURI }
     *     
     */
    public DomainlistanyURI getDomains() {
        return domains;
    }

    /**
     * Imposta il valore della proprietà domains.
     * 
     * @param value
     *     allowed object is
     *     {@link DomainlistanyURI }
     *     
     */
    public void setDomains(DomainlistanyURI value) {
        this.domains = value;
    }

    /**
     * Recupera il valore della proprietà vlanTag.
     * 
     * @return
     *     possible object is
     *     {@link Fields.VlanTag }
     *     
     */
    public Fields.VlanTag getVlanTag() {
        return vlanTag;
    }

    /**
     * Imposta il valore della proprietà vlanTag.
     * 
     * @param value
     *     allowed object is
     *     {@link Fields.VlanTag }
     *     
     */
    public void setVlanTag(Fields.VlanTag value) {
        this.vlanTag = value;
    }

    /**
     * Recupera il valore della proprietà daysAndTimes.
     * 
     * @return
     *     possible object is
     *     {@link DaysAndTimesType }
     *     
     */
    public DaysAndTimesType getDaysAndTimes() {
        return daysAndTimes;
    }

    /**
     * Imposta il valore della proprietà daysAndTimes.
     * 
     * @param value
     *     allowed object is
     *     {@link DaysAndTimesType }
     *     
     */
    public void setDaysAndTimes(DaysAndTimesType value) {
        this.daysAndTimes = value;
    }

    /**
     * Recupera il valore della proprietà documents.
     * 
     * @return
     *     possible object is
     *     {@link Documents }
     *     
     */
    public Documents getDocuments() {
        return documents;
    }

    /**
     * Imposta il valore della proprietà documents.
     * 
     * @param value
     *     allowed object is
     *     {@link Documents }
     *     
     */
    public void setDocuments(Documents value) {
        this.documents = value;
    }

    /**
     * Recupera il valore della proprietà scripts.
     * 
     * @return
     *     possible object is
     *     {@link Scripts }
     *     
     */
    public Scripts getScripts() {
        return scripts;
    }

    /**
     * Imposta il valore della proprietà scripts.
     * 
     * @param value
     *     allowed object is
     *     {@link Scripts }
     *     
     */
    public void setScripts(Scripts value) {
        this.scripts = value;
    }

    /**
     * Recupera il valore della proprietà webPages.
     * 
     * @return
     *     possible object is
     *     {@link Webpages }
     *     
     */
    public Webpages getWebPages() {
        return webPages;
    }

    /**
     * Imposta il valore della proprietà webPages.
     * 
     * @param value
     *     allowed object is
     *     {@link Webpages }
     *     
     */
    public void setWebPages(Webpages value) {
        this.webPages = value;
    }

    /**
     * Recupera il valore della proprietà applications.
     * 
     * @return
     *     possible object is
     *     {@link Applications }
     *     
     */
    public Applications getApplications() {
        return applications;
    }

    /**
     * Imposta il valore della proprietà applications.
     * 
     * @param value
     *     allowed object is
     *     {@link Applications }
     *     
     */
    public void setApplications(Applications value) {
        this.applications = value;
    }

    /**
     * Recupera il valore della proprietà medias.
     * 
     * @return
     *     possible object is
     *     {@link Medias }
     *     
     */
    public Medias getMedias() {
        return medias;
    }

    /**
     * Imposta il valore della proprietà medias.
     * 
     * @param value
     *     allowed object is
     *     {@link Medias }
     *     
     */
    public void setMedias(Medias value) {
        this.medias = value;
    }

    /**
     * Recupera il valore della proprietà advertisings.
     * 
     * @return
     *     possible object is
     *     {@link Advertisings }
     *     
     */
    public Advertisings getAdvertisings() {
        return advertisings;
    }

    /**
     * Imposta il valore della proprietà advertisings.
     * 
     * @param value
     *     allowed object is
     *     {@link Advertisings }
     *     
     */
    public void setAdvertisings(Advertisings value) {
        this.advertisings = value;
    }

    /**
     * Recupera il valore della proprietà emails.
     * 
     * @return
     *     possible object is
     *     {@link Emails }
     *     
     */
    public Emails getEmails() {
        return emails;
    }

    /**
     * Imposta il valore della proprietà emails.
     * 
     * @param value
     *     allowed object is
     *     {@link Emails }
     *     
     */
    public void setEmails(Emails value) {
        this.emails = value;
    }

    /**
     * Recupera il valore della proprietà priority.
     * 
     * @return
     *     possible object is
     *     {@link Fields.Priority }
     *     
     */
    public Fields.Priority getPriority() {
        return priority;
    }

    /**
     * Imposta il valore della proprietà priority.
     * 
     * @param value
     *     allowed object is
     *     {@link Fields.Priority }
     *     
     */
    public void setPriority(Fields.Priority value) {
        this.priority = value;
    }

    /**
     * Recupera il valore della proprietà body.
     * 
     * @return
     *     possible object is
     *     {@link Fields.Body }
     *     
     */
    public Fields.Body getBody() {
        return body;
    }

    /**
     * Imposta il valore della proprietà body.
     * 
     * @param value
     *     allowed object is
     *     {@link Fields.Body }
     *     
     */
    public void setBody(Fields.Body value) {
        this.body = value;
    }

    /**
     * Recupera il valore della proprietà geoPosition.
     * 
     * @return
     *     possible object is
     *     {@link Position }
     *     
     */
    public Position getGeoPosition() {
        return geoPosition;
    }

    /**
     * Imposta il valore della proprietà geoPosition.
     * 
     * @param value
     *     allowed object is
     *     {@link Position }
     *     
     */
    public void setGeoPosition(Position value) {
        this.geoPosition = value;
    }

    /**
     * Recupera il valore della proprietà bandwidth.
     * 
     * @return
     *     possible object is
     *     {@link Fields.Bandwidth }
     *     
     */
    public Fields.Bandwidth getBandwidth() {
        return bandwidth;
    }

    /**
     * Imposta il valore della proprietà bandwidth.
     * 
     * @param value
     *     allowed object is
     *     {@link Fields.Bandwidth }
     *     
     */
    public void setBandwidth(Fields.Bandwidth value) {
        this.bandwidth = value;
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
     *       &lt;attribute name="ConfigField" type="{http://www.verifuse.polito.it/chainfunctionality}configFieldType" />
     *       &lt;attribute name="Value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Bandwidth {

        @XmlAttribute(name = "ConfigField")
        protected ConfigFieldType configField;
        @XmlAttribute(name = "Value", required = true)
        protected String value;

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

        /**
         * Recupera il valore della proprietà value.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Imposta il valore della proprietà value.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

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
     *         &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *       &lt;attribute name="ConfigField" type="{http://www.verifuse.polito.it/chainfunctionality}configFieldType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    public static class Body {

        @XmlElement(name = "Content", required = true)
        protected String content;
        @XmlAttribute(name = "ConfigField")
        protected ConfigFieldType configField;

        /**
         * Recupera il valore della proprietà content.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContent() {
            return content;
        }

        /**
         * Imposta il valore della proprietà content.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContent(String value) {
            this.content = value;
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


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="Version" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Address" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="ConfigField" type="{http://www.verifuse.polito.it/chainfunctionality}configFieldType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class IpDst {

        @XmlAttribute(name = "Version", required = true)
        protected String version;
        @XmlAttribute(name = "Address", required = true)
        protected String address;
        @XmlAttribute(name = "ConfigField")
        protected ConfigFieldType configField;

        /**
         * Recupera il valore della proprietà version.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVersion() {
            return version;
        }

        /**
         * Imposta il valore della proprietà version.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVersion(String value) {
            this.version = value;
        }

        /**
         * Recupera il valore della proprietà address.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAddress() {
            return address;
        }

        /**
         * Imposta il valore della proprietà address.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAddress(String value) {
            this.address = value;
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


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="Version" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Address" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="ConfigField" type="{http://www.verifuse.polito.it/chainfunctionality}configFieldType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class IpSrc {

        @XmlAttribute(name = "Version", required = true)
        protected String version;
        @XmlAttribute(name = "Address", required = true)
        protected String address;
        @XmlAttribute(name = "ConfigField")
        protected ConfigFieldType configField;

        /**
         * Recupera il valore della proprietà version.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVersion() {
            return version;
        }

        /**
         * Imposta il valore della proprietà version.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVersion(String value) {
            this.version = value;
        }

        /**
         * Recupera il valore della proprietà address.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAddress() {
            return address;
        }

        /**
         * Imposta il valore della proprietà address.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAddress(String value) {
            this.address = value;
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


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="Range" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="RangeSetting" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="ConfigField" type="{http://www.verifuse.polito.it/chainfunctionality}configFieldType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class PortDst {

        @XmlAttribute(name = "Range", required = true)
        protected String range;
        @XmlAttribute(name = "RangeSetting", required = true)
        protected String rangeSetting;
        @XmlAttribute(name = "ConfigField")
        protected ConfigFieldType configField;

        /**
         * Recupera il valore della proprietà range.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRange() {
            return range;
        }

        /**
         * Imposta il valore della proprietà range.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRange(String value) {
            this.range = value;
        }

        /**
         * Recupera il valore della proprietà rangeSetting.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRangeSetting() {
            return rangeSetting;
        }

        /**
         * Imposta il valore della proprietà rangeSetting.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRangeSetting(String value) {
            this.rangeSetting = value;
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


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="Range" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="RangeSetting" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="ConfigField" type="{http://www.verifuse.polito.it/chainfunctionality}configFieldType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class PortSrc {

        @XmlAttribute(name = "Range", required = true)
        protected String range;
        @XmlAttribute(name = "RangeSetting", required = true)
        protected String rangeSetting;
        @XmlAttribute(name = "ConfigField")
        protected ConfigFieldType configField;

        /**
         * Recupera il valore della proprietà range.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRange() {
            return range;
        }

        /**
         * Imposta il valore della proprietà range.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRange(String value) {
            this.range = value;
        }

        /**
         * Recupera il valore della proprietà rangeSetting.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRangeSetting() {
            return rangeSetting;
        }

        /**
         * Imposta il valore della proprietà rangeSetting.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRangeSetting(String value) {
            this.rangeSetting = value;
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


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="ConfigField" type="{http://www.verifuse.polito.it/chainfunctionality}configFieldType" />
     *       &lt;attribute name="Value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Priority {

        @XmlAttribute(name = "ConfigField")
        protected ConfigFieldType configField;
        @XmlAttribute(name = "Value", required = true)
        protected String value;

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

        /**
         * Recupera il valore della proprietà value.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Imposta il valore della proprietà value.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

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
     *       &lt;attribute name="TypeProtocol" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="ConfigField" type="{http://www.verifuse.polito.it/chainfunctionality}configFieldType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Proto {

        @XmlAttribute(name = "TypeProtocol")
        protected String typeProtocol;
        @XmlAttribute(name = "ConfigField")
        protected ConfigFieldType configField;

        /**
         * Recupera il valore della proprietà typeProtocol.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTypeProtocol() {
            return typeProtocol;
        }

        /**
         * Imposta il valore della proprietà typeProtocol.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTypeProtocol(String value) {
            this.typeProtocol = value;
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


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="ConfigField" type="{http://www.verifuse.polito.it/chainfunctionality}configFieldType" />
     *       &lt;attribute name="Tag" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class VlanTag {

        @XmlAttribute(name = "ConfigField")
        protected ConfigFieldType configField;
        @XmlAttribute(name = "Tag", required = true)
        protected String tag;

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

        /**
         * Recupera il valore della proprietà tag.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTag() {
            return tag;
        }

        /**
         * Imposta il valore della proprietà tag.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTag(String value) {
            this.tag = value;
        }

    }

}
