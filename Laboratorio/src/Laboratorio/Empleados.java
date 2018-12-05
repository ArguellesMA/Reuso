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
 
   private String id_empleado;
   private String nombre, apellido_paterno, apellido_materno, calle, avenida, intext, nivel_academico, correo, sexo; 
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }
    
    public String getApellido_materno(){
        return apellido_materno;
    }
    
    public void setApellido_materno(String apellido_materno){
        this.apellido_materno = apellido_materno;
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
} 
  