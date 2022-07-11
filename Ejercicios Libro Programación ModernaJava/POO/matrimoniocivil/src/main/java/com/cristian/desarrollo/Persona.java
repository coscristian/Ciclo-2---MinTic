package com.cristian.desarrollo;

public abstract class Persona {

    private static final String EDAD_POR_DEFECTO = "N/A";
    private static final Character SEXO_POR_DEFECTO = '/';
    private static final String DIRECCION_POR_DEFECTO = "N/A";

    private String nombre;
    private String apellidos;
    private String edad;
    private Character sexo;
    private String direccion;

    public Persona(String nombre, String apellidos){
        this(nombre, apellidos, EDAD_POR_DEFECTO);
    }

    public Persona(String nombre, String apellidos, String edad){
        this(nombre, apellidos, edad, SEXO_POR_DEFECTO);
    }

    public Persona(String nombre, String apellidos, String edad, Character sexo){
        this(nombre, apellidos, edad, sexo, DIRECCION_POR_DEFECTO);
    }

    public Persona(String nombre, String apellidos, String edad, Character sexo, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sexo = sexo;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEdad() {
        return edad;
    }

    public Character getSexo() {
        return sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public abstract String mostrarInfo();
}
