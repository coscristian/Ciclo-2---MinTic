package com.cristian.desarrollo.modelo;

public class Reina extends Ficha{
    // Si el constructor de el padre tiene 2 parametros, el coonstructor de la clase hija debe tener
    // Por lo menos 2 parametros

    public Reina(Color color) {
        super(color);
    }  

    // public Reina(Color color, Integer origenFila, Character origenColumna){
    //     // this.color = color;
    //     // this.origen.fila = origenFila;
    //     // this.origen.columna = origenColumna;
    //     setColor(color);
    //     setOrigenFila(origenFila);
    //     setOrigenColumna(origenColumna);
    // }

    @Override
    public Boolean mover(Casilla destino) {
        // TODO: Falta implementar como se mueve la reina
        return false;
    }

    @Override
    public String toString() {
        return "r" + (getColor() == Color.BLANCO ? "B" : "N");
    }


    
}
