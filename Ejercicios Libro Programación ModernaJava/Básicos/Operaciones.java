package Básicos;
/*Construir un programa que muestre en pantalla el resultado de sumar,
restar, multiplicar y dividir dos números que usted asigne a unas
variables */
public class Operaciones{
    public static void main(String args[]){
        int num1 = 30, num2 = 5;
        System.out.println("Suma entre " + num1 + " y " + num2 + " = " + (num1+num2));
        System.out.println("Resta entre " + num1 + " y " + num2 + " = " + (num1 - num2));
        System.out.println("Multiplicacion entre " + num1 + " y " + num2 + " = " + (num1 * num2));
        System.out.println("Division entre " + num1 + " y " + num2 + " = " + (num1 / num2));
    }
}