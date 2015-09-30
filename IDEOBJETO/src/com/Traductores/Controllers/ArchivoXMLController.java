/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Traductores.Controllers;

import com.Traductores.Models.ArchivoXML;
import com.Traductores.Models.LectorArchivo;
import com.Traductores.Views.PantallaArchivoXML;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

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
    
    public static void Guardar()
    {
        
    }
    
    public static void GuardarArchivo(String contenidoXML)
        throws SAXException, ParserConfigurationException, IOException, TransformerConfigurationException, TransformerException {
        

        // Parse the given input
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(contenidoXML)));

        // Write the parsed document to an xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        
        File carpter = new File("proyecto_IDEOBJ");
        

        StreamResult result =  new StreamResult(new File(ClassController.nombreClase()));
        transformer.transform(source, result);
    }
    
}
