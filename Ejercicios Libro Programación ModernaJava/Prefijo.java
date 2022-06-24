/*Construir un programa que determine si la cadena “palabra” comienza
con la cadena “pala” */
public class Prefijo{
    public static void main(String args[]){
        String cad1 = "palabra", pref = "pala";
        System.out.println("La cadena".concat(cad1).concat(" comienza con ".concat(pref).concat(" --> ") + cad1.startsWith(pref)));
    }
}