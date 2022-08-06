package com.cristian.desarrollo;

import java.util.Scanner;

import com.cristian.desarrollo.controlador.RestauranteControlador;
import com.cristian.desarrollo.modelo.*;

public class App {
    public static void main( String[] args ){
        //prueba();
        try (var sc = new Scanner(System.in)){
            var controlador = new RestauranteControlador(sc);
            controlador.cargarBaseDatos();
            controlador.iniciarAplicacion();
        } catch (Exception e) {
            System.err.println("OCURRIÓ UN ERROR EN LA APLICACIÓN");
            System.err.println("\t" + e.getMessage());
        }

    }

    private static void prueba() {
        // Mesas del resturante
        var mesa1 = new Mesa("1");
        
        // Corrientazos 
        var almuerzo1 = new Corrientazo(12_000,
             new OpcionSopa("Queso"),
             new OpcionPrincipio("Fijoles"),
             new OpcionCarne("Res Plancha"),
             new OpcionEnsalada("Dulce"),
             new OpcionJugo("Lulo"));
        
        var almuerzo2 = new Corrientazo(12_000,
             new OpcionSopa("Patacón"),
             new OpcionPrincipio("Guiso Patacón"),
             new OpcionCarne("Punta de anca"),
             new OpcionEnsalada("Remolacha"),
             new OpcionJugo("Maracuyá"));
        
        // Creación de pedidos
        var cristian = new Pedido("Cristian", almuerzo1);
        var juan = new Pedido("Juan", almuerzo2);

        cristian.agregarAdicional(new Adicional("Ajiaco", 2_000));

        // Asignación de pedidos a las mesas
        mesa1.agregarPedido(cristian);
        mesa1.agregarPedido(juan);

        // Realizar entrega de pedidos
        cristian.entregarPedido();
        juan.entregarPedido();

        // Vista
        System.out.println("");
        System.out.printf("Cristian --> %d %n",cristian.calcularValorPedido());
        System.out.printf("Juan --> %d %n",juan.calcularValorPedido());
        
        System.out.printf("%n Mesa 1 %n");
        mesa1.getPedidos().forEach(p -> System.out.println("\t" + p));

        System.out.printf("%n A pagar en la mesa 1: $%,d%n", mesa1.calcularValorMesa());
    }
}
