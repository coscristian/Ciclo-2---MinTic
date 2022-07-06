package com.cristian.desarrollo.modelo;

public class Cliente extends Persona{
    private String telefono;

    // El cliente se puede crear solo con el nombre y la edad
    public Cliente(String nombre, Integer edad) {
        this(nombre, edad, "N/A");
    }

    // El cliente se puede crear con el nombre, la edad y el telefono
    public Cliente(String nombre, Integer edad, String telefono){
        super(nombre,edad);
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    @Override
    public String mostrarInfo(){
        return String.format("El cliente de nombre %s tiene edad %d y su telefono es %s %n", getNombre(), getEdad(), getTelefono());
    }
}
