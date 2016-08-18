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
public class Visita_Bean {
    
    private Date fecha_visita;
    private long id_producto_visita_visita;
    private long id_funcionario_visita;

    public Visita_Bean() {
    }
    
    public Visita_Bean(Date fecha_visita, long id_producto_visita_visita, long id_funcionario_visita) {
        this.fecha_visita = fecha_visita;
        this.id_producto_visita_visita = id_producto_visita_visita;
        this.id_funcionario_visita = id_funcionario_visita;
    }

    public Date getFecha_visita() {
        return fecha_visita;
    }

    public void setFecha_visita(Date fecha_visita) {
        this.fecha_visita = fecha_visita;
    }

    public long getId_producto_visita_visita() {
        return id_producto_visita_visita;
    }

    public void setId_producto_visita_visita(long id_producto_visita_visita) {
        this.id_producto_visita_visita = id_producto_visita_visita;
    }

    public long getId_funcionario_visita() {
        return id_funcionario_visita;
    }

    public void setId_funcionario_visita(long id_funcionario_visita) {
        this.id_funcionario_visita = id_funcionario_visita;
    }
    
    
}
