/*    */ package entradas;
/*    */ 
import java.awt.Font;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.SQLException;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import javax.swing.JOptionPane;
/*    */ import org.jfree.chart.ChartFactory;
/*    */ import org.jfree.chart.ChartFrame;
/*    */ import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.CategoryPlot;
/*    */ import org.jfree.chart.plot.PlotOrientation;
/*    */ import org.jfree.data.jdbc.JDBCCategoryDataset;
          import org.jfree.data.general.PieDataset;
import org.jfree.data.jdbc.JDBCPieDataset;




/*    */ 
/*    */ public class GeneraGrafica
/*    */ {
/*    */   String query;
/*    */   JDBCCategoryDataset dataset;
/*    */   String nombreven;
/*    */   String etiqhoriz;
/*    */   String etiverti;
          PieDataset data;
   String namegrafi;
   String fec;
   int buton;
   public void recibirparametros(String cons, String nomven, String ehor, String ever, int buton, String namegra,String fecha)
   {
     this.query = cons;
     this.nombreven = nomven;
     this.etiqhoriz = ehor;
     this.etiverti = ever;
     this.namegrafi = namegra;
     this.buton = buton;
     this.fec=fecha;
     generar();
   }
 public String getNombreGrafica()
 {
     String namegrafo;
     if(buton==0){
         namegrafo="Lineal";
     }
     else if(buton==1)
     {
       namegrafo=" de Barra";  
     }
     else if(buton==2)
     {
         namegrafo=" Circular";
     }
     else {
         namegrafo="Área";
     }
      return namegrafi + "" + namegrafo  + " " + fec;   
 }
   public void generar()
   {
       String nombregrafica=getNombreGrafica();
     conexioninicio ci = new conexioninicio();
     Connection con = null;
     try {
       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
     } catch (SQLException ex) {
       Logger.getLogger(GeneraGrafica.class.getName()).log(Level.SEVERE, null, ex);
     }

     try
     {
       this.dataset = new JDBCCategoryDataset(con, this.query);
       this.data=new JDBCPieDataset(con, this.query);
       
     } catch (Exception e) {
       JOptionPane.showMessageDialog(null, e);
     }
     JFreeChart chart;
     ChartFrame frame;
     if (this.buton == 0)
     {
       //chart = ChartFactory.createLineChart(this.namegrafi, this.etiqhoriz, this.etiverti, this.dataset, PlotOrientation.VERTICAL, true, true, true);
     // chart=ChartFactory.createCandlestickChart(query, etiverti, namegrafi, null, true)
      // chart=ChartFactory.createAreaChart(query, namegrafi, "Entradas", dataset, PlotOrientation.HORIZONTAL, true, true, true)       
         chart=ChartFactory.createLineChart(nombregrafica, etiverti, etiqhoriz, dataset, PlotOrientation.HORIZONTAL, true, true, true);     
         CategoryPlot plot=(CategoryPlot)chart.getPlot();
     plot.setNoDataMessage("No hay registros");
         //frame = new ChartFrame(this.nombreven, chart);
       //frame.setVisible(true);
       //frame.setSize(600, 600);
     } else if (this.buton==1){
       if (this.buton != 1) {
         return;
       }
     chart=ChartFactory.createBarChart3D(nombregrafica, etiverti, etiqhoriz, dataset, PlotOrientation.HORIZONTAL, true, true, true);               
     // chart=ChartFactory.createMultiplePieChart3D("prueba", dataset, TableOrder.BY_ROW, true, true, true);
      // frame = new ChartFrame(this.nombreven, chart);
       //frame.setVisible(true);
       //frame.setSize(600, 600);
     CategoryPlot plot=(CategoryPlot)chart.getPlot();
     plot.setNoDataMessage("No hay registros");
     }
     else if (this.buton==3){
      chart=ChartFactory.createAreaChart(nombregrafica, etiverti, etiqhoriz, dataset, PlotOrientation.HORIZONTAL, true, true, true);               
     
      // frame = new ChartFrame(this.nombreven, chart);
       //frame.setVisible(true);
       //frame.setSize(600, 600);
      
     }
     else {
         
         chart=ChartFactory.createPieChart3D(nombregrafica, data, true,true,true);
        
         PiePlot3D plot=(PiePlot3D)chart.getPlot();
         //p.setDepthFactor(0.3);
          plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
          plot.setNoDataMessage("No hay registros");
       // plot.setCircular(false);
       // plot.setLabelGap(0.02); 
         
         //frame = new ChartFrame(this.nombreven, chart);
         //frame.setSize(700, 700)
          //frame.setLocationRelativeTo(null);
       //frame.setVisible(true);
      
       
     }
     frame = new ChartFrame(this.nombreven, chart);
         frame.setSize(900, 700);
          frame.setLocationRelativeTo(null);
       frame.setVisible(true);
       
   }
 }

