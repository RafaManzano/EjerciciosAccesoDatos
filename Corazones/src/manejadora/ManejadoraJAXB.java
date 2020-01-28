package manejadora;

import clase.Corazoncitos;
import clase.TipoPersona;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejadoraJAXB {
    Corazoncitos corazones;

    public void abrirListaCorazones(File archivoXML) {
        JAXBContext contexto;
        try {
            contexto = JAXBContext.newInstance(Corazoncitos.class);
            Unmarshaller u = contexto.createUnmarshaller();
            corazones = (Corazoncitos) u.unmarshal(archivoXML);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void anhadirNuevosCorazones (File archivoXML) {
        JAXBContext contexto;
        Corazoncitos adicionales;
        try {
            contexto = JAXBContext.newInstance(Corazoncitos.class);
            Unmarshaller u = contexto.createUnmarshaller();
            adicionales = (Corazoncitos) u.unmarshal(archivoXML);

            for(TipoPersona persona:adicionales.getPersona()){

                corazones.getPersona().add(persona);
            }

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void guardarCorazonesFelices(File archivoXML){
        JAXBContext contexto;
        try {
            contexto = JAXBContext.newInstance(Corazoncitos.class);
            Marshaller marshalero = contexto.createMarshaller();
            marshalero.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter escribiente = new StringWriter();
            marshalero.marshal(corazones, archivoXML);
            marshalero.marshal(corazones, escribiente);
        } catch (JAXBException ex) {
            Logger.getLogger(ManejadoraJAXB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
