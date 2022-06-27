package Básicos;
/*Construir un programa Java que permita leer su edad y determinar a
cuánto es igual la raíz cuadrada de dicha edad */
import java.util.Scanner;

public class EdadRaizCuad{
    public static void main(String args[]){
        double edad, raizEdad;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su edad:");
        edad = sc.nextDouble();

        raizEdad = Math.sqrt(edad);
        System.out.printf("La raiz cuadrada de tu edad es %1.3f %n", raizEdad);

        sc.close();
    }
}