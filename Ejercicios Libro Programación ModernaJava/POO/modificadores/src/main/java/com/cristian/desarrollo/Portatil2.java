package com.cristian.desarrollo;
public class Portatil2 extends Dispositivo2{
    private String tactil;
    private String bateriaPortatil;

    public Portatil2(String marca, String peso, String color, String maleta, int memRam, String procesador, int memAux,
            String tactil, String bateriaPortatil) {
        super(marca, peso, color, maleta, memRam, procesador, memAux);
        this.tactil = tactil;
        this.bateriaPortatil = bateriaPortatil;
    }

    public String mostrarMarca(){
        return "Portatil marca: " + marca;
    }

    public String descripcion(){
        return "Un portail es un computador que permite ser movido de manera sencilla en diferentes lugares.";
    }
}
