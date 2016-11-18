
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

/**
 * Esta clase realiza y procesa las consultas a bases de datos, de la tabla
 * Item.
 *
 * @version 1.3
 * @author Monica <JBadCode>
 */

public class Item_Dao extends ConexionBD {

    private static final String COL_ID_ITEM = "id_item";
    private static final String COL_DESCRIPTOR_ITEM = "descriptor_item";
    private static final String COL_ID_AUTOR_ITEM = "id_autor_item";

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
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean InsertarItem(Item_Bean item) throws SQLException {
        boolean resultado;// esta sera la futura repuesta
        
        //datos en la consuta en base de datos
        String query = "{CALL INSERTAR_ITEM(?,?,?)}";
        int indexIdItem = 1;
        int indexDescriptorItem = 2;
        int indexIdAutorItem= 3;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdItem, item.getId_item());
        statement.setString(indexDescriptorItem, item.getDescriptor_item());
        statement.setLong(indexIdAutorItem, item.getId_autor_item());        
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
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean UpdateItem(Item_Bean item) throws SQLException {
        boolean resultado;// esta sera la futura repuesta
        
        //datos en la consuta en base de datos
        String query = "{CALL EDITAR_ITEM(?,?,?)}";
        int indexIdItem = 1;
        int indexDescriptorItem = 2;
        int indexIdAutorItem= 3;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdItem, item.getId_item());
        statement.setString(indexDescriptorItem, item.getDescriptor_item());
        statement.setLong(indexIdAutorItem, item.getId_autor_item());        
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
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean DeleteItem(Item_Bean item) throws SQLException {
         boolean resultado;// esta sera la futura repuesta
        
        //datos en la consuta en base de datos
        String query = "{CALL ELIMINAR_ITEM(?,?,?)}";
        int indexIdItem = 1;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdItem, item.getId_item());       
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
