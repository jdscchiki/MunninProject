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
public class Programa_Producto_Bean {
    private long id_producto_prog_prod;
    private long id_programa_prog_prod;

    public Programa_Producto_Bean() {
    }

    public Programa_Producto_Bean(long id_producto_prog_prod, long id_programa_prog_prod) {
        this.id_producto_prog_prod = id_producto_prog_prod;
        this.id_programa_prog_prod = id_programa_prog_prod;
    }

    public long getId_producto_prog_prod() {
        return id_producto_prog_prod;
    }

    public void setId_producto_prog_prod(long id_producto_prog_prod) {
        this.id_producto_prog_prod = id_producto_prog_prod;
    }

    public long getId_programa_prog_prod() {
        return id_programa_prog_prod;
    }

    public void setId_programa_prog_prod(long id_programa_prog_prod) {
        this.id_programa_prog_prod = id_programa_prog_prod;
    }
    
}
