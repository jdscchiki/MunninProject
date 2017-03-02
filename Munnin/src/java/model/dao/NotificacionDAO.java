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
import model.bean.Funcionario;
import model.bean.Mensaje;
import model.bean.Notificacion;
import model.bean.Rol;
import model.bean.Version;
import util.ConexionBD;

/**
 *
 * @author Juan David Segura
 */
public class NotificacionDAO extends ConexionBD {

    private static final String COL_ID = "id_notificacion";
    private static final String COL_ACTIVO = "activo_notificacion";
    private static final String COL_ID_MENSAJE = "id_mensaje_notificacion";
    private static final String COL_ID_VERSION = "id_version_notificacion";
    private static final String COL_ID_FUNCIONARIO = "id_funcionario_notificacion";
    private static final String COL_ID_ROL = "id_rol_notificacion";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     */
    public NotificacionDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar una notificacion en la base de datos
     *
     * @deprecated
     * @param notificacion Datos de la notificacion insertada
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(Notificacion notificacion) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_NOTIFICACION(?,?,?,?,?)}";
        int indexVisto = 1;
        int indexIdMensaje = 2;
        int indexIdVersion = 3;
        int indexIdFuncionario = 4;
        int indexIdRol = 5;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setBoolean(indexVisto, notificacion.isVisto());
        statement.setInt(indexIdMensaje, notificacion.getMensaje().getId());
        statement.setInt(indexIdVersion, notificacion.getVersion().getId());
        statement.setInt(indexIdFuncionario, notificacion.getFuncionario().getId());
        statement.setInt(indexIdRol, notificacion.getRol().getId());
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
     * Metodo para actualizar una notificacion en la base de datos
     *
     * @deprecated
     * @param notificacion Datos de la notificacion a ser modificada
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(Notificacion notificacion) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_NOTIFICACION(?,?,?,?,?,?)}";
        int indexId = 1;
        int indexVisto = 2;
        int indexIdMensaje = 3;
        int indexIdVersion = 4;
        int indexIdFuncionario = 5;
        int indexIdRol = 6;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, notificacion.getId());
        statement.setBoolean(indexVisto, notificacion.isVisto());
        statement.setInt(indexIdMensaje, notificacion.getMensaje().getId());
        statement.setInt(indexIdVersion, notificacion.getVersion().getId());
        statement.setInt(indexIdFuncionario, notificacion.getFuncionario().getId());
        statement.setInt(indexIdRol, notificacion.getRol().getId());

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
     * Metodo para borrar una notificacion en la base de datos
     *
     * @deprecated
     * @param notificacion Datos de la notificacion
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(Notificacion notificacion) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_NOTIFICACION(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, notificacion.getId());

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
     * Metodo para ver los datos de una notificacion
     *
     * @param notificacion Objeto de tipo Notificacion que en el atributo id
     * tiene el valor del id a ser consultado
     * @return los valores almacenados en la tabla notificacion de la base de
     * datos
     * @throws SQLException
     */
    public Notificacion select(Notificacion notificacion) throws SQLException {

        String query = "{CALL VER_NOTIFICACION(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, notificacion.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            notificacion.setId(rs.getInt(COL_ID));
            notificacion.setVisto(rs.getBoolean(COL_ACTIVO));
            Mensaje mensaje = new Mensaje();
            mensaje.setId(rs.getInt(COL_ID_MENSAJE));
            notificacion.setMensaje(mensaje);
            Version version = new Version();
            version.setId(rs.getInt(COL_ID_VERSION));
            notificacion.setVersion(version);
            Funcionario funcionario = new Funcionario();
            funcionario.setId(rs.getInt(COL_ID_FUNCIONARIO));
            notificacion.setFuncionario(funcionario);
            Rol rol = new Rol();
            rol.setId(rs.getInt(COL_ID_ROL));
            notificacion.setRol(rol);
        }
        if (!encontrado) {
            notificacion = null;
        }

        return notificacion;
    }
    
    public ArrayList<Notificacion> selectAll() throws SQLException {
        ArrayList<Notificacion> result = new ArrayList<>();

        String query = "{CALL VER_TODOS_NOTIFICACION()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Notificacion notificacion = new Notificacion();
            notificacion.setId(rs.getInt(COL_ID));
            notificacion.setVisto(rs.getBoolean(COL_ACTIVO));
            Mensaje mensaje = new Mensaje();
            mensaje.setId(rs.getInt(COL_ID_MENSAJE));
            notificacion.setMensaje(mensaje);
            Version version = new Version();
            version.setId(rs.getInt(COL_ID_VERSION));
            notificacion.setVersion(version);
            Funcionario funcionario = new Funcionario();
            funcionario.setId(rs.getInt(COL_ID_FUNCIONARIO));
            notificacion.setFuncionario(funcionario);
            Rol rol = new Rol();
            rol.setId(rs.getInt(COL_ID_ROL));
            notificacion.setRol(rol);
            
            result.add(notificacion);
        }

        return result;
    }
}
