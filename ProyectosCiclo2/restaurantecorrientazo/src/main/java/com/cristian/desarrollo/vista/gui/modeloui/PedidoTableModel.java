/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cristian.desarrollo.vista.gui.modeloui;

import com.cristian.desarrollo.modelo.EstadoPedido;
import com.cristian.desarrollo.modelo.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author coscristian
 */
public class PedidoTableModel extends AbstractTableModel{
    
    private List<Pedido> datos;
    
    public PedidoTableModel(){
        this.datos = new ArrayList<>();
    }
    
    public void setDatos(List<Pedido> datos) {
        this.datos = datos;
        fireTableDataChanged();
    }
    
    public void addDato(Pedido pedido){
        this.datos.add(pedido);
        var row = getRowCount() - 1;
        fireTableRowsInserted(row, row);
    }
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row, int column) {
        var dato = datos.get(row);
        switch (column) {
            case 0: // Nombre
                return dato.getCliente();
            case 1: // Entregado
                return dato.getEstado() == EstadoPedido.PEDIENTE_COBRAR;
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: // Nombre
                return "Cliente";
            case 1: // Entregado
                return "Entregado";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: // Nombre
                return String.class;
            case 1: // Entregado
                return Boolean.class;
        }
        return null;
    }
    
    
    
    
    
    
}
