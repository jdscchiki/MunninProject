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
import model.bean.Item;
import util.database.ConexionBD;

/**
 *
 * @author Juan David Segura
 */
public class ItemDAO extends ConexionBD {

    private static final String COL_ID = "id_item";
    private static final String COL_DESCRIPTOR = "descriptor_item";
    private static final String COL_ID_AUTOR = "id_autor_item";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     */
    public ItemDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar un item en la base de datos
     *
     * @deprecated
     * @param item Datos del item insertado
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(Item item) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_ITEM(?,?)}";
        int indexDescriptor = 1;
        int indexIdAutor = 2;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexDescriptor, item.getDescriptor());
        statement.setInt(indexIdAutor, item.getAutor().getId());
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
     * Metodo para actualizar un item en la base de datos
     *
     * @deprecated
     * @param item Datos del item a ser modificado
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(Item item) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_ITEM(?,?,?)}";
        int indexId = 1;
        int indexDescriptor = 2;
        int indexIdAutor = 3;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, item.getId());
        statement.setString(indexDescriptor, item.getDescriptor());
        statement.setInt(indexIdAutor, item.getAutor().getId());
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
     * Metodo para borrar un item en la base de datos
     *
     * @deprecated
     * @param item Datos del item
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(Item item) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_ITEM(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, item.getId());

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
     * Metodo para ver los datos de un item
     *
     * @param Item Objeto de tipo Item que en el atributo id tiene el valor del
     * id a ser consultado
     * @return los valores almacenados en la tabla item de la base de datos
     * @throws SQLException
     */
    public Item select(Item Item) throws SQLException {

        String query = "{CALL VER_ITEM(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, Item.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            Item.setId(rs.getInt(COL_ID));
            Item.setDescriptor(rs.getString(COL_DESCRIPTOR));
            Funcionario funcionario = new Funcionario();
            funcionario.setId(rs.getInt(COL_ID_AUTOR));
            Item.setAutor(funcionario);
        }
        if (!encontrado) {
            Item = null;
        }

        return Item;
    }
    
    public ArrayList<Item> selectAll() throws SQLException {
        ArrayList<Item> result = new ArrayList<>();
        
        String query = "{CALL VER_TODOS_ITEM()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Item item = new Item();
            item.setId(rs.getInt(COL_ID));
            item.setDescriptor(rs.getString(COL_DESCRIPTOR));
            Funcionario funcionario = new Funcionario();
            funcionario.setId(rs.getInt(COL_ID_AUTOR));
            item.setAutor(funcionario);
            
            result.add(item);
        }

        return result;
    }
}
