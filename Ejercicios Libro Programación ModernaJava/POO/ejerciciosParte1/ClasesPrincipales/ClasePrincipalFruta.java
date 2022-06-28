/*Construir una clase con tres atributos de una fruta, crear la Clase Fruta
y crear su método Constructor que le asigne valores a los atributos que
se crearon. Adicional construya un programa Java que utilice esta
Clase y muestre sus resultados */

package POO.ejerciciosParte1.ClasesPrincipales;

import POO.ejerciciosParte1.Clases.ClaseFruta;

public class ClasePrincipalFruta {
    public static void main(String[] args) {
        ClaseFruta Fruta1 = new ClaseFruta();
        System.out.println("Sabor:\t" + Fruta1.Sabor);
        System.out.println("Precio=\t" + Fruta1.Precio);
        System.out.println("Tamaño:\t" + Fruta1.Tamanio);
    }
}
