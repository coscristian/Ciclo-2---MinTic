package com.cristian.desarrollo.Ejercicio1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Fichero {
    public static void main(String[] args) {
        // Creación del Stream flujo de datos
        String rutaFichero = "/home/coscristian/Escritorio/Ciclo-2---MinTic/Ejercicios Libro Programación ModernaJava/ficheros/src/main/java/com/cristian/desarrollo/Ejercicio1/ficheroPrueba.txt";
        String texto;
    
        try {
            // Creación del fichero nuevo
            File fichero = new File(rutaFichero);
            fichero.createNewFile();
            
            // Escritura en el fichero
            texto = JOptionPane.showInputDialog("Ingrese el texto que desea escribir en el Fichero");
            FileWriter ficheroEscritura = new FileWriter(rutaFichero, true);
            for (int i = 0; i < texto.length(); i++) {
                ficheroEscritura.write(texto.charAt(i));
            }
            ficheroEscritura.close();

            // Mostrando en consola el contenido del archivo sin espacios
            // Creando el flujo de datos de entrada
            FileReader entrada = new FileReader(fichero.getAbsolutePath());
            int c = 0;
            char letra;
            while(c != -1){
                c = entrada.read();
                if ( (letra = (char) c ) != ' ' && c != -1)
                    System.out.print(letra);
            }
            entrada.close();
            
        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        }
    }
}
