/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.naming.NamingException;
import modelo.Beans.VisitaBean;
import util.ClassConexion;
import util.ConexionBD;

/**
 * Esta clase realiza y procesa las consultas a bases de datos, de la tabla
 * Visita.
 *
 * @version 1.3
 * @author Monica <JBadCode>
 */

public class VisitaDao extends ConexionBD {

    private static final String COL_FECHA_VISITA= "fecha_visita";
    private static final String COL_ID_PRODUCTO_VISITA_VISITA = "id_producto_visita_visita";
    private static final String COL_ID_FUNCIONARIO_VISITA = "id_funcionario_visita";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public VisitaDao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param visita
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean InsertarVisita(VisitaBean visita) throws SQLException {
        boolean resultado;// esta es la futura respuesta
        
        //datos en la consulta en base de datos
        String query = "{CALL INSERTAR_VISITA(?,?,?)}";
        int indexIdFuncionarioVisita = 1;
        int indexFechaVisita = 2 ;
        int indexProductoVisita = 3;
        
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdFuncionarioVisita, visita.getId_funcionario_visita());
        statement.setDate(indexFechaVisita, (java.sql.Date) visita.getFecha_visita());
        statement.setLong(indexProductoVisita, visita.getId_producto_visita_visita());
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * @param visita
     * @return Retorna Null si el visita no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Visita.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean UpdateVisita(VisitaBean visita) throws SQLException {
         boolean resultado;// esta es la futura respuesta
        
        //datos en la consulta en base de datos
        String query = "{CALL EDITAR_VISITA(?,?,?)}";
        int indexIdFuncionarioVisita = 1;
        int indexFechaVisita = 2 ;
        int indexProductoVisita = 3;
        
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdFuncionarioVisita, visita.getId_funcionario_visita());
        statement.setDate(indexFechaVisita, (java.sql.Date) visita.getFecha_visita());
        statement.setLong(indexProductoVisita, visita.getId_producto_visita_visita());
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * @param visita
     * @return Retorna Null si el Visita no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Visita.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean DeleteArea(VisitaBean visita) throws SQLException {
         boolean resultado;// esta es la futura respuesta
        
        //datos en la consulta en base de datos
        String query = "{CALL ELIMINAR_VISITA(?)}";
        int indexIdFuncionarioVisita = 1;
        
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdFuncionarioVisita, visita.getId_funcionario_visita());
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

}
