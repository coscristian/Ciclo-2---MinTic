package com.cristian.desarrollo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cristian.desarrollo.modelo.Corrientazo;
import com.cristian.desarrollo.modelo.Mesa;
import com.cristian.desarrollo.modelo.OpcionSopa;
import com.cristian.desarrollo.modelo.Pedido;
import com.cristian.desarrollo.util.JDBCUtilities;

public class PedidoDao {

/*     public List<Pedido> listar(Mesa mesa) throws SQLException{

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<Pedido> pedidos = null;
        
        try {
            // Conexión
            connection = JDBCUtilities.getConnection();
            // Crear sentencia preparada
            String sql = "SELECT * FROM MESA";
            pstmt = connection.prepareStatement(sql);
            // Ejecutar sentencia preparada
            rset = pstmt.executeQuery();
            
            pedidos = new ArrayList<>();
            while(rset.next()){
                var sopa = new OpcionSopa(rset.get("sopa"))
                var almuerzo = new Corrientazo(rset.getInt("precio"), sopa, principio, carne, ensalada, jugo)



                Mesa pedidos = new Pedido(rset.getString("cliente"),
                                          new Corrientazo(rset.getInt("precio"), new OpcionSopa(rset.getString("")), principio, carne, ensalada, jugo), idMesa);
                mesa.setId(rset.getInt("id"));
                pedidos.add(mesa);
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
    } */
    public void agregar(Pedido pedido) throws SQLException{
        Connection connection = null;
        PreparedStatement pstmt = null;
        
        try {
            // Conexión
            connection = JDBCUtilities.getConnection();
            
            // Crear sentencia preparada
            String sql = "INSERT INTO PEDIDO (id, cliente, estado, id_mesa) VALUES (?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);
            
            pstmt.setInt(1, generarConsecutivo());
            pstmt.setString(2, pedido.getCliente());
            pstmt.setString(3, String.valueOf(pedido.getEstado()));
            pstmt.setInt(4, pedido.getIdMesa());

            // Ejecutar sentencia preparada
            pstmt.executeUpdate();
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
