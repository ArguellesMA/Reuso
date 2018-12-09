/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Presentacion.Validacion;
import com.sun.istack.internal.Pool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author Aldo
 */
public class Validaciones {
    libreria.Conexion myconexion = new libreria.Conexion();
public int validar_ingreso(JTextField txtusuario, JTextField txtcontraseña){

    String nombre=txtusuario.getText();
    String contrasena=String.valueOf(txtcontraseña.getText());

    int resultado=0;
    
    String SSQL="SELECT * FROM usuarios WHERE usuario='"+nombre+"' AND clave=sha1('"+contrasena+"')";

    Connection conect = null;

    try {

        Statement st=myconexion.con.createStatement();
        ResultSet rs = st.executeQuery(SSQL);

        if(rs.next()){

            resultado=1;

        }

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);

    }finally{


        try {

            conect.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión", JOptionPane.ERROR_MESSAGE);

        }

    }

return resultado;

}

    


}
