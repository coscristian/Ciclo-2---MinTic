package com.cristian.desarrollo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.cristian.desarrollo.util.JDBCUtilities;

public class OpcionAlimentoDao<T> {

    private String tabla;
    public OpcionAlimentoDao(String tabla){
        this.tabla = tabla;
    }
    
    public List<T> listar(Function<ResultSet, T> mapper) throws SQLException{
        List<T> respuesta = null;

        Statement stmt = null;
        ResultSet rset = null;

        try {            
            stmt = JDBCUtilities.getConnection().createStatement();
            rset = stmt.executeQuery("SELECT * FROM " + tabla);
            respuesta = new ArrayList<>();
            
            while(rset.next()){
                var opcion = mapper.apply(rset);
                respuesta.add(opcion);
            }
        } catch (Exception e) {
            if (rset != null)
                rset.close();
            if (stmt != null)
                stmt.close();
        }


        return respuesta;
    }
}
