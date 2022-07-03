package com.cristian.desarrollo;

public class Portatil extends Dispositivo{
    private String modular;
    private String tactil;
    private String tipo = "Portatil";

    public Portatil(String marca, double peso, String color, String maleta, int memRam, String procesador, int memAux,
            String modular, String tactil) {
        super(marca, peso, color, maleta, memRam, procesador, memAux);
        this.modular = modular;
        this.tactil = tactil;
    }

    public String muestraMarca(){
        return "\nDispositivo Marca " + marca;
    }
    
}
