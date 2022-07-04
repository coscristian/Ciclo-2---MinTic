/*
Construir un programa Java que, a través de datos enumerados, permita
manejar cinco marcas de carros y una abreviatura por cada una que no
exceda tres letras */

package com.cristian.desarrollo;

public class MarcaCarro {
    // Clase enumeradora
    enum Marcas{
        Ford("FD"), Mazda("MZ"), Chevrolet("CVL"), Audi("AD"), Renault("RT");
   
        private String marca;
        // Constructor para la clase
        private Marcas(String marca){
            this.marca = marca;
        }

        public String muestraMarca(){
            return marca;
        }
    }

    public static void main( String[] args ){
        String m1 = "Ford";
        String m2 = "Mazda";
        String m3 = "Chevrolet";
        String m4 = "Audi";
        String m5 = "Renault";
        
        Marcas ab1 = Enum.valueOf(Marcas.class, m1);
        Marcas ab2 = Enum.valueOf(Marcas.class, m2);
        Marcas ab3 = Enum.valueOf(Marcas.class, m3);
        Marcas ab4 = Enum.valueOf(Marcas.class, m4);
        Marcas ab5 = Enum.valueOf(Marcas.class, m5);

        System.out.println("Marca: " + m1 + "\t\tAbreviación: " + ab1.muestraMarca());
        System.out.println("Marca: " + m2 + "\t\tAbreviación: " + ab2.muestraMarca());
        System.out.println("Marca: " + m3 + "\tAbreviación: " + ab3.muestraMarca());
        System.out.println("Marca: " + m4 + "\t\tAbreviación: " + ab4.muestraMarca());
        System.out.println("Marca: " + m5 + "\t\tAbreviación: " + ab5.muestraMarca());
    }
}
