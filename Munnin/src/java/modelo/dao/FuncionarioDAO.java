/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
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
    /**
     * String usado para llamar el procedimento almacenado en la base de datos
     * llamado login.
     */
    private static final String CALLPROCEDURE_INGRESO = "{CALL login(?)}";
    
    /**
     * String usado para llamar el procedimento almacenado en la base de datos
     * llamado registrar_instructor_centro.
     */
    private static final String CALLPROCEDURE_REGISTRO_FUNCIONARIO = "{CALL REGISTRAR_INSTRUCTOR_CENTRO(?,?,?,?,?,?,?,?) }}";
    
    /**
     * Este constructor permite establecer la conexion con la base de datos
     * 
     * @throws NamingException
     * @throws SQLException
     */
    public FuncionarioDAO() throws NamingException, SQLException{
        super();
    }
    
    /**
     * Ejecuta el procedimiento almacenado LOGIN de la base de datos
     * para obtener los datos del Usuario con el correo
     * 
     * @param correo Correo del usuario
     * @return Retorna Null si el correo no se encuetra en la base de datos, 
     * de lo contrario retorna los datos del Usuario.
     * @version 1.0
     * @throws java.sql.SQLException
    */
    public Funcionario buscarFuncionarioCorreo(String correo) throws SQLException{
        Funcionario funcionario = new Funcionario();
        funcionario.setCorreo(correo);
        CallableStatement statement = getConexion().prepareCall(CALLPROCEDURE_INGRESO);
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
        if(!encontrado){
            funcionario = null;
        }
        return funcionario;
    }
    
    public boolean registrar(Funcionario funcionario){
        boolean resultado = false;
        //encriptacion de contraseña
        try {
            funcionario.setContrasena(Encriptado.createHash(funcionario.getContrasena()));
            try{
                CallableStatement statement = getConexion().prepareCall(CALLPROCEDURE_REGISTRO_FUNCIONARIO);
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
            }catch(SQLException e){
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
