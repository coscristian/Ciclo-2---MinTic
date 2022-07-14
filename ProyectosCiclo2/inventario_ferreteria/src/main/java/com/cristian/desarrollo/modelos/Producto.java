package com.cristian.desarrollo.modelos;

public class Producto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double precioCompra;
    private Double precioVenta;
    private Integer cantidad;
    private Integer cantidadMinimaStock;
    private Integer idProveedor;
    
    public Producto() {
    }

    public Producto(Integer id, String nombre, String descripcion, Double precioCompra, Double precioVenta,
            Integer cantidad, Integer cantidadMinimaStock, Integer idProveedor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.cantidadMinimaStock = cantidadMinimaStock;
        this.idProveedor = idProveedor;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Integer getCantidadMinimaStock() {
        return cantidadMinimaStock;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setCantidadMinimaStock(Integer cantidadMinimaStock) {
        this.cantidadMinimaStock = cantidadMinimaStock;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
}
