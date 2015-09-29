/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Traductores.Models;

import java.util.StringTokenizer;



/**
 *
 * @author JC
 */
public class LectorArchivoXML 
{
    //private String texto = "";
    public LectorArchivoXML(String rua)
    {
        obtenerXML(rua);
    }
    
    public static String obtenerXML(String ruta)
    {
        
        String texto = LectorArchivo.obtenerTexto(ruta);
        StringTokenizer st = new StringTokenizer(texto,">");
        texto = "";
        texto += st.nextToken()+ ">\n";
        texto += st.nextToken()+ ">\n";
        while (st.hasMoreTokens()) 
        {  
            String token = st.nextToken();
            if(token.equals("</MoldeObjeto"))
            {
                texto += token+ ">";
            }else{
                 //System.out.print("\t"+token + ">\n"); 
                texto += "    "+token + ">\n";
            }
        }
            
        return texto;
    }// fin del metodo obtenerXML
        
   
}
