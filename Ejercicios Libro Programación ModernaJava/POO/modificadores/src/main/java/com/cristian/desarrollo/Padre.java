package com.cristian.desarrollo;

public class Padre extends Persona{

    public Padre(String nombre, String id, String estatura, String edad, boolean tieneHijos, Boolean trabajo,
            Boolean tienesCanas, String parentesco) {
        super(nombre, id, estatura, edad, tieneHijos, trabajo, tienesCanas, parentesco);
    } 

    public String mostrarInfoPadre(){
        return super.mostrarInfoGeneral() + 
               "\n------------------\n";
    } 
}
