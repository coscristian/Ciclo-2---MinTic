package Básicos;
/*Construir un programa que muestre la palabra “versi” tomado de la
cadena “Universidad” */
public class CadIguales{
    public static void main(String args[]){
        String cad1 = "estudiante", cad2 = "programación";
        System.out.println("La cadena ".concat(cad1).concat(" es igual a la cadena ".concat(cad2).concat(" --> ") + cad1.equals(cad2)));
    }
}