
package com.mycompany.vista.modeloui;

import com.mycompany.modelo.Lider;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class LiderTableModel extends AbstractTableModel{
    
    private List<Lider> datos;
    
    public LiderTableModel(){
        this.datos = new ArrayList<>();
    }

    public void setDatosLider(List<Lider> datosLider) {
        this.datos = datosLider;
        fireTableDataChanged(); // Los datos de la tabla cambiaron
    }
    
    public void addDato(Lider lider){
        this.datos.add(lider);
        var row = getRowCount() - 1;
        fireTableRowsInserted(row, row);
    }
    
    @Override
    public int getRowCount() {       
        return datos.size();       
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int column) {
        var dato = datos.get(row);
        switch (column) {
            case 0: // ID               
                return dato.getId();
            case 1: // Nombre
                return dato.getNombre();
            case 2: // Primer apellido
                return dato.getPrimerApellido();
            case 3: // Ciudad Residencia
                 return dato.getCiudadResidencia();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {        
        switch (column) {
            case 0: // ID               
                return "ID Lider";
            case 1: // Nombre
                return "Nombre";
            case 2: // Primer apellido
                return "Primer Apellido";
            case 3: // Ciudad Residencia
                 return "Ciudad Residencia";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: // ID               
                return Integer.class;
            case 1: // Nombre
                return String.class;
            case 2: // Primer apellido
                return String.class;
            case 3: // Ciudad Residencia
                 return String.class;
        }
        return null;
    }
}
