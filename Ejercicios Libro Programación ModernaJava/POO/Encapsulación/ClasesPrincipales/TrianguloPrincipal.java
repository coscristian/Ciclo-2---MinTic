/*
Construir un programa con clase encapsulada que permita mostrar las
dimensiones de un triángulo. Estas dimensiones corresponderán a una
base igual a 20 y una altura igual a 40. Estos valores serán válidos
solamente si no se establecen valores diferentes
 */

public class TrianguloPrincipal {
    public static void main(String[] args) {
        DimensionesTriangulo Tri1 = new DimensionesTriangulo();
        Tri1.setBase(20);
        Tri1.setAltura(40);

        System.out.println("Base de triangulo 1: " + Tri1.getBase());
        System.out.println("Altura de triangulo 1: " + Tri1.getAltura());
    }
}
