package com.cristian.desarrollo.vista;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.cristian.desarrollo.controlador.RestauranteControlador;
import com.cristian.desarrollo.modelo.Mesa;
import com.cristian.desarrollo.modelo.Pedido;

public class MesaVista {
    private Scanner sc;
    private RestauranteControlador controlador;

    public MesaVista(Scanner sc, RestauranteControlador controlador){
        this.sc = sc;
        this.controlador = controlador;
    }

    public Mesa pedirInformacionMesa() {

        System.out.println(".: INFORMACIÓN DE LA MESA :.");
        System.out.print("Ingrese el número de la mesa: ");
        var numero = sc.nextLine();

        return new Mesa(numero);
    }

    public void mostrarMesas(List<Mesa> mesas) {
        System.out.println(".: MESAS EN EL SISTEMA :.");
        mesas.forEach(System.out::println);
    }

    public Mesa consultarMesa() throws SQLException {
        System.out.println(".: CONSULTANDO MESAS :.");

        Mesa respuesta = null;
        var mesas = controlador.getMesas();
        do {
            try {
                System.out.println("Las mesas existentes son:");
                for (int i = 0; i < mesas.size(); i++) {
                    System.out.printf(" %d -> %s %n", (i + 1), mesas.get(i));
                }
        
                System.out.print("Cual es su opción?: ");
                var opcion = sc.nextInt(); // En el buffer queda el \n, cuando se lea algo diferente a cadenas
                if (opcion >= 1 && opcion <= mesas.size()){
                    respuesta = mesas.get(opcion - 1);
                }else{
                    System.err.println("Opción invalida, intente de nuevo");
                }
            } catch (Exception e) {
                System.err.println("OPCION INVALIDA, INTENTE DE NUEVO !!!");
                e.printStackTrace(); // Imprime todo el mensaje de error
            } finally{
                sc.nextLine();
            }

        } while (respuesta == null);
        return respuesta;
    }

    public Pedido seleccionePedido(Mesa mesa) {
        System.out.println(".: ELIJA EL PEDIDO :.");

        Pedido respuesta = null;
        var opciones = mesa.getPedidos();
        do {
            try {
                System.out.println("Las opciones son:");
                for (int i = 0; i < opciones.size(); i++) {
                    System.out.printf(" %d -> %s %n", (i + 1), opciones.get(i));
                }
        
                System.out.print("Cual es su opción?: ");
                var opcion = sc.nextInt(); // EN el buffer queda el \n, cuando se lea algo diferente a cadenas
                if (opcion >= 1 && opcion <= opciones.size()){
                    respuesta = opciones.get(opcion - 1);
                }else{
                    System.err.println("Opción invalida, intente de nuevo");
                }
            } catch (Exception e) {
                System.err.println("OPCION INVALIDA, INTENTE DE NUEVO !!!");
                e.printStackTrace(); // Imprime todo el mensaje de error
            } finally{
                sc.nextLine();
            }

        } while (respuesta == null);

        return respuesta;
    }

    public Integer leerValorEfectivo() {
        Integer respuesta = null;
        while(respuesta == null){
            try {
                System.out.print("Ingrese el valor del efectivo?: ");
                respuesta = sc.nextInt();
            } catch (Exception e) {
                System.err.println("VALOR INVALIDO, INTENTE DE NUEVO !!!");
                e.printStackTrace(); // Imprime todo el mensaje de error
            } finally{
                sc.nextLine();
            }
        }
        return respuesta;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarPedidos(Mesa mesa) {
        var opciones = mesa.getPedidos();
        System.out.println("Los pedidos son:");
        for (int i = 0; i < opciones.size(); i++) {
            System.out.printf(" %d -> %s %n", (i + 1), opciones.get(i));
        }
    }
    
}
