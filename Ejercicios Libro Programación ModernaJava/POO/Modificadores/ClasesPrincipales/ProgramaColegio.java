import POO.Modificadores.Clases.*;
import java.util.Scanner;

public class ProgramaColegio {
    public static void main(String[] args) {
        String codigo, nombre, apellidos, fechaN;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese el codigo del estudiante: ");
        codigo = sc.nextLine();

        System.out.print("Ingrese el nombre del estudiante: ");
        nombre = sc.nextLine();

        System.out.print("Ingrese los apellidos del estudiante: ");
        apellidos = sc.nextLine();

        System.out.print("Ingrese la fecha de nacimiento: ");
        fechaN = sc.nextLine();

        Estudiante est1 = new Estudiante(codigo, nombre, apellidos, fechaN);

        System.out.println(est1.muestraDatos());

        sc.close();
    }
}
