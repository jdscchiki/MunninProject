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
public class FuncionarioRolBean {
    private long id_funcionario_funci_rol;
    private long id_rol_funci_rol;

    public FuncionarioRolBean() {
    }

    public FuncionarioRolBean(long id_funcionario_funci_rol, long id_rol_funci_rol) {
        this.id_funcionario_funci_rol = id_funcionario_funci_rol;
        this.id_rol_funci_rol = id_rol_funci_rol;
    }

    public long getId_funcionario_funci_rol() {
        return id_funcionario_funci_rol;
    }

    public void setId_funcionario_funci_rol(long id_funcionario_funci_rol) {
        this.id_funcionario_funci_rol = id_funcionario_funci_rol;
    }

    public long getId_rol_funci_rol() {
        return id_rol_funci_rol;
    }

    public void setId_rol_funci_rol(long id_rol_funci_rol) {
        this.id_rol_funci_rol = id_rol_funci_rol;
    }
    
}
