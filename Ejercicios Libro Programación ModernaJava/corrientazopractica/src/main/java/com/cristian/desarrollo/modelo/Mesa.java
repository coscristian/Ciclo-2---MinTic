package com.cristian.desarrollo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private String numero;
    private Integer id;
    private List<Pedido> pedidos;

    public Mesa(String numero) {
        this.numero = numero;
        this.pedidos = new ArrayList<>();
    }

    // Getters y Setters

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void agregarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }    

    // Operaciones con la mesa

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer calcularValorMesa(){

        return pedidos.stream()
                .filter(pedido -> pedido.getEstado() == EstadoPedido.PENDIENTE_COBRAR)
                .map(pedido -> pedido.calcularValorPedido())
                .reduce((a, b) -> a + b)
                .orElse(0);
    }

    public Integer pagar(Integer efectivo){
        return null;
    }
}
