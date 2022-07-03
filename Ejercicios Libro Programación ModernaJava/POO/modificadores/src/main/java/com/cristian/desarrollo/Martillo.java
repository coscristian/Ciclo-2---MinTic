package com.cristian.desarrollo;

public class Martillo extends Herramienta{
    private String material;
    private String tipo = "Martillo";

    public Martillo(String color, String longitud, String marca, String acolchado, String material) {
        super(color, longitud, marca, acolchado);
        this.material = material;
    }

    public String muestraMarca(){
        return "Dispositivo Marca " + marca;
    }
}
