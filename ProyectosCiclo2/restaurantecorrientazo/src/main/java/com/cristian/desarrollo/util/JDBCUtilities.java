package com.cristian.desarrollo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Clase para realizar la conexión a la BBDD
public class JDBCUtilities {
    private static final String UBICACION_BD = "/home/coscristian/Escritorio/Ciclo-2---MinTic/ProyectosCiclo2/restaurantecorrientazo/src/main/resources/corrientazo.db";

    public static Connection getConnection() throws SQLException{
        String url = "jdbc:sqlite:" + UBICACION_BD;
        return DriverManager.getConnection(url);
    }
}
