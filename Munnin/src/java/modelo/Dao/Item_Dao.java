
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
    private static final String PROCEDURE_DELETE_ITEM = "{CALL ElIMINAR_ITEM(?,?,?)}";

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
     * @param Id_item Id del Item
     * @return Retorna Null si el Item no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Item.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Item_Bean InsertarItem(Long Id_item) throws SQLException {
        Item_Bean item = new Item_Bean();//el objeto en donde se guardan los resultados de la consulta
        item.setId_item(Id_item);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERTAR_ITEM(?,?,?)}");
        statement.setLong(PROCEDURE_INSERT_ITEM, Id_item);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_DESCRIPTOR_ITEM);
        statement.setString(3, COL_ID_AUTOR_ITEM);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta

       
        return item;
    }

    /**
     * @param Id_item Id del Item
     * @return Retorna Null si el Item no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Item.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Item_Bean UpdateItem(Long Id_item) throws SQLException {
        Item_Bean item = new Item_Bean();//el objeto en donde se guardan los resultados de la consulta
        item.setId_item(Id_item);
        CallableStatement statement = this.getConexion().prepareCall("{CALL EDITAR_ITEM(?,?,?)}");
        statement.setLong(PROCEDURE_UPDATE_ITEM, Id_item);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_DESCRIPTOR_ITEM);
        statement.setString(3, COL_ID_AUTOR_ITEM);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
     
        return item;
    }

    /**
     * @param Id_item Id del Item
     * @return Retorna Null si el Item no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Item.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public  Item_Bean DeleteItem(long Id_item) throws SQLException {
        Item_Bean item = new Item_Bean();//el objeto en donde se guardan los resultados de la consulta
        item.setId_item(Id_item);
        CallableStatement statement = this.getConexion().prepareCall("{CALL ELIMINAR_ITEM(?,?,?)}");
        statement.setLong(PROCEDURE_DELETE_ITEM, Id_item);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_DESCRIPTOR_ITEM);
        statement.setString(3, COL_ID_AUTOR_ITEM);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return item;
    }

}
