package com.cristian.desarrollo.modelo;

import java.util.ArrayList;
import java.util.List;

import com.cristian.desarrollo.exception.PagoException;

public class Mesa {
    private Integer id;
    private String numero;
    List<Pedido> pedidos;

    public Mesa(String numero){
        this(numero, new ArrayList<Pedido>());
    }
    
    public Mesa(String numero, List<Pedido> pedidos){
        this.numero = numero;
        this.pedidos = pedidos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Mesa # " + numero;
    }

}
