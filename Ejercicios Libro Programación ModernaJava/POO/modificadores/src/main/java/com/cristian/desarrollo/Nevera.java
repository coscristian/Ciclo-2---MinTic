package com.cristian.desarrollo;

public class Nevera extends Electrodomestico{
    private String congeladoRapido;

    public Nevera(String marca, String peso, String color, String innalambrico, String congeladoRapido) {
        super(marca, peso, color, innalambrico);
        this.congeladoRapido = congeladoRapido;
    }

    public String mostrarMarca(){
        return "Nevera marca: " + marca;
    }

    public String descripcion(){
        return "Una nevera es Electrodoméstico para conservar o enfriar alimentos y bebidas";
    }
    
}
