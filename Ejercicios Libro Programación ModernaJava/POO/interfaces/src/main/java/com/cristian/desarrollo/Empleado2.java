package com.cristian.desarrollo;

public class Empleado2 implements RecargoSalarioExceso{
    private String nombre;
    private String id;
    private String edad;
    private String cargo;
    private int cantHijos;

    private double salarioNeto;
    private double valorTotalRecargo = 0;
    private double salarioTotalConRecargo;

    public Empleado2(String nombre, String id, String edad, String cargo, int cantHijos, double salarioNeto) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.cargo = cargo;
        this.cantHijos = cantHijos;
        this.salarioNeto = salarioNeto;
    }

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

    public int getCantHijos() {
        return cantHijos;
    }

    public double getSalarioNeto() {
        return salarioNeto;
    }

    public double getValorTotalRecargo() {
        return valorTotalRecargo;
    }

    public double getSalarioTotalConRecargo() {
        return salarioTotalConRecargo;
    }

    public void setValorTotalRecargo(double valorTotalRecargo) {
        this.valorTotalRecargo = valorTotalRecargo;
    }

    public void setSalarioTotalConRecargo(double salarioTotalConRecargo) {
        this.salarioTotalConRecargo = salarioTotalConRecargo;
    }

    public double calcularValorRecargoSalario(double salario, int cantHijos){
        return salario * porcRecargo * cantHijos;
    }

    public double calcularValorRecargoSalarioExc(double salario, int cantHijos){
        return salario * porcRecargoExc * cantHijos;
    }

    public double getValorRecargoUnitario(double salario){
        return salario * porcRecargo;
    }

    public double getValorRecargoExcUnitario(double salario){
        return salario * porcRecargoExc;
    }
}
