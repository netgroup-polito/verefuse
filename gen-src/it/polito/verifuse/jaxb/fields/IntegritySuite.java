//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:13 PM CEST 
//


package it.polito.verifuse.jaxb.fields;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per IntegritySuite.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="IntegritySuite">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MD5"/>
 *     &lt;enumeration value="SHA1"/>
 *     &lt;enumeration value="SHA2"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IntegritySuite")
@XmlEnum
public enum IntegritySuite {

    @XmlEnumValue("MD5")
    MD_5("MD5"),
    @XmlEnumValue("SHA1")
    SHA_1("SHA1"),
    @XmlEnumValue("SHA2")
    SHA_2("SHA2");
    private final String value;

    IntegritySuite(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IntegritySuite fromValue(String v) {
        for (IntegritySuite c: IntegritySuite.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
