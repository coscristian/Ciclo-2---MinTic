package POO.ejerciciosParte2.Clases;

public class Cuadrado {
    public int lado;
    public int area;
    public int perimetro;

    public Cuadrado(int l){
        lado = l;
        area = lado * 2;
        perimetro = lado * 4;
    }
}
