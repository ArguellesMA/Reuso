package Negocios;

import java.sql.Statement;
import Laboratorio.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Marco 
 */
public class Operaciones {
    
    Statement sentencia;
   ResultSet resultado;
   
   Datos.Conexion myconexion=new Datos.Conexion();
/*♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫---ANALISIS---♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫*/

     public boolean Nuevo_Analisis(JTextField txtdescuento, JTextField txtsubtotal, JTextField txtanticipo, JTextField txttotal, JComboBox cbxanalisis, JTextField txtarequerimientos, JTextField txtfecha, JTextField txthora, JTextField txtprecio, JComboBox cbxdesaplicado)throws SQLException{
       Laboratorio.Analisis ana=new Laboratorio.Analisis();
        ana.setDescuento(Double.parseDouble(txtdescuento.getText()));
        ana.setSub_total(Double.parseDouble(txtsubtotal.getText()));
        ana.setAnticipo(Double.parseDouble(txtanticipo.getText()));
        ana.setTotal(Double.parseDouble(txttotal.getText()));
        ana.setNom_analisis((String) cbxanalisis.getSelectedItem());
        ana.setRequerimientos(txtarequerimientos.getText());
        ana.setFecha(txtfecha.getText());
        ana.setHora(txthora.getText());
        ana.setPrecio(Double.parseDouble(txtprecio.getText()));
        ana.setDescuento_aplicado((String) cbxdesaplicado.getSelectedItem());
       myconexion.Conecta();
       sentencia = myconexion.con.createStatement();
          
    try{
        if (Cons_reg_Analisis(ana.getFolio())==false)
        {
            //Insert into
            System.out.println("El nombre del analisis es: "+ana.getNom_analisis());
            String insertar ="insert into analisis(folio, id_paciente, id_empleado, nom_analisis, requerimientos, precio, descuento, sub_total, anticipo, fecha, hora, total, descuento_aplicado ) values("+ana.getFolio()+","+ana.getId_paciente()+",'"+ana.getId_empleado()+"','"+ana.getId_analisis()+"','"+ana.getRequerimientos()+"',"+ana.getPrecio()+","+ana.getDescuento()+","+ana.getSub_total()+","+ana.getAnticipo()+",'"+ana.getFecha()+"','"+ana.getHora()+"', "+ana.getTotal()+", '"+ana.getDescuento_aplicado()+"');";
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
     
     
     
      public boolean Cons_reg_Analisis(Integer Folio)throws SQLException{
       Laboratorio.Analisis ana=new Laboratorio.Analisis();
    myconexion.Conecta();
    sentencia = myconexion.con.createStatement();
    String miconsulta;
    try{
        miconsulta="select * from public.analisis where nom_analisis='"+ana.getFolio()+"';";
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
   
/*☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼---EMPLEADOS---☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼*/
    public boolean Reg_Nuevo_Empl(JComboBox cbxsexo, JTextField txtcorreo, JTextField txtncasa, JComboBox cbxnacademico, JComboBox cbxintext, JTextField txtedad, JTextField txtcelular, JTextField txtcalle, JTextField txtavenida, JTextField txtapellidos,JTextField txtidempleado, JTextField txtnombre, JTextField txtcontraseña)throws SQLException{
     Laboratorio.Empleados ave=new Laboratorio.Empleados();
        
        ave.setId_empleado(txtidempleado.getText());
        ave.setNombre(txtnombre.getText());
        ave.setContraseña(txtcontraseña.getText());
        ave.setApellidos(txtapellidos.getText());
        ave.setAvenida(txtavenida.getText());
        ave.setCalle(txtcalle.getText());
        ave.setCelular(Integer.parseInt(txtcelular.getText()));
        ave.setEdad(Integer.parseInt(txtedad.getText()));
        ave.setIntext((String) cbxintext.getSelectedItem());
        ave.setNcasa(Integer.parseInt(txtncasa.getText()));
        ave.setNivel_academico((String) cbxnacademico.getSelectedItem());
        ave.setCorreo(txtcorreo.getText());
        ave.setSexo((String) cbxsexo.getSelectedItem());

        myconexion.Conecta();
        sentencia = myconexion.con.createStatement();
        
        try{
        if (Consulta_Empl(ave.getId_empleado())==false)
        {
            //Insert into
            System.out.println("El id del empleado es: "+ave.getId_empleado());
            String insertar="insert into public.empleados(id_empleado, contraseña, nombre, apellidos, calle, avenida, intext, nivel_academico, edad, ncasa, celular, correo, sexo) values('"+ave.getId_empleado()+"','"+ave.getContraseña()+"','"+ave.getNombre()+"','"+ave.getApellidos()+"','"+ave.getCalle()+"','"+ave.getAvenida()+"','"+ave.getIntext()+"','"+ave.getNivel_academico()+"',"+ave.getEdad()+","+ave.getNcasa()+","+ave.getCelular()+",'"+ave.getCorreo()+"','"+ave.getSexo()+"');";
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
   
      public void Elim_Empl() throws SQLException 
   {
    myconexion.Conecta();
    sentencia = myconexion.con.createStatement();  
       
   }
/*↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨---HORA ENTRADA---↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨↨*/
public boolean Reg_hora_E(JTextField txtid, JTextField txtfecha, JTextField txthora, JTextField txtacomentarios)throws SQLException{
   Hora_Entrada hora=new Hora_Entrada();
    hora.setId_empleado(txtid.getText());
    hora.setFecha(txtfecha.getText());
    hora.setHora(txthora.getText());
    hora.setComentarios(txtacomentarios.getText());
        
     myconexion.Conecta();
     sentencia = myconexion.con.createStatement();
       
          try{
        
            //Insert into
            System.out.println("el id del empleado es:" +hora.getId_empleado());
            String insertar="insert into hora_entrada(id_empleado, fecha, hora, comentarios) values('"+hora.getId_empleado()+"','"+hora.getFecha()+"','"+hora.getHora()+"', '"+hora.getComentarios()+"');";
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
   
/*▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼---HORA SALIDA---▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼*/   
   public boolean Reg_hora_S(JTextField txtid, JTextField txtfecha, JTextField txthora, JTextField txtacomentarios)throws SQLException{
   Hora_Entrada hora=new Hora_Entrada();
    hora.setId_empleado(txtid.getText());
    hora.setFecha(txtfecha.getText());
    hora.setHora(txthora.getText());
    hora.setComentarios(txtacomentarios.getText());
        
     myconexion.Conecta();
     sentencia = myconexion.con.createStatement();
       
          try{
        
            //Insert into
            System.out.println("el id del empleado es:" +hora.getId_empleado());
            String insertar="insert into hora_salida(id_empleado, fecha, hora, comentarios) values('"+hora.getId_empleado()+"','"+hora.getFecha()+"','"+hora.getHora()+"', '"+hora.getComentarios()+"');";
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
   
/*♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦---LISTA ANALISIS---♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦*/
  
    public boolean Registrar (JTextField txtid, JTextField txtnombre, JTextField txtprecio, JTextField txtarequerimientos) throws SQLException{
        Lista_Analisis li=new Lista_Analisis();
        li.setId_analisis(Integer.parseInt(txtid.getText()));
        li.setNombre(txtnombre.getText());
        li.setPrecio(Double.parseDouble(txtprecio.getText()));
        li.setRequerimientos(txtarequerimientos.getText());
      
        
        myconexion.Conecta();
     sentencia = myconexion.con.createStatement();
     
         try{
        if (Cons_Lista_Analisis(li.getId_analisis())==false)
        {
            //Insert into
            System.out.println("El id del analisis es: "+li.getId_analisis());
            String insertar="insert into public.lista_analisis(id_analisis, nombre, requerimientos, precio)values("+li.getId_analisis()+", '"+li.getNombre()+"', '"+li.getRequerimientos()+"', '"+li.getPrecio()+"');";
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
  
public  boolean Cons_Lista_Analisis(int id) throws SQLException
   {
     String miconsulta;
     
    myconexion.Conecta();
        sentencia = myconexion.con.createStatement();
        try{
        miconsulta="select * from public.lista_analisis where id_analisis='"+id+"';";
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


 public void Consulta_Table(String valor) throws SQLException{
        myconexion.Conecta();
        sentencia = myconexion.con.createStatement();
        
     
  }
 
 
/*♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠---PACIENTES---♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠*/
public boolean Reg_Nuevo_Pac(JTextField txtide, JTextField txtfecha, JTextField txtapellidos, JTextField txtavenida, JTextField txtcalle, JTextField txtcorreo, JTextField txtintext, JTextField txtnombre, JComboBox cbxsexo, JTextField txttelcasa, JTextField txtidp, JTextField txtnocasa, JTextField txtcelular, JTextField txtedad) throws SQLException{
     Pacientes ins=new Pacientes();
        ins.setId_empleado(txtide.getText());
        ins.setFecha(txtfecha.getText());
        ins.setApellidos(txtapellidos.getText());
        ins.setAvenida(txtavenida.getText());
        ins.setCalle(txtcalle.getText());
        ins.setCorreo(txtcorreo.getText());
        ins.setIntext(txtintext.getText());
        ins.setNombre(txtnombre.getText());
        ins.setSexo((String) cbxsexo.getSelectedItem());
        ins.setTelefonocasa(Integer.parseInt(txttelcasa.getText()));
        ins.setIn_paciente(Integer.parseInt(txtidp.getText()));
        ins.setNcasa(Integer.parseInt(txtnocasa.getText()));
        ins.setCelular(Integer.parseInt(txtcelular.getText()));
        ins.setEdad(Integer.parseInt(txtedad.getText()));
    
    myconexion.Conecta();
     sentencia = myconexion.con.createStatement();
     

      try{
        if (Consultas_pac(ins.getId_paciente())==false)
        {
            //Insert into
            System.out.println("El id del paciente es: "+ins.getId_paciente());
            String insertar="insert into pacientes(id_paciente, id_empleado, fecha, nombre, apellidos, sexo, avenida, intext, calle, correo, edad, ncasa, telefonocasa, celular) values("+ins.getId_paciente()+",'"+ins.getId_empleado()+"','"+ins.getFecha()+"','"+ins.getNombre()+"','"+ins.getApellidos()+"', '"+ins.getSexo()+"','"+ins.getAvenida()+"', '"+ins.getIntext()+"', '"+ins.getCalle()+"', '"+ins.getCorreo()+"',"+ins.getEdad()+","+ins.getNcasa()+","+ins.getTelefonocasa()+","+ins.getCelular()+" );";
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

public boolean Consultas_pac(int id) throws SQLException{
       String miconsulta;
       
       myconexion.Conecta();
        sentencia = myconexion.con.createStatement();
        
      try{
        miconsulta="select * from public.pacientes where id_paciente='"+id+"';";
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

public void Modificar(String id_paciente, String id_empleado, String nombre, String apellidos, String sexo, String avenida, String intext, String calle, String correo, 
                      int edad, int ncasa, int telefonocasa, int celular, String fecha){

int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea modificar los datos actuales?");


if(confirmar == JOptionPane.YES_OPTION){

    Connection conexion = null;
    
    try {
    
        myconexion.Conecta();
        sentencia = myconexion.con.createStatement();
        
        String Ssql = "UPDATE pacientes SET id_empleado=?, nombre=?, apellidos=?, sexo=?, avenida=?, intext=?, calle=?, correo=?, fecha=?, edad=?, ncasa=?, telefonocasa=?, celular=?, "
                    + "WHERE id_paciente=?";
        
        PreparedStatement prest = conexion.prepareStatement(Ssql);
        
        prest.setString(1, id_paciente);
        prest.setString(2, id_empleado);
        prest.setString(3, nombre);
        prest.setString(4, apellidos);
        prest.setString(5, sexo);
        prest.setString(6, avenida);
        prest.setString(7, intext);
        prest.setString(7, calle);
        prest.setString(7, correo);
        prest.setString(7, fecha);
        prest.setInt(7, edad);
        prest.setInt(7, ncasa);
        prest.setInt(7, telefonocasa);
        prest.setInt(7, celular);
        
        if(prest.executeUpdate() > 0){
        
            JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa", 
                                          JOptionPane.INFORMATION_MESSAGE);
            
        }else{
        
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                          + "Inténtelo nuevamente.", "Error en la operación", 
                                          JOptionPane.ERROR_MESSAGE);
        
        }
        
    } catch (SQLException e) {
    
        JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                          + "Inténtelo nuevamente.\n"
                                          + "Error: "+e, "Error en la operación", 
                                          JOptionPane.ERROR_MESSAGE);
    
    }finally{
    
        if(conexion!=null){
        
            try {
                
                conexion.close();
            
            } catch (SQLException e) {
            
                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión."
                                          + "Error: "+e, "Error en la operación", 
                                          JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
           
    }
    

}

}
    }




