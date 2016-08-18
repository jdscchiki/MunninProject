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
public class Eval_Detalle_Lista_Bean {
    private long id_eval_detalle_lista;
    private int calificacion_eval_detalle_lista;
    private String observarcion_eval_detalle_lista;
    private long id_eval_version_general_eval_detalle_lista;
    private long id_detalle_lista_eval_detalle_lista;

    public Eval_Detalle_Lista_Bean() {
    }

    public Eval_Detalle_Lista_Bean(long id_eval_detalle_lista, int calificacion_eval_detalle_lista, String observarcion_eval_detalle_lista, long id_eval_version_general_eval_detalle_lista, long id_detalle_lista_eval_detalle_lista) {
        this.id_eval_detalle_lista = id_eval_detalle_lista;
        this.calificacion_eval_detalle_lista = calificacion_eval_detalle_lista;
        this.observarcion_eval_detalle_lista = observarcion_eval_detalle_lista;
        this.id_eval_version_general_eval_detalle_lista = id_eval_version_general_eval_detalle_lista;
        this.id_detalle_lista_eval_detalle_lista = id_detalle_lista_eval_detalle_lista;
    }

    public long getId_eval_detalle_lista() {
        return id_eval_detalle_lista;
    }

    public void setId_eval_detalle_lista(long id_eval_detalle_lista) {
        this.id_eval_detalle_lista = id_eval_detalle_lista;
    }

    public int getCalificacion_eval_detalle_lista() {
        return calificacion_eval_detalle_lista;
    }

    public void setCalificacion_eval_detalle_lista(int calificacion_eval_detalle_lista) {
        this.calificacion_eval_detalle_lista = calificacion_eval_detalle_lista;
    }

    public String getObservarcion_eval_detalle_lista() {
        return observarcion_eval_detalle_lista;
    }

    public void setObservarcion_eval_detalle_lista(String observarcion_eval_detalle_lista) {
        this.observarcion_eval_detalle_lista = observarcion_eval_detalle_lista;
    }

    public long getId_eval_version_general_eval_detalle_lista() {
        return id_eval_version_general_eval_detalle_lista;
    }

    public void setId_eval_version_general_eval_detalle_lista(long id_eval_version_general_eval_detalle_lista) {
        this.id_eval_version_general_eval_detalle_lista = id_eval_version_general_eval_detalle_lista;
    }

    public long getId_detalle_lista_eval_detalle_lista() {
        return id_detalle_lista_eval_detalle_lista;
    }

    public void setId_detalle_lista_eval_detalle_lista(long id_detalle_lista_eval_detalle_lista) {
        this.id_detalle_lista_eval_detalle_lista = id_detalle_lista_eval_detalle_lista;
    }
    
}
