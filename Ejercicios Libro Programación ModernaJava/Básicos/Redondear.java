package Básicos;
// Construir un programa que redondee el número 45.678
public class Redondear{
    public static void main(String args[]){
        double num = 45.678;
        int num_redondeado = 0;
        num_redondeado = (int) Math.round(num);
        System.out.println("El numero " + num + " redondeado es " + num_redondeado);
    }
}