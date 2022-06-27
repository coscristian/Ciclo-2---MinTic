/*Construir un programa Java que permita calcular la raíz cuadrada de
cada uno de los datos de un conjunto de 20 números */
package Arrays;

public class Ej13 {
    public static void main(String[] args) {
        int[] Vector={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        for (int Num : Vector) {
            System.out.println(Num + " --> " + Math.sqrt(Num));
        }
    }
}

