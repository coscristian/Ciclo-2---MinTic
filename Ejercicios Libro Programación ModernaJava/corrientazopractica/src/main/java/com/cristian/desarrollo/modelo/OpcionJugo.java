package com.cristian.desarrollo.modelo;

public class OpcionJugo {
    private String nombre;
    private Integer id;
    
    public OpcionJugo(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
