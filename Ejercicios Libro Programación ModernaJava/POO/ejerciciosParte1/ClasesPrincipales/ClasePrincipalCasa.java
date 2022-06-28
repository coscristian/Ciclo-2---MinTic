/*Construir una clase con tres atributos de una casa, crear la Clase Casa
y crear su método Constructor que le asigne valores a los atributos que
se crearon. Adicional construya un programa Java que utilice esta
Clase Casa y muestre sus resultados */

package POO.ejerciciosParte1.ClasesPrincipales;

import POO.ejerciciosParte1.Clases.ClaseCasa;

public class ClasePrincipalCasa {
    public static void main(String[] args) {
        ClaseCasa Casa1 = new ClaseCasa();

        System.out.println("Color de la casa 1:\t" + Casa1.Color);
        System.out.println("Direccion de la casa 1:\t" + Casa1.Direccion);
        System.out.println("Estrato de la casa 1 =\t" + Casa1.Estrato);
    }
}
