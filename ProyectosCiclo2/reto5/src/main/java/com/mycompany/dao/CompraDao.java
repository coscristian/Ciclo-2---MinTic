
package com.mycompany.dao;

import com.mycompany.modelo.Compra;
import com.mycompany.util.JDBCUtilities;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompraDao {
    
    private List<Compra> compras;
    
    public List<Compra> listar() throws SQLException{
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        try{
            pstmt = JDBCUtilities.getConnection()
                    .prepareStatement("SELECT c.ID_Compra, p.Constructora, p.Banco_Vinculado as banco"
                            + " FROM Compra c"
                            + " JOIN Proyecto p ON C.ID_Proyecto = p.ID_Proyecto"
                            + " WHERE p.Ciudad = 'Salento';");
            rset = pstmt.executeQuery();
            compras = new ArrayList<>();
            
            while(rset.next()){
                var compra = new Compra(rset.getInt("ID_Compra"), rset.getString("Constructora"), rset.getString("banco"));
                compras.add(compra);
            }
        }finally{
            if (pstmt != null)
               pstmt.close();
            if (rset != null)
                rset.close();
        }
        return compras;
    }
}
