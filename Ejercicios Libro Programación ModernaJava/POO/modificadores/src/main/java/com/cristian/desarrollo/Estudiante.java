package com.cristian.desarrollo;

public class Estudiante {
    private String nombre;
    private String apellidos;
    private final String codigo;
    private String direccion;
    private String edad;
    private String fechNac;
    private static Integer cantEstudiantes = 0;

    public Estudiante(String nombre, String apellidos, String codigo, String direccion, String edad, String fechNac) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.codigo = codigo;
        this.direccion = direccion;
        this.edad = edad;
        this.fechNac = fechNac;
        cantEstudiantes += 1;
    }

    public Estudiante(String nombre, String apellidos, String codigo, String direccion){
        this(nombre, apellidos, codigo, direccion, "1", "1000");
    }

    public static String mostrarCantEstudiantes() {
        return String.format(
            "\n\n**************************" +
            "\nEstudiantes Matriculados" +  
            "\n**************************\n\t" + 
            "%,d\n", cantEstudiantes
            );
    }
}
