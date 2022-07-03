package com.cristian.desarrollo;

public class ProgramaDispositivo {
    public static void main(String[] args) {
        SmartPhone2 sp1 = new SmartPhone2(1.5, "Negro", "No", "4000", "i3", "0", "Si", "Xiaomi", "Si", "Si", "Si");
        Impresora imp1 = new Impresora(5.2, "Negro", "N/A", "N/A", "N/A", "N/A", "Si", "EPSON", "Si", "Si", "Si");
        Monitor m1 = new Monitor(3.4, "Gris", "No", "N/A", "N/A", "N/A", "N/A", "Hp", "16:9", "75Hz", "5ms");

        System.out.print(sp1.mostrarMarca());
        System.out.print(sp1.mostrarCaracteristicas());

        System.out.print(imp1.mostrarMarca());
        System.out.print(imp1.mostrarCaracteristicas());

        System.out.print(m1.mostrarMarca());
        System.out.print(m1.mostrarCaracteristicas());
        System.out.println();
    }
}
