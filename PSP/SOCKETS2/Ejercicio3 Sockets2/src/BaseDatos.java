import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;

public class BaseDatos {
    private Connection conexion;

    public boolean conectar(){
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/laliga", "root", "");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL CONECTAR");
            return false;
        }
    }


    public void desconectar() throws SQLException {
        conexion.close();
    }

    public void insertar(String matricula, String marca, String potencia, LocalDateTime fechaAlta) throws SQLException {
        String consulta = "INSERT INTO coches(matricula, marca, potencia, fecha_publicacion) VALUES(?,?,?,?)";
        PreparedStatement sentencia = null;

        sentencia = conexion.prepareStatement(consulta);
        sentencia.setString(1, matricula);
        sentencia.setString(2, marca);
        sentencia.setString(3, potencia);
        sentencia.setTimestamp(4, Timestamp.valueOf(fechaAlta));

        sentencia.executeUpdate();

        if( sentencia == null ){
            sentencia.close();
        }
    }

    public void eliminar(String matricula) throws SQLException {
        String consulta = "DELETE FROM coches WHERE matricula = ?";
        PreparedStatement sentencia = null;

        sentencia = conexion.prepareStatement(consulta);
        sentencia.setString(1, matricula);
        sentencia.executeUpdate();

        if( sentencia == null ){
            sentencia.close();
        }
    }


    public int consultarUsuario(String usuario, String password){
        try {
            String SQL = "SELECT * FROM usuario";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                if (rs.getString("email").equals(usuario)){
                    if (rs.getString("password").equals(password)){
                        return rs.getInt("es_administrador");
                    }
                }
            }

            rs.close();
            stmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    public String consultarEntrenador(String nombre) {

        String resultado = "";

        try {
            String SQL = "SELECT * FROM entrenador WHERE nombre=?";
            PreparedStatement stmt = conexion.prepareStatement(SQL);
            stmt.setString(1,nombre);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                resultado += "Nombre: "+rs.getString("nombre");
                resultado += ":Nacionalidad: "+rs.getString("nacionalidad");
                resultado += ":ID Equipo: "+rs.getString("idEquipo");
            }

            rs.close();
            stmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

    public String consultarJugador(String nombre) {

        String resultado = "";

        try {
            String SQL = "SELECT * FROM jugador WHERE nombre=?";
            PreparedStatement stmt = conexion.prepareStatement(SQL);
            stmt.setString(1,nombre);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                resultado += "Nombre: "+rs.getString("nombre");
                resultado += ":Nacionalidad: "+rs.getString("nacionalidad");
                resultado += ":Posicion: "+rs.getString("posicion");
            }

            rs.close();
            stmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

    public String consultarEstadio(String nombre) {

        String resultado = "";

        try {
            String SQL = "SELECT * FROM estadio WHERE nombre=?";
            PreparedStatement stmt = conexion.prepareStatement(SQL);
            stmt.setString(1,nombre);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                resultado += "Nombre: "+rs.getString("nombre");
                resultado += ":Ciudad: "+rs.getString("ciudad");
            }

            rs.close();
            stmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

    public void eliminarEntrenador(String nombre) {

        try {
            String SQL = "DELETE entrenador.* FROM entrenador WHERE nombre=?";
            PreparedStatement stmt = conexion.prepareStatement(SQL);
            stmt.setString(1,nombre);
            stmt.executeUpdate();
            stmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void eliminarEstadio(String nombre) {

        try {
            String SQL = "DELETE estadio.* FROM estadio WHERE nombre=?";
            PreparedStatement stmt = conexion.prepareStatement(SQL);
            stmt.setString(1,nombre);
            stmt.executeUpdate();
            stmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void eliminarJugador(String nombre) {

        try {
            String SQL = "DELETE jugador.* FROM jugador WHERE nombre=?";
            PreparedStatement stmt = conexion.prepareStatement(SQL);
            stmt.setString(1,nombre);
            stmt.executeUpdate();
            stmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
