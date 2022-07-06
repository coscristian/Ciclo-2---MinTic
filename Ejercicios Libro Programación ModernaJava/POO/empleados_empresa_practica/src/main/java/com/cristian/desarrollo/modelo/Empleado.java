package com.cristian.desarrollo.modelo;

public class Empleado extends Persona{

    private static final Double SUELDO_POR_DEFECTO = 1_000_000d;
    protected Double sueldoBruto;

    public Empleado(String nombre, Integer edad) {
        this(nombre, edad, SUELDO_POR_DEFECTO);
    }

    public Empleado(String nombre, Integer edad, Double sueldoBruto){
        super(nombre, edad);
        this.sueldoBruto = sueldoBruto;
    }

    public Double getSueldoBruto(){
        return sueldoBruto;
    }

    public void setSueldoBruto(Double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public Double calcularSalarioNeto(){
        // Descuento Salud 4%
        // Descuento Pensión 4%
        Double porcSalud = 4.0, porcPension = 4.0;
        return sueldoBruto - (sueldoBruto * (porcSalud/100) + (porcPension/100));
    }

    @Override
    public String mostrarInfo(){
        return String.format("El empleado %s tiene edad %d, su sueldo bruto es de %,.2f y su salario neto será de %,.2f", getNombre(), getEdad(), getSueldoBruto(), calcularSalarioNeto());
    }

}
