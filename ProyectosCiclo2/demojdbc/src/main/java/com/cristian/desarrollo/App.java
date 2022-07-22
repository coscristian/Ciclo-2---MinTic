package com.cristian.desarrollo;

import com.cristian.desarrollo.dto.BaseDatos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main( String[] args ){
        var baseDatos = new BaseDatos();
        var archivoDB = "//home//coscristian//Escritorio//Ciclo-2---MinTic//BBDD//SQL//hr.db";
        try{
            // 1. Realizar conexión con la BBDD
            var connection = baseDatos.getConnection("jdbc:sqlite:" + archivoDB);
            System.out.println("Se ha realizado la conexión a la BBDD");
            
            // 2. Permitir realizar comandos SQL
            var statement = connection.createStatement();
            
            // 3. Añadir sentencias SQL
            // statement.execute("CREATE TABLE DEMO (ID INTEGER NOT NULL, NAME VARCHAR(200) NOT NULL, CONSTRAINT DEMO_PK PRIMARY KEY(ID));");
            // statement.execute("insert into demo (id, name) values (1, 'Datos iniciales');");
            // statement.execute("insert into demo (id, name) values (2, 'Datos adicionales');");
            
            // Traer datos y mostrar datos
            ResultSet rset = statement.executeQuery("SELECT * FROM DEMO;");
            while(rset.next()){
                System.out.printf("ID: %d \t", rset.getInt("ID"));
                System.out.printf("NAME: %s \t%n", rset.getString("NAME"));
            }
            // statement.execute("DROP TABLE DEMO;");


            // Final --> Cerrar conexión con BBDD
            baseDatos.closeConnection();
        }catch(SQLException ex){
            System.err.println("Existe un probema al trabajar con la base de datos: \n" + ex.getMessage());
        }
    }
}