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

/**
 * Esta clase realiza y procesa las consultas a bases de datos, de la tabla
 * TipoObjetoAprendizaje.
 *
 * @version 1.3
 * @author Monica <JBadCode>
 */

public class Tipo_Objeto_Aprendizaje_Dao extends ConexionBD {

    private static final String COL_ID_TIPO_OBJETO_APRENDIZAJE = "id_tipo_objeto_aprendizaje";
    private static final String COL_NOMBRE_TIPO_OBJETO_APRENDIZAJE = "nombre_tipo_objeto_aprendizaje";


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
     * @return Retorna Null si el TipoObjeto no se encuetra en la base de datos, de lo
     * contrario retorna los datos del TipoObjeto.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean InsertarArea(Tipo_Objeto_Aprendizaje_Bean tipoObjeto) throws SQLException {
        boolean resultado; // esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query = "{CALL INSERTAR_TIPO_OBJETO_APRENDIZAJE(?,?)}";
        int indexIdTipoObjeto = 1;
        int indexNombreTipoObjeto = 2;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdTipoObjeto, tipoObjeto.getId_tipo_objeto_aprendizaje());
        statement.setString(indexNombreTipoObjeto, tipoObjeto.getNombre_tipo_objeto_aprendizaje());        
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
     * @return Retorna Null si el TipoObjeto no se encuetra en la base de datos, de lo
     * contrario retorna los datos del TipoObjeto.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean UpdateArea(Tipo_Objeto_Aprendizaje_Bean tipoObjeto) throws SQLException {
       boolean resultado; // esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query = "{CALL EDITAR_TIPO_OBJETO_APRENDIZAJE(?,?)}";
        int indexIdTipoObjeto = 1;
        int indexNombreTipoObjeto = 2;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdTipoObjeto, tipoObjeto.getId_tipo_objeto_aprendizaje());
        statement.setString(indexNombreTipoObjeto, tipoObjeto.getNombre_tipo_objeto_aprendizaje());        
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
     * @param Id_tipo_objeto_aprendizaje Id del TipoObjeto
     * @return Retorna Null si el TipoObjeto no se encuetra en la base de datos, de lo
     * contrario retorna los datos del TipoObjeto.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean DeleteArea(Tipo_Objeto_Aprendizaje_Bean tipoObjeto) throws SQLException {
        boolean resultado; // esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query = "{CALL ELIMINAR_TIPO_OBJETO_APRENDIZAJE(?,?)}";
        int indexIdTipoObjeto = 1;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdTipoObjeto, tipoObjeto.getId_tipo_objeto_aprendizaje());     
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
