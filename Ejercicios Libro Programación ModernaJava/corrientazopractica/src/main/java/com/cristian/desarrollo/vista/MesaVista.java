package com.cristian.desarrollo.vista;

import java.sql.SQLException;
import java.util.Scanner;

import com.cristian.desarrollo.controlador.RestauranteControlador;
import com.cristian.desarrollo.modelo.Mesa;

public class MesaVista {

    private RestauranteControlador controlador;
    private Scanner sc;

    public MesaVista(RestauranteControlador controlador, Scanner sc) {
        this.controlador = controlador;
        this.sc = sc;
    }

    public Mesa consultarMesa() throws SQLException {
        System.out.println(".: CONSULTANDO MESAS :.");
        
        Mesa respuesta = null;
        var mesas = controlador.getMesas();
        
        do {
            try {
                System.out.println("Las mesas existentes son:");
                            
                for (int i = 0; i < mesas.size(); i++) {
                    System.out.printf("%s -> Mesa %s %n", (i+1), mesas.get(i).getNumero());
                }

                System.out.print("¿Cual es su opción?: ");
                var opcion = sc.nextInt();
                sc.nextLine();
        
                if (opcion >= 1 && opcion <= mesas.size()){
                    respuesta = mesas.get(opcion - 1);
                }else{
                    System.out.println("MESANJE: Opcion Invalida, intente de nuevo !!");
                }            
            } catch (Exception e) {
                System.err.println("MESANJE: Opcion Invalida, intente de nuevo !!");
                e.printStackTrace();
            }

        } while (respuesta == null);            
        return respuesta;
    }

    public void mostrarPedidos(Mesa mesa){
        System.out.printf(".: PEDIDOS DE LA MESA %s :.%n", mesa.getNumero());
        
        mesa.getPedidos().forEach(pedido -> System.out.printf("\tPedido Cliente -> %s %n\t\t%s %n", pedido.getCliente(), pedido.getEstado()));
        }
}

