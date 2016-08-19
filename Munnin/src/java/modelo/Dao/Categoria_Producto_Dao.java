/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Categoria_Producto_Bean;


public class Categoria_Producto_Dao {
   
   public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

   private long id_categoria_cat_prod;
    private long id_producto_cat_prod;
    
    public Categoria_Producto_Dao(Categoria_Producto_Bean Categoria_Producto) {
        super();
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();

            id_categoria_cat_prod = Categoria_Producto.getId_categoria_cat_prod();
            id_producto_cat_prod = Categoria_Producto.getId_producto_cat_prod();
            

        } catch (SQLException e) {
        }
    
}
}
