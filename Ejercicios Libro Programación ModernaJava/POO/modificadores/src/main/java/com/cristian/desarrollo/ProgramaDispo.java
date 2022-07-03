package com.cristian.desarrollo;

public class ProgramaDispo {
    public static void main(String[] args) {
        Dispositivo[] DV = new Dispositivo[5];

        SmartPhone DS = new SmartPhone("Nokia", 100, "Blanco", "Si", 200000, "T6", 600000, "SI", "No");
        Portatil DP = new Portatil("Lenovo", 1000, "Rojo", "No", 1000000, "P5", 5000000, "Si", "No");

        DV[0] = DS;
        DV[1] = DP;
        DV[2] = new SmartPhone("Compaq", 200, "Amarillo", "No", 300000, "T2", 600000, "Si", "No");
        DV[3] = new Portatil("IBM", 3000, "Azul", "Si", 4000000, "P5", 5000000, "Si", "No");
        DV[4] = new Dispositivo("Compaq", 200, "Amarillo", "No", 300000, "T2", 600000);

        for (Dispositivo D: DV) {
            System.out.println(D.muestraMarca());
        }

    }
}
