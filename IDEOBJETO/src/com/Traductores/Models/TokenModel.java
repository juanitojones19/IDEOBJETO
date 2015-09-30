/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Traductores.Models;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author JC
 */
public class TokenModel 
{
    private static String reporte = "";
    
    public TokenModel(File archivoXML)
    {
        obtenerElementsoDeXML(archivoXML);
    }

    //Metodo que obtiene los elementos de un xml por tags
    public static void obtenerElementsoDeXML(File archivoXML) 
    {
        int totalElementos = 0;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            Document doc = db.parse(archivoXML);
            Element clase = doc.getDocumentElement();
            NodeList atributosList =  clase.getElementsByTagName("AtributoObjeto");
            
            System.out.println("Numero de atributos: " + atributosList.getLength());
            obtenerElementosAtributosObjeto(atributosList);
            
            NodeList metodosList = clase.getElementsByTagName("ComportamientoObjeto");
            
            System.out.println("Numero de atributos: " + metodosList.getLength());
            obtenerElementosComportamientoObjeto(metodosList);
            
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(TokenModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(TokenModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TokenModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }///Fin del metodo obtenerElemetosDeXML
    
    //metodo que obtiene los atributos del tag AtributoOjbeto
    public static void obtenerElementosAtributosObjeto(NodeList atributosList)
    {
        if(atributosList != null & atributosList.getLength() > 0)
        {
            for(int i = 0; i < atributosList.getLength(); i++)
            {
                System.out.println(i+1+".- Acceso: " + atributosList.item(i).getAttributes().getNamedItem("acceso").getNodeValue() +
                        "\nnombre: " + atributosList.item(i).getAttributes().getNamedItem("nombre").getNodeValue() + 
                        "\nTipo: " + atributosList.item(i).getAttributes().getNamedItem("Tipodevalor").getNodeValue() + 
                        "\nValor: " + atributosList.item(i).getAttributes().getNamedItem("Valor").getNodeValue() + "\n");
            }
        }else{
            System.out.println("No hay elementos");
        }
    }//fin del metodo obtenerElentosAtributos
    
    //metodo que obtiene los atributos del tag AtributoOjbeto
    public static void obtenerElementosComportamientoObjeto(NodeList atributosList)
    {
        if(atributosList != null & atributosList.getLength() > 0)
        {
            for(int i = 0; i < atributosList.getLength(); i++)
            {
                System.out.println(i+1+".- Acceso: " + atributosList.item(i).getAttributes().getNamedItem("acceso").getNodeValue() +
                        "\nnombre: " + atributosList.item(i).getAttributes().getNamedItem("nombre").getNodeValue() + 
                        "\nTipo de retorno: " + atributosList.item(i).getAttributes().getNamedItem("tipoderetorno").getNodeValue() + "\n");
            }
        }else{
            System.out.println("No hay elementos");
        }
    }//fin del metodo obtenerElentosAtributos
    
    
}
