//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:13 PM CEST 
//


package it.polito.verifuse.jaxb.fields;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per KeyExchangeSuite.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="KeyExchangeSuite">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ECDH"/>
 *     &lt;enumeration value="ECDHE"/>
 *     &lt;enumeration value="RSA"/>
 *     &lt;enumeration value="PSK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "KeyExchangeSuite")
@XmlEnum
public enum KeyExchangeSuite {

    ECDH,
    ECDHE,
    RSA,
    PSK;

    public String value() {
        return name();
    }

    public static KeyExchangeSuite fromValue(String v) {
        return valueOf(v);
    }

}
