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
import modelo.Beans.AreaBean;

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
public class AreaDao extends ConexionBD {

    private static final String COL_ID_AREA = "id_area";
    private static final String COL_NOMBRE_AREA = "nombre_area";
    private static final String COL_ID_CENTRO_AREA = "id_centro_area";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public AreaDao() throws NamingException, SQLException {
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
    public boolean InsertarArea(AreaBean area) throws SQLException {
        boolean resultado;//esta es la futura respuesta
        
        String query = "{CALL INSERTAR_AREA(?,?,?)}";
        int indexIdArea = 1;
        int indexNombreArea = 2;
        int indexIdCentroArea = 3;
        
        //datos de la consulta en base de datos
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setLong(indexIdArea, area.getId_area());
        statement.setString(indexNombreArea, area.getNombre_area());
        statement.setString(indexIdCentroArea, area.getId_centro_area()); 
        
        if (statement.executeUpdate() == 1) {//si solo modifico una fila el registro se completa
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
    public boolean UpdateArea(AreaBean area) throws SQLException {
        boolean resultado;//esta es la futura respuesta
        
        String query = "{CALL EDITAR_AREA(?,?,?)}";
        int indexIdArea = 1;
        int indexNombreArea = 2;
        int indexIdCentroArea = 3;
        
        //datos de la consulta en base de datos
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setLong(indexIdArea, area.getId_area());
        statement.setString(indexNombreArea, area.getNombre_area());
        statement.setString(indexIdCentroArea, area.getId_centro_area()); 
        
        if (statement.executeUpdate() == 1) {//si solo modifico una fila el registro se completa
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
    public boolean DeleteArea(AreaBean area) throws SQLException {
        boolean resultado;//esta es la futura respuesta
        
        String query = "{CALL ELIMINAR_AREA(?)}";
        int indexIdArea = 1;
        
        //datos de la consulta en base de datos
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setLong(indexIdArea, area.getId_area()); 
        
        if (statement.executeUpdate() == 1) {//si solo modifico una fila el registro se completa
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

}
