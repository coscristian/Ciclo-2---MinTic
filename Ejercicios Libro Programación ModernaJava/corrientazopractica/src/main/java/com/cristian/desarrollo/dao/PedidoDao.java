package com.cristian.desarrollo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cristian.desarrollo.modelo.Corrientazo;
import com.cristian.desarrollo.modelo.EstadoPedido;
import com.cristian.desarrollo.modelo.Mesa;
import com.cristian.desarrollo.modelo.OpcionCarne;
import com.cristian.desarrollo.modelo.OpcionEnsalada;
import com.cristian.desarrollo.modelo.OpcionJugo;
import com.cristian.desarrollo.modelo.OpcionPrincipio;
import com.cristian.desarrollo.modelo.OpcionSopa;
import com.cristian.desarrollo.modelo.Pedido;
import com.cristian.desarrollo.util.JDBCUtilities;

public class PedidoDao {

    public List<Pedido> listar(Mesa mesa) throws SQLException{

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<Pedido> pedidos = null;

        try {
            // Conexión
            connection = JDBCUtilities.getConnection();
            var sql = "SELECT p.id, p.cliente, p.estado,"
                    + "         c.precio, c.id_sopa, c.id_principio, c.id_carne, c.id_ensalada, c.id_jugo,"
                    + "         os.nombre as sopa, op.nombre as principio, oc.nombre as carne, oe.nombre as ensalada, oj.nombre as jugo "
                    + "FROM PEDIDO p "
                    + "JOIN Corrientazo c ON (p.id = c.id_pedido) "
                    + "JOIN OpcionSopa os ON (c.id_sopa  = os.id) "
                    + "JOIN OpcionPrincipio op ON (c.id_principio  = op.id) "
                    + "JOIN OpcionCarne oc ON (c.id_carne = oc.id) "
                    + "LEFT JOIN OpcionEnsalada oe ON (c.id_ensalada = oe.id) "
                    + "JOIN OpcionJugo oj ON (c.id_jugo = oj.id) "
                    + "WHERE p.id_mesa = ?;";
            
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, mesa.getId());
            rset = pstmt.executeQuery();

            pedidos = new ArrayList<>();
        
            while(rset.next()){
                // Alimentos para crear almuerzo
                var sopa = new OpcionSopa(rset.getString("sopa"));
                sopa.setId(rset.getInt("id_sopa"));

                var principio = new OpcionPrincipio(rset.getString("principio"));
                principio.setId(rset.getInt("id_sopa"));

                var carne = new OpcionCarne(rset.getString("carne"));
                carne.setId(rset.getInt("id_carne"));

                OpcionEnsalada ensalada = null;
                if (rset.getString("ensalada") != null){
                    ensalada = new OpcionEnsalada(rset.getString("ensalada"));
                    ensalada.setId(rset.getInt("id_ensalada"));
                }

                var jugo = new OpcionJugo(rset.getString("jugo"));
                jugo.setId(rset.getInt("id_jugo"));

                // Creacion de almuerzo
                Corrientazo almuerzo = new Corrientazo(rset.getInt("precio"), sopa, principio, carne, ensalada, jugo);

                // Creacion del pedido
                var pedido = new Pedido(rset.getString("cliente"), almuerzo, mesa.getId());
                pedido.setId(rset.getInt("id"));
                pedido.setEstado(EstadoPedido.valueOf(rset.getString("estado")));

                pedidos.add(pedido);
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

    public void agregar(Pedido pedido, Mesa mesa) throws SQLException{
        Connection connection = null;
        PreparedStatement pstmt = null;
        
        try {
            // Conexión
            connection = JDBCUtilities.getConnection();
            
            // Crear sentencia preparada
            // Agregar Pedido
            String sql = "INSERT INTO PEDIDO (id, cliente, estado, id_mesa) VALUES (?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);
            
            pstmt.setInt(1, generarConsecutivo(mesa));
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

    private int generarConsecutivo(Mesa mesa) throws SQLException{
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Integer consecutivo = 0;
        try {
            // Conexión
            connection = JDBCUtilities.getConnection();
            // Crear sentencia preparada
            String sql = String.format(
                "SELECT MAX(id) AS ID FROM PEDIDO"
                + " WHERE id_mesa = %d;", mesa.getId());
            pstmt = connection.prepareStatement(sql);
            
            rset = pstmt.executeQuery();

            if(rset.next()){ // Si hay datos
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

    public void entregarPedido(Mesa mesa, Pedido pedido) throws SQLException {
        PreparedStatement pstmt = null;
        try{
            var sql = "UPDATE Pedido" 
                + " SET estado = ?"
                + " WHERE id = ?"
                + " AND id_mesa = ?;";
            pstmt = JDBCUtilities.getConnection().prepareStatement(sql);
            pstmt.setString(1, EstadoPedido.PENDIENTE_COBRAR.toString());
            pstmt.setInt(2, pedido.getId());
            pstmt.setInt(3, mesa.getId());

            pstmt.executeUpdate();
        }finally{
            if (pstmt != null)
                pstmt.close();
        }
    }

    public void eliminarPedidosDeMesa(Mesa mesa) throws SQLException{
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        PreparedStatement stmt4 = null;

        try{
            stmt1 = JDBCUtilities.getConnection()
                    .prepareStatement("DELETE"
                            + " FROM Corrientazo"
                            + " WHERE id_pedido IN ("
                            + "     SELECT id"
                            + "     FROM Pedido"
                            + "     WHERE id_mesa = ?"
                            + "     AND estado = ?"
                            + ");");
            stmt1.setInt(1, mesa.getId());
            stmt1.setString(2, EstadoPedido.PENDIENTE_COBRAR.toString());
            stmt1.executeUpdate();

            // Eliminar los adicionales del pedido.
            stmt2 = JDBCUtilities.getConnection()
                    .prepareStatement("DELETE"
                            + " FROM Adicional"
                            + " WHERE id IN ("
                            + "     SELECT id_adicional"
                            + "     FROM PedidoAdicional"
                            + "     WHERE id_mesa = ?"
                            + "     AND id_pedido IN ("
                            + "             SELECT id"
                            + "             FROM PEDIDO"
                            + "             WHERE id_mesa = ?"
                            + "             AND estado = ?"
                            + "     )"
                            + " );");
            stmt2.setInt(1, mesa.getId());
            stmt2.setInt(2, mesa.getId());
            stmt2.setString(3, EstadoPedido.PENDIENTE_COBRAR.toString());
            stmt2.executeUpdate();

            // Eliminar la relación en la tabla PedidoAdicional
            stmt3 = JDBCUtilities.getConnection()
                    .prepareStatement("DELETE"
                            + " FROM PedidoAdicional"
                            + " WHERE id_mesa = ?"
                            + " AND id_pedido IN ("
                            + "     SELECT id"
                            + "     FROM Pedido"
                            + "     WHERE id_mesa = ?"
                            + "     AND estado = ?"
                            + ");");
            stmt3.setInt(1, mesa.getId());
            stmt3.setInt(2, mesa.getId());
            stmt3.setString(3, EstadoPedido.PENDIENTE_COBRAR.toString());
            stmt3.executeUpdate();

            stmt4 = JDBCUtilities.getConnection()
                    .prepareStatement("DELETE FROM Pedido WHERE id_mesa = ? AND estado = ?;");
            stmt4.setInt(1, mesa.getId());
            stmt4.setString(2, EstadoPedido.PENDIENTE_COBRAR.toString());
            stmt4.executeUpdate();
        }finally{
            if (stmt1 != null)
                stmt1.close();
            if (stmt2 != null)
                stmt2.close();
        }
    }
}
