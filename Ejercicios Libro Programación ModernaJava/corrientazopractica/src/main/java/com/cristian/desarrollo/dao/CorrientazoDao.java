package com.cristian.desarrollo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cristian.desarrollo.modelo.Corrientazo;
import com.cristian.desarrollo.util.JDBCUtilities;

public class CorrientazoDao {

    public void guardar(Corrientazo almuerzo) throws SQLException{

        Connection connection = null;
        PreparedStatement pstmt = null;
        
        try {
            // Conexión
            connection = JDBCUtilities.getConnection();
            
            // Crear sentencia preparada
            String sql = "INSERT INTO corrientazo (id_pedido, precio, id_sopa, id_principio, id_carne, id_ensalada, id_jugo) VALUES (?,?,?,?,?,?,?)";
            pstmt = connection.prepareStatement(sql);
            
            pstmt.setInt(1, generarConsecutivo());
            pstmt.setInt(2, almuerzo.getPrecio());
            pstmt.setInt(3, almuerzo.getSopa().getId());
            pstmt.setInt(4, almuerzo.getPrincipio().getId());
            pstmt.setInt(5, almuerzo.getCarne().getId());
            pstmt.setInt(6, almuerzo.getEnsalada().getId());
            pstmt.setInt(7, almuerzo.getJugo().getId());

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
            String sql = "SELECT MAX(id_pedido) AS ID FROM corrientazo;";
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
