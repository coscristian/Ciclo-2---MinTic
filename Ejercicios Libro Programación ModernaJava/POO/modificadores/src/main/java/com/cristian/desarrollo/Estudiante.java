package com.cristian.desarrollo;

public class Estudiante {
    private String nombre;
    private String apellidos;
    private final String codigo;
    private String direccion;
    private String edad;
    private static Integer cantEstudiantes = 0;

    public Estudiante(String nombre, String apellidos, String codigo, String direccion, String edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.codigo = codigo;
        this.direccion = direccion;
        this.edad = edad;
        cantEstudiantes += 1;
    }

    public Integer getCantEstudiantes() {
        return cantEstudiantes;
    }
}
