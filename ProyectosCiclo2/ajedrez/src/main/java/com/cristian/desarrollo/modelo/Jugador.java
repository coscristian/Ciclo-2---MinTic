package com.cristian.desarrollo.modelo;

public class Jugador {
    public String nombre;
    public Color color;

    public Jugador(String nombre, Color color){
        /* Hace referencia al objeto que va a ser creado a partir de la clase
           Aqui uso this debido a que he colocado el mismo nombre del atributo que llega
           como parametro y el atributo global (Para diferenciar los atributos de la clase
           y los atributos de el metodo constructor) */
        this.nombre = nombre;
        this.color = color;
    }

}
