package com.cristian.desarrollo.registrosMedicos;

public class PerfilMedico {
    private String nombre;
    private String apellido;
    private Character sexo;
    private Integer dia;
    private Integer mes;
    private Integer anio;
    private Double altura;
    private Double peso;

    public PerfilMedico(String nombre, String apellido, Character sexo, Integer dia, Integer mes, Integer anio,
            Double altura, Double peso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.altura = altura;
        this.peso = peso;
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

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
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
    
    public Double calcularIMC(){
        var alturaMetros = altura / 100;
        return peso / Math.pow(alturaMetros, 2);
    }

    @Override
    public String toString(){
        String infoTabla = String.format(
                   "VALORES DE BMI %n" + 
                   "Bajo peso: menos de 18.5 %n" + 
                   "Normal: entre 18.5 y 24.9 %n" + 
                   "Sobrepeso: entre 25 y 29.9 %n" + 
                   "Obeso: 30 o más %n");
                    
        return String.format(
            "%nNombre:\t %s %n" + 
            "Apellido:\t %s %n" + 
            "Sexo:\t %s %n" + 
            "Fecha Nac:\t %d \\ %d \\ %d %n" + 
            "Altura:\t %.2f cm %n" + 
            "Peso:\t %.2f kg %n" + 
            "Edad:\t %d años %n" + 
            "IMC:\t %.2f %n" + 
            "Frec Max:\t %d %n" + 
            "Frec Esp:\tEntre %.2f y %.2f %n" + 
            "%n%s %n",
            nombre,
            apellido,
            sexo,
            dia, mes, anio,
            altura,
            peso,
            calcularEdad(),
            calcularIMC(),
            frecuenciaCarMaxima(),
            frecuenciaCarEsperadaMin(), frecuenciaCarEsperadaMax(),
            infoTabla );
    }
    
}
