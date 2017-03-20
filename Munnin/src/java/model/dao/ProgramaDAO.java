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
import model.bean.Programa;
import util.ConexionBD;

/**
 *
 * @author Juan David Segura
 */
public class ProgramaDAO extends ConexionBD {

    private static final String COL_ID = "id_programa";
    private static final String COL_NOMBRE = "nombre_programa";
    private static final String COL_ACTIVO = "activo_programa";
    private static final String COL_ID_AREA = "id_area_programa";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     */
    public ProgramaDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar un programa en la base de datos
     *
     * @deprecated
     * @param programa Datos del programa insertado
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(Programa programa) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_PROGRAMA(?,?,?)}";
        int indexNombre = 1;
        int indexActivo = 2;
        int indexIdArea = 3;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexNombre, programa.getNombre());
        statement.setBoolean(indexActivo, programa.isActivo());
        statement.setInt(indexIdArea, programa.getArea().getId());
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
     * Metodo para actualizar una programa en la base de datos
     *
     * @deprecated
     * @param programa Datos del programa a ser modificado
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(Programa programa) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_PROGRAMA(?,?,?,?)}";
        int indexId = 1;
        int indexNombre = 2;
        int indexActivo = 3;
        int indexIdArea = 4;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, programa.getId());
        statement.setString(indexNombre, programa.getNombre());
        statement.setBoolean(indexActivo, programa.isActivo());
        statement.setInt(indexIdArea, programa.getArea().getId());
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
     * Metodo para borrar un programa en la base de datos
     *
     * @deprecated
     * @param programa Datos del programa
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(Programa programa) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_PROGRAMA(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, programa.getId());

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
     * Metodo para ver los datos de un programa
     *
     * @param programa Objeto de tipo Programa que en el atributo id tiene el
     * valor del id a ser consultado
     * @return los valores almacenados en la tabla programa de la base de datos
     * @throws SQLException
     */
    public Programa select(Programa programa) throws SQLException {

        String query = "{CALL VER_PROGRAMA(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, programa.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            programa.setId(rs.getInt(COL_ID));
            programa.setNombre(rs.getString(COL_NOMBRE));
            programa.setActivo(rs.getBoolean(COL_ACTIVO));
            Area area = new Area();
            area.setId(rs.getInt(COL_ID_AREA));
            programa.setArea(area);
        }
        if (!encontrado) {
            programa = null;
        }

        return programa;
    }
    
    public ArrayList<Programa> selectAll() throws SQLException {
        ArrayList<Programa> result = new ArrayList<>();

        String query = "{CALL VER_TODOS_PROGRAMA()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Programa programa = new Programa();
            programa.setId(rs.getInt(COL_ID));
            programa.setNombre(rs.getString(COL_NOMBRE));
            programa.setActivo(rs.getBoolean(COL_ACTIVO));
            Area area = new Area();
            area.setId(rs.getInt(COL_ID_AREA));
            programa.setArea(area);
            
            result.add(programa);
        }

        return result;
    }
    
    public ArrayList<Programa> selectAllCenter(String idCenter) throws SQLException{
        ArrayList<Programa> result = new ArrayList<>();
        
        String query = "{CALL VER_TODOS_PROGRAMA_CENTRO(?,?)}";
        int indexIdCentro = 1;
        int indexActivo = 2;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexIdCentro, idCenter);
        statement.setBoolean(indexActivo, true);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Programa programa = new Programa();
            programa.setId(rs.getInt(COL_ID));
            programa.setNombre(rs.getString(COL_NOMBRE));
            result.add(programa);
        }
        
        return result;
    }
    
    public int countProgramsCenter(String idCenter, String search, boolean active) throws SQLException{
        int result = 0;
        
        String query = "{CALL VER_PROGRAMA_CENTRO_CONTEO(?,?,?)}";
        int indexIdCentro = 1;
        int indexSearch = 2;
        int indexActive = 3;

        String resConteo = "conteo";//nombre de la columna del select

        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexIdCentro, idCenter);
        statement.setString(indexSearch, search);
        statement.setBoolean(indexActive, active);

        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        while (rs.next()) {
            //asigna los valores resultantes de la consulta
            result = rs.getInt(resConteo);
        }
        return result;
    }
    
    public ArrayList<Programa> selectSomeProgramsCenter(String idCenter, int page, int resultsInPage, String search, boolean active) throws SQLException {
        ArrayList<Programa> result = new ArrayList<>();

        String query = "{CALL VER_TODOS_PROGRAMA_CENTRO_PAGINADO(?,?,?,?,?)}";
        int indexCentro = 1;
        int indexPagina = 2;
        int indexCantXPag = 3;
        int indexSearch = 4;
        int indexActive = 5;
        
        String resultNombreArea = "nombre_area";

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexCentro, idCenter);
        statement.setInt(indexPagina, page);
        statement.setInt(indexCantXPag, resultsInPage);
        statement.setString(indexSearch, search);
        statement.setBoolean(indexActive, active);

        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Programa programa = new Programa();
            programa.setId(rs.getInt(COL_ID));
            programa.setNombre(rs.getString(COL_NOMBRE));
            Area area = new Area();
            area.setNombre(rs.getString(resultNombreArea));
            programa.setArea(area);
            result.add(programa);
        }
        return result;
    }
    
    public boolean disable(Programa programa) throws SQLException{
        boolean resultado;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL EDITAR_PROGRAMA_INHABILITAR(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, programa.getId());

        if (statement.executeUpdate() == 1) {//si solo modifico una fila el update se completa
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el update cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }

        return resultado;
    }
    
    public boolean enable(Programa programa) throws SQLException{
        boolean resultado;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL EDITAR_PROGRAMA_HABILITAR(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, programa.getId());

        if (statement.executeUpdate() == 1) {//si solo modifico una fila el update se completa
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el update cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }

        return resultado;
    }
}
