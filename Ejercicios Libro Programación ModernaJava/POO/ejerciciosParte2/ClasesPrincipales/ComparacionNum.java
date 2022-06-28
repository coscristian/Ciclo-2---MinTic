package POO.ejerciciosParte2.ClasesPrincipales;
import java.util.Scanner;

import POO.ejerciciosParte2.Clases.Num1MayorNum2;
import POO.ejerciciosParte2.Clases.Num1MenorNum2;
import POO.ejerciciosParte2.Clases.NumDifentes;
import POO.ejerciciosParte2.Clases.NumIguales;

public class ComparacionNum {
    public static void main(String[] args) {
        int num1, num2;
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un numero: ");
        num1 = sc.nextInt();

        System.out.print("Ingrese otro numero: ");
        num2 = sc.nextInt();

        //Instacias de las clases
        Num1MayorNum2 PrimerMayorSegundo = new Num1MayorNum2(num1, num2);
        Num1MenorNum2 PrimerMenorSegundo = new Num1MenorNum2(num1, num2);
        NumIguales SonIguales = new NumIguales(num1, num2);
        NumDifentes SonDiferentes = new NumDifentes(num1, num2);

        if (PrimerMayorSegundo.resultado){
            System.out.println("El primer numero es mayor que el segundo");
        }else{
            System.out.println("El primer numero no es mayor que el segundo");
        }

        if (PrimerMenorSegundo.resultado){
            System.out.println("El primer numero es menor que el segundo");
        }else{
            System.out.println("El primer numero no es menor que el segundo");
        }

        if (SonIguales.resultado){
            System.out.println("Los numeros son iguales");
        }else{
            System.out.println("Los numero no son iguales");
        }

        if(SonDiferentes.resultado){
            System.out.println("Los numeros son diferentes");
        }else{
            System.out.println("Los numeros no son diferentes");
        }
        sc.close();
    }
}
