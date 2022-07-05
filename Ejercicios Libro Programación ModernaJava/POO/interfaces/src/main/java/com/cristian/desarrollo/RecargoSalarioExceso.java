package com.cristian.desarrollo;

public interface RecargoSalarioExceso extends RecargoSalario{
    public double porcRecargoExc = 2.0 / 100;
    public abstract double calcularValorRecargoSalarioExc(double salario, int cantHijos);
    public abstract double getValorRecargoExcUnitario(double salario);
}
