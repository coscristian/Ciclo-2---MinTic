/*Constuir un programa Java que permita registrar un nuevo estudiante
en un colegio con los datos Nombres, Apellidos, Edad y Año de
Nacimiento. Cuando no se tengan todos los datos, deberá registrarse
en Edad el valor 1 y en el Año de Nacimiento el valor 1000 */

package com.cristian.desarrollo;

public class Colegio {
    public static void main(String[] args) {
        Estudiante e1 = new Estudiante("Cristian", "Quesada Cossio", "1087489628", "Tinajas", "20", "28/03/2002");
        System.out.print(Estudiante.mostrarCantEstudiantes());

        Estudiante e2 = new Estudiante("Juan", "Quesada Cossio", "107458347", "Tinajas", "19", "17/04/2000");
        Estudiante e3 = new Estudiante("Cesar", "Quesada Vivas", "10024241", "Tinajas");
        System.out.print(Estudiante.mostrarCantEstudiantes());


    }
}
