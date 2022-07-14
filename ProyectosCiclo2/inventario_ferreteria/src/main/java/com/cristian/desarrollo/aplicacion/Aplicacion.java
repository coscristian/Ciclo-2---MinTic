package com.cristian.desarrollo.aplicacion;
import java.util.Scanner;

public class Aplicacion {
    public static Scanner teclado;
    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        var a = capturarNumeroEntero("Ingrese un numero entero");
        System.out.println(a);
    }

    public static Integer capturarNumeroEntero(String mensaje){
        while(true){
            try {
                System.out.printf("%s: ", mensaje);
                return Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("MENSAJE: Digite un valor que corresponda a un numero entero.");
            }
        }
    }
}
