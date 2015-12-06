/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Traductores.Models;

import com.Traductores.Controllers.ClassController;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Juanito
 */
public class ArchivosModels 
{
    public static void respaldoMarcaTiempo(File archivo)
    {
        System.out.println("Carpta" + archivo.getAbsolutePath());
        //System.out.println("Nombre del archivo: " + archivo.getName() + marcaTiempo());
        String nombre = archivo.getName();
        String[] nombreArchivo = nombre.split("\\.") ;
        nombre = nombreArchivo[0];
        String ruta = archivo.getAbsolutePath();
        String[] rutaArchivo = ruta.split(archivo.getName());
        ruta = rutaArchivo[0];
        System.out.println("Archivo: " + archivo);
        System.out.println("la rauta: " + rutaArchivo[0]);
        
        
        
       
        
        
        try{
            File carpeta;
            
            carpeta = new File(ruta+"Backups");
            carpeta.mkdirs();
            String rutaDirecta = ruta+carpeta.getName()+"/"+nombre+marcaTiempo()+".xml";
            System.out.println("La puta ruta" + rutaDirecta);
            
             System.out.println("La ruta: "  + ruta+carpeta+nombre+marcaTiempo()+".xml");
            
            FileWriter  save = new FileWriter(new File(rutaDirecta));
            save.write(LectorArchivo.obtenerTexto(archivo.getAbsolutePath()));
            save.close();
            JOptionPane.showMessageDialog(null,
                 "El archivo se a guardado Exitosamente",
                     "Información",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception err){
            err.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Su archivo no se ha guardado",
                "Advertencia",JOptionPane.WARNING_MESSAGE);
        }
        
    }//findel metodo respald
    
    public static String marcaTiempo()
    {
         Calendar c2 = Calendar.getInstance();
        
         String dia =  Integer.toString(c2.get(Calendar.DATE));
         String mes = Integer.toString(c2.get(Calendar.MONTH) + 1);
         String annio = Integer.toString(c2.get(Calendar.YEAR));
         String hora = Integer.toString(c2.get(Calendar.HOUR));
         String minuto = Integer.toString(c2.get(Calendar.MINUTE));
         String segundo = Integer.toString(c2.get(Calendar.SECOND));

         System.out.println("Anio: " + annio);
         System.out.println("MEs: " + mes);
         System.out.println("Dia: " + dia);
         System.out.println("Hora: " + hora);
         System.out.println("Minuto: " + minuto);
         System.out.println("Segudno: " + segundo);
        
        return annio+mes+dia+hora+minuto+segundo;
    }
}
