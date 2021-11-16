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
 * <p>Classe Java per OS_Type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="OS_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ARM"/>
 *     &lt;enumeration value="Android"/>
 *     &lt;enumeration value="BSD"/>
 *     &lt;enumeration value="CentOS"/>
 *     &lt;enumeration value="Debian"/>
 *     &lt;enumeration value="Fedora"/>
 *     &lt;enumeration value="Fink"/>
 *     &lt;enumeration value="FreeBSD"/>
 *     &lt;enumeration value="OpenBSD"/>
 *     &lt;enumeration value="Gentoo"/>
 *     &lt;enumeration value="IBM"/>
 *     &lt;enumeration value="iOS"/>
 *     &lt;enumeration value="Linux"/>
 *     &lt;enumeration value="macOS"/>
 *     &lt;enumeration value="Maemo"/>
 *     &lt;enumeration value="Mandriva"/>
 *     &lt;enumeration value="NetBSD"/>
 *     &lt;enumeration value="Slackware"/>
 *     &lt;enumeration value="SLES"/>
 *     &lt;enumeration value="Solaris"/>
 *     &lt;enumeration value="Ubuntu"/>
 *     &lt;enumeration value="Unix"/>
 *     &lt;enumeration value="Windows"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="Unspecified"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OS_Type")
@XmlEnum
public enum OSType {

    ARM("ARM"),
    @XmlEnumValue("Android")
    ANDROID("Android"),
    BSD("BSD"),
    @XmlEnumValue("CentOS")
    CENT_OS("CentOS"),
    @XmlEnumValue("Debian")
    DEBIAN("Debian"),
    @XmlEnumValue("Fedora")
    FEDORA("Fedora"),
    @XmlEnumValue("Fink")
    FINK("Fink"),
    @XmlEnumValue("FreeBSD")
    FREE_BSD("FreeBSD"),
    @XmlEnumValue("OpenBSD")
    OPEN_BSD("OpenBSD"),
    @XmlEnumValue("Gentoo")
    GENTOO("Gentoo"),
    IBM("IBM"),
    @XmlEnumValue("iOS")
    I_OS("iOS"),
    @XmlEnumValue("Linux")
    LINUX("Linux"),
    @XmlEnumValue("macOS")
    MAC_OS("macOS"),
    @XmlEnumValue("Maemo")
    MAEMO("Maemo"),
    @XmlEnumValue("Mandriva")
    MANDRIVA("Mandriva"),
    @XmlEnumValue("NetBSD")
    NET_BSD("NetBSD"),
    @XmlEnumValue("Slackware")
    SLACKWARE("Slackware"),
    SLES("SLES"),
    @XmlEnumValue("Solaris")
    SOLARIS("Solaris"),
    @XmlEnumValue("Ubuntu")
    UBUNTU("Ubuntu"),
    @XmlEnumValue("Unix")
    UNIX("Unix"),
    @XmlEnumValue("Windows")
    WINDOWS("Windows"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("Unspecified")
    UNSPECIFIED("Unspecified");
    private final String value;

    OSType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OSType fromValue(String v) {
        for (OSType c: OSType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
