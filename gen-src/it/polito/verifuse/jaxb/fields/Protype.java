//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.03.29 alle 12:22:43 PM CEST 
//


package it.polito.verifuse.jaxb.fields;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per protype.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="protype">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TCP"/>
 *     &lt;enumeration value="UDP"/>
 *     &lt;enumeration value="HTTP"/>
 *     &lt;enumeration value="HTTPS"/>
 *     &lt;enumeration value="TLS"/>
 *     &lt;enumeration value="IPSEC"/>
 *     &lt;enumeration value="SMTP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "protype")
@XmlEnum
public enum Protype {

    TCP,
    UDP,
    HTTP,
    HTTPS,
    TLS,
    IPSEC,
    SMTP;

    public String value() {
        return name();
    }

    public static Protype fromValue(String v) {
        return valueOf(v);
    }

}
