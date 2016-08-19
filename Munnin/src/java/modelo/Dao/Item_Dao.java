
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
            } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_item() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_item (?,?,?)}");
            } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_item() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_item (?)}");
            } catch (SQLException e) {
        }
        return listo;
    }

    public Item_Bean ver_item() {
        Item_Bean ab = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_item (?)}");
        } catch (SQLException e) {
        }
        return ab;
    }
}
