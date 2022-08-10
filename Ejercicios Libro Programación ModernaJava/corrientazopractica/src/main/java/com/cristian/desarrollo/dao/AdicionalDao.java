package com.cristian.desarrollo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cristian.desarrollo.modelo.Adicional;
import com.cristian.desarrollo.util.JDBCUtilities;

public class AdicionalDao {
    public void guardar(Adicional adicional) throws SQLException{
        PreparedStatement pstmt = null;
        
        try{
            var sql = "INSERT INTO Adicional (id, nombre, precio) VALUES (?, ?, ?)";
            pstmt = JDBCUtilities.getConnection().prepareStatement(sql);

            pstmt.setInt(1, generarConsecutivo());
            pstmt.setString(2, adicional.getNombre());
            pstmt.setInt(3, adicional.getPrecio());

            pstmt.executeUpdate();
        }finally{
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
            String sql = "SELECT MAX(id) AS ID FROM Adicional;";
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
