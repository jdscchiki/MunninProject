
package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.Item_Bean;
import util.ClassConexion;
import util.ConexionBD;

public class Item_Dao extends ConexionBD {

    private static final String COL_ID_ITEM = "id_item";
    private static final String COL_DESCRIPTOR_ITEM = "descriptor_item";
    private static final String COL_ID_AUTOR_ITEM = "id_autor_item";

    private static final String PROCEDURE_INSERT_ITEM = "{CALL INSERTAR_ITEM(?,?,?)}";
    private static final String PROCEDURE_UPDATE_ITEM = "{CALL EDITAR_ITEM(?,?,?)}";
    private static final String PROCEDURE_DELETE_ITEM = "{CALL ElIMINAR_ITEM(?)}";

    private static final int PROCEDURE_INSERTAR_ITEM_ID_ITEM_INDEX = 1;
    private static final int PROCEDURE_INSERTAR_ITEM_DESCRIPTOR_ITEM_INDEX = 2;    
    private static final int PROCEDURE_INSERTAR_ITEM_ID_AUTOR_ITEM_INDEX = 3;
    
    private static final int PROCEDURE_UPDATE_ITEM_ID_ITEM_INDEX = 1;
    private static final int PROCEDURE_UPDATE_ITEM_DESCRIPTOR_ITEM_INDEX = 2;
    private static final int PROCEDURE_UPDATE_ITEM_ID_AUTOR_ITEM_INDEX = 3;
    
    private static final int PROCEDURE_ELIMINAR_ITEM_ID_ITEM_INDEX = 1;

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Item_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param item
     * @return Retorna Null si el Item no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Item.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean InsertarItem(Item_Bean item) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_INSERT_ITEM);
        statement.setLong(PROCEDURE_INSERTAR_ITEM_ID_ITEM_INDEX, item.getId_autor_item());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_INSERTAR_ITEM_DESCRIPTOR_ITEM_INDEX, item.getDescriptor_item());
        statement.setLong(PROCEDURE_INSERTAR_ITEM_ID_AUTOR_ITEM_INDEX, item.getId_autor_item());        
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * @param item
     * @return Retorna Null si el Item no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Item.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean UpdateItem(Item_Bean item) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_UPDATE_ITEM);
        statement.setLong(PROCEDURE_UPDATE_ITEM_ID_ITEM_INDEX, item.getId_item());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_UPDATE_ITEM_DESCRIPTOR_ITEM_INDEX, item.getDescriptor_item());
        statement.setLong(PROCEDURE_UPDATE_ITEM_ID_AUTOR_ITEM_INDEX, item.getId_autor_item());
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * @param item
     * @return Retorna Null si el Item no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Item.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean DeleteItem(Item_Bean item) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_DELETE_ITEM);
        statement.setLong(PROCEDURE_ELIMINAR_ITEM_ID_ITEM_INDEX, item.getId_item());//asigna los valores necesarios para ejecutar el QUERY
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

}
