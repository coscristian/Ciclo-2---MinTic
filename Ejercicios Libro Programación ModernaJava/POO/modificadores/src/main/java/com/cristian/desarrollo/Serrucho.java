package com.cristian.desarrollo;

public class Serrucho extends Herramienta{
    private String empunadura;
    private String hoja;

    public Serrucho(String color, String longitud, String marca, String acolchado, String empunadura, String hoja) {
        super(color, longitud, marca, acolchado);
        this.empunadura = empunadura;
        this.hoja = hoja;
    }

    public String muestraMarca(){
        return "Dispositivo Marca " + marca;
    }

}
