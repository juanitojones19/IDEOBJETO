/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Traductores.Models;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;
/**
 *
 * @author JC
 */
public class ArchivoXML 
{
    private static Document doc;
    private static Element clase;
    private static Element variable;
    private static Element metodo;
    private static Element variableLocal;
    public ArchivoXML()
    {
        crearDocumentoXML();

    }//fin del constructor

    //prepara el documento XML
    public static void crearDocumentoXML()
    {
        try
        {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.newDocument();
            doc.setXmlStandalone(true);

            //crea tag principal
            //documento = doc.createElement("Documento");
        }catch(ParserConfigurationException ex){
            ex.printStackTrace();
        }
    }// fin del metodo crearDocumetnoXML


    public static void crearTagClase(String nombreClase )
    {

        clase = doc.createElement("MoldeObjeto");
        clase.setAttribute("nombreClase", nombreClase);

    }// fin del elemento crearTagParrafoOracion

    public static void crearTagVarialbe(String acceso, String nombreVariable, String tipoValor, String valor)
    {
        variable = doc.createElement("AtributoObjeto");
        variable.setAttribute("acceso", acceso);
        variable.setAttribute("nombre", nombreVariable);
        variable.setAttribute("Tipodevalor", tipoValor);
        variable.setAttribute("Valor", valor);
        clase.appendChild(variable);
    }
    
    public static void crearTagMetodo(String acceso, String nombreMetodo, String tipoRetorno)
    {
        metodo = doc.createElement("metodo");
        metodo.setAttribute("acesso", acceso);
        metodo.setAttribute("nombre", nombreMetodo);
        metodo.setAttribute("tipoderetorno", tipoRetorno);
        clase.appendChild(metodo);
        
    }
    
    public static void atributoParametro(String nombreParametro, String tipoDato)
    {
        metodo.setAttribute("parametro" + nombreParametro, nombreParametro);
        metodo.setAttribute("tipoDatode" + nombreParametro, tipoDato);
        
    }
    
    public static void tagVariablesLocales(String nombreVariable, String tipoDato, String valor)
    {
        variableLocal = doc.createElement("varialbeLocla");
        variableLocal.setAttribute("TipoDato", tipoDato);
        variableLocal.setAttribute("NombreVariable", nombreVariable);
        variableLocal.setAttribute("Valor", valor);
        metodo.appendChild(variableLocal);
        
    }

    //crear documento XML
    public static void contendioXML(String ruta)
    {
        try
        {
            
            //se agrega el tago principal al documento
            doc.appendChild(clase);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(doc);
            File archivo = new File(ruta+".xml");
            StreamResult result = new StreamResult(archivo);
            transformer.transform(source, result);
            //contenido = result.getWriter().toString();
        }catch (TransformerConfigurationException ex){
            ex.printStackTrace();
        }catch (TransformerException ex){
            ex.printStackTrace();
        }
        
    }// fin del metodo crearXML
}
