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
 * <p>Classe Java per Licence.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="Licence">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BSD"/>
 *     &lt;enumeration value="Commercial"/>
 *     &lt;enumeration value="Freeware"/>
 *     &lt;enumeration value="GPL"/>
 *     &lt;enumeration value="MIT"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="Unspecified"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Licence")
@XmlEnum
public enum Licence {

    BSD("BSD"),
    @XmlEnumValue("Commercial")
    COMMERCIAL("Commercial"),
    @XmlEnumValue("Freeware")
    FREEWARE("Freeware"),
    GPL("GPL"),
    MIT("MIT"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("Unspecified")
    UNSPECIFIED("Unspecified");
    private final String value;

    Licence(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Licence fromValue(String v) {
        for (Licence c: Licence.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
