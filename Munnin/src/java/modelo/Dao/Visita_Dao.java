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
import modelo.Beans.Visita_Bean;
import util.ClassConexion;
import util.ConexionBD;

public class Visita_Dao extends ConexionBD {

    private static final String COL_FECHA_VISITA= "fecha_visita";
    private static final String COL_ID_PRODUCTO_VISITA_VISITA = "id_producto_visita_visita";
    private static final String COL_ID_FUNCIONARIO_VISITA = "id_funcionario_visita";

    private static final String PROCEDURE_INSERT_VISITA = "{CALL INSERTAR_VISITA(?,?,?)}";
    //private static final int PROCEDURE_INGR_CORREO_INDEX = 1;
    private static final String PROCEDURE_UPDATE_VISITA = "{CALL EDITAR_VISITA(?,?,?)}";
    private static final String PROCEDURE_DELETE_VISITA = "{CALL ElIMINAR_VISITA(?)}";
    
    private static final int PROCEDURE_INSERTAR_VISITA_ID_FUNCIONARIO_INDEX = 1;
    private static final int PROCEDURE_INSERTAR_VISITA_FECHA_INDEX = 2;
    private static final int PROCEDURE_INSERTAR_VISITA_ID_PRODUCTO_VISITA_INDEX = 3;
    
    private static final int PROCEDURE_UPDATE_VISITA_ID_FUNCIONARIO_VISITA_INDEX = 1;
    private static final int PROCEDURE_UPDATE_VISITA_FECHA_INDEX = 2;
    private static final int PROCEDURE_UPDATE_VISITA_ID_PRODUCTO_VISITA_INDEX = 3;
    
    private static final int PROCEDURE_DELETE_VISITA_ID_FUNCIONARIO_VISITA_INDEX = 1;
    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Visita_Dao() throws NamingException, SQLException {
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
    public boolean InsertarVisita(Visita_Bean visita) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_INSERT_VISITA);
        statement.setLong(PROCEDURE_INSERTAR_VISITA_ID_FUNCIONARIO_INDEX, visita.getId_funcionario_visita());//asigna los valores necesarios para ejecutar el QUERY
        statement.setDate(PROCEDURE_INSERTAR_VISITA_FECHA_INDEX, (java.sql.Date) visita.getFecha_visita());
        statement.setLong(PROCEDURE_INSERTAR_VISITA_ID_PRODUCTO_VISITA_INDEX, visita.getId_producto_visita_visita());
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
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean UpdateVisita(Visita_Bean visita) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_UPDATE_VISITA);
        statement.setLong(PROCEDURE_UPDATE_VISITA_ID_FUNCIONARIO_VISITA_INDEX, visita.getId_funcionario_visita());//asigna los valores necesarios para ejecutar el QUERY
        statement.setDate(PROCEDURE_UPDATE_VISITA_FECHA_INDEX, (java.sql.Date) visita.getFecha_visita());
        statement.setLong(PROCEDURE_UPDATE_VISITA_ID_PRODUCTO_VISITA_INDEX, visita.getId_producto_visita_visita());
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
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
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean DeleteArea(Visita_Bean visita) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_DELETE_VISITA);
        statement.setLong(PROCEDURE_DELETE_VISITA_ID_FUNCIONARIO_VISITA_INDEX, visita.getId_funcionario_visita());//asigna los valores necesarios para ejecutar el QUERY
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
