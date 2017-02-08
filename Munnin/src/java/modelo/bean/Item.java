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
public class Item {
    private int id;
    private String descriptor;
    private Funcionario autor;
    private ArrayList<Lista> listas;
    private ArrayList<EvaluacionItem> evaluacionItems;

    public ArrayList<Lista> getListas() {
        return listas;
    }

    public void setListas(ArrayList<Lista> listas) {
        this.listas = listas;
    }

    public ArrayList<EvaluacionItem> getEvaluacionItems() {
        return evaluacionItems;
    }

    public void setEvaluacionItems(ArrayList<EvaluacionItem> evaluacionItems) {
        this.evaluacionItems = evaluacionItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public Funcionario getAutor() {
        return autor;
    }

    public void setAutor(Funcionario autor) {
        this.autor = autor;
    }

    public Item() {
    }
}
