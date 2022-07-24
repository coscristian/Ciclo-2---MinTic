package com.cristian.desarrollo.Ejercicio2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Escritura {

    private File fichero;

    public Escritura(File fichero) {
        this.fichero = fichero;
    }

    public void escribirEnFichero(String texto) throws IOException { 
        System.out.println(fichero.getAbsolutePath());
        FileWriter ficheroEscribir = new FileWriter(fichero.getAbsolutePath());
        for (int i = 0; i < texto.length(); i++) {
            ficheroEscribir.write(texto.charAt(i));
        }
    }
}
