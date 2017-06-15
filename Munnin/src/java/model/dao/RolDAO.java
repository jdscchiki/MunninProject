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
import model.bean.Rol;
import util.database.connectionDB;

/**
 *
 * @author Juan David Segura
 */
public class RolDAO extends connectionDB {

    public static final int ID_ADMINISTRADOR = 1;
    public static final int ID_COORDINADOR = 2;
    public static final int ID_E_TECNICO = 3;
    public static final int ID_E_PEDAGOGICO = 4;
    public static final int ID_INSTRUCTOR = 5;
    
    private static final String COL_ID = "id_rol";
    private static final String COL_NOMBRE = "nombre_rol";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor connectionDB
     * @throws SQLException Error en el constructor connectionDB
     */
    public RolDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar un rol en la base de datos
     *
     * @deprecated
     * @param rol Datos del rol insertado
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(Rol rol) throws SQLException {
        boolean result;

        String query = "{CALL INSERTAR_ROL(?)}";
        int indexNombre = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexNombre, rol.getNombre());
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
     * Metodo para actualizar un rol en la base de datos
     *
     * @deprecated
     * @param rol Datos del rol a ser modificado
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(Rol rol) throws SQLException {
        boolean result;

        String query = "{CALL EDITAR_ROL(?,?)}";
        int indexId = 1;
        int indexNombre = 2;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, rol.getId());
        statement.setString(indexNombre, rol.getNombre());
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
     * Metodo para borrar un rol en la base de datos
     *
     * @deprecated
     * @param rol Datos del rol
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(Rol rol) throws SQLException {
        boolean result;

        String query = "{CALL ELIMINAR_ROL(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, rol.getId());

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
     * Metodo para ver los datos de un rol
     *
     * @param rol Objeto de tipo Rol que en el atributo id tiene el valor del id
     * a ser consultado
     * @return los valores almacenados en la tabla rol de la base de datos
     * @throws SQLException
     */
    public Rol select(Rol rol) throws SQLException {

        String query = "{CALL VER_ROL(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, rol.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            rol.setId(rs.getInt(COL_ID));
            rol.setNombre(rs.getString(COL_NOMBRE));
        }
        if (!encontrado) {
            rol = null;
        }

        return rol;
    }
    
    public ArrayList<Rol> selectAll() throws SQLException{
        ArrayList<Rol> result = new ArrayList<>();
        
        String query = "{CALL VER_TODOS_ROL()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Rol rol = new Rol();
            rol.setId(rs.getInt(COL_ID));
            rol.setNombre(rs.getString(COL_NOMBRE));
            result.add(rol);
        }
        
        return result;
    }
}
