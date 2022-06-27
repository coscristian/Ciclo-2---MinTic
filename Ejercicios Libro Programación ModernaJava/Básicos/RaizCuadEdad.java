package Básicos;
/*Construir un programa Java que permita leer su estatura y determinar
a cuánto es igual la raíz cuadrada de su edad */
import java.util.Scanner;

public class RaizCuadEdad{
    public static void main(String args[]){
        double estatura, raizEstatura;

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su estatura: ");
        estatura = sc.nextDouble();

        raizEstatura = Math.sqrt(estatura);
        System.out.printf("Su estatura es: %1.2f %n", estatura);
        System.out.printf("La raiz cuadrada de su estatura es: %1.3f%n", raizEstatura);

        sc.close();
    }
}