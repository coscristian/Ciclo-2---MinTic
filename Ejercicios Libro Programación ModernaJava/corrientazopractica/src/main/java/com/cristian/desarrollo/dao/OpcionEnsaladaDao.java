package com.cristian.desarrollo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cristian.desarrollo.modelo.OpcionEnsalada;
import com.cristian.desarrollo.util.JDBCUtilities;

public class OpcionEnsaladaDao {
    public List<OpcionEnsalada> listar() throws SQLException{

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<OpcionEnsalada> ensaladas = null;
        
        try {
            // Conexión
            connection = JDBCUtilities.getConnection();
            // Crear sentencia preparada
            String sql = "SELECT * FROM OpcionEnsalada";
            pstmt = connection.prepareStatement(sql);
            // Ejecutar sentencia preparada
            rset = pstmt.executeQuery();
            
            ensaladas = new ArrayList<>();
            while(rset.next()){
                OpcionEnsalada ensalada = new OpcionEnsalada(rset.getString("nombre"));
                ensalada.setId(rset.getInt("id"));
                ensaladas.add(ensalada);
            }
        } finally {
            if (connection != null)
                connection.close();
            if (pstmt != null)
                pstmt.close();
            if (rset != null)
                rset.close();
        }
        return ensaladas;
    }

    public void guardar(OpcionEnsalada ensalada) throws SQLException{

        Connection connection = null;
        PreparedStatement pstmt = null;
        
        try {
            // Conexión
            connection = JDBCUtilities.getConnection();
            
            // Crear sentencia preparada
            String sql = "INSERT INTO OpcionEnsalada (id, nombre) VALUES (?,?)";
            pstmt = connection.prepareStatement(sql);
            
            pstmt.setInt(1, generarConsecutivo());
            pstmt.setString(2, ensalada.getNombre());

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
            String sql = "SELECT MAX(id) AS ID FROM OpcionEnsalada;";
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
