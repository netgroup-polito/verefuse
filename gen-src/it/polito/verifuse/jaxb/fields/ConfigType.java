//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.11 alle 12:33:50 PM CEST 
//


package it.polito.verifuse.jaxb.fields;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per configType.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="configType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CONF_DEC"/>
 *     &lt;enumeration value="NOT_CONF_MAKE_DEC"/>
 *     &lt;enumeration value="NOT_CONF_NOT_DEC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "configType")
@XmlEnum
public enum ConfigType {

    CONF_DEC,
    NOT_CONF_MAKE_DEC,
    NOT_CONF_NOT_DEC;

    public String value() {
        return name();
    }

    public static ConfigType fromValue(String v) {
        return valueOf(v);
    }

}
