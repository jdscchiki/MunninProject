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
    

    private static final String PROCEDURE_INSERT_DETALLE_LISTA = "{CALL INSERTAR_DETALLE_LISTA(?,?)}";
    private static final String PROCEDURE_UPDATE_DETALLE_LISTA = "{CALL EDITAR_DETALLE_LISTA(?,?)}";
    private static final String PROCEDURE_DELETE_DETALLE_LISTA = "{CALL ElIMINAR_DETALLE_LISTA(?,?)}";

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
     * @param Id_detalle_lista Id del estado
     * @return Retorna Null si el Estado no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Detalle_Lista_Bean InsertarDetalle(Long Id_detalle_lista) throws SQLException {
        Detalle_Lista_Bean detalle = new Detalle_Lista_Bean();//el objeto en donde se guardan los resultados de la consulta
        detalle.setId_detalle_lista(Id_detalle_lista);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERTAR_DETALLE_LISTA(?,?,?)}");
        statement.setLong(PROCEDURE_INSERT_DETALLE_LISTA, Id_detalle_lista);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_ID_LISTA_DETALLE_LISTA);
         statement.setString(3, COL_ID_ITEM_DETALLE_LISTA);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
       
        return detalle;
    }

    /**
     * @param Id_estado Id del Estado
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Detalle_Lista_Bean UpdateDetalle(Long Id_detalle_lista) throws SQLException {
        Detalle_Lista_Bean detalle = new Detalle_Lista_Bean();//el objeto en donde se guardan los resultados de la consulta
        detalle.setId_detalle_lista(Id_detalle_lista);
        CallableStatement statement = this.getConexion().prepareCall("{CALL EDITAR_DETALLE_LISTA(?,?,?)}");
        statement.setLong(PROCEDURE_UPDATE_DETALLE_LISTA, Id_detalle_lista);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_ID_LISTA_DETALLE_LISTA);
         statement.setString(3, COL_ID_ITEM_DETALLE_LISTA);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
     
        return detalle;
    }

    /**
     * @param Id_area Id del Area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public  Detalle_Lista_Bean DeleteDetalle(long Id_detalle_lista) throws SQLException {
        Detalle_Lista_Bean detalle = new Detalle_Lista_Bean();//el objeto en donde se guardan los resultados de la consulta
        detalle.setId_detalle_lista(Id_detalle_lista);
        CallableStatement statement = this.getConexion().prepareCall("{CALL ELIMINAR_DETALLE_LISTA(?,?,?)}");
        statement.setLong(PROCEDURE_DELETE_DETALLE_LISTA, Id_detalle_lista);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_ID_LISTA_DETALLE_LISTA);
         statement.setString(3, COL_ID_ITEM_DETALLE_LISTA);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return detalle;
    }

}
