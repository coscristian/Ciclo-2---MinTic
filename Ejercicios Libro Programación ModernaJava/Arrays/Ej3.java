/*Construir un programa que lea un conjunto de 10 datos y, después de
leídos, determine en qué posición está el menor número par */
package Arrays;
import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        
        int Pos;
        if ( (Pos = menorPar(leerDatos())) != -1 ){
            System.out.println("El menor numero par se encuentra en la posicion: " + (Pos+1));
        }else{
            System.out.println("No hay por lo menos un numero par...");
        }
    }

    private static int menorPar(int[] Vector){
        int MenorPar = 999999, Pos = -1;
        for(int i = 0; i < Vector.length; i++){
            if (Vector[i] % 2 == 0){
                if (Vector[i] < MenorPar){
                    MenorPar = Vector[i];
                    Pos = i;
                }
            }
        }
        return Pos;
    }

    private static int[] leerDatos(){
        Scanner sc = new Scanner(System.in);
        int[] Vector = new int[10];

        for(int i = 0; i < 10; i++){
            System.out.print("Por favor, ingrese un numero: ");
            Vector[i] = sc.nextInt();
        }
        sc.close();
        return Vector;
    }

}
