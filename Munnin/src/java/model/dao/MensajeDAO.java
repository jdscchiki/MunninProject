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
import model.bean.Mensaje;
import util.database.connectionDB;

/**
 *
 * @author Juan David Segura
 */
public class MensajeDAO extends connectionDB {

    private static final String COL_ID = "id_mensaje";
    private static final String COL_TEXTO = "texto_mensaje";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor connectionDB
     * @throws SQLException Error en el constructor connectionDB
     */
    public MensajeDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar un mensaje en la base de datos
     *
     * @deprecated
     * @param mensaje Datos del mensaje insertado
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(Mensaje mensaje) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_MENSAJE(?)}";
        int indexTexto = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexTexto, mensaje.getTexto());
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
     * Metodo para actualizar un mensaje en la base de datos
     *
     * @deprecated
     * @param mensaje Datos del mensaje a ser modificado
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(Mensaje mensaje) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_MENSAJE(?,?)}";
        int indexId = 1;
        int indexTexto = 2;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, mensaje.getId());
        statement.setString(indexTexto, mensaje.getTexto());

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
     * Metodo para borrar un mensaje en la base de datos
     *
     * @deprecated
     * @param mensaje Datos del mensaje
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(Mensaje mensaje) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_MENSAJE(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, mensaje.getId());

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
     * Metodo para ver los datos de un mensaje
     *
     * @param mensaje Objeto de tipo Mensaje que en el atributo id tiene el
     * valor del id a ser consultado
     * @return los valores almacenados en la tabla mensaje de la base de datos
     * @throws SQLException
     */
    public Mensaje select(Mensaje mensaje) throws SQLException {

        String query = "{CALL VER_MENSAJE(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, mensaje.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            mensaje.setId(rs.getInt(COL_ID));
            mensaje.setTexto(rs.getString(COL_TEXTO));
        }
        if (!encontrado) {
            mensaje = null;
        }

        return mensaje;
    }
    
    public ArrayList<Mensaje> selectAll() throws SQLException {
        ArrayList<Mensaje> result = new ArrayList<>();

        String query = "{CALL VER_TODOS_MENSAJE()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Mensaje mensaje = new Mensaje();
            mensaje.setId(rs.getInt(COL_ID));
            mensaje.setTexto(rs.getString(COL_TEXTO));
            
            result.add(mensaje);
        }

        return result;
    }
}
