package com.cristian.desarrollo.Ejercicio3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;


import javax.swing.JOptionPane;

public class AppPrincipal {
    public static void main(String[] args) {
        String matricula = JOptionPane.showInputDialog("Matricula"),
                marca = JOptionPane.showInputDialog("Marca"),
                deposito = JOptionPane.showInputDialog("Deposito"),
                modelo = JOptionPane.showInputDialog("Modelo"),
                rutaFichero = "/home/coscristian/Escritorio/Ciclo-2---MinTic/Ejercicios Libro Programación ModernaJava/ficheros/src/main/java/com/cristian/desarrollo/Ejercicio3/DatosVehiculo.txt";
        double tamanioDeposito = Double.parseDouble(deposito);

        try {
            File fichero = new File(rutaFichero);
            FileOutputStream ficheroSalida= new FileOutputStream(fichero.getAbsolutePath(), true);
            DataOutputStream salida = new DataOutputStream(ficheroSalida);
            
            Vehiculo v1 = new Vehiculo(matricula, marca, tamanioDeposito, modelo);
            // Matricula
            int longitudMatricula = v1.getMatricula().length();
            salida.writeInt(longitudMatricula);
            salida.writeBytes(v1.getMatricula());
            // Marca
            int longitudMarca = v1.getMarca().length();
            salida.writeInt(longitudMarca);
            salida.writeBytes(v1.getMarca());
            // Deposito
            salida.writeDouble(v1.getTamanioDeposito());
            // Modelo
            int longitudModelo = v1.getModelo().length();
            salida.writeInt(longitudModelo);
            salida.writeBytes(v1.getModelo());

            salida.close();

            String opc = JOptionPane.showInputDialog("Deseas ver todos los vehiculos?");
            if (opc.equalsIgnoreCase("Si") || opc.equalsIgnoreCase("si")){

                FileInputStream ficheroEntrada = new FileInputStream(fichero.getAbsolutePath());
                DataInputStream entrada = new DataInputStream(ficheroEntrada);
                
                while(entrada.available() > 0){
                    // Matricula
                    longitudMatricula = entrada.readInt();
                    byte[] bytesMatricula = new byte[longitudMatricula];
                    entrada.read(bytesMatricula, 0, longitudMatricula);
                    String matric = new String(bytesMatricula);
                    // Marca
                    longitudMarca = entrada.readInt();
                    byte[] bytesMarca = new byte[longitudMarca];
                    entrada.read(bytesMarca, 0, longitudMarca);
                    String marc = new String(bytesMarca);
                    // Deposito
                    double depo = entrada.readDouble();
                    // Modelo
                    longitudModelo = entrada.readInt();
                    byte[] bytesModelo = new byte[longitudModelo];
                    entrada.read(bytesModelo, 0, longitudModelo);
                    String model = new String(bytesModelo);

                    System.out.printf("El vehiculo tiene una matricula %s, " +
                        "su marca es %s, " + "el tamaño del deposito es de " +
                        "%.2f litros y su modelo es %s %n", matric, marc, depo, model);                
                }
                entrada.close();
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        }

    }
}
