package com.cristian.desarrollo.controlador;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.cristian.desarrollo.dao.AdicionalDao;
import com.cristian.desarrollo.dao.CorrientazoDao;
import com.cristian.desarrollo.dao.MesaDao;
import com.cristian.desarrollo.dao.OpcionCarneDao;
import com.cristian.desarrollo.dao.OpcionEnsaladaDao;
import com.cristian.desarrollo.dao.OpcionJugoDao;
import com.cristian.desarrollo.dao.OpcionPrincipioDao;
import com.cristian.desarrollo.dao.OpcionSopaDao;
import com.cristian.desarrollo.dao.PedidoAdicionalDao;
import com.cristian.desarrollo.dao.PedidoDao;
import com.cristian.desarrollo.exception.EstadoException;
import com.cristian.desarrollo.exception.PagoException;
import com.cristian.desarrollo.modelo.Adicional;
import com.cristian.desarrollo.modelo.EstadoPedido;
import com.cristian.desarrollo.modelo.Mesa;
import com.cristian.desarrollo.modelo.OpcionCarne;
import com.cristian.desarrollo.modelo.OpcionEnsalada;
import com.cristian.desarrollo.modelo.OpcionJugo;
import com.cristian.desarrollo.modelo.OpcionPrincipio;
import com.cristian.desarrollo.modelo.OpcionSopa;
import com.cristian.desarrollo.modelo.Pedido;
import com.cristian.desarrollo.vista.AdicionalVista;
import com.cristian.desarrollo.vista.MenuPrincipal;
import com.cristian.desarrollo.vista.MesaVista;
import com.cristian.desarrollo.vista.PedidoVista;

public class RestauranteControlador {
    // Vistas
    private MenuPrincipal menuPrincipal;
    private MesaVista mesaVista;
    private PedidoVista pedidoVista;
    private AdicionalVista adicionalVista;

    // Data Access Object
    private MesaDao mesaDao;
    private PedidoDao pedidoDao;
    private OpcionSopaDao sopaDao;
    private OpcionPrincipioDao principioDao;
    private OpcionCarneDao carneDao;
    private OpcionEnsaladaDao ensaladaDao;
    private OpcionJugoDao jugoDao;
    private CorrientazoDao corrientazoDao;
    private AdicionalDao adicionalDao;
    private PedidoAdicionalDao pedidoAdicionalDao;

    // Entrada teclado
    private Scanner sc;

    public RestauranteControlador(Scanner sc) {
        // Teclado
        this.sc = sc;
        
        // Vistas
        this.menuPrincipal = new MenuPrincipal(sc, this);
        this.mesaVista = new MesaVista(this, sc);
        this.pedidoVista = new PedidoVista(this, sc);
        this.adicionalVista = new AdicionalVista(this, sc);

        // Data Access Object
        this.mesaDao = new MesaDao();
        this.pedidoDao = new PedidoDao();
        this.sopaDao = new OpcionSopaDao();
        this.principioDao = new OpcionPrincipioDao();
        this.carneDao = new OpcionCarneDao();
        this.ensaladaDao = new OpcionEnsaladaDao();
        this.jugoDao = new OpcionJugoDao();
        this.corrientazoDao = new CorrientazoDao();
        this.adicionalDao = new AdicionalDao();
        this.pedidoAdicionalDao = new PedidoAdicionalDao();
    }

    public Mesa consultarMesa() throws SQLException {
        return mesaVista.consultarMesa();
    }

    public void mostrarPedidos(Mesa mesa) throws SQLException {
        mesaVista.mostrarPedidos(mesa);
    }

    public List<Pedido> getPedidos(Mesa mesa) throws SQLException{
        return pedidoDao.listar(mesa);
    }

    public List<Adicional> getAdicionales(Mesa mesa, Pedido pedido) throws SQLException {
        return adicionalDao.listar(mesa, pedido);
    }   

    public List<Mesa> getMesas() throws SQLException {
        return mesaDao.listar();
    }

    public List<OpcionSopa> getSopas() throws SQLException {
        return sopaDao.listar();
    }

    public List<OpcionPrincipio> getPrincipios() throws SQLException {
        return principioDao.listar();
    }

    public List<OpcionCarne> getCarnes() throws SQLException {
        return carneDao.listar();
    }

    public List<OpcionEnsalada> getEnsaladas() throws SQLException {
        return ensaladaDao.listar();
    }

    public List<OpcionJugo> getJugos() throws SQLException {
        return jugoDao.listar();
    }

    public void iniciarAplicacion() throws SQLException {
        menuPrincipal.iniciarAplicacion();
    }

    public void agregarPedido(Mesa mesa) throws SQLException {
        // Pedir informacion del pedido
        Pedido pedido = pedidoVista.pedirInformacionPedido(mesa.getId());
        
        // Agregar el pedido a la BBDD
        this.pedidoDao.agregar(pedido, mesa);

        // Guardar el corrientazo del pedido en BBDD
        this.corrientazoDao.guardar(pedido.getAlmuerzo());

        //Avisar al usuario
        pedidoVista.mostrarMensaje("PEDIDO AGREGADO EXITOSAMENTE!!");
    }

    public void agregarAdicional(Mesa mesa) {
        
        try {
            // Pedir informacion del adicional
            Adicional adicional = adicionalVista.pedirInformacionAdicional(mesa);

            // Agregar adicional a BBDD
            adicionalDao.guardar(adicional, mesa);
            
            // Buscar el pedido
            var pedidos = getPedidos(mesa);
            Pedido pedido = buscarPedidoPorId(pedidos, adicional.getIdPedido());
            
            pedido.agregarAdicional(adicional);

            // Agregar adicional al pedido especificado
            pedidoAdicionalDao.guardar(pedido, adicional, mesa);
            
            adicionalVista.mostrarMensaje("MENSAJE: ADICIONAL AGREGADO EXITOSAMENTE!!");
        } catch (SQLException e) {
            adicionalVista.mostrarMensaje("MENSAJE: ERROR AL BUSCAR PEDIDOS EN BBDD: " + e);
        }catch( InputMismatchException e){
            adicionalVista.mostrarMensaje("MENSAJE: ERROR AL LEER EL ID: " + e);
        }
    }

    public Pedido buscarPedidoPorId(List<Pedido> pedidos, Integer idPedido) {
        Pedido pedidoEncontrado = null;
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == idPedido){
                pedidoEncontrado = pedido;
                break;
            }
        }
        return pedidoEncontrado;
    }

    public void entregarPedido(Mesa mesa) {
        try {
            // Pedir el id del pedido a entregar
            Integer idPedido = pedidoVista.pedirIdPedido();

            // Buscar el pedido
            var pedidos = getPedidos(mesa);
            Pedido pedido = buscarPedidoPorId(pedidos, idPedido);

            // Cambiar el estado del pedido 
            if (pedido.getEstado() == EstadoPedido.PENDIENTE_COBRAR){
                throw new EstadoException("MENSAJE: El pedido ya se encuentra en estado " + EstadoPedido.PENDIENTE_COBRAR.toString());
            }else{
                pedidoDao.entregarPedido(mesa, pedido);
            }
            // Avisar al usuario
            pedidoVista.mostrarMensaje("MENSAJE: Pedido Entregado Correctamente");
        } catch (InputMismatchException e) {
            pedidoVista.mostrarMensaje("ERROR: Valor no valido ->" + e.getMessage());
        }catch (SQLException e){
            pedidoVista.mostrarMensaje("ERROR: Error en la BBDD -> " + e.getMessage());
        }catch (EstadoException e){
            pedidoVista.mostrarMensaje(e.getMessage());
        }
    }

    public void pagarCuenta(Mesa mesa){

        try {
            var pedidos = getPedidos(mesa)
                    .stream()
                    .filter(pedido -> pedido.getEstado() == EstadoPedido.PENDIENTE_COBRAR)
                    .collect(Collectors.toList());

            Integer cuentaPedidos = 0;
            for (Pedido pedido : pedidos) {
                cuentaPedidos += pedido.getAlmuerzo().getPrecio();
            }

            Integer valorAdicionales = 0;
            for (Pedido pedido : pedidos) {
                for (Adicional adicional : getAdicionales(mesa, pedido)) {
                    valorAdicionales += adicional.getPrecio();
                }
            }

            Integer cuentaMesa = cuentaPedidos + valorAdicionales;

            mesaVista.mostrarMensaje(String.format("La cuenta es $%,d", cuentaMesa));
            Integer efectivo = mesaVista.pedirEfectivo();
            
            Integer devuelta = efectivo - cuentaMesa;

            if (efectivo < cuentaMesa)
                throw new PagoException("El valor del efectivo no es suficiente para pagar la cuenta.");
            
            mesaVista.mostrarMensaje(String.format("MENSAJE: La devuelta es -> $%,d", devuelta));
            mesaVista.mostrarMensaje("MENSAJE: Cuenta pagada correctamente");
        } catch (SQLException e) {
            mesaVista.mostrarMensaje("MENSAJE: ERROR EN BBDD -> " + e.getMessage());
        } catch (PagoException e){
            mesaVista.mostrarMensaje("MENSAJE: " + e.getMessage());
        }
    }
}
