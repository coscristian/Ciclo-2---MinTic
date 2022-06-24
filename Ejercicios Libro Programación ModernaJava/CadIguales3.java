/*Construir un programa que determine si las cadenas “Amigo” y
“AmIgO” son iguales */
public class CadIguales3{
    public static void main(String args[]){
        String cad1 = "Amigo", cad2 = "AmIgO";
        System.out.println("La cadena ".concat(cad1).concat(" y la cadena ").concat(cad2).concat(" son iguales? --> ") + cad1.equals(cad2));
    }
}