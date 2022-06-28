package POO.ejerciciosParte2.ClasesPrincipales;

import POO.ejerciciosParte2.Clases.ClaseConParam;

public class EjemconParam {
    public static void main(String[] args) {
        ClaseConParam CP1 = new ClaseConParam(10, 20.0, "Hola");
        ClaseConParam CP2 = new ClaseConParam(20, 40.0, "Adios");

        System.out.println("Primer objeto\n");
        System.out.println("Dato1 =\t" + CP1.Dato1);
        System.out.println("Dato2 =\t" + CP1.Dato2);
        System.out.println("Cadena=\t" + CP1.Cadena);

        System.out.println("\nSegundo Objeto\n");
        System.out.println("Dato1 =\t" + CP2.Dato1);
        System.out.println("Dato2 =\t" + CP2.Dato2);
        System.out.println("Cadena=\t" + CP2.Cadena);
    }
}
