
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
        System.out.println(obtenerElementsoDeXML(archivoXML));
    }

    //Metodo que obtiene los elementos de un xml por tags
    public static String obtenerElementsoDeXML(File archivoXML) 
    {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            Document doc = db.parse(archivoXML);
            Element clase = doc.getDocumentElement();
            NodeList atributosList =  clase.getElementsByTagName("AtributoObjeto");
            
            reporte += "Numero de atributos: " + atributosList.getLength() + "\n";
            reporte += obtenerElementosAtributosObjeto(atributosList);
            System.out.println(reporte);
            
            NodeList metodosList = clase.getElementsByTagName("ComportamientoObjeto");
            
            reporte += "Numero de comportamiento de objetos: " + metodosList.getLength() + "\n";
            reporte += obtenerElementosComportamientoObjeto(metodosList);
            System.out.println(reporte);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(TokenModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(TokenModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TokenModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reporte;
    }///Fin del metodo obtenerElemetosDeXML
    
    //metodo que obtiene los atributos del tag AtributoOjbeto
    public static String obtenerElementosAtributosObjeto(NodeList atributosList)
    {
        String reporteAtributos = "";
        if(atributosList != null & atributosList.getLength() > 0)
        {
            for(int i = 0; i < atributosList.getLength(); i++)
            {
                reporteAtributos  += i+1+".- Acceso: " + atributosList.item(i).getAttributes().getNamedItem("acceso").getNodeValue() +
                        "\nnombre: " + atributosList.item(i).getAttributes().getNamedItem("nombre").getNodeValue() + 
                        "\nTipo: " + atributosList.item(i).getAttributes().getNamedItem("Tipodevalor").getNodeValue() + 
                        "\nValor: " + atributosList.item(i).getAttributes().getNamedItem("Valor").getNodeValue() + "\n";
            }
        }else{
            System.out.println("No hay elementos");
        }
        System.out.println(reporte);
        return reporteAtributos;
    }//fin del metodo obtenerElentosAtributos
    
    //metodo que obtiene los atributos del tag ComportamientoOjbeto
    public static String obtenerElementosComportamientoObjeto(NodeList atributosList)
    {
        String reporteMetodos = "";
        if(atributosList != null & atributosList.getLength() > 0)
        {
            for(int i = 0; i < atributosList.getLength(); i++)
            {
                reporteMetodos += "\n"+ (i+1) +".- Acceso: " + atributosList.item(i).getAttributes().getNamedItem("acceso").getNodeValue() +
                        "\nnombre: " + atributosList.item(i).getAttributes().getNamedItem("nombre").getNodeValue() + 
                        "\nTipo de retorno: " + atributosList.item(i).getAttributes().getNamedItem("tipoderetorno").getNodeValue() + "\n";
                
                //System.out.println(atributosList.item(i).getChildNodes().item(i));
                reporteMetodos += obtenerElmentosVariablesLocales(atributosList.item(i).getChildNodes() , atributosList.item(i).getChildNodes().getLength());
                
                //System.out.println("Variable local:" + atributosList.item(0).getChildNodes().item(1).getAttributes().getNamedItem("Valor").getNodeValue());
            }
        }else{
            System.out.println("No hay elementos");
        }
        return reporteMetodos;
    }//fin del metodo obtenerElentosAtributos
    
    public static String obtenerElmentosVariablesLocales(NodeList variable, int numeroVariables)
    {
        String reporteVariablesLocales = "";
        //System.out.println("Variable local:" + listaVariable.item(0).getChildNodes().item(1).getAttributes().getNamedItem("NombreVariable").getNodeValue());
        //System.out.println("Variable local:" + variable.item(5).getAttributes().getNamedItem("NombreVariable").getNodeValue());
        //System.out.println("Tipo de dato:" + variable.item(5).getAttributes().getNamedItem("TipoDato").getNodeValue());
        //System.out.println("Valor:" + variable.item(5).getAttributes().getNamedItem("Valor").getNodeValue());

        //System.out.println("Variable local:" + variable.item(2).getAttributes().getNamedItem("NombreVariable").getNodeValue());
        if(variable != null )
        {
            for(int i = 1; i <= numeroVariables - 2; i=i+2)
            {                
                reporteVariablesLocales += "\n\tNombre: " + variable.item(i).getAttributes().getNamedItem("NombreVariable").getNodeValue() + 
                        "\n\tTipo de Dato: " + variable.item(i).getAttributes().getNamedItem("TipoDato").getNodeValue() +
                        "\n\tValor: " + variable.item(i).getAttributes().getNamedItem("Valor").getNodeValue() + "\n";             
            }    
        }else{
            System.out.println("No hay elementos");
        }
        return reporteVariablesLocales;
    }// obtiene los atributos del elemento variableLocal 
}// fin de la clase
