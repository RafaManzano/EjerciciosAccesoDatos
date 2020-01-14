package es.iesnervion.rmanzano.metodos;

import java.sql.*;
import java.util.UUID;

public class Metodos {
    /*
    Nombre: abrirPartido
    Comentario: Con este metodo se abre un partido pasado por parametro
    Cabecera: public boolean abrirPartido(Connection conn, UUID idPartido)
    Precondiciones: El partido debe estar creado con anterioridad en la BBDD
    Entrada: Connection conexion //El objeto asociado a la conexion
             UUID idPartido //Es el id del partido que se va a abrir para poder realizar apuestas
    Salida: boolean realizado //Un booleano para saber si se ha realizado correctamente
    E/S: No hay
    Postcondiciones: Asociado al nombre, si es true, se ha podido abrir el partido y si es false no se ha podido
     */
    public boolean abrirPartido(Connection conn, UUID idPartido) {
        //ResultSet rs = null;
        boolean realizado = false;
        int filas = 0;
        String query = "UPDATE Partidos SET EstaAbierto = 1 WHERE ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, idPartido);
            filas = ps.executeUpdate();
            if(filas != 0) {
                realizado = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return realizado;
    }

    /*
    Nombre: cerrarPartido
    Comentario: Con este metodo se cierra un partido pasado por parametro
    Cabecera: public boolean cerrarPartido(Connection conn, UUID idPartido)
    Precondiciones: El partido debe estar creado con anterioridad en la BBDD
    Entrada: Connection conexion //El objeto asociado a la conexion
             UUID idPartido //Es el id del partido que se va a cerrar para no permitir apuestas
    Salida: boolean realizado //Un booleano para saber si se ha realizado correctamente
    E/S: No hay
    Postcondiciones: Asociado al nombre, si es true, se ha podido cerrar el partido y si es false no se ha podido
     */
    public boolean cerrarPartido(Connection conn, UUID idPartido) {
        ///ResultSet rs = null;
        boolean realizado = false;
        int filas = 0;
        String query = "UPDATE Partidos SET EstaAbierto = 0 WHERE ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, idPartido);
            filas = ps.executeUpdate();
            if(filas != 0) {
                realizado = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return realizado;
    }

    /*
    Nombre: pagarApuestasGanadas
    Comentario: Con este metodo se pagan aquellas apuestas que han sido ganadas de un partido pasado por parametro
    Cabecera: public boolean pagarApuestasGanadas (Connection conn, UUID idPartido)
    Precondiciones: El partido debe estar creado con anterioridad en la BBDD
    Entrada: Connection conexion //El objeto asociado a la conexion
             UUID idPartido //Es el id del partido que se van a revisar los ganadores y pagar aquellas ganadoras
    Salida: boolean realizado //Un booleano para saber si se ha realizado correctamente
    E/S: No hay
    Postcondiciones: Asociado al nombre, si es true, se pagan las apuestas y si es false no se ha podido
     */
    public boolean pagarApuestasGanadas (Connection conn, UUID idPartido) {
        boolean realizado = false;
        String query = "{CALL AñadirGanancias(?)}";
        try {
            CallableStatement cs = conn.prepareCall(query);
            cs.setObject(1, idPartido);
            realizado = cs.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return realizado;
    }

}
