/*Construir un programa Java que permita registrar los movimientos de
consignación y retiro sobre una cuenta bancaria por parte de su
propietario, desde la óptica del cuentahabiente, de manera que se pueda
controlar el saldo que se tiene en el banco */

package com.cristian.desarrollo;

public class Movimiento {
    private String nombreOrigen;
    private String nombreDestino;
    private final String banco = "Bancolombia";
    private String tipoMov;
    private Integer valorMov;
    private static Integer saldo = 50000;

    public Movimiento(String nombreOrigen, String nombreDestino, String tipoMov, Integer valorMov){
        this.nombreOrigen = nombreOrigen;
        this.nombreDestino = nombreDestino;
        this.tipoMov = tipoMov;
        this.valorMov = valorMov;

        if (this.tipoMov.equals("Consignacion")){
            if (this.nombreOrigen.equals("Cristian")){
                saldo = saldo - valorMov;
            }else if (this.nombreDestino.equals("Cristian")){
                saldo = saldo + valorMov;
            }
        }else if(this.tipoMov.equals("Retiro")){
            saldo = saldo - valorMov;
        }
    }

    public String mostrarInfo(){
        return "\n\n------------------\nMovimientos Cuenta Bancaria" +
        "\nTipo Mov:\t" + tipoMov +
        "\nBanco:\t" + banco + 
        "\nOrigen: \t" + nombreOrigen + 
        "\nDestino: \t" + nombreDestino + 
        "\nValor: $ \t" + valorMov + 
        "\n------------------\n";
    } 

    public static String mostrarSaldoDisponible(){
        return String.format(
            "\n\n**************************" +
            "\nSaldo Actual" +  
            "\n**************************\n\t" + 
            "$%,d", saldo
            );
    }
}
