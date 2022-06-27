package Básicos;
/*Construir un programa que calcula el resultado de elevar 5 a la 8 */
public class Elevar2{
    public static void main(String[] args){
        byte base = 5, exp = 8;
        System.out.println("EL resultado de elevar " + base + " a la " + exp + " es: " + (int) Math.pow(base, exp));
    }
}