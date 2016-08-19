/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Autor_Bean;
import modelo.Beans.Categoria_Producto_Bean;
import util.ClassConexion;

public class Categoria_Producto_Dao extends ClassConexion {

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_categoria_cat_prod;
    public long id_producto_cat_prod;

    public Categoria_Producto_Dao(Categoria_Producto_Bean Categoria_Producto) {
        super();
        conn = this.obtenerConexion();
        id_categoria_cat_prod = Categoria_Producto.getId_categoria_cat_prod();
        id_producto_cat_prod = Categoria_Producto.getId_producto_cat_prod();

    }
     public boolean insertar_categoria_producto() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_categoria_producto (?,?,?)}");
            } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_categoria_producto() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_categotia_producto (?,?,?)}");
          } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_categoria_producto() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_categoria_producto (?)}");
            } catch (SQLException e) {
        }
        return listo;
    }

    public Categoria_Producto_Bean ver_categoria_producto() {
        Categoria_Producto_Bean ab = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_categoria_prodcuto (?)}");
            } catch (SQLException e) {
        }
        return ab;
    }
}

    
    

 
        
    
