package com.cristian.desarrollo.modelo;

public class OpcionEnsalada {
    private String nombre;

    public OpcionEnsalada(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
