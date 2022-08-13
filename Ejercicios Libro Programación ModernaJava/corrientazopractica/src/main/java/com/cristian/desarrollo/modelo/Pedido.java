package com.cristian.desarrollo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Integer id;
    private Integer idMesa;
    private String cliente;
    private Corrientazo almuerzo;
    private List<Adicional> adicionales;
    private EstadoPedido estado;

    public Pedido(String cliente, Corrientazo almuerzo, Integer idMesa){
        this.cliente = cliente;
        this.almuerzo = almuerzo;
        this.idMesa = idMesa;
        
        // Estado inicial del pedido al ser creado
        this.estado = EstadoPedido.SIN_ENTREGAR;
        this.adicionales = new ArrayList<>();
    }

    public String getCliente() {
        return cliente;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Corrientazo getAlmuerzo() {
        return almuerzo;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public void setAlmuerzo(Corrientazo almuerzo) {
        this.almuerzo = almuerzo;
    }

    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public List<Adicional> getAdicionales() {
        return adicionales;
    }

    public void agregarAdicional(Adicional adicional) {
        this.adicionales.add(adicional);
    }

    public Integer calcularValor(){

        return almuerzo.getPrecio() + 
                adicionales.stream()
                .map(adicional -> adicional.getPrecio())
                .reduce((a,b)-> a + b)
                .orElse(0);
    }

    public void entregarPedido(){
        this.estado = EstadoPedido.PENDIENTE_COBRAR;
    }
}

