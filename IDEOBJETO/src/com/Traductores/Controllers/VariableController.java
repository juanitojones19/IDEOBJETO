/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Traductores.Controllers;

import com.Traductores.Models.Diccionario;
import com.Traductores.Models.VariableModel;
import com.Traductores.Views.AgregarAtributosVista;
/**
 *
 * @author JC
 */
public class VariableController {
    AgregarAtributosVista vista;
    private String nombrevariable;
    private String tipoDato;
    private String valor;
    private String acceso;
   
    public VariableController(AgregarAtributosVista vista)
    {
        this.vista = vista;
        this.acceso = vista.getjComboBox1().getSelectedItem().toString();
        this.nombrevariable = vista.getTextFielNombreVariable().getText();
        this.tipoDato = vista.getTextFieldTipoDato().getText();
        this.valor = vista.getTextFieldValor().getText();
        
        //this.vista.mostarMensajeError("nop");
        
        validarAtributos(this.nombrevariable, this.tipoDato, this.valor);
    }
    
    public void validarAtributos(String nombreVariable, String tipoDato, String valor){
        System.out.println(vista.getjComboBox1().getSelectedItem());
        if(VariableModel.validar(nombreVariable, tipoDato))
        {
            vista.mostarMensajeError("Exito");
            VariableModel.agregarVariable(this.acceso, nombreVariable, tipoDato, valor);
            vista.dispose();
        }else{
            vista.mostarMensajeError(VariableModel.obtenerMensaje());
        }
    }// fin del metodo validarAtributos


    
    
    
}
