package com.cristian.desarrollo.modelo;

import java.util.ArrayList;
import java.util.List;

import com.cristian.desarrollo.exception.PagoException;

public class Mesa {
    private String numero;
    List<Pedido> pedidos;

    public Mesa(String numero){
        this(numero, new ArrayList<Pedido>());
    }
    
    public Mesa(String numero, List<Pedido> pedidos){
        this.numero = numero;
        this.pedidos = pedidos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public Integer calcularValor(){
/*         Integer valorMesa = 0;
        if (pedidos.size() > 0){
            for (Pedido pedido : pedidos) {
                valorMesa += pedido.calcularValorPedido();
            }
        }
        return valorMesa; */
        var total = pedidos.stream()
                .filter(pedido -> pedido.getEstado() == EstadoPedido.PEDIENTE_COBRAR) // Solo pasan al map los estados que esten pendientes por cobrar
                .map(pedido -> pedido.calcularValor())
                .reduce((a, b) -> a + b)
                .orElse(0);
        return total;
    }

    public Integer pagar(Integer efectivo) throws PagoException{
/*         Integer totalPagar = calcularValorMesa();
        if (efectivo >= totalPagar){
            pedidos = new ArrayList<>();
            return efectivo - totalPagar;
        }else{
            return -1;
        } */

        // Valido si es suficiente para pagar
        var total = calcularValor();
        if(efectivo < total){
            throw new PagoException("El efectivo no es suficiente para cubrir la cuenta");
        }

        // Elimino los pedidos de la mesa
        pedidos.clear();

        // Retorna la devuelta
        return efectivo - total;
    }

    @Override
    public String toString() {
        return "Mesa [numero=" + numero + "]";
    }
}
