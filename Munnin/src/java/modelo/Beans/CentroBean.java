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
public class CentroBean {
    private String id_centro;
    private String nombre_centro;
    private String id_regional_centro;
    private String id_ciudad_centro;

    public CentroBean() {
    }

    public CentroBean(String id_centro, String nombre_centro, String id_regional_centro, String id_ciudad_centro) {
        this.id_centro = id_centro;
        this.nombre_centro = nombre_centro;
        this.id_regional_centro = id_regional_centro;
        this.id_ciudad_centro = id_ciudad_centro;
    }

    public String getId_centro() {
        return id_centro;
    }

    public void setId_centro(String id_centro) {
        this.id_centro = id_centro;
    }

    public String getNombre_centro() {
        return nombre_centro;
    }

    public void setNombre_centro(String nombre_centro) {
        this.nombre_centro = nombre_centro;
    }

    public String getId_regional_centro() {
        return id_regional_centro;
    }

    public void setId_regional_centro(String id_regional_centro) {
        this.id_regional_centro = id_regional_centro;
    }

    public String getId_ciudad_centro() {
        return id_ciudad_centro;
    }

    public void setId_ciudad_centro(String id_ciudad_centro) {
        this.id_ciudad_centro = id_ciudad_centro;
    }
    
}
