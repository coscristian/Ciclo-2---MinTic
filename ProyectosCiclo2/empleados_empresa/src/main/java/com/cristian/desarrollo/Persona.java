package com.cristian.desarrollo;

public abstract class Persona {
    protected String nombre;
    protected Integer edad;
    
    public Persona(String nombre, Integer edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public abstract void mostrarInfo();
}
