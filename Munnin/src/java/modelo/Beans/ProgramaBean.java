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
public class ProgramaBean {
    private long id_programa;
    private String nombre_programa;
    private long id_area_programa;

    public ProgramaBean() {
    }
    
    public ProgramaBean(long id_programa, String nombre_programa, long id_area_programa) {
        this.id_programa = id_programa;
        this.nombre_programa = nombre_programa;
        this.id_area_programa = id_area_programa;
    }

    public long getId_programa() {
        return id_programa;
    }

    public void setId_programa(long id_programa) {
        this.id_programa = id_programa;
    }

    public String getNombre_programa() {
        return nombre_programa;
    }

    public void setNombre_programa(String nombre_programa) {
        this.nombre_programa = nombre_programa;
    }

    public long getId_area_programa() {
        return id_area_programa;
    }

    public void setId_area_programa(long id_area_programa) {
        this.id_area_programa = id_area_programa;
    }
    
}
