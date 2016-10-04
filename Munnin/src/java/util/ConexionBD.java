/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;

/**
 *
 * @author Juan David
 */
public class ConexionBD {
    private Connection conexion;

    public ConexionBD() {
        conectar();
    }
    
    private void conectar(){
        try {
            //se realiza una conexion a bases de datos con JDNI
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("jdbc/munnin");
            conexion = ds.getConnection();
            System.out.println("Conexion a bases de datos ok");
        } catch (NamingException e) {
            System.out.println("error al usar context: " + e);
        } catch(SQLException e){
            System.out.println("error al obtener conexion: " + e);
        }
    }

    public Connection getConexion() {
        return conexion;
    }
    
    public Connection cerrarConexion() throws SQLException{
        conexion.close();
        conexion = null;
        System.out.println("Deconexion completa");
        return conexion;
    }
}
