/*Construir un programa Java que permita cobrar el valor del impuesto
IVA (que equivale al 19%) de un producto cualquiera usando la
facilidad de las interfaces */

package com.cristian.desarrollo;

import javax.swing.JOptionPane;

public class ProgInterface1 {
    public static void main(String[] args) {
        String nombreArticulo;
        int precioArticulo, cantArticulos;
        double ivaTotal;
        
        nombreArticulo = JOptionPane.showInputDialog("Ingrese el nombre del producto");
        precioArticulo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio unitario del producto"));
        cantArticulos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a llevar"));

        Producto producto1 = new Producto(nombreArticulo, precioArticulo, cantArticulos);
        ivaTotal = producto1.calcularIva(precioArticulo, cantArticulos);

        System.out.println("\nProducto 1");
        System.out.println("\tNombre:\t" + producto1.getNombre());
        System.out.println("\tPrecio: \t" + producto1.getPrecio());
        System.out.println("\tCantidad:\t" + producto1.getCant());
        System.out.println("\tIVA:\t" + ivaTotal);
        System.out.printf("\tTotal a pagar:\t" + producto1.calcularPrecioTotal(precioArticulo, producto1.getCant(), ivaTotal));
        System.out.println();
        
    }
}
