package com.cristian.desarrollo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cristian.desarrollo.modelo.Adicional;
import com.cristian.desarrollo.modelo.Mesa;
import com.cristian.desarrollo.modelo.Pedido;
import com.cristian.desarrollo.util.JDBCUtilities;

public class AdicionalDao {
    public void guardar(Adicional adicional, Mesa mesa) throws SQLException{
        PreparedStatement pstmt = null;
        
        try{
            var sql = "INSERT INTO Adicional (id, nombre, precio) VALUES (?, ?, ?)";
            pstmt = JDBCUtilities.getConnection().prepareStatement(sql);

            adicional.setId(generarConsecutivo(mesa, adicional));

            pstmt.setInt(1, adicional.getId());
            pstmt.setString(2, adicional.getNombre());
            pstmt.setInt(3, adicional.getPrecio());

            pstmt.executeUpdate();
        }finally{
            if (pstmt != null)
                pstmt.close();
        }
    }

    public List<Adicional> listar(Mesa mesa, Pedido pedido) throws SQLException{
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<Adicional> adicionales = null;

        var sql = String.format("SELECT a.id, a.nombre, a.precio"
                + " FROM Adicional a"
                + " JOIN PedidoAdicional pa ON a.id = pa.id_adicional"  
                + " WHERE pa.id_pedido = ?"
                + " AND pa.id_mesa = ?;");

        pstmt = JDBCUtilities.getConnection().prepareStatement(sql);
        pstmt.setInt(1, pedido.getId());
        pstmt.setInt(2, mesa.getId());

        rset = pstmt.executeQuery();

        adicionales = new ArrayList<>();

        while(rset.next()){
                var adicional = new Adicional(rset.getString("nombre"), rset.getInt("precio"));
                adicional.setId(rset.getInt("id"));
                adicional.setIdPedido(pedido.getId());
                adicionales.add(adicional);
        }
        return adicionales;
    }

    private int generarConsecutivo(Mesa mesa, Adicional adicional) throws SQLException{
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Integer consecutivo = 0;
        try {
            // Conexión
            connection = JDBCUtilities.getConnection();
            // Crear sentencia preparada
            String sql = "SELECT MAX(id) AS ID FROM Adicional a;";
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
