package com.cristian.desarrollo.vista;

import java.sql.SQLException;
import java.util.Scanner;

import com.cristian.desarrollo.controlador.RestauranteControlador;
import com.cristian.desarrollo.modelo.Corrientazo;
import com.cristian.desarrollo.modelo.OpcionCarne;
import com.cristian.desarrollo.modelo.OpcionEnsalada;
import com.cristian.desarrollo.modelo.OpcionJugo;
import com.cristian.desarrollo.modelo.OpcionPrincipio;
import com.cristian.desarrollo.modelo.OpcionSopa;
import com.cristian.desarrollo.modelo.Pedido;

public class PedidoVista {
    
    private static final int PRECIO_CORRIENTAZO = 12_000;

    private Scanner sc;
    private RestauranteControlador controlador;

    public PedidoVista(Scanner sc, RestauranteControlador controlador){
        this.sc = sc;
        this.controlador = controlador;
    }

    private OpcionSopa elegirOpcionSopa() throws SQLException {
        System.out.println(".: ELIJA SOPA :.");

        OpcionSopa respuesta = null;
        var opciones = controlador.getSopas();
        do {
            try {
                System.out.println("Las mesas existentes son:");
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

    private OpcionPrincipio elegirOpcionPrincipio() throws SQLException {
        System.out.println(".: ELIJA PRINCIPIO :.");

        OpcionPrincipio respuesta = null;
        var opciones = controlador.getPrincipios();
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

    private OpcionCarne elegirOpcionCarne() throws SQLException {
        System.out.println(".: ELIJA CARNE :.");

        OpcionCarne respuesta = null;
        var opciones = controlador.getCarnes();
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

    private OpcionEnsalada elegirOpcionEnsalada() throws SQLException {
        System.out.println(".: ELIJA ENSALADA :.");

        OpcionEnsalada respuesta = null;
        var opciones = controlador.getEnsaladas();
        do {
            try {
                System.out.println("Las opciones son:");
                System.out.printf(" %d -> %s %n", 0, "Sin ensalada");
                for (int i = 0; i < opciones.size(); i++) {
                    System.out.printf(" %d -> %s %n", (i + 1), opciones.get(i));
                }
        
                System.out.print("Cual es su opción?: ");
                var opcion = sc.nextInt(); // EN el buffer queda el \n, cuando se lea algo diferente a cadenas
                if(opcion == 0){
                    break;
                }else if (opcion >= 1 && opcion <= opciones.size()){
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

    private OpcionJugo elegirOpcionJugo() throws SQLException {
        System.out.println(".: ELIJA JUGO :.");

        OpcionJugo respuesta = null;
        var opciones = controlador.getJugos();
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

    public Pedido pedirInformacionPedido() throws SQLException {
        System.out.println(".: INGRESANDO EL PEDIDO :.");
        
        System.out.println("Ingrese nombre (descripción) del cliente: ");
        var cliente = sc.nextLine();

        var sopa = elegirOpcionSopa();
        var principio = elegirOpcionPrincipio();
        var carne = elegirOpcionCarne();
        var ensalada = elegirOpcionEnsalada();
        var jugo = elegirOpcionJugo();

        return new Pedido(cliente,
                 new Corrientazo(PRECIO_CORRIENTAZO, sopa, principio, carne, ensalada, jugo));
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }


}
