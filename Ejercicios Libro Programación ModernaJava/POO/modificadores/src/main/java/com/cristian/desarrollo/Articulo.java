package com.cristian.desarrollo;

public class Articulo {
    private final String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    
    public Articulo(String codigo, String nombre, String descripcion, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String mostrarInfo(){
        return "\nID: \t" + codigo + "\nNombre: \t" + nombre + "\nDescripcion: \t" + descripcion + "\nPrecio:\t" + precio;
    }
    
}