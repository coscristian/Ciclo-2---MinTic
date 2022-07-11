package com.cristian.desarrollo;

public class App {
    public static void main( String[] args ){
        
        // Contrayentes 
        Contrayente contrayente1 = new Contrayente("Juan", "Medina", "24");
        Contrayente contrayente2 = new Contrayente("Camila", "Gonzales");
        
        // Testigos
        Testigo testigo1 = new Testigo("Carlos", "Villareal", "30", 'M');
        Testigo testigo2 = new Testigo("Sebastian", "Giraldo");
        Testigo testigo3 = new Testigo("Andrea", "Henao", "27", 'F');
        
        // Matrimonio
        var matrimonio1 = new Matrimonio("07/07/2022", "Pereira");
        // Agregando los contrayentes del matrimonio
        matrimonio1.agregarContrayentes(contrayente1, contrayente2);
        // Agregando testigos al matrimonio
        matrimonio1.agregarTestigo(testigo1);
        matrimonio1.agregarTestigo(testigo2);
        matrimonio1.agregarTestigo(testigo3);

        System.out.println(matrimonio1.mostrarInfo());


    }
}
