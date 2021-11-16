//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:16 PM CEST 
//


package it.polito.verifuse.jaxb.requirementslist;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per configField.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="configField">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="inside"/>
 *     &lt;enumeration value="outside"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "configField")
@XmlEnum
public enum ConfigField {

    @XmlEnumValue("inside")
    INSIDE("inside"),
    @XmlEnumValue("outside")
    OUTSIDE("outside");
    private final String value;

    ConfigField(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ConfigField fromValue(String v) {
        for (ConfigField c: ConfigField.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
