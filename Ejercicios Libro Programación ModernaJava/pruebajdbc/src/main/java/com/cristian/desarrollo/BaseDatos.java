package com.cristian.desarrollo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {
    private Connection conn;
    
    public Connection getConnection(String url) throws SQLException{
        return getConnection(url, "", "");
    }
    
    // Método para realizar conexión
    public Connection getConnection(String url, String user, String password) throws SQLException{
        if(conn == null){
            conn = DriverManager.getConnection(url, user, password);
        }
        return conn;
    }

    // Método para cerrar conexión
    public void closeConnection() throws SQLException{
        if (conn != null) 
            conn.close();
    }
}
