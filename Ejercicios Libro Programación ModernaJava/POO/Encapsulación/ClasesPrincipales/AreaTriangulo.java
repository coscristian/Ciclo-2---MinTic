import java.util.Scanner;
import POO.Encapsulacion.Clases.*;

public class AreaTriangulo {
    public static void main(String[] args) {
        Double base, altura;
        Double area;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese la base del triangulo: ");
        base = sc.nextDouble();

        System.out.print("Ingrese la altura del triangulo: ");
        altura = sc.nextDouble();

        Triangulo Tri1 = new Triangulo();
        
        Tri1.setBase(base);
        Tri1.setAltura(altura);

        area = Tri1.getArea();

        System.out.println("El area del triangulo con base " + Tri1.getBase() + " y altura " + Tri1.getAltura() + " es --> " + Tri1.getArea());
        sc.close();
    }
}
