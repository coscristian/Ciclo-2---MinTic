package com.cristian.desarrollo.leyendo_escribiendo_bytes;

import java.io.*;

public class Lectura_Escritura {
    public static void main(String[] args) {
        int counter = 0;
        int[] datos_entrada = new int[573553];

        try {
            String ruta = "/home/coscristian/Desktop/pulpoBike.jpg";
            FileInputStream archivo_lectura = new FileInputStream(ruta); // Stream --> Flujo de datos
            boolean final_ar = false;

            while(!final_ar){
                int byte_entrada = archivo_lectura.read();
                if(byte_entrada != -1){
                    datos_entrada[counter] = byte_entrada;
                    System.out.println(counter + "." + datos_entrada[counter]); 
                }
                else{
                    final_ar = true;
                }
                counter++;
            }
            archivo_lectura.close();
        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        }

        crea_fichero(datos_entrada);

    }

    static void crea_fichero(int datos_nuevo_fichero[]){
        try {
            String ruta = "/home/coscristian/Desktop/pulpoBikeCopia.jpg";
            FileOutputStream fichero_nuevo = new FileOutputStream(ruta);

            for(int i = 0; i < datos_nuevo_fichero.length; i++){
                fichero_nuevo.write(datos_nuevo_fichero[i]);
            }

            fichero_nuevo.close();
        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        }
    }
}
