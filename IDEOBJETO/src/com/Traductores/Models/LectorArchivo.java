/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Traductores.Models;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LectorArchivo 
{
    
    public LectorArchivo( String ruta )
    {       
    }// fin del constructor
	
    //metodo estatico que alamenca en un String el contenido de un archivo
    public static String obtenerTexto(String ruta)
    {
        String texto = "";
        try
        {
            String linea;
            FileReader archivo = new FileReader(ruta);
            BufferedReader leer = new BufferedReader(archivo);
            while((linea = leer.readLine())!= null) {
                texto += linea;
                texto += "\n";
            }
        }catch(FileNotFoundException error){
            error.printStackTrace();

        }catch (IOException error){
            error.printStackTrace();
        }      
        return texto;
    }//finde obtenerTexto


}

