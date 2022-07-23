package com.cristian.desarrollo;

import java.io.File;

public class AccesoFicheros {
    public static void main(String[] args) {
        String r = "Ejercicios Libro Programación ModernaJava" + File.separator + "POO";
        File ruta = new File(r);

        System.out.println();
        System.out.println(ruta.getAbsolutePath());
        String[] nombres_archivos = ruta.list();
        // Forma 1
/*         for (String nombre : nombres_archivos) {
            System.out.println("\t" + nombre);
            if( (ruta = (new File (r + File.separator + nombre))).isDirectory()){ // Si lo que está dentro de POO es un directorio
                String[] nombres_archivos2 = ruta.list();
                for (String nombreSub : nombres_archivos2) {
                    System.out.println("\t\t" + nombreSub);
                }
            }
        }  */

        // Forma 2
        for (String nombre_arch : nombres_archivos) {
            System.out.println("\t" + nombre_arch);
            File f = new File(ruta.getAbsolutePath(), nombre_arch);
            if(f.isDirectory()){
                String[] archivos_subcarpeta = f.list();
                for (String nombre_arch2 : archivos_subcarpeta) {
                    System.out.println("\t\t" + nombre_arch2);
                }
            }
        }
        
    }
}
