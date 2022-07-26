package com.cristian.desarrollo.factura;

public class Factura {
    private String numeroPieza;
    private String descripcion;
    private int cantArticulos;
    private double precioUnidad;
    
    public Factura(String numeroPieza, String descripcion, int cantArticulos, double precioUnidad) {        
        this.numeroPieza = numeroPieza;
        this.descripcion = descripcion;
        this.cantArticulos = 0;
        this.precioUnidad = 0.0;

        if(cantArticulos > 0){
            this.cantArticulos = cantArticulos;
        }
        
        if(precioUnidad > 0.0){
            this.precioUnidad = precioUnidad;
        }
    }

    public String getNumeroPieza() {
        return numeroPieza;
    }

    public void setNumeroPieza(String numeroPieza) {
        this.numeroPieza = numeroPieza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantArticulos() {
        return cantArticulos;
    }

    public void setCantArticulos(int cantArticulos) {
        if(cantArticulos > 0){
            this.cantArticulos = cantArticulos;
        }
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        if(precioUnidad > 0.0){
            this.precioUnidad = precioUnidad;
        }
    }

    public double obtenerMontoFactura(){
        return cantArticulos * precioUnidad;
    }

    @Override
    public String toString() {
        return String.format("FACTURA %n" +
                        "\tNum Pieza:\t %s %n" + 
                        "\tDescripción:\t %s %n" + 
                        "\tCantidad:\t %d %n" +  
                        "\tPrecio Unid:$\t %,.2f %n",
                        numeroPieza,
                        descripcion, 
                        cantArticulos,
                        precioUnidad); 
    }

    

}
