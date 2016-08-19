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
public class Funcionario_Bean {
    private long id_funcionario;
    private String documento_funcionario;
    private String correo_funcionario;
    private String contrasena_funcionario;
    private String nombre_funcionario;
    private String apellido_funcionario;
    private String cargo_funcionario;
    private String telefono_funcionario;
    private String id_centro_funcionario;

    public Funcionario_Bean() {
    }

    public Funcionario_Bean(long id_funcionario, String documento_funcionario, String correo_funcionario, String contrasena_funcionario, String nombre_funcionario, String apellido_funcionario, String cargo_funcionario, String telefono_funcionario, String id_centro_funcionario) {
        this.id_funcionario = id_funcionario;
        this.documento_funcionario = documento_funcionario;
        this.correo_funcionario = correo_funcionario;
        this.contrasena_funcionario = contrasena_funcionario;
        this.nombre_funcionario = nombre_funcionario;
        this.apellido_funcionario = apellido_funcionario;
        this.cargo_funcionario = cargo_funcionario;
        this.telefono_funcionario = telefono_funcionario;
        this.id_centro_funcionario = id_centro_funcionario;
    }

    public Funcionario_Bean(long id_funcionario, String string, String string0, String string1, String string2, String string3, String string4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public long getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(long id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getDocumento_funcionario() {
        return documento_funcionario;
    }

    public void setDocumento_funcionario(String documento_funcionario) {
        this.documento_funcionario = documento_funcionario;
    }

    public String getCorreo_funcionario() {
        return correo_funcionario;
    }

    public void setCorreo_funcionario(String correo_funcionario) {
        this.correo_funcionario = correo_funcionario;
    }

    public String getContrasena_funcionario() {
        return contrasena_funcionario;
    }

    public void setContrasena_funcionario(String contrasena_funcionario) {
        this.contrasena_funcionario = contrasena_funcionario;
    }

    public String getNombre_funcionario() {
        return nombre_funcionario;
    }

    public void setNombre_funcionario(String nombre_funcionario) {
        this.nombre_funcionario = nombre_funcionario;
    }

    public String getApellido_funcionario() {
        return apellido_funcionario;
    }

    public void setApellido_funcionario(String apellido_funcionario) {
        this.apellido_funcionario = apellido_funcionario;
    }

    public String getCargo_funcionario() {
        return cargo_funcionario;
    }

    public void setCargo_funcionario(String cargo_funcionario) {
        this.cargo_funcionario = cargo_funcionario;
    }

    public String getTelefono_funcionario() {
        return telefono_funcionario;
    }

    public void setTelefono_funcionario(String telefono_funcionario) {
        this.telefono_funcionario = telefono_funcionario;
    }

    public String getId_centro_funcionario() {
        return id_centro_funcionario;
    }

    public void setId_centro_funcionario(String id_centro_funcionario) {
        this.id_centro_funcionario = id_centro_funcionario;
    }
    
}
