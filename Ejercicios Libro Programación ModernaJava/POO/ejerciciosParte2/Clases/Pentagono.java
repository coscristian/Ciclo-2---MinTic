package POO.ejerciciosParte2.Clases;

public class Pentagono {
    public int lado;
    public int apotema;
    public double area;

    public Pentagono(int l, int a){
        lado = l;
        apotema = a;
        area = (double) 5 * ((lado*apotema) / 2);
    }
}
