package com.cristian.desarrollo;

import java.util.ArrayList;
import java.util.List;

import com.cristian.desarrollo.excepciones.MaximoNumeroSubordinadosException;

public class Directivo extends Empleado{

    protected static final String CATEGORIA_POR_DEFECTO = "No asignado";
    protected static final Integer CANTIDAD_SUBORDINADOS = 1;
    
    private String categoria;
    private Integer numSubordinados;

    //Relacion directivo tiene a cargo 0 a n subordinados
    //Empleado[] subordinados;
    // Coleccion con la interfaz
    private List<Empleado> subordinados; // SI lo defino explicito, no hay necesidad de decrile el tipo al crearlo

    public Directivo(String nombre, Integer edad) {
        this(nombre, edad, SUELDO_POR_DEFECTO);
    }

    public Directivo(String nombre, Integer edad, Double sueldoBruto) {
        this(nombre, edad, sueldoBruto, CATEGORIA_POR_DEFECTO);
    }

    public Directivo(String nombre, Integer edad, String categoria) {
        this(nombre, edad, 0d, categoria);
    }

    public Directivo(String nombre, Integer edad, Double sueldoBruto, String categoria) {
        super(nombre, edad, sueldoBruto);
        this.categoria = categoria;
        this.subordinados = new ArrayList<>();
        this.numSubordinados = 0;
    }

    public String getCategoria() {
        return categoria;
    }

    public List<Empleado> getSubordinados() {
        return subordinados;
    }

    public void agregarSubordinado(Empleado empleado){

        subordinados.add(empleado);

        if (numSubordinados >= CANTIDAD_SUBORDINADOS){
            throw new MaximoNumeroSubordinadosException();
        }

/*         if(numSubordinados < CANTIDAD_SUBORDINADOS){
            subordinados[numSubordinados++] = empleado;
        }else{
            System.err.println("Err: El Directivo no puede agregar un empleado subordinado más.");
        } */
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public Double getSueldoBruto() {
        return super.getSueldoBruto() + 100_000d;
    }

    // Directivo hereda el metodo mostrar de Empleado pero la quiero modificar o sobreescribir
    @Override
    public void mostrarInfo() {
        System.out.printf("El Directivo de nombre %s tiene %d años, un sueldo de $ %,.2f y su categoria es %s %n",
        getNombre(), getEdad(), getSueldoBruto(), categoria);
    }

    

}
