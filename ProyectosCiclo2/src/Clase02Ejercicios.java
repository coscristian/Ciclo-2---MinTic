import java.nio.file.OpenOption;
import java.util.Scanner;

public class Clase02Ejercicios {
    public static void main(String[] args) {
        clearScreen();
        byte option = 0;
        Scanner sc = new Scanner(System.in);
        while(option != 18){
            try {
                showMainMenu();
                option = inputByte("Select an option: ", sc);
                clearScreen();
                switch(option){
                    case 1: exercise1(sc); break;
                    case 2: exercise2(sc); break;
                    case 3: exercise3(sc); break;
                    case 4: exercise4(sc); break;
                    case 5: exercise5(sc); break;
                    case 6: exercise6(sc); break;
                    case 7: exercise7(sc); break;
                    case 8: exercise8(sc); break;
                    case 9: exercise9(sc); break;
                    case 10: exercise10(sc); break;
                    case 11: exercise11(sc); break;
                    case 12: exercise12(sc); break;
                    case 13: exercise13(sc); break;
                    case 14: exercise14(sc); break;
                    case 15: exercise15(sc); break;
                    case 16: exercise16(sc); break;
                    case 17: exercise17(sc); break;
                    case 18: clearScreen();
                             System.out.println("Saliendo...");; break;
                    default:
                        System.out.println("Select a correct option...");
                        break;
                }       
            } catch (Exception e) {
                System.out.println("Error...");
                System.out.println(e);
            }
            waitForInput(sc);
            clearScreen();
        }
        sc.close();
    }

    // Base methods
    private static void showError(Exception error, Scanner sc){
        clearScreen();
        sc.nextLine();
        System.out.println("Incorrect value...");
        System.out.print(error);
        waitForInput(sc);
    }
    private static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    private static void waitForInput(Scanner sc) {
        System.out.print("\n\nPress ENTER to continue...");
        sc.nextLine();
    }

    private static char inputChar(String message, Scanner sc){
        System.out.print(message);
        char charact = sc.next().charAt(0);
        sc.nextLine();
        return charact;
    }

    private static byte inputByte(String message, Scanner sc){
        System.out.print(message);
        byte ByteValue = sc.nextByte();
        sc.nextLine();
        return ByteValue;
    }

    private static double inputDouble(String message, Scanner sc){
        System.out.print(message);
        double DoubleValue = sc.nextDouble();
        sc.nextLine();
        return DoubleValue;
    }

    private static int inputInt(String message, Scanner sc){
        System.out.print(message);
        int intValue = sc.nextInt();
        sc.nextLine();
        return intValue;
    }

/*     private static String inputString(String message, Scanner sc) {
        System.out.print(message);
        String UserInput = sc.nextLine();
        //sc.nextLine(); //Cleans the buffer
        return UserInput;
    } */

    private static void showMainMenu(){
        String Menu;
        Menu = "Main Menu \n" + 
               "-------------- \n" + 
               "1. Exercise 1\n" +
               "2. Exercise 2\n" +
               "3. Exercise 3\n" +
               "4. Exercise 4\n" +
               "5. Exercise 5\n" +
               "6. Exercise 6\n" +
               "7. Exercise 7\n" +
               "8. Exercise 8\n" +
               "9. Exercise 9\n" +
               "10. Exercise 10\n" +
               "11. Exercise 11\n" +
               "12. Exercise 12\n" +
               "13. Exercise 13\n" +
               "14. Exercise 14\n" +
               "15. Exercise 15\n" +
               "16. Exercise 16\n" +
               "17. Exercise 17\n" +
               "18. Exit\n";
        System.out.print(Menu);
    }

    //Exercises
    private static void exercise17(Scanner sc){
        for (int counter = 10000; counter < 100000; counter++){
            String str = Integer.toString(counter);
            String newNumb = str.substring(0,2) + 'E' + str.substring(3, 5);
            System.out.println(newNumb);
        }
    }

    private static void exercise16(Scanner sc) {
        int counter = 90;
        for (int line = 1; line <= 26; line++){
            for(int letter = counter; letter >= 65; letter--){
                System.out.printf("%c", (char) letter);
            }
            System.out.println();
            counter--;
        }
    }

    private static void exercise15(Scanner sc){
        int factorial, suma = 1, N;
        boolean CorrectValues = false;

        while(!CorrectValues){
            try {
                clearScreen();
                N = inputInt("Enter the N value: ", sc);
                for(int i = 1; i <= N; i++){
                    factorial = 1;
                    for(int j = 1; j <= i; j++){
                        factorial = factorial * j;
                    }
                    suma += factorial;
                }
                System.out.println(suma);
                CorrectValues = true;
            } catch (Exception e) {
                showError(e, sc);
            }
        }
    }

    private static void exercise14(Scanner sc){
        int AmountNumbers, prev = 0, current = 1, next, counter = 1;
        boolean CorrectValue = false;

        while(!CorrectValue){
            try {
                clearScreen();
                AmountNumbers = inputInt("Please enter the amount of numbers of the Serie you want to see: ", sc);
                if (AmountNumbers != 0){
                    System.out.print(prev);
                    while(counter < AmountNumbers){
                        next = prev + current;
                        System.out.printf(" %d",current);
                        prev = current;
                        current = next;
                        counter++;
                    }
                }
                CorrectValue = true;
            } catch (Exception e) {
                showError(e, sc);
            }
        }
    }

    private static void exercise13(Scanner sc){
        byte option;
        boolean CorrectValues = false;
        String message = String.format("1. COP to USD. %n2. USD to COP.%nSelect an option: ");
        double COP, USD;
        while(!CorrectValues){
            try {
                clearScreen();
                option = inputByte(message, sc);
                if (option == 1){
                    COP = inputDouble("Please enter the value in COP: ", sc);
                    USD = COP * 0.000242;
                    System.out.printf("Value in USD --> %,f", USD);
                }else if (option == 2){
                    USD = inputDouble("Please enter the value in USD: ", sc);
                    COP = USD * 4138.50;
                    System.out.printf("Value in COP --> %,f", COP);
                }else{
                    System.out.println("Incorrect option...");
                }  
                CorrectValues = true;
            } catch (Exception e) {
                showError(e, sc);
            }
        }

    }

    private static void exercise12(Scanner sc){
        //While
/*      int Num = 1;
        while(Num < 100){
            if (Num % 3 != 0){
                System.out.println(Num);
            }
            Num++;
        } */
        //For
/*      for(int i = 1; i < 100; i++){
            if (i % 3 != 0){
                System.out.println(i);
            }
        } */
        //Do WHile
        int i = 1;
        do{ 
            if (i % 3 != 0){
                System.out.println(i);
            }
            i++;
        }while(i < 100);

    }

    private static void exercise11(Scanner sc) {
        byte month;
        boolean CorrectValue = false;

        while(!CorrectValue){
            try {
                clearScreen();
                month = inputByte("Please enter the value of the month: ", sc);
                switch (month) {
                    case 1:
                        System.out.println("Mes de 31 días --> Corresponde a Enero");
                        break;
                    case 2:
                        System.out.println("Mes de 28 días --> Corresponde a Febrero");
                        break;
                    case 3:
                        System.out.println("Mes de 31 días --> Corresponde a Marzo");
                        break;  
                    case 4:
                        System.out.println("Mes de 30 días --> Corresponde a Abril");
                        break;  
                    case 5:
                        System.out.println("Mes de 31 días --> Corresponde a Mayo");
                        break;
                    case 6:
                        System.out.println("Mes de 30 días --> Corresponde a Junio");
                        break; 
                    case 7:
                        System.out.println("Mes de 31 días --> Corresponde a Julio");
                        break; 
                    case 8:
                        System.out.println("Mes de 31 días --> Corresponde a Agosto");
                        break; 
                    case 9:
                        System.out.println("Mes de 30 días --> Corresponde a Septiembre");
                        break; 
                    case 10:
                        System.out.println("Mes de 31 días --> Corresponde a Octubre");
                        break; 
                    case 11:
                        System.out.println("Mes de 30 días --> Corresponde a Noviembre");
                        break; 
                    case 12:
                        System.out.println("Mes de 31 días --> Corresponde a Diciembre");
                        break; 
                    default:
                        System.out.println("Incorrect Month...");
                        break;
                }
                CorrectValue = true;
            } catch (Exception e) {
                showError(e, sc);
            }
        }
    }

    private static void exercise10(Scanner sc){
        int Hours, Minutes, Seconds;
        boolean CorrectValues = false, CorrectHour, CorrectMinute, CorrectSecond;
        
        while(!CorrectValues){
            try {
                clearScreen();
                Hours = inputInt("Please enter the hours: ", sc);
                Minutes = inputInt("Please enter the minutes: ", sc);
                Seconds = inputInt("Please enter the seconds: ", sc);

                CorrectHour = Hours >= 1 && Hours <= 12;
                CorrectMinute = Minutes >= 0 && Minutes <= 59;
                CorrectSecond = Seconds >= 0 && Seconds <= 59;
                if (CorrectHour && CorrectMinute && CorrectSecond){
                    System.out.println("The hour that you indicate is correct");
                }else{
                    System.out.println("Invalid hour");
                }
                CorrectValues = true;
            } catch (Exception e) {
                showError(e, sc);
            }
        }
    }

    private static int greater(int Num1, int Num2){
        return (Num1 > Num2) ? Num1 : Num2;
    }

    private static void exercise9(Scanner sc){
        int Num1, Num2, Num3, GreatestNum;
        boolean CorrectValue = false;

        while(!CorrectValue){
            try {
                clearScreen();
                Num1 = inputInt("Please enter the first integer value: ", sc);
                Num2 = inputInt("Please enter the second integer value: ", sc);
                Num3 = inputInt("Please enter the third integer value: ", sc);
                GreatestNum = greater(Num3, greater(Num1, Num2));
                System.out.printf("The greatest number of %d, %d, %d is --> %d %n", Num1, Num2, Num3, GreatestNum);
                CorrectValue = true;
            } catch (Exception e) {
                showError(e, sc);
            }
        }
    }

    private static void exercise8(Scanner sc){
        boolean CorrectValue = false;

        while(!CorrectValue){
            try {
                clearScreen();
                var Num1 = inputDouble("Please enter the first number: ", sc);
                var Num2 = inputDouble("Plase enter the second number: ", sc);
                if (Num2 == 0){
                    System.out.println("The division by 0 is not definied...");
                }else{
                    var Result = Num1 / Num2;
                    System.out.printf("The result of the divition is --> %1.3f", Result);
                }
                CorrectValue = true;
            } catch (Exception e) {
                showError(e, sc);
            }
        }
    }

    private static void exercise7(Scanner sc){
        char charact;
        boolean CorrectValue = false;

        while(!CorrectValue){
            try {
                clearScreen();
                charact = inputChar("Please enter the letter: ", sc);
                if (Character.isAlphabetic(charact)){
                    if (Character.isUpperCase(charact)){
                        System.out.println("The letter is an uppercase letter");
                    }else{
                        System.out.println("The letter is not an uppercase letter");
                    }
                }else{
                    System.out.println("The value that you entered is not a letter...");
                }
                CorrectValue = true;
            } catch (Exception e) {
                showError(e, sc);
            }
        }
    }

    private static void exercise6(Scanner sc){
        int Num;
        boolean CorrectValue = false;

        while(!CorrectValue){
            try {
                clearScreen();
                Num = inputInt("Please enter a number: ", sc);
                if (Num % 10 == 0){
                    System.out.printf("%d is multiple of 10 %n", Num);
                }else{
                    System.out.printf("%d isn't multiple of 10 %n", Num);
                }
                CorrectValue = true;
            } catch (Exception e) {
                showError(e, sc);
            }
        }
    }

    private static void exercise5(Scanner sc) {
        boolean CorrectValue = false;

        while(!CorrectValue){
            try {
                clearScreen();
                var cat1 = inputDouble("Please enter the value of one cathetus: ", sc);
                var cat2 = inputDouble("Please enter the value of the other cathetus: ", sc);
                var hyp = Math.sqrt(Math.pow(cat1, 2) + Math.pow(cat2, 2));
                System.out.print("Hypotenuse: " + hyp);
                CorrectValue = true;
            } catch (Exception e) {
                showError(e, sc);
            }
        }

    }

    private static void exercise4(Scanner sc){
        boolean CorrectValue = false;

        while (!CorrectValue){
            try {
                clearScreen();
                var Km = inputDouble("Please enter the Km: ", sc);
                var mt = (int) (Km * 1000);
                System.out.print(Km + " Km to meters --> " + mt);
                CorrectValue = true;
            } catch (Exception e) {
                showError(e, sc);
            }
        }
    }

    private static int amountOfDigits(int N){
        int counter = 0;
        while(N != 0){
            counter++;
            N /= 10;
        }
        return counter;
    }

    private static void exercise3(Scanner sc){
        int N, m;
        boolean correctValues = false;
        
        while(!correctValues){
            try {
                clearScreen();
                N = inputInt("Please enter the N value: ", sc);
                m = inputInt("Please enter the m value: ", sc);
                if (amountOfDigits(N) >= m){
                    int counter = 0;
                    while(counter < m){
                        counter++;
                        N /= 10;
                    }
                    System.out.printf("N: %d %n", N);
                    correctValues = true;
                }else{
                    clearScreen();
                    System.out.print("Incorrect...");
                    waitForInput(sc); 
                }
            } catch (Exception e) {
                showError(e, sc);
            }
        }        
    }

    private static void exercise2(Scanner sc){
        double PricePerUnit, IVA, PriceNoIva, TotalIva, TotalPrice;
        int AmountProducts;
        boolean CorrectValues = false;

        while(!CorrectValues){
            try {
                clearScreen();
                PricePerUnit = inputDouble("Please enter the Price per unit: ", sc);
                AmountProducts = inputInt("Please enter the amount of products: ", sc);
                IVA = inputDouble("Please enter the IVA value: ", sc);
        
                PriceNoIva = PricePerUnit * AmountProducts;
                TotalIva = PriceNoIva * (IVA / 100);
                TotalPrice = PriceNoIva + TotalIva;
        
                System.out.printf("Total price with IVA --> $%,d %n", (int) TotalPrice);
                CorrectValues = true;
            } catch (Exception e) {
                showError(e, sc);
            }
        }
    }

    private static void exercise1(Scanner sc) {
        byte Day = inputByte("Please enter your birthday: ", sc);
        byte Month = inputByte("Please enter your birth month: ", sc);
        byte LuckyDay = 0;
        int Year = inputInt("Please enter your birth year of birth: ", sc);

        int Sum = Day + Month + Year;
        
        while(Sum != 0){
            LuckyDay += Sum % 10;
            Sum /= 10;
        }
        clearScreen();
        System.out.println("Your Lucky day is: " + LuckyDay);
    }
}
