package Básicos;
/*Construir un programa Java que permita leer su estatura y determinar
cuánto mediría usted si tuviera 10 cms. más. */
import javax.swing.JOptionPane;

public class EstaturaMas{
    public static void main(String args[]){
        String entr = JOptionPane.showInputDialog("Ingrese su estatura");
        double estatura = Double.parseDouble(entr);
        estatura += 0.1; 
        System.out.printf("Si midieras 10 cms más, tu estatura sería: %1.2f cm %n", estatura);
    }
}