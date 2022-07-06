package com.cristian.desarrollo;

import com.cristian.desarrollo.excepciones.MaximoNumeroClientesException;

public class App {
    public static void main( String[] args ){
        Empleado cristian = new Empleado("Cristian Quesada", 20);
        cristian.setSueldoBruto(3000000.0);

        Cliente maria = new Cliente("Maria Adelaida", 30, "3105551223");

        Directivo juan = new Directivo("Juan Silva", 25);
        juan.setCategoria("Jefe de Desarrollo");

        Empleado gustavo = new Empleado("Gustavo Briceño", 30);
        Empleado ivan = new Empleado("Ivan R", 25);

        //Agregando los subordinados de el directivo Juan
        juan.agregarSubordinado(gustavo);
        juan.agregarSubordinado(ivan);
        juan.agregarSubordinado(cristian);

        // Creando la empresa con empleados ya definidos
        Empresa empresa = new Empresa("Grupo 69", new Empleado[]{
            cristian, juan, gustavo, ivan });
        
        // Agregar cliente a la empresa
/*         try {
            empresa.agregarCliente(maria);
            empresa.agregarCliente(new Cliente("Laura Gutierrez", 28));
        } catch (MaximoNumeroClientesException ex) {
            System.err.println("Ha ocurrido un error al agregar un cliente\n\t" + ex.getMessage());
        } */

        try {
            empresa.agregarCliente(maria);
            empresa.agregarCliente(new Cliente("Laura Gutierrez", 28));
        } catch (Exception e) {
            System.err.println("El directivo no puede agregar mas subordinados.");
        }


        //Imprimir
        System.out.printf("La empresa %s tiene los siguientes empleados: %n", empresa.getNombre());
        for (Empleado empleado : empresa.getEmpleados()) {
            if (empleado instanceof Directivo){
                var directivo = (Directivo) empleado;
                System.out.print(" Y sus subordinados son: ");
                var imprimioSubordinado = false;
                for (var subordinado : directivo.getSubordinados()) {
                    if( subordinado == null){
                        break;
                    }
                    if(imprimioSubordinado){
                        System.out.print(", ");
                    }
                    System.out.print(subordinado.getNombre() + ", ");
                    imprimioSubordinado = true;
                }
                System.out.println();
            }
            empleado.mostrarInfo();
        }
        System.out.println("Y sus clientes son: ");
        for (Cliente cliente : empresa.getClientes()) {
            if (cliente == null){
                break;
            }
            cliente.mostrarInfo();
        }

    }
}
