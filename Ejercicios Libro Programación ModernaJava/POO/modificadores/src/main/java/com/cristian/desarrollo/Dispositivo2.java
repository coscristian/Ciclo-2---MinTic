package com.cristian.desarrollo;

public class Dispositivo2 extends Aparato{    
    private double peso;
    private String color;
    private String maleta;
    private int memRam;
    private String procesador;
    private int memAux;

    public Dispositivo2(String marca, String peso, String color, String maleta, int memRam, String procesador, int memAux) {
        super(marca, peso, color);
        this.maleta = maleta;
        this.memRam = memRam;
        this.procesador = procesador;
        this.memAux = memAux;
    }

    public String mostrarMarca(){
        return "Dispositivo marca: " + marca;
    } 

    public String descripcion(){
        return "Un dispositivo es una Pieza o conjunto de piezas o elementos preparados para realizar una función determinada y que generalmente forman parte de un conjunto más complejo.";
    }

}
