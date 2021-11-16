//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.03.30 alle 10:55:15 AM CEST 
//


package it.polito.verifuse.jaxb.fieldsmanifest;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per typeField.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="typeField">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Conf:Dec"/>
 *     &lt;enumeration value="NotConf:Dec"/>
 *     &lt;enumeration value="NotConf:NotDec"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "typeField")
@XmlEnum
public enum TypeField {

    @XmlEnumValue("Conf:Dec")
    CONF_DEC("Conf:Dec"),
    @XmlEnumValue("NotConf:Dec")
    NOT_CONF_DEC("NotConf:Dec"),
    @XmlEnumValue("NotConf:NotDec")
    NOT_CONF_NOT_DEC("NotConf:NotDec");
    private final String value;

    TypeField(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TypeField fromValue(String v) {
        for (TypeField c: TypeField.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
