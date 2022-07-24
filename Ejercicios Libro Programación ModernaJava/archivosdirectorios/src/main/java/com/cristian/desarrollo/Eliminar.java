package com.cristian.desarrollo;

import java.io.File;

public class Eliminar {
    public static void main(String[] args) {
        String r = "Ejercicios Libro Programación ModernaJava" + File.separator + "POO" + File.separator + "nuevo_archivo.txt";
        File ruta = new File(r);

        // Eliminar archivo
        ruta.delete();
    }
}
