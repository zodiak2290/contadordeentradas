/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entradas;

/**
 *
 * @author pc
 */
public class Consultas {
 String entradasHoy="SELECT DATE( fecha ) as Hoy , nombrecarr as Carrera, SUM( cantidad ) AS Entradas\n" +
"FROM  `carrera` \n" +
"NATURAL JOIN registro\n" +
"WHERE \n" +
"DATE( fecha ) \n" +
"=  CURRENT_DATE\n" +
"GROUP BY DATE( fecha ) , nombrecarr\n" +
"ORDER BY DATE( fecha ) desc , nombrecarr" ;
 String entradasAñoCarrera="SELECT YEAR(fecha) AS Año,nombrecarr as Carrera, SUM(cantidad) AS Entradas\n" +
"FROM  `carrera` \n" +
"NATURAL JOIN registro\n" +
"GROUP BY YEAR(fecha) , nombrecarr\n" +
"ORDER BY  YEAR(fecha)desc , nombrecarr";
 String entradasAñoTotal="SELECT YEAR(fecha) AS Año,SUM(cantidad) AS Entradas\n" +
"FROM  carrera \n" +
"NATURAL JOIN registro\n" +
"GROUP BY YEAR(fecha) \n" +
"ORDER BY YEAR(fecha) desc";
 String entadaAñoTotalcomp="WHERE YEAR(fecha)='";
 String entradasDiaCarrera="SELECT DATE(fecha) as Día,nombrecarr as Carrera,SUM(cantidad) AS Entradas\n" +
"FROM carrera \n" +
"NATURAL JOIN registro\n" +
"GROUP BY DATE( fecha ) , nombrecarr\n" +
"ORDER BY DATE( fecha ) desc, nombrecarr";
 String entradasDiaTotal="SELECT DATE(fecha) AS Día,SUM(cantidad) AS Entradas\n" +
"FROM  carrera \n" +
"NATURAL JOIN registro\n" +
"GROUP BY DATE(fecha) \n" +
"oRDER BY DATE(fecha) desc";
 String entradaDiaTotalcomp="WHERE DATE(fecha)='";
 String entradasMesCarrera="SELECT YEAR(fecha) AS Año,MONTHNAME(fecha) AS Mes, nombrecarr as Carrera, SUM(cantidad) AS Entradas\n" +
"FROM  `carrera` \n" +
"NATURAL JOIN registro\n" +
"GROUP BY year(fecha) ,MONTHNAME(fecha) , nombrecarr\n" +
"ORDER BY year(fecha) desc,MONTHNAME(fecha) asc, nombrecarr";
 
 String entradasMesTotal="SELECT DATE_FORMAT(fecha,' %M %Y') AS Año ,SUM(cantidad) AS Entradas\n" +
"FROM carrera \n" +
"NATURAL JOIN registro\n" +
"GROUP BY year(fecha) ,month(fecha)\n" +
"ORDER BY year(fecha) desc,month(fecha) desc  ";
 String entradasMesTotal2="SELECT year(fecha) AS Año,monthname(fecha) as Mes,SUM(cantidad) AS Entradas\n" +
"FROM carrera \n" +
"NATURAL JOIN registro\n" +
"GROUP BY year(fecha) ,month(fecha)\n" +
"ORDER BY year(fecha) ,month(fecha) asc  ";
 String entradasMesTotalcom="WHERE YEAR(fecha)='";
 String entradasDiaCarreraGrafica="SELECT nombrecarr as Carrera,SUM(cantidad) AS 'Total de Visitas'\n" +
"FROM carrera \n" +
"NATURAL JOIN registro\n" +
"WHERE date(fecha)='"     ; 
  String entradasMesCarreraGrafica="SELECT nombrecarr as Carrera,SUM(cantidad) AS 'Total de Visitas'\n" +
"FROM carrera \n" +
"NATURAL JOIN registro\n" +
"WHERE YEAR(fecha)='"; 
  String entradasAñoCarreraGrafica="Select nombrecarr as Carrera, SUM(cantidad) AS Entradas\n" +
"FROM  `carrera` \n" +
"NATURAL JOIN registro\n" +
"WHERE YEAR(fecha)='"; 
  String entradasTodoCarreraGrafica="Select nombrecarr as Carrera, SUM(cantidad) AS Entradas\n" +
"FROM  `carrera` \n" +
"NATURAL JOIN registro gROUP BY nombrecarr order by nombrecarr";
  
public String getEntradasTotales(){
    return entradasTodoCarreraGrafica;
}

 public String getEntradasHoy()
 {
     return entradasHoy;
 }
 public String getEntradasAñoCarrera()
 {
     return entradasAñoCarrera;
 }
 public String getEntradasAñoTotal()
 {
     return entradasAñoTotal;
 }
 public String getEntradasDiaCarrera()
 {
     return entradasDiaCarrera;
 }
 public String getEntradasDiaTotal()
 {
     return entradasDiaTotal;
 }
 public String getEntradasMesCarrera()
 {
     return entradasMesCarrera;
 }
 public String getEntradasMesTotal()
 {
     return entradasMesTotal;
 }
 public String getEntradasAñoTotalcom(int año)
 {
     return entradasAñoTotal.substring(0, 89) + " " + entadaAñoTotalcomp  +  año + "'";
 }
 public String getEntradasMesTotalcom(int año,int mes)
 {
     return entradasMesTotal2.substring(0, 113) + " " + entradasMesTotalcom  +  año + "' and month(fecha)='"+mes+"' ";
 }
 public String getEntradasDiaTotalcom(int año,int mes,int dia)
 {
     return entradasDiaTotal.substring(0, 89) + " " + entradaDiaTotalcomp  + año +"-"+ (mes+1) +"-"+dia+"'";
 }
 public String getEntradasAñoCarreraBus(int año)
 {
     return entradasAñoCarrera.substring(0, 113) + " WHERE YEAR(fecha)='"+ año +"'\n"+ 
               " GROUP BY nombrecarr ORDER BY nombrecarr";
 }
 public String getEntradasMesCarreraBus(int año, int mes)
 {
     return entradasMesCarrera.substring(0, 139) + "WHERE YEAR(fecha)='"+ año +"' and month(fecha)='"+ mes+"'" +
"GRoup BY  nombrecarr ORDER BY  nombrecarr";
 }
 public String getEntradasDiaCarreraBus(int año, int mes , int dia)
 {
     return entradasDiaCarrera.substring(0, 110) +  " WHERE DATE(fecha)='"+ año +"-"+ (mes+1) +"-"+dia+"'\n"+ "GROUP BY DATE( fecha ) , nombrecarr\n" +
"ORDER BY DATE( fecha ) desc, nombrecarr";

 }
 public String getentradasDiaCarreraGrafica(int año,int mes,int dia)
 {
     return entradasDiaCarreraGrafica + año +"-"+ (mes+1) +"-"+dia+"'"  +  " GROUP BY DATE( fecha ) , nombrecarr\n" +
"ORDER BY DATE( fecha ) desc, nombrecarr";
 }
 public String getentradasMesCarreraGrafica(int año,int mes)
 {
     return entradasMesCarreraGrafica + año +"' and month(fecha)='"+ mes+"'" +
"GRoup BY  nombrecarr ORDER BY  nombrecarr";
 }
 public String getentradasAñoCarreraGrafica(int año)
 {
    return entradasAñoCarreraGrafica + año + 
"'  GRoup BY  nombrecarr ORDER BY  nombrecarr"; 
 }
 public String getModificarEntradas(String fecha)
 {

     return "SELECT nombrecarr,sum(cantidad) as cantidad FROM `registro` natural join carrera where date(fecha)='" + fecha +"' group by nombrecarr";
 }
 public String getActualizar(int cantidad ,String fecha,String idcar)
 {
     return "UPDATE  `registro` SET  `cantidad` = cantidad - "+ cantidad +"WHERE DATE( fecha ) =  "+fecha +" AND idcarrera = "+idcar +" AND cantidad >1000";
 }
 public String getListRegistros()
 {
     return "SELECT nombrecarr as Carrera, cantidad as Cantidad,fecha as Fecha FROM registro natural join carrera ";
 }
 public String getActualizandoRegistro(String valor, String idcar,String canti,String fecha){
     return " UPDATE `registro` SET `cantidad`="+ valor + " WHERE idcarrera="+ idcar+  " and cantidad= "+ canti+  ""
                + " and fecha='"+ fecha+  "'  LIMIT 1";
 }
 public String getIdCarrera(String carrera){
     return "select idcarrera from carrera where nombrecarr='"+carrera+"'";
 }
         
}

