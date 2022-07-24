package com.cristian.desarrollo;

import java.io.File;
import java.io.IOException;

public class Creando {
    
    public static void main(String[] args) {
        String r = "Ejercicios Libro Programación ModernaJava" + File.separator + "POO" + File.separator + "nuevo_archivo.txt";
        File ruta = new File(r);

        // Crear directorio
        //ruta.mkdir();

        // Crear archivo, lo crea siempre y cuando no esté creado
        try {
            ruta.createNewFile();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
    


    
}
