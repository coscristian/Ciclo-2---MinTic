/* Construir un programa que lea un conjunto de 10 datos y, después de
leídos, determine en qué posición está el menor número terminado en
3 */

package Arrays;
import java.util.Scanner;

public class Ej5 {
    public static void main(String[] args) {
        int Pos;
        if ((Pos = menorTerminado3(leerDatos())) != -1){
            System.out.println("El menor numero que termina en 3 se encuentra en la posicion: " + (Pos+1));
        }else{
            System.out.println("No hay por lo menos un numero que termine en 3...");
        }
    }  

    private static int menorTerminado3(int[] Vector){
        int MenorTerm3 = 999999, Pos = -1;
        for(int i = 0; i < Vector.length; i++){
            if (Vector[i] % 10 == 3){
                if (Vector[i] < MenorTerm3){
                    MenorTerm3 = Vector[i];
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
