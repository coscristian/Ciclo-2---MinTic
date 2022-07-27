package com.cristian.desarrollo.frecuenciaCardiaca;

import javax.swing.JOptionPane;

public class FrecuenciaCardPrueba {
    public static void main(String[] args) {
        String nombre,
                apellido;
        Integer mes,
                dia,
                anio;
        
        try {
            nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre");
            apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido");
            mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero del mes de nacimiento"));
            dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dia de nacimiento"));
            anio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de nacimiento"));
    
            FrecuenciasCardiacas f1 = new FrecuenciasCardiacas(nombre, apellido, mes, dia, anio);
            JOptionPane.showMessageDialog(null, f1);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e);
        }

    }
}


