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
public class TipoObjetoAprendizajeBean {
    private long id_tipo_objeto_aprendizaje;
    private String nombre_tipo_objeto_aprendizaje;

    public TipoObjetoAprendizajeBean() {
    }

    public TipoObjetoAprendizajeBean(long id_tipo_objeto_aprendizaje, String nombre_tipo_objeto_aprendizaje) {
        this.id_tipo_objeto_aprendizaje = id_tipo_objeto_aprendizaje;
        this.nombre_tipo_objeto_aprendizaje = nombre_tipo_objeto_aprendizaje;
    }

    public long getId_tipo_objeto_aprendizaje() {
        return id_tipo_objeto_aprendizaje;
    }

    public void setId_tipo_objeto_aprendizaje(long id_tipo_objeto_aprendizaje) {
        this.id_tipo_objeto_aprendizaje = id_tipo_objeto_aprendizaje;
    }

    public String getNombre_tipo_objeto_aprendizaje() {
        return nombre_tipo_objeto_aprendizaje;
    }

    public void setNombre_tipo_objeto_aprendizaje(String nombre_tipo_objeto_aprendizaje) {
        this.nombre_tipo_objeto_aprendizaje = nombre_tipo_objeto_aprendizaje;
    }
    
}
