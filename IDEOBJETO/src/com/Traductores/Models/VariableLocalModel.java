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
public class VariableLocalModel 
{
    private static final String regex = "[^\\d]\\w*";
    private static List<String> listaVariablres = new ArrayList();
    private static boolean bandera = true;
    private static String mensaje = "";

    /**
     * @return the listaVariablres
     */
    public static List<String> getListaVariablres() {
        return listaVariablres;
    }
    private JDialog ventana;
    
    public VariableLocalModel( JDialog ventanaDialogo, String nombreVariable, String tipoValor, String valor)
    {
        DiccionarioTipoDatos.cargarPalabras("TipodeVariables.txt");
        Diccionario.cargarPalabras("palabrasReservadas.txt");
        ventana = ventanaDialogo;
        if(esNombreValido(nombreVariable))
        {
            if(!esPalabraReservada(nombreVariable))// si no es palabra reservada sigue evaluando 
            {
                if(tipoValorValido(tipoValor))// si el tipo de valor corresponde a los que existe en java
                {
                    //JOptionPane.showMessageDialog(ventanaDialogo, "nombre de variable correcta, no es palabra reservada y es tipo de valor valido");
                    //listaVariablres.add(nombreVariable);
                    agregarVariable(nombreVariable, tipoValor, valor);
                                       
                }else{// si no corresponden manda un mensaje
                    JOptionPane.showMessageDialog(ventanaDialogo, "Tipo de valor no valiod");
                }// fin del if - else
            }else{// de lo contrario no sigue y manda un mensaje
                JOptionPane.showMessageDialog(ventanaDialogo, Diccionario.obtenerListaPalabras().get(nombreVariable));
            }
        }else{// si no es un nombre valido manda un mensae de error
            JOptionPane.showMessageDialog(ventanaDialogo, "Nombre de variable invalido");
        }
    }// fin del constructor
    
    public static boolean validar(String nombreVariable, String tipoValor)
    {
        DiccionarioTipoDatos.cargarPalabras("TipodeVariables.txt");
        Diccionario.cargarPalabras("palabrasReservadas.txt");
        boolean valido = true;
        if(esNombreValido(nombreVariable))
        {
            if(!esPalabraReservada(nombreVariable))// si no es palabra reservada sigue evaluando 
            {
                if(tipoValorValido(tipoValor))// si el tipo de valor corresponde a los que existe en java
                {
                    //JOptionPane.showMessageDialog(ventanaDialogo, "nombre de variable correcta, no es palabra reservada y es tipo de valor valido");
                    //listaVariablres.add(nombreVariable);
                    //agregarVariable(nombreVariable, tipoValor, valor);
                                       
                }else{// si no corresponden manda un mensaje
                    //JOptionPane.showMessageDialog(ventanaDialogo, "Tipo de valor no valiod");
                    valido = false;
                    mensaje = tipoValor + "Tipo de valor no valiod";
                }// fin del if - else
            }else{// de lo contrario no sigue y manda un mensaje
                //JOptionPane.showMessageDialog(ventanaDialogo, Diccionario.obtenerListaPalabras().get(nombreVariable));
                mensaje = Diccionario.obtenerListaPalabras().get(nombreVariable).toString();
                valido = false;
            }
        }else{// si no es un nombre valido manda un mensae de error
            //JOptionPane.showMessageDialog(ventanaDialogo, "Nombre de variable invalido");
            mensaje = nombreVariable + "Nombre de variable invalido";
            valido = false;
        }
        return valido;
    }
    
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
        for(int i = 0; i < getListaVariablres().size(); i++)
        {
            //System.out.println("lista variablres: " + listaVariablres.get(i));
            if(getListaVariablres().get(i).equals(nombreVariable))// si ya se encuentra repetido
            {
                indicador = true;
            }
        }
        return indicador;
    }//fin del metodo yaSeAgrego
    
    //metodo que agregar el nombre de una variable a una lista
    public static boolean agregarVariable(String nombreVariable, String tipoValor, String valor)
    {
        boolean seAgrego = true;
        //System.out.println(bandera);
        if(bandera)// si es la primera vex que se agrega una variable a la clase
        {
            getListaVariablres().add(nombreVariable);
            bandera = false;
            ArchivoXML.tagVariablesLocales(nombreVariable, tipoValor, valor);
            mensaje = "Se agrego la variable: " + nombreVariable;
        }else{// de lo contrario
            if(yaSeAgrego(nombreVariable))// si el nombre de la variable esta repetido
            {
                //JOptionPane.showMessageDialog(ventana, "Ya se agrego la variable " + nombreVariable);//manda mensaje
                mensaje = "La variable: " + nombreVariable + " esta repetida";
                seAgrego = false;
            }else{// de lo contrario agrega el nombre de la variable
                getListaVariablres().add(nombreVariable);
                ArchivoXML.tagVariablesLocales(nombreVariable, tipoValor, valor);
                mensaje = "Se agrego correctamemente: " + nombreVariable;
            }//fin del if - else dentro del else
        }// fin del if - else
        return seAgrego;
    }//fin del metodo agregarVariable
    
    public static String obtenerMensaje()
    {
        return mensaje;
    }
    
}//fin de la clase VariableControlador
