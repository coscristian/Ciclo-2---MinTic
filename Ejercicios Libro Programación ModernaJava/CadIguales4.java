/*Construir un programa que determine si las cadenas “amigo” y
“AMIGO” son iguales */
public class CadIguales4{
    public static void main(String args[]){
        String cad1 = "amigo", cad2 = "AMIGO";
        System.out.println("(Ignorando mayusculas y minusculas) La cadena ".concat(cad1).concat(" es igual a la cadena ").concat(cad2).concat(" --> ") + cad1.equalsIgnoreCase(cad2));
    }
}