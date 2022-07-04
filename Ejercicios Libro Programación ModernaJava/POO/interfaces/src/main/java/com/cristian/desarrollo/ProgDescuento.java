/*Construir un programa que permita descontar de un producto en
promoción el 20% del precio del producto usando la facilidad de las
interfaces */

package com.cristian.desarrollo;
import javax.swing.JOptionPane;

public class ProgDescuento {

    public static void main(String[] args) {
        String nombreProducto;
        int precioProducto, cantProductos;
        double ivaTotal, descuentoTotal, precioTotal;
        
        nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto");  
        precioProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio unitario del producto"));
        cantProductos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a llevar"));

        Producto p1 = new Producto(nombreProducto, precioProducto, cantProductos);
        ivaTotal = p1.calcularIva(precioProducto, cantProductos);
        descuentoTotal = p1.calcularDesc(precioProducto + ivaTotal);
        precioTotal = p1.calcularPrecioTotal(precioProducto, p1.getCant(), ivaTotal);

        System.out.println("\nProducto 1");
        System.out.println("\tNombre:\t" + p1.getNombre());
        System.out.println("\tPrecio: \t" + p1.getPrecio());
        System.out.println("\tCantidad:\t" + p1.getCant());
        System.out.println("\tIVA:\t" + ivaTotal);
        System.out.println("\tDescuento:\t" + descuentoTotal);
        System.out.println("\tPrecio total sin desc:\t" + precioTotal);
        System.out.println("\tPrecio total con desc:\t" + (precioTotal - descuentoTotal));
        System.out.println();

    }


}
