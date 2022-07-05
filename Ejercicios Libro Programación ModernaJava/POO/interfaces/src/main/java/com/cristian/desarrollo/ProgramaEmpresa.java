/*
Construir un programa Java que permita pagar un 3% adicional como
recargo al salario por cada hijo que tenga un empleado de una empresa
y que pague 2% más por cada hijo después del 3er hijo, aprovechando
el concepto de herencia entre interfaces
*/

// Me falta implementar la separacion de miles a la hora de mostrar los valores

package com.cristian.desarrollo;
import javax.swing.JOptionPane;

public class ProgramaEmpresa {
    public static void main(String[] args) {
        Empleado2[] empleados = new Empleado2[3];
        
        String nombre;
        String id;
        String edad;
        String cargo;
        int cantHijos;
        double salarioNeto, valorTotalRecargo = 0, salarioTotalConRecargo;

        for (int i = 0; i < 3; i++) {
            nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado " + (i+1));
            id = JOptionPane.showInputDialog("Ingrese la CC del empleado " + (i+1));
            edad = JOptionPane.showInputDialog("Ingrese la edad del empleado " + (i+1));
            cargo = JOptionPane.showInputDialog("Ingrese el cargo del empleado " + (i+1));
            cantHijos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de hijos del empleado " + (i+1)));
            salarioNeto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario neto del empleado " + (i+1)));

            Empleado2 empleado = new Empleado2(nombre, id, edad, cargo, cantHijos, salarioNeto);

            // Verificar cantidad de hijos para saber que recargo aplicar
            if (empleado.getCantHijos() <= 3){
                valorTotalRecargo = empleado.calcularValorRecargoSalario(salarioNeto, cantHijos);
            }else if (empleado.getCantHijos() > 3){
                // Como tiene mas de 3 hijos el recargo de los 3 primeros es de 3%, el resto de 2%.
                valorTotalRecargo = empleado.calcularValorRecargoSalario(salarioNeto, 3); 
                valorTotalRecargo += empleado.calcularValorRecargoSalarioExc(salarioNeto, cantHijos - 3);
            }
            empleado.setValorTotalRecargo(valorTotalRecargo);
            salarioTotalConRecargo = salarioNeto + valorTotalRecargo;
            empleado.setSalarioTotalConRecargo(salarioTotalConRecargo);
            empleados[i] = empleado;
        }

        int cont = 1;
        System.out.println("------------------------");
        for (Empleado2 e : empleados) {
            System.out.println("Empleado " + cont);
            System.out.println("\tNombre:\t" + e.getNombre());
            System.out.println("\tID:\t" + e.getId());
            System.out.println("\tEdad:\t" + e.getEdad());
            System.out.println("\tCargo:\t" + e.getCargo());
            System.out.println("\tCant Hijos:\t" + e.getCantHijos());
            System.out.printf("\tSalario Neto:\t%,d\n" + (int)e.getSalarioNeto());
            
            salarioNeto = e.getSalarioNeto();
            cantHijos = e.getCantHijos();
            valorTotalRecargo  = e.calcularValorRecargoSalario(salarioNeto, cantHijos);
            String porcentaje = "3%";

            if (cantHijos > 0){
                System.out.println("\t\tHijos");
            }else{
                System.out.println("\t\tHijos:\tN/A");
            }

            for (int i = 1; i <= e.getCantHijos(); i++) { // Ciclo para mostrar el recargo que aporta cada hijo a cada empleado
                double valorUnitarioRecargo = e.getValorRecargoUnitario(e.getSalarioNeto());
                if (i > 3){
                    valorUnitarioRecargo = e.getValorRecargoExcUnitario(e.getSalarioNeto());
                    porcentaje = "2%";
                }
                System.out.print("\t\t\tHijo " + i + " (" + porcentaje + "):\t$%,d\n" + valorUnitarioRecargo);
            }
            System.out.println("\t\tValor Total Recargo:\t" + valorTotalRecargo);
            System.out.println();
            System.out.println("\t=======================================");
            System.out.printf("\t\tSalario Total con recargo\n\t\t$%,d\n" + (int) e.getSalarioTotalConRecargo());
            System.out.println("\t=======================================");
            System.out.println("------------------------");
            cont++;
        }
    }    
}
