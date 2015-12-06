/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Traductores.Views;

import com.Traductores.Controllers.ArchivoXMLController;
import com.Traductores.Controllers.ClassController;
import com.Traductores.Controllers.TokenController;
import com.Traductores.Models.EditarXML;
import static com.Traductores.Models.EditarXML.buscarTagCierreApertura;
import static com.Traductores.Models.EditarXML.buscarTagEditable;
import com.Traductores.Models.XMLValidator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author JC
 */
public class PantallaArchivoXML extends javax.swing.JDialog {

    /**
     * Creates new form PantallaArchivoXML
     */
    private String texto = "";
    private String ruta;
    
    public PantallaArchivoXML(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public PantallaArchivoXML(java.awt.Dialog parent, boolean modal, String ruta) {
        super(parent, modal);
        initComponents();
        this.ruta = ruta;
        setTexArea(this.ruta);
    }
    
    public void setTexArea(String ruta){
        //ArchivoXMLController.setArchivoXML(ruta);
        
        if(ClassController.getNombreProyecto() != null)
        {
            textAreaXML.setText(ArchivoXMLController.setArchivoXML(ClassController.getNombreProyecto()+"/"+ruta+".xml"));
        }else if(ClassController.obtenerRutaProyecto() != null){
            textAreaXML.setText(ArchivoXMLController.setArchivoXML(ClassController.obtenerRutaProyecto()+"/"+ruta+".xml"));
        }
        else{
            textAreaXML.setText(ArchivoXMLController.setArchivoXML("proyecto_IDEOBJ/"+ruta+".xml"));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaXML = new javax.swing.JTextArea();
        botonGuardarXML = new javax.swing.JButton();
        botonAnalizaToken = new javax.swing.JButton();
        editarBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        textAreaXML.setEditable(false);
        textAreaXML.setColumns(20);
        textAreaXML.setRows(5);
        jScrollPane1.setViewportView(textAreaXML);

        botonGuardarXML.setText("Validar");
        botonGuardarXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarXMLActionPerformed(evt);
            }
        });

        botonAnalizaToken.setText("Tokens");
        botonAnalizaToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnalizaTokenActionPerformed(evt);
            }
        });

        editarBoton.setText("Editar");
        editarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonGuardarXML, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(editarBoton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonAnalizaToken, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(botonGuardarXML)
                .addGap(41, 41, 41)
                .addComponent(botonAnalizaToken)
                .addGap(40, 40, 40)
                .addComponent(editarBoton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarXMLActionPerformed
        try {
            
            String texto = textAreaXML.getText();
            
            //se crea la carpeta
            File carpeta = new File("temposss");
            carpeta.mkdirs();
            try
            {
                //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
                File archivo=new File(carpeta.getPath()+"/"+ClassController.nombreClase()+".xml");

                //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
                FileWriter escribir=new FileWriter(archivo,true);

                //Escribimos en el archivo con el metodo write 
                escribir.write(texto);

                //Cerramos la conexion
                escribir.close();
            }

            //Si existe un problema al escribir cae aqui
            catch(Exception e)
            {
                System.out.println("Error al escribir");
            }
            
            XMLValidator validador = 
            new XMLValidator("lenguajeSchema.xsd",carpeta.getPath()+"/"+ClassController.nombreClase()+".xml");

           System.out.println
           ("706.xml es valido de acuerdo a cfdv32.xsd? "
                   + validador.isValido()); 

           if(!validador.isValido()){
               System.out.println(validador.getErrorMSg());
               ArchivoXMLController.GuardarArchivo(textAreaXML.getText());
           }
      
            
            

            
        } catch (SAXException ex) {
            Logger.getLogger(PantallaArchivoXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(PantallaArchivoXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PantallaArchivoXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(PantallaArchivoXML.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_botonGuardarXMLActionPerformed

    private void botonAnalizaTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnalizaTokenActionPerformed
        // TODO add your handling code here:
        pantallaReporteXML pantallaReporte = new pantallaReporteXML(this, true, TokenController.generarReporteXML());
        pantallaReporte.setTitle("Pantalla reporte");
        pantallaReporte.setVisible(true);
    }//GEN-LAST:event_botonAnalizaTokenActionPerformed

    private void editarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBotonActionPerformed
        // TODO add your handling code here:
        int posicion = textAreaXML.getCaretPosition();
        System.out.println("La posicion: " + posicion);
        if(!buscarTagCierreApertura(posicion, textAreaXML.getText()))
        {
            System.out.println("es editable carajo: " + posicion);
            //System.out.println("No esotoy dentro de un tag");
            if(buscarTagEditable(posicion, textAreaXML.getText()))
            {
                System.out.println("es editable carajo: " + posicion);
                textAreaXML.setEditable(true);
                caretDialogo agregarDialog = new caretDialogo(this, true, this);
                agregarDialog.setVisible(true);
                textAreaXML.insert(texto, posicion);
                textAreaXML.setEditable(false);
            }
            
        }
    }//GEN-LAST:event_editarBotonActionPerformed

    public void setTextCaret(String texto)
    {
        this.texto = texto;
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
            java.util.logging.Logger.getLogger(PantallaArchivoXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaArchivoXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaArchivoXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaArchivoXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PantallaArchivoXML dialog = new PantallaArchivoXML(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botonAnalizaToken;
    private javax.swing.JButton botonGuardarXML;
    private javax.swing.JButton editarBoton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAreaXML;
    // End of variables declaration//GEN-END:variables
}
