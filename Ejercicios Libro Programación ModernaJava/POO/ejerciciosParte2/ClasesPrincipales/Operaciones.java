/*Construir un programa que permita leer dos números enteros y, basado
en clases, calcule la suma de los dos números, la resta de los dos
números, la multiplicación de los dos números y el cociente de los dos
números */

package POO.ejerciciosParte2.ClasesPrincipales;
import POO.ejerciciosParte2.Clases.*;
import java.util.Scanner;

public class Operaciones {
    public static void main(String[] args) {
        int num1, num2;
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el primer numero: ");
        num1 = sc.nextInt();

        System.out.print("Ingrese el segundo numero: ");
        num2 = sc.nextInt();

        //Instancias de las clases
        Suma sum1 = new Suma(num1, num2);
        Resta rest1 = new Resta(num1, num2);
        Multiplicacion mult1 = new Multiplicacion(num1, num2);
        Cociente coc1 = new Cociente(num1, num2);

        System.out.println("La suma de los dos numeros es: " + sum1.resultado);
        System.out.println("La resta de los dos numeros es: " + rest1.resultado);
        System.out.println("La multiplicacion de los dos numeros es: " + mult1.resultado);
        System.out.println("EL cociente de los dos numeros es: " + coc1.resultado);

        sc.close();
    }
}
