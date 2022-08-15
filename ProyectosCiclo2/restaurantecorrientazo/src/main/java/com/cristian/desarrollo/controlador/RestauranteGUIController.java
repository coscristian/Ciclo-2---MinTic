/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cristian.desarrollo.controlador;

import com.cristian.desarrollo.dao.MesaDao;
import com.cristian.desarrollo.dao.OpcionAlimentoDao;
import com.cristian.desarrollo.dao.PedidoDao;
import com.cristian.desarrollo.modelo.EstadoPedido;
import com.cristian.desarrollo.modelo.Mesa;
import com.cristian.desarrollo.modelo.OpcionCarne;
import com.cristian.desarrollo.modelo.OpcionEnsalada;
import com.cristian.desarrollo.modelo.OpcionJugo;
import com.cristian.desarrollo.modelo.OpcionPrincipio;
import com.cristian.desarrollo.modelo.OpcionSopa;
import com.cristian.desarrollo.modelo.Pedido;
import java.sql.SQLException;
import java.util.List;

public class RestauranteGUIController {
    
    private MesaDao mesaDao;
    private PedidoDao pedidoDao;
    private OpcionAlimentoDao<OpcionSopa> opcionSopaDao;
    private OpcionAlimentoDao<OpcionPrincipio> opcionPrincipioDao;
    private OpcionAlimentoDao<OpcionCarne> opcionCarneDao;
    private OpcionAlimentoDao<OpcionEnsalada> opcionEnsaladaDao;
    private OpcionAlimentoDao<OpcionJugo> opcionJugoDao;
    
    
    public RestauranteGUIController(){
        this.mesaDao = new MesaDao();
        this.pedidoDao = new PedidoDao();
        
        this.opcionSopaDao = new OpcionAlimentoDao<>("OpcionSopa");
        this.opcionPrincipioDao = new OpcionAlimentoDao<>("OpcionPrincipio");
        this.opcionCarneDao = new OpcionAlimentoDao<>("OpcionCarne");
        this.opcionEnsaladaDao = new OpcionAlimentoDao<>("OpcionEnsalada");
        this.opcionJugoDao = new OpcionAlimentoDao<>("OpcionJugo");
        
    }
    
    public List<Mesa> listarMesas() throws SQLException{
        return mesaDao.listar();
    }
    
    public Integer calcularTotalMesa(Mesa mesa) throws SQLException{
        var pedidos = pedidoDao.listar(mesa);
        return pedidos.stream()
                    .filter(pedido -> pedido.getEstado() == EstadoPedido.PEDIENTE_COBRAR) // Solo pasan al map los estados que esten pendientes por cobrar
                    .map(pedido -> pedido.calcularValor())
                    .reduce((a, b) -> a + b)
                    .orElse(0);
        
    }
    
    public List<Pedido> listarPedidos(Mesa mesa) throws SQLException{
        return pedidoDao.listar(mesa);
    }
    
    public List<OpcionSopa> listarSopas() throws SQLException{
        return opcionSopaDao.listar(rset -> {
            try{
                var dato = new OpcionSopa(rset.getString("nombre"));
                dato.setId(rset.getInt("id"));
                return dato;
            }catch(SQLException ex){
                return null;
            }
        });
    }
    
    public List<OpcionPrincipio> listarPrincipios() throws SQLException{
        return opcionPrincipioDao.listar(rset -> {
            try{
                var dato = new OpcionPrincipio(rset.getString("nombre"));
                dato.setId(rset.getInt("id"));
                return dato;
            }catch(SQLException ex){
                return null;
            }
        });
    }
    
    public List<OpcionCarne> listarCarnes() throws SQLException{
        return opcionCarneDao.listar(rset -> {
            try{
                var dato = new OpcionCarne(rset.getString("nombre"));
                dato.setId(rset.getInt("id"));
                return dato;
            }catch(SQLException ex){
                return null;
            }
        });
    }
    
    public List<OpcionEnsalada> listarEnsaladas() throws SQLException{
        return opcionEnsaladaDao.listar(rset -> {
            try{
                var dato = new OpcionEnsalada(rset.getString("nombre"));
                dato.setId(rset.getInt("id"));
                return dato;
            }catch(SQLException ex){
                return null;
            }
        });
    }
    
    public List<OpcionJugo> listarJugos() throws SQLException{
        return opcionJugoDao.listar(rset -> {
            try{
                var dato = new OpcionJugo(rset.getString("nombre"));
                dato.setId(rset.getInt("id"));
                return dato;
            }catch(SQLException ex){
                return null;
            }
        });
    }

    
}
