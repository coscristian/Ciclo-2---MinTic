package com.cristian.desarrollo;

public class Empresa2Programa {
    public static void main(String[] args) {
        Empleado e1 = new Empleado("1087489628", "Cristian Quesada Cossio", "20");
        System.out.print(e1.mostrarInfo());

        Empleado e2 = new Empleado("35586755");
        System.out.print(e2.mostrarInfo());

        Empleado e3 = new Empleado("10024241", "Cesar Vivas", "48");
        System.out.print(e3.mostrarInfo());
    }
}
