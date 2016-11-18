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
import javax.naming.NamingException;
import modelo.Beans.Detalle_Lista_Bean;
import util.ClassConexion;
import util.ConexionBD;

/**
 * Esta clase realiza y procesa las consultas a bases de datos, de las tablas
 * Detalle_lista.
 *
 * @version 1.3
 * @author Monica <JBadCode>
 */
 public class Detalle_Lista_Dao extends ConexionBD {

    private static final String COL_ID_DETALLE_LISTA = "id_detalle_lista";
    private static final String COL_ID_LISTA_DETALLE_LISTA = "id_lista_detalle_lista";
    private static final String COL_ID_ITEM_DETALLE_LISTA = "id_item_detalle_lista";
    

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Detalle_Lista_Dao() throws NamingException, SQLException {
        super(); 
    }

    /**
     *
     * @param detalle_lista
     * @return Retorna Null si el Detalle_lista no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Detalle_lista.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean InsertarDetalleLista(Detalle_Lista_Bean detalle) throws SQLException {
        boolean resultado;// esta es la futura respuesta
        
        //datos en la consulta en base de datos
        String query ="{CALL INSERTAR_DETALLE_LISTA(?,?,?)}";
        int indexIdDetalleLista = 1;
        int indexIdListaDetalleLista = 2;
        int indexIdItemDetalleLista = 3;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdDetalleLista, detalle.getId_detalle_lista());
        statement.setLong(indexIdListaDetalleLista, detalle.getId_lista_detalle_lista());
        statement.setLong(indexIdItemDetalleLista, detalle.getId_item_detalle_lista());        
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
     * @param detalle_lista
     * @return Retorna Null si el Detalle_lista no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Detalle_lista.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean UpdateArea(Detalle_Lista_Bean detalle) throws SQLException {
         boolean resultado;// esta es la futura respuesta
        
        //datos en la consulta en base de datos
        String query ="{CALL EDITAR_DETALLE_LISTA(?,?,?)}";
        int indexIdDetalleLista = 1;
        int indexIdListaDetalleLista = 2;
        int indexIdItemDetalleLista = 3;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdDetalleLista, detalle.getId_detalle_lista());
        statement.setLong(indexIdListaDetalleLista, detalle.getId_lista_detalle_lista());
        statement.setLong(indexIdItemDetalleLista, detalle.getId_item_detalle_lista());        
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
     * @param detalle_lista
     * @return Retorna Null si el Detalle_Lista no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Detale_lista.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean DeleteArea(Detalle_Lista_Bean detalle) throws SQLException {
        boolean resultado;// esta es la futura respuesta
        
        //datos en la consulta en base de datos
        String query ="{CALL ELIMINAR_DETALLE_LISTA(?)}";
        int indexIdDetalleLista = 1;
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdDetalleLista, detalle.getId_detalle_lista());      
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
