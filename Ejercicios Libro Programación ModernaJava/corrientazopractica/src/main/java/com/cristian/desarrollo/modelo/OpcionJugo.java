package com.cristian.desarrollo.modelo;

public class OpcionJugo {
    private String nombre;
    private Integer idJugo;
    
    public OpcionJugo(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdJugo() {
        return idJugo;
    }

    public void setIdJugo(Integer idJugo) {
        this.idJugo = idJugo;
    }
}
