package com.cristian.desarrollo.Ejercicio2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
        System.out.println();
        String nombreFichero = JOptionPane.showInputDialog("Ingrese el nombre del fichero");
        String extensionFichero = JOptionPane.showInputDialog("Ingrese la extensión del fichero");
        String rutaFichero = JOptionPane.showInputDialog("Ingrese la ruta del fichero");

        rutaFichero += "/" + nombreFichero + '.' + extensionFichero;
        try {
            // Crear el fichero
            File fichero = new File(rutaFichero);
            if(!fichero.exists()){
                fichero.createNewFile();

                String texto = JOptionPane.showInputDialog("Ingrese el texto del fichero");
                Principal.escribirEnFichero(texto, fichero);

                // Leer fichero
                Principal.leerFichero(fichero);
                
            }else{
                String entradaUsuario = JOptionPane.showInputDialog("El fichero ya existe, desea agregar mas texto?");
                if (entradaUsuario.equalsIgnoreCase("Si") || entradaUsuario.equalsIgnoreCase("si")){
                    String texto = JOptionPane.showInputDialog("Ingrese el texto del fichero");
                    Principal.escribirEnFichero(texto, fichero);
                }
                Principal.leerFichero(fichero);
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        }
        System.out.println();
    }

    public static void escribirEnFichero(String texto, File fichero) throws IOException { 
        FileWriter ficheroEscribir = new FileWriter(fichero.getAbsolutePath(), true);
        for (int i = 0; i < texto.length(); i++) {
            ficheroEscribir.write(texto.charAt(i));
        }
        ficheroEscribir.close();
    }

    private static void leerFichero(File fichero) throws IOException{
        FileReader entradaFichero = new FileReader(fichero.getAbsolutePath());
        int c = 0, counter = 0;
        while(c != -1){
            c = entradaFichero.read();
            if (c != -1){
                char letra = (char) c;
                letra = counter != 0 ? Character.toUpperCase(letra): letra;
                System.out.print(letra);
            }
            counter++;
        }
        entradaFichero.close();
    }

}
