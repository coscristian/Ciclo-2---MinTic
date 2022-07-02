package com.cristian.desarrollo;

public class Abuelo extends Persona{

    private Boolean pensionado;

    public Abuelo(String nombre, String id, String estatura, String edad, boolean tieneHijos, Boolean trabajo,
            Boolean tienesCanas, Boolean pensionado, String parentesco) {
        super(nombre, id, estatura, edad, tieneHijos, trabajo, tienesCanas, parentesco);
        this.pensionado = pensionado;
    }

    public String mostrarInfoAbuelo(){
        return super.mostrarInfoGeneral() + 
               "\nPensión\t" + pensionado +  
               "\n------------------\n";
    } 
}
