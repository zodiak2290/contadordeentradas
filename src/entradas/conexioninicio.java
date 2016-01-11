/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entradas;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author alberto
 */
public class conexioninicio {
public String bd = "biblio";
public String login = "root";
public String password = "1234";
String ip=new IPservidor().getLinea();

public String url = "jdbc:mysql://localhost/"+bd;
Connection conn=null;
public void conectar() {
    System.out.println(ip);
try {
Class.forName("org.gjt.mm.mysql.Driver");
conn = DriverManager.getConnection(url, login, password);
if (conn != null)
{
System.out.println("Conexión a base de datos "+url+" ... Ok");

}
}
catch(SQLException ex) {
System.out.println("Hubo un problema al intentar conectarse con la base de datos "+url);
System.out.println(ex);
}
catch(ClassNotFoundException ex) {
System.out.println(ex);
}
}
public String getURl()
    {
    return url;
}
public Connection getConnection()
{
    return conn;
}
public String getLogin()
    {
    return login;
}
public String getPassword()
    {
    return password;
}

public boolean update(String valor, String idcar,String canti,String fecha)
    {
        boolean res = false;   
         conexioninicio ci = new conexioninicio();
         Connection con = null;
         try {
             con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
             Statement stmt = con.createStatement();
                       
          String cadenasql = new Consultas().getActualizandoRegistro(valor, idcar, canti, fecha);
          stmt.executeUpdate(cadenasql);
          System.out.println(cadenasql);
           
           res=true;
         }
      
         catch (SQLException e)
         {
          JOptionPane.showMessageDialog(null, "Error", "Error", 0);
          JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
        }
        
    
          return res;
    }
}
