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
public class EvaluacionDetalleLista {
    private int id;
    private int calificacion;
    private String observarcion;
    private int idEvaluacion;
    private int idDetalleLista;

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

    public int getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public int getIdDetalleLista() {
        return idDetalleLista;
    }

    public void setIdDetalleLista(int idDetalleLista) {
        this.idDetalleLista = idDetalleLista;
    }

    public EvaluacionDetalleLista() {
    }
}
