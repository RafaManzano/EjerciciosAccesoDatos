package es.iesnervion.rmanzano.jdbc;

import es.iesnervion.rmanzano.clases.ApuestaTipo1;
import es.iesnervion.rmanzano.clases.ApuestaTipo2;
import es.iesnervion.rmanzano.clases.ApuestaTipo3;
import es.iesnervion.rmanzano.clases.Partido;
import es.iesnervion.rmanzano.clasesAbstractas.Apuesta;

import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public class JDBC {

    /*
    Interfaz
    Nombre: crearConexion
    Comentario: Con este metodo se crearia la conexion y nos devuelve el objeto asociado a la conexion
    Cabecera: public Connection crearConexion()
    Precondiciones: No hay
    Entrada: No hay
    Salida: Connection conexion //El objeto asociado a la conexion
    E/S: No hay
    Postcondiciones: Asociado al nombre, el objeto asociado a la conexion para su posterior uso
     */
    public Connection crearConexion() {
        String sourceUrl = "jdbc:sqlserver://107-05\\MSSQLSERVER2017:62824";
        String usuario = "p0";
        String password = "p0";
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(sourceUrl, usuario, password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }

    /*
    Nombre: RealizarApuestas (Para Tipo1)
    Comentario: Con este metodo se realizan las apuestas del tipo 1 y nos devuelve un boolean si se ha realizado
    correctamente o no
    Cabecera: public boolean realizarApuesta(Connection conexion, Double cantidad, UUID idPartido, String correo, Integer golLocal, Integer golVisitante)
    Precondiciones: El partido debe estar introducido en la BBDD con anterioridad
                    El correo debe existir en la BBDD con anterioridad
    Entrada: Connection conn //Es la conexion con la BBDD
             Double cantidad //La cantidad apostada
             UUID idPartido //El partido donde se quiere realizar la apuesta
             String correo //El correo del usuario de la apuesta
             Integer golLocal //Los goles introducidos al equipo local
             Integer golVisitante //Los goles introducidos al equipo visitante
    Salida: boolean resultado //Si es true es que se ha realizado la apuesta y si es false no se ha realizado
    E/S: No hay
    Postcondiciones: Asociado al nombre, el boolean realizado si es true es que se ha realizado la apuesta y si es false no se ha realizado
     */
    public boolean realizarApuesta(Connection conexion, Double cantidad, UUID idPartido, String correo, Integer golLocal, Integer golVisitante) {
        //String query = "EXECUTE RealizarApuestaTipo1(?,?,?,?,?,?)";
        String query = "{CALL RealizarApuestaTipo1(?,?,?,?,?,?)}";
        double cuota = 0.0;
        boolean resultado = false;
        //ResultSet rs = null;
        cuota = calcularCuota(conexion,'1', idPartido, golLocal, golVisitante);
        if(cuota > 1.5) {
            try {
                CallableStatement cs = conexion.prepareCall(query);
                cs.setDouble(1, cantidad);
                cs.setDouble(2, cuota);
                cs.setObject(3, idPartido);
                cs.setString(4, correo);
                cs.setInt(5, golLocal);
                cs.setInt(6, golVisitante);
                cs.executeQuery();

                resultado = true;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultado;
    }

    /*
    Nombre: RealizarApuestas (Para Tipo2)
    Comentario: Con este metodo se realizan las apuestas del tipo 2 y nos devuelve un boolean si se ha realizado
    correctamente o no
    Cabecera: public boolean realizarApuesta(Connection conexion, Double cantidad, UUID idPartido, String correo,
    Character localOVisitante, Integer goles)
    Precondiciones: El partido debe estar introducido en la BBDD con anterioridad
                    El correo debe existir en la BBDD con anterioridad
    Entrada: Connection conn //Es la conexion con la BBDD
             Double cantidad //La cantidad apostada
             UUID idPartido //El partido donde se quiere realizar la apuesta
             String correo //El correo del usuario de la apuesta
             Character localOVisitante //Un caracter que decide cual es el equipo al que se desea apostar
             Integer goles //Los goles introducidos al equipo
    Salida: boolean resultado //Si es true es que se ha realizado la apuesta y si es false no se ha realizado
    E/S: No hay
    Postcondiciones: Asociado al nombre, el boolean realizado si es true es que se ha realizado la apuesta y si es false no se ha realizado
 */
    public boolean realizarApuesta(Connection conexion, Double cantidad, UUID idPartido, String correo, Character localOVisitante, Integer goles) {
        String query = "EXECUTE RealizarApuestaTipo2(?,?,?,?,?,?)";
        double cuota = 0.0;
        boolean resultado = false;
        cuota = calcularCuota(conexion,'2', idPartido, localOVisitante, goles);
        if(cuota > 1.5) {
            try {
                CallableStatement cs = conexion.prepareCall(query);
                cs.setDouble(1, cantidad);
                cs.setDouble(2, cuota);
                cs.setObject(3, idPartido);
                cs.setString(4, correo);
                cs.setString(5, String.valueOf(localOVisitante));
                cs.setInt(6, goles);

                cs.execute();

                resultado = true;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultado;
    }

    /*
    Nombre: RealizarApuestas (Para Tipo3)
    Comentario: Con este metodo se realizan las apuestas del tipo 3 y nos devuelve un boolean si se ha realizado
    correctamente o no
    Cabecera: public boolean realizarApuesta(Connection conexion, Double cantidad, UUID idPartido, String correo,
    Character unoxdos)
    Precondiciones: El partido debe estar introducido en la BBDD con anterioridad
                    El correo debe existir en la BBDD con anterioridad
    Entrada: Connection conn //Es la conexion con la BBDD
             Double cantidad //La cantidad apostada
             UUID idPartido //El partido donde se quiere realizar la apuesta
             String correo //El correo del usuario de la apuesta
             Character unoxdos //Un caracter que decide cual es el equipo ganador del encuentro
    Salida: boolean resultado //Si es true es que se ha realizado la apuesta y si es false no se ha realizado
    E/S: No hay
    Postcondiciones: Asociado al nombre, el boolean realizado si es true es que se ha realizado la apuesta y si es false no se ha realizado
*/
    public boolean realizarApuesta(Connection conexion, Double cantidad, UUID idPartido, String correo, Character unoxdos) {
        String query = "EXECUTE RealizarApuestaTipo3(?,?,?,?,?)";
        double cuota = 0.0;
        boolean resultado = false;
        cuota = calcularCuota(conexion,'3', idPartido, unoxdos);
        if(cuota > 1.5) {
            try {
                CallableStatement cs = conexion.prepareCall(query);
                cs.setDouble(1, cantidad);
                cs.setDouble(2, cuota);
                cs.setObject(3, idPartido);
                cs.setString(4, correo);
                cs.setString(5, String.valueOf(unoxdos));
                resultado = cs.execute();

                resultado = true;


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultado;
    }

    /*
    Interfaz
    Nombre: calcularCuota (Tipo 1)
    Comentario: Con este metodo se calculara la cuota para apuestas del tipo 1
    Cabecera: public double calcularCuota(Connection conn, char tipo , UUID idPartido, Integer golLocal, Integer golVisitante)
    Precondiciones: El partido debe estar introducido en la BBDD con anterioridad
    Entrada: Connection conn //Es la conexion con la BBDD
             char tipo //Es el tipo de la apuesta a introducir
             UUID idPartido //El partido donde de la apuesta que se desea introducir
             Integer golLocal //Los goles introducidos al equipo local
             Integer golVisitante //Los goles introducidos al equipo visitante
    Salida: double resultado //Es la cuota final de la apuesta
    E/S: No hay
    Postcondiciones: Asociado al nombre, la cuota final de la apuesta
     */
    public double calcularCuota(Connection conn, char tipo , UUID idPartido, Integer golLocal, Integer golVisitante){
        double resultado = 0.0;
        double cantidad = 0.0;
        double t = 0.0;
        ResultSet rs = null;
        String query = "SELECT SUM (cantidad) AS cantidad FROM Apuestas WHERE Tipo = ? AND IDPartido = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, String.valueOf(tipo));
            ps.setObject(2, idPartido);
            rs = ps.executeQuery();

            if(rs.next()) {
                cantidad = rs.getDouble(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(cantidad <= 40) {
            resultado = 4.0;
        }
        else {
            //Query apuestas igual a la apostada
            query = "SELECT SUM(A.cantidad) AS cantidad FROM Apuestas AS A " +
                    "INNER JOIN ApuestasTipo1 AS AP ON A.ID = AP.IDApuesta " +
                    "WHERE AP.GolesLocal = ? AND AP.GolesVisitante = ? AND A.IDPartido = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, golLocal);
                ps.setInt(2, golVisitante);
                ps.setObject(3, idPartido);
                rs = ps.executeQuery();

                if(rs.next()) {
                    t = rs.getDouble("cantidad");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            resultado = ((cantidad/t) - 1) * 0.8;
        }
        return resultado;
    }

    /*
    Interfaz
    Nombre: calcularCuota (Tipo 2)
    Comentario: Con este metodo se calculara la cuota para apuestas del tipo 2
    Cabecera: public double calcularCuota(Connection conn, char tipo , UUID idPartido, Character localOVisitante, Integer goles)
    Precondiciones: El partido debe estar introducido en la BBDD con anterioridad
    Entrada: Connection conn //Es la conexion con la BBDD
             char tipo //Es el tipo de la apuesta a introducir
             UUID idPartido //El partido donde de la apuesta que se desea introducir
             Character localOVisitante //Un caracter que decide cual es el equipo al que se desea apostar
             Integer goles //Los goles introducidos al equipo
    Salida: double resultado //Es la cuota final de la apuesta
    E/S: No hay
    Postcondiciones: Asociado al nombre, la cuota final de la apuesta
    */
    public double calcularCuota(Connection conn, char tipo , UUID idPartido, char localOVisitante, Integer goles){
        double resultado = 0.0;
        double cantidad = 0.0;
        double t = 0.0;
        ResultSet rs = null;
        String query = "SELECT SUM (cantidad) AS cantidad FROM Apuestas WHERE Tipo = ? AND IDPartido = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, String.valueOf(tipo));
            ps.setObject(2, idPartido);
            rs = ps.executeQuery();

            if(rs.next()) {
                cantidad = rs.getDouble("cantidad");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(cantidad <= 40) {
            resultado = 3.0;
        }
        else {
            //Query apuestas igual a la apostada
            query = "SELECT SUM(A.cantidad) AS cantidad FROM Apuestas AS A " +
                    "INNER JOIN ApuestasTipo2 AS AP2 ON A.ID = AP2.IDApuesta " +
                    "WHERE AP2.LocalOVisitante = ? AND AP2.Goles = ? AND A.IDPartido = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, String.valueOf(localOVisitante));
                ps.setInt(2, goles);
                ps.setObject(3, idPartido);
                rs = ps.executeQuery();

                if(rs.next()) {
                    t = rs.getDouble("cantidad");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            resultado = ((cantidad/t) - 1) * 0.8;
        }
        return resultado;
    }

    /*
   Interfaz
   Nombre: calcularCuota (Tipo 3)
   Comentario: Con este metodo se calculara la cuota para apuestas del tipo 3
   Cabecera: public double calcularCuota(Connection conn, char tipo , UUID idPartido, Character unoxdos)
   Precondiciones: El partido debe estar introducido en la BBDD con anterioridad
   Entrada: Connection conn //Es la conexion con la BBDD
            char tipo //Es el tipo de la apuesta a introducir
            UUID idPartido //El partido donde de la apuesta que se desea introducir
            Character unoxdos //Un caracter que decide cual es el equipo ganador
            Integer goles //Los goles introducidos al equipo
   Salida: double resultado //Es la cuota final de la apuesta
   E/S: No hay
   Postcondiciones: Asociado al nombre, la cuota final de la apuesta
   */
    public double calcularCuota(Connection conn, char tipo , UUID idPartido, char unoxDos){
        double resultado = 0.0;
        double cantidad = 0.0;
        double t = 0.0;
        ResultSet rs = null;
        String query = "SELECT SUM (cantidad) AS cantidad FROM Apuestas WHERE Tipo = ? AND IDPartido = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, String.valueOf(tipo));
            ps.setObject(2, idPartido);
            rs = ps.executeQuery();

            if(rs.next()) {
                cantidad = rs.getDouble("cantidad");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(cantidad <= 40) {
            resultado = 3.0;
        }
        else {
            //Query apuestas igual a la apostada
            query = "SELECT SUM(A.cantidad) AS Total FROM Apuestas AS A " +
                    "INNER JOIN ApuestasTipo3 AS AP3 ON A.ID = AP3.IDApuesta " +
                    "WHERE AP3.[1X2] = ?  AND A.IDPartido = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, String.valueOf(unoxDos));
                ps.setObject(2, idPartido);
                rs = ps.executeQuery();

                if(rs.next()) {
                    t = rs.getDouble("cantidad");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            resultado = ((cantidad/t) - 1) * 0.8;
        }
        return resultado;
    }

    /*
    Interfaz
    Nombre: partidosAbiertos
    Comentario: Con este metodo se mostrarian los partidos que estan abiertos en este momento
    Cabecera: public ArrayList<Partido> partidosAbiertos(Connection conexion)
    Precondiciones: No hay
    Entrada: Connection conexion //El objeto asociado a la conexion
    Salida: ArrayList<Partido> partidos //Una lista con los partidos que estan abiertos
    E/S: No hay
    Postcondiciones: Asociado al nombre, una lista con los partidos que estan abiertos
     */
    public ArrayList<Partido> partidosAbiertos(Connection conexion) {
        String query = "SELECT * FROM Partidos WHERE EstaAbierto = 1";
        Partido partido = new Partido();
        ArrayList<Partido> partidos = new ArrayList<>();
        ResultSet rs = null;
            try {
                Statement s = conexion.createStatement();
                rs = s.executeQuery(query);

                while(rs.next()) {
                    partido = new Partido(rs.getString("competicion"), rs.getInt("golesLocal"), rs.getInt("golesVisitante"), (Timestamp) rs.getObject("fechaInicio"), (Timestamp)rs.getObject("fechaFin"));
                    partidos.add(partido);
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

        return partidos;
    }


    /*
    Interfaz
    Nombre: apuestaCompleta
    Comentario: Con este metodo se muestra la informacion completa de la apuesta
    Cabecera: public Apuesta apuestaCompleta(Connection conn, UUID idApuesta, Character tipo)
    Precondiciones: La apuesta debe estar creada con anterioridad en la BBDD
    Entrada: Connection conexion //El objeto asociado a la conexion
             UUID idApuesta //Es el id de la apuesta que se quiere mostrar su informacion
             Character tipo //Es el tipo de apuesta realizada
    Salida: Apuesta ap //Es la apuesta con toda su informacion
    E/S: No hay
    Postcondiciones: Asociado al nombre, la apuesta con su informacion
    **** NOTA: Apuesta es abstracta, el objeto que se devolvera sera ApuestaTipo1 o ApuestaTipo2 o ApuestaTipo3 ****
     */

    public Apuesta apuestaCompleta(Connection conn, UUID idApuesta, Character tipo) {
        Apuesta ap;
        if(tipo == '1') {
            ap = apuestaCompletaTipo1(conn, idApuesta);
        }
        else if(tipo == '2') {
            ap = apuestaCompletaTipo2(conn, idApuesta);
        }
            else {
                ap = apuestaCompletaTipo3(conn, idApuesta);
            }
        return ap;
    }

    /*
    Nombre: apuestaCompletaTipo1
    Comentario: Con este metodo se muestra la informacion completa de la apuesta de tipo 1
    Cabecera: public ApuestaTipo1 apuestaCompletaTipo1(Connection conn, UUID idApuesta)
    Precondiciones: La apuesta debe estar creada con anterioridad en la BBDD
    Entrada: Connection conexion //El objeto asociado a la conexion
             UUID idApuesta //Es el id de la apuesta que se quiere mostrar su informacion
    Salida: ApuestaTipo1 apuesta //Es la apuesta de tipo 1 con toda su informacion
    E/S: No hay
    Postcondiciones: Asociado al nombre, la apuesta de tipo 1 con su informacion
     */
    public ApuestaTipo1 apuestaCompletaTipo1(Connection conn, UUID idApuesta) {
        ApuestaTipo1 apuesta = new ApuestaTipo1();
        ResultSet rs = null;
        String query = "SELECT A.CorreoUsuario, A.cantidad, A.cuota, IDPartido, A.Tipo, AT.GolesLocal, AT.GolesVisitante FROM Apuestas AS A INNER JOIN ApuestasTipo1 AS AT ON A.ID AND AT.IDApuestas WHERE AT.IDApuesta = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, idApuesta);
            rs = ps.executeQuery();

            if(rs.next()) {
                apuesta = new ApuestaTipo1(new UUID(0,0).fromString(rs.getString("ID")), rs.getDouble("cantidad"), rs.getDouble("cuota"), new UUID(0,0).fromString(rs.getString("IDPartido")), rs.getString("CorreoUsuario"), rs.getString("Tipo").charAt(0), rs.getInt("GolesLocal"), rs.getInt("GolesVisitante"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

       return apuesta;
    }

    /*
    Nombre: apuestaCompletaTipo2
    Comentario: Con este metodo se muestra la informacion completa de la apuesta de tipo 2
    Cabecera: public ApuestaTipo2 apuestaCompletaTipo2(Connection conn, UUID idApuesta)
    Precondiciones: La apuesta debe estar creada con anterioridad en la BBDD
    Entrada: Connection conexion //El objeto asociado a la conexion
             UUID idApuesta //Es el id de la apuesta que se quiere mostrar su informacion
    Salida: ApuestaTipo2 apuesta //Es la apuesta de tipo 2 con toda su informacion
    E/S: No hay
    Postcondiciones: Asociado al nombre, la apuesta de tipo 2 con su informacion
     */
    public ApuestaTipo2 apuestaCompletaTipo2(Connection conn, UUID idApuesta) {
        ApuestaTipo2 apuesta = new ApuestaTipo2();
        ResultSet rs = null;
        String query = "SELECT A.CorreoUsuario, A.cantidad, A.cuota, IDPartido, A.Tipo, AT.LocalOVisitante, AT.Goles FROM Apuestas AS A INNER JOIN ApuestasTipo2 AS AT ON A.ID AND AT.IDApuestas WHERE AT.IDApuesta = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, idApuesta);
            rs = ps.executeQuery();

            if(rs.next()) {
                apuesta = new ApuestaTipo2(new UUID(0,0).fromString(rs.getString("ID")), rs.getDouble("cantidad"), rs.getDouble("cuota"), new UUID(0,0).fromString(rs.getString("IDPartido")), rs.getString("CorreoUsuario"), rs.getString("Tipo").charAt(0), rs.getString("LocalOVisitante").charAt(0), rs.getInt("Goles"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apuesta;
    }

    /*
    Nombre: apuestaCompletaTipo3
    Comentario: Con este metodo se muestra la informacion completa de la apuesta de tipo 3
    Cabecera: public ApuestaTipo3 apuestaCompletaTipo3(Connection conn, UUID idApuesta)
    Precondiciones: La apuesta debe estar creada con anterioridad en la BBDD
    Entrada: Connection conexion //El objeto asociado a la conexion
             UUID idApuesta //Es el id de la apuesta que se quiere mostrar su informacion
    Salida: ApuestaTipo3 apuesta //Es la apuesta de tipo 3 con toda su informacion
    E/S: No hay
    Postcondiciones: Asociado al nombre, la apuesta de tipo 3 con su informacion
     */
    public ApuestaTipo3 apuestaCompletaTipo3(Connection conn, UUID idApuesta) {
        ApuestaTipo3 apuesta = new ApuestaTipo3();
        ResultSet rs = null;
        String query = "SELECT A.CorreoUsuario, A.cantidad, A.cuota, IDPartido, A.Tipo, AT.[1X2] FROM Apuestas AS A INNER JOIN ApuestasTipo3 AS AT ON A.ID AND AT.IDApuestas WHERE AT.IDApuesta = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, idApuesta);
            rs = ps.executeQuery();

            if(rs.next()) {
                apuesta = new ApuestaTipo3(new UUID(0,0).fromString(rs.getString("ID")), rs.getDouble("cantidad"), rs.getDouble("cuota"), new UUID(0,0).fromString(rs.getString("IDPartido")), rs.getString("CorreoUsuario"), rs.getString("Tipo").charAt(0), rs.getString("[1X2]").charAt(0));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apuesta;
    }

}
