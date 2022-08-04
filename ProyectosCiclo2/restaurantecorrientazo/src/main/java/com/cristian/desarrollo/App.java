package com.cristian.desarrollo;

import java.util.Scanner;

import com.cristian.desarrollo.controlador.RestauranteControlador;
import com.cristian.desarrollo.modelo.*;

public class App {    
    public static void main(String[] args) {
        //prueba();

        // Try with resources --> Cierra automaticamente el flujo que haya creado
        try( var sc = new Scanner(System.in) ){
            
            var controlador = new RestauranteControlador(sc);    
            controlador.cargarBaseDatos();

            var mesa = controlador.consultarMesa();
            System.out.println("La mesa seleccionada es: " + mesa);
            
            controlador.agregarPedido(mesa);
            controlador.agregarPedido(mesa);

            controlador.entregarPedido(mesa);

            System.out.println("El total a pagar del pedido de la mesa es: " + mesa.calcularValor());

        } catch (Exception e) {
            System.err.println("OCURRIÓ UN ERROR EN LA APLICACIÓN");
            System.err.println("\t" + e.getMessage());
        } 
    }

    private static void prueba() {
        var mesa = new Mesa("1");

        var almuerzo1 = new Corrientazo(12_000,
                 new OpcionSopa("Patacón"),
                 new OpcionPrincipio("Frijoles"),
                 new OpcionCarne("Cerdo a la plancha"),
                 new OpcionEnsalada("Cesar"),
                 new OpcionJugo("Limonada"));
        
        var almuerzo2 = new Corrientazo(12_000,
                 new OpcionSopa("Raiz"),
                 new OpcionPrincipio("Espaguetis"),
                 new OpcionCarne("Pollo sudado"),
                 new OpcionJugo("Maracuya"));
        
        var anderson = new Pedido("Anderson", almuerzo1);
        var cristian = new Pedido("Cristian", almuerzo2);

        mesa.agregarPedido(anderson);
        mesa.agregarPedido(cristian);

        anderson.agregarAdicional(new Adicional("Chicharron", 3_000));
        anderson.agregarAdicional(new Adicional("Huevo", 800));

        anderson.entregarPedido();
        cristian.entregarPedido();

        System.out.printf("Total de la mesa: $ %,d %n", mesa.calcularValor());
        var efectivo = 27_700;
        try {
            System.out.printf("Se paga con $ %,d y le devuelven $%,d %n",
                efectivo, mesa.pagar(efectivo));
        } catch (Exception e) {
            System.err.printf("Se paga con $ %,d y el efectivo no es suficiete para cubrir la cuenta %n",
                efectivo, e.getMessage());
        }

        System.out.println(mesa.calcularValor());
    }
}
