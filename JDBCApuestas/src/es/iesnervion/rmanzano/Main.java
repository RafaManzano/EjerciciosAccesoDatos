package es.iesnervion.rmanzano;

import es.iesnervion.rmanzano.clases.Partido;
import es.iesnervion.rmanzano.jdbc.JDBC;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        JDBC jdbc = new JDBC();
        Connection c = jdbc.crearConexion();
        //System.out.println(jdbc.realizarApuesta(c, 10.0, UUID.fromString("DC22D7DD-3326-427A-B4D3-8E2F2436AB4C"), "test@test.test", '1'));
        //System.out.println(jdbc.realizarApuesta(c, 10.0, UUID.fromString("DC22D7DD-3326-427A-B4D3-8E2F2436AB4C"), "test@test.test", 2,5));
        //jdbc.realizarApuesta(c, 10.0, UUID.fromString("2FAED649-D9B9-45EB-B24C-B776E76DCE98"), "test@test.test", 2,5);
        ArrayList<Partido> p = jdbc.partidosAbiertos(c);
        p.stream().forEach(a -> System.out.println(a.toString()));
    }
}

