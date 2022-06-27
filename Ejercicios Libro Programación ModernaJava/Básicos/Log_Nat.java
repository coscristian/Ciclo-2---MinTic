package Básicos;
// Construir un programa que calcule el logaritmo natural (base e) de 50
public class Log_Nat{
    public static void main(String args[]){
        double valor = 50, result;
        result = Math.log(valor);
        System.out.println("El logaritmo en base e de " + valor + " es: " + result);
    }
}