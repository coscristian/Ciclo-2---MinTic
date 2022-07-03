package com.cristian.desarrollo;

public class ProgramaHerramienta {
    public static void main(String[] args) {
        
        Herramienta[] ArrayHerr = new Herramienta[4];

        Martillo m1 = new Martillo("Rojo", "3cm", "Stanley", "Si", "Madera");
        Serrucho s1 = new Serrucho("Café", "4cm", "Bahco", "No", "Madera", "Metal");
        Taladro t1 = new Taladro("Amarillo", "10cm", "DeWalt", "Si", "Si", "No", "Farol");
        Herramienta h1 = new Herramienta("Azul", "6cm", "Bosch", "No");

        ArrayHerr[0] = m1;
        ArrayHerr[1] = s1;
        ArrayHerr[2] = t1;
        ArrayHerr[3] = h1;
        
        for (Herramienta herr : ArrayHerr) {
            System.out.println(herr.muestraMarca());   
        }
    }
}
