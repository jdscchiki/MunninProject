/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Juan David Segura
 */
public class EvaluacionItem implements java.io.Serializable {
    private int id;
    private int calificacion;
    private String observarcion;
    private EvaluacionLista evaluacionLista;
    private Item item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getObservarcion() {
        return observarcion;
    }

    public void setObservarcion(String observarcion) {
        this.observarcion = observarcion;
    }

    public EvaluacionLista getEvaluacionLista() {
        return evaluacionLista;
    }

    public void setEvaluacionLista(EvaluacionLista evaluacionLista) {
        this.evaluacionLista = evaluacionLista;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public EvaluacionItem() {
    }
}
