package com.cristian.desarrollo;

public class Empleado {
    private final String id;
    private String nombreCompleto;
    private String edad;
    private static Integer cantEmpleados = 0;

    public Empleado(String id, String nombreCompleto, String edad){
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        cantEmpleados++;
    }

    public Empleado(String id){
        this(id, "Nuevo", "99");
    }

    public String mostrarInfo(){
        return "\n------------------" +
        "\nEmpleado N°\t" + cantEmpleados +
        "\nNombre\t" + nombreCompleto + 
        "\nID\t" + id +
        "\nEdad\t" + edad +  
        "\n------------------\n";
    } 

}
