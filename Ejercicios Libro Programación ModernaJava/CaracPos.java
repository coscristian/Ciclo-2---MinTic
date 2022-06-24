/*Construir un programa que muestre el carácter que está en la posición
5ª, 7ª y 9ª de la palabra “desencantamiento” */
public class CaracPos{
    public static void main(String args[]){
        String palab = "desencantamiento";
        System.out.println("Palabra --> ".concat(palab));
        System.out.println("Caracter en la posicion 5 " + palab.charAt(4));
        System.out.println("Caracter en la posicion 7 " + palab.charAt(6));
        System.out.println("Caracter en la posicion 9 " + palab.charAt(8));
    }
}