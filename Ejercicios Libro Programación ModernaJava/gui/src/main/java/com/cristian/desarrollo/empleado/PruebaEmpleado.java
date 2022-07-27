package com.cristian.desarrollo.empleado;
import javax.swing.JOptionPane;

public class PruebaEmpleado {
    public static void main(String[] args) {
        Empleado[] empleados = new Empleado[2];

        for(int i = 0; i < 2; i++){
            String nombre,
                    apellido;
            Double salarioMensual;
            try {
                nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado");
                apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido del empleado");
                salarioMensual = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el salario mensual del empleado"));
    
                Empleado e1 = new Empleado(nombre, apellido, salarioMensual);
                empleados[i] = e1;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ERROR: " + e);
            }
        }

        for (Empleado e : empleados) {
            var salarioAnual = e.getSalarioMensual() * 12;
            String mensaje = String.format("El salario anual del empleado %s es $ %,.2f", e.getNombre(), salarioAnual);
            JOptionPane.showMessageDialog(null, mensaje);
        }

        for (Empleado e : empleados) {
            var porcAumento = 10 /100f;
            var salarioAnual = e.getSalarioMensual() * 12;
            var salarioAnualAumento = salarioAnual * porcAumento + salarioAnual;
            e.setSalarioMensual(salarioAnualAumento);

            String mensaje = 
                    String.format("El salario anual con aumento del $ %.1f%% del empleado %s es $ %,.2f", porcAumento * 100,
                                    e.getNombre(), salarioAnualAumento);
            JOptionPane.showMessageDialog(null, mensaje);
        }


    }
}
