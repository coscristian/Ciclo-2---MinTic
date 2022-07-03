package com.cristian.desarrollo;

public abstract class Aparato {
    protected String marca;
    private String peso;
    private String color;

    public Aparato(String marca, String peso, String color) {
        this.marca = marca;
        this.peso = peso;
        this.color = color;
    }

    public String mostrarMarca(){
        return "Aparato marca: " + marca;
    }

    public abstract String descripcion();
}
