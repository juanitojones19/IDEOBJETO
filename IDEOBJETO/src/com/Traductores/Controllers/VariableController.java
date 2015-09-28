/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Traductores.Controllers;

import com.Traductores.Models.Diccionario;
import com.Traductores.Models.VariableModel;
import com.Traductores.Views.AgregarAtributosVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author JC
 */
public class VariableController {
    AgregarAtributosVista vista;
   
    public VariableController(AgregarAtributosVista vista)
    {
        this.vista = vista;
        this.vista.agregarAtributosListener(new AgregarAtributosListener());
        
    }
    
    class AgregarAtributosListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            /*
            if(VariableModel.esNombreValido(vista.getTextFielNombreVariable().getText())){
                if (!VariableModel.esPalabraReservada(vista.getTextFielNombreVariable().getText())) {
                    VariableModel.agregarVariable(vista.getTextFielNombreVariable().getText(), vista.getTextFieldTipoDato().getText(), vista.getTextFieldValor().getText());
                }else{//es palabra reservada
                    vista.mostarMensajeError(Diccionario.obtenerListaPalabras().get(vista.getTextFielNombreVariable().getText()));
                }
            }else{//no es nombre valido
                vista.mostarMensajeError("No es nombre valido");
                
            }// fin if else
            */
            if(VariableModel.validar(vista.getTextFielNombreVariable().getText(), vista.getTextFieldTipoDato().getText()))
            {
                vista.mostarMensajeError(VariableModel.obtenerMensaje());
                VariableModel.agregarVariable(vista.getTextFielNombreVariable().getText(), vista.getTextFieldTipoDato().getText(), vista.getTextFieldValor().getText());
            }else{
                vista.mostarMensajeError(VariableModel.obtenerMensaje());
            }
            System.out.println("Botno");
        }//fin metodo actionPerformed
    
    }//fin de la clase interna
    
}
