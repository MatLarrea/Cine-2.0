/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cine.Views;

import com.mycompany.cine.Controller.ConectorDB;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JPanel;

/**
 *
 * @author mlarr
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() throws SQLException {
        initComponents();
        this.conector = new ConectorDB();
        this.conector.creaConexion();
        Bienvenida p1 = new Bienvenida();
        mostrarPanel(p1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        content = new javax.swing.JPanel();
        jMenuBarBarraHerramientas = new javax.swing.JMenuBar();
        jMenuOpciones = new javax.swing.JMenu();
        jMenuItemPeliculas = new javax.swing.JMenuItem();
        jMenuAcercaDe = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        getContentPane().add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 700, 520));

        jMenuBarBarraHerramientas.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBarBarraHerramientas.setForeground(new java.awt.Color(153, 153, 153));

        jMenuOpciones.setText("Opciones");

        jMenuItemPeliculas.setText("Peliculas");
        jMenuItemPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPeliculasActionPerformed(evt);
            }
        });
        jMenuOpciones.add(jMenuItemPeliculas);

        jMenuBarBarraHerramientas.add(jMenuOpciones);

        jMenuAcercaDe.setText("Acerca de");
        jMenuBarBarraHerramientas.add(jMenuAcercaDe);

        setJMenuBar(jMenuBarBarraHerramientas);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPeliculasActionPerformed
        
        ListaPeliculas p2 = new ListaPeliculas(this.conector);
        mostrarPanel(p2);
    }//GEN-LAST:event_jMenuItemPeliculasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void mostrarPanel(JPanel p1){
         
        p1.setSize(700, 500);
        p1.setLocation(0, 0);
        content.removeAll();
        content.add(p1, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }
    
    protected ConectorDB conector;
    protected Connection conexionOCI;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel content;
    private javax.swing.JMenu jMenuAcercaDe;
    private javax.swing.JMenuBar jMenuBarBarraHerramientas;
    private javax.swing.JMenuItem jMenuItemPeliculas;
    private javax.swing.JMenu jMenuOpciones;
    // End of variables declaration//GEN-END:variables
}