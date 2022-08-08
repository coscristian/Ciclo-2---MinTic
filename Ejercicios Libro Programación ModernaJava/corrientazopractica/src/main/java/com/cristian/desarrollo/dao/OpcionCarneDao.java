package com.cristian.desarrollo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cristian.desarrollo.modelo.OpcionCarne;
import com.cristian.desarrollo.util.JDBCUtilities;

public class OpcionCarneDao {
    public List<OpcionCarne> listar() throws SQLException{

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<OpcionCarne> carnes = null;
        
        try {
            // Conexión
            connection = JDBCUtilities.getConnection();
            // Crear sentencia preparada
            String sql = "SELECT * FROM OpcionCarne";
            pstmt = connection.prepareStatement(sql);
            // Ejecutar sentencia preparada
            rset = pstmt.executeQuery();
            
            carnes = new ArrayList<>();
            while(rset.next()){
                OpcionCarne carne = new OpcionCarne(rset.getString("nombre"));
                carne.setId(rset.getInt("id"));
                carnes.add(carne);
            }
        } finally {
            if (connection != null)
                connection.close();
            if (pstmt != null)
                pstmt.close();
            if (rset != null)
                rset.close();
        }
        return carnes;
    }

    public void guardar(OpcionCarne carne) throws SQLException{

        Connection connection = null;
        PreparedStatement pstmt = null;
        
        try {
            // Conexión
            connection = JDBCUtilities.getConnection();
            
            // Crear sentencia preparada
            String sql = "INSERT INTO OpcionCarne (id, nombre) VALUES (?,?)";
            pstmt = connection.prepareStatement(sql);
            
            pstmt.setInt(1, generarConsecutivo());
            pstmt.setString(2, carne.getNombre());

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
            String sql = "SELECT MAX(id) AS ID FROM OpcionCarne;";
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
