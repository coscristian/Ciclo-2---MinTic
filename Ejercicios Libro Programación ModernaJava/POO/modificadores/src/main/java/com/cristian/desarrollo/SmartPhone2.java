package com.cristian.desarrollo;

public class SmartPhone2 extends Dispositivo3{
    private String inteligente;
    private String protector;
    private String huella;

    public SmartPhone2(double peso, String color, String maleta, String memRam, String procesador, String memAux,
            String tieneWifi, String marca, String inteligente, String protector, String huella) {
        super(peso, color, maleta, memRam, procesador, memAux, tieneWifi, marca);
        this.inteligente = inteligente;
        this.protector = protector;
        this.huella = huella;
    }

    public String mostrarMarca(){
        return "\nSmartPhone marca " + marca + "\n";
    }

    public String mostrarCaracteristicas(){
        return "\tInteligente\t" + inteligente + 
               "\n\tProctector\t" + protector + 
               "\n\tHuella\t" + huella;
    }
}
