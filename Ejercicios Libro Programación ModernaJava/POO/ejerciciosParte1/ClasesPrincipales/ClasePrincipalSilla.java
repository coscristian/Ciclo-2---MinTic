/*Construir una clase con tres atributos de una silla, crear la Clase Silla
y crear su método Constructor que le asigne valores a los atributos que
se crearon. Adicional construya un programa Java que utilice esta
Clase y muestre sus resultados */

package POO.ejerciciosParte1.ClasesPrincipales;

import POO.ejerciciosParte1.Clases.ClaseSilla;

public class ClasePrincipalSilla {
    public static void main(String[] args) {
        ClaseSilla Silla1 = new ClaseSilla();
        System.out.println("Marca:\t" + Silla1.Marca);
        System.out.println("Cantidad de personas que se pueden sentar:\t" + Silla1.CantPersonas);
        System.out.println("Precio:\t" + Silla1.Precio);
    }
}
