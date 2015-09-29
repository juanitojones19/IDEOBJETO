/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Traductores.Controllers;

import com.Traductores.Models.ArchivoXML;
import com.Traductores.Models.LectorArchivo;
import com.Traductores.Views.PantallaArchivoXML;

/**
 *
 * @author JC
 */
public class ArchivoXMLController 
{
    PantallaArchivoXML pantalla;
    
    public ArchivoXMLController(PantallaArchivoXML pantalla)
    {
        this.pantalla = pantalla;
    }
    
    public static String setArchivoXML(String ruta)
    {
        return LectorArchivo.obtenerTexto(ruta);
    }
    
    public static void GuardarArchivo()
    {
        
    }
    
}
