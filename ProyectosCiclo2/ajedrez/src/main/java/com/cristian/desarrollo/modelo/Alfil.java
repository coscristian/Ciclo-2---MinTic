package com.cristian.desarrollo.modelo;

public class Alfil extends Ficha{

    

    // public Alfil(Color color, Integer origenFila, Character origenColumna){
    //     // this.color = color;
    //     // this.origen.fila = origenFila;
    //     // this.origen.columna = origenColumna;
    //     setColor(color);
    //     setOrigenFila(origenFila);
    //     setOrigenColumna(origenColumna);
    // }

    public Alfil(Color color) {
        // Cuando lleguen estos parametros llame al constructor del padre con esos parametros
        // Al hacer esto, se inicializan los valores en el constructor padre
        super(color);
        
    }

    @Override
    public Boolean mover(Casilla destino) {
        // TODO: Falta implementar como se mueve el alfil
        return false;
    }

    @Override
    public String toString() {
        return "A" + (getColor() == Color.BLANCO ? "B" : "N");
    }
    
}
