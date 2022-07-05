/*Construir un programa Java que permita diseñar una solución para
realizar un descuento para todos los estudiantes que se matriculen en
un colegio y además para que los estudiantes de estratos 1 y 2 reciban
un descuento adicional, aprovechando el concepto de herencia entre
interfaces */

package com.cristian.desarrollo;
import javax.swing.JOptionPane;

public class ProgramaColegio {
    public static void main(String[] args) {
        String nombre;
        String codigo;
        String edad;
        Character estrato;

        double valorMatricula;
        double valorServEspeciales;
        double valorDescuentoMatricula;
        double valorDescuentoServEsp = 0;
        double valorRealMatricula;

        double porcDescuento;
        double porcDescuentoServEsp;
        
        // Arreglo para estudiantes
        Estudiante[] estudiantes = new Estudiante[3];

        // Descuentos
        porcDescuento = Double.parseDouble(JOptionPane.showInputDialog("Ingrese en porcentaje el valor de descuento general"));
        porcDescuentoServEsp = Double.parseDouble(JOptionPane.showInputDialog("Ingrese en porcentaje el valor de descuento para los estratos 1 y 2"));

        // Datos estudiantes
        for (int i = 0; i < 3; i++) {
            nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante " + (i+1));
            codigo = JOptionPane.showInputDialog("Ingrese el codigo del estudiante" ) + (i+1);
            edad = JOptionPane.showInputDialog("Ingrese la edad del estudiante " + (i+1));
            estrato = JOptionPane.showInputDialog("Ingrese el estrato del estudiante " + (i+1)).charAt(0);
            valorMatricula = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de la matricula del estudiante " + (i+1)));
            valorServEspeciales = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de los servicios especiales " + (i+1)));

            //Instacias de Estudiante
            Estudiante estudiante = new Estudiante(nombre, codigo, edad, estrato, valorMatricula, valorServEspeciales);
            
            // Calculo del Descuentos a los estudiantes
            // Descuento general a todos los estudiantes
            valorMatricula = estudiante.getValorMatricula();
            valorDescuentoMatricula = estudiante.calcularDescuentoMatricula(porcDescuento, valorMatricula);
            estudiante.setvalorDescuentoMatricula(valorDescuentoMatricula);
            
            //Descuento dependiendo del estrato
            if (estudiante.getEstrato() == '1' || estudiante.getEstrato() == '2'){
                valorServEspeciales = estudiante.getValorServEspeciales();
                valorDescuentoServEsp = estudiante.calcularDescuentoServEspeciales(porcDescuentoServEsp, valorServEspeciales);
                estudiante.setvalorDescuentoServEsp(valorDescuentoServEsp);
            }

            // Calculo de los valores finales a pagar  
            estudiante.setValorRealMatricula(valorMatricula - valorDescuentoMatricula);
            estudiante.setValorRealServEspeciales(valorServEspeciales - valorDescuentoServEsp);
            valorRealMatricula = estudiante.getValorRealMatricula() + estudiante.getValorRealServEspeciales();
            estudiante.setvalorRealaPagar(valorRealMatricula);

            //Agrego el estudiante al arrray de estudiantes
            estudiantes[i] = estudiante;
        }

        int cont = 0;
        for ( Estudiante e : estudiantes){
            System.out.println("Estudiante " + (cont+1));
            System.out.println("\tNombre:\t" + e.getNombre());
            System.out.println("\tCódigo:\t" + e.getCodigo());
            System.out.println("\tEdad:\t" + e.getEdad());
            System.out.println("\tEstrato:\t" + e.getEstrato());
            
            System.out.println("\n\t\tValor Matricula:\t" + e.getValorMatricula());
            System.out.println("\t\tValor Desc Matr:\t" + e.getValorDescuentoMatricula());
            System.out.println("\t\tValor Real Matric:\t" + e.getValorRealMatricula());
            
            System.out.println("\n\t\tValor Servicios:\t" + e.getValorServEspeciales());
            System.out.println("\t\tValor Desc Serv:\t" + e.getValorDescuentoServEsp());
            System.out.println("\t\tValor Real Serv:\t" + e.getValorRealServEspeciales());

            System.out.println("\n\n\t\tValor Total a Pagar:\t" + e.getvalorRealaPagar());
        }

    }
}
