package com.cristian.desarrollo;

public class SmartPhone extends Dispositivo {
    private String inteligente;
    private String protector;
    private String tipo = "SmartPhone";

    public SmartPhone(String marca, double peso, String color, String maleta, int memRam, String procesador, int memAux,
            String inteligente, String protector) {
        super(marca, peso, color, maleta, memRam, procesador, memAux);
        this.inteligente = inteligente;
        this.protector = protector;
    }

    public String muestraMarca(){
        return "\nDispositivo Marca " + marca;
    }
    

}
