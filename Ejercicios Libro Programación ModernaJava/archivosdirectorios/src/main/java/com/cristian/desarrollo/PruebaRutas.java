package com.cristian.desarrollo;

import java.io.File;

public class PruebaRutas {
    public static void main(String[] args) {
        File archivo = new File("BBDD");
        System.out.println();
        System.out.println(archivo.getAbsolutePath());
        System.out.println(archivo.exists());
    }
}

