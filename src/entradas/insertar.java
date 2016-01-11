/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entradas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class insertar {
ResultSet rs=null;
    public  String obtenerId( String cons)
    {
                 String id = null;
            
        try
    {
       
         conexioninicio ci = new conexioninicio();
         Connection con = null;
         try {
          con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());

          String cadenasql =cons;
          Statement stmt = con.createStatement();
         ResultSet rs=  stmt.executeQuery(cadenasql);
         rs.next();
         id=rs.getString("idcarrera");
         }
         catch (SQLException e)
         {
          JOptionPane.showMessageDialog(null, "Error", "Error", 0);
          JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
        }

      
     }
       
     catch (Exception e)
    {
    }
           return id;
    }
    public  void insert(int idcarr, String cant)
    {
        if(cant.length()>0 )
        {  
            if( (Integer.parseInt(cant))<10&&Integer.parseInt(cant)>0){
                
            
        try
    {
       
         conexioninicio ci = new conexioninicio();
         Connection con = null;
         try {
          con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());

          String cadenasql = "insert into registro(idcarrera,cantidad,fecha) values('"+ idcarr + "','" + cant + "',CURRENT_TIMESTAMP())";
          Statement stmt = con.createStatement();
           stmt.executeUpdate(cadenasql);
         }
         catch (SQLException e)
         {
          JOptionPane.showMessageDialog(null, "Error", "Error", 0);
          JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
        }

      
     }
       
     catch (Exception e)
    {
    }
        }
         else
        {
            JOptionPane.showMessageDialog(null, "No se pueden registrar mas de 10 entradas ala vez","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        }
    }
}



