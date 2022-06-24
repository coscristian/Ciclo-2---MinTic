// Construir un programa que calcula la raíz cúbica de 100
public class RaizCubica{
    public static void main(String args[]){
        double argm = 100, result = 0;
        result = Math.cbrt(argm);
        System.out.println("La raiz cubica de " + argm + " es " + result);
    }
}