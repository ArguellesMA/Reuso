/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Laboratorio;

/**
 *
 * @author Marco, Itzeel, omar 
 */
import Datos.Conexion;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Hora_Entrada {
   private String id_empleado;
   private String fecha;
   private String hora;
   private String comentarios;
   
    Statement sentencia;
   ResultSet resultado;
   
   Datos.Conexion myconexion=new Datos.Conexion();
 
   
    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
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
    
     public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }




   /**
   @roseuid
    */
   public Hora_Entrada() 
   {
    
   }
   
   /**
     * @return 
     * @throws java.sql.SQLException
   @roseuid 5AEBC48D000D
    */
   public boolean Reg_hora_E()throws SQLException{
     myconexion.Conecta();
     sentencia = myconexion.con.createStatement();
       
          try{
        
            //Insert into
            System.out.println("el id del empleado es:" +id_empleado);
            String insertar="insert into hora_entrada(id_empleado, fecha, hora, comentarios) values('"+id_empleado+"','"+fecha+"','"+hora+"', '"+comentarios+"');";
            System.out.println(insertar);
            sentencia.execute(insertar);
            return true;
        }
        catch(SQLException e)
            {
              System.out.println(" ERROR " + e.getMessage());    
              return false;
            }
   }
   
   /**
     * @param id
     * @return 
     * @throws java.sql.SQLException
   @roseuid 5AEBC49D02D1
    */
   public  boolean Cons_Reg_hora_E(String id) throws SQLException
   {
    String miconsulta;
    
    myconexion.Conecta();
    sentencia = myconexion.con.createStatement();
    
    try{
   miconsulta="select * from public.hora_entrada where id_empleado='"+id+"';";
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
            }
       return false;
   }
}