package com.cristian.desarrollo.modelo;

public class Peon extends Ficha{

    public boolean coronar(){
        // TODO: Falta implementar como corona el peon
        return false;
    }

    @Override
    public Boolean comer() {
        // TODO: Falta implementar como como el peon
        return super.comer();
    }

    public Boolean comerAlPaso(){
        return false;
    }

    @Override
    public Boolean mover(Casilla destino) {
        // TODO: Falta implementar como se mueve el peon
        return true;
    }
    
}
