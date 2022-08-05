package com.cristian.desarrollo;

import com.cristian.desarrollo.modelo.*;

public class App {
    public static void main( String[] args ){
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
        System.out.printf("Cristian --> %d %n",cristian.calcularValorPedido());
        mesa1.getPedidos().forEach(p -> System.out.println(p));
    }
}
