/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Traductores.Models;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

/**
 *
 * @author moy
 */
public class XMLValidator {
    
    private String errorMSg = "";
    private boolean valido = false;
    
    
    public XMLValidator(String xsdPath, String xmlPath){
        valido = validateXMLSchema(xsdPath, xmlPath);
    }
    
    private  boolean validateXMLSchema(String xsdPath, 
            String xmlPath){
         
        try {
            SchemaFactory factory = 
                    SchemaFactory.newInstance
        (XMLConstants.W3C_XML_SCHEMA_NS_URI);
           
            Schema schema = factory.newSchema
        (new File(xsdPath));
            
            Validator validator = schema.newValidator();
            
            
            validator.validate(new StreamSource
        (new File(xmlPath)));
            
        } catch (IOException | SAXException e) {
            errorMSg = e.getMessage();
            //System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * @return the errorMSg
     */
    public String getErrorMSg() {
        return errorMSg;
    }

    /**
     * @return the valido
     */
    public boolean isValido() {
        return valido;
    }
}
