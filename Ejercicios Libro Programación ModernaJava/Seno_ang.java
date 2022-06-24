// Construir un programa que muestre en pantalla el seno de 45
public class Seno_ang{
    public static void main(String args[]){
        double ang = 45, valor_sen;
        valor_sen = Math.sin(ang);
        System.out.println("El seno de " + ang + " radianes es " + valor_sen);
    }
}