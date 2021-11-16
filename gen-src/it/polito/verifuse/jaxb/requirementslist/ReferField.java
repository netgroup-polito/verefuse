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
 * <p>Classe Java per ReferField.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="ReferField">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IpSrcVer4"/>
 *     &lt;enumeration value="IpDstVer4"/>
 *     &lt;enumeration value="IpSrcVer6"/>
 *     &lt;enumeration value="IpDstVer6"/>
 *     &lt;enumeration value="PortSrc"/>
 *     &lt;enumeration value="PortDst"/>
 *     &lt;enumeration value="Proto"/>
 *     &lt;enumeration value="Urls"/>
 *     &lt;enumeration value="Domain"/>
 *     &lt;enumeration value="VlanTag"/>
 *     &lt;enumeration value="DaysAndTimes"/>
 *     &lt;enumeration value="Documents"/>
 *     &lt;enumeration value="Scripts"/>
 *     &lt;enumeration value="WebPages"/>
 *     &lt;enumeration value="Applications"/>
 *     &lt;enumeration value="Medias"/>
 *     &lt;enumeration value="Advertisings"/>
 *     &lt;enumeration value="Emails"/>
 *     &lt;enumeration value="Priority"/>
 *     &lt;enumeration value="Body"/>
 *     &lt;enumeration value="GeoPosition"/>
 *     &lt;enumeration value="Displace"/>
 *     &lt;enumeration value="Bandwidth"/>
 *     &lt;enumeration value="RemarkField"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReferField")
@XmlEnum
public enum ReferField {

    @XmlEnumValue("IpSrcVer4")
    IP_SRC_VER_4("IpSrcVer4"),
    @XmlEnumValue("IpDstVer4")
    IP_DST_VER_4("IpDstVer4"),
    @XmlEnumValue("IpSrcVer6")
    IP_SRC_VER_6("IpSrcVer6"),
    @XmlEnumValue("IpDstVer6")
    IP_DST_VER_6("IpDstVer6"),
    @XmlEnumValue("PortSrc")
    PORT_SRC("PortSrc"),
    @XmlEnumValue("PortDst")
    PORT_DST("PortDst"),
    @XmlEnumValue("Proto")
    PROTO("Proto"),
    @XmlEnumValue("Urls")
    URLS("Urls"),
    @XmlEnumValue("Domain")
    DOMAIN("Domain"),
    @XmlEnumValue("VlanTag")
    VLAN_TAG("VlanTag"),
    @XmlEnumValue("DaysAndTimes")
    DAYS_AND_TIMES("DaysAndTimes"),
    @XmlEnumValue("Documents")
    DOCUMENTS("Documents"),
    @XmlEnumValue("Scripts")
    SCRIPTS("Scripts"),
    @XmlEnumValue("WebPages")
    WEB_PAGES("WebPages"),
    @XmlEnumValue("Applications")
    APPLICATIONS("Applications"),
    @XmlEnumValue("Medias")
    MEDIAS("Medias"),
    @XmlEnumValue("Advertisings")
    ADVERTISINGS("Advertisings"),
    @XmlEnumValue("Emails")
    EMAILS("Emails"),
    @XmlEnumValue("Priority")
    PRIORITY("Priority"),
    @XmlEnumValue("Body")
    BODY("Body"),
    @XmlEnumValue("GeoPosition")
    GEO_POSITION("GeoPosition"),
    @XmlEnumValue("Displace")
    DISPLACE("Displace"),
    @XmlEnumValue("Bandwidth")
    BANDWIDTH("Bandwidth"),
    @XmlEnumValue("RemarkField")
    REMARK_FIELD("RemarkField");
    private final String value;

    ReferField(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReferField fromValue(String v) {
        for (ReferField c: ReferField.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
