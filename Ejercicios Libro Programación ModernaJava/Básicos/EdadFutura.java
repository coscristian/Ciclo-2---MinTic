package Básicos;
/*Construir un programa Java que permita leer su edad y determina
cuántos años tendrá dentro 10 años */
import java.util.Scanner;

public class EdadFutura{
    public static void main(String[] args) {
        System.out.print("Ingrese su edad actual: ");
        Scanner sc = new Scanner(System.in);
        int edad = sc.nextInt();
        edad+=10;
        System.out.printf("En 10 años tendrás %d%n", edad);
        sc.close();
    }
}