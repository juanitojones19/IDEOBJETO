/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Traductores.Models;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author JC
 */
public class Diccionario 
{
    private static HashMap<String, String> listaDiccionario = new HashMap<>();
    
    public Diccionario(String entrada)
    {
        cargarPalabras(entrada);
    }
    
    //memtodo que carga la lista de palabras reservadas desde un archivo
    public static void cargarPalabras(String archivo)
    {
        String[] arregloPalabras = LectorArchivo.obtenerTexto(archivo).split("\n");
        
        for(int i = 0; i < arregloPalabras.length; i++)
        {
            //System.out.println(" " + arregloPalabras[i]);
            StringTokenizer token = new StringTokenizer(arregloPalabras[i], "-");
             while (token.hasMoreTokens()) {
                //System.out.println("\nKey: " + token.nextToken() + " Valor: " + token.nextToken());
                listaDiccionario.put(token.nextToken(), token.nextToken());
            }
        }
    }//fin del metodo cargarPalabras
    
    //metodo que busca una palabra dada en la lista map
    public static boolean buscarPalabra(String palabra)
    {
        
        return listaDiccionario.containsKey(palabra);
    }// fin del metodo buscarPalabras
    
    public static HashMap obtenerListaPalabras()
    {
        return listaDiccionario;
    }
    
}
