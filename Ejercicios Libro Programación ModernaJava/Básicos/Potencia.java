package Básicos;
// Construir un programa que calcule el valor de elevar el número e a la potencia 4
public class Potencia{
    public static void main(String args[]){
        double pot = 4, resultado;
        resultado = Math.exp(pot);
        System.out.println("El numero " + Math.E + " elevado a la " + pot + " es " + resultado);
    }
}