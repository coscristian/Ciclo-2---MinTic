package com.cristian.desarrollo.modelo;

public class Empresa {
    private String nombre;
    private Integer contadorEmpleados = 0;
    private Integer contadorClientes = 0;

    // Relacion de 0..* (La empresa puede tener 0 o n clientes)
    Cliente[] clientes; 
    // Relacion de 1..* (La empresa debe tener por lo menos un empleado)
    Empleado[] empleados;

    // Crear empresa solo dandole el nombre
    public Empresa(String nombre) {
        this(nombre, new Empleado[10], new Cliente[100]);
    }

    // Crear empresa dandole el nombre y los empleados
    public Empresa(String nombre, Empleado[] empleados){
        this(nombre, empleados, new Cliente[100]);
    }

    // Crear empresa dandole el nombre y los clientes
    public Empresa(String nombre, Cliente[] clientes){
        this(nombre, new Empleado[10], clientes);        
    }

    // Crear empresa dandole el nombre, los empleados y los clientes
    public Empresa(String nombre, Empleado[] empleados, Cliente[] clientes){
        this.nombre = nombre;
        this.empleados = empleados;
        this.clientes = clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public Cliente[] getClientes(){
        return clientes;
    }

    public Empleado[] getEmpleados(){
        return empleados;
    }

    public void agregarEmpleado(Empleado nuevoEmpleado){
        empleados[contadorEmpleados++] = nuevoEmpleado;
    }

    public void agregarCliente(Cliente nuevoCliente){
        clientes[contadorClientes++] = nuevoCliente;
    }
}
