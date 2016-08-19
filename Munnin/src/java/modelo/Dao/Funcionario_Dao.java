
package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import modelo.Beans.Funcionario_Bean;


public class Funcionario_Dao {
    
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    private long id_funcionario;
    private String documento_funcionario;
    private String correo_funcionario;
    private String contrasena_funcionario;
    private String nombre_funcionario;
    private String apellido_funcionario;
    private String cargo_funcionario;
    private String telefono_funcionario;
    private String id_centro_funcionario;
    
    
    public Funcionario_Dao(Funcionario_Bean Funcionario) {
        super();
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();

            id_funcionario = Funcionario.getId_funcionario();
            documento_funcionario = Funcionario.getDocumento_funcionario();
            correo_funcionario = Funcionario.getCorreo_funcionario();
            contrasena_funcionario = Funcionario.getContrasena_funcionario();
            nombre_funcionario = Funcionario.getNombre_funcionario();
            apellido_funcionario = Funcionario.getApellido_funcionario();
            cargo_funcionario = Funcionario.getCargo_funcionario();
            telefono_funcionario = Funcionario.getTelefono_funcionario();
            id_centro_funcionario = Funcionario.getId_centro_funcionario();
            

        } catch (SQLException e) {
        }
    
    } 
    
}
