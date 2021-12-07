import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;

public class BaseDatos {
    private Connection conexion;

    public void conectar(){
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/laliga", "root", "");
        } catch (SQLException e) {
            int ventanaYesNo = JOptionPane.showConfirmDialog(null, "¿Deseas crear la base?", "Base no encontrada",
                    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (ventanaYesNo == 0) {
                crearBase();
                conectar();
                JOptionPane.showMessageDialog(null, "BASE CREADA");
            }else {
                System.exit(0);
            }
        }
    }

    private void crearBase(){

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307", "root", "");
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE DATABASE IF NOT EXISTS laliga";
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void crearTabla() throws SQLException {
        String consulta = "CREATE TABLE coches(id int auto_increment primary key,matricula VARCHAR(20) not null UNIQUE,marca VARCHAR(40) not null,potencia INTEGER,fecha_publicacion TIMESTAMP)";
        PreparedStatement sentencia = null;

        sentencia = conexion.prepareStatement(consulta);
        sentencia.executeUpdate();
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


    public boolean consultarUsuario(String usuario,String password){
        try {
            String SQL = "SELECT * FROM usuario";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                if (rs.getString("email").equals(usuario)){
                    if (rs.getString("password").equals(password)){
                        return true;
                    }
                }
            }

            rs.close();
            stmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
