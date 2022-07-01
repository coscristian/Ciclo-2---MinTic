package com.cristian.desarrollo.modelo;
//Herencia
public class Rey extends Ficha{
    //Como en la clase padre Ficha, el objeto no se sabe mover, debo socreescribir el metodo
    //para darle un comportamiento a un metodo que viene de la clase padre

    @Override
    public Boolean mover(Casilla destino) {
        // TODO: Falta implementar como se mueve el rey
        return false;
    }




}
