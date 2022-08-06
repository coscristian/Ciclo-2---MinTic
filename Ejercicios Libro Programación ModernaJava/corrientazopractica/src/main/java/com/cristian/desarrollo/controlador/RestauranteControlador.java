package com.cristian.desarrollo.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cristian.desarrollo.modelo.Adicional;
import com.cristian.desarrollo.modelo.Corrientazo;
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

public class RestauranteControlador {
    private MenuPrincipal menuPrincipal;
    private MesaVista mesaVista;
    private PedidoVista pedidoVista;
    private List<Mesa> mesas;

    private List<OpcionSopa> sopas;
    private List<OpcionPrincipio> principios;
    private List<OpcionCarne> carnes;
    private List<OpcionEnsalada> ensaladas;
    private List<OpcionJugo> jugos;
    private Scanner sc;

    public RestauranteControlador(Scanner sc) {
        this.menuPrincipal = new MenuPrincipal(sc, this);
        this.sc = sc;

        this.mesaVista = new MesaVista(this, sc);
        this.pedidoVista = new PedidoVista(this, sc);

        this.mesas = new ArrayList<>();

        this.sopas = new ArrayList<>();
        this.principios = new ArrayList<>();
        this.carnes = new ArrayList<>();
        this.ensaladas = new ArrayList<>();
        this.jugos = new ArrayList<>();
    }

    public Mesa consultarMesa() {
    
        return mesaVista.consultarMesa();
    }

    public void mostrarPedidos(Mesa mesa) {
        mesaVista.mostrarPedidos(mesa);
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public List<OpcionSopa> getSopas() {
        return sopas;
    }

    public void setSopas(List<OpcionSopa> sopas) {
        this.sopas = sopas;
    }

    public List<OpcionPrincipio> getPrincipios() {
        return principios;
    }

    public void setPrincipios(List<OpcionPrincipio> principios) {
        this.principios = principios;
    }

    public List<OpcionCarne> getCarnes() {
        return carnes;
    }

    public void setCarnes(List<OpcionCarne> carnes) {
        this.carnes = carnes;
    }

    public List<OpcionEnsalada> getEnsaladas() {
        return ensaladas;
    }

    public void setEnsaladas(List<OpcionEnsalada> ensaladas) {
        this.ensaladas = ensaladas;
    }

    public List<OpcionJugo> getJugos() {
        return jugos;
    }

    public void setJugos(List<OpcionJugo> jugos) {
        this.jugos = jugos;
    }

    public void cargarBaseDatos() {
        this.mesas.add(new Mesa("01"));
        this.mesas.add(new Mesa("02"));
        this.mesas.add(new Mesa("03"));
        this.mesas.add(new Mesa("04"));
        this.mesas.add(new Mesa("05"));
        this.mesas.add(new Mesa("06"));
        this.mesas.add(new Mesa("07"));

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

/*         var almuerzo1 = new Corrientazo(12_000,
                        new OpcionSopa("Queso"),
                        new OpcionPrincipio("Fijoles"),
                        new OpcionCarne("Res Plancha"),
                        new OpcionEnsalada("Dulce"),
                        new OpcionJugo("Lulo"));

        var almuerzo2 = new Corrientazo(12_000,
                        new OpcionSopa("Patacón"),
                        new OpcionPrincipio("Guiso Patacón"),
                        new OpcionCarne("Punta de anca"),
                        new OpcionEnsalada("Remolacha"),
                        new OpcionJugo("Maracuyá"));

        Pedido cristian = new Pedido("Cristian", almuerzo1); 
        Pedido juan = new Pedido("Juan", almuerzo2); 
        
        cristian.agregarAdicional(new Adicional("Ajiaco", 2_000));

        mesas.get(0).agregarPedido(cristian);     
        mesas.get(0).agregarPedido(juan);  
        
        cristian.entregarPedido(); */
    }

    public void iniciarAplicacion() {
        menuPrincipal.iniciarAplicacion();
    }

    public void agregarPedido(Mesa mesa) {
        // Pedir informacion del pedido
        Pedido pedido = pedidoVista.pedirInformacionPedido();

        //Agregar el pedido a la mesa
        mesa.agregarPedido(pedido);

        //Avisar al usuario
        pedidoVista.mostrarMensaje("PEDIDO AGREGADO EXITOSAMENTE!!");
    }

	public void agregarAdicional(Mesa mesa) {

	}
    
}
