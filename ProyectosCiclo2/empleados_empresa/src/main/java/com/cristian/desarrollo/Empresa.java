package com.cristian.desarrollo;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.cristian.desarrollo.excepciones.MaximoNumeroClientesException;

public class Empresa {
    private String nombre;
    // La relacion siempre debe ser un atributo
    protected static final Integer CANTIDAD_CLIENTES = 1;

    //private Empleado[] empleados; // Relacion de 1 a *
    private List<Empleado> empleados;
    //private Cliente[] clientes;
    private List<Cliente> clientes;

    public Empresa(String nombre) {
        this.nombre = nombre;
    }  

    // La unica forma de crear una empresa es darle un nombre y la lista de empleados
    public Empresa(String nombre, List<Empleado> empleados) {
        this.nombre = nombre;
        this.empleados = empleados;

        this.clientes = new ArrayList<>();
    }

    // Si el tipo de error es de los verdes, debo decirle explicitamente que el metodo puede lanzar una excepcion
    public void agregarCliente(Cliente cliente){
        // Primero valido, luego proceso
        clientes.add(cliente);
    }

    public String getNombre(){
        return nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void eliminarCliente(Cliente cliente){
        // Forma 1
        clientes.remove(cliente);
        //Forma 2
/*         var pos = clientes.indexOf(cliente);
        if(pos!= -1){
            clientes.remove(pos);
        }else{
            throw new RuntimeErrorException("El cliente no pertenece a esta empresa");
        } */
    }

}
