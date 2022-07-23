package com.cristian.desarrollo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    public static final EstadoPedido ESTADO_INICIAL = EstadoPedido.SIN_ENTREGAR;
    public static final EstadoPedido PENDIENTE_COBRAR = EstadoPedido.PEDIENTE_COBRAR;

    private String nombre;
    Corrientazo almuerzo;
    List<Adicional> alimentosAdicionales;
    EstadoPedido estado;

    public Pedido(String nombre) {
        this(nombre, null);
    }

    public Pedido(String nombre, Corrientazo almuerzo) {
        this(nombre, almuerzo, new ArrayList<Adicional>());
    }

    public Pedido(String nombre, Corrientazo almuerzo, List<Adicional> alimentosAdicionales) {
        this.nombre = nombre;
        this.almuerzo = almuerzo;
        this.alimentosAdicionales = alimentosAdicionales;
        this.estado = ESTADO_INICIAL;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Corrientazo getAlmuerzo() {
        return almuerzo;
    }

    public void setAlmuerzo(Corrientazo almuerzo) {
        this.almuerzo = almuerzo;
    }

    public void setAlimentoAdicional(Adicional alimentoAdicional) {
        alimentosAdicionales.add(alimentoAdicional);
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Adicional> getAlimentosAdicionales() {
        return alimentosAdicionales;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public Integer calcularValorPedido() {
        Integer totalPedido = almuerzo.getPrecio();
        if (alimentosAdicionales.size() > 0){
            for (Adicional adicional : alimentosAdicionales) {
                totalPedido += adicional.getPrecio();
            }
        }
        return totalPedido;
    }

}
