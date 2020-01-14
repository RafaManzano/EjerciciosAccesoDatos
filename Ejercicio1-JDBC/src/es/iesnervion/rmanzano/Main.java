package es.iesnervion.rmanzano;

import es.iesnervion.rmanzano.jdbc.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        JDBC jdbc = new JDBC();
        int numFilas = 0;
        ResultSet rs = null;

        Connection conn = jdbc.crearConexion();
        numFilas = jdbc.updateAlturaCristina(conn, 180);
        System.out.println(numFilas);
        rs = jdbc.selectTodasPersonas(conn);
        System.out.println("...........................................PERSONAS.......................................................");
        while(rs.next()) {
            System.out.println(rs.getString("Nombre") + " " + rs.getInt("Altura"));
        }

        rs = jdbc.regalosPorTipo(conn, "A");

        System.out.println("...........................................REGALOS.......................................................");
        while(rs.next()) {
            System.out.println(rs.getString("Denominacion") + " " + rs.getDouble("Precio") + "€");
        }
    }
}
