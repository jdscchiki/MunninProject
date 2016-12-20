/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

/**
 *
 * @author Juan David Segura
 */
public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private String palabrasClave;
    private int idTipoObjetoAprendizaje;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(String palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public int getIdTipoObjetoAprendizaje() {
        return idTipoObjetoAprendizaje;
    }

    public void setIdTipoObjetoAprendizaje(int idTipoObjetoAprendizaje) {
        this.idTipoObjetoAprendizaje = idTipoObjetoAprendizaje;
    }

    public Producto() {
    }
}
