package com.cristian.desarrollo;

public class Estudiante implements DescServEspecial{
    private String nombre;
    private String codigo;
    private String edad;
    private Character estrato;
    
    private double valorMatricula;
    private double valorServEspeciales;
    private double valorDescuentoMatricula;
    private double valorDescuentoServEsp = 0;

    private double valorRealMatricula;
    private double valorRealServEspeciales = 0;
    private double valorRealaPagar;
    
    public Estudiante(String nombre, String codigo, String edad, Character estrato, double valorMatricula,
            double valorServEspeciales) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.edad = edad;
        this.estrato = estrato;
        this.valorMatricula = valorMatricula;
        this.valorServEspeciales = valorServEspeciales;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getEdad() {
        return edad;
    }

    public Character getEstrato() {
        return estrato;
    }

    public double getValorMatricula() {
        return valorMatricula;
    }

    public double getValorServEspeciales() {
        return valorServEspeciales;
    }

    public double getValorDescuentoMatricula() {
        return valorDescuentoMatricula;
    }

    public double getValorDescuentoServEsp() {
        return valorDescuentoServEsp;
    }

    public double getValorRealaPagar() {
        return valorRealaPagar;
    }

    public double getValorRealMatricula() {
        return valorRealMatricula;
    }

    public double getValorRealServEspeciales() {
        return valorRealServEspeciales;
    }

    public double getvalorRealaPagar() {
        return valorRealaPagar;
    }

    // Setters
    public void setValorRealMatricula(double valorRealMatricula) {
        this.valorRealMatricula = valorRealMatricula;
    }

    public void setValorRealServEspeciales(double valorRealServEspeciales) {
        this.valorRealServEspeciales = valorRealServEspeciales;
    }

    public void setvalorDescuentoMatricula(double valorDescuentoMatricula) {
        this.valorDescuentoMatricula = valorDescuentoMatricula;
    }

    public void setvalorDescuentoServEsp(double valorDescuentoServEsp) {
        this.valorDescuentoServEsp = valorDescuentoServEsp;
    }

    public void setvalorRealaPagar(double valorRealaPagar) {
        this.valorRealaPagar = valorRealaPagar;
    }

    // Descuentos
    public double calcularDescuentoMatricula(double porc, double valorMatricula){
        return (porc / 100) * valorMatricula;
    } 

    public double calcularDescuentoServEspeciales(double porc, double valorServEspeciales){
        return (porc / 100) * valorServEspeciales;
    }
}
