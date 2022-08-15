/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vista.modeloui;

import com.mycompany.modelo.Lider;
import com.mycompany.modelo.Proyecto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProyectoTableModel extends AbstractTableModel{
    
    private List<Proyecto> datos;
    
    public ProyectoTableModel(){
        this.datos = new ArrayList<>();
    }

    public void setDatosProyecto(List<Proyecto> datosProyecto) {
        this.datos = datosProyecto;
        fireTableDataChanged(); // Los datos de la tabla cambiaron
    }
    
    public void addDato(Proyecto proyecto){
        this.datos.add(proyecto);
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
            case 0: 
                return dato.getId();
            case 1: 
                return dato.getConstructora();
            case 2: 
                return dato.getNumeroHabitaciones();
            case 3: 
                 return dato.getCiudad();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {        
        switch (column) {
            case 0: 
                return "ID Proyecto";
            case 1: 
                return "Constructora";
            case 2: 
                return "Número Habitaciones";
            case 3: 
                 return "Ciudad";
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
