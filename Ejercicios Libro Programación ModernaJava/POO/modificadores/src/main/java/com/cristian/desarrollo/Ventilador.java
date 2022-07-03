package com.cristian.desarrollo;

public class Ventilador extends Electrodomestico{
    private String gira;
    private String temporizador;

    public Ventilador(String marca, String peso, String color, String innalambrico, String gira, String temporizador) {
        super(marca, peso, color, innalambrico);
        this.gira = gira;
        this.temporizador = temporizador;
    }

    public String mostrarMarca(){
        return "Ventilador marca " + marca;
    }

    public String descripcion(){
        return "Un ventilador es un Aparato para ventilar o refrigerar un lugar impulsando aire a una presión moderada, generalmente mediante un motor que hace girar unas aspas.";
    }
}
