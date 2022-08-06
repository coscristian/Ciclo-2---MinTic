package com.cristian.desarrollo.vista;

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
            System.out.println(".: MENU PRINCIPAL :.");
            System.out.println("1 -> Gestión Pedidos");
            System.out.println("2 -> Pagos de Mesas");
            System.out.println("3 -> Tablas Maestras");
            System.out.println("0 -> Salir");
            System.out.print("¿Cúal es su opción?: ");
            var opcion = sc.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Saliendo");
                    enMenu = false;
                    break;
                case 1:
                    abrirMenuGestionPedidos();
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                default:
                    break;
            }
            
        } while (enMenu);
    }

    private void abrirMenuGestionPedidos() {
        var mesa = controlador.consultarMesa();
        var enMenu = true;        
        do {
            try {
                System.out.println(".: GESTIÓN PEDIDOS :.");
                System.out.println("1 -> Ver pedidos de Mesa");
                System.out.println("2 -> Agregar Pedido");
                System.out.println("3 -> Agregar Adicional a Pedido");
                System.out.println("4 -> Entregar Pedido");
                System.out.println("0 -> Salir al Menu Principal");
                System.out.print("¿Cúal es su opción?: ");    

                var opcion = sc.nextInt();
                sc.nextLine();
    
                switch (opcion) {
                    case 0:
                        System.out.println("Saliendo al Menu Principal");
                        enMenu = false;
                        break;
                    case 1:
                        controlador.mostrarPedidos(mesa);
                        enMenu = false;
                        break;
                    case 2:
                        controlador.agregarPedido(mesa);
                        enMenu = false;
                        break;
                    case 3:
                        controlador.agregarAdicional(mesa);
                        break;
                    case 4:
                        
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("ERROR, INTENTE DE NUEVO");
                e.printStackTrace();
            }
        } while (enMenu);
    }
}
