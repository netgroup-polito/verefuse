//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:17 PM CEST 
//


package it.polito.verifuse.jaxb.manifestvnfs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Architecture.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="Architecture">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="x86"/>
 *     &lt;enumeration value="x64"/>
 *     &lt;enumeration value="ARM"/>
 *     &lt;enumeration value="Unspecified"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Architecture")
@XmlEnum
public enum Architecture {

    @XmlEnumValue("x86")
    X_86("x86"),
    @XmlEnumValue("x64")
    X_64("x64"),
    ARM("ARM"),
    @XmlEnumValue("Unspecified")
    UNSPECIFIED("Unspecified");
    private final String value;

    Architecture(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Architecture fromValue(String v) {
        for (Architecture c: Architecture.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
