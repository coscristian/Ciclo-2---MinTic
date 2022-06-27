package Básicos;
/*  Construir un programa que muestre en pantalla la tangente de 60 pero
calculándola a partir de la expresión tan = sin / cos */

public class Tan_ang_2{
    public static void main(String args[]){
        double ang = 60, valor_tan;
        valor_tan = Math.sin(ang) / Math.cos(ang);
        System.out.println("La tangente de " + ang + " radianes es " + valor_tan);
    }
}