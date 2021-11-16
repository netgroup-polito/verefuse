//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.19 alle 12:16:17 PM CEST 
//


package it.polito.verifuse.jaxb.manifestvnfs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per typeAction.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="typeAction">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALLOW_TRAFFIC"/>
 *     &lt;enumeration value="DENY_TRAFFIC"/>
 *     &lt;enumeration value="LOG_TRAFFIC"/>
 *     &lt;enumeration value="ALERT"/>
 *     &lt;enumeration value="COUNT"/>
 *     &lt;enumeration value="ENCRYPT_TRAFFIC"/>
 *     &lt;enumeration value="AUTHN_TRAFFIC"/>
 *     &lt;enumeration value="PROTECT_CONFIDENTIALITY"/>
 *     &lt;enumeration value="PROTECT_INTEGRITY"/>
 *     &lt;enumeration value="LIMIT_BANDWIDTH"/>
 *     &lt;enumeration value="FORWARD_TRAFFIC"/>
 *     &lt;enumeration value="STORE_PACKET"/>
 *     &lt;enumeration value="NAT_TRAFFIC"/>
 *     &lt;enumeration value="REMARK_PACKET"/>
 *     &lt;enumeration value="ANTIVIRUS"/>
 *     &lt;enumeration value="IDS"/>
 *     &lt;enumeration value="IPS"/>
 *     &lt;enumeration value="PROXY"/>
 *     &lt;enumeration value="PROTECT_DDOS"/>
 *     &lt;enumeration value="SCANNING"/>
 *     &lt;enumeration value="PROTECT_TRACKING"/>
 *     &lt;enumeration value="PROTECT_IDENTITY"/>
 *     &lt;enumeration value="VPN_TRAFFIC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "typeAction", namespace = "http://www.verifuse.polito.it/actionsmanifest")
@XmlEnum
public enum TypeAction {

    ALLOW_TRAFFIC,
    DENY_TRAFFIC,
    LOG_TRAFFIC,
    ALERT,
    COUNT,
    ENCRYPT_TRAFFIC,
    AUTHN_TRAFFIC,
    PROTECT_CONFIDENTIALITY,
    PROTECT_INTEGRITY,
    LIMIT_BANDWIDTH,
    FORWARD_TRAFFIC,
    STORE_PACKET,
    NAT_TRAFFIC,
    REMARK_PACKET,
    ANTIVIRUS,
    IDS,
    IPS,
    PROXY,
    PROTECT_DDOS,
    SCANNING,
    PROTECT_TRACKING,
    PROTECT_IDENTITY,
    VPN_TRAFFIC;

    public String value() {
        return name();
    }

    public static TypeAction fromValue(String v) {
        return valueOf(v);
    }

}
