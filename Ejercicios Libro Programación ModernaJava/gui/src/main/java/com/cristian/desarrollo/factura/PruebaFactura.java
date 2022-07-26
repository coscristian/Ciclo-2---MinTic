package com.cristian.desarrollo.factura;

import javax.swing.JOptionPane;

public class PruebaFactura {
    public static void main(String[] args) {
        
        String numeroPieza,
                descripcion;
        Integer cantArticulos;
        Double precioUnidad;

        try {
            numeroPieza = JOptionPane.showInputDialog(null, "Ingrese el numero(ID) de la pieza");
            descripcion = JOptionPane.showInputDialog(null, "Ingrese la descripción de la pieza");
            cantArticulos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de piezas"));
            precioUnidad = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el precio por unidad"));
            
            Factura f1 = new Factura(numeroPieza, descripcion, cantArticulos, precioUnidad);
            JOptionPane.showMessageDialog(null, f1);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e);
        }
    }
}
