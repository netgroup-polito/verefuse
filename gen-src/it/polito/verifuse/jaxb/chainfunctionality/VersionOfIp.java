//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:19 PM CEST 
//


package it.polito.verifuse.jaxb.chainfunctionality;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per versionOfIp.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="versionOfIp">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ipv4"/>
 *     &lt;enumeration value="ipv6"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "versionOfIp")
@XmlEnum
public enum VersionOfIp {

    @XmlEnumValue("ipv4")
    IPV_4("ipv4"),
    @XmlEnumValue("ipv6")
    IPV_6("ipv6");
    private final String value;

    VersionOfIp(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VersionOfIp fromValue(String v) {
        for (VersionOfIp c: VersionOfIp.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
