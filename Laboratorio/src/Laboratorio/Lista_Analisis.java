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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Lista_Analisis {
   private int id_analisis;
   private String nombre, requerimientos;
   private double precio;
  
   
  public int getId_analisis(){
  return id_analisis;
  }
  
  public void setId_analisis(int id_analisis){
  this.id_analisis= id_analisis;
  }
  
  public String getNombre(){
  return nombre;
  }
  
  public void setNombre(String nombre){
  this.nombre= nombre;
  }
  
  public String getRequerimientos(){
  return requerimientos;
  }
  
  public void setRequerimientos(String requerimientos){
  this.requerimientos= requerimientos;
  }
  
  public double getPrecio(){
  return precio;
  }
  
  public void setPrecio(double precio){
  this.precio= precio;
  }
}
