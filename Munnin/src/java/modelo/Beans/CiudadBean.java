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
public class CiudadBean {
    private String id_ciudad;
    private String nombre_ciudad;

    public CiudadBean() {
    }

    public CiudadBean(String id_ciudad, String nombre_ciudad) {
        this.id_ciudad = id_ciudad;
        this.nombre_ciudad = nombre_ciudad;
    }

    public String getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(String id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }
    
}
