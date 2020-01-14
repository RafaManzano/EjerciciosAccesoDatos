package es.iesnervion.rmanzano.sax;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sax {
    XMLReader procesadorXML;
    GestionXML gestor;
    InputSource archivoXML;

    public Sax (String nombreArchivo){
        try {
            procesadorXML = XMLReaderFactory.createXMLReader();
        } catch (SAXException ex) {
            Logger.getLogger(Sax.class.getName()).log(Level.SEVERE, null, ex);
        }
        gestor = new GestionXML();
        procesadorXML.setContentHandler(gestor);
        archivoXML = new InputSource(nombreArchivo);
    }
    public void parsear(){
        try {
            procesadorXML.parse(archivoXML);
        } catch (IOException ex) {
            Logger.getLogger(Sax.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Sax.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
