package com.cristian.desarrollo;

public class Herramienta {
    private String color;
    private String longitud;
    public String marca;
    private String acolchado;

    public Herramienta(String color, String longitud, String marca, String acolchado) {
        this.color = color;
        this.longitud = longitud;
        this.marca = marca;
        this.acolchado = acolchado;
    }

    public String muestraMarca(){
        return "Dispositivo Marca " + marca;
    }

}
