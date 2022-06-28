package POO.ejerciciosParte2.ClasesPrincipales;
import java.util.Scanner;

import POO.ejerciciosParte2.Clases.Rectangulo;

public class RectanguloPrincipal {
    public static void main(String[] args) {
        int base1, base2, alt1, alt2;
        Scanner sc = new Scanner(System.in);

        //Pedir valores necesarios
        System.out.print("Ingrese por favor la base del rectangulo 1: ");
        base1 = sc.nextInt();

        System.out.print("Ingrese por favor la altura del rectangulo 1: ");
        alt1 = sc.nextInt();

        System.out.print("Ingrese por favor la base del rectangulo 2: ");
        base2 = sc.nextInt();

        System.out.print("Ingrese por favor la altura del rectangulo 2: ");
        alt2 = sc.nextInt();

        //Instaciación de las clases
        Rectangulo Rect1 = new Rectangulo(base1, alt1);
        Rectangulo Rect2 = new Rectangulo(base2, alt2);

        System.out.println("El area del rectangulo 1 es: " + Rect1.area);
        System.out.println("El perimetro del rectangulo 1 es: " + Rect1.perimetro);
        System.out.println("\nEl area del rectangulo 2 es: " + Rect2.area);
        System.out.println("El perimetro del rectangulo 2 es: " + Rect2.perimetro);

        sc.close();
    }
}
