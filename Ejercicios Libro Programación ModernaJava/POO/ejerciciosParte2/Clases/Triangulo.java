package POO.ejerciciosParte2.Clases;

public class Triangulo {
    public int base;
    public int altura;
    public double area;

    public Triangulo(int b, int a){
        base = b;
        altura = a;
        area = (double) (base * altura)/2;
    }
}
