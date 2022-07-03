package com.cristian.desarrollo;

public class LibretaNota extends Documento{
    private String anuncios;
    private String calendario;

    public LibretaNota(String color, String tipoLetra, String tamanio, String anuncios,
            String calendario) {
        super("N/A", color, tipoLetra, tamanio);
        this.anuncios = anuncios;
        this.calendario = calendario;
    }

    public String mostrarTamanio(){
        return "LIbreta Tamaño:\t" + tamanio;
    }
}
