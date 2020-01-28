/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iesnervion.rmanzano;

import java.io.File;
import beans.*;

/**
 *
 * @author Leo
 */
public class PruebasJAXB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ManejadorAtomos ma = new ManejadorAtomos();
        File origen = new File("src\\xml\\atomos.xml");
        File destino = new File("src\\xml\\masatomos.xml");
        // Cargamos el XML mediante unmarshaling
        ma.abrirListaAtomosJAXB(origen);
        // Comprobamos que se ha cargado
        ma.recorreListaAtomos();
        // Ahora vamos a añadir otro átomo
        Atomo nuevoAtomo = new Atomo();
        nuevoAtomo.setNombre("Mentirio");
        nuevoAtomo.setSimbolo("Mt");
        nuevoAtomo.setNumeroAtomico(111);
        ma.anadirAtomo (nuevoAtomo);
        // Y generamso un nuevo XML mediante marshaling
        ma.guardarListaAtomos(destino);
    }
}
