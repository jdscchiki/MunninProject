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
public class ItemBean {
    private long id_item;
    private String descriptor_item;
    private long id_autor_item;

    public ItemBean() {
    }

    public ItemBean(long id_item, String descriptor_item, long id_autor_item) {
        this.id_item = id_item;
        this.descriptor_item = descriptor_item;
        this.id_autor_item = id_autor_item;
    }

    public long getId_item() {
        return id_item;
    }

    public void setId_item(long id_item) {
        this.id_item = id_item;
    }

    public String getDescriptor_item() {
        return descriptor_item;
    }

    public void setDescriptor_item(String descriptor_item) {
        this.descriptor_item = descriptor_item;
    }

    public long getId_autor_item() {
        return id_autor_item;
    }

    public void setId_autor_item(long id_autor_item) {
        this.id_autor_item = id_autor_item;
    }
    
}
