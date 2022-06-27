package Básicos;
import java.util.Scanner;

public class Sentencias{
    public static void main(String[] args){
        System.out.println();
        System.out.println();
        //condicionales2();
        //ciclos1();
        //ciclos2();
        //ciclos3();
        ciclos4();
        System.out.println();
    }

    private static void condicionales(){
        var sc = new Scanner(System.in);
        int num = 0;
        
        System.out.print("Ingrese un número: ");
        num = sc.nextInt();
        if (num > 0){
            System.out.println("Es positivo");
        }else if(num == 0){
            System.out.println("Es cero");
        }else{
            System.out.println("Es negativo");
        }
        sc.close();

    }

    private static void condicionales2() {

        System.out.print("Por favor, ingrese una letra: ");
        var sc = new Scanner(System.in);
        var num = sc.nextLine();;

        switch(num.toLowerCase()){
            case "a":
                System.out.println("Es una vocal");
                break;
            case "e":
                System.out.println("Es una vocal");
                break;
            case "i":
                System.out.println("Es una vocal");
                break;
            case "o":
                System.out.println("Es una vocal");
                break;
            case "u":
                System.out.println("Es una vocal");
                break;
            default:
                System.out.println("Es una consonante");
                break;
        }
        sc.close();
    }

    private static void ciclos1(){
        var numero = 5;
        while(numero > 0){
            System.out.println(numero);
            numero--;
        }
        System.out.println("BOOM!!");
    }

    private static void ciclos2(){
        var numero = 10;
        do{
            System.out.println(numero);
            numero--;
        }while(numero > 0);
        System.out.println("Despegue");
    }

    private static void ciclos3(){
        for(var numero = 5; numero > 0; --numero){
            System.out.println(numero);
        }
        System.out.println("BOOMMMMMM!!!!!!!!!!!!!");
    }

    private static void ciclos4(){
        // Foreach
        var frutas = new String[]{
            "Manzana", "Pera", "Naranja", "Mandarina", "Limon"
        };
        for(var fruta : frutas){
            System.out.println(fruta);
        }
    }
}