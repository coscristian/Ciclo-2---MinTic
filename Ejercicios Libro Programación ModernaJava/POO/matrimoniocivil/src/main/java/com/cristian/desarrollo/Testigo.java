package com.cristian.desarrollo;

public class Testigo extends Persona{

    public Testigo(String nombre, String apellidos) {
        super(nombre, apellidos);
    }

    public Testigo(String nombre, String apellidos, String edad) {
        super(nombre, apellidos, edad);
    }

    public Testigo(String nombre, String apellidos, String edad, Character sexo) {
        super(nombre, apellidos, edad, sexo);
    }

    public Testigo(String nombre, String apellidos, String edad, Character sexo, String direccion) {
        super(nombre, apellidos, edad, sexo, direccion);
    }

    @Override
    public String mostrarInfo() {
        return "Testigo: \n" + getNombre();
    }
    
}
