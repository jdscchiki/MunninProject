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
public class Autor_Bean {
    
    private long id_funcionario_autor;
    private long id_version_autor;

    public Autor_Bean() {
    }

    public Autor_Bean(long id_funcionario_autor, long id_version_autor) {
        this.id_funcionario_autor = id_funcionario_autor;
        this.id_version_autor = id_version_autor;
    }

    public long getId_funcionario_autor() {
        return id_funcionario_autor;
    }

    public void setId_funcionario_autor(long id_funcionario_autor) {
        this.id_funcionario_autor = id_funcionario_autor;
    }

    public long getId_version_autor() {
        return id_version_autor;
    }

    public void setId_version_autor(long id_version_autor) {
        this.id_version_autor = id_version_autor;
    }
    
}
