package com.cristian.desarrollo.vista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cristian.desarrollo.controlador.RestauranteControlador;
import com.cristian.desarrollo.modelo.Adicional;
import com.cristian.desarrollo.modelo.Mesa;
import com.cristian.desarrollo.modelo.Pedido;

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

    public void mostrarPedidos(Mesa mesa) throws SQLException{
        System.out.printf(".: PEDIDOS DE LA MESA %s :.%n", mesa.getNumero());
        List<Pedido> pedidos = controlador.getPedidos(mesa);
        List<Adicional> adicionales = new ArrayList<>();
        
        for (Pedido pedido : pedidos) {
            
            System.out.println("\t----------------");
            System.out.printf("\tPedido Cliente -> %s %n", pedido.getCliente());
            System.out.printf("\tID -> %d %n", pedido.getId());
            System.out.printf("\tEstado -> %s %n", pedido.getEstado());
            System.out.println("\t\t----------------");
            System.out.printf("\t\t.: ALimentos :. %n");
            System.out.println("\t\t----------------");
            System.out.printf("\t\tSopa -> %s %n", pedido.getAlmuerzo().getSopa().getNombre());
            System.out.printf("\t\tPrincipio -> %s %n", pedido.getAlmuerzo().getPrincipio().getNombre());
            System.out.printf("\t\tCarne -> %s %n", pedido.getAlmuerzo().getCarne().getNombre());
            
            String ensalada = null;
            if (pedido.getAlmuerzo().getEnsalada() != null)
                ensalada = pedido.getAlmuerzo().getEnsalada().getNombre();
            System.out.printf("\t\tEnsalada -> %s %n", ensalada);
            System.out.printf("\t\tJugo -> %s %n", pedido.getAlmuerzo().getJugo().getNombre());

            adicionales = controlador.getAdicionales(mesa, pedido);
            if ( adicionales.size() > 0 ){ // Si hay adicionales en la consulta
                System.out.println("\t\t-----------------");
                System.out.printf("\t\t.: Adicionales :.%n");
                System.out.println("\t\t-----------------");
                for (Adicional adicional : adicionales) {
                    System.out.printf("\t\tNombre -> %s %n", adicional.getNombre());
                    System.out.printf("\t\t\tPrecio -> %,d %n", adicional.getPrecio());
                }
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public Integer pedirEfectivo() {
        System.out.println(".: SOLICITANDO EFECTIVO :.");
        
        System.out.printf("Ingrese el valor del efectivo: ");
        Integer efectivo = sc.nextInt();
        sc.nextLine();

        return efectivo;
    }
}

