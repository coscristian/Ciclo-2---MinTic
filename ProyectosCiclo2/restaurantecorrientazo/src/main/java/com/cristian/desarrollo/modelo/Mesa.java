package com.cristian.desarrollo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private Integer numero;
    List<Pedido> pedidos;

    public Mesa(Integer numero){
        this(numero, new ArrayList<>());
    }
    
    public Mesa(Integer numero, List<Pedido> pedidos){
        this.numero = numero;
        this.pedidos = pedidos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setPedidos(Pedido pedido) {
        pedidos.add(pedido);
    }

    public Integer calcularValorMesa(){
        Integer valorMesa = 0;
        if (pedidos.size() > 0){
            for (Pedido pedido : pedidos) {
                valorMesa += pedido.calcularValorPedido();
            }
        }
        return valorMesa;
    }

    public Integer pagar(Integer efectivo){
        Integer totalPagar = calcularValorMesa();
        if (efectivo >= totalPagar){
            pedidos = new ArrayList<>();
            return efectivo - totalPagar;
        }else{
            return -1;
        }
    }
}
