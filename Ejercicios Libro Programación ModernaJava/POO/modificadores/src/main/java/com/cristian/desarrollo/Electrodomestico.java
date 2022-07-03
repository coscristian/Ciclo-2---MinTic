package com.cristian.desarrollo;

public class Electrodomestico extends Aparato{
    public String innalambrico;

    public Electrodomestico(String marca, String peso, String color, String innalambrico) {
        super(marca, peso, color);
        this.innalambrico = innalambrico;
    }

    public String mostrarMarca(){
        return "Ventilador marca: " + marca;
    }

    public String descripcion(){
        return "Un electromestico es algo que funciona con energía eléctrica y está destinado al uso doméstico.";
    }
}
