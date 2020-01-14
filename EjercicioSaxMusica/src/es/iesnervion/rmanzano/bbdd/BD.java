package es.iesnervion.rmanzano.bbdd;

import es.iesnervion.rmanzano.clases.Disco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BD {
    public Connection crearConexion(String usuario, String contrasena){
        String sourceURL = "jdbc:sqlserver://107-05\\MSSQLSERVER2017:62824";
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(sourceURL, usuario, contrasena);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conexion;
    }


    public int insertarDisco(Connection conexion, Disco disco){
        int filas = 0;
        PreparedStatement sentencia = null;
        String  miOrden = "INSERT INTO Discos VALUES(?,?,?,?)";

        try{
            sentencia = conexion.prepareStatement(miOrden);
            sentencia.setString(1, disco.getAutor());
            sentencia.setString(2, disco.getTitulo());
            sentencia.setString(3, disco.getFormato());
            sentencia.setString(4, disco.getLocalizacion());
            filas = sentencia.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();;
        }

        return filas;
    }
}
