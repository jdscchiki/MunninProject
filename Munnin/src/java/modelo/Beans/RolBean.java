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
public class RolBean {
    private long id_rol;
    private String nombre_rol;
    private String descripcion_rol;

    public RolBean() {
    }

    public RolBean(long id_rol, String nombre_rol, String descripcion_rol) {
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
        this.descripcion_rol = descripcion_rol;
    }

    public long getId_rol() {
        return id_rol;
    }

    public void setId_rol(long id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public String getDescripcion_rol() {
        return descripcion_rol;
    }

    public void setDescripcion_rol(String descripcion_rol) {
        this.descripcion_rol = descripcion_rol;
    }
    
}
