package com.cristian.desarrollo.modelo;

public class Directivo extends Empleado{

    private static final Double SUELDO_POR_DEFECTO = 1_000_000d;
    private static final String CATEGORIA_POR_DEFECTO = "N/A";
    
    private String categoria;
    private Integer cantSubordinados = 0;

    // Relacion de 0..* (El directivo puede tener n cantidad de empleados subordinados)
    Empleado[] subordinados;

    public Directivo(String nombre, Integer edad) {
        this(nombre, edad, CATEGORIA_POR_DEFECTO);
    }

    public Directivo(String nombre, Integer edad, String categoria){
        this(nombre, edad, categoria, SUELDO_POR_DEFECTO);
    }

    public Directivo(String nombre, Integer edad, Double sueldoBruto){
        this(nombre, edad, CATEGORIA_POR_DEFECTO, sueldoBruto);
    }

    public Directivo(String nombre, Integer edad, String categoria, Double sueldoBruto) {
        super(nombre, edad, sueldoBruto);
        this.categoria = categoria;
        subordinados = new Empleado[5];
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void agregarSubordinado(Empleado empleadoSubordinado){
        subordinados[cantSubordinados++] = empleadoSubordinado;
    }

    @Override
    public String mostrarInfo() {
        return String.format("El Directivo %s tiene edad %d, su sueldo bruto es de %,.2f y su categoria es %s", getNombre(), getEdad(), getSueldoBruto(), getCategoria());
    }

    
}
