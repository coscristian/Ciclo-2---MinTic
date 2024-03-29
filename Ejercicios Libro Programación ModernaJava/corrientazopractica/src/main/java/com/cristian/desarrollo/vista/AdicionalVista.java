package com.cristian.desarrollo.vista;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.cristian.desarrollo.controlador.RestauranteControlador;
import com.cristian.desarrollo.modelo.Adicional;
import com.cristian.desarrollo.modelo.Mesa;

public class AdicionalVista {
    
    private RestauranteControlador controlador;
    private Scanner sc;
    
    public AdicionalVista(RestauranteControlador controlador, Scanner sc){
        this.controlador = controlador;
        this.sc = sc;
    }

    public Adicional pedirInformacionAdicional(Mesa mesa) throws InputMismatchException, SQLException {
        System.out.println(".: AGREGANDO ADICIONAL :.");
        
        // Pedir info
        System.out.printf("Ingrese el id del pedido al que va a agregar el adicional: ");
        Integer idPedido = sc.nextInt();
        sc.nextLine();

        // Pedir nombre
        System.out.printf("Ingrese el nombre del adicional: ");
        String nombre = sc.nextLine();

        // Pedir precio
        System.out.printf("Ingrese el precio del adicional: ");
        Integer precio = sc.nextInt();
        sc.nextLine();

        // Crear el adicional --> Generar el consecutivo del adicional
        var adicional = new Adicional(nombre, precio);
        adicional.setIdPedido(idPedido);

        return adicional;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
