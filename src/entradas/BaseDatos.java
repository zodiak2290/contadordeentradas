/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entradas;

import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class BaseDatos {
    public  void Respaldar() {
 try{
int copia_seguridad;
Process runtimeProcess = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqldump --opt --password=15f64591ab --user=root --databases biblioteca -r C:\\Users\\pc\\Desktop\\biblioteca.sql");
copia_seguridad = runtimeProcess.waitFor();
if(copia_seguridad==1){
JOptionPane.showMessageDialog(null, "La copia de seguridad no se pudo generar");}
else 
if(copia_seguridad==0){
JOptionPane.showMessageDialog(null,"\nCopia de seguridad ha sido creada con exito.\n El archivo biblioteca.sql Ha sido creado en el Escritorio de Windows "); }
}catch(Exception e){ 
JOptionPane.showMessageDialog(null,e);
}
//JOptionPane.showMessageDialog(null, "Archivo generado", "Verificar",JOptionPane.INFORMATION_MESSAGE);
//}
}
    
    
    public  void Restaurar() {
 try{
int copia_seguridad;
Process runtimeProcess = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqldump  --password=15f64591ab --user=root --databases tienda -r C:\\Users\\pc\\Desktop\\tienda.sql");
copia_seguridad = runtimeProcess.waitFor();
if(copia_seguridad==1){
JOptionPane.showMessageDialog(null, "La copia de seguridad no se pudo generar");}
else 
if(copia_seguridad==0){
JOptionPane.showMessageDialog(null,"\nCopia de seguridad agregada con exito.\n Del archivo tienda.sql  "); }
}catch(Exception e){ 
JOptionPane.showMessageDialog(null,e);
}

}
}
