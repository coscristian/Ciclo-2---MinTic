// Construir un programa que muestre en pantalla 3 números aleatorios comprendidos entre 1 y 10
public class Num_Aleat2{
    public static void main(String args[]){
        int aleat = 0, aleat2 = 0, aleat3 = 0, min = 1, max = 10, cant_posib;
        cant_posib = max - min + 1;
        aleat = (int) (Math.random() * cant_posib + min);
        aleat2 = (int) (Math.random() * cant_posib + min);
        aleat3 = (int) (Math.random() * cant_posib + min);
        System.out.println("Numero aleatorio entre " + min + " y " + max + " = " + aleat);
        System.out.println("Numero aleatorio entre " + min + " y " + max + " = " + aleat2);
        System.out.println("Numero aleatorio entre " + min + " y " + max + " = " + aleat3);
    }
}