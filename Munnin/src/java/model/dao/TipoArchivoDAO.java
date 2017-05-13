/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import model.bean.TipoArchivo;
import util.database.connectionDB;

/**
 *
 * @author Juan David Segura
 */
public class TipoArchivoDAO extends connectionDB {

    private static final String COL_ID = "id_tipo_archivo";
    private static final String COL_NOMBRE = "nombre_tipo_archivo";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor connectionDB
     * @throws SQLException Error en el constructor connectionDB
     */
    public TipoArchivoDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar un tipo de archivo en la base de datos
     *
     * @deprecated
     * @param tipoArchivo Datos del tipo de archivo insertado
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(TipoArchivo tipoArchivo) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_TIPO_ARCHIVO(?)}";
        int indexNombre = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexNombre, tipoArchivo.getNombre());
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
     * Metodo para actualizar un tipo de archivo en la base de datos
     *
     * @deprecated
     * @param tipoArchivo Datos del tipo de archivo a ser modificado
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(TipoArchivo tipoArchivo) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_TIPO_ARCHIVO(?,?)}";
        int indexId = 1;
        int indexNombre = 2;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, tipoArchivo.getId());
        statement.setString(indexNombre, tipoArchivo.getNombre());
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
     * Metodo para borrar una tipo de archivo en la base de datos
     *
     * @deprecated
     * @param tipoArchivo Datos de la tipo de archivo
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(TipoArchivo tipoArchivo) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_TIPO_ARCHIVO(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, tipoArchivo.getId());

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
     * Metodo para ver los datos de una tipo de archivo
     *
     * @param tipoArchivo Objeto de tipo TipoArchivo que en el atributo id tiene
     * el valor del id a ser consultado
     * @return los valores almacenados en la tabla Tipo_Archivo de la base de
     * datos
     * @throws SQLException
     */
    public TipoArchivo select(TipoArchivo tipoArchivo) throws SQLException {

        String query = "{CALL VER_TIPO_ARCHIVO(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, tipoArchivo.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            tipoArchivo.setId(rs.getInt(COL_ID));
            tipoArchivo.setNombre(rs.getString(COL_NOMBRE));
        }
        if (!encontrado) {
            tipoArchivo = null;
        }

        return tipoArchivo;
    }
    
    public ArrayList<TipoArchivo> selectAll() throws SQLException {
        ArrayList<TipoArchivo> result = new ArrayList<>();

        String query = "{CALL VER_TODOS_TIPO_ARCHIVO()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            TipoArchivo tipoArchivo = new TipoArchivo();
            tipoArchivo.setId(rs.getInt(COL_ID));
            tipoArchivo.setNombre(rs.getString(COL_NOMBRE));
            
            result.add(tipoArchivo);
        }

        return result;
    }
}
