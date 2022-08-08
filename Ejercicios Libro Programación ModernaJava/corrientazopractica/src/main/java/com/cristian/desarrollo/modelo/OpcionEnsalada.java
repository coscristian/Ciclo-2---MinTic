package com.cristian.desarrollo.modelo;

public class OpcionEnsalada {
    private String nombre;
    private Integer idEnsalada;

    public OpcionEnsalada(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdEnsalada() {
        return idEnsalada;
    }

    public void setIdEnsalada(Integer idEnsalada) {
        this.idEnsalada = idEnsalada;
    }
}
