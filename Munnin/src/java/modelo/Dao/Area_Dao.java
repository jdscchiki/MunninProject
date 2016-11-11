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
    private static final String PROCEDURE_DELETE_AREA = "{CALL ElIMINAR_AREA(?,?,?)}";

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
     * @param Id_area Id del Area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Area_Bean InsertarArea(Long Id_area) throws SQLException {
        Area_Bean area = new Area_Bean();//el objeto en donde se guardan los resultados de la consulta
        area.setId_area(Id_area);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERTAR_AREA(?,?,?)}");
        statement.setLong(PROCEDURE_INSERT_AREA, Id_area);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_AREA);
        statement.setString(3, COL_ID_CENTRO_AREA);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta

       
        return area;
    }

    /**
     * @param Id_area Id del Area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Area_Bean UpdateArea(Long Id_area) throws SQLException {
        Area_Bean area = new Area_Bean();//el objeto en donde se guardan los resultados de la consulta
        area.setId_area(Id_area);
        CallableStatement statement = this.getConexion().prepareCall("{CALL EDITAR_AREA(?,?,?)}");
        statement.setLong(PROCEDURE_UPDATE_AREA, Id_area);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_AREA);
        statement.setString(3, COL_ID_CENTRO_AREA);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
     
        return area;
    }

    /**
     * @param Id_area Id del Area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public  Area_Bean DeleteArea(long Id_area) throws SQLException {
        Area_Bean area = new Area_Bean();//el objeto en donde se guardan los resultados de la consulta
        area.setId_area(Id_area);
        CallableStatement statement = this.getConexion().prepareCall("{CALL ELIMINAR_AREA(?,?,?)}");
        statement.setLong(PROCEDURE_DELETE_AREA, Id_area);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_AREA);
        statement.setString(3, COL_ID_CENTRO_AREA);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return area;
    }

}
