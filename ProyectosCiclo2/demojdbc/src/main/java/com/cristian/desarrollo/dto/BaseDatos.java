package com.cristian.desarrollo.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {
    private Connection conn;
    
    public Connection getConnection(String url) throws SQLException{
        return getConnection(url, "", "");
    }

    public Connection getConnection(String url, String username, String password) throws SQLException{
        if (conn == null){
            //Pedir la conexión
            conn = DriverManager.getConnection(url, username, password);
        }
        return conn;
    }

    public void closeConnection() throws SQLException{
        if(conn != null){
            conn.close();
        }
    }

    public List<Departments> listarDepartamentos(){
        var resp = new ArrayList<Departments>();
        var statement = new Statement();

        // Listar Departamentos : Hacer consultaa en BBDD
        

        return resp;
    }

    public List<Jobs> listarCargos() throws Exception {

    }
}