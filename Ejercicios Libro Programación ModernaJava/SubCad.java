/* Construir un programa que muestre la palabra “versi” tomado de la
cadena “Universidad”*/
public class SubCad{
    public static void main(String args[]){
        String palab = "Universidad", subCad;
        subCad = palab.substring(3, 8);
        System.out.println("La subcadena de la palabra ".concat(palab.concat(" es ".concat(subCad))));
    }
}