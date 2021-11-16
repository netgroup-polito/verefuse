//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.03.29 alle 12:22:45 PM CEST 
//


package it.polito.verifuse.jaxb.requirementslist;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ScriptType.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="ScriptType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="JS"/>
 *     &lt;enumeration value="BASH"/>
 *     &lt;enumeration value="BAT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ScriptType")
@XmlEnum
public enum ScriptType {

    JS,
    BASH,
    BAT;

    public String value() {
        return name();
    }

    public static ScriptType fromValue(String v) {
        return valueOf(v);
    }

}
