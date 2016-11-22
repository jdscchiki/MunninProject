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
public class VersionBean {
    private long id_version;
    private long numero_version;
    private String url_version;
    private boolean notificacion_version;
    private Date fecha_version;
    private Date fecha_caducidad_version;
    private Date fecha_aprovacion_version;
    private int id_estdo_version;
    private int id_tipo_archivo_version;
    private int id_producto_version;
    private String id_centro_version;

    public VersionBean() {
    }

    public VersionBean(long id_version, long numero_version, String url_version, boolean notificacion_version, Date fecha_version, Date fecha_caducidad_version, Date fecha_aprovacion_version, int id_estdo_version, int id_tipo_archivo_version, int id_producto_version, String id_centro_version) {
        this.id_version = id_version;
        this.numero_version = numero_version;
        this.url_version = url_version;
        this.notificacion_version = notificacion_version;
        this.fecha_version = fecha_version;
        this.fecha_caducidad_version = fecha_caducidad_version;
        this.fecha_aprovacion_version = fecha_aprovacion_version;
        this.id_estdo_version = id_estdo_version;
        this.id_tipo_archivo_version = id_tipo_archivo_version;
        this.id_producto_version = id_producto_version;
        this.id_centro_version = id_centro_version;
    }

    public long getId_version() {
        return id_version;
    }

    public void setId_version(long id_version) {
        this.id_version = id_version;
    }

    public long getNumero_version() {
        return numero_version;
    }

    public void setNumero_version(long numero_version) {
        this.numero_version = numero_version;
    }

    public String getUrl_version() {
        return url_version;
    }

    public void setUrl_version(String url_version) {
        this.url_version = url_version;
    }

    public boolean isNotificacion_version() {
        return notificacion_version;
    }

    public void setNotificacion_version(boolean notificacion_version) {
        this.notificacion_version = notificacion_version;
    }

    public Date getFecha_version() {
        return fecha_version;
    }

    public void setFecha_version(Date fecha_version) {
        this.fecha_version = fecha_version;
    }

    public Date getFecha_caducidad_version() {
        return fecha_caducidad_version;
    }

    public void setFecha_caducidad_version(Date fecha_caducidad_version) {
        this.fecha_caducidad_version = fecha_caducidad_version;
    }

    public Date getFecha_aprovacion_version() {
        return fecha_aprovacion_version;
    }

    public void setFecha_aprovacion_version(Date fecha_aprovacion_version) {
        this.fecha_aprovacion_version = fecha_aprovacion_version;
    }

    public int getId_estdo_version() {
        return id_estdo_version;
    }

    public void setId_estdo_version(int id_estdo_version) {
        this.id_estdo_version = id_estdo_version;
    }

    public int getId_tipo_archivo_version() {
        return id_tipo_archivo_version;
    }

    public void setId_tipo_archivo_version(int id_tipo_archivo_version) {
        this.id_tipo_archivo_version = id_tipo_archivo_version;
    }

    public int getId_producto_version() {
        return id_producto_version;
    }

    public void setId_producto_version(int id_producto_version) {
        this.id_producto_version = id_producto_version;
    }

    public String getId_centro_version() {
        return id_centro_version;
    }

    public void setId_centro_version(String id_centro_version) {
        this.id_centro_version = id_centro_version;
    }
    
}
