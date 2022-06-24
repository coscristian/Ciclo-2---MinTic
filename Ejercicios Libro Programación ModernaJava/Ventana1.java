import javax.swing.JOptionPane;

public class Ventana1{
    public static void main(String[] args) {
        String Apellido = JOptionPane.showInputDialog("Digite su apellido");
        System.out.printf("Hola señor(a) %s!!%n", Apellido);
    }
}