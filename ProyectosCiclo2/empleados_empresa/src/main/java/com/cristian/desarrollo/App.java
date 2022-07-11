package com.cristian.desarrollo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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

        var empleados = new ArrayList<Empleado>();
        empleados.add(cristian);
        empleados.add(juan);
        empleados.add(gustavo);
        empleados.add(ivan);

        // Creando la empresa con empleados ya definidos
        Empresa empresa = new Empresa("Grupo 69", empleados);

        // Probando cosas nuevas
        // Crea una lista lista nueva de tipo empleado
        var empleados2 = Arrays.asList(cristian, juan, gustavo, ivan);

        //Crear lista vacia (Es inmutable)
        Collections.emptyList();
        
        //Imprimir
        System.out.printf("La empresa %s tiene los siguientes empleados: %n", empresa.getNombre());

        empresa.getEmpleados().
                forEach((empleado) -> {  // parametros(empleado)
                    empleado.mostrarInfo();  // bloque(función)
                    if (empleado instanceof Directivo){
                        System.out.println("Y sus subordinados son: " + 
                        ((Directivo) empleado).getSubordinados()
                            .stream() // Flujo de datos: 
                            .map(subordinado -> subordinado.getNombre())
                            .reduce((a,b))  );
                    }
                });




/*         for (Empleado empleado : empresa.getEmpleados()) {
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
        } */

    }
}
