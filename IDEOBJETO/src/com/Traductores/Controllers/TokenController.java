/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Traductores.Controllers;
import com.Traductores.Models.TokenModel;
import java.io.File;
/**
 *
 * @author JC
 */
public class TokenController 
{
    public static String generarReporteXML()
    {
        //TokenModel.obtenerElementsoDeXML(new File(ClassController.nombreClase()+".xml"));
        return TokenModel.obtenerElementsoDeXML(new File("proyecto_IDEOBJ/"+ClassController.nombreClase()+".xml"));//prueba
 
    }
    
}
