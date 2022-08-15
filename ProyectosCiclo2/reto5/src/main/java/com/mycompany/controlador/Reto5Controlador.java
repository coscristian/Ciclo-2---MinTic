package com.mycompany.controlador;

import com.mycompany.dao.CompraDao;
import com.mycompany.dao.LiderDao;
import com.mycompany.dao.ProyectoDao;
import com.mycompany.modelo.Compra;
import com.mycompany.modelo.Lider;
import com.mycompany.modelo.Proyecto;
import java.sql.SQLException;
import java.util.List;

public class Reto5Controlador {
    
    private LiderDao liderDao;
    private ProyectoDao proyectoDao;
    private CompraDao compraDao;
    
    public Reto5Controlador(){
        this.liderDao = new LiderDao();
        this.proyectoDao = new ProyectoDao();
        this.compraDao = new CompraDao();
    }
    
    public List<Lider> listarLideres() throws SQLException{
        return liderDao.listar();
    }

    public List<Proyecto> listarProyectos() throws SQLException {
        return proyectoDao.listar();
    }

    public List<Compra> listarCompras() throws SQLException {
        return compraDao.listar();
    }
    
    
}
