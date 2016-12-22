/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import java.util.ArrayList;

/**
 *
 * @author Juan David Segura
 */
public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private String palabrasClave;
    private TipoObjetoAprendizaje tipoObjetoAprendizaje;
    private ArrayList<Categoria> categorias;
    private ArrayList<Programa> programas;
    private ArrayList<Version> versiones;
    private ArrayList<Comentario> comentarios;
    private ArrayList<Visita> visitas;

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public ArrayList<Programa> getProgramas() {
        return programas;
    }

    public void setProgramas(ArrayList<Programa> programas) {
        this.programas = programas;
    }

    public ArrayList<Version> getVersiones() {
        return versiones;
    }

    public void setVersiones(ArrayList<Version> versiones) {
        this.versiones = versiones;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public ArrayList<Visita> getVisitas() {
        return visitas;
    }

    public void setVisitas(ArrayList<Visita> visitas) {
        this.visitas = visitas;
    }

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

    public TipoObjetoAprendizaje getTipoObjetoAprendizaje() {
        return tipoObjetoAprendizaje;
    }

    public void setTipoObjetoAprendizaje(TipoObjetoAprendizaje tipoObjetoAprendizaje) {
        this.tipoObjetoAprendizaje = tipoObjetoAprendizaje;
    }

    public Producto() {
    }
}
