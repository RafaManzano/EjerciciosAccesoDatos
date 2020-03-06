package manejadora;

import clase.Medicamento;
import clase.Medico;
import clase.Receta;
import clase.Recetario;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Manejadora {
    Recetario recetas;

    public void abrirListaRecetas(File archivoXML) {
        JAXBContext contexto;
        try {
            contexto = JAXBContext.newInstance(Recetario.class);
            Unmarshaller u = contexto.createUnmarshaller();
            recetas = (Recetario) u.unmarshal(archivoXML);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public Receta crearObjetoReceta() {
        Receta receta = new Receta();
        Medico medico = new Medico();
        Medicamento medicamento = new Medicamento();
        Receta.Alternativo.Medicamento medicamento1 = new Receta.Alternativo.Medicamento();
        Receta.Alternativo.Medicamento medicamento2 = new Receta.Alternativo.Medicamento();
        List<Receta.Alternativo> alternativoList = new ArrayList<>();

        //Iniciamos medico
        medico.setNumcol((short) 333);
        medico.setEspecialidad("Ginecologo");
        medico.setNombre("Armando elTaco");

        //Iniciamos medicamento
        medicamento.setNombre("Cremita Fresquita");
        medicamento.setLaboratorio("Laboratorio Sevillanas");
        medicamento.setPresentacion("Tubo");

        //Medicamento alternativo1
        medicamento1.setNombre("Cremita Calentita");
        medicamento1.setLaboratorio("Laboratorio Sevillanas");
        medicamento1.setPresentacion("Tubo");

        //Medicamento alternativo2
        medicamento2.setNombre("Pomadita");
        medicamento2.setLaboratorio("Laboratorio La Giralda");
        medicamento2.setPresentacion("Bote");

        //Iniciamos Alternativos
        alternativoList.add(new Receta.Alternativo(medicamento1, (byte) 1));
        alternativoList.add(new Receta.Alternativo(medicamento2, (byte) 2));

        //Incluimos en la receta
        receta = new Receta("3", medico, "11/02/2020", medicamento, alternativoList, (byte)5);

        return receta;
    }

    /*
    public List<Receta> listadoTodasRecetas() {

    }

     */

    public void guardarRecetaXML(File archivoXML, Receta receta){
        JAXBContext contexto;

        try {
            recetas.getReceta().add(receta);
            contexto = JAXBContext.newInstance(Recetario.class);
            Marshaller marshalero = contexto.createMarshaller();
            marshalero.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshalero.marshal(recetas, archivoXML);
        } catch (JAXBException ex) {
            Logger.getLogger(Manejadora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
