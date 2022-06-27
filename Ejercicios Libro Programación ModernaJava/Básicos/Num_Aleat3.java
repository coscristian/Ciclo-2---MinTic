package Básicos;
/*Construir un programa que muestre en pantalla 3 números aleatorios
comprendidos entre 100 y 200*/
public class Num_Aleat3{
    public static void main(String args[]){
        int a1 = 0, a2 = 0, a3 = 0, min = 100, max = 200, cant_posible;
        cant_posible = max - min + 1;
        a1 = (int) (Math.random() * cant_posible + min);
        a2 = (int) (Math.random() * cant_posible + min);
        a3 = (int) (Math.random() * cant_posible + min);
        System.out.println("Numero aleatorio entre " + min + " y " + max + " = " + a1);
        System.out.println("Numero aleatorio entre " + min + " y " + max + " = " + a2);
        System.out.println("Numero aleatorio entre " + min + " y " + max + " = " + a3);        
    }
}
