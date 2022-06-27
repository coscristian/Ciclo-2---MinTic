package Básicos;
/*Construir un programa que determine si las cadenas “amigo” y
“amigo” son iguales */
public class CadIguales2{
    public static void main(String args[]){
        String cad1 = "amigo", cad2 = "amigo";
        System.out.println("La cadena ".concat(cad1).concat(" es igual a la cadena ").concat(cad2).concat(" --> ") + cad1.equals(cad2));
    }
}