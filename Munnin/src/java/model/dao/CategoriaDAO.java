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
import model.bean.Categoria;
import model.bean.Centro;
import util.database.ConexionBD;

/**
 *
 * @author Juan David Segura
 */
public class CategoriaDAO extends ConexionBD {

    private static final String COL_ID = "id_categoria";
    private static final String COL_NOMBRE = "nombre_categoria";
    private static final String COL_ACTIVO = "activo_categoria";
    private static final String COL_ID_CENTRO = "id_centro_categoria";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     */
    public CategoriaDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar una categoria en la base de datos
     *
     * @deprecated
     * @param categoria Datos de la categoria insertada
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(Categoria categoria) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_CATEGORIA(?,?,?)}";
        int indexNombre = 1;
        int indexActivo = 2;
        int indexIdCentro = 3;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexNombre, categoria.getNombre());
        statement.setBoolean(indexActivo, categoria.isActivo());
        statement.setString(indexIdCentro, categoria.getCentro().getId());
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
     * Metodo para actualizar una categoria en la base de datos
     *
     * @deprecated
     * @param categoria Datos de la categoria a ser modificada
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(Categoria categoria) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_CATEGORIA(?,?,?,?)}";
        int indexId = 1;
        int indexNombre = 2;
        int indexActivo = 3;
        int indexIdCentro = 4;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, categoria.getId());
        statement.setString(indexNombre, categoria.getNombre());
        statement.setBoolean(indexActivo, categoria.isActivo());
        statement.setString(indexIdCentro, categoria.getCentro().getId());

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
     * Metodo para borrar una categoria en la base de datos
     *
     * @deprecated
     * @param categoria Datos de la categoria
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(Categoria categoria) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_CATEGORIA(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, categoria.getId());

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
     * Metodo para ver los datos de una categoria
     *
     * @param categoria Objeto de tipo Categoria que en el atributo id tiene el
     * valor del id a ser consultado
     * @return los valores almacenados en la tabla categoria de la base de datos
     * @throws SQLException
     */
    public Categoria select(Categoria categoria) throws SQLException {

        String query = "{CALL VER_CATEGORIA(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, categoria.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            categoria.setId(rs.getInt(COL_ID));
            categoria.setNombre(rs.getString(COL_NOMBRE));
            categoria.setActivo(rs.getBoolean(COL_ACTIVO));
            Centro centro = new Centro();
            centro.setId(rs.getString(COL_ID_CENTRO));
            categoria.setCentro(centro);
        }
        if (!encontrado) {
            categoria = null;
        }

        return categoria;
    }
    
    public ArrayList<Categoria> selectAll() throws SQLException {
        ArrayList<Categoria> result = new ArrayList<>();
        
        String query = "{CALL VER_TODOS_CATEGORIA()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt(COL_ID));
            categoria.setNombre(rs.getString(COL_NOMBRE));
            categoria.setActivo(rs.getBoolean(COL_ACTIVO));
            Centro centro = new Centro();
            centro.setId(rs.getString(COL_ID_CENTRO));
            categoria.setCentro(centro);
            
            result.add(categoria);
        }

        return result;
    }
    
    public ArrayList<Categoria> selectAllCenter(String idCentro) throws SQLException{
        ArrayList<Categoria> result = new ArrayList<>();
        
        String query = "{CALL VER_TODOS_CATEGORIA_CENTRO(?,?)}";
        int indexIdCentro = 1;
        int indexActivo = 2;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexIdCentro, idCentro);
        statement.setBoolean(indexActivo, true);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt(COL_ID));
            categoria.setNombre(rs.getString(COL_NOMBRE));
            
            result.add(categoria);
        }
        
        return result;
    }

    public boolean isNameCategoryOcuped(String nombre, String idCentro) throws SQLException {
           boolean result = false;

        String query = "{CALL VER_CATEGORIA_NOMBRE(?,?)}";
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

    public boolean updateCategory(Categoria categoria) throws SQLException {
         boolean resultado;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL EDITAR_CATEGORIA_NOMBRE(?,?)}";
        int indexNombre = 1;
        int indexIdCategoria = 2;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexNombre, categoria.getNombre());
        statement.setInt(indexIdCategoria, categoria.getId());

        if (statement.executeUpdate() == 1) {//si solo modifico una fila el registro se completa
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }

        return resultado;
    }

    public boolean enableCategory(int idCategoria) throws SQLException {
        boolean resultado;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL EDITAR_CATEGORIA_HABILITAR(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, idCategoria);

        if (statement.executeUpdate() == 1) {//si solo modifico una fila el update se completa
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el update cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }

        return resultado;
    }

    public boolean isNameCategoriesOcuped(String nombre, String idCentro) throws SQLException {
      boolean result = false;

        String query = "{CALL VER_CATEGORIA_NOMBRE(?,?)}";
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
    
     public boolean registerCategories(Categoria categoria) throws SQLException {
        boolean resultado;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL INSERTAR_CATEGORIA_NUEVA(?,?)}";
        int indexNombre = 1;
        int indexIdCentro = 2;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexNombre, categoria.getNombre());
        statement.setString(indexIdCentro, categoria.getCentro().getId());

        if (statement.executeUpdate() == 1) {//si solo modifico una fila el registro se completa
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }

        return resultado;
    }

    public int countCategoriesCenter(String idCentro, String search, boolean activo) throws SQLException {
        int conteo = 0;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL VER_CATEGORIA_CENTRO_CONTEO(?,?,?)}";
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

    public ArrayList<Categoria> selectSomeCategoriesCenter(String idCentro, int pagina, int cantXpag, String search, boolean activo) throws SQLException {
      ArrayList<Categoria> categorias = new ArrayList<>();//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL VER_TODOS_CATEGORIA_CENTRO_PAGINADO(?,?,?,?,?)}";
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
            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt(COL_ID));
            categoria.setNombre(rs.getString(COL_NOMBRE));
            Centro centro = new Centro();
            centro.setId(COL_ID_CENTRO);
            categoria.setCentro(centro);
            categorias.add(categoria);
        }
        return categorias;
    }
    
      public boolean isLastCategoriesEnableArea(String idCentro, int idcate) throws SQLException {
        boolean answer = false;

        //datos de la consulta en base de datos
        String query = "{CALL VER_CATEGORIA_ES_ULTIMO(?,?)}";
        int indexIdCentro = 1;
        int indexIdArea = 2;
        String colAnswer = "RESULTADO";

        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setString(indexIdCentro, idCentro);
        statement.setInt(indexIdArea, idcate);

        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            answer = rs.getBoolean(colAnswer);
        }
        return answer;
    }

    public boolean disableCategories(int idCate) throws SQLException {
         boolean resultado;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL EDITAR_CATEGORIA_INHABILITAR(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, idCate);

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
