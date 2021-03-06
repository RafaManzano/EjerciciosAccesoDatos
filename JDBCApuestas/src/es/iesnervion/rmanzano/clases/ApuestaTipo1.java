package es.iesnervion.rmanzano.clases;

import es.iesnervion.rmanzano.clasesAbstractas.Apuesta;

import java.util.UUID;

public class ApuestaTipo1 extends Apuesta {
    private Integer golLocal;
    private Integer golVisitante;

    public ApuestaTipo1() {
        golLocal = 0;
        golVisitante = 0;
    }

    public ApuestaTipo1(UUID id, Double cantidad, Double cuota, UUID idPartido, String correoUsuario, Character tipo, Integer golLocal, Integer golVisitante) {
        super(id, cantidad, cuota, idPartido, correoUsuario, tipo);
        this.golLocal = golLocal;
        this.golVisitante = golVisitante;
    }

    public Integer getGolLocal() {
        return golLocal;
    }

    public void setGolLocal(Integer golLocal) {
        this.golLocal = golLocal;
    }

    public Integer getGolVisitante() {
        return golVisitante;
    }

    public void setGolVisitante(Integer golVisitante) {
        this.golVisitante = golVisitante;
    }
}
