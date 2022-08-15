
package com.mycompany.vista;

import com.mycompany.controlador.Reto5Controlador;
import com.mycompany.vista.modeloui.CompraTableModel;
import com.mycompany.vista.modeloui.LiderTableModel;
import com.mycompany.vista.modeloui.ProyectoTableModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class FrmPrincipall extends javax.swing.JFrame {
    private Reto5Controlador controlador;
    private LiderTableModel liderTableModel;
    private ProyectoTableModel proyectoTableModel;
    private CompraTableModel compraTableModel;
    
    public FrmPrincipall() {
        initComponents();
        setLocationRelativeTo(null);
        this.controlador = new Reto5Controlador();       
    }
   
    public void cargarDatosLideres(){
        try {
            var lideres = controlador.listarLideres();
            this.liderTableModel.setDatosLider(lideres);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error cargando los lideres de la consulta 1: " + ex.getMessage(),
                    "ERROR", ERROR_MESSAGE); 
        }                
    }
    
    public void cargarDatosProyectos(){
        try {
            var proyectos = controlador.listarProyectos();
            this.proyectoTableModel.setDatosProyecto(proyectos);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error cargando los Proyectos de la consulta 2: " + ex.getMessage(),
                    "ERROR", ERROR_MESSAGE);            
        }                
    }
    
    public void cargarDatosCompras(){
        try {
            var compras = controlador.listarCompras();
            this.compraTableModel.setDatosCompra(compras);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error cargando las Compras de la consulta 3: " + ex.getMessage(),
                    "ERROR", ERROR_MESSAGE);               
        }                
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrincipal = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reportes");
        setResizable(false);

        jButton1.setText("Ver Consulta 1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ver Consulta 2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ver Consulta 3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(66, 66, 66)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jButton3)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cristian Quesada Cossio");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jScrollPane1.setViewportView(tblPrincipal);
        tblPrincipal.setVisible(false);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Compras
        tblPrincipal.setVisible(true);
        this.compraTableModel = new CompraTableModel();
        tblPrincipal.setModel(this.compraTableModel);
        cargarDatosCompras();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Proyectos
        tblPrincipal.setVisible(true);
        this.proyectoTableModel = new ProyectoTableModel();
        tblPrincipal.setModel(this.proyectoTableModel);
        cargarDatosProyectos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tblPrincipal.setVisible(true);
        this.liderTableModel = new LiderTableModel();
        tblPrincipal.setModel(this.liderTableModel);
        cargarDatosLideres();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipall().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPrincipal;
    // End of variables declaration//GEN-END:variables
}
