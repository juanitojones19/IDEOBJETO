/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Traductores.Models;

import com.Traductores.Views.PantallaArchivoXML;
import javax.swing.JTextArea;

/**
 *
 * @author Juanito
 */
public class EditarXML 
{
    static PantallaArchivoXML ventanapadre;
    public static void editarXML(int posicion, JTextArea areaTextoXML)
    {
        //int posicion = areaTextoXMl.getCaretPosition();
        //int posicion = areaTextoXMl.getCaretPosition();
        
        
            
    }
    
    public static boolean buscarTagCierreApertura(int posicion, String texto)
    {
        int tamano = texto.length();
        int delimitador = posicion;
        boolean posicionApertura = false;
        boolean posicionCierre = false;
        do{//hacia la izquierda
            if(texto.charAt(delimitador) == '<')
            {
                //posicionApertura = delimitador;
                posicionApertura = true;
                break;
            }else if(texto.charAt(delimitador) == '>'){
                break;
            }
            //System.out.println("Caracter: " + texto.charAt(delimitador) + "ESta enp osicion: " + delimitador);
            delimitador--;
        }while(delimitador >= 0);
        
        do//hacia la derecha
        {
            if(texto.charAt(delimitador) == '>')
            {
                //posicionCierre = delimitador;
                posicionCierre = true;
                break;
            }
            //System.out.println("Caracter: " + texto.charAt(delimitador) + "ESta enp osicion: " + delimitador);
            delimitador++;
        }while(delimitador <= tamano);
        
        if(posicionApertura && posicionCierre)
        {
            return true;
        }else{
            return false;
        }
        
    }// fin de metodo buscarTaga
    
    //busca el tag en el cual su contendio sera editable
    public static boolean buscarTagEditable(int posicion, String texto)
    {
        boolean esTag = false;
        int delimitador = posicion;
        do
        {
            if(texto.charAt(delimitador) == '>')
            {
                if(esTagComportamiento(posicion, texto))
                {
                    esTag = true;
                    break;
                }
                else{
                    esTag = false;
                }
                //break;
            }
            delimitador--;
        }while(delimitador >= 0);
        return esTag;
    }// fin del metodo buscarTagEditable
    
    //metodo que busca si es comportamiento objeto
    public static boolean esTagComportamiento(int posicion, String texto)
    {
        int delimitador = posicion;
        String nombreTag = "";
        StringBuilder builder;
        do
        {
            nombreTag = nombreTag + texto.charAt(delimitador);
            
            if(texto.charAt(delimitador) == '<')
            {
                //nombreTag = '<' + nombreTag;
                break;
            }
            delimitador--;
        }while(delimitador >= 0);
        builder = new StringBuilder(nombreTag);
        nombreTag = builder.reverse().toString();
        
        
        
        if(nombreTag.trim().equals("</ComportamientoObjeto>"))
        {
            
            return true;
        }else{
            return false;
        }
    }
        
        
    
}
