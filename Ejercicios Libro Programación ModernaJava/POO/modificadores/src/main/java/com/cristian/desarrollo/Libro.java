package com.cristian.desarrollo;

public class Libro {
    private String titulo;
    private String autor;
    private String anio;
    private String editorial;
    private static Integer cantLibrosIngresados = 0;

    public Libro(String titulo, String autor, String anio, String editorial){
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.editorial = editorial;
        cantLibrosIngresados++;
    }

    public Libro(String titulo){
        this(titulo, "Pendiente", "1000", "Pendiente");
    }

    public static String mostrarTitulo(){
        return "\n----------" + 
               "\nLibreria Panamericana\n" +
               "Capacidad Total\t" + 100 + " libros\n" +
               "----------";

    }

    public String mostrarInfo(){
        return "\n------------------" +
        "\nLibro N°\t" + cantLibrosIngresados +
        "\nTitulo\t" + titulo + 
        "\nAutor\t" + autor + 
        "\nAño\t" + anio + 
        "\n------------------\n";
    } 

    public static String mostrarCapacidadAct(){
        return String.format(
            "\n\n**************************" +
            "\nCapacidad Actual" +  
            "\n**************************\n\t" + 
            "%,d\n", (100 - cantLibrosIngresados)
            );
    }
}
