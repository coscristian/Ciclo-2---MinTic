package com.cristian.desarrollo;

public class AutoridadCivil extends Persona{

    private TipoAutoridad autoridad;

    public AutoridadCivil(String nombre, String apellidos) {
        super(nombre, apellidos);
    }

    public AutoridadCivil(String nombre, String apellidos, String edad) {
        super(nombre, apellidos, edad);
    }

    public AutoridadCivil(String nombre, String apellidos, String edad, Character sexo) {
        super(nombre, apellidos, edad, sexo);
    }

    public AutoridadCivil(String nombre, String apellidos, String edad, Character sexo, String direccion) {
        super(nombre, apellidos, edad, sexo, direccion);
    }

    public TipoAutoridad getAutoridad() {
        return autoridad;
    }

    public void setAutoridad(TipoAutoridad autoridad) {
        this.autoridad = autoridad;
    }

    @Override
    public String mostrarInfo() {
        return autoridad + ": \n" + getNombre();
    }



    
}
