//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:17 PM CEST 
//


package it.polito.verifuse.jaxb.manifestvnfs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per SoftwareInfo complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="SoftwareInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Developers" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Developer" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="VersionInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="version" use="required" type="{http://www.verifuse.polito.it/manifestvnfs}regExrVersion" />
 *                 &lt;attribute name="release" use="required" type="{http://www.verifuse.polito.it/manifestvnfs}regExrVersion" />
 *                 &lt;attribute name="releaseDate" use="required" type="{http://www.verifuse.polito.it/manifestvnfs}regExrDate" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Repository" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="ProgrammingLanguagesUsed" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ProgrammingLanguage" type="{http://www.verifuse.polito.it/manifestvnfs}ProgrammingLanguage" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OperatingSystemsSupported" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="OperatingSystem" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="OS_Type" type="{http://www.verifuse.polito.it/manifestvnfs}OS_Type" />
 *                           &lt;attribute name="OS_Version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="OS_Architecture" type="{http://www.verifuse.polito.it/manifestvnfs}Architecture" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Licence" type="{http://www.verifuse.polito.it/manifestvnfs}Licence" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoftwareInfo", propOrder = {
    "developers",
    "versionInfo",
    "repository",
    "programmingLanguagesUsed",
    "operatingSystemsSupported",
    "licence"
})
public class SoftwareInfo {

    @XmlElement(name = "Developers")
    protected SoftwareInfo.Developers developers;
    @XmlElement(name = "VersionInfo")
    protected SoftwareInfo.VersionInfo versionInfo;
    @XmlElement(name = "Repository")
    @XmlSchemaType(name = "anyURI")
    protected String repository;
    @XmlElement(name = "ProgrammingLanguagesUsed")
    protected SoftwareInfo.ProgrammingLanguagesUsed programmingLanguagesUsed;
    @XmlElement(name = "OperatingSystemsSupported")
    protected SoftwareInfo.OperatingSystemsSupported operatingSystemsSupported;
    @XmlElement(name = "Licence")
    @XmlSchemaType(name = "string")
    protected Licence licence;

    /**
     * Recupera il valore della proprietà developers.
     * 
     * @return
     *     possible object is
     *     {@link SoftwareInfo.Developers }
     *     
     */
    public SoftwareInfo.Developers getDevelopers() {
        return developers;
    }

    /**
     * Imposta il valore della proprietà developers.
     * 
     * @param value
     *     allowed object is
     *     {@link SoftwareInfo.Developers }
     *     
     */
    public void setDevelopers(SoftwareInfo.Developers value) {
        this.developers = value;
    }

    /**
     * Recupera il valore della proprietà versionInfo.
     * 
     * @return
     *     possible object is
     *     {@link SoftwareInfo.VersionInfo }
     *     
     */
    public SoftwareInfo.VersionInfo getVersionInfo() {
        return versionInfo;
    }

    /**
     * Imposta il valore della proprietà versionInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link SoftwareInfo.VersionInfo }
     *     
     */
    public void setVersionInfo(SoftwareInfo.VersionInfo value) {
        this.versionInfo = value;
    }

    /**
     * Recupera il valore della proprietà repository.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepository() {
        return repository;
    }

    /**
     * Imposta il valore della proprietà repository.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepository(String value) {
        this.repository = value;
    }

    /**
     * Recupera il valore della proprietà programmingLanguagesUsed.
     * 
     * @return
     *     possible object is
     *     {@link SoftwareInfo.ProgrammingLanguagesUsed }
     *     
     */
    public SoftwareInfo.ProgrammingLanguagesUsed getProgrammingLanguagesUsed() {
        return programmingLanguagesUsed;
    }

    /**
     * Imposta il valore della proprietà programmingLanguagesUsed.
     * 
     * @param value
     *     allowed object is
     *     {@link SoftwareInfo.ProgrammingLanguagesUsed }
     *     
     */
    public void setProgrammingLanguagesUsed(SoftwareInfo.ProgrammingLanguagesUsed value) {
        this.programmingLanguagesUsed = value;
    }

    /**
     * Recupera il valore della proprietà operatingSystemsSupported.
     * 
     * @return
     *     possible object is
     *     {@link SoftwareInfo.OperatingSystemsSupported }
     *     
     */
    public SoftwareInfo.OperatingSystemsSupported getOperatingSystemsSupported() {
        return operatingSystemsSupported;
    }

    /**
     * Imposta il valore della proprietà operatingSystemsSupported.
     * 
     * @param value
     *     allowed object is
     *     {@link SoftwareInfo.OperatingSystemsSupported }
     *     
     */
    public void setOperatingSystemsSupported(SoftwareInfo.OperatingSystemsSupported value) {
        this.operatingSystemsSupported = value;
    }

    /**
     * Recupera il valore della proprietà licence.
     * 
     * @return
     *     possible object is
     *     {@link Licence }
     *     
     */
    public Licence getLicence() {
        return licence;
    }

    /**
     * Imposta il valore della proprietà licence.
     * 
     * @param value
     *     allowed object is
     *     {@link Licence }
     *     
     */
    public void setLicence(Licence value) {
        this.licence = value;
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
     *         &lt;element name="Developer" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
        "developer"
    })
    public static class Developers {

        @XmlElement(name = "Developer", required = true)
        protected List<String> developer;

        /**
         * Gets the value of the developer property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the developer property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDeveloper().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getDeveloper() {
            if (developer == null) {
                developer = new ArrayList<String>();
            }
            return this.developer;
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
     *         &lt;element name="OperatingSystem" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="OS_Type" type="{http://www.verifuse.polito.it/manifestvnfs}OS_Type" />
     *                 &lt;attribute name="OS_Version" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="OS_Architecture" type="{http://www.verifuse.polito.it/manifestvnfs}Architecture" />
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
        "operatingSystem"
    })
    public static class OperatingSystemsSupported {

        @XmlElement(name = "OperatingSystem", required = true)
        protected List<SoftwareInfo.OperatingSystemsSupported.OperatingSystem> operatingSystem;

        /**
         * Gets the value of the operatingSystem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the operatingSystem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOperatingSystem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SoftwareInfo.OperatingSystemsSupported.OperatingSystem }
         * 
         * 
         */
        public List<SoftwareInfo.OperatingSystemsSupported.OperatingSystem> getOperatingSystem() {
            if (operatingSystem == null) {
                operatingSystem = new ArrayList<SoftwareInfo.OperatingSystemsSupported.OperatingSystem>();
            }
            return this.operatingSystem;
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
         *       &lt;attribute name="OS_Type" type="{http://www.verifuse.polito.it/manifestvnfs}OS_Type" />
         *       &lt;attribute name="OS_Version" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="OS_Architecture" type="{http://www.verifuse.polito.it/manifestvnfs}Architecture" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class OperatingSystem {

            @XmlAttribute(name = "OS_Type")
            protected OSType osType;
            @XmlAttribute(name = "OS_Version")
            protected String osVersion;
            @XmlAttribute(name = "OS_Architecture")
            protected Architecture osArchitecture;

            /**
             * Recupera il valore della proprietà osType.
             * 
             * @return
             *     possible object is
             *     {@link OSType }
             *     
             */
            public OSType getOSType() {
                return osType;
            }

            /**
             * Imposta il valore della proprietà osType.
             * 
             * @param value
             *     allowed object is
             *     {@link OSType }
             *     
             */
            public void setOSType(OSType value) {
                this.osType = value;
            }

            /**
             * Recupera il valore della proprietà osVersion.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOSVersion() {
                return osVersion;
            }

            /**
             * Imposta il valore della proprietà osVersion.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOSVersion(String value) {
                this.osVersion = value;
            }

            /**
             * Recupera il valore della proprietà osArchitecture.
             * 
             * @return
             *     possible object is
             *     {@link Architecture }
             *     
             */
            public Architecture getOSArchitecture() {
                return osArchitecture;
            }

            /**
             * Imposta il valore della proprietà osArchitecture.
             * 
             * @param value
             *     allowed object is
             *     {@link Architecture }
             *     
             */
            public void setOSArchitecture(Architecture value) {
                this.osArchitecture = value;
            }

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
     *         &lt;element name="ProgrammingLanguage" type="{http://www.verifuse.polito.it/manifestvnfs}ProgrammingLanguage" maxOccurs="unbounded"/>
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
        "programmingLanguage"
    })
    public static class ProgrammingLanguagesUsed {

        @XmlElement(name = "ProgrammingLanguage", required = true)
        protected List<String> programmingLanguage;

        /**
         * Gets the value of the programmingLanguage property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the programmingLanguage property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProgrammingLanguage().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getProgrammingLanguage() {
            if (programmingLanguage == null) {
                programmingLanguage = new ArrayList<String>();
            }
            return this.programmingLanguage;
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
     *       &lt;attribute name="version" use="required" type="{http://www.verifuse.polito.it/manifestvnfs}regExrVersion" />
     *       &lt;attribute name="release" use="required" type="{http://www.verifuse.polito.it/manifestvnfs}regExrVersion" />
     *       &lt;attribute name="releaseDate" use="required" type="{http://www.verifuse.polito.it/manifestvnfs}regExrDate" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class VersionInfo {

        @XmlAttribute(name = "version", required = true)
        protected String version;
        @XmlAttribute(name = "release", required = true)
        protected String release;
        @XmlAttribute(name = "releaseDate", required = true)
        protected String releaseDate;

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
         * Recupera il valore della proprietà release.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRelease() {
            return release;
        }

        /**
         * Imposta il valore della proprietà release.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRelease(String value) {
            this.release = value;
        }

        /**
         * Recupera il valore della proprietà releaseDate.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReleaseDate() {
            return releaseDate;
        }

        /**
         * Imposta il valore della proprietà releaseDate.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReleaseDate(String value) {
            this.releaseDate = value;
        }

    }

}
