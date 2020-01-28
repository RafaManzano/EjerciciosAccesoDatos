
package clase;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoGrado.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoGrado">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Celsius"/>
 *     &lt;enumeration value="Farenheit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoGrado", namespace = "http://www.example.org/NewXMLSchema")
@XmlEnum
public enum TipoGrado {

    @XmlEnumValue("Celsius")
    CELSIUS("Celsius"),
    @XmlEnumValue("Farenheit")
    FARENHEIT("Farenheit");
    private final String value;

    TipoGrado(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoGrado fromValue(String v) {
        for (TipoGrado c: TipoGrado.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
