/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Beans;

import java.util.Date;

/**
 *
 * @author Juan David
 */
public class ListaChequeoBean {
    private long id_lista;
    private String nombre_lista;
    private String descripcion_lista;
    private Date fecha_lista;
    private String tipo_lista;
    private long id_autor_lista;

    public ListaChequeoBean() {
    }

    public ListaChequeoBean(long id_lista, String nombre_lista, String descripcion_lista, Date fecha_lista, String tipo_lista, long id_autor_lista) {
        this.id_lista = id_lista;
        this.nombre_lista = nombre_lista;
        this.descripcion_lista = descripcion_lista;
        this.fecha_lista = fecha_lista;
        this.tipo_lista = tipo_lista;
        this.id_autor_lista = id_autor_lista;
    }

    public long getId_lista() {
        return id_lista;
    }

    public void setId_lista(long id_lista) {
        this.id_lista = id_lista;
    }

    public String getNombre_lista() {
        return nombre_lista;
    }

    public void setNombre_lista(String nombre_lista) {
        this.nombre_lista = nombre_lista;
    }

    public String getDescripcion_lista() {
        return descripcion_lista;
    }

    public void setDescripcion_lista(String descripcion_lista) {
        this.descripcion_lista = descripcion_lista;
    }

    public Date getFecha_lista() {
        return fecha_lista;
    }

    public void setFecha_lista(Date fecha_lista) {
        this.fecha_lista = fecha_lista;
    }

    public String getTipo_lista() {
        return tipo_lista;
    }

    public void setTipo_lista(String tipo_lista) {
        this.tipo_lista = tipo_lista;
    }

    public long getId_autor_lista() {
        return id_autor_lista;
    }

    public void setId_autor_lista(long id_autor_lista) {
        this.id_autor_lista = id_autor_lista;
    }
    
}
