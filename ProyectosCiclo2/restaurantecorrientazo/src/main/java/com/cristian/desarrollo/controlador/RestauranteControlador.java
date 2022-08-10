package com.cristian.desarrollo.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.cristian.desarrollo.dao.MesaDao;
import com.cristian.desarrollo.dao.OpcionAlimentoDao;
import com.cristian.desarrollo.dao.OpcionSopaDao;
import com.cristian.desarrollo.dao.PedidoDao;

// Clase que se encarga de definir y administrar como se se va a acceder a la BBDD


import com.cristian.desarrollo.exception.PagoException;
import com.cristian.desarrollo.modelo.EstadoPedido;
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
    
    private MesaDao mesaDao;
    private OpcionSopaDao opcionSopaDao;
    private PedidoDao pedidoDao;
    private PedidoVista pedidoVista;
    private OpcionAlimentoDao<OpcionPrincipio> opcionPrincipioDao;
    private OpcionAlimentoDao<OpcionCarne> opcionCarneDao;
    private OpcionAlimentoDao<OpcionEnsalada> opcionEnsaladaDao;
    private OpcionAlimentoDao<OpcionJugo> opcionJugoDao;

    public RestauranteControlador(Scanner sc){
        this.menuPrincipal = new MenuPrincipal(sc, this);
        this.mesaVista = new MesaVista(sc, this);
        this.pedidoVista = new PedidoVista(sc, this);

        this.opcionSopaDao = new OpcionSopaDao();
        this.opcionPrincipioDao = new OpcionAlimentoDao<>("OpcionPrincipio");
        this.opcionCarneDao = new OpcionAlimentoDao<>("OpcionCarne");
        this.opcionEnsaladaDao = new OpcionAlimentoDao<>("OpcionEnsalada");
        this.opcionJugoDao = new OpcionAlimentoDao<>("OpcionJugo");
        
        this.mesaDao = new MesaDao();
        this.pedidoDao = new PedidoDao();
    }

    public List<Mesa> getMesas() throws SQLException {
        return mesaDao.listar();
    }

    public List<OpcionSopa> getSopas() throws SQLException {
        return opcionSopaDao.listar();
    }

    public List<OpcionPrincipio> getPrincipios() throws SQLException {
        return opcionPrincipioDao.listar(rset -> {
            try {
                var opcion = new OpcionPrincipio(rset.getString("nombre"));
                opcion.setId(rset.getInt("ID"));
                return opcion;    

            } catch (SQLException e) {
                return null;
            }
            
        });
    }

    public List<OpcionCarne> getCarnes() throws SQLException {
        return opcionCarneDao.listar(rset -> {
            try {
                var opcion = new OpcionCarne(rset.getString("nombre"));
                opcion.setId(rset.getInt("ID"));
                return opcion;    

            } catch (SQLException e) {
                return null;
            }
        });
    }

    public List<OpcionEnsalada> getEnsaladas() throws SQLException {
        return opcionEnsaladaDao.listar(rset -> {
            try {
                var opcion = new OpcionEnsalada(rset.getString("nombre"));
                opcion.setId(rset.getInt("ID"));
                return opcion;    

            } catch (SQLException e) {
                return null;
            }
        });
    }

    public List<OpcionJugo> getJugos() throws SQLException {
        return opcionJugoDao.listar(rset -> {
            try {
                var opcion = new OpcionJugo(rset.getString("nombre"));
                opcion.setId(rset.getInt("ID"));
                return opcion;    

            } catch (SQLException e) {
                return null;
            }
        });
    }
    
    public void crearMesa() throws SQLException{
        // Pedir al usuario la información necesaria para crear la mesa
        Mesa mesa = mesaVista.pedirInformacionMesa();

        // Almacenar la mesa
        mesaDao.guardar(mesa);

        // Listar las mesas que se encuentran en el sistema
        mesaVista.mostrarMesas(getMesas());
    }

    public void agregarPedido(Mesa mesa){
        try {
            // Pedir al usuario la información del pedido
            var pedido = pedidoVista.pedirInformacionPedido();
            // Agregar el pedido a la mesa
            pedidoDao.guardar(mesa, pedido);
            // Mostrar confirmación de agregar el pedido
            pedidoVista.mostrarMensaje("Se ha recibido el pedido de " + pedido.getCliente());
        } catch (SQLException e) {
            System.err.println("Error accediendo a la BBDD: " + e.getMessage());
        }

    }

    public Mesa consultarMesa() throws SQLException {
        return mesaVista.consultarMesa();
    }

    public void entregarPedido(Mesa mesa) {
        try {
            // Seleccionar pedido de mesa
            var pedidos = pedidoDao.listar(mesa)
                .stream()
                .filter(pedido -> pedido.getEstado() == EstadoPedido.SIN_ENTREGAR)
                .collect(Collectors.toList()); // Recolecta los elementos en una lista
            Pedido pedido = mesaVista.seleccionePedido(pedidos);

            // Marcar como entregado el pedido
            pedido.entregarPedido();
            pedidoDao.entregarPedido(pedido);
            
            pedidoVista.mostrarMensaje(String.format("El pedido de %s fue entregado",
                     pedido.getCliente()));
        } catch (Exception e) {
            System.err.println("Error entregando el pedido: " + e.getMessage());
        }
    }

    public void mostrarPedidos(Mesa mesa) {
        try {
            var pedidos = pedidoDao.listar(mesa);
            mesaVista.mostrarPedidos(pedidos);    
        } catch (SQLException e) {
            System.err.println("Error obteniendo pedidos: " + e.getMessage());
        }
    }

    public void pagarCuenta(Mesa mesa) {

        try{
            var pedidos = pedidoDao.listar(mesa);
            var total = pedidos.stream()
                        .filter(pedido -> pedido.getEstado() == EstadoPedido.PEDIENTE_COBRAR) // Solo pasan al map los estados que esten pendientes por cobrar
                        .map(pedido -> pedido.calcularValor())
                        .reduce((a, b) -> a + b)
                        .orElse(0);
                                
            pedidoVista.mostrarMensaje(String.format("La cuenta es: $%,d", total));
            var efectivo = mesaVista.leerValorEfectivo();
            try {
                // Valido si es suficiente para pagar
                if(efectivo < total){
                    throw new PagoException("El efectivo no es suficiente para cubrir la cuenta");
                }

                // Elimino los pedidos de la mesa
                pedidoDao.eliminarPedidosDeMesa(mesa);
                
                // Retorna la devuelta
                mesaVista.mostrarMensaje(String.format("La devuelta son: $ %,d",(efectivo - total)));
            } catch (Exception e) {
                mesaVista.mostrarMensaje(e.getMessage());   
            }
        }catch(SQLException e){
            System.err.println("Error al pagar la cuenta: " + e.getMessage());
        }
    }

    public void iniciarAplicacion() throws SQLException {
        menuPrincipal.iniciarAplicacion();
    }
}
