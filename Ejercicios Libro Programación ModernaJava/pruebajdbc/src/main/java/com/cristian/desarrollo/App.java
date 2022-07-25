package com.cristian.desarrollo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class App {
    public static void main( String[] args ){
        var baseDatos = new BaseDatos();
        var archivo = "//home//coscristian//Escritorio//Ciclo-2---MinTic//BBDD//SQL//hr.db";
        try {
            var connection = baseDatos.getConnection("jdbc:sqlite:" + archivo, "", "");
            System.out.println("Se ha realizado la conexión a la BBDD");

            // Realizar consulta para mostrar todas las columna de la tabla Paises
            var sql = "SELECT * FROM COUNTRIES";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rset = pstmt.executeQuery();
            
            System.out.println("ID\tNAME\t\tREGION ID");

            while(rset.next()){
                String id_pais = rset.getString("country_id");
                String nombre_pais = rset.getString("country_name");
                Integer id_region = rset.getInt("region_id");
                System.out.printf("%s \t%s\t\t%d%n", id_pais, nombre_pais, id_region);
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
}
