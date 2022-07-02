/*Construir un programa Java que permita sumar dos o tres o cuatro
operandos apoyándose en el concepto de sobrecarga de constructores */

package com.cristian.desarrollo;

public class SumaPrincipal {
    public static void main(String[] args) {
        Suma s1 = new Suma(5, 2);
        Suma s2 = new Suma(1, 8);
        Suma s3 = new Suma(2, 2,1);
        Suma s4 = new Suma(6, 2, 1, 2);

        System.out.println(s1.mostrarResultado());
        System.out.println(s2.mostrarResultado());
        System.out.println(s3.mostrarResultado());
        System.out.println(s4.mostrarResultado());

    }
}
