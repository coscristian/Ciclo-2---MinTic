package com.cristian.desarrollo;

public class Producto implements Interfaz1{
    // Atributos de la clase
    private String nombre;
    private double precio;
    private int cant;

    // Constructor de Producto
    public Producto(String nombre, double precio, int cant) {
        this.nombre = nombre;
        this.precio = precio;
        this.cant = cant;
    }

    // Métodos Getters
    public double calcularIva(int precioArticulo, int cantProductos){
        return (precioArticulo * cantProductos) * valorIva;
    }

    public double calcularDesc(double precioArticulo){
        return precioArticulo * valorDescuento;
    }

    public double calcularPrecioTotal(double precioArticulo, int cantArticulos, double ivaDelPrecioTotal){
        return (precioArticulo * cantArticulos) + ivaDelPrecioTotal;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCant() {
        return cant;
    }
}
