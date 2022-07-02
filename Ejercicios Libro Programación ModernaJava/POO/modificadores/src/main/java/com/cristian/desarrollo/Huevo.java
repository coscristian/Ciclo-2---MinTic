package com.cristian.desarrollo;

public class Huevo {
    private Integer huevosAcomprar;
    private static Integer huevosDisponibles = 5;
    private Integer huevosAdquiridos;

    public Huevo(Integer huevosAcomprar, Integer huevosAdquiridos){
        this.huevosAcomprar = huevosAcomprar;
        this.huevosAdquiridos = huevosAdquiridos;
        huevosDisponibles = huevosDisponibles - huevosAcomprar + huevosAdquiridos;
    }

    public String mostrarInfo(){
        return "\n\nCant comprar\t" + huevosAcomprar +
                "\nCant adquirida\t" + huevosAdquiridos + 
                "\n----------------------";
    }

    public static String mostrarCantDisponible(){
        return "\n\n**************************" +
               "\nCantidad Huevos Disponibles" +  
               "\n**************************\n\t" + 
               huevosDisponibles;
    }
}
