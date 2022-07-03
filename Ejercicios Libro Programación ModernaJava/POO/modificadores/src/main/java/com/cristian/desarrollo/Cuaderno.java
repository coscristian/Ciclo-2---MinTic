package com.cristian.desarrollo;

public class Cuaderno extends Documento{
    private String marca;
    private String stickers;

    public Cuaderno(String color, String tipoLetra, String tamanio, String marca, String stickers) {
        super("N/A", color, tipoLetra, tamanio);
        this.marca = marca;
        this.stickers = stickers;
    }

    public String mostrarTamanio(){
        return "Cuaderno Tamaño:\t" + tamanio;
    }
    
}
