package com.cristian.desarrollo.modelo;

public class Peon extends Ficha{

    // public Peon(Color color, Integer origenFila, Character origenColumna) {
    //     // this.color = color;
    //     // this.origen.fila = origenFila;
    //     // this.origen.columna = origenColumna;
    //     setColor(color);
    //     setOrigenFila(origenFila);
    //     setOrigenColumna(origenColumna);
    // }

    public Peon(Color color) {
        super(color); //Llama al constructor de la superclase
    }

    public boolean coronar(){
        // TODO: Falta implementar como corona el peon
        return false;
    }

    @Override
    public Boolean comer() {
        // TODO: Falta implementar como como el peon
        return super.comer();  //Llama al metodo comer del padre
    }

    public Boolean comerAlPaso(){
        return false;
    }

    @Override
    public Boolean mover(Casilla destino) {
        // TODO: Falta implementar como se mueve el peon
        return true;
    }

    @Override
    public String toString() {
        return "P" + (getColor() == Color.BLANCO ? "B" : "N");
    }
    
}
