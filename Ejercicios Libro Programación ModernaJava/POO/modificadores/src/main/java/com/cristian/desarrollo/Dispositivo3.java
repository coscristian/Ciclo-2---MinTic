package com.cristian.desarrollo;

public abstract class Dispositivo3 {
    private double peso;
    private String color;
    private String maleta;
    private String memRam;
    private String procesador;
    private String memAux;
    private String tieneWifi;
    protected String marca;

    public Dispositivo3(double peso, String color, String maleta, String memRam, String procesador, String memAux,
            String tieneWifi, String marca) {
        this.peso = peso;
        this.color = color;
        this.maleta = maleta;
        this.memRam = memRam;
        this.procesador = procesador;
        this.memAux = memAux;
        this.tieneWifi = tieneWifi;
        this.marca = marca;
    }

    public String mostrarMarca(){
        return "Dispositivo marca: " + marca;
    }

    public abstract String mostrarCaracteristicas();
}
