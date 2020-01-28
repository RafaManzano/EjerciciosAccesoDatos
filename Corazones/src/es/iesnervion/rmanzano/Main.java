package es.iesnervion.rmanzano;

import manejadora.ManejadoraJAXB;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        ManejadoraJAXB manejadora = new ManejadoraJAXB();
        File origen1 = new File("src\\xml\\corazonesSolitarios.xml");
        File origen2 = new File("src\\xml\\masCorazones.xml");
        File destino = new File("src\\xml\\corazonesFelices.xml");

        manejadora.abrirListaCorazones(origen1);
        manejadora.anhadirNuevosCorazones(origen2);
        manejadora.guardarCorazonesFelices(destino);
    }
}
