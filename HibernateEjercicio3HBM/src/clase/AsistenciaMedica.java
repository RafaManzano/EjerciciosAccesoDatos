package clase;

import java.io.Serializable;

public class AsistenciaMedica implements Serializable {
    private int idAsistenciaMedica;
    private Seguro seguro;
    private String breveDescripcion;
    private String lugar;

    public AsistenciaMedica() {
    }

    public AsistenciaMedica(int idAsistenciaMedica, Seguro seguro, String breveDescripcion, String lugar) {
        this.idAsistenciaMedica = idAsistenciaMedica;
        this.seguro = seguro;
        this.breveDescripcion = breveDescripcion;
        this.lugar = lugar;
    }

    public int getIdAsistenciaMedica() {
        return idAsistenciaMedica;
    }

    public void setIdAsistenciaMedica(int idAsistenciaMedica) {
        this.idAsistenciaMedica = idAsistenciaMedica;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public String getBreveDescripcion() {
        return breveDescripcion;
    }

    public void setBreveDescripcion(String breveDescripcion) {
        this.breveDescripcion = breveDescripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
