package Básicos;
// Construir un programa que muestre en pantalla el coseno de 57
public class Cos_ang{
    public static void main(String args[]){
        double ang = 57, valor_cos;
        valor_cos = Math.cos(ang);
        System.out.println("El coseno de " + ang + " radianes es " + valor_cos);
    }
}