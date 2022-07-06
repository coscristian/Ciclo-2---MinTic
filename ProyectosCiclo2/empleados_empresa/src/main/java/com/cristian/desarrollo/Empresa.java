package com.cristian.desarrollo;

import com.cristian.desarrollo.excepciones.MaximoNumeroClientesException;

public class Empresa {
    private String nombre;
    // La relacion siempre debe ser un atributo
    protected static final Integer CANTIDAD_CLIENTES = 1;

    private Empleado[] empleados; // Relacion de 1 a *
    private Cliente[] clientes;
    private Integer numClientes;


    public Empresa(String nombre) {
        this.nombre = nombre;
    }  

    // La unica forma de crear una empresa es darle un nombre y la lista de empleados
    public Empresa(String nombre, Empleado[] empleados) {
        this.nombre = nombre;
        this.empleados = empleados;

        this.clientes = new Cliente[100];
        this.numClientes = 0;
    }

    // Si el tipo de error es de los verdes, debo decirle explicitamente que el metodo puede lanzar una excepcion
    public void agregarCliente(Cliente cliente) throws MaximoNumeroClientesException{
        // Primero valido, luego proceso
        if (numClientes >= CANTIDAD_CLIENTES){
            throw new MaximoNumeroClientesException("Err: No se pueden agregar mas clientes");
        }

        //Proceso

        if (numClientes < CANTIDAD_CLIENTES){
            clientes[numClientes++] = cliente;
        }else{
            System.err.println();
        }
    }

    public String getNombre(){
        return nombre;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

}
