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
public class Version implements java.io.Serializable{
    private int id;
    private int numero;
    private String url;
    private Date fecha;
    private Date fechaCaducidad;
    private Date fechaAprovacion;
    private Estado estado;
    private TipoArchivo tipoArchivo;
    private Producto producto;
    private Centro centro;
    private ArrayList<Notificacion> notificaciones;
    private ArrayList<EvaluacionLista> evaluacionListas;
    private ArrayList<Funcionario> funcionarios;

    public ArrayList<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(ArrayList<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public ArrayList<EvaluacionLista> getEvaluacionListas() {
        return evaluacionListas;
    }

    public void setEvaluacionListas(ArrayList<EvaluacionLista> evaluacionListas) {
        this.evaluacionListas = evaluacionListas;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public TipoArchivo getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(TipoArchivo tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Centro getCentro() {
        return centro;
    }

    public void setCentro(Centro centro) {
        this.centro = centro;
    }

    public Version() {
    }
}
