
package com.mycompany.vista.modeloui;

import com.mycompany.modelo.Compra;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CompraTableModel extends AbstractTableModel {
    private List<Compra> datos;
    
    public CompraTableModel(){
        this.datos = new ArrayList<>();
    }

    public void setDatosCompra(List<Compra> datosCompra) {
        this.datos = datosCompra;
        fireTableDataChanged(); // Los datos de la tabla cambiaron
    }
    
    public void addDato(Compra compra){
        this.datos.add(compra);
        var row = getRowCount() - 1;
        fireTableRowsInserted(row, row);
    }
    
    @Override
    public int getRowCount() {       
        return datos.size();       
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        var dato = datos.get(row);
        switch (column) {
            case 0: 
                return dato.getId();
            case 1: 
                return dato.getConstructora();
            case 2: 
                return dato.getBanco();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {        
        switch (column) {
            case 0: 
                return "ID Compra";
            case 1: 
                return "Constructora";
            case 2: 
                return "Banco";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: 
                return Integer.class;
            case 1: 
                return String.class;
            case 2: 
                return String.class;

        }
        return null;
    }
}
