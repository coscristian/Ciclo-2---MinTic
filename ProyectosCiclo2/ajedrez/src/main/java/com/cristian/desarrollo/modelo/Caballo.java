package com.cristian.desarrollo.modelo;

public class Caballo extends Ficha{

    public Caballo(Color color) {
        super(color);
    }

    // public Caballo(Color color, Integer origenFila, Character origenColumna){
    //     // this.color = color;
    //     // this.origen.fila = origenFila;
    //     // this.origen.columna = origenColumna;
    //     setColor(color);
    //     setOrigenFila(origenFila);
    //     setOrigenColumna(origenColumna);
    // }

    @Override
    public Boolean mover(Casilla destino) {
        // TODO: Falta implementar como se mueve el caballo
        return true;
    }

    @Override
    public String toString() {
        return "C" + (getColor() == Color.BLANCO ? "B" : "N");
    }


    
}
