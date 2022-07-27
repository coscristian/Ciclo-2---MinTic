package com.cristian.desarrollo;

import java.util.ArrayList;
import java.util.List;
import com.cristian.desarrollo.modelo.*;

public class App {    
    public static void main(String[] args) {
        var mesa = new Mesa(1);

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

        System.out.printf("Total de la mesa: $ %,d %n", mesa.calcularValor());
        var efectivo = 27_800;
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
