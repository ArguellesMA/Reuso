/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static java.lang.Integer.parseInt;

import libreria.Conexion.*;

/**
 *
 * @author OMAR y MARCO
 */
public class Reglas {
    
    libreria.Conexion myconexion = new libreria.Conexion();
    
   Statement sentencia;
   ResultSet resultado;
    
   /*public boolean res;
   Libreria lib = new Libreria();
       boolean rest= lib.permiso();*/
       

  
   
               //primera regla
   //=============================================================================================================
    public boolean permiso(){
    
            String numero;
        numero=JOptionPane.showInputDialog("ingrese 1 si cuenta con un permiso y 2 si no cuenta con el permiso");
        
        if(numero==null)
            JOptionPane.showMessageDialog(null, "el registro ha sido canselado");
        else{
        int edad2;
        edad2=Integer.parseInt(numero);
        
        if(edad2==2)
            JOptionPane.showMessageDialog(null, "no debe seguir con el registro");
        else
            JOptionPane.showMessageDialog(null, "puede seguir con el registro");
        }
        return false;
    }
    
    
                        //SEGUNDA REGLA
//================================================================================================================
    
    public void descuento(JTextField txtprecio, JTextField txtdescuento, JTextField txtsubtotal) {
        
        double precio=Double.parseDouble(txtprecio.getText());
        double descuento=Double.parseDouble(txtdescuento.getText());
        
        if(precio<=100){
            descuento=10;
            JOptionPane.showMessageDialog(null, "el descuento sera por 10%"); 
            txtsubtotal.setText(String.valueOf(precio-(precio*descuento/100)));
         }
        else{
             descuento=20;
             JOptionPane.showMessageDialog(null, "el descuento sera por 20%"); 
            txtsubtotal.setText(String.valueOf(precio-(precio*descuento/100)));
                    }
        
    
    }
    
    
    public void total(JTextField txtsubtotal, JTextField txtanticipo, JTextField txttotal){
        double sub_total=Double.parseDouble(txtsubtotal.getText());
        double anticipo=Double.parseDouble(txtanticipo.getText());
        
        
        if(sub_total<anticipo){
            JOptionPane.showMessageDialog(null, "error en la cantidad de anticipo");
        }else if(anticipo<(sub_total/2)){
            JOptionPane.showMessageDialog(null, "el anticipo debe ser mayor que el 50 %");
        }else{
            txttotal.setText(String.valueOf(sub_total-anticipo));
        }
    }
    
                                    //TERCERA REGLA
//================================================================================================================    
       
public boolean bloqueo() throws SQLException{

       String miconsulta;
       myconexion.Conecta();
       sentencia = myconexion.con.createStatement();
        
 String apellido_paterno;
 String apellido_materno;
 apellido_paterno = JOptionPane.showInputDialog("apellido paterno:");
 apellido_materno = JOptionPane.showInputDialog("apellido materno:");
        

        try{
        miconsulta="select*from empleados where apellido_paterno = '"+apellido_paterno+"' or apellido_materno = '"+apellido_paterno+"' or apellido_paterno = '"+apellido_materno+"' or apellido_materno = '"+apellido_materno+"'";
         //System.out.println(miconsulta);
          
         //JOptionPane.showMessageDialog(null,"nombres que coinciden:"+ resultado);
         resultado=sentencia.executeQuery(miconsulta);
         if (resultado.next())
         {
         
             Presentacion.V_alerta alert = new Presentacion.V_alerta();
             alert.setVisible(true);
             
             return true;
         }else{
             
             Presentacion.NuevoEmpleado azul =new Presentacion.NuevoEmpleado();
             azul.setVisible(true);
             
         }return false;
        }
        catch(SQLException e )
            {
              System.out.println(" ERROR " + e.getMessage());    
              return false;
            }
        
   }
    
    
     public void prueva(JTextField txtedad){
        
        int edad = parseInt(txtedad.getText());

        
        if(edad < 18){
        
        JOptionPane.showMessageDialog(null,"no cumple con la mayoria de edad"); 
        
        Presentacion.Empleados empleados= new Presentacion.Empleados();
        empleados.setVisible(true);
  
        
        }
        else{
        if(edad > 45){
            
        JOptionPane.showMessageDialog(null, "sobrepasa la edad de registro permitida");
        
        Presentacion.Empleados empleados= new Presentacion.Empleados();
        empleados.setVisible(true);

        
        }else{}
        
        }
    
    
    }

   /* private static class res {

        public res() {
        }
           Libreria lib = new Libreria();
   rest= lib.permiso();
    }*/

    


   }   

