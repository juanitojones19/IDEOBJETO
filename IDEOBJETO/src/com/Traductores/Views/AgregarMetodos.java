/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Traductores.Views;

import com.Traductores.Controllers.ClassController;
import com.Traductores.Controllers.MetodosControllers;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author JC
 */
public class AgregarMetodos extends javax.swing.JDialog {

    /**
     * Creates new form AgregarMetodos
     */
    public AgregarMetodos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public AgregarMetodos(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        texFieldNombreMetodo = new javax.swing.JTextField();
        botonNombreMetodo = new javax.swing.JButton();
        botonAgregarParametros = new javax.swing.JButton();
        botonAgregarVariablesLocales = new javax.swing.JButton();
        BotonAgregarNuevoMetodo = new javax.swing.JButton();
        botonTerminar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        texFieldNombreParametro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textFieldTipoRetorno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboBoxAcceso = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        textFieldTipoDato = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textFieldNmbreVariableLocal = new javax.swing.JTextField();
        textFieldTipoDatoVariableLocal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textFieldValorVariableLocal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre del metodo:");

        botonNombreMetodo.setText("Agregar");
        botonNombreMetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNombreMetodoActionPerformed(evt);
            }
        });

        botonAgregarParametros.setText("Agregar");
        botonAgregarParametros.setEnabled(false);
        botonAgregarParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarParametrosActionPerformed(evt);
            }
        });

        botonAgregarVariablesLocales.setText("Agregar");
        botonAgregarVariablesLocales.setEnabled(false);
        botonAgregarVariablesLocales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarVariablesLocalesActionPerformed(evt);
            }
        });

        BotonAgregarNuevoMetodo.setText("Agregar otro Metodo");
        BotonAgregarNuevoMetodo.setEnabled(false);
        BotonAgregarNuevoMetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarNuevoMetodoActionPerformed(evt);
            }
        });

        botonTerminar.setText("Terminar");
        botonTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTerminarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre del parametro:");

        jLabel5.setText("Tipo de retorno:");

        jLabel6.setText("Acceso:");

        comboBoxAcceso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "public", "priviate" }));

        jLabel7.setText("Tipo de Dato:");

        jLabel8.setText("Nombre de la variable:");

        jLabel9.setText("Tipo de dato:");

        jLabel10.setText("Valor:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonAgregarNuevoMetodo)
                .addGap(18, 18, 18)
                .addComponent(botonTerminar)
                .addGap(18, 18, 18)
                .addComponent(botonCancelar)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldTipoRetorno)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBoxAcceso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(texFieldNombreMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(textFieldTipoDato, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(texFieldNombreParametro)
                    .addComponent(textFieldNmbreVariableLocal)
                    .addComponent(textFieldTipoDatoVariableLocal)
                    .addComponent(textFieldValorVariableLocal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonAgregarParametros)
                    .addComponent(botonNombreMetodo)
                    .addComponent(botonAgregarVariablesLocales))
                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(texFieldNombreMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonNombreMetodo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(comboBoxAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(textFieldTipoRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(texFieldNombreParametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonAgregarParametros))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(textFieldTipoDato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textFieldNmbreVariableLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botonAgregarVariablesLocales))
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9))
                    .addComponent(textFieldTipoDatoVariableLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textFieldValorVariableLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonAgregarNuevoMetodo)
                    .addComponent(botonTerminar)
                    .addComponent(botonCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonNombreMetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNombreMetodoActionPerformed
        // TODO add your handling code here:
        MetodosControllers controladoMetodo = new MetodosControllers(this);
        controladoMetodo.validarNombreMetodo(comboBoxAcceso.getSelectedItem().toString(), getTexFieldNombreMetodo().getText(), 
                getTexFieldTipoRetorno().getText());
    }//GEN-LAST:event_botonNombreMetodoActionPerformed

    private void botonAgregarParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarParametrosActionPerformed
        // TODO add your handling code here:
        MetodosControllers controladoMetodo = new MetodosControllers(this);
        controladoMetodo.agregarParametros(getTexFieldNombreParametro().getText(), getTexFieldTipoDato().getText());
    }//GEN-LAST:event_botonAgregarParametrosActionPerformed

    private void botonAgregarVariablesLocalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarVariablesLocalesActionPerformed
        // TODO add your handling code here:
        MetodosControllers controladoMetodo = new MetodosControllers(this);
        controladoMetodo.agregarVarablesLocales(getTexFieldVariableLocal().getText(), getTexFieldTipoDatoVariableLocal().getText(),
            getTexFieldValorVariableLocal().getText());
    }//GEN-LAST:event_botonAgregarVariablesLocalesActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTerminarActionPerformed
        // TODO add your handling code here:
         JFileChooser fc=new JFileChooser();
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".xml","xml");
        fc.setFileFilter(filtro);

        //Abrimos la ventana, guardamos la opcion seleccionada por el usuario
        int seleccion=fc.showSaveDialog(this);

        //Si el usuario, pincha en aceptar
        if(seleccion == JFileChooser.APPROVE_OPTION)
        {          
            ClassController.GuardarXML(fc.getSelectedFile().toString());
            botonTerminar.setEnabled(false);
            //System.out.println(fc.getSelectedFile().toString());
            //textAreaXML.setText(LectorArchivoXML.obtenerXML(fc.getSelectedFile().toString()+".xml"));
            //botonAceptar.setEnabled(false);
            this.dispose();
            PantallaArchivoXML pantallaXML = new PantallaArchivoXML(this, true, fc.getSelectedFile().toString());
            pantallaXML.setVisible(true);
        }
    }//GEN-LAST:event_botonTerminarActionPerformed

    private void BotonAgregarNuevoMetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarNuevoMetodoActionPerformed
        // TODO add your handling code here:
        getTexFieldNombreMetodo().setText("");
        getTexFieldTipoDato().setText("");
        getTexFieldNombreParametro().setText("");
        getTexFieldTipoDatoVariableLocal().setText("");
        getTexFieldVariableLocal().setText("");
        getTexFieldValorVariableLocal().setText("");
        getBotonAgregarParametros().setEnabled(false);
        getBotonAgregarVariablesLocales().setEnabled(false);
        getBotonNombreMetodo().setEnabled(true);
        MetodosControllers.borrarListaParametros();
        MetodosControllers.borrarListaVariablesLocales();
    }//GEN-LAST:event_BotonAgregarNuevoMetodoActionPerformed

    public void mensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgregarMetodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarMetodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarMetodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarMetodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarMetodos dialog = new AgregarMetodos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregarNuevoMetodo;
    private javax.swing.JButton botonAgregarParametros;
    private javax.swing.JButton botonAgregarVariablesLocales;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonNombreMetodo;
    private javax.swing.JButton botonTerminar;
    private javax.swing.JComboBox comboBoxAcceso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField texFieldNombreMetodo;
    private javax.swing.JTextField texFieldNombreParametro;
    private javax.swing.JTextField textFieldNmbreVariableLocal;
    private javax.swing.JTextField textFieldTipoDato;
    private javax.swing.JTextField textFieldTipoDatoVariableLocal;
    private javax.swing.JTextField textFieldTipoRetorno;
    private javax.swing.JTextField textFieldValorVariableLocal;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the BotonAgregarNuevoMetodo
     */
    public javax.swing.JButton getBotonAgregarNuevoMetodo() {
        return BotonAgregarNuevoMetodo;
    }

    /**
     * @return the botonAgregarParametros
     */
    public javax.swing.JButton getBotonAgregarParametros() {
        return botonAgregarParametros;
    }

    /**
     * @return the botonAgregarVariablesLocales
     */
    public javax.swing.JButton getBotonAgregarVariablesLocales() {
        return botonAgregarVariablesLocales;
    }

    /**
     * @return the botonCancelar
     */
    public javax.swing.JButton getBotonCancelar() {
        return botonCancelar;
    }

    /**
     * @return the botonNombreMetodo
     */
    public javax.swing.JButton getBotonNombreMetodo() {
        return botonNombreMetodo;
    }

    /**
     * @return the botonTerminar
     */
    public javax.swing.JButton getBotonTerminar() {
        return botonTerminar;
    }

    /**
     * @return the texFieldNombreMetodo
     */
    public javax.swing.JTextField getTexFieldNombreMetodo() {
        return texFieldNombreMetodo;
    }
    
     public javax.swing.JTextField getTexFieldNombreParametro() {
        return texFieldNombreParametro;
    }
     
     public javax.swing.JTextField getTexFieldVariableLocal() {
        return textFieldNmbreVariableLocal;
    }
     
     public javax.swing.JTextField getTexFieldTipoDato() {
        return textFieldTipoDato;
    }
     
    public javax.swing.JTextField getTexFieldTipoDatoVariableLocal() {
        return textFieldTipoDatoVariableLocal;
    }
    
    public javax.swing.JTextField getTexFieldTipoRetorno() {
        return textFieldTipoRetorno;
    }
    
    public javax.swing.JTextField getTexFieldValorVariableLocal() {
        return textFieldValorVariableLocal;
    }
    
}
