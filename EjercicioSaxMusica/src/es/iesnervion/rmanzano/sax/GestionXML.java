package es.iesnervion.rmanzano.sax;

import es.iesnervion.rmanzano.bbdd.BD;
import es.iesnervion.rmanzano.clases.Disco;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.Connection;
import java.util.ArrayList;

public class GestionXML extends DefaultHandler {
    private String propiedad;
    private Disco disco;
    private ArrayList<Disco> discos;
    private BD bbdd = new BD();
    Connection conn = bbdd.crearConexion("admin", "admin");
    public GestionXML() {
        super();
        disco = new Disco();
        discos = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String nombre, String nombreC, Attributes att){
        //System.out.println("\t< "+nombre +">");
        propiedad = nombre;
    }

    @Override
    public void endElement(String uri, String nombre, String nombreC){
        if(nombre == "album") {
            //discos.add(disco);
            //InsertarDisco
            bbdd.insertarDisco(conn, disco);
        }
    }

    @Override
    public void characters (char[] ch, int inicio, int longitud) throws SAXException {
        String cad = new String(ch, inicio, longitud);
        cad = cad.replaceAll("[\t\n]",""); // Quitamos tabuladores y saltos de linea
        if(!cad.equalsIgnoreCase("")) {
            switch (propiedad) {
                case"autor":
                    disco.setAutor(cad);
                    break;

                case"titulo":
                    disco.setTitulo(cad);
                    break;

                case "formato":
                    disco.setFormato(cad);
                    break;

                case "localizacion" :
                    disco.setLocalizacion(cad);
                    break;
            }
        }

        //System.out.println("\t\t" + cad);
        //propiedad = "";
    }

}
