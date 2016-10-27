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
 *  En esta clase se realiza la conexion a una JDNI que se encuentra en el servidor de aplicaciones.
 * 
 * @author Juan David
 */
public class ConexionBD {
    private Connection conexion;
    private static final String JNDI = "jdbc/munnin";
    
    /**
     * Establece la conexion con la base de datos
     * 
     * @throws NamingException si la JNDI no es la correcta
     * @throws SQLException 
     */
    public ConexionBD() throws NamingException, SQLException {
        conectar();
    }
    
    /**
     * Conecta con la JNDI del servidor de aplicaciones.
     * por medio de esta se establece la conexion a la base de datos
     * 
     * @throws NamingException si la JNDI no es la correcta
     * @throws SQLException 
     */
    private void conectar() throws NamingException, SQLException{
        Context ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup(JNDI);
        conexion = ds.getConnection();
    }
    /**
     * 
     * @return conexion con la base de datos
     */
    public Connection getConexion() {
        return conexion;
    }
    
    /**
     * Metodo para cerrar la conexion con la base de datos.
     * 
     * @return null si la conexion se cerro correctamente
     * @throws SQLException 
     */
    public Connection cerrarConexion() throws SQLException{
        conexion.close();
        conexion = null;
        return conexion;
    }
}
