package com.cristian.desarrollo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cristian.desarrollo.modelo.Adicional;
import com.cristian.desarrollo.modelo.Pedido;
import com.cristian.desarrollo.util.JDBCUtilities;

public class PedidoAdicionalDao {

    public void guardar(Pedido pedido, Adicional adicional) throws SQLException{
        PreparedStatement pstmt = null;
        System.out.println(pedido);
        try{
            pstmt = JDBCUtilities.getConnection().prepareStatement(
                "INSERT INTO PedidoAdicional (id_pedido, id_adicional) VALUES (?, ?);");
            pstmt.setInt(1, pedido.getId());
            pstmt.setInt(2, adicional.getId());
            pstmt.executeUpdate();
        }finally{
            if (pstmt != null)
                pstmt.close();
        }
    }
}
