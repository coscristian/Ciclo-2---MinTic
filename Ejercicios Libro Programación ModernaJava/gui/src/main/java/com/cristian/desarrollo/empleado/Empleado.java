package com.cristian.desarrollo.empleado;

public class Empleado {
    private String nombre;
    private String apellido;
    private Double salarioMensual;
    
    public Empleado(String nombre, String apellido, Double salarioMensual) {
        this.nombre = nombre;
        this.apellido = apellido;
        if (salarioMensual > 0)
            this.salarioMensual = salarioMensual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Double getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(Double salarioMensual) {
        if (salarioMensual > 0)
            this.salarioMensual = salarioMensual;
    }
}
