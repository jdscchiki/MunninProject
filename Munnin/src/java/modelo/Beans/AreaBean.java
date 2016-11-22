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
public class AreaBean {
    
    private long id_area;
    private String nombre_area;
    private String id_centro_area;

    public AreaBean() {
    }

    public AreaBean(long id_area, String nombre_area, String id_centro_area) {
        this.id_area = id_area;
        this.nombre_area = nombre_area;
        this.id_centro_area = id_centro_area;
    }

    public long getId_area() {
        return id_area;
    }

    public void setId_area(long id_area) {
        this.id_area = id_area;
    }

    public String getNombre_area() {
        return nombre_area;
    }

    public void setNombre_area(String nombre_area) {
        this.nombre_area = nombre_area;
    }

    public String getId_centro_area() {
        return id_centro_area;
    }

    public void setId_centro_area(String id_centro_area) {
        this.id_centro_area = id_centro_area;
    }
    
}
