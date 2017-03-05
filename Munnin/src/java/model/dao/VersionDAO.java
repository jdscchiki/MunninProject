/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import model.bean.Centro;
import model.bean.Estado;
import model.bean.Producto;
import model.bean.TipoArchivo;
import model.bean.Version;
import util.ConexionBD;

/**
 *
 * @author Juan David Segura
 */
public class VersionDAO extends ConexionBD {

    private static final String COL_ID = "id_version";
    private static final String COL_NUMERO = "numero_version";
    private static final String COL_URL = "url_version";
    private static final String COL_NOTIFICACION = "notificacion_version";
    private static final String COL_FECHA = "fecha_version";
    private static final String COL_FECHA_CADUCIDAD = "fecha_caducidad_version";
    private static final String COL_FECHA_APROVACION = "fecha_aprovacion_version";
    private static final String COL_ID_ESTADO = "id_estdo_version";
    private static final String COL_ID_TIPO_ARCHIVO = "id_tipo_archivo_version";
    private static final String COL_ID_PRODUCTO = "id_producto_version";
    private static final String COL_ID_CENTRO = "id_centro_version";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     */
    public VersionDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar una version en la base de datos
     *
     * @deprecated
     * @param version Datos de la version insertada
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(Version version) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_VERSION(?,?,?,?,?,?,?,?,?,?)}";
        int indexNumero = 1;
        int indexUrl = 2;
        int indexNotificacion = 3;
        int indexFecha = 4;
        int indexFechaCaducidad = 5;
        int indexfechaAprovacion = 6;
        int indexIdEstado = 7;
        int indexIdTipoArchivo = 8;
        int indexIdProducto = 9;
        int indexIdCentro = 10;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexNumero, version.getNumero());
        statement.setString(indexUrl, version.getUrl());
        statement.setBoolean(indexNotificacion, version.isNotificacion());
        statement.setDate(indexFecha, (java.sql.Date) version.getFecha());
        statement.setDate(indexFechaCaducidad, (java.sql.Date) version.getFechaCaducidad());
        statement.setDate(indexfechaAprovacion, (java.sql.Date) version.getFechaAprovacion());
        statement.setInt(indexIdEstado, version.getEstado().getId());
        statement.setInt(indexIdTipoArchivo, version.getTipoArchivo().getId());
        statement.setInt(indexIdProducto, version.getProducto().getId());
        statement.setString(indexIdCentro, version.getCentro().getId());
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
     * Metodo para actualizar una version en la base de datos
     *
     * @deprecated
     * @param version Datos de la version a ser modificada
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(Version version) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_VERSION(?,?,?,?,?,?,?,?,?,?,?)}";
        int indexId = 1;
        int indexNumero = 2;
        int indexUrl = 3;
        int indexNotificacion = 4;
        int indexFecha = 5;
        int indexFechaCaducidad = 6;
        int indexfechaAprovacion = 7;
        int indexIdEstado = 8;
        int indexIdTipoArchivo = 9;
        int indexIdProducto = 10;
        int indexIdCentro = 11;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, version.getId());
        statement.setInt(indexNumero, version.getNumero());
        statement.setString(indexUrl, version.getUrl());
        statement.setBoolean(indexNotificacion, version.isNotificacion());
        statement.setDate(indexFecha, (java.sql.Date) version.getFecha());
        statement.setDate(indexFechaCaducidad, (java.sql.Date) version.getFechaCaducidad());
        statement.setDate(indexfechaAprovacion, (java.sql.Date) version.getFechaAprovacion());
        statement.setInt(indexIdEstado, version.getEstado().getId());
        statement.setInt(indexIdTipoArchivo, version.getTipoArchivo().getId());
        statement.setInt(indexIdProducto, version.getProducto().getId());
        statement.setString(indexIdCentro, version.getCentro().getId());
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
     * Metodo para borrar una version en la base de datos
     *
     * @deprecated
     * @param version Datos de la version
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(Version version) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_VERSION(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, version.getId());

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
     * Metodo para ver los datos de una version
     *
     * @param version Objeto de tipo Version que en el atributo id tiene el
     * valor del id a ser consultado
     * @return los valores almacenados en la tabla version de la base de datos
     * @throws SQLException
     */
    public Version select(Version version) throws SQLException {

        String query = "{CALL VER_VERSION(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, version.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            version.setId(rs.getInt(COL_ID));
            version.setNumero(rs.getInt(COL_NUMERO));
            version.setUrl(rs.getString(COL_URL));
            version.setNotificacion(rs.getBoolean(COL_NOTIFICACION));
            version.setFecha(rs.getDate(COL_FECHA));
            version.setFechaCaducidad(rs.getDate(COL_FECHA_CADUCIDAD));
            version.setFechaAprovacion(rs.getDate(COL_FECHA_APROVACION));
            Estado estado = new Estado();
            estado.setId(rs.getInt(COL_ID_ESTADO));
            version.setEstado(estado);
            TipoArchivo tipoArchivo = new TipoArchivo();
            tipoArchivo.setId(rs.getInt(COL_ID_TIPO_ARCHIVO));
            version.setTipoArchivo(tipoArchivo);
            Producto producto = new Producto();
            producto.setId(rs.getInt(COL_ID_PRODUCTO));
            version.setProducto(producto);
            Centro centro = new Centro();
            centro.setId(rs.getString(COL_ID_CENTRO));
            version.setCentro(centro);
        }
        if (!encontrado) {
            version = null;
        }

        return version;
    }
}
