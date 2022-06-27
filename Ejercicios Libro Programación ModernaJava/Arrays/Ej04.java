/* Construir un programa que lea un conjunto de 10 datos y, después de
leídos, determine en qué posición está el menor número impar */

package Arrays;
import java.util.Scanner;

public class Ej04 {
    public static void main(String[] args) {
        int Pos;
        if ((Pos = menorImpar(leerDatos())) != -1){
            System.out.println("El menor numero impar se encuentra en la posicion: " + (Pos+1));
        }else{
            System.out.println("No hay por lo menos un numero impar...");
        }
    }

    private static int menorImpar(int[] Vector){
        int MenorImpar = 999999, Pos = -1;
        for(int i = 0; i < Vector.length; i++){
            if (Vector[i] % 2 != 0){
                if (Vector[i] < MenorImpar){
                    MenorImpar = Vector[i];
                    Pos = i;
                }
            }
        }
        return Pos;
    }

    private static int[] leerDatos(){
        Scanner sc = new Scanner(System.in);
        int[] Vector = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Por favor, ingrese un numero: ");
            Vector[i] = sc.nextInt();   
        }
        sc.close();
        return Vector;
    }
    
}


