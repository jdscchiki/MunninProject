
package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Funcionario_Rol_Bean;


public class Funcionario_Rol_Dao {
    
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    private long id_funcionario_funci_rol;
    private long id_rol_funci_rol;
    
    public Funcionario_Rol_Dao(Funcionario_Rol_Bean Funcionario_Rol) {
        super();
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();

            id_funcionario_funci_rol = Funcionario_Rol.getId_funcionario_funci_rol();
            id_rol_funci_rol = Funcionario_Rol.getId_rol_funci_rol();
            
            

        } catch (SQLException e) {
        }
    
    } 
    
}
