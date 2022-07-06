package com.cristian.desarrollo;

import com.cristian.desarrollo.modelo.*;

public class App {
    public static void main( String[] args ){

        // Empresas
        Empresa unity = new Empresa("Unity");

        // Empleados
        Empleado alberto = new Empleado("Alberto Rodriguez", 20);
        alberto.setSueldoBruto(3000000.0);

        Empleado gustavo = new Empleado("Gustavo Briceño", 30);

        Empleado ivan = new Empleado("Ivan R", 25);

        // Clientes
        Cliente maria = new Cliente("Maria Adelaida", 30, "345852693");
        Cliente santiago = new Cliente("Santiago Lopez", 25);
        Cliente stiven = new Cliente("Sriven Vargas", 25);
        stiven.setTelefono("32124586");

        // Directivos
        Directivo camilo = new Directivo("Camilo Mena", 25, "Jefe de desarrollo");
        Directivo andrea = new Directivo("Andrea Salazar", 28, 4900000.0);

        // Empleados subordinados
        Empleado samir = new Empleado("Samir Loaiza", 24, 800000.0);
        Empleado luz = new Empleado("Luz Quiroga", 22);
        
        // Agregando empleados a la empresa
        unity.agregarEmpleado(alberto);
        unity.agregarEmpleado(gustavo);
        unity.agregarEmpleado(ivan);
        unity.agregarEmpleado(samir);
        unity.agregarEmpleado(luz);

        // Agregando clientes a la empresa
        unity.agregarCliente(maria);
        unity.agregarCliente(santiago);
        unity.agregarCliente(stiven);
        
        // Agregando directivos
        unity.agregarEmpleado(camilo);
        unity.agregarEmpleado(andrea);

        // Agregando empleados subordinados a los directivos
        camilo.agregarSubordinado(samir);
        andrea.agregarSubordinado(luz);


        // Mostrar datos de la empresa
        System.out.println("==================================================");
        System.out.println("Empresa " + unity.getNombre());
        System.out.println("\tEmpleados");
        for (Empleado empleado : unity.getEmpleados()) {
            if (empleado == null){
                break;
            }
            System.out.println("\t\t------------------------------");
            System.out.printf("\t\tNombre:\t %s \n", empleado.getNombre());
            System.out.printf("\t\tEdad:\t %d \n", empleado.getEdad());
            System.out.printf("\t\tSueldo:\t %,.2f \n", empleado.getSueldoBruto());
            System.out.println("\t\t------------------------------");
            System.out.println();
        }

        System.out.println("\tClientes");
        for (Cliente cliente : unity.getClientes()) {
            if (cliente == null){
                break;
            }
            System.out.println("\t\t------------------------------");
            System.out.printf("\t\tNombre:\t %s \n", cliente.getNombre());
            System.out.printf("\t\tEdad:\t %d \n", cliente.getEdad());
            System.out.printf("\t\tTel:\t %s \n", cliente.getTelefono());
            System.out.println("\t\t------------------------------");
            System.out.println();
        }
        System.out.println("==================================================");
    }
}
