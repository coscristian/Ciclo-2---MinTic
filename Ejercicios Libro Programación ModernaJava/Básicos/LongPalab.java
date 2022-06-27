package Básicos;
/*Construir un programa que muestre la longitud de las palabras “casa”,
“amigo” y “universitario" */
public class LongPalab{
    public static void main(String args[]){
        String p1 = "casa", p2 = "amigo", p3 = "universitario";
        System.out.println("Longitud de la palabra ".concat(p1.concat(" = " + p1.length())));
        System.out.println("Longitud de la palabra ".concat(p2.concat(" = " + p2.length())));
        System.out.println("Longitud de la palabra ".concat(p3.concat(" = " + p3.length())));
    }
}