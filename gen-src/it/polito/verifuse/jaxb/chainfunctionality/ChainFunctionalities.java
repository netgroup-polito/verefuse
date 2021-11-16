//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:19 PM CEST 
//


package it.polito.verifuse.jaxb.chainfunctionality;

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
 *         &lt;element name="Chain" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Solution" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Functionality" type="{http://www.verifuse.polito.it/chainfunctionality}functionExtended" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="Sol_ID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Satisfiability" type="{http://www.w3.org/2001/XMLSchema}string" default="PARTIAL" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Chain_ID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    "chain"
})
@XmlRootElement(name = "ChainFunctionalities")
public class ChainFunctionalities {

    @XmlElement(name = "Chain", required = true)
    protected List<ChainFunctionalities.Chain> chain;

    /**
     * Gets the value of the chain property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chain property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChain().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChainFunctionalities.Chain }
     * 
     * 
     */
    public List<ChainFunctionalities.Chain> getChain() {
        if (chain == null) {
            chain = new ArrayList<ChainFunctionalities.Chain>();
        }
        return this.chain;
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
     *         &lt;element name="Solution" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Functionality" type="{http://www.verifuse.polito.it/chainfunctionality}functionExtended" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="Sol_ID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Satisfiability" type="{http://www.w3.org/2001/XMLSchema}string" default="PARTIAL" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="Chain_ID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "solution"
    })
    public static class Chain {

        @XmlElement(name = "Solution", required = true)
        protected List<ChainFunctionalities.Chain.Solution> solution;
        @XmlAttribute(name = "Chain_ID", required = true)
        protected String chainID;

        /**
         * Gets the value of the solution property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the solution property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSolution().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ChainFunctionalities.Chain.Solution }
         * 
         * 
         */
        public List<ChainFunctionalities.Chain.Solution> getSolution() {
            if (solution == null) {
                solution = new ArrayList<ChainFunctionalities.Chain.Solution>();
            }
            return this.solution;
        }

        /**
         * Recupera il valore della proprietà chainID.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getChainID() {
            return chainID;
        }

        /**
         * Imposta il valore della proprietà chainID.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setChainID(String value) {
            this.chainID = value;
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
         *         &lt;element name="Functionality" type="{http://www.verifuse.polito.it/chainfunctionality}functionExtended" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="Sol_ID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Satisfiability" type="{http://www.w3.org/2001/XMLSchema}string" default="PARTIAL" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "functionality"
        })
        public static class Solution {

            @XmlElement(name = "Functionality")
            protected List<FunctionExtended> functionality;
            @XmlAttribute(name = "Sol_ID", required = true)
            protected String solID;
            @XmlAttribute(name = "Satisfiability")
            protected String satisfiability;

            /**
             * Gets the value of the functionality property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the functionality property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getFunctionality().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link FunctionExtended }
             * 
             * 
             */
            public List<FunctionExtended> getFunctionality() {
                if (functionality == null) {
                    functionality = new ArrayList<FunctionExtended>();
                }
                return this.functionality;
            }

            /**
             * Recupera il valore della proprietà solID.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSolID() {
                return solID;
            }

            /**
             * Imposta il valore della proprietà solID.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSolID(String value) {
                this.solID = value;
            }

            /**
             * Recupera il valore della proprietà satisfiability.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSatisfiability() {
                if (satisfiability == null) {
                    return "PARTIAL";
                } else {
                    return satisfiability;
                }
            }

            /**
             * Imposta il valore della proprietà satisfiability.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSatisfiability(String value) {
                this.satisfiability = value;
            }

        }

    }

}
