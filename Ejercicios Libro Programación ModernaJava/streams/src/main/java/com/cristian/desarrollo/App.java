package com.cristian.desarrollo;

import com.cristian.desarrollo.escribiendo.EscribirFichero;
import com.cristian.desarrollo.leyendo.LeerFichero;

public class App {
    public static void main( String[] args ){
        System.out.println();
        LeerFichero accediendo = new LeerFichero();
        accediendo.lee();
/*         EscribirFichero escribiendo = new EscribirFichero();
        escribiendo.escribir(); */
        System.out.println();
    }
}
