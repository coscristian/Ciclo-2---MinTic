package com.cristian.desarrollo;

public class Empleado extends Persona{
    private double sueldoBruto;

    public Empleado(String nombre, String edad, double sueldoBruto) {
        super(nombre, edad);
        this.sueldoBruto = sueldoBruto;
    }

    public String mostrarInfo(){
        return "\nNombre: " + nombre + "\nEdad: " + edad;
    }

    public double calcularSalarioNeto(){
        return sueldoBruto;
    }
    
}
