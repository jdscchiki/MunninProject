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
public class ProductoBean {
    private long id_producto;
    private String nombre_producto;
    private String descripcion_producto;
    private String palabras_clave_producto;
    private long id_tipo_objeto_aprendizaje_producto;

    public ProductoBean() {
    }

    public ProductoBean(long id_producto, String nombre_producto, String descripcion_producto, String palabras_clave_producto, long id_tipo_objeto_aprendizaje_producto) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.descripcion_producto = descripcion_producto;
        this.palabras_clave_producto = palabras_clave_producto;
        this.id_tipo_objeto_aprendizaje_producto = id_tipo_objeto_aprendizaje_producto;
    }

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public String getPalabras_clave_producto() {
        return palabras_clave_producto;
    }

    public void setPalabras_clave_producto(String palabras_clave_producto) {
        this.palabras_clave_producto = palabras_clave_producto;
    }

    public long getId_tipo_objeto_aprendizaje_producto() {
        return id_tipo_objeto_aprendizaje_producto;
    }

    public void setId_tipo_objeto_aprendizaje_producto(long id_tipo_objeto_aprendizaje_producto) {
        this.id_tipo_objeto_aprendizaje_producto = id_tipo_objeto_aprendizaje_producto;
    }
    
}
