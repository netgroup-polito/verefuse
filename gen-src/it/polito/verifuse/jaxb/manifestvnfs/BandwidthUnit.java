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
 * <p>Classe Java per Bandwidth_Unit.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="Bandwidth_Unit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Kb/s"/>
 *     &lt;enumeration value="Mb/s"/>
 *     &lt;enumeration value="Gb/s"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Bandwidth_Unit")
@XmlEnum
public enum BandwidthUnit {

    @XmlEnumValue("Kb/s")
    KB_S("Kb/s"),
    @XmlEnumValue("Mb/s")
    MB_S("Mb/s"),
    @XmlEnumValue("Gb/s")
    GB_S("Gb/s");
    private final String value;

    BandwidthUnit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BandwidthUnit fromValue(String v) {
        for (BandwidthUnit c: BandwidthUnit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
