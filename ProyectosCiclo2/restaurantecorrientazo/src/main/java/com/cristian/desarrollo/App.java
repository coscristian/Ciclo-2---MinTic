package com.cristian.desarrollo;

import java.util.Scanner;

import com.cristian.desarrollo.controlador.RestauranteControlador;

public class App {    
    public static void main(String[] args) {
        //prueba();

        // Try with resources --> Cierra automaticamente el flujo que haya creado
        try( var sc = new Scanner(System.in) ){
            var controlador = new RestauranteControlador(sc);
            controlador.cargarBaseDatos();
            controlador.iniciarAplicacion();
        } catch (Exception e) {
            System.err.println("OCURRIÓ UN ERROR EN LA APLICACIÓN");
            System.err.println("\t" + e.getMessage());
        } 
    }
}
