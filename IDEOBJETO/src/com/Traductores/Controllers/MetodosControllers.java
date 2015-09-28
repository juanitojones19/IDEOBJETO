/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Traductores.Controllers;

import com.Traductores.Models.MetodoModel;
import com.Traductores.Models.ParametroModel;
import com.Traductores.Models.VariableLocalModel;
import com.Traductores.Views.AgregarMetodos;

/**
 *
 * @author Juanito
 */
public class MetodosControllers 
{
    AgregarMetodos vista;
    private static String nombreMetodo;
    private static String parametro;
    private static String tipoDato;
    private static String acceso;
    
    public MetodosControllers(AgregarMetodos vista)
    {
        this.vista = vista;
        
    }
    
    public void validarNombreMetodo(String acceso, String nombreMetodo, String tipoRetorno)
    {
        if(MetodoModel.validarIdentificador(nombreMetodo)){// si el nombre es valido
            if(MetodoModel.tipoValorValido(tipoRetorno)){
                if(MetodoModel.agregarMetodo(acceso, nombreMetodo, tipoRetorno)){
                    vista.getBotonAgregarParametros().setEnabled(true);
                    vista.getBotonAgregarVariablesLocales().setEnabled(true);
                    vista.getBotonAgregarNuevoMetodo().setEnabled(true);
                    vista.getBotonNombreMetodo().setEnabled(false);
                }else{
                    vista.mensaje("Metodo: " + nombreMetodo + " yase agrego");
                }
                
            }else{
                vista.mensaje("Tipo de retorno invalido");
            }
            
        }else{// de lo contrario
            vista.mensaje("nombre no valido");
        }
    }// fin de validar nombreMtodo
   
    //validar Parametros
    public void agregarParametros(String nombreParametro, String tipoDato)
    {
        if(ParametroModel.validarIdentificador(nombreParametro)){
            if(ParametroModel.tipoValorValido(tipoDato)){
                if(ParametroModel.agregarParametros(nombreParametro, tipoDato)){
                    vista.mensaje("Se agrego correctamtne el parametro: " + nombreParametro);
                }else{
                    vista.mensaje("El parametro esta repetido");
                }
            }else{
                vista.mensaje("Nombre del parametro invalido");
            }
        }else{
            vista.mensaje("Tipo de retorno invalido");
        }
    }// fin del metdo agregarATributos
    
    //metodo para agregar variables locales
    public void agregarVarablesLocales(String nombreVariable, String tipoDato, String valor)
    {
        if(VariableLocalModel.validar(nombreVariable, tipoDato))// si el nombres es vlaido
        {
            if(VariableLocalModel.agregarVariable(nombreVariable, tipoDato, valor))// si no se ha agregado
            {
                this.vista.mensaje(VariableLocalModel.obtenerMensaje());
            }else{// si ya se agrego
                this.vista.mensaje(VariableLocalModel.obtenerMensaje());
            }
        }else{// si no es valido el nombre
            this.vista.mensaje(VariableLocalModel.obtenerMensaje());
        }
    }// fin dle metod agregarVarablesLoclaes
    
    public static void borrarListaParametros(){
        ParametroModel.getListaMetodos().clear();
    }
    public static void borrarListaVariablesLocales(){
        VariableLocalModel.getListaVariablres().clear();
    }
    
    
    
}
