package com.cristian.desarrollo;

public class Gasto {
    private String descripcion;
    private Double valorGasto;
    private static Double cajaMenor = 500000.0;

    public Gasto(String descripcion, Double valorGasto){
        this.descripcion = descripcion;
        this.valorGasto = valorGasto;
        cajaMenor -= valorGasto;
    }

    public String mostrarInfo(){
        return "\n------------------\nGastos Empresa" +
        "\nDescripción:\t" + descripcion +
        "\nValor Gasto:\t" + valorGasto + 
        "\nCaja Menor: \t" + cajaMenor +  
        "\n------------------\n";
    } 

}
