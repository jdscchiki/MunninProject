/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Beans;

/**
 *
 * @author Juan David
 */
public class CategoriaProductoBean {
    private long id_categoria_cat_prod;
    private long id_producto_cat_prod;

    public CategoriaProductoBean() {
    }
    
    public CategoriaProductoBean(long id_categoria_cat_prod, long id_producto_cat_prod) {
        this.id_categoria_cat_prod = id_categoria_cat_prod;
        this.id_producto_cat_prod = id_producto_cat_prod;
    }

    public long getId_categoria_cat_prod() {
        return id_categoria_cat_prod;
    }

    public void setId_categoria_cat_prod(long id_categoria_cat_prod) {
        this.id_categoria_cat_prod = id_categoria_cat_prod;
    }

    public long getId_producto_cat_prod() {
        return id_producto_cat_prod;
    }

    public void setId_producto_cat_prod(long id_producto_cat_prod) {
        this.id_producto_cat_prod = id_producto_cat_prod;
    }
    
}
