package com.cristian.desarrollo.modelo;
//Tarea: Convertir todos los atributos a privados
//Tarea2: Ponerle a todas las clases con su respectivo constructor
public class Tablero {

    public Jugador jugador1;
    public Jugador jugador2;

    public Casilla[][] casillas;

    public Tablero(Jugador j1, Jugador j2){
        jugador1 = j1;
        jugador2 = j2;

        // Cargar las casillas con su color
        inicializarCasillas();

        // Ubicar fichas en su posicion inicial
    }

    private void inicializarCasillas(){
        casillas = new Casilla[8][8];
        for (var fila = 0; fila < 8; fila++) {
            for (var columna = 0; columna < 8; columna++) {
                var color = (fila + columna) % 2 == 0 ? Color.NEGRO : Color.BLANCO;
                casillas[fila][columna] = new Casilla(fila, letraDeColumna(columna), color);
            }
        }
    }

    private Character letraDeColumna(Integer columna){
        return "abcdefgh".charAt(columna);
    }

    public void enroque(){
        // TODO: Falta implementar este metodo
    }

    public void jaque(){
        // TODO: Falta implementar este metodo
    }

    public void jaqueMate(){
        // TODO: Falta implementar este metodo
    }
    
}
