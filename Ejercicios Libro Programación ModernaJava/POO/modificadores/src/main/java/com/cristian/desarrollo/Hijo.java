package com.cristian.desarrollo;

public class Hijo extends Persona{
    private Boolean estudiante;
    private Boolean haceDeporte;

    public Hijo(String nombre, String id, String estatura, String edad, boolean tieneHijos, Boolean trabajo,
            Boolean tienesCanas, Boolean estudiante, Boolean haceDeporte, String parentesco) {
        super(nombre, id, estatura, edad, tieneHijos, trabajo, tienesCanas, parentesco);
        this.estudiante = estudiante;
        this.haceDeporte = haceDeporte;
    }

    public String mostrarInfoHijo(){
        return super.mostrarInfoGeneral() + 
               "\nEstudio\t" + estudiante +
               "\nDepor\t" + haceDeporte +  
               "\n------------------\n";
    } 
}
