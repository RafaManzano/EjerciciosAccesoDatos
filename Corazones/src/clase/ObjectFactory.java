
package clase;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the clase package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clase
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TipoPersonaYPreferencias }
     * 
     */
    public TipoPersonaYPreferencias createTipoPersona() {
        return new TipoPersonaYPreferencias();
    }

    /**
     * Create an instance of {@link TipoPersonaYPreferencias.Preferencias }
     * 
     */
    public TipoPersonaYPreferencias.Preferencias createTipoPersonaPreferencias() {
        return new TipoPersonaYPreferencias.Preferencias();
    }

    /**
     * Create an instance of {@link Corazoncitos }
     * 
     */
    public Corazoncitos createCorazoncitos() {
        return new Corazoncitos();
    }

    /**
     * Create an instance of {@link TipoPersonaYPreferencias.Preferencias.Gusto }
     * 
     */
    public TipoPersonaYPreferencias.Preferencias.Gusto createTipoPersonaPreferenciasGusto() {
        return new TipoPersonaYPreferencias.Preferencias.Gusto();
    }

}
