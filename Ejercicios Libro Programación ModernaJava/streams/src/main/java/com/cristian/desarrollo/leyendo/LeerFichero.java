package com.cristian.desarrollo.leyendo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {
    
    public void lee(){
        try {
            var ruta = "/home/coscristian/Escritorio/Ciclo-2---MinTic/Ejercicios Libro Programación ModernaJava/streams/src/main/java/com/cristian/desarrollo/leyendo/archivo.txt";
            FileReader entrada = new FileReader(ruta);
            // Buffer: Memoria intermedia
            BufferedReader miBuffer = new BufferedReader(entrada);

            String linea = "";

            while(linea != null){
                linea = miBuffer.readLine();
                if (linea != null) System.out.print(linea);
            }

            entrada.close();
        } catch (IOException e) {
            System.out.println("ERROR: \n" + e);
        }
    }
}
