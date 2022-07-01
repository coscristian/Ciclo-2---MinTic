package com.cristian.desarrollo;

import com.cristian.desarrollo.modelo.Casilla;
import com.cristian.desarrollo.modelo.Color;
import com.cristian.desarrollo.modelo.Jugador;
import com.cristian.desarrollo.modelo.Tablero;

public class App 
{
    public static void main( String[] args ){
        //Creacion del tablero
        var tablero = new Tablero("Cristian Quesada", "Juan Jose Quesada");
        tablero.imprimirTablero();
    }
}
