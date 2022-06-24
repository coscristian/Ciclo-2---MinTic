/*Construir un programa Java que permita leer su edad y mostrar la mitad
de su edad */
import javax.swing.JOptionPane;

public class MitadEdad2{
    public static void main(String[] args) {
        String entr = JOptionPane.showInputDialog("Ingrese su edad");
        int mitad_edad = Integer.parseInt(entr) / 2;
        System.out.printf("Su edad es %s y la mitad de su edad es %d%n", entr, mitad_edad);
    }
}