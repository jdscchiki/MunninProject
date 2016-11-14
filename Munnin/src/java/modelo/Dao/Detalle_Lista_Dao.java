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
 *
 * @author Administrador
 */
 public class Detalle_Lista_Dao extends ConexionBD {

    private static final String COL_ID_DETALLE_LISTA = "id_detalle_lista";
    private static final String COL_ID_LISTA_DETALLE_LISTA = "id_lista_detalle_lista";
    private static final String COL_ID_ITEM_DETALLE_LISTA = "id_item_detalle_lista";
    

    private static final String PROCEDURE_INSERT_DETALLE_LISTA = "{CALL INSERTAR_DETALLE_LISTA(?,?,?)}";
    private static final String PROCEDURE_UPDATE_DETALLE_LISTA = "{CALL EDITAR_DETALLE_LISTA(?,?,?)}";
    private static final String PROCEDURE_DELETE_DETALLE_LISTA = "{CALL ElIMINAR_DETALLE_LISTA(?)}";

    private static final int PROCEDURE_INSERTAR_DETALLE_LISTA_ID_DETALLE_LISTA_INDEX = 1;
    private static final int PROCEDURE_INSERTAR_DETALLE_LISTA_ID_LISTA_DETALLE_LISTA_INDEX = 2;
    private static final int PROCEDURE_INSERTAR_DETALLE_LISTA_ID_ITEM_DETALLE_LISTA_INDEX = 3;
    private static final int PROCEDURE_UPDATE_DETALLE_LISTA_ID_DETALLE_LISTA_INDEX = 1;
    private static final int PROCEDURE_UPDATE_DETALLE_LISTA_ID_LISTA_DETALLE_LISTA_INDEX = 2;
    private static final int PROCEDURE_UPDATE_DETALLE_LISTA_ID_ITEM_DETALLE_LISTA_INDEX = 3;
    private static final int PROCEDURE_ELIMINAR_DETALLE_ID_DETALLE_LISTA_INDEX = 1;

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
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean InsertarDetalleLista(Detalle_Lista_Bean detalle) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_INSERT_DETALLE_LISTA);
        statement.setLong(PROCEDURE_INSERTAR_DETALLE_LISTA_ID_DETALLE_LISTA_INDEX, detalle.getId_detalle_lista());//asigna los valores necesarios para ejecutar el QUERY
        statement.setLong(PROCEDURE_INSERTAR_DETALLE_LISTA_ID_LISTA_DETALLE_LISTA_INDEX, detalle.getId_lista_detalle_lista());
        statement.setLong(PROCEDURE_INSERTAR_DETALLE_LISTA_ID_ITEM_DETALLE_LISTA_INDEX, detalle.getId_item_detalle_lista());        
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
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean UpdateArea(Detalle_Lista_Bean detalle) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_UPDATE_DETALLE_LISTA);
        statement.setLong(PROCEDURE_UPDATE_DETALLE_LISTA_ID_DETALLE_LISTA_INDEX, detalle.getId_detalle_lista());//asigna los valores necesarios para ejecutar el QUERY
        statement.setLong(PROCEDURE_UPDATE_DETALLE_LISTA_ID_LISTA_DETALLE_LISTA_INDEX, detalle.getId_lista_detalle_lista());
        statement.setLong(PROCEDURE_UPDATE_DETALLE_LISTA_ID_ITEM_DETALLE_LISTA_INDEX, detalle.getId_item_detalle_lista());
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
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean DeleteArea(Detalle_Lista_Bean detalle) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_DELETE_DETALLE_LISTA);
        statement.setLong(PROCEDURE_ELIMINAR_DETALLE_ID_DETALLE_LISTA_INDEX,detalle .getId_detalle_lista());//asigna los valores necesarios para ejecutar el QUERY
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
