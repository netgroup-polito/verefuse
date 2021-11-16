//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:14 PM CEST 
//


package it.polito.verifuse.jaxb.fieldsmanifest;

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
 *         &lt;element name="Field" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Supports" type="{http://www.verifuse.polito.it/fieldsmanifest}SupportType" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Type" use="required" type="{http://www.verifuse.polito.it/fieldsmanifest}enumField" />
 *                 &lt;attribute name="TypeConfig" type="{http://www.verifuse.polito.it/fieldsmanifest}configType" default="CONF_DEC" />
 *                 &lt;attribute name="importSuite" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    "field"
})
@XmlRootElement(name = "FieldsManifest")
public class FieldsManifest {

    @XmlElement(name = "Field", required = true)
    protected List<FieldsManifest.Field> field;

    /**
     * Gets the value of the field property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the field property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getField().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FieldsManifest.Field }
     * 
     * 
     */
    public List<FieldsManifest.Field> getField() {
        if (field == null) {
            field = new ArrayList<FieldsManifest.Field>();
        }
        return this.field;
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
     *         &lt;element name="Supports" type="{http://www.verifuse.polito.it/fieldsmanifest}SupportType" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="Type" use="required" type="{http://www.verifuse.polito.it/fieldsmanifest}enumField" />
     *       &lt;attribute name="TypeConfig" type="{http://www.verifuse.polito.it/fieldsmanifest}configType" default="CONF_DEC" />
     *       &lt;attribute name="importSuite" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "supports"
    })
    public static class Field {

        @XmlElement(name = "Supports")
        protected SupportType supports;
        @XmlAttribute(name = "Type", required = true)
        protected EnumField type;
        @XmlAttribute(name = "TypeConfig")
        protected ConfigType typeConfig;
        @XmlAttribute(name = "importSuite")
        protected String importSuite;

        /**
         * Recupera il valore della proprietà supports.
         * 
         * @return
         *     possible object is
         *     {@link SupportType }
         *     
         */
        public SupportType getSupports() {
            return supports;
        }

        /**
         * Imposta il valore della proprietà supports.
         * 
         * @param value
         *     allowed object is
         *     {@link SupportType }
         *     
         */
        public void setSupports(SupportType value) {
            this.supports = value;
        }

        /**
         * Recupera il valore della proprietà type.
         * 
         * @return
         *     possible object is
         *     {@link EnumField }
         *     
         */
        public EnumField getType() {
            return type;
        }

        /**
         * Imposta il valore della proprietà type.
         * 
         * @param value
         *     allowed object is
         *     {@link EnumField }
         *     
         */
        public void setType(EnumField value) {
            this.type = value;
        }

        /**
         * Recupera il valore della proprietà typeConfig.
         * 
         * @return
         *     possible object is
         *     {@link ConfigType }
         *     
         */
        public ConfigType getTypeConfig() {
            if (typeConfig == null) {
                return ConfigType.CONF_DEC;
            } else {
                return typeConfig;
            }
        }

        /**
         * Imposta il valore della proprietà typeConfig.
         * 
         * @param value
         *     allowed object is
         *     {@link ConfigType }
         *     
         */
        public void setTypeConfig(ConfigType value) {
            this.typeConfig = value;
        }

        /**
         * Recupera il valore della proprietà importSuite.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getImportSuite() {
            return importSuite;
        }

        /**
         * Imposta il valore della proprietà importSuite.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setImportSuite(String value) {
            this.importSuite = value;
        }

    }

}
