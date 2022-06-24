import java.util.Scanner;

public class Lectura1{
    public static void main(String args[]){
        Scanner Teclado = new Scanner(System.in);
        String nombre;
        int edad;
        double estatura;
        
        System.out.println("Por favor, escriba su nombre: ");
        nombre = Teclado.nextLine();

        System.out.println("Por favor, escriba su edad: ");
        edad = Teclado.nextInt();

        System.out.println("Por favor, escriba su estatura: ");
        estatura = Teclado.nextDouble();

        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Estatura: " + estatura);
        Teclado.close();
    }
}