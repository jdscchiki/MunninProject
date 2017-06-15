/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import model.bean.Centro;
import model.bean.Estado;
import model.bean.Funcionario;
import model.bean.Producto;
import model.bean.TipoArchivo;
import model.bean.Version;
import util.database.connectionDB;

/**
 *
 * @author Juan David Segura
 */
public class VersionDAO extends connectionDB {

    private static final String COL_ID = "id_version";
    private static final String COL_NUMERO = "numero_version";
    private static final String COL_URL = "url_version";
    private static final String COL_FECHA = "fecha_version";
    private static final String COL_FECHA_CADUCIDAD = "fecha_caducidad_version";
    private static final String COL_FECHA_APROVACION = "fecha_aprobacion_version";
    private static final String COL_ID_ESTADO = "id_estado_version";
    private static final String COL_ID_TIPO_ARCHIVO = "id_tipo_archivo_version";
    private static final String COL_ID_PRODUCTO = "id_producto_version";
    private static final String COL_ID_CENTRO = "id_centro_version";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor connectionDB
     * @throws SQLException Error en el constructor connectionDB
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
        boolean result;

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
            result = true;
        } else {
            this.getConexion().rollback();
            result = false;
        }
        return result;
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
        boolean result;

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
            result = true;
        } else {
            this.getConexion().rollback();
            result = false;
        }
        return result;
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
        boolean result;

        String query = "{CALL ELIMINAR_VERSION(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, version.getId());

        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            result = true;
        } else {
            this.getConexion().rollback();
            result = false;
        }
        return result;
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

    public ArrayList<Version> selectAll() throws SQLException {
        ArrayList<Version> result = new ArrayList<>();

        String query = "{CALL VER_TODOS_VERSION()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Version version = new Version();
            version.setId(rs.getInt(COL_ID));
            version.setNumero(rs.getInt(COL_NUMERO));
            version.setUrl(rs.getString(COL_URL));
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

            result.add(version);
        }

        return result;
    }

    public int create(Version version) throws SQLException {
        int result = 0;

        String query = "INSERT INTO version ("
                + COL_NUMERO + ","
                + COL_URL + ","
                + COL_FECHA + ","
                + COL_ID_ESTADO + ","
                + COL_ID_TIPO_ARCHIVO + ","
                + COL_ID_PRODUCTO + ","
                + COL_ID_CENTRO + ") "
                + "VALUES(?,'',CURRENT_DATE,3,?,?,?)";
        int indexNumero = 1;
        int indexIdTipoArchivo = 2;
        int indexIdProducto = 3;
        int indexIdCentro = 4;

        PreparedStatement statement = this.getConexion().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setInt(indexNumero, version.getNumero());
        statement.setInt(indexIdTipoArchivo, version.getTipoArchivo().getId());
        statement.setInt(indexIdProducto, version.getProducto().getId());
        statement.setString(indexIdCentro, version.getCentro().getId());

        if (statement.executeUpdate() != 1) {
            this.getConexion().rollback();
        } else {
            this.getConexion().commit();
        }

        ResultSet rs = statement.getGeneratedKeys();
        while (rs.next()) {
            result = rs.getInt(1);
        }

        return result;
    }

    public boolean editUrl(Version version) throws SQLException {
        boolean result = false;

        String query = "UPDATE version SET "
                + COL_URL + "=? "
                + "WHERE " + COL_ID + "=?";
        int indexURL = 1;
        int indexId = 2;

        PreparedStatement statement = this.getConexion().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setString(indexURL, version.getUrl());
        statement.setInt(indexId, version.getId());
        if (statement.executeUpdate() != 1) {
            this.getConexion().rollback();
        } else {
            this.getConexion().commit();
            result = true;
        }

        return result;
    }

    public boolean updateEstado(Version version) throws SQLException {
        boolean result;

        String query = "{CALL CAMBIO_ESTADO(?,?)}";
        int indexId = 1;
        int indexIdEstado = 2;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, version.getId());
        statement.setInt(indexIdEstado, version.getEstado().getId());
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            result = true;
        } else {
            this.getConexion().rollback();
            result = false;
        }
        return result;
    }
    
    public int countFilesCoordinatorCenter(String idCentro, String search) throws SQLException {
        int conteo = 0;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL CONTEO_ARCHIVOS_COORDINADOR_CENTRO(?,?)}";
        int indexCentro = 1;
        int indexFiltro = 2;

        String resConteo = "conteo";//nombre de la columna del select
        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexCentro, idCentro);
        statement.setString(indexFiltro, search);

        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        while (rs.next()) {
            //asigna los valores resultantes de la consulta
            conteo = rs.getInt(resConteo);
        }
        return conteo;
    }
    
    public ArrayList<Version> selectSomeFilesCoordinatorCenter(String idCentro, int pagina, int cantXpag, String search) throws SQLException {
        ArrayList<Version> versions = new ArrayList<>();//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL VER_ARCHIVOS_COORDINADOR_CENTRO(?,?,?,?)}";
        int indexCentro = 1;
        int indexPagina = 2;
        int indexCantXPag = 3;
        int indexSearch = 4;

        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexCentro, idCentro);
        statement.setInt(indexPagina, pagina);
        statement.setInt(indexCantXPag, cantXpag);
        statement.setString(indexSearch, search);

        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        while (rs.next()) {
            //asigna los valores resultantes de la consulta
            Version version = new Version();
            version.setId(rs.getInt(COL_ID));
            version.setNumero(rs.getInt(COL_NUMERO));
            version.setFecha((rs.getDate(COL_FECHA)));
            version.setUrl(rs.getString(COL_URL));
            Producto producto = new Producto();
            producto.setNombre(rs.getString("nombre_producto_version"));
            version.setProducto(producto);
            versions.add(version);
        }
        return versions;
    }
    
    public int countFilesPedagocicalCenter(String idCentro, String search) throws SQLException {
        int conteo = 0;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL CONTEO_ARCHIVOS_PEDAGOGICO_CENTRO(?,?)}";
        int indexCentro = 1;
        int indexFiltro = 2;

        String resConteo = "conteo";//nombre de la columna del select
        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexCentro, idCentro);
        statement.setString(indexFiltro, search);

        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        while (rs.next()) {
            //asigna los valores resultantes de la consulta
            conteo = rs.getInt(resConteo);
        }
        return conteo;
    }
    
    public ArrayList<Version> selectSomeFilesPedagogicalCenter(String idCentro, int pagina, int cantXpag, String search) throws SQLException {
        ArrayList<Version> versions = new ArrayList<>();//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL VER_ARCHIVOS_PEDAGOGICO_CENTRO(?,?,?,?)}";
        int indexCentro = 1;
        int indexPagina = 2;
        int indexCantXPag = 3;
        int indexSearch = 4;

        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexCentro, idCentro);
        statement.setInt(indexPagina, pagina);
        statement.setInt(indexCantXPag, cantXpag);
        statement.setString(indexSearch, search);

        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        while (rs.next()) {
            //asigna los valores resultantes de la consulta
            Version version = new Version();
            version.setId(rs.getInt(COL_ID));
            version.setNumero(rs.getInt(COL_NUMERO));
            version.setFecha((rs.getDate(COL_FECHA)));
            version.setUrl(rs.getString(COL_URL));
            Producto producto = new Producto();
            producto.setNombre(rs.getString("nombre_producto_version"));
            version.setProducto(producto);
            versions.add(version);
        }
        return versions;
    }
    
    public int countFilesCenter(String idCentro, String search) throws SQLException {
        int conteo = 0;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL CONTEO_ARCHIVOS_CENTRO(?,?)}";
        int indexCentro = 1;
        int indexFiltro = 2;

        String resConteo = "conteo";//nombre de la columna del select
        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexCentro, idCentro);
        statement.setString(indexFiltro, search);

        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        while (rs.next()) {
            //asigna los valores resultantes de la consulta
            conteo = rs.getInt(resConteo);
        }
        return conteo;
    }
    
    public ArrayList<Version> selectSomeFilesCenter(String idCentro, int pagina, int cantXpag, String search) throws SQLException {
        ArrayList<Version> versions = new ArrayList<>();//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL VER_ARCHIVOS_CENTRO(?,?,?,?)}";
        int indexCentro = 1;
        int indexPagina = 2;
        int indexCantXPag = 3;
        int indexSearch = 4;

        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexCentro, idCentro);
        statement.setInt(indexPagina, pagina);
        statement.setInt(indexCantXPag, cantXpag);
        statement.setString(indexSearch, search);

        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        while (rs.next()) {
            //asigna los valores resultantes de la consulta
            Version version = new Version();
            version.setId(rs.getInt(COL_ID));
            version.setNumero(rs.getInt(COL_NUMERO));
            version.setFecha((rs.getDate(COL_FECHA)));
            version.setUrl(rs.getString(COL_URL));
            Producto producto = new Producto();
            producto.setNombre(rs.getString("nombre_producto_version"));
            version.setProducto(producto);
            versions.add(version);
        }
        return versions;
    }
    
    public boolean setAutores(Version version) throws SQLException{
        boolean result = false;
        
        String query = "{CALL INSERTAR_AUTOR(?,?)}";
        int indexIdFuncionario = 1;
        int indexIdVersion = 2;
        
        boolean commit = true;
        for (Funcionario funcionario : version.getFuncionarios()) {
            CallableStatement statement = this.getConexion().prepareCall(query);
            statement.setInt(indexIdFuncionario, funcionario.getId());
            statement.setInt(indexIdVersion, version.getId());
            if(statement.executeUpdate()!=1){
                this.getConexion().rollback();
                commit = false;
                break;
            }
        }
        if (commit) {
            this.getConexion().commit();
        }
        
        return result;
    }
}
