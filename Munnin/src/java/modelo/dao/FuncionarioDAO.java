/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.ConexionBD;
import util.Encriptado;
import modelo.bean.Funcionario;
import modelo.bean.Rol;

//cosas a tener en cuenta:
//  documentar los metodos, es facil con la herramienta javadoc
//  traten de ser lo mas explicitos posibles en la descripcion de los metodos

/**
 * Esta clase realiza y procesa las consultas a bases de datos, de las tablas 
 * funcionario, rol y rol funcionario
 * @version 1.0
 * @author Juan David Segura Castro <JBadCode>
 */
public class FuncionarioDAO extends ConexionBD{

    //se establece la conexion a bases de datos en el momento en el que se crea un nuevo funcionarioDAO
    public FuncionarioDAO() {
        super();
    }
    
    /**
     * Ejecuta el procedimiento almacenado <code>LOGIN</code> de la base de datos
     * para obtener los datos del Usuario
     * 
     * @param correo Correo ingresado por el Usuario
     * @param contrasena Contraseña ingresada por el Usuario
     * @return Retorna Null si el correo o contraseña son incorrectos, 
     * de lo contrario retorna los datos del Usuario (excepto la contraseña)
     * @version 1.0
    */
    public Funcionario ingresar(String correo, String contrasena){
        Funcionario funcionario = new Funcionario();
        funcionario.setCorreo(correo);
        try{
            String query = "{call LOGIN(?)}";
            CallableStatement statement = getConexion().prepareCall(query);
            statement.setString(1, correo);
            ResultSet rs = statement.executeQuery();
            boolean encontrado = false;
            while(rs.next()){
                encontrado = true;
                funcionario.setDocumento(rs.getString(2));
                funcionario.setContrasena(rs.getString(3));
                funcionario.setNombre(rs.getString(4));
                funcionario.setApellido(rs.getString(5));
                funcionario.setCargo(rs.getString(6));
                funcionario.setTelefono(rs.getString(7));
                funcionario.setId_centro(rs.getString(8));
            }
            if(encontrado){
                System.out.println("Contraseña: " + funcionario.getContrasena());
                if(Encriptado.verifyPassword(contrasena, funcionario.getContrasena())){
                    funcionario.setContrasena("");
                }else{
                    funcionario = null;
                }
            }else{
                funcionario = null;
            }
        }catch(SQLException e){
            System.out.println("Error al realizar consulta operacion Ingresar: " + e);
        }catch(Exception e){
            System.out.println("Error al realizar operacion Ingresar: " + e);
        }finally{
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion: " + e);
            }
        }
        return funcionario;
    }
    
    public boolean registrar(Funcionario funcionario){
        boolean resultado = false;
        //encriptacion de contraseña
        try {
            funcionario.setContrasena(Encriptado.createHash(funcionario.getContrasena()));
            try{
                String query = "{call REGISTRAR_INSTRUCTOR_CENTRO(?,?,?,?,?,?,?,?) }";
                CallableStatement statement = getConexion().prepareCall(query);
                statement.setString(1, funcionario.getDocumento());
                statement.setString(2, funcionario.getCorreo());
                statement.setString(3, funcionario.getContrasena());
                statement.setString(4, funcionario.getNombre());
                statement.setString(5, funcionario.getApellido());
                statement.setString(6, funcionario.getCargo());
                statement.setString(7, funcionario.getTelefono());
                statement.setString(8, funcionario.getId_centro());

                if(statement.executeUpdate()>0){
                    resultado = true;
                }
            }catch(Exception e){
                System.out.println("Error al realizar operacion Ingresar: " + e);
            }
        } catch (Encriptado.CannotPerformOperationException ex) {
            ex.getMessage();
        } finally{
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion: " + e);
            }
        }
        return resultado;
    }
    
}
