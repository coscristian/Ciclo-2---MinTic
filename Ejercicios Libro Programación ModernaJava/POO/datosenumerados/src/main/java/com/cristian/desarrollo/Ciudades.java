/*Construir un programa Java que, a través de datos enumerados, permita
manejar diez ciudades con sus respectivas abreviaturas según los
estándares internacionales */

package com.cristian.desarrollo;

public class Ciudades {
    enum AbrevCiudades{
        Miami("MIA"), Milwaukee("MKE"), Milan("MIL"), Melbourne("MEL"), Maracaibo("MAR"),
        Medellín("MDE"), Moscu("MOW"), New_York("NYC"), New_Orleans("MSY"), Murcia("MJV"),
        Nairobi("NBO");

        private String ciudad;
        private AbrevCiudades(String ciudad){
            this.ciudad = ciudad;
        }

        public String mostrarAbreviatura(){
            return ciudad;
        }
    }

    public static void main(String[] args) {
        String c1 = "Miami";
        String c2 = "Milwaukee";
        String c3 = "Milan";
        String c4 = "Melbourne";
        String c5 = "Maracaibo";
        String c6 = "Medellín";
        String c7 = "Moscu";
        String c8 = "New_York";
        String c9 = "New_Orleans";
        String c10 = "Murcia";
        String c11 = "Nairobi";

        AbrevCiudades a1 = Enum.valueOf(AbrevCiudades.class, c1);
        AbrevCiudades a2 = Enum.valueOf(AbrevCiudades.class, c2);
        AbrevCiudades a3 = Enum.valueOf(AbrevCiudades.class, c3);
        AbrevCiudades a4 = Enum.valueOf(AbrevCiudades.class, c4);
        AbrevCiudades a5 = Enum.valueOf(AbrevCiudades.class, c5);
        AbrevCiudades a6 = Enum.valueOf(AbrevCiudades.class, c6);
        AbrevCiudades a7 = Enum.valueOf(AbrevCiudades.class, c7);
        AbrevCiudades a8 = Enum.valueOf(AbrevCiudades.class, c8);
        AbrevCiudades a9 = Enum.valueOf(AbrevCiudades.class, c9);
        AbrevCiudades a10 = Enum.valueOf(AbrevCiudades.class, c10);
        AbrevCiudades a11 = Enum.valueOf(AbrevCiudades.class, c11);
    
        System.out.println("Abreviatura: " + a1.mostrarAbreviatura() + "\tCiudad: " + c1);
        System.out.println("Abreviatura: " + a2.mostrarAbreviatura() + "\tCiudad: " + c2);
        System.out.println("Abreviatura: " + a3.mostrarAbreviatura() + "\tCiudad: " + c3);
        System.out.println("Abreviatura: " + a4.mostrarAbreviatura() + "\tCiudad: " + c4);
        System.out.println("Abreviatura: " + a5.mostrarAbreviatura() + "\tCiudad: " + c5);
        System.out.println("Abreviatura: " + a6.mostrarAbreviatura() + "\tCiudad: " + c6);
        System.out.println("Abreviatura: " + a7.mostrarAbreviatura() + "\tCiudad: " + c7);
        System.out.println("Abreviatura: " + a8.mostrarAbreviatura() + "\tCiudad: " + c8);
        System.out.println("Abreviatura: " + a9.mostrarAbreviatura() + "\tCiudad: " + c9);
        System.out.println("Abreviatura: " + a10.mostrarAbreviatura() + "\tCiudad: " + c10);
        System.out.println("Abreviatura: " + a11.mostrarAbreviatura() + "\tCiudad: " + c11);
    }
}
