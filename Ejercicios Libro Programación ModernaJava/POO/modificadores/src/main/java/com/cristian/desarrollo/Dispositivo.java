package com.cristian.desarrollo;

public class Dispositivo {
    public String marca;
    private double peso;
    private String color;
    private String maleta;
    private int memRam;
    private String procesador;
    private int memAux;

    public Dispositivo(String marca, double peso, String color, String maleta, int memRam, String procesador,
            int memAux) {
        this.marca = marca;
        this.peso = peso;
        this.color = color;
        this.maleta = maleta;
        this.memRam = memRam;
        this.procesador = procesador;
        this.memAux = memAux;
    }

    public String muestraMarca(){
        return "\nDispositivo Marca " + marca;
    }

}
