package com.cristian.desarrollo;

public class CuentaBancaria {
    public static void main(String[] args) {

        Movimiento mv0 = new Movimiento("N/A", "N/A", "N/A", 0);
        System.out.print(mv0.mostrarInfo());
        System.out.print(Movimiento.mostrarSaldoDisponible());
        
        Movimiento mv1 = new Movimiento("Cristian", "Yuldavis", "Consignacion", 14000);
        System.out.print(mv1.mostrarInfo());
        System.out.print(Movimiento.mostrarSaldoDisponible());

        Movimiento mv2 = new Movimiento("N/A", "N/A", "Retiro", 20000);
        System.out.print(mv2.mostrarInfo());
        System.out.print(Movimiento.mostrarSaldoDisponible());

        Movimiento mv3 = new Movimiento("Juan Jose", "Cristian", "Consignacion", 3000);
        System.out.print(mv3.mostrarInfo());
        System.out.print(Movimiento.mostrarSaldoDisponible());
        System.out.println();
    }
}
