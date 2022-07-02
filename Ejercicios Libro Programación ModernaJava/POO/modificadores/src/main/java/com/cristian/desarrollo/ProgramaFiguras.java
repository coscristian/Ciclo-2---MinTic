/*Construir un programa Java que permita calcular el área de un
cuadrado, de un triángulo o de un pentágono apoyándose en el
concepto de sobrecarga de constructores */

package com.cristian.desarrollo;

public class ProgramaFiguras {
    public static void main(String[] args) {
        
        Figura cuad1 = new Figura(4);
        System.out.println(cuad1.mostrarAreaCuad());

        Figura tri1 = new Figura(6,8);
        System.out.println(tri1.mostrarAreaTriang());

        Figura pent1 = new Figura(3,2,5); 
        System.out.println(pent1.mostrarAreaPent());

    }
}
