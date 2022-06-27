package Básicos;
/*Construir un programa Java que permita leer su salario y determinar
cuánto ganará el próximo año si el incremento se sabe que será del 10% */

import javax.swing.JOptionPane;

public class IncrementoSalario{
    public static void main(String[] args) {
        String entrSalar, entrIncrem, respuesta;
        double Salario, Incremento, SalarioNuevo;;
        entrSalar = JOptionPane.showInputDialog("Ingrese su salario actual");
        entrIncrem = JOptionPane.showInputDialog("Ingrese el porcentaje a incrementar");
        
        Salario = Double.parseDouble(entrSalar);
        Incremento = (Double.parseDouble(entrIncrem) / 100) * Salario;
        SalarioNuevo = Salario + Incremento;

        respuesta = String.format("Su salario $%,d con un incremento del %s%% le queda en $%,d", (int) Salario, entrIncrem, (int) SalarioNuevo);
        System.out.println(respuesta);
    }
}