/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Marco y equipo ☺☻♠♦♠
 */
public class Conexion {
    
    
    public Connection con=null;
    public void Conecta(){
        
        String Url= "jdbc:postgresql://localhost:5432/Laboratorio";
        try {
            Class.forName("org.postgresql.Driver");
             con=DriverManager.getConnection(Url,"postgres","Marco2805");
            //System.out.println("se conecto");
        }
        catch( Exception e )
        {
           System.out.println(e);
        }
             
    }//Finaliza la funcion Conecta()

    

    
    
}//Finaliza la clase Conexion
