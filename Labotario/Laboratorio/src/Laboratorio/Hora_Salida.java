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
import java.sql.*;
import java.sql.Time;

public class Hora_Salida 
{
   private String id_empleado;
   private String fecha;
   private String hora;
   private String comentarios;
   
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
   
   Statement sentencia;
   ResultSet resultado;
   
   Datos.Conexion myconexion=new Datos.Conexion();
   
   /**
   @roseuid
    */
  /* public Hora_Salida() 
   {
    
   }*/
   
   /**
     * @return 
     * @throws java.sql.SQLException
   @roseuid 5AEBCF4D037A
    */
  /* public boolean Reg_hora_S()throws SQLException {
    myconexion.Conecta();
       sentencia = myconexion.con.createStatement();
       
        try{
        
            //Insert into
            
            System.out.println("El id del empleado es: "+id_empleado);
            String insertar="insert into hora_salida(id_empleado, fecha, hora, comentarios) values('"+id_empleado+"','"+fecha+"','"+hora+"', '"+comentarios+"');";
            System.out.println(insertar);
            sentencia.execute(insertar);
            return true;
        }
        catch(SQLException e)
            {
              System.out.println(" ERROR " + e.getMessage());    
              return false;
            }
   }*/
   
   /**
     * @param id
     * @return 
     * @throws java.sql.SQLException
   @roseuid 5AEBCF59035A
    */
   /*public boolean Cons_Reg_hora_S(String id)  throws SQLException 
   {
       String miconsulta;
       
    myconexion.Conecta();
        sentencia = myconexion.con.createStatement();
        try{
        miconsulta="select * from public.hora_salida where id_empleado='"+id+"';";
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
   }*/
}
