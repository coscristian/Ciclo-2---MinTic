package com.cristian.desarrollo;

public class Taladro extends Herramienta{
    private String cable;
    private String innalambrico;
    private String broca;

    public Taladro(String color, String longitud, String marca, String acolchado, String cable, String innalambrico,
            String broca) {
        super(color, longitud, marca, acolchado);
        this.cable = cable;
        this.innalambrico = innalambrico;
        this.broca = broca;
    }

    public String muestraMarca(){
        return "Dispositivo Marca " + marca;
    }
}
