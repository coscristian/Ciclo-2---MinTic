package Básicos;
// Construir un programa que calcule el logaritmo (base 10) de 30
public class Log_Base_10{
    public static void main(String args[]){
        double valor = 30, result;
        result = Math.log10(valor);
        System.out.println("El logaritmo en base 10 de " + valor + " es: " + result);
    }
}