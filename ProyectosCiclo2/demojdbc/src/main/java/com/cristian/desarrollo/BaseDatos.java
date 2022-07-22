package com.cristian.desarrollo;


import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cristian.desarrollo.dto.Departments;
import com.cristian.desarrollo.dto.Jobs;

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

    public List<Jobs> listarCargos() throws SQLException{
        var resp = new ArrayList<Jobs>();
        
        // Permite crear las sentencias SQL
        var statement = conn.createStatement();
        var rset = statement.executeQuery("SELECT * FROM jobs");
        while(rset.next()){
            var jobs = new Jobs();
            // Asignar los valores de cada elemento de la BBDD
            jobs.setId(rset.getInt("job_id"));
            jobs.setTitle(rset.getString("job_title"));
            jobs.setMaxSalary(rset.getDouble("max_salary"));
            jobs.setMinSalary(rset.getDouble("min_salary"));
            resp.add(jobs);
        }
        rset.close();
        return resp;
    }

    public boolean crearDepartamento(Departments departamento) throws SQLException{
        var statement = conn.createStatement();
        var lineas = statement.executeUpdate(
            String.format("INSERT INTO departments (department_id, department_name, location_id)" +
            " VALUES (%d, %s, %d)",
            departamento.getId(), departamento.getName(), departamento.getLocation()));
        return lineas == 1;
    }

}