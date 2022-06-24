import javax.swing.JOptionPane;

public class Ventana3{
    public static void main(String[] args) {
        String N1 = JOptionPane.showInputDialog("Ingrese un numero");
        double N2 = Double.parseDouble(N1);
        System.out.print("La raiz cubica de " + N1 + " es ");
        System.out.printf("%1.3f%n", Math.cbrt(N2));
    }
}