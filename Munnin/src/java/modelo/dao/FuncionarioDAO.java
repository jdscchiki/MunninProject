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

//cosas a tener en cuenta:
//  documentar los metodos, es facil con la herramienta javadoc
//  traten de ser lo mas explicitos posibles en la descripcion de los metodos

/**
 * Esta clase realiza y procesa las consultas a bases de datos, de las tablas 
 * funcionario, rol y rol funcionario
 * @version 1.2
 * @author Juan David Segura Castro <JBadCode>
 */
public class FuncionarioDAO extends ConexionBD{
    private static final String COL_ID = "id_funcionario";
    private static final String COL_ACTIVO = "activo_funcionario";
    private static final String COL_ID_TIPODOCUMENTO = "id_tipo_documento_funcionario";
    private static final String COL_DOCUMENTO = "documento_funcionario";
    private static final String COL_CORREO = "correo_funcionario";
    private static final String COL_CONTRASENA = "contrasena_funcionario";
    private static final String COL_NOMBRE = "nombre_funcionario";
    private static final String COL_APELLIDO = "apellido_funcionario";
    private static final String COL_TELEFONO = "telefono_funcionario";
    private static final String COL_ID_CENTRO = "id_centro_funcionario";
    
    private static final String PROCEDURE_INGRESO = "{CALL LOGIN(?)}";
    private static final int PROCEDURE_INGRESO_CORREO_INDEX = 1;
    private static final String PROCEDURE_REGISTRO_FUNCIONARIO = "{CALL REGISTRAR_INSTRUCTOR_CENTRO(?,?,?,?,?,?,?,?) }}";//tal ves no funcione aun
    
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
        Funcionario funcionario = new Funcionario();//el objeto en donde se guardan los resultados de la consulta
        funcionario.setCorreo(correo);
        CallableStatement statement = getConexion().prepareCall(PROCEDURE_INGRESO);
        statement.setString(PROCEDURE_INGRESO_CORREO_INDEX, correo);//asigna los valores necesarios para ejecutar el QUERY
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        boolean encontrado = false;//una bandera
        while(rs.next()){
            encontrado = true;
            //asigna los valores resultantes de la consulta
            funcionario.setId(rs.getInt(COL_ID));
            funcionario.setActivo(rs.getBoolean(COL_ACTIVO));
            funcionario.setIdTipoDocumento(rs.getInt(COL_ID_TIPODOCUMENTO));
            funcionario.setDocumento(rs.getString(COL_DOCUMENTO));
            funcionario.setContrasena(rs.getString(COL_CONTRASENA));
            funcionario.setNombre(rs.getString(COL_NOMBRE));
            funcionario.setApellido(rs.getString(COL_APELLIDO));
            funcionario.setTelefono(rs.getString(COL_TELEFONO));
            funcionario.setIdCentro(rs.getString(COL_ID_CENTRO));
        }
        if(!encontrado){
            funcionario = null;//si no existe el correo en la base de datos retorna null
        }
        return funcionario;
    }
    
    //no le pongan atencion a este metodo aun
    public boolean registrar(Funcionario funcionario){
        boolean resultado = false;
        //encriptacion de contraseña
        try {
            funcionario.setContrasena(Encriptado.createHash(funcionario.getContrasena()));
            try{
                CallableStatement statement = getConexion().prepareCall(PROCEDURE_REGISTRO_FUNCIONARIO);
                statement.setString(1, funcionario.getDocumento());
                statement.setString(2, funcionario.getCorreo());
                statement.setString(3, funcionario.getContrasena());
                statement.setString(4, funcionario.getNombre());
                statement.setString(5, funcionario.getApellido());
                statement.setString(6, funcionario.getCargo());
                statement.setString(7, funcionario.getTelefono());
                statement.setString(8, funcionario.getIdCentro());

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
