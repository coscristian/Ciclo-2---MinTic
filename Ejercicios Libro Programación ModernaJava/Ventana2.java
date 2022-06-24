import javax.swing.JOptionPane;

public class Ventana2{
    public static void main(String args[]){
        String Hijos;
        Hijos = JOptionPane.showInputDialog("Cuantos hijos tiene?");
        int NumHijos = Integer.parseInt(Hijos);
        System.out.printf("Con un hijo más tendrás %d%n", (NumHijos+1));
    }
}