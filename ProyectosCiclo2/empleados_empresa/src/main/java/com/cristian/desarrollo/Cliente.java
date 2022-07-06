package com.cristian.desarrollo;

public class Cliente extends Persona{
    private String telefono;

    public Cliente(String nombre, Integer edad){
        this(nombre, edad, "N/A");
    }

    public Cliente(String nombre, Integer edad, String telefono){
        super(nombre, edad);
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public void mostrarInfo() {
        System.out.printf("El cliente de nombre %s tiene edad %d y su telefono es %s %n",
        getNombre(), getEdad(), getTelefono());
    }
}
