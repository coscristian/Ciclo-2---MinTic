package POO.ejerciciosParte2.Clases;

public class Rectangulo {
    public int base;
    public int altura;
    public int area;
    public int perimetro;

    public Rectangulo(int b, int a){
        base = b;
        altura = a;
        area = base * altura;
        perimetro = 2 * (base + altura);
    }
}
