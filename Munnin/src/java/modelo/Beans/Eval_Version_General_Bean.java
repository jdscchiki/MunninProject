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
public class Eval_Version_General_Bean {
    
    private long id_eval_version_general;
    private long id_version_eval_version_general;
    private long id_lista_eval_version_general;
    private int calificacion_eval_version_general;
    private String observaciones_eval_version_general;
    private Date fecha_eval_version_general;
    private long id_evaluador_eval_version_general;

    public Eval_Version_General_Bean() {
    }

    public Eval_Version_General_Bean(long id_eval_version_general, long id_version_eval_version_general, long id_lista_eval_version_general, int calificacion_eval_version_general, String observaciones_eval_version_general, Date fecha_eval_version_general, long id_evaluador_eval_version_general) {
        this.id_eval_version_general = id_eval_version_general;
        this.id_version_eval_version_general = id_version_eval_version_general;
        this.id_lista_eval_version_general = id_lista_eval_version_general;
        this.calificacion_eval_version_general = calificacion_eval_version_general;
        this.observaciones_eval_version_general = observaciones_eval_version_general;
        this.fecha_eval_version_general = fecha_eval_version_general;
        this.id_evaluador_eval_version_general = id_evaluador_eval_version_general;
    }

    public long getId_eval_version_general() {
        return id_eval_version_general;
    }

    public void setId_eval_version_general(long id_eval_version_general) {
        this.id_eval_version_general = id_eval_version_general;
    }

    public long getId_version_eval_version_general() {
        return id_version_eval_version_general;
    }

    public void setId_version_eval_version_general(long id_version_eval_version_general) {
        this.id_version_eval_version_general = id_version_eval_version_general;
    }

    public long getId_lista_eval_version_general() {
        return id_lista_eval_version_general;
    }

    public void setId_lista_eval_version_general(long id_lista_eval_version_general) {
        this.id_lista_eval_version_general = id_lista_eval_version_general;
    }

    public int getCalificacion_eval_version_general() {
        return calificacion_eval_version_general;
    }

    public void setCalificacion_eval_version_general(int calificacion_eval_version_general) {
        this.calificacion_eval_version_general = calificacion_eval_version_general;
    }

    public String getObservaciones_eval_version_general() {
        return observaciones_eval_version_general;
    }

    public void setObservaciones_eval_version_general(String observaciones_eval_version_general) {
        this.observaciones_eval_version_general = observaciones_eval_version_general;
    }

    public Date getFecha_eval_version_general() {
        return fecha_eval_version_general;
    }

    public void setFecha_eval_version_general(Date fecha_eval_version_general) {
        this.fecha_eval_version_general = fecha_eval_version_general;
    }

    public long getId_evaluador_eval_version_general() {
        return id_evaluador_eval_version_general;
    }

    public void setId_evaluador_eval_version_general(long id_evaluador_eval_version_general) {
        this.id_evaluador_eval_version_general = id_evaluador_eval_version_general;
    }
    
}
