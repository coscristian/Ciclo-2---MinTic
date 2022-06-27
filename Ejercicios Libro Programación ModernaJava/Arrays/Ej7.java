/* Construir un programa que lea un conjunto de 10 datos y, después de
leídos, determine cuántos números impares hay en el vector */
package Arrays;
import java.util.Scanner;

public class Ej7 {
    public static void main(String[] args) {
        int Cant;
        if ((Cant = cantImpares(leerDatos())) != 0){
            System.out.println("La cantidad de numeros impares es --> " + Cant);
        }else{
            System.out.println("No hay por lo menos un numero impar...");
        }
    }

    private static int cantImpares(int[] Vector) {
        int Contador = 0;
        for (int Num : Vector) {
            if (Num % 2 != 0){
                Contador++;
            }
        }
        return Contador;
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
