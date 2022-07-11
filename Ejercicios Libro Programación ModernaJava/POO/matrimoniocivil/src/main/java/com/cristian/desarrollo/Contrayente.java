package com.cristian.desarrollo;

public class Contrayente extends Persona{

    public Contrayente(String nombre, String apellidos) {
        super(nombre, apellidos);
    }

    public Contrayente(String nombre, String apellidos, String edad) {
        super(nombre, apellidos, edad);
    }

    public Contrayente(String nombre, String apellidos, String edad, Character sexo) {
        super(nombre, apellidos, edad, sexo);
    }

    public Contrayente(String nombre, String apellidos, String edad, Character sexo, String direccion) {
        super(nombre, apellidos, edad, sexo, direccion);
    }

    @Override
    public String mostrarInfo() {
        return "Contrayente: \n" + getNombre();
    }
    
}
