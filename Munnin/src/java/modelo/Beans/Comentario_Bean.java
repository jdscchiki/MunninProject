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
public class Comentario_Bean {
    private long id_comentario;
    private String valoracion_comentario;
    private int puntuacion_comentario;
    private Date fecha_comentario;
    private long id_producto_comentario;
    private long id_funcionario_comentario;

    public Comentario_Bean() {
    }

    public Comentario_Bean(long id_comentario, String valoracion_comentario, int puntuacion_comentario, Date fecha_comentario, long id_producto_comentario, long id_funcionario_comentario) {
        this.id_comentario = id_comentario;
        this.valoracion_comentario = valoracion_comentario;
        this.puntuacion_comentario = puntuacion_comentario;
        this.fecha_comentario = fecha_comentario;
        this.id_producto_comentario = id_producto_comentario;
        this.id_funcionario_comentario = id_funcionario_comentario;
    }

    public long getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(long id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getValoracion_comentario() {
        return valoracion_comentario;
    }

    public void setValoracion_comentario(String valoracion_comentario) {
        this.valoracion_comentario = valoracion_comentario;
    }

    public int getPuntuacion_comentario() {
        return puntuacion_comentario;
    }

    public void setPuntuacion_comentario(int puntuacion_comentario) {
        this.puntuacion_comentario = puntuacion_comentario;
    }

    public Date getFecha_comentario() {
        return fecha_comentario;
    }

    public void setFecha_comentario(Date fecha_comentario) {
        this.fecha_comentario = fecha_comentario;
    }

    public long getId_producto_comentario() {
        return id_producto_comentario;
    }

    public void setId_producto_comentario(long id_producto_comentario) {
        this.id_producto_comentario = id_producto_comentario;
    }

    public long getId_funcionario_comentario() {
        return id_funcionario_comentario;
    }

    public void setId_funcionario_comentario(long id_funcionario_comentario) {
        this.id_funcionario_comentario = id_funcionario_comentario;
    }
    
}
