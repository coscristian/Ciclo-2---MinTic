package com.cristian.desarrollo.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cristian.desarrollo.dao.MesaDao;
import com.cristian.desarrollo.dao.OpcionCarneDao;
import com.cristian.desarrollo.dao.OpcionPrincipioDao;
import com.cristian.desarrollo.dao.OpcionSopaDao;
import com.cristian.desarrollo.dao.PedidoDao;
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
    private MesaDao mesaDao;
    private PedidoDao pedidoDao;
    private OpcionSopaDao sopaDao;
    private OpcionPrincipioDao principioDao;
    private OpcionCarneDao carneDao;


    private List<OpcionSopa> sopas;
    private List<OpcionPrincipio> principios;
    private List<OpcionCarne> carnes;
    private List<OpcionEnsalada> ensaladas;
    private List<OpcionJugo> jugos;
    private Scanner sc;

    public RestauranteControlador(Scanner sc) {
        // Vistas
        this.menuPrincipal = new MenuPrincipal(sc, this);
        this.mesaVista = new MesaVista(this, sc);
        this.pedidoVista = new PedidoVista(this, sc);
        this.sc = sc;

        // Data Access Object
        this.mesaDao = new MesaDao();
        this.pedidoDao = new PedidoDao();
        this.sopaDao = new OpcionSopaDao();
        this.principioDao = new OpcionPrincipioDao();
        this.carneDao = new OpcionCarneDao();

        // Listas alimentos corrientazo
        this.sopas = new ArrayList<>();
        this.principios = new ArrayList<>();
        this.carnes = new ArrayList<>();
        this.ensaladas = new ArrayList<>();
        this.jugos = new ArrayList<>();
    }

    public Mesa consultarMesa() throws SQLException {
        return mesaVista.consultarMesa();
    }

    public void mostrarPedidos(Mesa mesa) throws SQLException {
        //pedidoDao.listar(mesa);
        //mesaVista.mostrarPedidos(mesa);
    }

    public List<Mesa> getMesas() throws SQLException {
        return mesaDao.listar();
    }

    public List<OpcionSopa> getSopas() throws SQLException {
        return sopaDao.listar();
    }

    public void setSopas(List<OpcionSopa> sopas) {
        this.sopas = sopas;
    }

    public List<OpcionPrincipio> getPrincipios() throws SQLException {
        return principioDao.listar();
    }

    public void setPrincipios(List<OpcionPrincipio> principios) {
        this.principios = principios;
    }

    public List<OpcionCarne> getCarnes() throws SQLException {
        return carneDao.listar();
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

    public void cargarBaseDatos() throws SQLException {
/*         this.mesaDao.guardar(new Mesa("01"));
        this.mesaDao.guardar(new Mesa("02"));
        this.mesaDao.guardar(new Mesa("03"));
        this.mesaDao.guardar(new Mesa("04"));
        this.mesaDao.guardar(new Mesa("05"));
        this.mesaDao.guardar(new Mesa("06"));
        this.mesaDao.guardar(new Mesa("07"));  */

/*         this.sopaDao.guardar(new OpcionSopa("Pasta"));
        this.sopaDao.guardar(new OpcionSopa("Sancocho"));
        this.sopaDao.guardar(new OpcionSopa("Crema Ahuyama"));
        this.sopaDao.guardar(new OpcionSopa("Patacón"));
        this.sopaDao.guardar(new OpcionSopa("Verduras"));
        this.sopaDao.guardar(new OpcionSopa("Ajiaco")); */

/*         this.principioDao.guardar(new OpcionPrincipio("Frijoles"));
        this.principioDao.guardar(new OpcionPrincipio("Lentejas"));
        this.principioDao.guardar(new OpcionPrincipio("Papa guisada"));
        this.principioDao.guardar(new OpcionPrincipio("Espaguetis")); */

/*         this.carneDao.guardar(new OpcionCarne("Res a la plancha"));
        this.carneDao.guardar(new OpcionCarne("Cerdo a la plancha"));
        this.carneDao.guardar(new OpcionCarne("Pechuga a la plancha"));
        this.carneDao.guardar(new OpcionCarne("Chicharrón"));
        this.carneDao.guardar(new OpcionCarne("Carne molida"));
        this.carneDao.guardar(new OpcionCarne("En Bistec")); */

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

        Pedido cristian = new Pedido("Cristian", almuerzo1, 1); 
        Pedido juan = new Pedido("Juan", almuerzo2, 1); 
        
        pedidoDao.agregar(cristian);
        pedidoDao.agregar(juan); */
        //cristian.agregarAdicional(new Adicional("Ajiaco", 2_000));

/*         mesas.get(0).agregarPedido(cristian);     
        mesas.get(0).agregarPedido(juan);  */ 
        
        //cristian.entregarPedido(); 
    }

    public void iniciarAplicacion() throws SQLException {
        menuPrincipal.iniciarAplicacion();
    }

    public void agregarPedido(Mesa mesa) throws SQLException {
        // Pedir informacion del pedido
        Pedido pedido = pedidoVista.pedirInformacionPedido(mesa.getId());

        // Agregar el pedido a la BBDD
        //this.pedidoDao.agregar(pedido);

        //Agregar el pedido a la mesa
        mesa.agregarPedido(pedido);

        //Avisar al usuario
        pedidoVista.mostrarMensaje("PEDIDO AGREGADO EXITOSAMENTE!!");
    }

	public void agregarAdicional(Mesa mesa) {

	}
    
}
