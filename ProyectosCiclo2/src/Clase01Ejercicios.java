import java.util.Scanner;
import java.util.Random;

public class Clase01Ejercicios {
    public static void main(String args[]){
        
        byte opcion = 0;
        Scanner sc = new Scanner(System.in);

        while(opcion != 16){
            try {
                mostrar_menu();
                opcion = seleccionarOpcion(sc);
                clearScreen();
                switch(opcion){
                    case 1: ejercicio1(sc); break;
                    case 2: ejercicio2(sc); break;
                    case 3: ejercicio3(sc); break;
                    case 4: ejercicio4(sc); break;
                    case 5: ejercicio5(sc); break;
                    case 6: ejercicio6(sc); break;
                    case 7: ejercicio7(sc); break;
                    case 8: ejercicio8(sc); break;
                    case 9: ejercicio9(sc); break;
                    case 10: ejercicio10(sc); break;
                    case 11: ejercicio11(sc); break;
                    case 12: ejercicio12(sc); break;
                    case 13: ejercicio13(sc); break;
                    // case 14: ejercicio14(); break;
                    // case 15: ejercicio15(); break;
                    // case 16: salir(); break;
                    default:
                        clearScreen();
                        System.out.println("\nValor no valido");
                        break;
                }
            }catch (Exception e) {
                clearScreen();
                System.out.println("\nError!! Ingrese un valor valido");
                System.out.println(e);
                sc.nextLine(); 
            }    
            esperarEntrada(sc);
        }
        sc.close();
    }

    private static void esperarEntrada(Scanner sc){
        System.out.print("\n\nPresione Enter para continuar... ");
        sc.nextLine();
        clearScreen();
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    public static double pedirFlotante(String mensaje, Scanner sc) {
        double Num;
        System.out.print(mensaje);
        Num = sc.nextDouble();
        sc.nextLine();   // Obtiene el salto de linea en el buffer
        return Num;
    }

    public static int pedirEntero(String mensaje, Scanner sc) {
        int Num;
        System.out.print(mensaje);
        Num = sc.nextInt();
        sc.nextLine();   // Obtiene el salto de linea en el buffer
        return Num;
    }

    public static String pedirCadena(String mensaje, Scanner sc){
        System.out.print(mensaje);
        String Cadena = sc.nextLine();
        return Cadena;
    }
    // ------------------

    private static void ejercicio13(Scanner sc){
        boolean continuarJugando = true;
        String Nombre1, Nombre2, opcionJugador1, opcionJugador2, Resultado = "";
        byte puntosJugador1 = 0, puntosJugador2 = 0;
        Nombre1 = pedirCadena("Ingrese el nombre del Jugador 1: ", sc);
        Nombre2 = pedirCadena("Ingrese el nombre del Jugador 2: ", sc);
        
        while(continuarJugando){
            //Pedir al jugador que seleccione la opcion con la que desea jugar
            opcionJugador1 = pedirCadena(Nombre1 + ": Piedra (P), Papel(L), Tijera(T) ?: ", sc);
            opcionJugador2 = pedirCadena(Nombre2 + ": Piedra (P), Papel(L), Tijera(T) ?: ", sc);

            if (opcionJugador1.equalsIgnoreCase("P")){  //Casos derivados para Piedra seleccionada por J1
                if(opcionJugador2.equalsIgnoreCase("P")){
                    Resultado = "EMPATE!! No hay puntos para ningún jugador";
                }else if (opcionJugador2.equalsIgnoreCase("L")){
                    Resultado = "Punto para " + Nombre2;
                    puntosJugador2++;
                }else if(opcionJugador2.equalsIgnoreCase("T")){
                    Resultado = "Punto para " + Nombre1;
                    puntosJugador1++;
                }else{
                    System.out.println("Ingrese una letra correcta!!");
                }
            }else if(opcionJugador1.equalsIgnoreCase("L")){ //Casos derivados para Papel seleccionado por J1
                if(opcionJugador2.equalsIgnoreCase("L")){
                    Resultado = "EMPATE!! No hay puntos para ningún jugador";
                }else if (opcionJugador2.equalsIgnoreCase("P")){
                    Resultado = "Punto para " + Nombre1;
                    puntosJugador1++;
                }else if(opcionJugador2.equalsIgnoreCase("T")){
                    Resultado = "Punto para " + Nombre2;
                    puntosJugador2++;
                }else{
                    System.out.println("Ingrese una letra correcta!!");
                }
            }else if(opcionJugador1.equalsIgnoreCase("T")){ //Casos derivados para Tijera seleccionado por J1
                if(opcionJugador2.equalsIgnoreCase("T")){
                    Resultado = "EMPATE!! No hay puntos para ningún jugador";
                }else if (opcionJugador2.equalsIgnoreCase("P")){
                    Resultado = "Punto para " + Nombre2;
                    puntosJugador2++;
                }else if(opcionJugador2.equalsIgnoreCase("L")){
                    Resultado = "Punto para " + Nombre1;
                    puntosJugador1++;
                }else{
                    System.out.println("Ingrese una letra correcta!!");
                }
            }else{
                System.out.println("Ingrese una letra correcta!!");
            }
            clearScreen();
            System.out.println(Resultado);
            System.out.printf("\tPuntos %s --> %d %n\tPuntos %s --> %d",Nombre1, puntosJugador1, Nombre2, puntosJugador2);

            if (puntosJugador1 == 3 || puntosJugador2 == 3){
                if (puntosJugador1 == 3){
                    System.out.println("\n" + Nombre1 + " ha ganado la ronda!!!");
                }else if(puntosJugador2 == 3){
                    System.out.println("\n" + Nombre2 + " ha ganado la ronda!!!");
                }
                if(!continuarIngresando("Desea jugar de nuevo?: ", sc)){  //Si no desea continuar jugando
                    continuarJugando = false;
                }
            }
            esperarEntrada(sc);
        }
    }

    private static boolean continuarIngresando(String mensaje, Scanner sc){
        esperarEntrada(sc);
        while(true){
            clearScreen();
            String respuesta = pedirCadena(mensaje, sc);
            if (respuesta.equalsIgnoreCase("S")){
                return true;
            }else if(respuesta.equalsIgnoreCase("N")){
                return false;
            }else{
                System.out.println("Ingrese una respuesta correcta");
                esperarEntrada(sc);
            }
        }
    }

    private static boolean esPrimo(int Num){
        int cont_div = 0;
        if (Num != 1 && Num != 0){
            for(int i = 2; i < Num; i++){
                if (Num % i == 0){
                    cont_div++;
                }
            }
            return cont_div == 0;
        }else{
            return false;
        }
    }

    private static void ejercicio12(Scanner sc) {
        boolean ingresar = true;
        int Num;

        while(ingresar){
            clearScreen();
            Num = pedirEntero("Ingrese un numero: ", sc);
            if (esPrimo(Num)){
                System.out.println("El numero es primo.");
            }else{
                System.out.println("El numero no es primo.");
            }
            ingresar = continuarIngresando("Desea introducir otro número (S/N): ", sc);
        }
    }

    private static void ejercicio11(Scanner sc){
        String sexo;
        int estatura = 0, PesoIdeal = 0;
        boolean correcto = false;
        while(!correcto){
            sexo = pedirCadena("Ingrese el sexo H/M: ", sc);
            estatura = pedirEntero("Ingrese la estatura en cm: ", sc);
            if (sexo.equalsIgnoreCase("H")){
                PesoIdeal = estatura - 100;
                correcto = true;
            }else if (sexo.equalsIgnoreCase("M")){
                PesoIdeal = estatura - 110;
                correcto = true;
            }else{
                System.out.println("Dato ingresado no valido");
                esperarEntrada(sc);
            }
        }
        System.out.print("Peso ideal " + PesoIdeal + " kg.");
    }

    private static void ejercicio10(Scanner sc){
        int NumIngresado, NumAleat;
        boolean Encontrado = false;
        Random  claseRandom = new Random();
        NumAleat = 1 + claseRandom.nextInt(100 - 1);

        while (!Encontrado){
            NumIngresado = pedirEntero("Ingrese un numero: ", sc);
            if (NumAleat > NumIngresado){
                System.out.println("El numero que busca es mayor.");
            }else if (NumAleat < NumIngresado){
                System.out.println("El numero que busca es menor.");
            }else{
                System.out.println("Has encontrado el numero.");
                Encontrado = true;
            }
            esperarEntrada(sc);
        }
    }

    private static void ejercicio9(Scanner sc){
        int Num = pedirEntero("Ingrese un numero entero: ", sc);
        for(int i = 1; i <= 10; i++){
            System.out.printf("%d * %d = %d%n", Num, i, (Num*i));
        }
    }

    private static void ejercicio8(Scanner sc){
        double horasTrabajadas, valorHora = 30000, sueldoFinal;
        horasTrabajadas = pedirFlotante("Ingrese el total de horas trabajadas: ", sc);
        sueldoFinal = horasTrabajadas * valorHora;
        System.out.printf("Si el trabajador trabaja %1.1f horas y cada hora vale $%1.1f, el sueldo final será de $%1.1f.%n", horasTrabajadas, valorHora, sueldoFinal);
    }

    private static double sacarPromedio(double N1,double N2,double N3){
        return (N1+N2+N3)/3;
    }

    private static void ejercicio7(Scanner sc){
        String Nombre;
        double N1, N2, N3, Promedio;

        Nombre = pedirCadena("Ingrese el nombre del alumno: ", sc);
        N1 = pedirFlotante("Ingrese la nota 1: ", sc);
        N2 = pedirFlotante("Ingrese la nota 2: ", sc);
        N3 = pedirFlotante("Ingrese la nota 3: ", sc);

        Promedio = sacarPromedio(N1, N2, N3);
        System.out.println("El estudiante " + Nombre + " con notas: ");
        System.out.println("\tNota 1: " + N1);
        System.out.println("\tNota 2: " + N2);
        System.out.println("\tNota 3: " + N3);
        System.out.printf("\tTiene un promedio academico de: %1.3f%n", Promedio);
        if (Promedio >= 3.0){
            System.out.print("Aprobado");
        }else{
            System.out.print("Reprobado");
        }

    }

    private static void ejercicio6(Scanner sc){
        int num1, num2, suma, resta, div, mult;
        
        num1 = pedirEntero("Ingrese un numero: ", sc);
        num2 = pedirEntero("Ingrese otro numero: ", sc);

        suma = num1 + num2;
        resta = num1 - num2;
        div = num1 / num2;
        mult = num1 * num2;

        System.out.printf("La suma de %d y %d es igual a %d%n", num1, num2, suma);
        System.out.printf("La resta de %d y %d es igual a %d%n", num1, num2, resta);
        System.out.printf("La division de %d y %d es igual a %d%n", num1, num2, div);
        System.out.printf("La multiplicacion de %d y %d es igual a %d%n", num1, num2, mult);
    }

    private static boolean NumEsPar(int Num){
        return (Num % 2 == 0);
    }

    private static void ejercicio5(Scanner sc) {
        int Num = pedirEntero("Ingrese un numero entero: ", sc);
        if ( NumEsPar(Num) ){
            System.out.print("Es par");
        }else{
            System.out.print("Es impar");
        }
    }

    private static double centigAfarenh(double Centig) {
        return 32 + (9 * Centig / 5);
    }

    private static void ejercicio4(Scanner sc){
        double Centig = pedirFlotante("Ingrese la cantidad en Centigrados: ", sc);
        double Farenh = centigAfarenh(Centig);
        System.out.printf("%1.2f grados Centigrados equivalen a %1.2f grados Farenheit.", Centig,Farenh);
    }

    private static void ejercicio3(Scanner sc){
        int Num = pedirEntero("Ingrese un numero: ", sc);
        System.out.printf("Doble: %d %nTriple: %d", Num*2, Num*3);
    }

    private static int cantDigitos(int Num){
        int contador = 0;
        if (Num == 0){
            return 1;
        }else{
            while(Num != 0){
                Num /= 10;
                contador++;
            }
        }
        return contador;
    }

    private static void ejercicio2(Scanner sc){
        int CantDig, Num;

        Num = pedirEntero("Ingrese un número: ", sc);
        CantDig = cantDigitos(Num);
        System.out.printf("Numero ingresado: %d %nCantidad de digitos: %d", Num, CantDig);
    }

    private static void ejercicio1(Scanner sc){
        String Nombre = pedirCadena("Ingrese su nombre: ", sc);

        System.out.printf("\nHola %s Bienvenido!! %n", Nombre);
    }

    private static byte seleccionarOpcion(Scanner sc){
        byte OpcionSelecc;
        OpcionSelecc = sc.nextByte();
        sc.nextLine(); // Obtiene el salto de linea en el buffer
        return OpcionSelecc;
    }

    private static void mostrar_menu(){
        String Menu;
        Menu = "Menu Principal \n" + 
               "-------------- \n" + 
               "1. Ejercicio 1\n" +
               "2. Ejercicio 2\n" +
               "3. Ejercicio 3\n" +
               "4. Ejercicio 4\n" +
               "5. Ejercicio 5\n" +
               "6. Ejercicio 6\n" +
               "7. Ejercicio 7\n" +
               "8. Ejercicio 8\n" +
               "9. Ejercicio 9\n" +
               "10. Ejercicio 10\n" +
               "11. Ejercicio 11\n" +
               "12. Ejercicio 12\n" +
               "13. Ejercicio 13\n" +
               "14. Ejercicio 14\n" +
               "15. Ejercicio 15\n" +
               "16. Salir\n" + 
               "Seleccione una opción: ";
        System.out.print(Menu);
    }
}
