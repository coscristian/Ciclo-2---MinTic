package com.cristian.desarrollo.frecuenciaCardiaca;

public class FrecuenciasCardiacas {
    private String nombre;
    private String apellido;
    private Integer mes;
    private Integer dia;
    private Integer anio;
    
    public FrecuenciasCardiacas(String nombre, String apellido, Integer mes, Integer dia, Integer anio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mes = mes;
        this.dia = dia;
        this.anio = anio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer calcularEdad(){
        return 2022 - anio;
    }

    public Integer frecuenciaCarMaxima(){
        return 220 - calcularEdad();
    }

    public Double frecuenciaCarEsperadaMin(){
        return frecuenciaCarMaxima() * 0.5;
    }

    public Double frecuenciaCarEsperadaMax(){
        return frecuenciaCarMaxima() * 0.85;
    }

    @Override
    public String toString(){
        return String.format(
                "%nNombre:\t %s %n" + 
                "Apellido:\t %s %n" + 
                "Fecha Nac:\t %d \\ %d \\ %d %n" + 
                "Edad:\t %d %n" + 
                "Frec Max:\t %d %n" + 
                "Frec Esp:\tEntre %.2f y %.2f %n",
                nombre,
                apellido,
                dia, mes, anio,
                calcularEdad(),
                frecuenciaCarMaxima(),
                frecuenciaCarEsperadaMin(), frecuenciaCarEsperadaMax());
    }

}
