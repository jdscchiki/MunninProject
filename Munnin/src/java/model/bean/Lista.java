/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Juan David Segura
 */
public class Lista {
    private int id;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private TipoLista tipoLista;
    private int idAutor;
    private ArrayList<Item> items;
    private ArrayList<EvaluacionLista> evaluacionListas;

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<EvaluacionLista> getEvaluacionListas() {
        return evaluacionListas;
    }

    public void setEvaluacionListas(ArrayList<EvaluacionLista> evaluacionListas) {
        this.evaluacionListas = evaluacionListas;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TipoLista getTipoLista() {
        return tipoLista;
    }

    public void setTipoLista(TipoLista tipoLista) {
        this.tipoLista = tipoLista;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public Lista() {
    }
}
