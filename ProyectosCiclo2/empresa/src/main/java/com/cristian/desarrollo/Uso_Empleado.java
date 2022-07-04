package com.cristian.desarrollo;
import java.util.*;

// Clase principal
public class Uso_Empleado {
    public static void main( String[] args ){
        
    }
}

class Empleado{
    public Empleado(String nom, double sue, int agno, int mes, int dia){
        nombre = nom;  
        sueldo = sue;
        GregorianCalendar calendario = new GregorianCalendar(agno, mes-1, dia);
        altaContrato = calendario.getTime();
    }

    public String getNombre(){
        return nombre;
    }

    public double getSueldo(){
        return sueldo;
    }

    public Date getFechaContrato(){
        return altaContrato;
    }

    public void subeSueldo(double porcentaje){
        double aumento = sueldo * porcentaje / 100;
        sueldo += aumento;
    }

    private String nombre;
    private double sueldo;
    private Date altaContrato;


}
