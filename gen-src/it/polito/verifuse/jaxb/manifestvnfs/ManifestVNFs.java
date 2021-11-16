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
 *         &lt;element name="ManifestVNF" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="GeneralInfo" type="{http://www.verifuse.polito.it/manifestvnfs}GeneralInfo" minOccurs="0"/>
 *                   &lt;element name="SoftwareInfo" type="{http://www.verifuse.polito.it/manifestvnfs}SoftwareInfo" minOccurs="0"/>
 *                   &lt;element name="HardwareInfo" type="{http://www.verifuse.polito.it/manifestvnfs}HardwareInfo" minOccurs="0"/>
 *                   &lt;element name="ManifestInfo">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element ref="{http://www.verifuse.polito.it/fieldsmanifest}FieldsManifest"/>
 *                             &lt;element ref="{http://www.verifuse.polito.it/actionsmanifest}ActionsManifest"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Manifest_ID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    "manifestVNF"
})
@XmlRootElement(name = "ManifestVNFs")
public class ManifestVNFs {

    @XmlElement(name = "ManifestVNF", required = true)
    protected List<ManifestVNFs.ManifestVNF> manifestVNF;

    /**
     * Gets the value of the manifestVNF property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the manifestVNF property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getManifestVNF().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ManifestVNFs.ManifestVNF }
     * 
     * 
     */
    public List<ManifestVNFs.ManifestVNF> getManifestVNF() {
        if (manifestVNF == null) {
            manifestVNF = new ArrayList<ManifestVNFs.ManifestVNF>();
        }
        return this.manifestVNF;
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
     *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="GeneralInfo" type="{http://www.verifuse.polito.it/manifestvnfs}GeneralInfo" minOccurs="0"/>
     *         &lt;element name="SoftwareInfo" type="{http://www.verifuse.polito.it/manifestvnfs}SoftwareInfo" minOccurs="0"/>
     *         &lt;element name="HardwareInfo" type="{http://www.verifuse.polito.it/manifestvnfs}HardwareInfo" minOccurs="0"/>
     *         &lt;element name="ManifestInfo">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element ref="{http://www.verifuse.polito.it/fieldsmanifest}FieldsManifest"/>
     *                   &lt;element ref="{http://www.verifuse.polito.it/actionsmanifest}ActionsManifest"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="Manifest_ID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "description",
        "generalInfo",
        "softwareInfo",
        "hardwareInfo",
        "manifestInfo"
    })
    public static class ManifestVNF {

        @XmlElement(name = "Description", required = true)
        protected String description;
        @XmlElement(name = "GeneralInfo")
        protected GeneralInfo generalInfo;
        @XmlElement(name = "SoftwareInfo")
        protected SoftwareInfo softwareInfo;
        @XmlElement(name = "HardwareInfo")
        protected HardwareInfo hardwareInfo;
        @XmlElement(name = "ManifestInfo", required = true)
        protected ManifestVNFs.ManifestVNF.ManifestInfo manifestInfo;
        @XmlAttribute(name = "Manifest_ID", required = true)
        protected String manifestID;

        /**
         * Recupera il valore della proprietà description.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription() {
            return description;
        }

        /**
         * Imposta il valore della proprietà description.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription(String value) {
            this.description = value;
        }

        /**
         * Recupera il valore della proprietà generalInfo.
         * 
         * @return
         *     possible object is
         *     {@link GeneralInfo }
         *     
         */
        public GeneralInfo getGeneralInfo() {
            return generalInfo;
        }

        /**
         * Imposta il valore della proprietà generalInfo.
         * 
         * @param value
         *     allowed object is
         *     {@link GeneralInfo }
         *     
         */
        public void setGeneralInfo(GeneralInfo value) {
            this.generalInfo = value;
        }

        /**
         * Recupera il valore della proprietà softwareInfo.
         * 
         * @return
         *     possible object is
         *     {@link SoftwareInfo }
         *     
         */
        public SoftwareInfo getSoftwareInfo() {
            return softwareInfo;
        }

        /**
         * Imposta il valore della proprietà softwareInfo.
         * 
         * @param value
         *     allowed object is
         *     {@link SoftwareInfo }
         *     
         */
        public void setSoftwareInfo(SoftwareInfo value) {
            this.softwareInfo = value;
        }

        /**
         * Recupera il valore della proprietà hardwareInfo.
         * 
         * @return
         *     possible object is
         *     {@link HardwareInfo }
         *     
         */
        public HardwareInfo getHardwareInfo() {
            return hardwareInfo;
        }

        /**
         * Imposta il valore della proprietà hardwareInfo.
         * 
         * @param value
         *     allowed object is
         *     {@link HardwareInfo }
         *     
         */
        public void setHardwareInfo(HardwareInfo value) {
            this.hardwareInfo = value;
        }

        /**
         * Recupera il valore della proprietà manifestInfo.
         * 
         * @return
         *     possible object is
         *     {@link ManifestVNFs.ManifestVNF.ManifestInfo }
         *     
         */
        public ManifestVNFs.ManifestVNF.ManifestInfo getManifestInfo() {
            return manifestInfo;
        }

        /**
         * Imposta il valore della proprietà manifestInfo.
         * 
         * @param value
         *     allowed object is
         *     {@link ManifestVNFs.ManifestVNF.ManifestInfo }
         *     
         */
        public void setManifestInfo(ManifestVNFs.ManifestVNF.ManifestInfo value) {
            this.manifestInfo = value;
        }

        /**
         * Recupera il valore della proprietà manifestID.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getManifestID() {
            return manifestID;
        }

        /**
         * Imposta il valore della proprietà manifestID.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setManifestID(String value) {
            this.manifestID = value;
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
         *         &lt;element ref="{http://www.verifuse.polito.it/fieldsmanifest}FieldsManifest"/>
         *         &lt;element ref="{http://www.verifuse.polito.it/actionsmanifest}ActionsManifest"/>
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
            "fieldsManifest",
            "actionsManifest"
        })
        public static class ManifestInfo {

            @XmlElement(name = "FieldsManifest", namespace = "http://www.verifuse.polito.it/fieldsmanifest", required = true)
            protected FieldsManifest fieldsManifest;
            @XmlElement(name = "ActionsManifest", namespace = "http://www.verifuse.polito.it/actionsmanifest", required = true)
            protected ActionsManifest actionsManifest;

            /**
             * Recupera il valore della proprietà fieldsManifest.
             * 
             * @return
             *     possible object is
             *     {@link FieldsManifest }
             *     
             */
            public FieldsManifest getFieldsManifest() {
                return fieldsManifest;
            }

            /**
             * Imposta il valore della proprietà fieldsManifest.
             * 
             * @param value
             *     allowed object is
             *     {@link FieldsManifest }
             *     
             */
            public void setFieldsManifest(FieldsManifest value) {
                this.fieldsManifest = value;
            }

            /**
             * Recupera il valore della proprietà actionsManifest.
             * 
             * @return
             *     possible object is
             *     {@link ActionsManifest }
             *     
             */
            public ActionsManifest getActionsManifest() {
                return actionsManifest;
            }

            /**
             * Imposta il valore della proprietà actionsManifest.
             * 
             * @param value
             *     allowed object is
             *     {@link ActionsManifest }
             *     
             */
            public void setActionsManifest(ActionsManifest value) {
                this.actionsManifest = value;
            }

        }

    }

}
