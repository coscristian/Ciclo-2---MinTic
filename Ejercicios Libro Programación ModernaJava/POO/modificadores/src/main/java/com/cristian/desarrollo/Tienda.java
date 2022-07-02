/*Construir un programa Java que permita comprar y vender una
cantidad de huevos de manera que se pueda tener control de los huevos
que se venden, que no se puedan vender más de los que hay y que cada
cantidad de huevos adquiridos incrementen el inventario para vender */

package com.cristian.desarrollo;

public class Tienda {
    public static void main(String[] args) {
        Huevo h0 = new Huevo(0,0);
        System.out.print(h0.mostrarInfo());

        Huevo h1 = new Huevo(1, 0);
        System.out.print(h1.mostrarInfo());

        Huevo h2 = new Huevo(1, 4);
        System.out.print(h2.mostrarInfo());

        Huevo h3 = new Huevo(2, 0);
        System.out.print(h3.mostrarInfo());

        Huevo h4 = new Huevo(1, 2);
        System.out.println(h4.mostrarInfo());
    }
}
