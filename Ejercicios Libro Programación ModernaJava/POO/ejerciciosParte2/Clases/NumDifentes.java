package POO.ejerciciosParte2.Clases;

public class NumDifentes {
    public int num1;
    public int num2;
    public boolean resultado;

    public NumDifentes(int n1, int n2){
        num1 = n1;
        num2 = n2;
        resultado = n1 != n2;
    }
}
