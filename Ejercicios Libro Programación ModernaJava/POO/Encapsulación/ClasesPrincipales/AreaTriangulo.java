import java.util.Scanner;

public class AreaTriangulo {
    public static void main(String[] args) {
        Integer base, altura;
        Double area;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese la base del triangulo: ");
        base = sc.nextInt();

        System.out.print("Ingrese la altura del triangulo: ");
        altura = sc.nextInt();

        Triangulo Tri1 = new Triangulo();
        
        Tri1.setBase(base);
        Tri1.setAltura(altura);

        area = Tri1.getArea();

        System.out.println("El area del triangulo con base " + Tri1.getBase() + " y altura " + Tri1.getAltura() + " es --> " + Tri1.getArea());
        sc.close();
    }
}
