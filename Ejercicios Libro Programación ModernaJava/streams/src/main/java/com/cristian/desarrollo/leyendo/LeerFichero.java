package com.cristian.desarrollo.leyendo;

import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {
    
    public void lee(){
        try {
            var ruta = "/home/coscristian/Escritorio/Ciclo-2---MinTic/Ejercicios Libro Programación ModernaJava/streams/src/main/java/com/cristian/desarrollo/leyendo/archivo.txt";
            FileReader entrada = new FileReader(ruta);

            int c = entrada.read(); // Retorna el valor numerico del caracter leido
            while(c != -1){
                char letra = (char) c;
                System.out.print(letra);
                c = entrada.read();
            }

            entrada.close();
        } catch (IOException e) {
            System.out.println("ERROR: \n" + e);
        }
    }
}
