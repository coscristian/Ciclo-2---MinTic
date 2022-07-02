package com.cristian.desarrollo;

public class Figura {
    private Integer ladoCuad;
    private Integer baseTrian;
    private Integer alturaTrian;
    private Integer ladoPent;
    private Integer apotema;
    private Integer cantLados;
    private Double areaCuad;
    private Integer areaTriang;
    private Integer areaPent;

    public Figura(Integer ladoCuad, Integer baseTrian, Integer alturaTrian, Integer ladoPent, Integer apotema, Integer cantLados) {
        // Cuadrado
        this.ladoCuad = ladoCuad;
        
        // Triangulo
        this.baseTrian = baseTrian;
        this.alturaTrian = alturaTrian;
        
        //Pentagono
        this.ladoPent = ladoPent;
        this.apotema = apotema;
        this.cantLados = cantLados;

        //Area de las figuras
        this.areaCuad = Math.pow(ladoCuad, 2);
        this.areaTriang =  (this.baseTrian * this.alturaTrian) / 2;
        this.areaPent =  (this.ladoPent * this.cantLados * this.apotema) / 2;
    }

    //  Constructor para cuadrado
    public Figura(Integer ladoCuad){
        this(ladoCuad, 0, 0, 0, 0, 0);
    }

    //  Constructor para triangulo
    public Figura(Integer baseTrian, Integer alturaTrian){
        this(0, baseTrian, alturaTrian, 0, 0, 0);
    }

    //  Constuctor para pentagono
    public Figura(Integer ladoPent, Integer apotema, Integer cantLados){
        this(0, 0, 0, ladoPent, apotema, cantLados);
    }

    public String mostrarAreaCuad(){
        return "El area del cuadrado es: " + areaCuad;
    }

    public String mostrarAreaTriang(){
        return "El area del triangulo es: " + areaTriang;
    }

    public String mostrarAreaPent(){
        return "El area del pentagono es: " + areaPent;
    }
}
