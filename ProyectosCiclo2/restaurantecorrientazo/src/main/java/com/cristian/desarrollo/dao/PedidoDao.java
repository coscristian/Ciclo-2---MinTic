package com.cristian.desarrollo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
    public void guardar(Mesa mesa, Pedido pedido) throws SQLException{
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        try{
            pedido.setId(generarConsecutivo());
            stmt1 = JDBCUtilities.getConnection()
                .prepareStatement("INSERT INTO PEDIDO (id, cliente, estado, id_mesa) " + 
                "VALUES (?, ?, ?, ?);");
            stmt1.setInt(1, pedido.getId());
            stmt1.setString(2, pedido.getCliente());
            stmt1.setString(3, pedido.getEstado().toString());
            stmt1.setInt(4, mesa.getId());

            stmt1.executeUpdate();

            stmt2 = JDBCUtilities.getConnection()
                .prepareStatement("INSERT INTO CORRIENTAZO (id_pedido, precio, id_sopa, id_principio, id_carne, id_ensalada, id_jugo) " + 
                "VALUES (?, ?, ?, ?, ?, ?, ?);");

            stmt2.setInt(1, pedido.getId());
            stmt2.setInt(2, pedido.getAlmuerzo().getPrecio());
            stmt2.setInt(3, pedido.getAlmuerzo().getSopa().getId());
            stmt2.setInt(4, pedido.getAlmuerzo().getPrincipio().getId());
            stmt2.setInt(5, pedido.getAlmuerzo().getCarne().getId());
            if(pedido.getAlmuerzo().getEnsalada() != null)
                stmt2.setInt(6, pedido.getAlmuerzo().getEnsalada().getId());
            else
                stmt2.setNull(6, Types.INTEGER); // Guarde un valor nulo en donde se esperaba un entero
            stmt2.setInt(7, pedido.getAlmuerzo().getJugo().getId());
            
            stmt2.executeUpdate();

        }finally{
            if (stmt1 != null)
                stmt1.close();
            if (stmt2 != null)
                stmt2.close();
        }

    }


    private Integer generarConsecutivo()throws SQLException{
        Integer respuesta = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rset = null;
        try{
            // Conexión
            connection = JDBCUtilities.getConnection();
            // Sentencia
            statement = connection.prepareStatement("SELECT MAX(ID) AS ID FROM PEDIDO");
            // Ejecución
            rset = statement.executeQuery();
            
            if(rset.next()){ // Si hay datos
                respuesta = rset.getInt("ID");
            }
            respuesta += 1;
        }finally {
            // Cerrar flujos de datos
            if (rset != null){
                rset.close();
            }

            if (statement != null){
                statement.close();
            }

            if (connection != null){
                connection.close();
            }
        }
        return respuesta;
    }


    public List<Pedido> listar(Mesa mesa) throws SQLException{
        List<Pedido> respuesta = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;

        try{
            var sql = "SELECT p.id, p.cliente, p.estado, "  
            + "       c.precio, c.id_sopa, c.id_principio, c.id_carne, c.id_ensalada, c.id_jugo, " 
            + "       os.nombre as sopa, op.nombre as principio, oc.nombre as carne, oe.nombre as ensalada, oj.nombre as jugo " 
            + "FROM Pedido p " 
            + "JOIN Corrientazo c ON (p.id = c.id_pedido) " 
            + "JOIN OpcionSopa os ON (c.id_sopa = os.id) "   
            + "JOIN OpcionPrincipio op ON (c.id_principio  = op.id) " 
            + "JOIN OpcionCarne oc ON (c.id_carne = oc.id) " 
            + "LEFT JOIN OpcionEnsalada oe ON (c.id_ensalada  = oe.id) " 
            + "JOIN OpcionJugo oj ON (c.id_jugo = oj.id) " 
            + "WHERE id_mesa = ? ;";

            stmt = JDBCUtilities.getConnection().prepareStatement(sql);
            stmt.setInt(1, mesa.getId());

            rset = stmt.executeQuery();
            respuesta = new ArrayList<>();

            while(rset.next()){
                var sopa = new OpcionSopa(rset.getString("sopa"));
                sopa.setId(rset.getInt("id_sopa"));
                
                var principio = new OpcionPrincipio(rset.getString("principio"));
                principio.setId(rset.getInt("id_principio"));
                
                var carne = new OpcionCarne(rset.getString("carne"));
                carne.setId(rset.getInt("id_carne"));

                OpcionEnsalada ensalada = null;
                if (rset.getString("ensalada") != null){
                    ensalada = new OpcionEnsalada(rset.getString("ensalada"));
                    ensalada.setId(rset.getInt("id_ensalada"));
                }

                var jugo = new OpcionJugo(rset.getString("jugo"));
                jugo.setId(rset.getInt("id_carne"));
                
                var almuerzo = new Corrientazo(rset.getInt("precio"), sopa, principio, carne, ensalada, jugo);
                var pedido = new Pedido(rset.getString("cliente"), almuerzo);
                pedido.setId(rset.getInt("id"));
                pedido.setEstado(EstadoPedido.valueOf(rset.getString("estado")));
                
                respuesta.add(pedido);
            }
        }finally{
            if (rset != null)
                rset.close();
            if (stmt != null)
                stmt.close();
        }
        return respuesta;
    }


    public void entregarPedido(Pedido pedido) throws SQLException {
        PreparedStatement stmt = null;
        try{
            stmt = JDBCUtilities.getConnection()
                    .prepareStatement("UPDATE Pedido SET estado = ? WHERE id = ?;");
            stmt.setString(1, pedido.getEstado().toString());
            stmt.setInt(2, pedido.getId());
            stmt.executeUpdate();
        }finally{
            if (stmt != null)
                stmt.close();
        }
        
    }


    public void eliminarPedidosDeMesa(Mesa mesa) throws SQLException{
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        try{
            stmt1 = JDBCUtilities.getConnection()
                    .prepareStatement("DELETE"
                            + " FROM Corrientazo"
                            + " WHERE id_pedido IN ("
                            + "     SELECT id"
                            + "     FROM Pedido"
                            + "     WHERE id_mesa = ?"
                            + ");");
            stmt1.setInt(1, mesa.getId());
            stmt1.executeUpdate();

            stmt2 = JDBCUtilities.getConnection()
            .prepareStatement("DELETE FROM Pedido WHERE id_mesa = ?;");
            stmt2.setInt(1, mesa.getId());
            stmt2.executeUpdate();
        }finally{
            if (stmt1 != null)
                stmt1.close();
            if (stmt2 != null)
                stmt2.close();
        }
    }
}
