package es.iesnervion.rmanzano.clases;

import es.iesnervion.rmanzano.clasesAbstractas.Apuesta;

import java.util.UUID;

public class ApuestaTipo3 extends Apuesta {
    Character unoxDos;

    public ApuestaTipo3() {
        unoxDos = ' ';
    }

    public ApuestaTipo3(UUID id, Double cantidad, Double cuota, UUID idPartido, String correoUsuario, Character tipo, Character unoxDos) {
        super(id, cantidad, cuota, idPartido, correoUsuario, tipo);
        this.unoxDos = unoxDos;
    }

    public Character getUnoxDos() {
        return unoxDos;
    }

    public void setUnoxDos(Character unoxDos) {
        this.unoxDos = unoxDos;
    }
}
