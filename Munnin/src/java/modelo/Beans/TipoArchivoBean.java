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
public class TipoArchivoBean {
    private long id_tipo_archivo;
    private String extencion_tipo_archivo;

    public TipoArchivoBean() {
    }

    public TipoArchivoBean(long id_tipo_archivo, String extencion_tipo_archivo) {
        this.id_tipo_archivo = id_tipo_archivo;
        this.extencion_tipo_archivo = extencion_tipo_archivo;
    }

    public long getId_tipo_archivo() {
        return id_tipo_archivo;
    }

    public void setId_tipo_archivo(long id_tipo_archivo) {
        this.id_tipo_archivo = id_tipo_archivo;
    }

    public String getExtencion_tipo_archivo() {
        return extencion_tipo_archivo;
    }

    public void setExtencion_tipo_archivo(String extencion_tipo_archivo) {
        this.extencion_tipo_archivo = extencion_tipo_archivo;
    }
    
}
