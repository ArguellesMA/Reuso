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

    
   private Integer folio;
   private String id_analisis,id_empleado, nom_analisis, requerimientos, descuento_aplicado, fecha, hora, nom_paciente;
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

    public String getNom_paciente() {
        return nom_paciente;
    }

 
    public void setNom_paciente(String nom_paciente) {
        this.nom_paciente = nom_paciente;
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

}

