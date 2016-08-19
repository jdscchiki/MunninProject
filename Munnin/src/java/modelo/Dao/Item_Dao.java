
package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Item_Bean;

public class Item_Dao {
    
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
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();

            id_item = Item.getId_item();
            descriptor_item = Item.getDescriptor_item();
            id_autor_item = Item.getId_autor_item();
            
            

        } catch (SQLException e) {
        }
    
    } 
    
}
