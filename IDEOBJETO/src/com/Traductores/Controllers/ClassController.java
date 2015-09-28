/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Traductores.Controllers;

import com.Traductores.Models.*;
import com.Traductores.Views.AgregarAtributosVista;
import com.Traductores.Views.NuevoArchivo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.tools.Diagnostic;

/**
 *
 * @author JC
 */
public class ClassController 
{
    private static String mensaje;
    private static String nombreClase;
    private NuevoArchivo vista;
    private final String mensajeErrorIdentificadorNoValido = "El nombre no es un identificador valido";
    private final String mensajeErrorPalabraReservada = "El nombre es una palabra reservada";
    
    
    public ClassController(NuevoArchivo vista, String nombreClase)
    {
        this.nombreClase = nombreClase;
        this.vista = vista;
        //Diccionario.cargarPalabras("palabrasReservadas.txt");
        validarNombre(nombreClase);
        this.vista.agregarAtribustListener(new AgregarListener());
    }
    
    public void validarNombre(String nombreClase)
    {
        if(!ClassModel.esPalabraReservada(nombreClase))// si no es palabra reservada
        {
            if(ClassModel.esNombreValido(nombreClase))// si el nombre es valido se genra el XML
            {
                ArchivoXML.crearDocumentoXML();
                ArchivoXML.crearTagClase(nombreClase);
                vista.activarBotonTerminar(true);
                vista.activarBotonSiguiente(true);
            }else{// si el no nombre es valido
                vista.mensaje(mensajeErrorIdentificadorNoValido);
            }
        }else{//si es palabra reservada
            //Diccionario.cargarPalabras("palabrasReservadas.txt");
            vista.mensaje(Diccionario.obtenerListaPalabras().get(nombreClase));
        }
    }
    
    public static String getMensaje()
    {
        return mensaje;
    }
    
    public static void GuardarXML(String ruta)
    {
        ArchivoXML.contendioXML(ruta);
    }
    
    class AgregarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            AgregarAtributosVista vistaAtributos = new AgregarAtributosVista(vista, true);
            vistaAtributos.setVisible(true);
            vistaAtributos.setModal(true);
            VariableController controladorAtributos = new VariableController(vistaAtributos);
            
        }
    
    }
    
}





