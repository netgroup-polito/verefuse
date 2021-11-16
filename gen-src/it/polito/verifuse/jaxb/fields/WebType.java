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
 * <p>Classe Java per WebType.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="WebType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HTML"/>
 *     &lt;enumeration value="ASPX"/>
 *     &lt;enumeration value="TAG_A"/>
 *     &lt;enumeration value="TAG_HREF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WebType")
@XmlEnum
public enum WebType {

    HTML,
    ASPX,
    TAG_A,
    TAG_HREF;

    public String value() {
        return name();
    }

    public static WebType fromValue(String v) {
        return valueOf(v);
    }

}
