package com.cristian.desarrollo;

import java.sql.SQLException;

public class App {
    public static void main( String[] args ){
        var baseDatos = new BaseDatos();
        var archivoDB = "//home//coscristian//Documentos//MisionTic 2022//Ciclo 2//MisionTIC-2022-R2-Ciclo2-Programacion_Basica//clase08//assets//hr.db";
        try{
            var connection = baseDatos.getConnection("jdbc:sqlite:" + archivoDB);
            System.out.println("Se ha realizado la conexión a la BBDD");



            baseDatos.closeConnection();
        }catch(SQLException ex){
            System.err.println(ex);
        }
    }

    public void nombre(){
        var statement = connection.createStatement(); // Instrucciones
        statement.execute("CREATE TABLE DEMO (ID INTEGER NOT NULL, NAME VARCHAR(200) NOT NULL, CONSTRAINT DEMO_Pk");
        statement.execute("insert into demo (id,name) values (1, 'Datos iniciales');");

        var rset = statement.executeQuery("SELECT * FROM DEMO"); // rset: Conjunto de datos resultantes, es un flujo de datos, por lo tanto hay que cerrarlo
        while(rset.next()){ // recorre todos los elementos de la consulta
            System.out.printf("ID: %d \t", rset.getInt("ID"));
            System.out.printf("NAME: %s %n", rset.getString("NAME"));

        }

        rset.close();
    }


}
