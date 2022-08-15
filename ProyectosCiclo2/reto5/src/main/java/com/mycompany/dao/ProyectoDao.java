
package com.mycompany.dao;

import com.mycompany.modelo.Proyecto;
import com.mycompany.util.JDBCUtilities;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDao {
    private List<Proyecto> proyectos;
    
    public List<Proyecto> listar() throws SQLException{
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        try{
            pstmt = JDBCUtilities.getConnection()
                    .prepareStatement("SELECT ID_Proyecto, Constructora,"
                            + " Numero_Habitaciones, Ciudad"
                            + " FROM Proyecto"
                            + " WHERE Clasificacion = 'Casa Campestre'"
                            + " AND CIUDAD IN ('Santa Marta', 'Cartagena', 'Barranquilla');");
            rset = pstmt.executeQuery();
            proyectos = new ArrayList<>();
            
            while(rset.next()){
                var proyecto = new Proyecto(rset.getInt("ID_Proyecto"),
                        rset.getString("Constructora"), rset.getInt("Numero_Habitaciones"),
                        rset.getString("Ciudad"));
                proyectos.add(proyecto);
            }
        }finally{
            if (pstmt != null)
                pstmt.close();
            if (rset != null)
                rset.close();
        }
        return proyectos;
    }
}
