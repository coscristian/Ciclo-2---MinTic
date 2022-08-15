package com.mycompany.modelo;

public class Lider {
    private Integer id;
    private String nombre;
    private String primerApellido;
    private String ciudadResidencia;

    public Lider(Integer id, String nombre, String primerApellido, String ciudadResidencia) {
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.ciudadResidencia = ciudadResidencia;
    }        

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }
}
