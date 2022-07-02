package com.cristian.desarrollo;

public class Libreria {
    public static void main(String[] args) {
        Libro l1 = new Libro("Probabilidad", "Omar Trejos", "2017");
        System.out.printf(l1.mostrarInfo());

        Libro l2 = new Libro("Python para todos", "Guido Van Rossum", "2020");
        System.out.printf(l2.mostrarInfo());

        Libro l3 = new Libro("Java con aplicaciones", "Alberto Mancilla", "2019");
        System.out.printf(l3.mostrarInfo());
    }
}
