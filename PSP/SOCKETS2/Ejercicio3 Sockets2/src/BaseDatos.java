import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;

public class BaseDatos {
    private Connection conexion;

    public boolean conectar(){
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/laliga", "root", "");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL CONECTAR");
            return false;
        }
    }


    public void desconectar() throws SQLException {
        conexion.close();
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
                resultado += "Nombre:"+rs.getString("nombre");
                resultado += ":Nacionalidad:"+rs.getString("nacionalidad");
                resultado += ":ID Equipo:"+rs.getString("idEquipo");
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
                resultado += "Nombre:"+rs.getString("nombre");
                resultado += ":Nacionalidad:"+rs.getString("nacionalidad");
                resultado += ":ID Equipo:"+rs.getString("idEquipo");
                resultado += ":Posicion:"+rs.getString("posicion");
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
                resultado += "Nombre:"+rs.getString("nombre");
                resultado += ":Ciudad:"+rs.getString("ciudad");
            }

            rs.close();
            stmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

    public void modificarEntrenador(String nombre, String nuevoNombre, String nuevaNacionalidad, String nuevoEquipo) {

        try {
            PreparedStatement st = conexion.prepareStatement("UPDATE entrenador SET nombre = ?, nacionalidad = ?, idEquipo = ? WHERE nombre = ?");
            st.setString(4, nombre);
            st.setString(1, nuevoNombre);
            st.setString(2, nuevaNacionalidad);
            st.setString(3, nuevoEquipo);
            st.executeUpdate();
            st.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarEstadio(String nombre, String nuevoNombre, String nuevaCiudad) {

        try {
            PreparedStatement st = conexion.prepareStatement("UPDATE estadio SET nombre = ?, ciudad = ? WHERE nombre = ?");

            st.setString(1, nuevoNombre);
            st.setString(2, nuevaCiudad);
            st.setString(3, nombre);
            st.executeUpdate();
            st.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarJugador(String nombre, String nuevoNombre, String nuevaNacionalidad, String nuevoIdEquipo, String nuevaPosicion) {

        try {
            PreparedStatement st = conexion.prepareStatement("UPDATE jugador SET nombre = ?, nacionalidad = ?, idEquipo = ?, posicion = ? WHERE nombre = ?");
            st.setString(5, nombre);
            st.setString(1, nuevoNombre);
            st.setString(2, nuevaNacionalidad);
            st.setString(3, nuevoIdEquipo);
            st.setString(4, nuevaPosicion);
            st.executeUpdate();
            st.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
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
