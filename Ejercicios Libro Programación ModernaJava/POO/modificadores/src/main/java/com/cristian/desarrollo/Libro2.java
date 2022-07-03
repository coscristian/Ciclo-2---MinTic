package com.cristian.desarrollo;

public class Libro2 extends Documento{
    private String autor;
    private String anio;
    private String editorial;
    private String tipo = "Libro";

    public Libro2(String titulo, String color, String tipoLetra, String tamanio, String autor, String anio,
            String editorial) {
        super(titulo, color, tipoLetra, tamanio);
        this.autor = autor;
        this.anio = anio;
        this.editorial = editorial;
    }

    public String mostrarTamanio(){
        return "Libro Tamaño:\t" + tamanio;
    }

}
