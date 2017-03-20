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
    
    public ArrayList<Area> selectSomeAreasCenter(String idCentro, int pagina, int cantXpag, String search, boolean activo) throws SQLException {
        ArrayList<Area> areas = new ArrayList<>();//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL VER_TODOS_AREA_CENTRO_PAGINADO(?,?,?,?,?)}";
        int indexCentro = 1;
        int indexPagina = 2;
        int indexCantXPag = 3;
        int indexSearch = 4;
        int indexActivo = 5;

        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexCentro, idCentro);
        statement.setInt(indexPagina, pagina);
        statement.setInt(indexCantXPag, cantXpag);
        statement.setString(indexSearch, search);
        statement.setBoolean(indexActivo, activo);

        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        while (rs.next()) {
            //asigna los valores resultantes de la consulta
            Area area = new Area();
            area.setId(rs.getInt(COL_ID));
            area.setNombre(rs.getString(COL_NOMBRE));
            Centro centro = new Centro();
            centro.setId(COL_ID_CENTRO);
            area.setCentro(centro);
            areas.add(area);
        }
        return areas;
    }
    
    public boolean isNameAreaOcuped(String nombre, String idCentro) throws SQLException {
        boolean result = false;

        String query = "{CALL VER_AREA_NOMBRE(?,?)}";
        int indexNombre = 1;
        int indexIdCentro = 2;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexNombre, nombre);
        statement.setString(indexIdCentro, idCentro);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            result = true;
        }

        return result;
    }
    
    public boolean registerArea(Area area) throws SQLException {
        boolean resultado;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL INSERTAR_AREA_NUEVA(?,?)}";
        int indexNombre = 1;
        int indexIdCentro = 2;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexNombre, area.getNombre());
        statement.setString(indexIdCentro, area.getCentro().getId());

        if (statement.executeUpdate() == 1) {//si solo modifico una fila el registro se completa
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }

        return resultado;
    }
    
    public boolean updateArea(Area area) throws SQLException {
        boolean resultado;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL EDITAR_AREA_NOMBRE(?,?)}";
        int indexNombre = 1;
        int indexIdArea = 2;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexNombre, area.getNombre());
        statement.setInt(indexIdArea, area.getId());

        if (statement.executeUpdate() == 1) {//si solo modifico una fila el registro se completa
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }

        return resultado;
    }
    
    public boolean isLastAreaEnableArea(String idCentro, int idArea) throws SQLException {
        boolean answer = false;

        //datos de la consulta en base de datos
        String query = "{CALL VER_AREA_ES_ULTIMO(?,?)}";
        int indexIdCentro = 1;
        int indexIdArea = 2;
        String colAnswer = "RESULTADO";

        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexIdCentro, idCentro);
        statement.setInt(indexIdArea, idArea);

        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            answer = rs.getBoolean(colAnswer);
        }
        return answer;
    }
    
    public boolean disableArea(int idArea) throws SQLException {
        boolean resultado;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL EDITAR_AREA_INHABILITAR(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, idArea);

        if (statement.executeUpdate() == 1) {//si solo modifico una fila el update se completa
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el update cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }

        return resultado;
    }
    
    public int countAreasCenter(String idCentro, String search, boolean activo) throws SQLException {
        int conteo = 0;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL VER_AREA_CENTRO_CONTEO(?,?,?)}";
        int indexCentro = 1;
        int indexFiltro = 2;
        int indexActivo = 3;

        String resConteo = "conteo";//nombre de la columna del select

        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexCentro, idCentro);
        statement.setString(indexFiltro, search);
        statement.setBoolean(indexActivo, activo);

        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        while (rs.next()) {
            //asigna los valores resultantes de la consulta
            conteo = rs.getInt(resConteo);
        }
        return conteo;
    }
    
    public boolean enableArea(int idArea) throws SQLException {
        boolean resultado;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL EDITAR_AREA_HABILITAR(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, idArea);

        if (statement.executeUpdate() == 1) {//si solo modifico una fila el update se completa
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el update cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }

        return resultado;
    }
    
    public ArrayList<Area> selectAllCenter(String idCenter) throws SQLException{
        ArrayList<Area> result = new ArrayList<>();
        
        String query = "{CALL VER_TODOS_AREA_CENTRO(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexId, idCenter);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Area area = new Area();
            area.setId(rs.getInt(COL_ID));
            area.setNombre(rs.getString(COL_NOMBRE));
            result.add(area);
        }
        
        return result;
    }
}
