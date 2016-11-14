package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.Tipo_Objeto_Aprendizaje_Bean;
import util.ClassConexion;
import util.ConexionBD;

public class Tipo_Objeto_Aprendizaje_Dao extends ConexionBD {

    private static final String COL_ID_TIPO_OBJETO_APRENDIZAJE = "id_tipo_objeto_aprendizaje";
    private static final String COL_NOMBRE_TIPO_OBJETO_APRENDIZAJE = "nombre_tipo_objeto_aprendizaje";

    private static final String PROCEDURE_INSERT_TIPO_OBJETO = "{CALL INSERTAR_TIPO_OBJETO(?,?)}";
    private static final String PROCEDURE_UPDATE_TIPO_OBJETO = "{CALL EDITAR_TIPO_OBJETO(?,?)}";
    private static final String PROCEDURE_DELETE_TIPO_OBJETO = "{CALL ElIMINAR_TIPO_OBJETO(?,?)}";
    
    private static final int PROCEDURE_INSERTAR_TIPO_OBJETO_ID_INDEX = 1;
    private static final int PROCEDURE_INSERTAR_TIPO_OBJETO__NOMBRE_INDEX = 2;
    
    private static final int PROCEDURE_UPDATE_TIPO_OBJETO_ID_INDEX = 1;
    private static final int PROCEDURE_UPDATE_TIPO_OBJETO__NOMBRE_INDEX = 2;
    
    private static final int PROCEDURE_DELETE_TIPO_OBJETO_ID_INDEX = 1;
    private static final int PROCEDURE_DELETE_TIPO_OBJETO__NOMBRE_INDEX = 2;

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Tipo_Objeto_Aprendizaje_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param tipoObjeto
     * @return Retorna Null si el Tipo_Objeto no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Tipo_Objeto.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean InsertarArea(Tipo_Objeto_Aprendizaje_Bean tipoObjeto) throws SQLException {
        boolean resultado;        
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_INSERT_TIPO_OBJETO);
        statement.setLong(PROCEDURE_INSERTAR_TIPO_OBJETO_ID_INDEX, tipoObjeto.getId_tipo_objeto_aprendizaje());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_INSERTAR_TIPO_OBJETO__NOMBRE_INDEX, tipoObjeto.getNombre_tipo_objeto_aprendizaje());        
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
     * @param tipoObjeto
     * @return Retorna Null si el Tipo_Objeto no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Tipo_Objeto.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean UpdateArea(Tipo_Objeto_Aprendizaje_Bean tipoObjeto) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_UPDATE_TIPO_OBJETO);
        statement.setLong(PROCEDURE_UPDATE_TIPO_OBJETO_ID_INDEX, tipoObjeto.getId_tipo_objeto_aprendizaje());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_UPDATE_TIPO_OBJETO__NOMBRE_INDEX, tipoObjeto.getNombre_tipo_objeto_aprendizaje());  
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
     * @param Id_tipo_objeto_aprendizaje Id del Tipo_Objeto
     * @return Retorna Null si el Tipo_Objeto no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Tipo_Objeto.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean DeleteArea(Tipo_Objeto_Aprendizaje_Bean tipoObjeto) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_DELETE_TIPO_OBJETO);
        statement.setLong(PROCEDURE_DELETE_TIPO_OBJETO_ID_INDEX, tipoObjeto.getId_tipo_objeto_aprendizaje());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_DELETE_TIPO_OBJETO__NOMBRE_INDEX, tipoObjeto.getNombre_tipo_objeto_aprendizaje());        
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
