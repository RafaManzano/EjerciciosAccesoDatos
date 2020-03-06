
package clase;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para receta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="receta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="medico" type="{}medico"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="medicamento" type="{}medicamento"/>
 *         &lt;element name="alternativo" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="medicamento">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="laboratorio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="presentacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="ord" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "receta", propOrder = {
    "tipo",
    "medico",
    "fecha",
    "medicamento",
    "alternativo"
})
public class Receta {

    @XmlElement(required = true)
    protected String tipo;
    @XmlElement(required = true)
    protected Medico medico;
    @XmlElement(required = true)
    protected String fecha;
    @XmlElement(required = true)
    protected clase.Medicamento medicamento;
    protected List<Receta.Alternativo> alternativo;
    @XmlAttribute(name = "id")
    protected Byte id;

    public Receta() {
    }

    public Receta(String tipo, Medico medico, String fecha, Medicamento medicamento, List<Alternativo> alternativo, Byte id) {
        this.tipo = tipo;
        this.medico = medico;
        this.fecha = fecha;
        this.medicamento = medicamento;
        this.alternativo = alternativo;
        this.id = id;
    }

    /**
     * Obtiene el valor de la propiedad tipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

    /**
     * Obtiene el valor de la propiedad medico.
     * 
     * @return
     *     possible object is
     *     {@link Medico }
     *     
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * Define el valor de la propiedad medico.
     * 
     * @param value
     *     allowed object is
     *     {@link Medico }
     *     
     */
    public void setMedico(Medico value) {
        this.medico = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecha(String value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad medicamento.
     * 
     * @return
     *     possible object is
     *     {@link clase.Medicamento }
     *     
     */
    public clase.Medicamento getMedicamento() {
        return medicamento;
    }

    /**
     * Define el valor de la propiedad medicamento.
     * 
     * @param value
     *     allowed object is
     *     {@link clase.Medicamento }
     *     
     */
    public void setMedicamento(clase.Medicamento value) {
        this.medicamento = value;
    }

    /**
     * Gets the value of the alternativo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alternativo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlternativo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Receta.Alternativo }
     * 
     * 
     */
    public List<Receta.Alternativo> getAlternativo() {
        if (alternativo == null) {
            alternativo = new ArrayList<Receta.Alternativo>();
        }
        return this.alternativo;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setId(Byte value) {
        this.id = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="medicamento">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="laboratorio" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="presentacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="ord" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "medicamento"
    })
    public static class Alternativo {

        @XmlElement(required = true)
        protected Receta.Alternativo.Medicamento medicamento;
        @XmlAttribute(name = "ord")
        protected Byte ord;

        public Alternativo() {
        }

        public Alternativo(Medicamento medicamento, Byte ord) {
            this.medicamento = medicamento;
            this.ord = ord;
        }

        /**
         * Obtiene el valor de la propiedad medicamento.
         * 
         * @return
         *     possible object is
         *     {@link Receta.Alternativo.Medicamento }
         *     
         */
        public Receta.Alternativo.Medicamento getMedicamento() {
            return medicamento;
        }

        /**
         * Define el valor de la propiedad medicamento.
         * 
         * @param value
         *     allowed object is
         *     {@link Receta.Alternativo.Medicamento }
         *     
         */
        public void setMedicamento(Receta.Alternativo.Medicamento value) {
            this.medicamento = value;
        }

        /**
         * Obtiene el valor de la propiedad ord.
         * 
         * @return
         *     possible object is
         *     {@link Byte }
         *     
         */
        public Byte getOrd() {
            return ord;
        }

        /**
         * Define el valor de la propiedad ord.
         * 
         * @param value
         *     allowed object is
         *     {@link Byte }
         *     
         */
        public void setOrd(Byte value) {
            this.ord = value;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="laboratorio" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="presentacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "nombre",
            "laboratorio",
            "presentacion"
        })
        public static class Medicamento {

            @XmlElement(required = true)
            protected String nombre;
            @XmlElement(required = true)
            protected String laboratorio;
            @XmlElement(required = true)
            protected String presentacion;

            /**
             * Obtiene el valor de la propiedad nombre.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNombre() {
                return nombre;
            }

            /**
             * Define el valor de la propiedad nombre.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNombre(String value) {
                this.nombre = value;
            }

            /**
             * Obtiene el valor de la propiedad laboratorio.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLaboratorio() {
                return laboratorio;
            }

            /**
             * Define el valor de la propiedad laboratorio.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLaboratorio(String value) {
                this.laboratorio = value;
            }

            /**
             * Obtiene el valor de la propiedad presentacion.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPresentacion() {
                return presentacion;
            }

            /**
             * Define el valor de la propiedad presentacion.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPresentacion(String value) {
                this.presentacion = value;
            }

        }

    }

}
