/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Traductores.Models;

import com.Traductores.Controllers.ClassController;
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
import javax.xml.transform.OutputKeys;
import org.w3c.dom.DOMImplementation;
/**
 *
 * @author JC
 */
public class ArchivoXML 
{
    private static Document doc;
    private static Element clase;
    private static Element AtributoObjeto;
    private static Element AccionesObjetos;
    private static Element ParametrosComportamiento;
    private static Element variable;
    private static Element metodo;
    private static Element parametro;
    private static Element variableLocal;
    private static String contendioXML;
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
            DOMImplementation implementation = docBuilder.getDOMImplementation();
            doc = implementation.createDocument(null, null, null);
            //doc = docBuilder.newDocument();
            //doc.setXmlStandalone(true);

            //crea tag principal
            //documento = doc.createElement("Documento");
            AtributoObjeto = doc.createElement("AtributosObjetos");
            AccionesObjetos = doc.createElement("ComportamientosObjetos");
            ParametrosComportamiento = doc.createElement("ParametrosComportamiento");
        }catch(ParserConfigurationException ex){
            ex.printStackTrace();
        }
    }// fin del metodo crearDocumetnoXML


    public static void crearTagClase(String nombreClase )
    {

        clase = doc.createElement("MoldeObjeto");
        clase.setAttribute("nombreClase", nombreClase);
        //AtributoObjeto = doc.createElement("AtributosObjetos");

    }// fin del elemento crearTagParrafoOracion

    public static void crearTagVarialbe(String acceso, String nombreVariable, String tipoValor, String valor)
    {
        //AtributoObjeto = doc.createElement("AtributosObjetos");
        variable = doc.createElement("AtributoObjeto");
        variable.setAttribute("acceso", acceso);
        variable.setAttribute("nombre", nombreVariable);
        variable.setAttribute("Tipodevalor", tipoValor);
        variable.setAttribute("Valor", valor);
        AtributoObjeto.appendChild(variable);
        clase.appendChild(AtributoObjeto);
    }
    
    public static void crearTagMetodo(String acceso, String nombreMetodo, String tipoRetorno)
    {
        metodo = doc.createElement("ComportamientoObjeto");
        metodo.setAttribute("acceso", acceso);
        metodo.setAttribute("nombre", nombreMetodo);
        metodo.setAttribute("tipoderetorno", tipoRetorno);
        AccionesObjetos.appendChild(metodo);
        clase.appendChild(AccionesObjetos);
        
    }
    
    public static void atributoParametro(String nombreParametro, String tipoDato)
    {
        parametro = doc.createElement("Parametro");
        parametro.setAttribute("TipoDato", tipoDato);
        parametro.setAttribute("identificador", nombreParametro);
        ParametrosComportamiento.appendChild(parametro);
        metodo.appendChild(ParametrosComportamiento);
        
    }
    
    public static void tagVariablesLocales(String nombreVariable, String tipoDato, String valor)
    {
        System.out.println("Cae aqui la varible local");
        variableLocal = doc.createElement("VariableLocal");
        variableLocal.setAttribute("TipoDato", tipoDato);
        variableLocal.setAttribute("nombre", nombreVariable);
        variableLocal.setAttribute("valor", valor);
        metodo.appendChild(variableLocal);
        
    }

    //crear documento XML
    public static void contendioXML()
    {
        try
        {
             //AtributoObjeto.appendChild(variable);
             clase.appendChild(AtributoObjeto);
             clase.appendChild(AccionesObjetos);
            //se agrega el tago principal al documento
            doc.appendChild(clase);
            ///doc.getDocumentElement().appendChild(clase);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", new Integer(5));
            
            
            Transformer transformer = transformerFactory.newTransformer();
            
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            
            //transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            
            File carpeta;
//
            DOMSource source;
            File archivo;
            StreamResult result;
//            transformer.transform(source, result);
            
            if(ClassController.getNombreProyecto() != null)
            {
                carpeta = new File(ClassController.getNombreProyecto());
                carpeta.mkdirs();

                source = new DOMSource(doc);
                archivo = new File(carpeta + "/" +clase.getAttribute("nombreClase")+".xml");
                result = new StreamResult(archivo);
                transformer.transform(source, result);
            }else if(ClassController.obtenerRutaProyecto() != null){
                
                System.out.println("La ruta al abri el archivo: " + ClassController.obtenerRutaProyecto());
                
                source = new DOMSource(doc);
                archivo = new File( ClassController.obtenerRutaProyecto() +clase.getAttribute("nombreClase")+".xml");
                result = new StreamResult(archivo);
                transformer.transform(source, result);
                
            }else{
                System.out.println("Ruta de queso: " + ClassController.obtenerRutaProyecto());
                
                carpeta = new File("proyecto_IDEOBJ");
                carpeta.mkdirs();

                source = new DOMSource(doc);
                archivo = new File(carpeta + "/" +clase.getAttribute("nombreClase")+".xml");
                result = new StreamResult(archivo);
                transformer.transform(source, result);
            }
            
            
            //StreamResult resultado = new StreamResult(System.out);
            //transformer.transform(source, resultado);
            //System.out.println(result.getWriter().toString());
            
            
        }catch (TransformerConfigurationException ex){
            ex.printStackTrace();
        }catch (TransformerException ex){
            ex.printStackTrace();
        }
        
    }// fin del metodo crearXML
    
    public static String getContenidoXML(){
        return contendioXML;
    }
}//fin de la clase
