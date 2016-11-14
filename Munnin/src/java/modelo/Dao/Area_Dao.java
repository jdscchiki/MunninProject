/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import util.ConexionBD;
import modelo.Beans.Area_Bean;

//cosas a tener en cuenta:
//  documentar los metodos, es facil con la herramienta javadoc
//  traten de ser lo mas explicitos posibles en la descripcion de los metodos
/**
 * Esta clase realiza y procesa las consultas a bases de datos, de las tablas
 * Area.
 *
 * @version 1.2
 * @author Monica <JBadCode>
 */
public class Area_Dao extends ConexionBD {

    private static final String COL_ID_AREA = "id_area";
    private static final String COL_NOMBRE_AREA = "nombre_area";
    private static final String COL_ID_CENTRO_AREA = "id_centro_area";

    private static final String PROCEDURE_INSERT_AREA = "{CALL INSERTAR_AREA(?,?,?)}";
    //private static final int PROCEDURE_INGR_CORREO_INDEX = 1;
    private static final String PROCEDURE_UPDATE_AREA = "{CALL EDITAR_AREA(?,?,?)}";
    private static final String PROCEDURE_DELETE_AREA = "{CALL ElIMINAR_AREA(?)}";
    
    private static final int PROCEDURE_INSERTAR_AREA_ID_AREA_INDEX = 1;
    private static final int PROCEDURE_INSERTAR_AREA_NOMBRE_AREA_INDEX = 2;    
    private static final int PROCEDURE_INSERTAR_AREA_ID_CENTRO_AREA_INDEX = 3;
    
    private static final int PROCEDURE_UPDATE_AREA_ID_AREA_INDEX = 1;
    private static final int PROCEDURE_UPDATE_AREA_NOMBRE_AREA_INDEX = 2;
    private static final int PROCEDURE_UPDATE_AREA_ID_CENTRO_AREA_INDEX = 3;
    
    private static final int PROCEDURE_ELIMINAR_AREA_ID_AREA_INDEX = 1;

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Area_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean InsertarArea(Area_Bean area) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_INSERT_AREA);
        statement.setLong(PROCEDURE_INSERTAR_AREA_ID_AREA_INDEX, area.getId_area());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_INSERTAR_AREA_NOMBRE_AREA_INDEX, area.getNombre_area());
        statement.setString(PROCEDURE_INSERTAR_AREA_ID_CENTRO_AREA_INDEX, area.getId_centro_area());        
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
     * @param area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean UpdateArea(Area_Bean area) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_UPDATE_AREA);
        statement.setLong(PROCEDURE_UPDATE_AREA_ID_AREA_INDEX, area.getId_area());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_UPDATE_AREA_NOMBRE_AREA_INDEX, area.getNombre_area());
        statement.setString(PROCEDURE_UPDATE_AREA_ID_CENTRO_AREA_INDEX, area.getId_centro_area());
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
     * @param area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean DeleteArea(Area_Bean area) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_DELETE_AREA);
        statement.setLong(PROCEDURE_ELIMINAR_AREA_ID_AREA_INDEX, area.getId_area());//asigna los valores necesarios para ejecutar el QUERY
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
