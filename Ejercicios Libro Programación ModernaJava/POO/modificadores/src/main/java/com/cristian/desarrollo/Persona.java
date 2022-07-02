package com.cristian.desarrollo;

public class Persona {
    private String nombre;
    private final String id;
    private String estatura;
    private String edad;
    private Boolean tieneHijos;
    private Boolean trabajo;
    private Boolean tienesCanas;
    private String parentesco;

    public Persona(String nombre, String id, String estatura, String edad, boolean tieneHijos, Boolean trabajo, Boolean tienesCanas, String parentesco) {
        this.nombre = nombre;
        this.id = id;
        this.estatura = estatura;
        this.edad = edad;
        this.tieneHijos = tieneHijos;
        this.trabajo = trabajo;
        this.tienesCanas = tienesCanas;
        this.parentesco = parentesco;

    }    

    public String mostrarInfoGeneral(){
        return "\n------------------" +
        "\n" + parentesco +
        "\nNombre\t" + nombre +
        "\nID\t" + id + 
        "\nEst\t" + estatura +
        "\nEdad\t" + edad +
        "\nHijos\t" + tieneHijos + 
        "\nTrabajo\t" + trabajo +
        "\nCanas\t" + tienesCanas;
    } 
}
