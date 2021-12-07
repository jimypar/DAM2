package com.elenajif.vehiculosbbdd;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by DAM on 02/12/2021.
 */
public class Controlador implements ActionListener, TableModelListener {

    private Vista vista;
    private Modelo modelo;

    private enum tipoEstado {conectado, desconectado}

    ;
    private tipoEstado estado;


    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        estado = tipoEstado.desconectado;

        iniciarTabla();
        addActionListener(this);
        addTableModelListeners(this);
    }

     private void addActionListener(ActionListener listener) {
        vista.btnBuscar.addActionListener(listener);
        vista.btnEliminar.addActionListener(listener);
        vista.btnNuevo.addActionListener(listener);
        vista.itemConectar.addActionListener(listener);
        vista.itemSalir.addActionListener(listener);
    }

    private void addTableModelListeners(TableModelListener listener) {
        vista.dtm.addTableModelListener(listener);
    }

    @Override
    public void tableChanged(TableModelEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "Nuevo":
                break;
            case "Buscar":
                break;
            case "Eliminar":
                break;
            case "Salir":
                break;
            case "Conectar":
                break;
        }

    }

    private void iniciarTabla() {
        String[] headers={"id","matricula","marca","modelo","fecha matriculacion"};
        vista.dtm.setColumnIdentifiers(headers);
    }

    private void cargarFilas(ResultSet resultSet) throws SQLException {
        Object[] fila = new Object[5];
        vista.dtm.setRowCount(0);

        while (resultSet.next()) {
            fila[0]=resultSet.getObject(1);
            fila[1]=resultSet.getObject(2);
            fila[2]=resultSet.getObject(3);
            fila[3]=resultSet.getObject(4);
            fila[4]=resultSet.getObject(5);

            vista.dtm.addRow(fila);
        }

        if (resultSet.last()) {
            vista.lblAccion.setVisible(true);
            vista.lblAccion.setText(resultSet.getRow()+ " filas cargadas");
        }
    }
}
