/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Traductores.Models;

/**
 *
 * @author JC
 */
public class ClassModel 
{
    private static final String regexIdentificador = "[^\\d]\\w*";
    
    public static boolean esNombreValido(String nombreClase)
    {
        return nombreClase.matches(regexIdentificador);
    }
    
    public static boolean esPalabraReservada(String nombreClase)
    {
        Diccionario.cargarPalabras("palabrasReservadas.txt");
        return Diccionario.buscarPalabra(nombreClase);
    }
    
    public static void generarXmlClase(String nombreClase)
    {
        System.out.printf("Se genero la clase %s\n", nombreClase);
    }
    
    public static void crearClase(String nombreClase)
    {
        ArchivoXML.crearDocumentoXML();
        ArchivoXML.crearTagClase(nombreClase);
    }
    
}
