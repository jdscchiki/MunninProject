/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Dao;

import java.sql.*;
import java.sql.Statement;
import util.ClassConexion;
import modelo.Beans.Area_Bean;



/**
 *
 * @author Administrador
 */
public class Area_Dao extends ClassConexion{
    
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;
    
    public boolean encontrado = false;
    public boolean listo = false;
    
    public long id_area;
    public String nombre_area;
    public String id_centro_area;
    
    public Area_Dao(Area_Bean Area){
        super();
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();
            
            
            id_area =Area.getId_area();
            nombre_area = Area.getNombre_area();
            id_centro_area = Area.getId_centro_area();
            
        } catch (SQLException e) {            
        }
    }
}