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

    private RestauranteControlador controlador;
    private Scanner sc;

    public PedidoVista(RestauranteControlador controlador, Scanner sc){
        this.controlador = controlador;
        this.sc = sc;
        
    }

    public Pedido pedirInformacionPedido(Integer idMesa) throws SQLException {
        System.out.println(".: AGREGANDO PEDIDO :.");
        
        System.out.printf("Ingrese el nombre del cliente: ");
        String cliente = sc.nextLine();

        OpcionSopa sopa = elegirSopa();
        OpcionPrincipio principio = elegirPrincipio();
        OpcionCarne carne = elegirCarne();
        OpcionEnsalada ensalada = elegirEnsalada();
        OpcionJugo jugo = elegirJugo();
        
        return new Pedido(cliente,
                         new Corrientazo(12_000, sopa, principio, carne, ensalada, jugo),
                         idMesa);
    }

    private OpcionEnsalada elegirEnsalada() throws SQLException {
        var ensaladas = controlador.getEnsaladas();
        OpcionEnsalada respuesta = null;

        do {
            try {
                System.out.println("ELIJA ENSALADA:");
                for (int i = 0; i < ensaladas.size(); i++) {
                    System.out.printf("\t%d -> %s %n", (i+1), ensaladas.get(i).getNombre());
                }
                System.out.print("\t¿Qué desea elegir?: ");
                var opcion = sc.nextInt();
                
                if(opcion >= 1 && opcion <= ensaladas.size()){
                    respuesta = ensaladas.get(opcion -1);
                }else{
                    System.out.println("Opcion Incorrecta Intente de nuevo!!");
                }
            } catch (Exception e) {
                System.out.println("ERROR, INTETE DE NUEVO");
                e.printStackTrace();
            }
        } while (respuesta == null);
        return respuesta;
    }

    private OpcionJugo elegirJugo() throws SQLException {
        var jugos = controlador.getJugos();
        OpcionJugo respuesta = null;

        do {
            try {
                System.out.println("ELIJA JUGO:");
                for (int i = 0; i < jugos.size(); i++) {
                    System.out.printf("\t%d -> %s %n", (i+1), jugos.get(i).getNombre());
                }
                System.out.print("\t¿Qué desea elegir?: ");
                var opcion = sc.nextInt();
                
                if(opcion >= 1 && opcion <= jugos.size()){
                    respuesta = jugos.get(opcion -1);
                }else{
                    System.out.println("Opcion Incorrecta Intente de nuevo!!");
                }
            } catch (Exception e) {
                System.out.println("ERROR, INTETE DE NUEVO");
                e.printStackTrace();
            }
        } while (respuesta == null);
        return respuesta;
    }

    private OpcionPrincipio elegirPrincipio() throws SQLException {
        var principios = controlador.getPrincipios();
        OpcionPrincipio respuesta = null;

        do {
            try {
                System.out.println("ELIJA PRINCIPIO:");
                for (int i = 0; i < principios.size(); i++) {
                    System.out.printf("\t%d -> %s %n", (i+1), principios.get(i).getNombre());
                }
                System.out.print("\t¿Qué desea elegir?: ");
                var opcion = sc.nextInt();
                
                if(opcion >= 1 && opcion <= principios.size()){
                    respuesta = principios.get(opcion -1);
                }else{
                    System.out.println("Opcion Incorrecta Intente de nuevo!!");
                }
            } catch (Exception e) {
                System.out.println("ERROR, INTETE DE NUEVO");
                e.printStackTrace();
            }
        } while (respuesta == null);
        return respuesta;
    }

    private OpcionCarne elegirCarne() throws SQLException {
        var carnes = controlador.getCarnes();
        OpcionCarne respuesta = null;

        do {
            try {
                System.out.println("ELIJA CARNE:");
                for (int i = 0; i < carnes.size(); i++) {
                    System.out.printf("\t%d -> %s %n", (i+1), carnes.get(i).getNombre());
                }
                System.out.print("\t¿Qué desea elegir?: ");
                var opcion = sc.nextInt();
                
                if(opcion >= 1 && opcion <= carnes.size()){
                    respuesta = carnes.get(opcion -1);
                }else{
                    System.out.println("Opcion Incorrecta Intente de nuevo!!");
                }
            } catch (Exception e) {
                System.out.println("ERROR, INTETE DE NUEVO");
                e.printStackTrace();
            }
        } while (respuesta == null);
        return respuesta;
    }

    private OpcionSopa elegirSopa() throws SQLException {
        var sopas = controlador.getSopas();
        OpcionSopa respuesta = null;

        do {
            try {
                System.out.println("ELIJA SOPA:");
                for (int i = 0; i < sopas.size(); i++) {
                    System.out.printf("\t%d -> %s %n", (i+1), sopas.get(i).getNombre());
                }
                System.out.print("\t¿Qué desea elegir?: ");
                var opcion = sc.nextInt();
                
                if(opcion >= 1 && opcion <= sopas.size()){
                    respuesta = sopas.get(opcion -1);
                }else{
                    System.out.println("Opcion Incorrecta Intente de nuevo!!");
                }
            } catch (Exception e) {
                System.out.println("ERROR, INTENTE DE NUEVO");
                e.printStackTrace();
            }
        } while (respuesta == null);
        return respuesta;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
