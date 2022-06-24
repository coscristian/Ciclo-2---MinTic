/*Construir un programa Java que permita leer su nombre, después leer
su apellido y mostrar en pantalla su nombre concatenado con su
apellido en una sola variable */
import javax.swing.JOptionPane;

public class NombreApellido2{
    public static void main(String[] args) {
        String Nombre = JOptionPane.showInputDialog("Ingrese su nombre");
        String Apellido = JOptionPane.showInputDialog("Ingrese su apellido");
        String NombreCompleto = Nombre + " " + Apellido;
        System.out.printf("Su nombre completo es %s%n", NombreCompleto);
    }
}