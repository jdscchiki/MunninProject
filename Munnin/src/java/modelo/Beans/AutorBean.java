
package modelo.Beans;

public class AutorBean {
    
    private long id_funcionario_autor;
    private long id_version_autor;

    public AutorBean() {
    }

    public AutorBean(long id_funcionario_autor, long id_version_autor) {
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
