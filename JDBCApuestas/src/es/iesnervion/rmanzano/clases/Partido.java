package es.iesnervion.rmanzano.clases;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

public class Partido {
    //private UUID id;
    private String competicion;
    private int golLocal;
    private int golVisitante;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    public Partido() {

    }

    public Partido(String competicion, int golLocal, int golVisitante, Timestamp fechaInicio, Timestamp fechaFin) {
        this.competicion = competicion;
        this.golLocal = golLocal;
        this.golVisitante = golVisitante;
        this.fechaInicio = fechaInicio.toLocalDateTime();
        this.fechaFin = fechaFin.toLocalDateTime();
    }

    /*
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    */
    public String getCompeticion() {
        return competicion;
    }

    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public int getGolLocal() {
        return golLocal;
    }

    public void setGolLocal(int golLocal) {
        this.golLocal = golLocal;
    }

    public int getGolVisitante() {
        return golVisitante;
    }

    public void setGolVisitante(int golVisitante) {
        this.golVisitante = golVisitante;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return competicion + golLocal + golVisitante + fechaInicio + fechaFin;
    }
}
