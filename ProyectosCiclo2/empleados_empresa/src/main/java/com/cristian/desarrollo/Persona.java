package com.cristian.desarrollo;

public abstract class Persona {
    protected String nombre;
    protected String edad;
    
    public Persona(String nombre, String edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public abstract String mostrarInfo();
}
