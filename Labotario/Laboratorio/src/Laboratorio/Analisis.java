/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Laboratorio;
/**
 *
 * @author Marco y equipo
 */
import Datos.Conexion;
import java.awt.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Analisis {

    
   private Integer folio, id_paciente;
   private String id_analisis,id_empleado, nom_analisis, requerimientos, descuento_aplicado, fecha, hora;
   private double precio, descuento,sub_total, anticipo, total;
   
   Statement sentencia;
   ResultSet resultado;
   Datos.Conexion myconexion=new Datos.Conexion();
   
  
    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public Integer getId_paciente() {
        return id_paciente;
    }

 
    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getId_analisis() {
        return id_analisis;
    }

    public void setId_analisis(String id_analisis) {
        this.id_analisis = id_analisis;
    }

    public String getId_empleado() {
        return id_empleado;
    }


    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNom_analisis() {
        return nom_analisis;
    }

    public void setNom_analisis(String nom_analisis) {
        this.nom_analisis = nom_analisis;
    }

    public String getRequerimientos() {
        return requerimientos;
    }

    public void setRequerimientos(String requerimientos) {
        this.requerimientos = requerimientos;
    }

    public String getDescuento_aplicado() {
        return descuento_aplicado;
    }

    public void setDescuento_aplicado(String descuento_aplicado) {
        this.descuento_aplicado = descuento_aplicado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }

    public double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(double anticipo) {
        this.anticipo = anticipo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean Cons_reg_Analisis(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
      /** 
       * REGISTRO DE UN NUEVO ANALISIS
    */
  public boolean Nuevo_Analisis()throws SQLException{
       myconexion.Conecta();
       sentencia = myconexion.con.createStatement();
          
    try{
        if (Cons_reg_Analisis(folio)==false)
        {
            //Insert into
            System.out.println("El nombre del analisis es: "+nom_analisis);
            String insertar ="insert into analisis(folio, id_paciente, id_empleado, nom_analisis, requerimientos, precio, descuento, sub_total, anticipo, fecha, hora, total, descuento_aplicado ) values("+folio+","+id_paciente+",'"+id_empleado+"','"+nom_analisis+"','"+requerimientos+"',"+precio+","+descuento+","+sub_total+","+anticipo+",'"+fecha+"','"+hora+"', "+total+", '"+descuento_aplicado+"');";
            System.out.println(insertar);
            sentencia.execute(insertar);
            
            return true;
        }
        else
            return false;
        }
        catch(SQLException e)
            {
              System.out.println(" ERROR " + e.getMessage());    
              return false;
            }
   }
   
   /**
    * CONSULRA DE LOS REGISTRO DE LOS ANALISI REGISTRADOS
     * @param Folio
     * @return 
     * @throws java.sql.SQLException
    */
   public boolean Cons_reg_Analisis(Integer Folio)throws SQLException{
    myconexion.Conecta();
    sentencia = myconexion.con.createStatement();
    String miconsulta;
    try{
        miconsulta="select * from public.analisis where nom_analisis='"+folio+"';";
         System.out.println(miconsulta);
        resultado=sentencia.executeQuery(miconsulta);
         if (resultado.next())
           return true;
        else
           return false;
        }
        catch(SQLException e)
            {
              System.out.println(" ERROR " + e.getMessage());    
              return false;
            }
    
   }

   


}

