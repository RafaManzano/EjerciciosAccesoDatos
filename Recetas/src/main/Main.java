package main;

import clase.Receta;
import clase.Recetario;
import manejadora.Manejadora;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        Manejadora manejadora = new Manejadora();
        Receta receta = new Receta();
        File archivo = new File("src\\xml\\recetario.xml");
        manejadora.abrirListaRecetas(archivo);
        receta = manejadora.crearObjetoReceta();
        manejadora.guardarRecetaXML(archivo, receta);
    }
}
