package com.cristian.desarrollo.modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Factura {
    private static Integer contadorIds = 1;
    private Integer id;
    private Date fecha;
    private String cedulaCliente;
    private Double impuesto;
    private Double total;
    private List<Integer> idsProductos;

    public Factura() {
        idsProductos = new ArrayList<>();
        id = contadorIds;
        contadorIds++;
    }

    public Factura(String cedulaCliente, Double impuesto) {
        this();
        fecha = new Date();
        this.cedulaCliente = cedulaCliente;
        this.impuesto = impuesto;
    }
    
    public Integer getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public Double getTotal() {
        return total;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void agregarIdProducto(Integer idProducto){
        idsProductos.add(idProducto);
    }

    public Integer[] getIdsProductos(){
        // Creates a new array with all the elements of the list to avoid modifications outside the class
        return idsProductos.toArray(new Integer[idsProductos.size()]);
    }

}
