package com.cristian.desarrollo.Ejercicio3;

public class Vehiculo {
    private String matricula;
    private String marca;
    private double tamanioDeposito;
    private String modelo;
    
    public Vehiculo(String matricula, String marca, Double tamanioDeposito, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.tamanioDeposito = tamanioDeposito;
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getTamanioDeposito() {
        return tamanioDeposito;
    }

    public void setTamaDeposito(Double tamanioDeposito) {
        this.tamanioDeposito = tamanioDeposito;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "El vehiculo tiene una matricula " + matricula + ", su marca es " + marca + ", el tamaño del deposito es de " +
            tamanioDeposito + " litros y su modelo es " + modelo;
    }
}
