import java.util.Scanner;

public class Leer1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Por favor, ingrese su nombre: ");
        String nombre = sc.nextLine();
        sc.close();
        var plantilla = "Hola %s!";
        System.out.printf(plantilla, nombre);
    }
}
