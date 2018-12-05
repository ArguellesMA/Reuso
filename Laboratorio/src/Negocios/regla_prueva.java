
package Negocios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import libreria.Conexion.*;

public class regla_prueva{
    
    libreria.Conexion myconexion = new libreria.Conexion();
    
   Statement sentencia;
   ResultSet resultado;
    
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
}