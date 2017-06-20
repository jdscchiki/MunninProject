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
import model.bean.Funcionario;
import model.bean.Lista;
import model.bean.TipoLista;
import util.database.connectionDB;

/**
 *
 * @author Juan David Segura
 */
public class ListaDAO extends connectionDB {

    private static final String COL_ID = "id_lista";
    private static final String COL_NOMBRE = "nombre_lista";
    private static final String COL_DESCRIPCION = "descripcion_lista";
    private static final String COL_FECHA = "fecha_lista";
    private static final String COL_ID_TIPO_LISTA = "id_tipo_lista_lista";
    private static final String COL_ID_AUTOR = "id_autor_lista";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor connectionDB
     * @throws SQLException Error en el constructor connectionDB
     */
    public ListaDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar una lista en la base de datos
     *
     * @deprecated
     * @param lista Datos de la lista insertada
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(Lista lista) throws SQLException {
        boolean result;

        String query = "{CALL INSERTAR_LISTA(?,?,?,?,?,?)}";
        int indexNombre = 1;
        int indexDescripcion = 2;
        int indexFecha = 3;
        int indexTipo = 4;
        int indexIdAutor = 5;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexNombre, lista.getNombre());
        statement.setString(indexDescripcion, lista.getDescripcion());
        statement.setDate(indexFecha, (java.sql.Date) lista.getFecha());
        statement.setInt(indexTipo, lista.getTipoLista().getId());
        statement.setInt(indexIdAutor, lista.getIdAutor());
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
     * Metodo para actualizar una lista en la base de datos
     *
     * @deprecated
     * @param lista Datos de la lista a ser modificada
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(Lista lista) throws SQLException {
        boolean result;

        String query = "{CALL EDITAR_LISTA(?,?,?,?,?,?)}";
        int indexId = 1;
        int indexNombre = 2;
        int indexDescripcion = 3;
        int indexFecha = 4;
        int indexTipo = 5;
        int indexIdAutor = 6;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, lista.getId());
        statement.setString(indexNombre, lista.getNombre());
        statement.setString(indexDescripcion, lista.getDescripcion());
        statement.setDate(indexFecha, (java.sql.Date) lista.getFecha());
        statement.setInt(indexTipo, lista.getTipoLista().getId());
        statement.setInt(indexIdAutor, lista.getIdAutor());
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
     * Metodo para borrar una lista en la base de datos
     *
     * @deprecated
     * @param lista Datos de la lista
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(Lista lista) throws SQLException {
        boolean result;

        String query = "{CALL ELIMINAR_LISTA(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, lista.getId());

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
     * Metodo para ver los datos de una lista
     *
     * @param lista Objeto de tipo Lista que en el atributo id tiene el valor
     * del id a ser consultado
     * @return los valores almacenados en la tabla lista de la base de datos
     * @throws SQLException
     */
    public Lista select(Lista lista) throws SQLException {

        String query = "{CALL VER_LISTA(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, lista.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            lista.setId(rs.getInt(COL_ID));
            lista.setNombre(rs.getString(COL_NOMBRE));
            lista.setDescripcion(rs.getString(COL_DESCRIPCION));
            lista.setFecha(rs.getDate(COL_FECHA));
            TipoLista tipoLista = new TipoLista();
            tipoLista.setId(rs.getInt(COL_ID_TIPO_LISTA));
            lista.setTipoLista(tipoLista);
            lista.setIdAutor(rs.getInt(COL_ID_AUTOR));
        }
        if (!encontrado) {
            lista = null;
        }

        return lista;
    }
    
    public ArrayList<Lista> selectAll() throws SQLException {
        ArrayList<Lista> result = new ArrayList<>();
        
        String query = "{CALL VER_TODOS_LISTA()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Lista lista = new Lista();
            lista.setId(rs.getInt(COL_ID));
            lista.setNombre(rs.getString(COL_NOMBRE));
            lista.setDescripcion(rs.getString(COL_DESCRIPCION));
            lista.setFecha(rs.getDate(COL_FECHA));
            TipoLista tipoLista = new TipoLista();
            tipoLista.setId(rs.getInt(COL_ID_TIPO_LISTA));
            lista.setTipoLista(tipoLista);
            lista.setIdAutor(rs.getInt(COL_ID_AUTOR));
            
            result.add(lista);
        }

        return result;
    }
    
    public ArrayList<Lista> selectListas(Lista lista) throws SQLException {
        ArrayList<Lista> result = new ArrayList<>();
        
        String query = "{CALL VER_LISTAS_FUNCIONARIO(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, lista.getId());
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            lista = new Lista();
            lista.setId(rs.getInt(COL_ID));
            lista.setNombre(rs.getString(COL_NOMBRE));
            lista.setDescripcion(rs.getString(COL_DESCRIPCION));
            lista.setFecha(rs.getDate(COL_FECHA));
            result.add(lista);
        }

        return result;
    }
    
    public int countCheckListFunctionay(int idAutor, String search, boolean active, int idListType) throws SQLException {
        int conteo = 0;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL VER_LISTAS_FUNCIONARIO_CONTEO(?,?,?,?)}";
        int indexIdAutor = 1;
        int indexSearch = 2;
        int indexActive = 3;
        int indexListType = 4;

        String resConteo = "conteo";//nombre de la columna del select

        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexIdAutor, idAutor);
        statement.setString(indexSearch, search);
        statement.setBoolean(indexActive, active);
        statement.setInt(indexListType, idListType);

        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        while (rs.next()) {
            //asigna los valores resultantes de la consulta
            conteo = rs.getInt(resConteo);
        }
        return conteo;
    }
    
    public ArrayList<Lista> selectSomeCheckListFunctionary(int idAutor, int pagina, int cantXpag, String search, int idTypeList, boolean active) throws SQLException {
        ArrayList<Lista> listas = new ArrayList<>();//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL VER_LISTAS_FUNCIONARIOS(?,?,?,?,?,?)}";
        int indexAutor = 1;
        int indexPagina = 2;
        int indexCantXPag = 3;
        int indexSearch = 4;
        int indexActive = 5;
        int indexIdTypeList = 6;

        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexAutor, idAutor);
        statement.setInt(indexPagina, pagina);
        statement.setInt(indexCantXPag, cantXpag);
        statement.setString(indexSearch, search);
        statement.setBoolean(indexActive, active);
        statement.setInt(indexIdTypeList, idTypeList);

        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        while (rs.next()) {
            //asigna los valores resultantes de la consulta
            Lista lista = new Lista();
            lista.setId(rs.getInt(COL_ID));
            lista.setNombre(rs.getString(COL_NOMBRE));
            lista.setDescripcion(rs.getString(COL_DESCRIPCION));
            lista.setFecha(rs.getDate(COL_FECHA));
            listas.add(lista);
        }
        return listas;
    }
    
    public boolean newList(Lista lista) throws SQLException {
        boolean result;

        String query = "{CALL INSERTAR_LISTA_NUEVA(?,?,?,?)}";
        int indexNombre = 1;
        int indexDescripcion = 2;
        int indexIdAutor = 3;
        int indexTipo = 4;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexNombre, lista.getNombre());
        statement.setString(indexDescripcion, lista.getDescripcion());
        statement.setInt(indexTipo, lista.getTipoLista().getId());
        statement.setInt(indexIdAutor, lista.getIdAutor());
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            result = true;
        } else {
            this.getConexion().rollback();
            result = false;
        }
        return result;
    }
    
    public int create(Lista lista) throws SQLException {
        int result = 0;
        System.out.println("bandera");
        String query = "INSERT INTO lista ("
                + COL_NOMBRE + ","
                + COL_DESCRIPCION + ","
                + COL_FECHA + ","
                + COL_ID_AUTOR + ","
                + "activo_lista ,"
                + COL_ID_TIPO_LISTA + ") "
                + "VALUES(?,?,CURRENT_DATE,?,1,?)";
        int indexNombre = 1;
        int indexDescripcion = 2;        
        int indexIdAutor = 3;
        int indexTipo = 4;

        PreparedStatement statement = this.getConexion().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setString(indexNombre, lista.getNombre());
        statement.setString(indexDescripcion, lista.getDescripcion());
        statement.setInt(indexIdAutor, lista.getIdAutor());
        statement.setInt(indexTipo, lista.getTipoLista().getId());       

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
    
    public int countListsFunctionary(Funcionario funcionario, int idTipoLista, boolean activo) throws SQLException{
        int conteo = 0;//esta es la futura respuesta

        //datos de la consulta en base de datos
        String query = "{CALL VER_TODAS_LISTA_FUNCIONARIO_CONTEO(?,?)}";
        int indexIdFuncionario = 1;
        int indexIdTipoLista = 2;
        int indexActivo = 3;

        String resConteo = "conteo";//nombre de la columna del select

        //prepara la consulta
        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexIdFuncionario, funcionario.getId());
        statement.setInt(indexIdTipoLista, idTipoLista);
        statement.setBoolean(indexActivo, activo);

        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        while (rs.next()) {
            //asigna los valores resultantes de la consulta
            conteo = rs.getInt(resConteo);
        }
        return conteo;
    }
    
    public boolean changeActive(int idList, boolean active) throws SQLException{
        boolean result;

        String query = "{CALL EDITAR_LISTA_ACTIVO(?,?)}";
        int indexId = 1;
        int indexActive = 2;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, idList);
        statement.setBoolean(indexActive, active);

        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            result = true;
        } else {
            this.getConexion().rollback();
            result = false;
        }
        return result;
    }
}
