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
}
