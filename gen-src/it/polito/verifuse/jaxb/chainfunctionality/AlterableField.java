//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.05.11 alle 08:15:15 PM CEST 
//


package it.polito.verifuse.jaxb.chainfunctionality;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per AlterableField.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="AlterableField">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IpSrcVer4"/>
 *     &lt;enumeration value="IpDstVer4"/>
 *     &lt;enumeration value="IpSrcVer6"/>
 *     &lt;enumeration value="IpDstVer6"/>
 *     &lt;enumeration value="PortSrc"/>
 *     &lt;enumeration value="PortDst"/>
 *     &lt;enumeration value="VlanTag"/>
 *     &lt;enumeration value="Priority"/>
 *     &lt;enumeration value="Body"/>
 *     &lt;enumeration value="GeoPosition"/>
 *     &lt;enumeration value="Bandwidth"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AlterableField")
@XmlEnum
public enum AlterableField {

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
    @XmlEnumValue("VlanTag")
    VLAN_TAG("VlanTag"),
    @XmlEnumValue("Priority")
    PRIORITY("Priority"),
    @XmlEnumValue("Body")
    BODY("Body"),
    @XmlEnumValue("GeoPosition")
    GEO_POSITION("GeoPosition"),
    @XmlEnumValue("Bandwidth")
    BANDWIDTH("Bandwidth");
    private final String value;

    AlterableField(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AlterableField fromValue(String v) {
        for (AlterableField c: AlterableField.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
