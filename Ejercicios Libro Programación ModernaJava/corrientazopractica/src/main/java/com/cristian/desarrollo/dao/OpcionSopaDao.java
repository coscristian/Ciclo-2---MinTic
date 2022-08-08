package com.cristian.desarrollo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cristian.desarrollo.modelo.OpcionSopa;
import com.cristian.desarrollo.util.JDBCUtilities;

public class OpcionSopaDao {

    public List<OpcionSopa> listar() throws SQLException{

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<OpcionSopa> sopas = null;
        
        try {
            // Conexión
            connection = JDBCUtilities.getConnection();
            // Crear sentencia preparada
            String sql = "SELECT * FROM OpcionSopa";
            pstmt = connection.prepareStatement(sql);
            // Ejecutar sentencia preparada
            rset = pstmt.executeQuery();
            
            sopas = new ArrayList<>();
            while(rset.next()){
                OpcionSopa sopa = new OpcionSopa(rset.getString("nombre"));
                sopa.setId(rset.getInt("id"));
                sopas.add(sopa);
            }
        } finally {
            if (connection != null)
                connection.close();
            if (pstmt != null)
                pstmt.close();
            if (rset != null)
                rset.close();
        }
        return sopas;
    }

    public void guardar(OpcionSopa sopa) throws SQLException{

        Connection connection = null;
        PreparedStatement pstmt = null;
        
        try {
            // Conexión
            connection = JDBCUtilities.getConnection();
            
            // Crear sentencia preparada
            String sql = "INSERT INTO OpcionSopa (id, nombre) VALUES (?,?)";
            pstmt = connection.prepareStatement(sql);
            
            pstmt.setInt(1, generarConsecutivo());
            pstmt.setString(2, sopa.getNombre());

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
            String sql = "SELECT MAX(id) AS ID FROM OpcionSopa;";
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
