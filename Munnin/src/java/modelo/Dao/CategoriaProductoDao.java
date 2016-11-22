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
import modelo.Beans.CategoriaProductoBean;
import util.ClassConexion;

public class CategoriaProductoDao extends ClassConexion {

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_categoria_cat_prod;
    public long id_producto_cat_prod;

    public CategoriaProductoDao(CategoriaProductoBean Categoria_Producto) {
        super();
        conn = this.obtenerConexion();
        id_categoria_cat_prod = Categoria_Producto.getId_categoria_cat_prod();
        id_producto_cat_prod = Categoria_Producto.getId_producto_cat_prod();

    }
     public boolean insertar_categoria_producto() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_categoria_producto (?,?)}");
            cst.setLong(1, id_categoria_cat_prod);
            cst.setLong(2, id_producto_cat_prod);
            cst.execute();
            } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_categoria_producto() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_categotia_producto (?,?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_categoria_cat_prod);
            cst.setLong(2, id_producto_cat_prod);
            // Ejecuta el procedimiento almacenado
            cst.execute();
          } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_categoria_producto() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_categoria_producto (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_categoria_cat_prod);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            } catch (SQLException e) {
        }
        return listo;
    }

    public CategoriaProductoBean ver_categoria_producto() {
        CategoriaProductoBean cap = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_categoria_prodcuto (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_categoria_cat_prod);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            cap = new CategoriaProductoBean(id_categoria_cat_prod, cst.getLong(2));
            } catch (SQLException e) {
        }
        return cap;
    }
}

    
    

 
        
    
