/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import util.ConexionBD;
import modelo.bean.TipoDocumento;

/**
 *
 * @author Juan David Segura Castro 
 */
public class TipoDocumentoDAO extends ConexionBD {

    private static final String COL_ID = "id_tipo_documento";
    private static final String COL_NOMBRE = "nombre_tipo_documento";

    /**
     * Establece conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     */
    public TipoDocumentoDAO() throws NamingException, SQLException {
        super();
    }
    
    /**
     * Metodo para insertar un tipo de documento en la base de datos
     *
     * @deprecated
     * @param tipoDocumento Datos del tipo de documento insertado
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(TipoDocumento tipoDocumento) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_TIPO_DOCUMENTO(?,?)}";
        int indexId = 1;
        int indexNombre = 2;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, tipoDocumento.getId());
        statement.setString(indexNombre, tipoDocumento.getNombre());
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * Metodo para actualizar un tipo de documento en la base de datos
     *
     * @deprecated
     * @param tipoDocumento Datos del tipo de documento a ser modificado
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(TipoDocumento tipoDocumento) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_TIPO_DOCUMENTO(?,?)}";
        int indexId = 1;
        int indexNombre = 2;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, tipoDocumento.getId());
        statement.setString(indexNombre, tipoDocumento.getNombre());
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * Metodo para borrar un tipo de documento en la base de datos
     *
     * @deprecated
     * @param tipoDocumento Datos de la tipo de documento
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(TipoDocumento tipoDocumento) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_TIPO_DOCUMENTO(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, tipoDocumento.getId());

        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * Metodo para ver los datos de una tipo de documento
     *
     * @param tipoDocumento Objeto de tipo TipoDocumento que en el atributo id tiene el
     * valor del id a ser consultado
     * @return los valores almacenados en la tabla tipo_documento de la base de datos
     * @throws SQLException
     */
    public TipoDocumento select(TipoDocumento tipoDocumento) throws SQLException {

        String query = "{CALL VER_TIPO_DOCUMENTO(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, tipoDocumento.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            tipoDocumento.setId(rs.getInt(COL_ID));
            tipoDocumento.setNombre(rs.getString(COL_NOMBRE));
        }
        if (!encontrado) {
            tipoDocumento = null;
        }

        return tipoDocumento;
    }

    /**
     * Consulta en la base de datos todos los tipos de documentos permitidos en
     * el aplicativo
     *
     * @return ArrayList de objetos TipoDocumento
     * @throws SQLException Error al realizar la consulta, revisar el procedimiento almacenado
     */
    public ArrayList<TipoDocumento> verTodos() throws SQLException {
        ArrayList<TipoDocumento> tiposDoc = new ArrayList<>();//el objeto en donde se guardan los resultados de la consulta
        
        //datos de la consulta en base de datos
        String query = "{CALL VERTODOS_TIPO_DOCUMENTO()}";
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        while (rs.next()) {
            TipoDocumento td = new TipoDocumento();
            td.setId(rs.getInt(COL_ID));
            td.setNombre(rs.getString(COL_NOMBRE));
            tiposDoc.add(td);
        }

        return tiposDoc;
    }

}
