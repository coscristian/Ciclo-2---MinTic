package com.cristian.desarrollo.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cristian.desarrollo.exception.PagoException;
import com.cristian.desarrollo.modelo.Mesa;
import com.cristian.desarrollo.modelo.OpcionCarne;
import com.cristian.desarrollo.modelo.OpcionEnsalada;
import com.cristian.desarrollo.modelo.OpcionJugo;
import com.cristian.desarrollo.modelo.OpcionPrincipio;
import com.cristian.desarrollo.modelo.OpcionSopa;
import com.cristian.desarrollo.modelo.Pedido;
import com.cristian.desarrollo.vista.MenuPrincipal;
import com.cristian.desarrollo.vista.MesaVista;
import com.cristian.desarrollo.vista.PedidoVista;

// Acciones que podrá hacer el usuario en el sistema
public class RestauranteControlador {
    private MenuPrincipal menuPrincipal;
    private MesaVista mesaVista;
    private List<Mesa> mesas;
    private PedidoVista pedidoVista;
    private List<OpcionSopa> sopas;
    private List<OpcionPrincipio> principios;
    private List<OpcionCarne> carnes;
    private List<OpcionEnsalada> ensaladas;
    private List<OpcionJugo> jugos;

    public RestauranteControlador(Scanner sc){
        this.menuPrincipal = new MenuPrincipal(sc, this);
        this.mesaVista = new MesaVista(sc, this);
        this.pedidoVista = new PedidoVista(sc, this);

        this.mesas = new ArrayList<>();

        this.sopas = new ArrayList<>();
        this.principios = new ArrayList<>();
        this.carnes = new ArrayList<>();
        this.ensaladas = new ArrayList<>();
        this.jugos = new ArrayList<>();
    }

    //TODO: Solo para las pruebas
    public void cargarBaseDatos(){
        mesas.add(new Mesa("01"));
        mesas.add(new Mesa("02"));
        mesas.add(new Mesa("03"));
        mesas.add(new Mesa("04"));
        mesas.add(new Mesa("05"));
        mesas.add(new Mesa("06"));
        mesas.add(new Mesa("07"));

        sopas.add(new OpcionSopa("Pasta"));
        sopas.add(new OpcionSopa("Sancocho"));
        sopas.add(new OpcionSopa("Crema Ahuyama"));
        sopas.add(new OpcionSopa("Patacón"));
        sopas.add(new OpcionSopa("Verduras"));
        sopas.add(new OpcionSopa("Ajiaco"));

        principios.add(new OpcionPrincipio("Frijoles"));
        principios.add(new OpcionPrincipio("Lentejas"));
        principios.add(new OpcionPrincipio("Papa guisada"));
        principios.add(new OpcionPrincipio("Espaguetis"));

        carnes.add(new OpcionCarne("Res a la plancha"));
        carnes.add(new OpcionCarne("Cerdo a la plancha"));
        carnes.add(new OpcionCarne("Pechuga a la plancha"));
        carnes.add(new OpcionCarne("Chicharrón"));
        carnes.add(new OpcionCarne("Carne molida"));
        carnes.add(new OpcionCarne("En Bistec"));

        ensaladas.add(new OpcionEnsalada("Solo tomate"));
        ensaladas.add(new OpcionEnsalada("Tomate y Cebolla"));
        ensaladas.add(new OpcionEnsalada("Dulce"));
        ensaladas.add(new OpcionEnsalada("Remolacha y Zahahoria"));

        jugos.add(new OpcionJugo("Limonada"));
        jugos.add(new OpcionJugo("Guayaba"));
        jugos.add(new OpcionJugo("Mora"));
        jugos.add(new OpcionJugo("Maracuya"));
        jugos.add(new OpcionJugo("Lulo"));
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public List<OpcionSopa> getSopas() {
        return sopas;
    }

    public List<OpcionPrincipio> getPrincipios() {
        return principios;
    }

    public List<OpcionCarne> getCarnes() {
        return carnes;
    }

    public List<OpcionEnsalada> getEnsaladas() {
        return ensaladas;
    }

    public List<OpcionJugo> getJugos() {
        return jugos;
    }
    
    public void crearMesa(){
        // Pedir al usuario la información necesaria para crear la mesa
        Mesa mesa = mesaVista.pedirInformacionMesa();

        // Almacenar la mesa
        this.mesas.add(mesa);

        // Listar las mesas que se encuentran en el sistema
        mesaVista.mostrarMesas(mesas);

    }

    public void agregarPedido(Mesa mesa){
        // Pedir al usuario la información del pedido
        var pedido = pedidoVista.pedirInformacionPedido();
        // Agregar el pedido a la mesa
        mesa.agregarPedido(pedido);
        // Mostrar confirmación de agregar el pedido
        pedidoVista.mostrarMensaje("Se ha recibido el pedido de " + pedido.getCliente());
    }

    public Mesa consultarMesa() {
        return mesaVista.consultarMesa();
    }

    public void entregarPedido(Mesa mesa) {
        // Seleccionar pedido de mesa
        Pedido pedido = mesaVista.seleccionePedido(mesa);

        // Marcar como entregado el pedido
        pedido.entregarPedido();
    }

    public void mostrarPedidos(Mesa mesa) {
        mesaVista.mostrarPedidos(mesa);
    }

    public void pagarCuenta(Mesa mesa) {
        var efectivo = mesaVista.leerValorEfectivo();

        try {
            // Valido si es suficiente para pagar
            var total = mesa.calcularValor();
            if(efectivo < total){
                throw new PagoException("El efectivo no es suficiente para cubrir la cuenta");
            }

            // Elimino los pedidos de la mesa
            mesa.limpiarPedidos();
            
            // Retorna la devuelta
            mesaVista.mostrarMensaje(String.format("La devuelta son: $ %,d",(efectivo - total)));
        } catch (Exception e) {
            mesaVista.mostrarMensaje(e.getMessage());   
        }
    }

    public void iniciarAplicacion() {
        menuPrincipal.iniciarAplicacion();
    }


}
