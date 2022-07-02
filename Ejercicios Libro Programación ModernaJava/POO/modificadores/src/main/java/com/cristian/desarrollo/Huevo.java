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
        return "\nCant comprar: \t" + huevosAcomprar +
                "\nCant adquirida: \t" + huevosAdquiridos + 
                "\nCant disponible:\t" + huevosDisponibles + 
                "\n----------------------";
    }
}
