package es.iesnervion.rmanzano;

import es.iesnervion.rmanzano.sax.Sax;

public class Main {

    public static void main(String[] args) {
        String nombreArchivo = "src\\discos.xml";
        Sax sax = new Sax (nombreArchivo);
        sax.parsear();
    }
}
