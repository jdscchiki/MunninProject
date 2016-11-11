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
    private static final String PROCEDURE_DELETE_VISITA = "{CALL ElIMINAR_VISITA(?,?,?)}";

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
     * @param Id_area Id del Area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Area_Bean InsertarArea(Long Id_area) throws SQLException {
        Area_Bean area = new Area_Bean();//el objeto en donde se guardan los resultados de la consulta
        area.setId_area(Id_area);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERT_AREA(?,?,?)}");
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
        CallableStatement statement = this.getConexion().prepareCall("{CALL UPDATE_AREA(?,?,?)}");
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
        CallableStatement statement = this.getConexion().prepareCall("{CALL DELETE_AREA(?,?,?)}");
        statement.setLong(PROCEDURE_DELETE_AREA, Id_area);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_AREA);
        statement.setString(3, COL_ID_CENTRO_AREA);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return area;
    }

}
