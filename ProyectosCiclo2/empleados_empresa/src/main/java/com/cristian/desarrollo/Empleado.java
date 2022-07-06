package com.cristian.desarrollo;

public class Empleado extends Persona{

    protected static final Double SUELDO_POR_DEFECTO = 1_000_000d;

    private Double sueldoBruto;

    // Constructor principal
    public Empleado(String nombre, Integer edad, Double sueldoBruto) {
        super(nombre, edad);
        this.sueldoBruto = sueldoBruto;
    }

    // Constructor auxiliar
    public Empleado(String nombre, Integer edad){
        this(nombre, edad, SUELDO_POR_DEFECTO);
    }

    public Double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(Double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public Double calcularValorNeto(){
        Double porcentajeSalud = 4d; 
        Double porcentajePension = 4d;

        return getSueldoBruto() * (100 - porcentajeSalud - porcentajePension) / 100;

    }

    @Override
    public void mostrarInfo() {
        System.out.printf("El empleado de nombre %s tiene edad %d y tiene un sueldo de %,.2f %n",
        super.getNombre(), super.getEdad(), getSueldoBruto());
    }
}
