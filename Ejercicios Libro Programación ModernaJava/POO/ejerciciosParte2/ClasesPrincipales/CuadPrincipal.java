package POO.ejerciciosParte2.ClasesPrincipales;
import java.util.Scanner;

import POO.ejerciciosParte2.Clases.Cuadrado;

public class CuadPrincipal {
    public static void main(String[] args) {
       //Declaracion de variables
       int lado1, lado2;
       Scanner sc = new Scanner(System.in);
       //Pedir datos al usuario del cuadrado 1
       System.out.print("Por favor, ingrese el valor del lado del cuadrado 1: ");
       lado1 = sc.nextInt();
       //Pedir datos al usuario del cuadrado 2
       System.out.print("Por favor, ingrese el valor del lado del cuadrado 2: ");
       lado2 = sc.nextInt();
       //Crear las instancias de la clase Cuadrado
       Cuadrado Cuad1 = new Cuadrado(lado1);
       Cuadrado Cuad2 = new Cuadrado(lado2);
       //Mostrar por pantalla los atributos de los cuadrados
       System.out.println("Area del cuadrado 1: " + Cuad1.area);
       System.out.println("Perimetro del cuadrado 1: " + Cuad1.perimetro);

       System.out.println("Area del cuadrado 2: " + Cuad2.area);
       System.out.println("Perimetro del cuadrado 2: " + Cuad2.perimetro);
       sc.close();
    }
}
