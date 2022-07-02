package com.cristian.desarrollo;

public class Familia {
    public static void main(String[] args) {
        Abuelo ab1 = new Abuelo("Ovidio Quesada", "147852369", "1.70", "64", true, false, true, true, "Abuelo");
        System.out.print(ab1.mostrarInfoAbuelo());

        Padre pad1 = new Padre("Cesar Quesada", "10024241", "1.68", "48", true, true, true, "Padre");
        System.out.print(pad1.mostrarInfoPadre());

        Hijo hijo1 = new Hijo("Cristian Quesada", "1087489628", "1.78", "20", false, false, true, true, false, "Hijo");
        System.out.print(hijo1.mostrarInfoHijo());
    }
}
