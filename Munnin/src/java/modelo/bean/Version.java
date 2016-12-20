/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import java.util.Date;

/**
 *
 * @author Juan David Segura
 */
public class Version {
    private int id;
    private int numero;
    private String url;
    private boolean notificacion;
    private Date fecha;
    private Date fechaCaducidad;
    private Date fechaAprovacion;
    private int idEstdo;
    private int idTipoArchivo;
    private int idProducto;
    private String idCentro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isNotificacion() {
        return notificacion;
    }

    public void setNotificacion(boolean notificacion) {
        this.notificacion = notificacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Date getFechaAprovacion() {
        return fechaAprovacion;
    }

    public void setFechaAprovacion(Date fechaAprovacion) {
        this.fechaAprovacion = fechaAprovacion;
    }

    public int getIdEstdo() {
        return idEstdo;
    }

    public void setIdEstdo(int idEstdo) {
        this.idEstdo = idEstdo;
    }

    public int getIdTipoArchivo() {
        return idTipoArchivo;
    }

    public void setIdTipoArchivo(int idTipoArchivo) {
        this.idTipoArchivo = idTipoArchivo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(String idCentro) {
        this.idCentro = idCentro;
    }

    public Version() {
    }
}
