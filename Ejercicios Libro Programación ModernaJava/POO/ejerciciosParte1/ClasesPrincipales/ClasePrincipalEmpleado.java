/*
Construir una clase con cuatro atributos de un empleado, crear la Clase
Empleado y crear su método Constructor que le asigne valores a los
atributos que se crearon. Adicional construya un programa Java que
utilice esta Clase y muestre sus resultados
 */

package POO.ejerciciosParte1.ClasesPrincipales;

import POO.ejerciciosParte1.Clases.ClaseEmpleado;

public class ClasePrincipalEmpleado {
    public static void main(String[] args) {
        ClaseEmpleado Emple1 = new ClaseEmpleado();
        System.out.println("Nombre:\t" + Emple1.Nombre);
        System.out.println("Edad: \t" + Emple1.Edad);
        System.out.println("Cargo: \t" + Emple1.Cargo);
        System.out.println("Salario: \t" + Emple1.Salario);        
    }
}
