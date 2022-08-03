package com.cristian.desarrollo.registrosMedicos;

import javax.swing.JOptionPane;
import com.cristian.desarrollo.registrosMedicos.excepciones.SexoIncorrectoExcepcion;

public class PerfilMedicoPrueba {
    public static void main(String[] args) {

        try {
            String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre"),
                    apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido");
            
            Character sexo = JOptionPane.showInputDialog(null, "Ingrese el sexo").charAt(0);    
            if (!sexo.equals('M') || !sexo.equals('F') || !sexo.equals('m') || !sexo.equals('f')){
                throw new SexoIncorrectoExcepcion("Sexo Incorrecto");
            }
            Integer dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dia de nacimiento")),
                    mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de nacimiento")),
                    anio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de nacimiento"));
            
            Double altura = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la altura en cm")),
                    peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el peso en kg"));
            
            PerfilMedico pf1 = new PerfilMedico(nombre, apellido, sexo, dia, mes, anio, altura, peso);
            JOptionPane.showMessageDialog(null, pf1);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e);
        }
    }
}
