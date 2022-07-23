package com.cristian.desarrollo.escribiendo;

import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichero {
    public void escribir(){

        String frase = String.format(".\nNuevo Texto");
        String ruta = "/home/coscristian/Escritorio/Ciclo-2---MinTic/Ejercicios Libro Programación ModernaJava/streams/src/main/java/com/cristian/desarrollo/escribiendo/archivoEscritura.txt";
        try {    
            FileWriter escritura = new FileWriter(ruta, true);    
            
            for(int i = 0; i < frase.length(); i++){
                escritura.write(frase.charAt(i));
            }
            escritura.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
