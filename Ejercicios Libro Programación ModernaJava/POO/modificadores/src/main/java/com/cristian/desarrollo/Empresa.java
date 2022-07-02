package com.cristian.desarrollo;

public class Empresa {
    public static void main(String[] args) {
        Gasto g1 = new Gasto("Pago deudas", 35000.0);
        System.out.print(g1.mostrarInfo());

        Gasto g2 = new Gasto("Pago Banco", 67000.0);
        System.out.print(g2.mostrarInfo());
    }
}
