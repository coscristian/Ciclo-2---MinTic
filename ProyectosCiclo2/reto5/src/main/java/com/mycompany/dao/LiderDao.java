package com.mycompany.dao;

import com.mycompany.modelo.Lider;
import com.mycompany.util.JDBCUtilities;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LiderDao {
    
    private List<Lider> lideres;
    
    public List<Lider> listar() throws SQLException{
        PreparedStatement pstmt = null;
        ResultSet rset = null;
      
        try{
            pstmt = JDBCUtilities.getConnection()
                    .prepareStatement("SELECT ID_Lider as id,"
                            + " Nombre as nombre, Primer_Apellido as primerApellido,"
                            + " Ciudad_Residencia as ciudad FROM"
                            + " Lider"
                            + " ORDER BY ciudad;");
            rset = pstmt.executeQuery();

            lideres = new ArrayList<>();
            while(rset.next()){
                var lider = new Lider(rset.getInt("id"), rset.getString("nombre"),
                        rset.getString("primerApellido"), rset.getString("ciudad"));
                lideres.add(lider);
            } 
        }finally{
            if (pstmt != null)
                pstmt.close();
            
            if (rset != null)
                rset.close();
        }            
        return lideres;
    }
}
