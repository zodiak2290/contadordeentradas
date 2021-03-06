/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entradas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author pc
 */
public class RegistrosEdit extends javax.swing.JFrame {

    /**
     * Creates new form RegistrosEdit
     */
    public RegistrosEdit() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        Actualizar_Tabla();
       tablasm.getColumnModel().getColumn(1).setCellEditor(new MyTableCellEditor()); 
      System.out.println("columna: "  + tablasm.getColumnModel().getColumn(1));
    }
     private void Actualizar_Tabla(){
         conexioninicio ci = new conexioninicio();
     ci.conectar();
     Connection con = ci.getConnection();
     try
    {
        
       DefaultTableModel modelo = new DefaultTableModel();
       TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel> (modelo);
       tablasm.setRowSorter(elQueOrdena);  
       this.tablasm.setModel(modelo);
       
       tablasGraficas tg=new tablasGraficas();
       ResultSetMetaData rsMd = tg.datos(new Consultas().getListRegistros(), con);
       ResultSet rs=tg.getRS();
       int cantidadColumnas = tg.cantidadcolumnas();
      
       for (int i = 1; i <= cantidadColumnas; ++i) {
        
         modelo.addColumn(rsMd.getColumnLabel(i));
         
       }
       while (rs.next()) {
         Object[] fila = new Object[cantidadColumnas];
         for (int i = 0; i < cantidadColumnas; ++i)
         {
           fila[i] = rs.getObject(i + 1);
           
         }
         modelo.addRow(fila);
       }
       rs.close();
       con.close();
     }
     catch (SQLException e)
     {
       if (con == null)
         return;
       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablasm = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                if(colIndex==1||colIndex==0){
                    return true;
                }
                return false; //Disallow the editing of any cell
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablasm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Carrera", "Cantidad", "Fecha"
            }

        ));
        jScrollPane1.setViewportView(tablasm);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public void iniciar() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrosEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrosEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrosEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrosEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrosEdit().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablasm;
    // End of variables declaration//GEN-END:variables
}
