/*Construir un programa que lea un conjunto de 10 datos y, después de
leídos, determine cuántas veces está el número menor */

package Arrays;
import java.util.Scanner;

public class Ej8 {
    public static void main(String[] args) {
        int[] Vector = leerDatos();
        System.out.println("El numero menor está " + CantVecesNum(menor(Vector), Vector) + " veces.");
    }

    private static int CantVecesNum(int Num, int[] Vector) {
        int Contador = 0;
        for (int Elemento : Vector) {
            if (Elemento == Num){
                Contador++;
            }
        }
        return Contador;
    }

    private static int menor(int[] Vector){
        int menor = Vector[0];

        for(int i = 1; i < Vector.length; i++){
            if (Vector[i] < menor){
                menor = Vector[i];
            }
        }
        return menor;
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
