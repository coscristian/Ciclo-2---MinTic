package com.cristian.desarrollo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    //public static final EstadoPedido ESTADO_INICIAL = EstadoPedido.SIN_ENTREGAR;
    //public static final EstadoPedido PENDIENTE_COBRAR = EstadoPedido.PEDIENTE_COBRAR;

    //private String nombre;
    private String cliente;
    private Corrientazo almuerzo;
    private List<Adicional> adicionales;
    private EstadoPedido estado;
    //EstadoPedido estado;

/*     public Pedido(String nombre) {
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
    } */

    // Versión profesor
    public Pedido(String cliente, Corrientazo almuerzo){
        this.cliente = cliente;
        this.almuerzo = almuerzo;

        estado = EstadoPedido.SIN_ENTREGAR;
        adicionales = new ArrayList<>();
    }

/*     public void setNombre(String nombre) {
        this.nombre = nombre;
    } */

    public Corrientazo getAlmuerzo() {
        return almuerzo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setAlmuerzo(Corrientazo almuerzo) {
        this.almuerzo = almuerzo;
    }

    public void agregarAdicional(Adicional alimentoAdicional) {
        adicionales.add(alimentoAdicional);
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

/*     public String getNombre() {
        return nombre;
    } */

    public List<Adicional> getAdicionales() {
        return adicionales;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

/*     public Integer calcularValorPedido() {
        Integer totalPedido = almuerzo.getPrecio();
        if (adicionales.size() > 0){
            for (Adicional adicional : adicionales) {
                totalPedido += adicional.getPrecio();
            }
        }
        return totalPedido;
    } */

    public Integer calcularValor(){
        return almuerzo.getPrecio()
                + adicionales.stream()
                    .map(adicional -> adicional.getPrecio()) // Aqui tengo una lista de precios
                    .reduce((a, b) -> a + b) // Toma una lista y recibe una función y todos los datos los lleva a uno
                    .orElse(0); // En caso contrario, en caso de que no tenga ningún valor
    }           

    public void entregarPedido(){
        estado = EstadoPedido.PEDIENTE_COBRAR;
    }

    @Override
    public String toString() {
        return "Pedido [cliente=" + cliente + ", almuerzo=" + almuerzo + ", adicionales=" + adicionales + ", estado="
                + estado + "]";
    }

    
}
