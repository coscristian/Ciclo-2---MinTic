package com.cristian.desarrollo.modelo;

public abstract class Ficha {
    //Proctected va a ser publica solo para los que hereden de ficha
    private Color color;
    private Casilla origen;

    public Ficha(Color color){
        // Va a buscar un constructor que tenga dos parametros con el mismo tipo
        // En caso de que desea inicializar una ficha solo con su color sin su origen
        this(color, null);
    }

    public Ficha(Color color, Casilla origen) {
        this.color = color;
        this.origen = origen;
    }

    public Boolean comer(){
        // TODO: Falta implementar este metodo
        return true;
    }

    public abstract Boolean mover(Casilla destino); // La clase ficha se puede mover pero aún no se como se puede mover
    //Ya que hay peones, torres, caballos...etc

    public Color getColor() {
        return color;
    }

    public Casilla getOrigen() {
        return origen;
    }

    
}
