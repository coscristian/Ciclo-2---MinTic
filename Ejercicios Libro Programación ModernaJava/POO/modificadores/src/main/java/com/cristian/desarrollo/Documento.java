package com.cristian.desarrollo;

public class Documento {
    private String titulo;
    private String color;
    private String tipoLetra;
    public String tamanio;

    public Documento(String titulo, String color, String tipoLetra, String tamanio) {
        this.titulo = titulo;
        this.color = color;
        this.tipoLetra = tipoLetra;
        this.tamanio = tamanio;
    }

    public String mostrarTamanio(){
        return "Documento Tamaño:\t" + tamanio;
    }
    
}
