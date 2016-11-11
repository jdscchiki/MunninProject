package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.Rol_Bean;
import util.ClassConexion;
import util.ConexionBD;

public class Rol_Dao extends ConexionBD {

    private static final String COL_ID_ROL = "id_rol";
    private static final String COL_NOMBRE_ROL = "nombre_rol";
    private static final String COL_ID_DESCRIPCION_ROL = "id_descripcion_rol";

    private static final String PROCEDURE_INSERT_ROL = "{CALL INSERTAR_ROL(?,?,?)}";
    private static final String PROCEDURE_UPDATE_ROL = "{CALL EDITAR_ROL(?,?,?)}";
    private static final String PROCEDURE_DELETE_ROL = "{CALL ElIMINAR_ROL(?,?,?)}";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Rol_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param Id_rol Id del Rol
     * @return Retorna Null si el Rol no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Rol.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Rol_Bean InsertarRol(Long Id_rol) throws SQLException {
        Rol_Bean rol = new Rol_Bean();//el objeto en donde se guardan los resultados de la consulta
        rol.setId_rol(Id_rol);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERTAR_ROL(?,?,?)}");
        statement.setLong(PROCEDURE_INSERT_ROL, Id_rol);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_ROL);
        statement.setString(3, COL_ID_DESCRIPCION_ROL);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta

       
        return rol;
    }

    /**
     * @param Id_rol Id del Rol
     * @return Retorna Null si el Rol no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Rol.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Rol_Bean UpdateRol(Long Id_rol) throws SQLException {
        Rol_Bean rol = new Rol_Bean();//el objeto en donde se guardan los resultados de la consulta
        rol.setId_rol(Id_rol);
        CallableStatement statement = this.getConexion().prepareCall("{CALL EDITAR_ROL(?,?,?)}");
        statement.setLong(PROCEDURE_UPDATE_ROL, Id_rol);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_ROL);
        statement.setString(3, COL_ID_DESCRIPCION_ROL);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
     
        return rol;
    }

    /**
     * @param Id_rol Id del Rol
     * @return Retorna Null si el Rol no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Rol.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public  Rol_Bean DeleteRol(long Id_rol) throws SQLException {
        Rol_Bean rol = new Rol_Bean();//el objeto en donde se guardan los resultados de la consulta
        rol.setId_rol(Id_rol);
        CallableStatement statement = this.getConexion().prepareCall("{CALL ELIMINAR_ROL(?,?,?)}");
        statement.setLong(PROCEDURE_DELETE_ROL, Id_rol);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_ROL);
        statement.setString(3, COL_ID_DESCRIPCION_ROL);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return rol;
    }

}
