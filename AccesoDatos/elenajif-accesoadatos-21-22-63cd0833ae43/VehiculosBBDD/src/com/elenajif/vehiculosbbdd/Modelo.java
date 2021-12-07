package com.elenajif.vehiculosbbdd;

import java.sql.*;

/**
 * Created by DAM on 02/12/2021.
 */
public class Modelo {

    private Connection conexion;

    public void conectar() throws SQLException {
        conexion=null;
        conexion= DriverManager.getConnection("jdbc:mysql://localhost:3307/vehiculos","root","");

    }

    public void desconectar() throws SQLException {
        conexion.close();
        conexion = null;
    }

    public ResultSet obtenerDatos() throws SQLException {
        if (conexion==null){
            return null;
        }
        if (conexion.isClosed()){
            return null;
        }
        String consulta = "SELECT * FROM coches";
        PreparedStatement sentencia = null;
        sentencia=conexion.
    }


    public void insertarVehiculo() {

    }

    public void eliminarVehiculo() {

    }

    public void modificarVehiculo() {

    }
}
