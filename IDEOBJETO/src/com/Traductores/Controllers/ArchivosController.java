/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Traductores.Controllers;

import com.Traductores.Models.ArchivosModels;
import java.io.File;

/**
 *
 * @author Juanito
 */
public class ArchivosController 
{
    //se pasa al model para respaldarlo con marcatiempo
    public static void respaldarArchivo(File archivo)
    {
        ArchivosModels.respaldoMarcaTiempo(archivo);
    }
    
}
