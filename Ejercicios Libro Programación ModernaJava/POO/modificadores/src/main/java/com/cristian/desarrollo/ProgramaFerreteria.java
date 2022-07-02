/*Construir un programa Java que permita crear los artículos de una
ferretería (almacén donde se venden herramientas) de manera que cada
una tenga un Código de Referencia, un Nombre, una Descripción y un
Precio de Venta. Se necesita que el código de referencia de cada
herramienta no pueda ser modificada desde otra clase */

package com.cristian.desarrollo;

import java.util.Scanner;

public class ProgramaFerreteria {
    public static void main( String[] args ){
        String codigo, nombre, descripcion;
        Double precio;
        Scanner sc = new Scanner(System.in); 

        System.out.print("Ingrese el codigo del producto: ");
        codigo = sc.nextLine();

        System.out.print("Ingrese el nombre del producto: ");
        nombre = sc.nextLine();

        System.out.print("Ingrese la descripcion del producto: ");
        descripcion = sc.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        precio = sc.nextDouble();

        Articulo martillo = new Articulo(codigo, nombre, descripcion, precio);
        System.out.println(martillo.mostrarInfo());

        sc.close();
    }
}
