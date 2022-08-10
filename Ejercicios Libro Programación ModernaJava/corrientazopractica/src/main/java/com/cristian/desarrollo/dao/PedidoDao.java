package com.cristian.desarrollo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cristian.desarrollo.modelo.Corrientazo;
import com.cristian.desarrollo.modelo.Mesa;
import com.cristian.desarrollo.modelo.OpcionCarne;
import com.cristian.desarrollo.modelo.OpcionEnsalada;
import com.cristian.desarrollo.modelo.OpcionJugo;
import com.cristian.desarrollo.modelo.OpcionPrincipio;
import com.cristian.desarrollo.modelo.OpcionSopa;
import com.cristian.desarrollo.modelo.Pedido;
import com.cristian.desarrollo.util.JDBCUtilities;

public class PedidoDao {


    private List<OpcionSopa> obtenerNombreSopa(Connection connection, ResultSet rset, PreparedStatement pstmt, String sql, Integer idMesa, List<OpcionSopa> sopas) throws SQLException{

        String sqlSopa = String.format(
            "INNER JOIN opcionsopa os ON c.id_pedido = os.id " +
            "WHERE id_mesa = %d", idMesa);

        pstmt = connection.prepareStatement(sql + sqlSopa);
        rset = pstmt.executeQuery();

        while(rset.next()){
            sopas.add(new OpcionSopa(rset.getString("nombre")));
        }
        return sopas;
    }

    private List<OpcionPrincipio> obtenerNombrePrincipio(Connection connection, ResultSet rset, PreparedStatement pstmt, String sql, Integer idMesa, List<OpcionPrincipio> principios) throws SQLException{
    
        String sqlPrincipio = String.format(
            "INNER JOIN opcionprincipio op ON c.id_pedido = op.id " +
            "WHERE id_mesa = %d", idMesa);

        pstmt = connection.prepareStatement(sql + sqlPrincipio);
        rset = pstmt.executeQuery();

        while (rset.next()){
            principios.add(new OpcionPrincipio(rset.getString("nombre")));
        }
        return principios;
    }

    private List<OpcionCarne> obtenerNombreCarne(Connection connection, ResultSet rset, PreparedStatement pstmt, String sql, Integer idMesa, List<OpcionCarne> carnes) throws SQLException{
        
        String sqlCarne = String.format(
            "INNER JOIN opcioncarne oc ON c.id_pedido = oc.id " +
            "WHERE id_mesa = %d", idMesa);

        pstmt = connection.prepareStatement(sql + sqlCarne);
        rset = pstmt.executeQuery();

        while (rset.next()){
            carnes.add(new OpcionCarne(rset.getString("nombre")));
        }
        return carnes;
    }

    private List<OpcionEnsalada> obtenerNombreEnsalada(Connection connection, ResultSet rset, PreparedStatement pstmt, String sql, Integer idMesa, List<OpcionEnsalada> ensaladas) throws SQLException{
        
        String sqlEnsalada = String.format(
            "INNER JOIN opcionensalada oe ON c.id_pedido = oe.id " +
            "WHERE id_mesa = %d", idMesa);

        pstmt = connection.prepareStatement(sql + sqlEnsalada);
        rset = pstmt.executeQuery();

        while (rset.next()){
            ensaladas.add(new OpcionEnsalada(rset.getString("nombre")));
        }
        return ensaladas;
    }

    private List<OpcionJugo> obtenerNombreJugo(Connection connection, ResultSet rset, PreparedStatement pstmt, String sql, Integer idMesa, List<OpcionJugo> jugos) throws SQLException{
        
        String sqlJugo = String.format(
            "INNER JOIN opcionJugo oj ON c.id_pedido = oj.id " +
            "WHERE id_mesa = %d", idMesa);

        pstmt = connection.prepareStatement(sql + sqlJugo);
        rset = pstmt.executeQuery();

        while (rset.next()){
            jugos.add(new OpcionJugo(rset.getString("nombre")));
        }
        return jugos;
    }

    public List<Pedido> listar(Mesa mesa) throws SQLException{

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<Pedido> pedidos = null;
        List<OpcionSopa> sopas = null;
        List<OpcionPrincipio> principios = null;
        List<OpcionCarne> carnes = null;
        List<OpcionEnsalada> ensaladas = null;
        List<OpcionJugo> jugos = null;
        Integer idMesa = mesa.getId();
        try {
            sopas = new ArrayList<>();
            principios = new ArrayList<>();
            carnes = new ArrayList<>();
            ensaladas = new ArrayList<>();
            jugos = new ArrayList<>();
            // Conexión
            connection = JDBCUtilities.getConnection();
            String sql = String.format(
                "SELECT nombre FROM pedido " + 
                "INNER JOIN corrientazo c ON pedido.id = c.id_pedido ");
    
            sopas = obtenerNombreSopa(connection, rset, pstmt, sql, idMesa, sopas);
            principios = obtenerNombrePrincipio(connection, rset, pstmt, sql, idMesa, principios);
            carnes = obtenerNombreCarne(connection, rset, pstmt, sql, idMesa, carnes);
            ensaladas = obtenerNombreEnsalada(connection, rset, pstmt, sql, idMesa, ensaladas);
            jugos = obtenerNombreJugo(connection, rset, pstmt, sql, idMesa, jugos);

            sql = "SELECT cliente, estado FROM PEDIDO";
            pstmt = connection.prepareStatement(sql);
            rset = pstmt.executeQuery();

            pedidos = new ArrayList<>();
            Integer tSopas = sopas.size(),
                    tPrinc = principios.size(),
                    tCarnes = carnes.size(),
                    tEnsaladas = ensaladas.size(),
                    tJugos = jugos.size();
            Integer contador = 0;
            // Error por aquí: Falta agregar el corrientazo a la BBDD para que pueda traer los nombres
            while(contador < sopas.size()){
                Corrientazo almuerzo = new Corrientazo(12_000,
                                        sopas.get(sopas.size() - tSopas), principios.get(principios.size() - tPrinc),
                                        carnes.get(carnes.size() - tCarnes), ensaladas.get(ensaladas.size() - tEnsaladas),
                                        jugos.get(jugos.size() - tJugos));
                Pedido pedido = new Pedido(rset.getString("cliente"), almuerzo, idMesa);
                pedidos.add(pedido);
                tSopas--;
                tPrinc--;
                tCarnes--;
                tEnsaladas--;
                tJugos--;
                contador++;
                rset.next();
            }
        } finally {
            if (connection != null)
                connection.close();
            if (pstmt != null)
                pstmt.close();
            if (rset != null)
                rset.close();
        }
        return pedidos;
    } 

    public void agregar(Pedido pedido) throws SQLException{
        Connection connection = null;
        PreparedStatement pstmt = null;
        
        try {
            // Conexión
            connection = JDBCUtilities.getConnection();
            
            // Crear sentencia preparada
            // Agregar Pedido
            String sql = "INSERT INTO PEDIDO (id, cliente, estado, id_mesa) VALUES (?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);
            
            pstmt.setInt(1, generarConsecutivo());
            pstmt.setString(2, pedido.getCliente());
            pstmt.setString(3, String.valueOf(pedido.getEstado()));
            pstmt.setInt(4, pedido.getIdMesa());

            // Ejecutar sentencia preparada
            pstmt.executeUpdate();

            // Agregar Corrientazo



        } finally {
            if (connection != null)
                connection.close();
            if (pstmt != null)
                pstmt.close();
        }
    }

    private int generarConsecutivo() throws SQLException{
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Integer consecutivo = 0;
        try {
            // Conexión
            connection = JDBCUtilities.getConnection();
            // Crear sentencia preparada
            String sql = "SELECT MAX(id) AS ID FROM PEDIDO;";
            pstmt = connection.prepareStatement(sql);
            
            rset = pstmt.executeQuery();

            if(rset.next()){
                consecutivo = rset.getInt("ID");
            }

            consecutivo += 1;
            
        } finally {
            if (connection != null)
                connection.close();
            if (pstmt != null)
                pstmt.close();
            if (rset != null)
                rset.close();
        }
        return consecutivo;
    }
}
