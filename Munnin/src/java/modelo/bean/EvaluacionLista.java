/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Juan David Segura
 */
public class EvaluacionLista {
    private int id;
    private int calificacion;
    private String observaciones;
    private Date fecha;
    private Version version;
    private Lista lista;
    private Funcionario evaluador;
    private ArrayList<EvaluacionItem> evaluacionItems;

    public ArrayList<EvaluacionItem> getEvaluacionItems() {
        return evaluacionItems;
    }

    public void setEvaluacionItems(ArrayList<EvaluacionItem> evaluacionItems) {
        this.evaluacionItems = evaluacionItems;
    }

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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public Funcionario getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(Funcionario evaluador) {
        this.evaluador = evaluador;
    }

    public EvaluacionLista() {
    }
}
