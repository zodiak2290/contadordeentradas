/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entradas;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class MyTableCellEditor extends AbstractCellEditor implements TableCellEditor{


    private String OldValue=""; //Valor antiguo de la celda
    private String NewValue=""; //valor nuevo de la celda
    
    private String ID="";// Llave del registro
    private String cant="";
    private String fecha="";
    private JComponent component = new JTextField();


    public Object getCellEditorValue() {
        return ((JTextField)component).getText();
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        OldValue = value.toString();//Toma valor de celda antes de cualquier modificación
        
        ID = new insertar().obtenerId(new Consultas().getIdCarrera(table.getValueAt(row,0).toString()));//obtiene el ID unico del registro
        cant=table.getValueAt(row, 1).toString();
        fecha=table.getValueAt(row, 2).toString().substring(0, 19);
        //((JTextField)component).setText(value.toString());//coloca valor de la celda al JTextField
        System.out.println(OldValue);
         System.out.println(ID);
          System.out.println(cant);
           System.out.println(fecha);
        return component;
    }

    
    @Override
    public boolean stopCellEditing() {
       conexioninicio db=new conexioninicio();
        NewValue = (String)getCellEditorValue();//Captura nuevo valor de la celda
        //Compara valores, si no son iguales, debe actualizar registro
        if( !NewValue.equals(OldValue))
        {   //Realiza la actualizacion
            if( !db.update( NewValue, ID,cant,fecha ) )
            {   //Si existe algun error al actualizar, escribe viejo valor en la celda
                JOptionPane.showMessageDialog(null,"Error: No se puede actualizar");
                ((JTextField)component).setText(OldValue);
            }
        }
        return super.stopCellEditing();
    }
}