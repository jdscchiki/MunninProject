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
public class Categoria_Bean {
    
    private long id_categoria;
    private String nombre_categoria;
    private String id_centro_categoria;

    public Categoria_Bean() {
    }

    public Categoria_Bean(long id_categoria, String nombre_categoria, String id_centro_categoria) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
        this.id_centro_categoria = id_centro_categoria;
    }

    public long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getId_centro_categoria() {
        return id_centro_categoria;
    }

    public void setId_centro_categoria(String id_centro_categoria) {
        this.id_centro_categoria = id_centro_categoria;
    }
    
}
