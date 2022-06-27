package Básicos;
/*Construir un programa que determine si la palabra “ver” está contenida
en la cadena “Universidad” */
public class PalabContenida{
    public static void main(String args[]){
        String cad1 = "Universidad", subCad = "ver";
        System.out.println("La subcadena ".concat(subCad).concat(" está contenida en ".concat(cad1).concat(" --> ") + cad1.contains(subCad)));
    }
}