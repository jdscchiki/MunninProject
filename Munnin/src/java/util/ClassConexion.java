/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sergio
 */
public class ClassConexion {
    public String driver, urlbd, passbd, bd, userbd;
    public Connection conexion;

    public ClassConexion() {
        driver = "com.mysql.jdbc.Driver";
        userbd = "root";
        passbd = "";
        bd = "munninProject";
        urlbd = "jdbc:mysql://localhost:3306/"+bd;
        
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(urlbd, userbd, passbd);
            System.out.println("conexion a BD ok");
        } catch (Exception e) {
            System.out.println("conexion fallida: " + e);
        }
    }
    
    public Connection obtenerConexion(){
        return conexion;
    }
    
    public Connection cerrarConexion() throws SQLException{
        conexion.close();
        conexion = null;
        return conexion;
    }
    
    public static void main(String[] args) {
        new ClassConexion();
    }
}
