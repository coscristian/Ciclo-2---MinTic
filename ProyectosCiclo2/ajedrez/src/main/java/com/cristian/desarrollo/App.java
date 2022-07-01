package com.cristian.desarrollo;

import com.cristian.desarrollo.modelo.Casilla;
import com.cristian.desarrollo.modelo.Color;
import com.cristian.desarrollo.modelo.Jugador;
import com.cristian.desarrollo.modelo.Tablero;

public class App 
{
    public static void main( String[] args ){
        //Creacion de jugadores
        var jugador1 = new Jugador("Cristian Quesada", Color.BLANCO);
        var jugador2 = new Jugador("Juan Jose Quesada", Color.NEGRO);

        //Creacion del tablero
        var tablero = new Tablero(jugador1, jugador2);

        tablero.casillas = new Casilla[8][8];
        var casilla = new Casilla();
        casilla.color = Color.NEGRO;
        tablero.casillas[0][0] = casilla;

        casilla = new Casilla();
        casilla.color = Color.BLANCO;
        tablero.casillas[0][1] = casilla;
    }
}
