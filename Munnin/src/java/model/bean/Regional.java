/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.ArrayList;

/**
 *
 * @author Juan David Segura
 */
public class Regional {
    private String id;
    private String nombre;
    private ArrayList<Centro> centros;

    public ArrayList<Centro> getCentros() {
        return centros;
    }

    public void setCentros(ArrayList<Centro> centros) {
        this.centros = centros;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Regional() {
    }
}
