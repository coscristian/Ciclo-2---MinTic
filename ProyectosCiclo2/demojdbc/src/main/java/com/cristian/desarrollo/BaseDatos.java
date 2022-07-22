package com.cristian.desarrollo;


import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cristian.desarrollo.dto.Departments;

public class BaseDatos {
    private Connection conn;
    
    public Connection getConnection(String url) throws SQLException{
        return getConnection(url, "", "");
    }

    public Connection getConnection(String url, String username, String password) throws SQLException{
        if (conn == null){
            //Pedir la conexión: Driver Manager permite dar la conexión dada la URL
            conn = DriverManager.getConnection(url, username, password);
        }
        return conn;
    }  

    public void closeConnection() throws SQLException{
        if(conn != null){
            conn.close();
        }
    }

    public List<Departments> listarDepartamentos() throws SQLException{
        var resp = new ArrayList<Departments>();
        
        // Permite crear las sentencias SQL
        var statement = conn.createStatement();
        var rset = statement.executeQuery("SELECT * FROM departments");
        while(rset.next()){
            var departments = new Departments();
            // Asignar los valores de cada elemento de la BBDD
            departments.setId(rset.getInt("department_id"));
            departments.setName(rset.getString("department_name"));
            departments.setLocation(rset.getInt("location_id"));
            resp.add(departments);
        }
        rset.close();
        return resp;
    }
}