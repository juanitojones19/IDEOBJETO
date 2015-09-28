/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Traductores.Models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Juanito
 */
public class MetodoModel 
{
    private static final String regex = "[^\\d]\\w*";
    private static final List <String> listaMetodos = new ArrayList();
    private static boolean bandera = true;
    private static String mensaje;
    private JDialog ventana;
    
    public MetodoModel()
    {
        Diccionario.cargarPalabras("palabrasReservadas.txt");
    }
    
    public MetodoModel(JDialog ventanaDialogo, String nombreMetodo, String tipoRetorno)
    {
        Diccionario.cargarPalabras("palabrasReservadas.txt");
        ventana = ventanaDialogo;
        /*
        if(validarIdentificador(nombreMetodo))
        {
            //JOptionPane.showMessageDialog(ventanaDialogo, "Se agrego correctamente el metodo: " + nombreMetodo);
            if(validarTipoRetorno(tipoRetorno))
            {
                JOptionPane.showMessageDialog(ventanaDialogo, "Se agrego correctamente el metodo: " + nombreMetodo);
                agregarMetodo(nombreMetodo, tipoRetorno);
                listaMetodos.add(nombreMetodo);
            }else{
                JOptionPane.showMessageDialog(ventanaDialogo,  tipoRetorno + ": No es un tipo de retorno valido");
            }
        }else{
            JOptionPane.showMessageDialog(ventanaDialogo,  nombreMetodo + ": Es un nombre invalido");
        }
        */
    }// fin del constructor 
    
    //metodo que valida el nombre de un metodo
    public static boolean validarIdentificador(String nombreMetodo)
    {
        boolean valido = true;
        
        if(!esNombreValido(nombreMetodo))// si no es valido elnombre
        {
            valido = false;
        }else{// si lo es
            if(Diccionario.buscarPalabra(nombreMetodo))// si es una palabra reservada
            {
                valido = false;
            }
        }    
        return valido;
    }//fin del metodo validarIdentificador
    
    //metodo que verfica que el tipo de valor sea correcto
    public static boolean validarTipoRetorno(String tipoRetorno)
    {
        DiccionarioTipoDatos.cargarPalabras("TipoRetornoMetodo.txt");
        return DiccionarioTipoDatos.buscarPalabra(tipoRetorno);
    }// fin del metodo validarTipoRetorno
    
     public static boolean esNombreValido(String nombre)
    {
        return nombre.matches(regex);
    }
    
    public static boolean esPalabraReservada(String nombre)
    {
        return Diccionario.buscarPalabra(nombre);
    }
    
    public static boolean tipoValorValido(String tipoValor)
    {
        return DiccionarioTipoDatos.buscarPalabra(tipoValor);
    }
    // metodo que busca dentro de una lista si el elemento esta repedito
    public static boolean yaSeAgrego(String nombreVariable)
    {
        //System.out.println("Entra: " + nombreVariable);
        boolean indicador = false;
        for(int i = 0; i < listaMetodos.size(); i++)
        {
            //System.out.println("lista variablres: " + listaVariablres.get(i));
            if(listaMetodos.get(i).equals(nombreVariable))// si ya se encuentra repetido
            {
                indicador = true;
            }
        }
        return indicador;
    }//fin del metodo yaSeAgrego
    
    public static boolean agregarMetodo(String acesso, String nombreMetodo, String tipoValor)
    {
        boolean exitoso = true;
        if(bandera)// si es la primera vex que se agrega una variable a la clase
        {
            listaMetodos.add(nombreMetodo);
            bandera = false;
            ArchivoXML.crearTagMetodo(acesso, nombreMetodo, tipoValor);
        }else{// de lo contrario
            if(yaSeAgrego(nombreMetodo))// si el nombre de la variable esta repetido
            {
                //JOptionPane.showMessageDialog(ventana, "Ya se agrego la variable " + nombreMetodo);//manda mensaje
                exitoso = false;
            }else{// de lo contrario agrega el nombre de la variable
                listaMetodos.add(nombreMetodo);
                ArchivoXML.crearTagMetodo(acesso, nombreMetodo, tipoValor);
            }//fin del if - else dentro del else
        }// fin del if - else
        return exitoso;
    }
    
}
