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
    private static final String JDNI = "jdbc/munnin";
    
    public ConexionBD() throws NamingException, SQLException {
        conectar();
    }
    
    private void conectar() throws NamingException, SQLException{
        Context ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup(JDNI);
        conexion = ds.getConnection();
    }

    public Connection getConexion() {
        return conexion;
    }
    
    public Connection cerrarConexion() throws SQLException{
        conexion.close();
        conexion = null;
        return conexion;
    }
}
