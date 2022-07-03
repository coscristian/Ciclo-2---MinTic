package com.cristian.desarrollo;

public class AparatoPrincipal {

    public static void main(String[] args) {
        //Usando el principio de sustitucion el cual permite almacenar un objeto de una subclase en donde se espera un objeto de tipo superclase
        Portatil2 p1 = new Portatil2("Lenovo", "2", "Gris", "No", 4000,"i3", 8000, "No","No");
        Nevera n1 = new Nevera("Mabe", "40", "Gris", "No", "Si");
        Ventilador v1 = new Ventilador("Lasko", "5", "Gris Oscuro", "No", "Si", "Si");
        Electrodomestico e1 = new Electrodomestico("Mabe", "20", "Azul", "Si");
        Dispositivo2 d1 = new Dispositivo2("Xiaomi", "5", "Negro", "No", 4000, "i2", 0);

        System.out.println(p1.mostrarMarca());
        System.out.println(n1.mostrarMarca());
        System.out.println(v1.mostrarMarca());
        System.out.println(e1.mostrarMarca());
        System.out.println(d1.mostrarMarca());


    }

}
