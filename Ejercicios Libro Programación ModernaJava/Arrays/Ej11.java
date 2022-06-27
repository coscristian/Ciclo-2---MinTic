
/*Construir un programa Java que permita señalar en pantalla los
números impares de un conjunto de 10 números */
package Arrays;

public class Ej11 {
    public static void main(String[] args) {
        int[] Vector = {1,4,6,8,2,7,21,23,35,70};
        for(int Num: Vector){
            if (Num % 2 != 0){
                System.out.printf("%d ", Num);
            }
        }
    }
}
