/*
-Construir un programa que permita pagar a un empleado el 5%
adicional sobre el valor de su salario por cada hijo que tenga, usando
la facilidad de las intefaces 

-Construir un programa que permita aumentar el salario de un empleado
en un porcentaje dado a partir del uso de interfaces
*/

package com.cristian.desarrollo;
import javax.swing.JOptionPane;

public class ProgramaEmpleado {
    public static void main(String[] args) {
        Empleado[] misEmpleados = new Empleado[3];

        String nombre, id, edad, cargo;
        int cantHijos;
        double salarioNeto, adicionalHijos, aumento;

        for (int i = 0; i < 3; i++) {
            nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado " + (i+1));
            id = JOptionPane.showInputDialog("Ingrese la cedula del empleado " + (i+1));
            edad = JOptionPane.showInputDialog("Ingrese la edad del empleado " + (i+1));
            cargo = JOptionPane.showInputDialog("Ingrese el cargo del empleado " + (i+1));
            salarioNeto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario del empleado " + (i+1)));
            cantHijos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de hijos del empleado " + (i+1)));
            aumento = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del aumento para el empleado " + (i+1)));

            Empleado empleado = new Empleado(nombre, id, edad, cargo, cantHijos);
            
            empleado.setSalarioNeto(salarioNeto);
            adicionalHijos = empleado.calcularAdicionalHijos(empleado.getSalarioNeto(), empleado.getCantHijos());
            empleado.setSalarioAdicional(adicionalHijos);
            empleado.setSalarioAumento(aumento);
            empleado.setSalarioTotal(empleado.getSalarioAdicional() + empleado.getSalarioNeto() + empleado.getAumento());
            
            misEmpleados[i] = empleado;
        }

        int cont = 1;
        for (Empleado e : misEmpleados) {
            System.out.println("Empleado " + cont);
            System.out.println("\tNombre\t" + e.getNombre());
            System.out.println("\tID\t" + e.getId());
            System.out.println("\tEdad\t" + e.getEdad());
            System.out.println("\tCargo\t" + e.getCargo());
            System.out.println("\tSalarioNeto\t" + e.getSalarioNeto());
            System.out.println("\tCant Hij\t" + e.getCantHijos());
            System.out.println("\tValor Ad\t" + e.getSalarioAdicional());
            System.out.println("\tValor Aum\t" + e.getAumento());
            System.out.println("\tSalario Tot\t" + e.getSalarioTotal());
            System.out.println();
            cont++;
        }
    }
}
