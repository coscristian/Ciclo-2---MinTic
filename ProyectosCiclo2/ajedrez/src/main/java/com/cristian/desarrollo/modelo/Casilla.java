package com.cristian.desarrollo.modelo;

public class Casilla {
    public Integer fila;
    public Character columna;
    public Color color;
    
    public Ficha ficha;

    public Casilla(Integer fila, Character columna, Color color){
        this.fila = fila;
        this.columna = columna;
        this.color = color;
    }

    public Boolean estaOcupada(){
        if (ficha != null){
            return true;
        }
        return false;
    }

}
