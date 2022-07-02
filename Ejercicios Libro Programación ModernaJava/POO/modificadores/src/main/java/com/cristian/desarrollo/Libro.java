package com.cristian.desarrollo;

public class Libro {
    private String titulo;
    private String autor;
    private String anio;
    private static Integer cantLibrosIngresados = 0;

    public Libro(String titulo, String autor, String anio){
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        cantLibrosIngresados++;
    }

    public String mostrarInfo(){
        return "\n------------------\nLibrería" +
        "\nLibro N°:\t" + cantLibrosIngresados +
        "\nTitulo:\t" + titulo + 
        "\nAutor: \t" + autor + 
        "\nAño: \t" + anio + 
        "\nCapacidad actual:\t" + (100 - cantLibrosIngresados) +
        "\nCapacidad total:\t" + 100 + 
        "\n------------------\n";
    } 


}
