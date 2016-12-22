/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import java.util.ArrayList;

/**
 *
 * @author Juan David
 */
public class Funcionario implements java.io.Serializable {

    private int id;
    private boolean activo;
    private String documento;
    private String correo;
    private String contrasena;
    private String nombre;
    private String apellido;
    private String telefono;
    private String idCentro;
    private TipoDocumento tipoDocumento;
    private ArrayList<Rol> roles;
    private ArrayList<Notificacion> notificaciones;
    private ArrayList<Version> versiones;
    private ArrayList<EvaluacionLista> evaluacionListas;
    private ArrayList<Lista> listas;
    private ArrayList<Item> items;
    private ArrayList<Comentario> comentarios;
    private ArrayList<Visita> visitas;

    public ArrayList<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(ArrayList<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public ArrayList<Version> getVersiones() {
        return versiones;
    }

    public void setVersiones(ArrayList<Version> versiones) {
        this.versiones = versiones;
    }

    public ArrayList<EvaluacionLista> getEvaluacionListas() {
        return evaluacionListas;
    }

    public void setEvaluacionListas(ArrayList<EvaluacionLista> evaluacionListas) {
        this.evaluacionListas = evaluacionListas;
    }

    public ArrayList<Lista> getListas() {
        return listas;
    }

    public void setListas(ArrayList<Lista> listas) {
        this.listas = listas;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public ArrayList<Visita> getVisitas() {
        return visitas;
    }

    public void setVisitas(ArrayList<Visita> visitas) {
        this.visitas = visitas;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(String idCentro) {
        this.idCentro = idCentro;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public ArrayList<Rol> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Rol> roles) {
        this.roles = roles;
    }

    public boolean isAdministrador() {
        for (Rol rol : roles) {
            if (rol.getId() == 5) {
                return true;
            }
        }
        return false;
    }

    public boolean isCoordinador() {
        for (Rol rol : roles) {
            if (rol.getId() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean isTecnico() {
        for (Rol rol : roles) {
            if (rol.getId() == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean isPedagogico() {
        for (Rol rol : roles) {
            if (rol.getId() == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean isInstructor() {
        for (Rol rol : roles) {
            if (rol.getId() == 4) {
                return true;
            }
        }
        return false;
    }

    public Funcionario() {

    }

}
