/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entradas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class IPservidor {
   String  pathToFile = "../Entradas/src/servidor.txt";
   String linea;
    public  IPservidor() 
     {
       try {
           Scanner scanner = new Scanner(new File(pathToFile));
        while(scanner.hasNextLine()){
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Entradas.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            }
       linea=scanner.nextLine();   
        }         
       } catch (FileNotFoundException ex) {
           Logger.getLogger(IPservidor.class.getName()).log(Level.SEVERE, null, ex);
       }
     }
    public String getLinea()
    {
        
        return linea;
    }
    
    public void cambiarIP(String IP)
    {
       eliminarArchivo(pathToFile);
          creaArc(pathToFile);
         EscribirLineaFicheNuevo(IP,pathToFile); 
    }
    public void eliminarArchivo(String pathToFile)
{
  File fichero = new File(pathToFile);  
  if (fichero.delete())
  {
      //System.out.println("El fichero ha sido borrado satisfactoriamente");
  }else
  { 
      //System.out.println();
  }
}
    public void creaArc(String pathToFile)
    {
       String nombreArchivo= pathToFile; // Aqui se le asigna el nombre y 
FileWriter fw = null;	 // la extension al archivo 
try { 
fw = new FileWriter(nombreArchivo); 

} 
catch (IOException ex) { 
}  
    }
    public void EscribirLineaFicheNuevo(String linea,String rutaarchivo)
    {
        try 
        {
                BufferedWriter out = new BufferedWriter(new FileWriter(rutaarchivo, true));
                out.write(linea+"\n");
                out.close();
        } catch (IOException e) 
        {
            System.out.println(e.getMessage());
        }
    }
}

