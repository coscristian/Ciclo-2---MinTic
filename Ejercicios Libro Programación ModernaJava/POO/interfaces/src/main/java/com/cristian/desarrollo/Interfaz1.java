
package com.cristian.desarrollo;

public interface Interfaz1 {
    public final double valorIva = 19.0 / 100;
    public final double valorDescuento = 20.0 / 100;
    public abstract double calcularIva(int precioArticulo, int cantProductos);
    public abstract double calcularDesc(double precioArticulo);
}
