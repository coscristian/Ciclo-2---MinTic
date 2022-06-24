/*Construir un programa Java que permita leer su nombre y mostrar
solamente las dos primeras letras */
import java.util.Scanner;

public class NombreDosLetras{
    public static void main(String args[]){
        Character l1 ,l2;
        String Nombre;
        
        System.out.print("Ingrese su nombre: ");
        Scanner sc = new Scanner(System.in);
        Nombre = sc.nextLine();
        
        l1 = Nombre.charAt(0);
        l2 = Nombre.charAt(1);

        System.out.printf("Letra 1: %c %nLetra 2: %c %n", l1,l2);
        sc.close();
    }
}