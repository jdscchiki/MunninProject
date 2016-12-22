/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import java.util.ArrayList;

/**
 *
 * @author Juan David Segura
 */
public class Estado {

    private int id;
    private String nombre;
    private ArrayList<Version> versiones;

    public ArrayList<Version> getVersiones() {
        return versiones;
    }

    public void setVersiones(ArrayList<Version> versiones) {
        this.versiones = versiones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estado() {
    }
}
