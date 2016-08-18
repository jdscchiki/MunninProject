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
public class Detalle_Lista_Bean {
    
    private long id_detalle_lista;
    private long id_lista_detalle_lista;
    private long id_item_detalle_lista;

    public Detalle_Lista_Bean() {
    }

    public Detalle_Lista_Bean(long id_detalle_lista, long id_lista_detalle_lista, long id_item_detalle_lista) {
        this.id_detalle_lista = id_detalle_lista;
        this.id_lista_detalle_lista = id_lista_detalle_lista;
        this.id_item_detalle_lista = id_item_detalle_lista;
    }

    public long getId_detalle_lista() {
        return id_detalle_lista;
    }

    public void setId_detalle_lista(long id_detalle_lista) {
        this.id_detalle_lista = id_detalle_lista;
    }

    public long getId_lista_detalle_lista() {
        return id_lista_detalle_lista;
    }

    public void setId_lista_detalle_lista(long id_lista_detalle_lista) {
        this.id_lista_detalle_lista = id_lista_detalle_lista;
    }

    public long getId_item_detalle_lista() {
        return id_item_detalle_lista;
    }

    public void setId_item_detalle_lista(long id_item_detalle_lista) {
        this.id_item_detalle_lista = id_item_detalle_lista;
    }
    
}
