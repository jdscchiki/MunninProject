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
import model.bean.Area;
import model.bean.Centro;
import util.ConexionBD;

/**
 *
 * @author Juan David Segura
 */
public class AreaDAO extends ConexionBD {

    private static final String COL_ID = "id_area";
    private static final String COL_NOMBRE = "nombre_area";
    private static final String COL_ACTIVO = "activo_area";
    private static final String COL_ID_CENTRO = "id_centro_area";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     */
    public AreaDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar un area en la base de datos
     *
     * @deprecated
     * @param area Datos del area insertada
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean insert(Area area) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_AREA(?,?,?)}";
        int indexNombre = 1;
        int indexActivo = 2;
        int indexIdCentro = 3;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexNombre, area.getNombre());
        statement.setBoolean(indexActivo, area.isActivo());
        statement.setString(indexIdCentro, area.getCentro().getId());

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
     * Metodo para actualizar un area en la base de datos
     *
     * @deprecated
     * @param area Datos del area a ser modificada
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(Area area) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_AREA(?,?,?,?)}";
        int indexId = 1;
        int indexNombre = 2;
        int indexActivo = 3;
        int indexIdCentro = 4;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, area.getId());
        statement.setString(indexNombre, area.getNombre());
        statement.setBoolean(indexActivo, area.isActivo());
        statement.setString(indexIdCentro, area.getCentro().getId());

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
     * Metodo para borrar un area en la base de datos
     *
     * @deprecated
     * @param area Datos del area
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(Area area) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_AREA(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, area.getId());

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
     * Metodo para ver los datos de un area
     *
     * @param area Objeto de tipo Area que en el atributo id tiene el valor del
     * id a ser consultado
     * @return los valores almacenados en la tabla area de la base de datos
     * @throws SQLException
     */
    public Area select(Area area) throws SQLException {

        String query = "{CALL VER_AREA(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, area.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            area.setId(rs.getInt(COL_ID));
            area.setNombre(rs.getString(COL_NOMBRE));
            area.setActivo(rs.getBoolean(COL_ACTIVO));
            Centro centro = new Centro();
            centro.setId(rs.getString(COL_ID_CENTRO));
            area.setCentro(centro);
        }
        if (!encontrado) {
            area = null;
        }

        return area;
    }
    
    public ArrayList<Area> selectAll() throws SQLException {
        ArrayList<Area> result = new ArrayList<>();

        String query = "{CALL VER_TODOS_AREA()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Area area = new Area();
            area.setId(rs.getInt(COL_ID));
            area.setNombre(rs.getString(COL_NOMBRE));
            area.setActivo(rs.getBoolean(COL_ACTIVO));
            Centro centro = new Centro();
            centro.setId(rs.getString(COL_ID_CENTRO));
            area.setCentro(centro);
            
            result.add(area);
        }

        return result;
    }
}
