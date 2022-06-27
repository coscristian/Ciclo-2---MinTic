/*Construir un programa que lea un conjunto de 10 datos y, después de
leídos, determine en qué posición está el número menor */

package Arrays;
import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        System.out.println(posic_menor(leer_datos()));        
    }

    private static int posic_menor(int[] Vector){
        int menor = Vector[0], pos = 0;

        for(int i = 1; i < Vector.length; i++){
            if (Vector[i] < menor){
                menor = Vector[i];
                pos = i;
            }
        }
        return pos+1;
    }

    private static int[] leer_datos(){
        Scanner sc = new Scanner(System.in);
        int[] Vector = new int[10];
        for(int i = 0; i < 10; i++){
            System.out.print("Ingrese un número: ");
            Vector[i] = sc.nextInt();
        }
        sc.close();
        return Vector;
    }


}
