package com.cristian.desarrollo;

public interface Interfaz2 {
    public final double porcentajeAdicional = 5.0 / 100;
    public abstract double calcularAdicionalHijos(double salario, int cantHijos);
    public abstract double calcularAumento(double salario, double aumento);
}
