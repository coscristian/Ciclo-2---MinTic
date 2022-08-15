/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Clase para realizar la conexión a la BBDD
public class JDBCUtilities {
    private static final String UBICACION_BD = "/home/coscristian/Escritorio/Ciclo-2---MinTic/ProyectosCiclo2/reto5/src/main/java/com/mycompany/resources/ProyectosConstruccion.db";

    public static Connection getConnection() throws SQLException{
        String url = "jdbc:sqlite:" + UBICACION_BD;
        return DriverManager.getConnection(url);
    }
}

