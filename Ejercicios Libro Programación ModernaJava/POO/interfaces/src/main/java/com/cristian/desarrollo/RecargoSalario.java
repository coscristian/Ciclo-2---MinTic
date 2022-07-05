package com.cristian.desarrollo;

public interface RecargoSalario{
    public final double porcRecargo = 3.0 / 100;
    public abstract double calcularValorRecargoSalario(double salario, int cantHijos);
    public abstract double getValorRecargoUnitario(double salario);
}
