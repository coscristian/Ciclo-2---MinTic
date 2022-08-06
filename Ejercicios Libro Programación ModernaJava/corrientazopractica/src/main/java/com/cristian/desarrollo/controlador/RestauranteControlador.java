package com.cristian.desarrollo.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cristian.desarrollo.modelo.Mesa;
import com.cristian.desarrollo.vista.MenuPrincipal;
import com.cristian.desarrollo.vista.MesaVista;
import com.cristian.desarrollo.vista.PedidoVista;

public class RestauranteControlador {
    private MenuPrincipal menuPrincipal;
    private MesaVista mesaVista;
    private PedidoVista pedidoVista;
    private List<Mesa> mesas;
    private Scanner sc;

    public RestauranteControlador(Scanner sc) {
        this.menuPrincipal = new MenuPrincipal(sc, this);
        this.mesaVista = new MesaVista(this, sc);
        //this.pedidoVista = pedidoVista;
        this.mesas = new ArrayList<>();
        this.sc = sc;
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

    public void cargarBaseDatos() {
        this.mesas.add(new Mesa("01"));
        this.mesas.add(new Mesa("02"));
        this.mesas.add(new Mesa("03"));
        this.mesas.add(new Mesa("04"));
        this.mesas.add(new Mesa("05"));
        this.mesas.add(new Mesa("06"));
        this.mesas.add(new Mesa("07"));
    }

    public void iniciarAplicacion() {
        menuPrincipal.iniciarAplicacion();
    }
    
}
