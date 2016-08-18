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
public class Regional_Bean {
    private long id_regional;
    private String nombre_regional;

    public Regional_Bean() {
    }

    public Regional_Bean(long id_regional, String nombre_regional) {
        this.id_regional = id_regional;
        this.nombre_regional = nombre_regional;
    }

    public long getId_regional() {
        return id_regional;
    }

    public void setId_regional(long id_regional) {
        this.id_regional = id_regional;
    }

    public String getNombre_regional() {
        return nombre_regional;
    }

    public void setNombre_regional(String nombre_regional) {
        this.nombre_regional = nombre_regional;
    }
    
}
