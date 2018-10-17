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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Empleados {
 
   private String id_empleado, contraseña;
   private String nombre, apellidos, calle, avenida, intext, nivel_academico, correo, sexo; 
   private int edad,ncasa, celular;
   
   Statement sentencia;
   ResultSet resultado;
   
   Datos.Conexion myconexion=new Datos.Conexion();
   

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getAvenida() {
        return avenida;
    }

    public void setAvenida(String avenida) {
        this.avenida = avenida;
    }

    public String getIntext() {
        return intext;
    }

    public void setIntext(String intext) {
        this.intext = intext;
    }

    public String getNivel_academico() {
        return nivel_academico;
    }

    public void setNivel_academico(String nivel_academico) {
        this.nivel_academico = nivel_academico;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNcasa() {
        return ncasa;
    }

    public void setNcasa(int ncasa) {
        this.ncasa = ncasa;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }
   
    
    
   /*
   REGISTRO DE UN NUEVO EMPLEADO
   */
   public boolean Reg_Nuevo_Empl()throws SQLException{
      
        myconexion.Conecta();
        sentencia = myconexion.con.createStatement();
        
        try{
        if (Consulta_Empl(id_empleado)==false)
        {
            //Insert into
            System.out.println("El id del empleado es: "+id_empleado);
            String insertar="insert into public.empleados(id_empleado, contraseña, nombre, apellidos, calle, avenida, intext, nivel_academico, edad, ncasa, celular, correo, sexo) values('"+id_empleado+"','"+contraseña+"','"+nombre+"','"+apellidos+"','"+calle+"','"+avenida+"','"+intext+"','"+nivel_academico+"',"+edad+","+ncasa+","+celular+",'"+correo+"','"+sexo+"');";
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
    * CONSULTA DE EMPLEADOS
     * @param id
     * @return 
     * @throws java.sql.SQLException
   @roseuid 
    */
   public boolean Consulta_Empl(String id) throws SQLException{
       String miconsulta;
       myconexion.Conecta();
        sentencia = myconexion.con.createStatement();
        
        try{
        miconsulta="select * from public.empleados where id_empleado='"+id+"';";
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
   
   
   
   /**
    * ELIMINACION DE EMPLEADOS
   @roseuid 
    */
   public void Elim_Empl() throws SQLException 
   {
    myconexion.Conecta();
    sentencia = myconexion.con.createStatement();
    
  
   }  
   }   
  