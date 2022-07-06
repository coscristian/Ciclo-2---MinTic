/*
Construir un programa Java que permita asignarle 2 puntos a un equipo
de futbol por cada partido ganado y que le adicione 1 punto más cuando
dicho triunfo se hace como equipo visitante, es decir, en la casa del
otro equipo, aprovechando el concepto de herencia entre interfaces
 */

package com.cristian.desarrollo;
import javax.swing.JOptionPane;

public class ProgramaPrincipal {
    public static void main( String[] args ){
        String nombre;
        int partidosJugadosLocal, partidosGanadosLocal, partidosJugadosVis,
            partidosGanadosVis;
        
        Equipo[] misEquipos = new Equipo[1];

        for (int i = 0; i < 1; i++) {
            nombre = JOptionPane.showInputDialog("Ingrese el nombre del equipo " + (i+1));
            partidosJugadosLocal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de partidos jugados de local"));
            partidosGanadosLocal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de partidos ganados de local"));
            partidosJugadosVis = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de partidos jugados de visitante"));
            partidosGanadosVis = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de partidos ganados de visitante"));

            Equipo equipo = new Equipo(nombre, partidosJugadosLocal, partidosJugadosVis, partidosGanadosLocal, partidosGanadosVis);

            boolean masPartidosGanadosQueJugadosLocal = equipo.getPartidosGanadosLocal() > equipo.getPartidosJugadosLocal();
            boolean masPartidosGanadosQueJugadosVisit = equipo.getPartidosGanadosVis() > equipo.getPartidosJugadosVis();

            if (masPartidosGanadosQueJugadosLocal || masPartidosGanadosQueJugadosVisit){
                System.out.println("\n\nValores Ingresados no Validos!!!");
            }else{
                equipo.asignarPuntosLocal(equipo.getPartidosGanadosLocal());
                equipo.asignarPuntosVisitante(equipo.getPartidosGanadosVis());
                equipo.setTotalPartidosJugados(equipo.getPartidosJugadosLocal() + equipo.getPartidosJugadosVis());
                misEquipos[i] = equipo;
            }
        } 

        int cont = 1;    
        System.out.println("================================================================");
        System.out.println("Posición\t|Equipo\t|PTS\t|Jug Loc\t|Jug Vis\t|Gan Loc\t|Gan Vis\t|Total");
        for (Equipo e : misEquipos) {
            System.out.print(cont + "\t\t|" + e.getNombre() + "\t|" + e.getPuntosTotales() + "\t|" + e.getPartidosJugadosLocal() + "\t|" + e.getPartidosJugadosVis() + "\t|" + e.getPartidosGanadosLocal() + "\t|" + e.getPartidosGanadosVis() + "\t|" + e.getTotalPartidosJugados());
            System.out.println();
            cont++;
        }
        System.out.println("================================================================");
    }
}
