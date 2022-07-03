package com.cristian.desarrollo;

public class Impresora extends Dispositivo3{
    private String imprimeColor;
    private String pantalla;
    private String memoriaSD;

    public Impresora(double peso, String color, String maleta, String memRam, String procesador, String memAux,
            String tieneWifi, String marca, String imprimeColor, String pantalla, String memoriaSD) {
        super(peso, color, maleta, memRam, procesador, memAux, tieneWifi, marca);
        this.imprimeColor = imprimeColor;
        this.pantalla = pantalla;
        this.memoriaSD = memoriaSD;
    }

    public String mostrarMarca(){
        return "\nImpresora marca " + marca + "\n";
    }

    public String mostrarCaracteristicas(){
        return "\tImpr Col\t" + imprimeColor + 
               "\n\tPantalla\t" + pantalla + 
               "\n\tMem SD\t" + memoriaSD;
    }

}
