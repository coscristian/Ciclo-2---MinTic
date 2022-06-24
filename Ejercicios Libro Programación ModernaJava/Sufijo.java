/*Construir un programa que determine si la cadena “enamorado”
termina en la palabra “morado” */
public class Sufijo{
    public static void main(String args[]){
        String cad1 = "enamorado", sufijo = "morado";
        System.out.println("La cadena ".concat(cad1).concat(" termina en ").concat(sufijo).concat(" --> ") + cad1.endsWith(sufijo));
    }
}