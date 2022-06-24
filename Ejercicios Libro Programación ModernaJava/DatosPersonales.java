/*onstruir un programa Java que recibe tres de sus datos personales y
los muestre por consola de forma organizada */
import javax.swing.JOptionPane;

public class DatosPersonales{
    public static void main(String args[]){
        String Nombre, Direccion, EntrEdad;
        byte Edad;

        Nombre = JOptionPane.showInputDialog("Ingrese su nombre por favor");
        Edad = Byte.parseByte(JOptionPane.showInputDialog("Ingrese su edad por favor"));
        Direccion = JOptionPane.showInputDialog("Ingrese su direccion por favor");

        System.out.printf("Nombre: \t%s %n", Nombre);
        System.out.printf("Edad: \t%d %n", Edad);
        System.out.printf("Dirección: \t%s %n", Direccion);

    }
}