public class Cadenas1{
    public static void main(String args[]){
        String Cad1 = "Universidad";
        System.out.println("Cadena -->" + Cad1);
        
        //Calcula el numero de caracteres de una cadena
        System.out.println("Cantidad de caracteres = " + Cad1.length());

        //Muestra un caracter en determinada posición de una cadena
        System.out.println("Posicion 3, Caracter --> " + Cad1.charAt(3));
        System.out.println("Posicion 7, Caracter --> " + Cad1.charAt(7));
        System.out.println("Posición 9, Caracter --> " + Cad1.charAt(9));

        //Muestra una subcadena que comienza en ini y tiene num caracteres
        System.out.println("Subcadena Inicio 4 Longitud 8 --> " + Cad1.substring(4, 8));

        //Retorna verdadero si dos cadenas son iguales
        String Cad2 = "Universo";
        System.out.println(Cad2 + " igual a " + Cad1 + "? --> " + Cad1.equals(Cad2));

        //Retorna Verdadedro si dos cadenas son iguales (Asume Mayusculas y minusculas iguales)
        String Cad3 = "UnIvErSiDaD";
        System.out.println(Cad3 + " igual a " + Cad1 + " ? --> " + Cad1.equalsIgnoreCase(Cad3));

        //Comparación lexicografica de dos cadenas
        System.out.println(Cad1 + " comparada con " + Cad3 + " ? --> " + Cad1.compareTo(Cad3));

        //Concatena dos cadenas
        System.out.println("Dos cadenas concatenadas " + Cad1.concat(Cad3));

        //Verifica si una cadena esta contenida en otra
        String Cad4 = "ver";
        System.out.println(Cad4 + " está contenida en " + Cad1 + " ? --> " + Cad1.contains(Cad4));

        //Verifica si una cadena finaliza con un sufijo
        System.out.println("Cadena " + Cad1 + " Sufijo = idad " + Cad1.endsWith("idad"));

        //Determina si una cadena está vacía
        String Cad5 = "";
        System.out.println("Cadena está vacía? --> " + Cad5.isEmpty());

        //Verifica si una cadena comienza con un prefijo
        System.out.println("Cadena " + Cad1 + " Prefijo = univ " + Cad1.startsWith("univ"));
    }
}