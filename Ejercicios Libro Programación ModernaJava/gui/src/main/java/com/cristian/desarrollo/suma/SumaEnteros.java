package com.cristian.desarrollo.suma;

import javax.swing.JOptionPane;

public class SumaEnteros {
    public static void main(String[] args) {
        Boolean fin = false;
        while(!fin){
            try {
                Integer num1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese primer número"));
                Integer num2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo número"));
                String mensaje =
                     String.format("La suma entre %d y %d es %d", num1, num2, num1 + num2);
                JOptionPane.showMessageDialog(null, mensaje);
                fin = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ERROR: Debes ingresar un número");
            }  
        }
    }
}
