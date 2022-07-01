package com.cristian.desarrollo.modelo;
//Herencia
public class Rey extends Ficha{
    //Como en la clase padre Ficha, el objeto no se sabe mover, debo socreescribir el metodo
    //para darle un comportamiento a un metodo que viene de la clase padre
    
    public Rey(Color color) {
        super(color);
    }

    // public Rey(Color color, Integer origenFila, Character origenColumna){
    //     // this.color = color;
    //     // this.origen.fila = origenFila;
    //     // this.origen.columna = origenColumna;
    //     setColor(color);
    //     setOrigenFila(origenFila);
    //     setOrigenColumna(origenColumna);
    // }

    @Override
    public Boolean mover(Casilla destino) {
        // TODO: Falta implementar como se mueve el rey
        return false;
    }

    @Override
    public String toString() {
        return "R" + (getColor() == Color.BLANCO ? "B" : "N");
    }





}
