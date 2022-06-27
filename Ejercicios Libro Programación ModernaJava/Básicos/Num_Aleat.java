package Básicos;
// Construir un programa que muestre en pantalla 3 números aleatorios comprendidos entre 0.0 y 1.0
public class Num_Aleat{
    public static void main(String args[]){
        double r1, r2, r3;
        r1 = Math.random();
        r2 = Math.random();
        r3 = Math.random();
        System.out.println("Numero aleatorio 1: " + r1);
        System.out.println("Numero aleatorio 2: " + r2);
        System.out.println("Numero aleatorio 3: " + r3);
    }
}