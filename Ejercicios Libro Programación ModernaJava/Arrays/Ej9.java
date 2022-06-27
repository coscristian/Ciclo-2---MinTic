/*Construir un programa que lea un conjunto de 10 datos y, después de
leídos, determine cuántas veces está el número mayor */
package Arrays;
import java.util.Scanner;

public class Ej9 {
    public static void main(String[] args) {
        int[] Vector = leerDatos();
        System.out.println("El numero mayor está " + CantVecesNum(mayor(Vector), Vector) + " veces.");
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

    private static int mayor(int[] Vector){
        int mayor = Vector[0];

        for(int i = 1; i < Vector.length; i++){
            if (Vector[i] > mayor){
                mayor = Vector[i];
            }
        }
        return mayor;
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