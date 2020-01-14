package es.iesnervion.rmanzano.jdbc;

import java.sql.*;

public class JDBC {
    public Connection crearConexion() {
        String sourceUrl = "jdbc:sqlserver://107-05\\MSSQLSERVER2017:62824";
        String usuario = "usuario";
        String password = "usuario";
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(sourceUrl, usuario, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }

    public int updateAlturaCristina(Connection conexion, int altura)  {
        int numFilas = 0;
        try {
            Statement sentencia = conexion.createStatement();
            String update = "UPDATE Personas SET Altura = " + altura + " WHERE Nombre = 'Cristina'";

            numFilas = sentencia.executeUpdate(update);
            //conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numFilas;
    }

    public ResultSet selectTodasPersonas(Connection conexion) {
        ResultSet rs = null;
        try {
            Statement sentencia = conexion.createStatement();
            String query = "SELECT Nombre, Altura FROM Personas";
            rs = sentencia.executeQuery(query);
            //conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet regalosPorTipo(Connection cox, String tipo) {
        String query = "SELECT Denominacion, Precio FROM Regalos WHERE Tipo = ?";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = cox.prepareStatement(query);
            ps.setString(1, tipo);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }


}
