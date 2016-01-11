package entradas;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class tablasGraficas {
    ResultSet rs=null;
    ResultSetMetaData rsMd=null;
    public ResultSet tablas(String consulta ,Connection con) { 
   
     try
    {
       Statement stmt = con.createStatement();
      rs = stmt.executeQuery(consulta);    
     }    
     catch (SQLException e)
     {
       if (con == null)
       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
    }   
     return rs;
    }
    public ResultSetMetaData datos(String consulta,Connection con) throws SQLException
    {
       rs = tablas(consulta,con);
         rsMd = rs.getMetaData();
        return rsMd;
    }
    public int cantidadcolumnas() throws SQLException
    {
        int cantidadColumnas = rsMd.getColumnCount();
        return cantidadColumnas;
    }
    
 public ResultSet getRS()
 {
     return this.rs;
 }
 public ResultSetMetaData getRSmd()
 {
     return this.rsMd;
 }
}
