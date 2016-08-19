
package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Funcionario_Rol_Bean;
import util.ClassConexion;


public class Funcionario_Rol_Dao extends ClassConexion{
    
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    private long id_funcionario_funci_rol;
    private long id_rol_funci_rol;
    
    public Funcionario_Rol_Dao(Funcionario_Rol_Bean Funcionario_Rol) {
        super();
            conn = this.obtenerConexion();

            id_funcionario_funci_rol = Funcionario_Rol.getId_funcionario_funci_rol();
            id_rol_funci_rol = Funcionario_Rol.getId_rol_funci_rol();
    
    } 
    
    public boolean insertar_funcionario_rol() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_funcionario_rol (?,?)}");
            cst.setLong(1, id_funcionario_funci_rol);
            cst.setLong(2, id_rol_funci_rol);

            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_funcionario_rol() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_funcionario_rol (?,?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_funcionario_funci_rol);
            cst.setLong(2, id_rol_funci_rol);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_funcionario_rol() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_funcionario_rol (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_funcionario_funci_rol);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public Funcionario_Rol_Bean ver_estado() {
        Funcionario_Rol_Bean frb = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_estado (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_funcionario_funci_rol);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.DOUBLE);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            frb = new Funcionario_Rol_Bean(id_funcionario_funci_rol, cst.getLong(2));
        } catch (SQLException e) {
        }
        return frb;
    }
}
