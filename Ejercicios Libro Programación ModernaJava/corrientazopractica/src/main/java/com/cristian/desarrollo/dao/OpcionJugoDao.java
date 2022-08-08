package com.cristian.desarrollo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cristian.desarrollo.modelo.OpcionJugo;
import com.cristian.desarrollo.util.JDBCUtilities;


public class OpcionJugoDao {
    public List<OpcionJugo> listar() throws SQLException{

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<OpcionJugo> jugos = null;
        
        try {
            // Conexión
            connection = JDBCUtilities.getConnection();
            // Crear sentencia preparada
            String sql = "SELECT * FROM OpcionJugo";
            pstmt = connection.prepareStatement(sql);
            // Ejecutar sentencia preparada
            rset = pstmt.executeQuery();
            
            jugos = new ArrayList<>();
            while(rset.next()){
                OpcionJugo jugo = new OpcionJugo(rset.getString("nombre"));
                jugo.setId(rset.getInt("id"));
                jugos.add(jugo);
            }
        } finally {
            if (connection != null)
                connection.close();
            if (pstmt != null)
                pstmt.close();
            if (rset != null)
                rset.close();
        }
        return jugos;
    }

    public void guardar(OpcionJugo jugo) throws SQLException{

        Connection connection = null;
        PreparedStatement pstmt = null;
        
        try {
            // Conexión
            connection = JDBCUtilities.getConnection();
            
            // Crear sentencia preparada
            String sql = "INSERT INTO OpcionJugo (id, nombre) VALUES (?,?)";
            pstmt = connection.prepareStatement(sql);
            
            pstmt.setInt(1, generarConsecutivo());
            pstmt.setString(2, jugo.getNombre());

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
            String sql = "SELECT MAX(id) AS ID FROM OpcionJugo;";
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
