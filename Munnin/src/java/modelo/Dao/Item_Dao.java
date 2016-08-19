
package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Item_Bean;
import util.ClassConexion;

public class Item_Dao extends ClassConexion  {
    
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_item;
    public String descriptor_item;
    public long id_autor_item;
    
    public Item_Dao(Item_Bean Item) {
        super();
        conn = this.obtenerConexion();
        id_item = Item.getId_item();
        descriptor_item = Item.getDescriptor_item();
        id_autor_item = Item.getId_autor_item();
          
        }
    
    public boolean insertar_item() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_item (?,?,?)}");
            cst.setLong(1, id_item);
            cst.setString(2, descriptor_item);
            cst.setLong(3, id_autor_item);
            } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_item() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_item (?,?,?)}");
             // Se envian parametros del procedimiento almacenado
           cst.setLong(1, id_item);
            cst.setString(2, descriptor_item);
            cst.setLong(3, id_autor_item);
            // Ejecuta el procedimiento almacenado
            } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_item() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_item (?)}");
             // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_item);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            } catch (SQLException e) {
        }
        return listo;
    }

    public Item_Bean ver_item() {
        Item_Bean it = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_item (?)}");
             // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_item);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            it = new Item_Bean(id_item, cst.getString(2), cst.getLong(3));
        } catch (SQLException e) {
        }
        return it;
    }
}
