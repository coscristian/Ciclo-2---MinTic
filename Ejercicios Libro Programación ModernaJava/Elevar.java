// Construir un programa que muestre por pantalla el resultado de elevar 5 a la potencia 4
public class Elevar{
    public static void main(String args[]){
        int result = 0;
        double base = 5, potencia = 4;
        result = (int) Math.pow(base, potencia);
        System.out.println("EL resultado de elevar " + base + " a la potencia " + potencia + " es " + result);
    }
}