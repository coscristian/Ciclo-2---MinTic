package com.cristian.desarrollo.modelo;

public abstract class Ficha {
    // Una clase es abstracta cuando yo se que un objeto tiene un comportamiento especifico pero no se
    // cual va a ser ese comportamiento.
    public Color color;
    public Casilla origen;

    public Boolean comer(){
        // TODO: Falta implementar este metodo
        return true;
    }

    public abstract Boolean mover(Casilla destino); // La clase ficha se puede mover pero no se como se puede mover
    //Ya que hay peones, torres, caballos...etc

}
