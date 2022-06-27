/*Construir un programa Java que muestre en pantalla el resultado
progresivo de sumar los números almacenados en un arreglo de 15
datos */

package Arrays;

public class Ej12 {
    public static void main(String[] args) {
        int[] Vector={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int Suma = 0;
        for (int Num : Vector) {
            Suma += Num;
            System.out.println(Suma);
        }
    }
}
