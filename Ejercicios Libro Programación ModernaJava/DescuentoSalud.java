/*Construir un programa Java que permita leer su salario y determinar
cuánto le descuentan por salud si se sabe que este descuento equivale
al 12% de dicho salario */

import javax.swing.JOptionPane;

public class DescuentoSalud{
    public static void main(String args[]){
        String entrSalario, entrDesc;
        double Salario, Descuento, SalarioFinal;

        entrSalario = JOptionPane.showInputDialog("Ingrese su salario");
        entrDesc = JOptionPane.showInputDialog("Ingrese el descuento en porcentaje que le hacen por salud");

        Salario = Double.parseDouble(entrSalario);
        Descuento = (Double.parseDouble(entrDesc) / 100) * Salario;
        SalarioFinal = Salario - Descuento;

        System.out.printf("Su salario es de $%,d %n", (int) Salario);
        System.out.printf("El descuento de %s%% de su salario equivale a $%,d %n", entrDesc, (int) Descuento);
        System.out.printf("Por lo tanto tu salario final será de $%,d %n", (int) SalarioFinal);
    }
}