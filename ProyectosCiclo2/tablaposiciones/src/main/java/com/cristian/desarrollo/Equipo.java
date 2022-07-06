package com.cristian.desarrollo;

public class Equipo implements AsignarPuntosVisitante{
    private String nombre;
    private int partidosJugadosLocal;
    private int partidosGanadosLocal;
    private int partidosJugadosVis;
    private int partidosGanadosVis;

    private int posicion;
    private int totalPartidosJugados;
    private int puntosTotales = 0;

    public Equipo(String nombre, int partidosJugadosLocal, int partidosJugadosVis, int partidosGanadosLocal, int partidosGanadosVis) {
        this.nombre = nombre;
        this.partidosJugadosLocal = partidosJugadosLocal;
        this.partidosJugadosVis = partidosJugadosVis;
        this.partidosGanadosLocal = partidosGanadosLocal;
        this.partidosGanadosVis = partidosGanadosVis;
    }

    // Getters
    public String getNombre(){
        return nombre;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public int getPosicion() {
        return posicion;
    }

    public int getPartidosJugadosLocal() {
        return partidosJugadosLocal;
    }

    public int getPartidosJugadosVis() {
        return partidosJugadosVis;
    }

    public int getTotalPartidosJugados() {
        return totalPartidosJugados;
    }

    public int getPartidosGanadosLocal() {
        return partidosGanadosLocal;
    }

    public int getPartidosGanadosVis() {
        return partidosGanadosVis;
    }

    // Setters
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void setTotalPartidosJugados(int totalPartidosJugados) {
        this.totalPartidosJugados = totalPartidosJugados;
    }

    // Asignación de puntos
    public void asignarPuntosLocal(int partidosGanados){
        puntosTotales += puntosLocal * partidosGanados;
    }    

    public void asignarPuntosVisitante(int partidosGanados){
        puntosTotales += puntosVisitante * partidosGanados;
    }
}
