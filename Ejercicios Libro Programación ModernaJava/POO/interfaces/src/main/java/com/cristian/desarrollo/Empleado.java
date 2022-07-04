package com.cristian.desarrollo;

public class Empleado implements Interfaz2{
    private String nombre;
    private String id;
    private String edad;
    private String cargo;
    private double salarioNeto;
    private double salarioTotal;
    private double salarioAdicional;
    private int cantHijos;

    public Empleado(String nombre, String id, String edad, String cargo, int cantHijos) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.cargo = cargo;
        this.cantHijos = cantHijos;
    }

    @Override
    public double calcularAdicionalHijos(double salario, int cantHijos) {
        return (salario * porcentajeAdicional) * cantHijos;
    }
    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getEdad() {
        return edad;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalarioNeto() {
        return salarioNeto;
    }

    public double getSalarioAdicional(){
        return salarioAdicional;
    }

    public double getSalarioTotal() {
        return salarioTotal;
    }

    public int getCantHijos() {
        return cantHijos;
    }

    // Setters
    public void setSalarioNeto(double salarioNeto) {
        this.salarioNeto = salarioNeto;
    }

    public void setSalarioTotal(double salarioTotal) {
        this.salarioTotal = salarioTotal;
    }

    public void setSalarioAdicional(double salarioAdicional) {
        this.salarioAdicional = salarioAdicional;
    }
}
