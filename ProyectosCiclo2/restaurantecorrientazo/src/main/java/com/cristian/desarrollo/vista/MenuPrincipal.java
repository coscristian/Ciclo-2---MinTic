package com.cristian.desarrollo.vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cristian.desarrollo.controlador.RestauranteControlador;

public class MenuPrincipal {

    private Scanner sc;
    private RestauranteControlador controlador;

    public MenuPrincipal(Scanner sc, RestauranteControlador controlador) {
        this.sc = sc;
        this.controlador = controlador;
    }

    public void iniciarAplicacion(){
        var enMenu = true;
        do {
            try {
                System.out.println(".: MENU PRINCIPAL :.");
                System.out.println("1 -> Gestión de Pedidos");
                System.out.println("2 -> Pagos de Mesas");
                System.out.println("3 -> Tablas maestras");
                System.out.println("0 -> Salir");
                System.out.print("¿Cual es su opción?: ");
                var opcion = sc.nextInt();

                switch (opcion) {
                    case 0:
                        System.out.println("Hasta pronto");
                        enMenu = true;
                        break;
                    case 1:
                        abrirMenuGestionPedidos();
                        break;
                    case 2:
                        pagosDeMesa();
                        break;
                    case 3:
                        abrirMenuTablasMaestras();
                        break;                
                    default:
                        break;
                }
                
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida, intente de nuevo.");
            }
        } while (enMenu);
    }

    private void abrirMenuTablasMaestras() {

        var salida = false;
        while(!salida){
            try {
                System.out.println(".: TABLAS MAESTRAS :.");
                System.out.println("1 -> Mesa");
                System.out.println("2 -> Opciones de Sopa");
                System.out.println("3 -> Opciones de Principio");
                System.out.println("4 -> Opciones de Carne");
                System.out.println("5 -> Opciones de Ensalada");
                System.out.println("6 -> Opciones de Jugo");
                System.out.println("7 -> Opciones de Adicionales");
                System.out.println("0 -> Salir al Menu Principal");
                System.out.print("¿Cual es su opción?: ");
                var opcion = sc.nextInt();
                sc.nextLine();
                
                switch (opcion) {
                    case 0:
                        salida = true;
                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;    
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;          
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida, intente de nuevo.");
            }
        } 
    }

    private void pagosDeMesa() {
        var mesa = controlador.consultarMesa();

        controlador.pagarCuenta(mesa);
    }

    private void abrirMenuGestionPedidos() {
        
        var mesa = controlador.consultarMesa();
        var salida = false;
        while(!salida){
            try {
                System.out.println(".: GESTIÓN DE PEDIDOS :.");
                System.out.println("1 -> Ver Pedidos de Mesa");
                System.out.println("2 -> Agregar Pedido");
                System.out.println("3 -> Agregar Adicional a Pedido");
                System.out.println("4 -> Entregar Pedido");
                System.out.println("0 -> Salir al Menu Principal");
                System.out.print("¿Cual es su opción?: ");
                var opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 0:
                        salida = true;
                        break;
                    case 1:
                        controlador.mostrarPedidos(mesa);
                        salida = true;
                        break;
                    case 2:
                        controlador.agregarPedido(mesa);
                        salida = true;
                        break;
                    case 3:
                        // TODO Realizar este método
                        salida = true;
                        break; 
                    case 4:
                        controlador.entregarPedido(mesa);
                        break;               
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida, intente de nuevo.");
            }
        } 
    }
}
