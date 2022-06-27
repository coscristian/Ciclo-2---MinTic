/*Construir un programa que lea un conjunto de 10 datos y, después de
leídos, determine en qué posición está el número mayor */

package Arrays;
import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        System.out.println(pos_mayor(leer_datos()));
    }

    private static int pos_mayor(int[] Vector){
        int mayor = Vector[0], pos = 0;

        for(int i = 1; i < Vector.length; i++){
            if (Vector[i] > mayor){
                mayor = Vector[i];
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
