/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Laboratorio;

/**
 *
 * @author Agustin Lagunes Dominguez
 */
import Datos.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pacientes 
{
   private Integer id_paciente;
   private String id_empleado, nombre, apellidos, sexo, avenida, intext, calle, correo;
   private int edad, ncasa,telefonocasa, celular;
   private String fecha;
   
   public Integer getId_paciente(){
   return id_paciente;
   }
   
   public void setIn_paciente(Integer id_paciente){
   this.id_paciente= id_paciente;
   }
   
   public String getId_empleado(){
   return id_empleado;
   }
   
   public void setId_empleado(String id_empleado){
   this.id_empleado= id_empleado;
   }
   
   public String getNombre(){
   return nombre;
   }
   
   public void setNombre(String nombre){
   this.nombre= nombre;
   }
   
   public String getApellidos(){
   return apellidos;
   }
   
   public void setApellidos(String apellidos){
   this.apellidos=apellidos;
   }
   
   public String getSexo(){
   return sexo;
   }
   
   public void setSexo(String sexo){
   this.sexo=sexo;
   }
   
   public String getAvenida(){
   return avenida;
   }
   
   public void setAvenida(String avenida){
   this.avenida=avenida;
   }
   
   public String getIntext(){
   return intext;
   }
   
   public void setIntext(String intext){
   this.intext=intext;
   }
   
   public String getCalle(){
   return calle;
   }
   
   public void setCalle(String calle){
   this.calle= calle;
   }
   
   public String getCorreo(){
   return correo;
   }
   
   public void setCorreo(String correo){
   this.correo=correo;
   }
   
   public int getEdad(){
   return edad;
   }
   
   public void setEdad(int edad){
   this.edad= edad;
   }
   
   public int getNcasa(){
   return ncasa;
   }
  
   public void setNcasa(int ncasa){
   this.ncasa= ncasa;
   }
   
   public int getTelefonocasa(){
   return telefonocasa;
   }
   
   public void setTelefonocasa(int telefonocasa){
   this.telefonocasa= telefonocasa;
   }
   
   public int getCelular(){
   return celular;
   }
   
   public void setCelular(int celular){
   this.celular= celular;
   }
   
   public String getFecha(){
   return fecha;
   }
   
   public void setFecha(String fecha){
   this.fecha= fecha;
   }
}