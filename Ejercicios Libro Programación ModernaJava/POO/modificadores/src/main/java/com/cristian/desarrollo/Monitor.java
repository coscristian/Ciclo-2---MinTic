package com.cristian.desarrollo;

public class Monitor extends Dispositivo3{
    private String relAspecto;
    private String tasaRef;
    private String velResp;

    public Monitor(double peso, String color, String maleta, String memRam, String procesador, String memAux,
            String tieneWifi, String marca, String relAspecto, String tasaRef, String velResp) {
        super(peso, color, maleta, memRam, procesador, memAux, tieneWifi, marca);
        this.relAspecto = relAspecto;
        this.tasaRef = tasaRef;
        this.velResp = velResp;
    }

    public String mostrarMarca(){
        return "\nMonitor marca " + marca + "\n";
    }

    public String mostrarCaracteristicas(){
        return "\tRel Asp\t" + relAspecto + 
               "\n\tTasa Ref\t" + tasaRef + 
               "\n\tVel Resp\t" + velResp;
    }
}
