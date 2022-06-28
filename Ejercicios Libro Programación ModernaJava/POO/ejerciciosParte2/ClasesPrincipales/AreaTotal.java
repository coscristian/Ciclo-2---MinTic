package POO.ejerciciosParte2.ClasesPrincipales;

import POO.ejerciciosParte2.Clases.*;

public class AreaTotal {
    public static void main(String[] args) {
        Triangulo Tri1 = new Triangulo(5,3);
        Triangulo Tri2 = new Triangulo(5,4);
        Rectangulo Rec1 = new Rectangulo(5,4);
        Rectangulo Rec2 = new Rectangulo(8, 2);
        Pentagono Pen1 = new Pentagono(3,2);

        double AreaTotal = Tri1.area + Tri2.area + Rec1.area + Rec2.area + Pen1.area;

        System.out.println("Base de Triangulo 1:\t" + Tri1.base);
        System.out.println("Altura de Triangulo 1:\t" + Tri1.altura);
        System.out.println("Area de Triangulo 1:\t" + Tri1.area);
        System.out.println();
        
        System.out.println("Base de Triangulo 2:\t" + Tri2.base);
        System.out.println("Altura de Triangulo 2:\t" + Tri2.altura);
        System.out.println("Area de Triangulo 2:\t" + Tri2.area);
        System.out.println();

        System.out.println("Base de Rectangulo 1:\t" + Rec1.base);
        System.out.println("Altura de Rectangulo 1:\t" + Rec1.altura);
        System.out.println("Area de Rectangulo 1:\t" + Rec1.area);
        System.out.println();

        System.out.println("Base de Rectangulo 2:\t" + Rec2.base);
        System.out.println("Altura de Rectangulo 2:\t" + Rec2.altura);
        System.out.println("Area de Rectangulo 2:\t" + Rec2.area);
        System.out.println();
        
        System.out.println("Lado del Pent 1:\t" + Pen1.lado);
        System.out.println("Apot del Pent 1:\t" + Pen1.apotema);
        System.out.println("Area de Pent 1:\t" + Pen1.area);

        System.out.println("\n\tArea Total:\t" + AreaTotal);
    }
}
