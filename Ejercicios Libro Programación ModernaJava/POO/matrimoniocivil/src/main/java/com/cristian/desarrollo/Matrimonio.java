package com.cristian.desarrollo;

public class Matrimonio {
    private String fecha;
    private String lugar;

    // Relacion con la clase Contrayente
    Contrayente[] contrayentes;
    // Relacion con la clase Testigo
    Testigo[] testigos;
    private Integer contadorTestigos = 0;

    public Matrimonio(String fecha, String lugar) {
        this.fecha = fecha;
        this.lugar = lugar;
        this.contrayentes = new Contrayente[2];
        this.testigos = new Testigo[10];
    }

    //Getters
    public String getFecha(){
        return fecha;
    }

    public String getLugar(){
        return lugar;
    }

    public Contrayente getContrayente1(){
        return contrayentes[0];
    }

    public Contrayente getContrayente2(){
        return contrayentes[1];
    }

    public Contrayente[] getContrayentes() {
        return contrayentes;
    }

    public Testigo[] getTestigos() {
        return testigos;
    }

    //Setters
    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public void setLugar(String lugar){
        this.lugar = lugar;
    }

    public void agregarContrayentes(Contrayente persona1, Contrayente persona2){
        contrayentes[0] = persona1;
        contrayentes[1] = persona2;
    }

    public void agregarTestigo(Testigo testigo){
        testigos[contadorTestigos++] = testigo;
    }

    public String mostrarInfo() {
        return "\n\nMatrimonio"  +
               "\n\tFecha:\t" + getFecha() + 
               "\n\tLugar:\t" + getLugar() + 
               "\n\t\tContrayentes" + 
               "\n\t\t\t" + getContrayente1().getNombre() + " " + getContrayente1().getApellidos() + 
               "\n\t\t\t" + getContrayente2().getNombre() + " " + getContrayente2().getApellidos();
    }    
}
