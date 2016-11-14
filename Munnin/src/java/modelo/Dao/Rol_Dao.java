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
    private static final String COL_DESCRIPCION_ROL = "id_descripcion_rol";

    private static final String PROCEDURE_INSERT_ROL = "{CALL INSERTAR_ROL(?,?,?)}";
    private static final String PROCEDURE_UPDATE_ROL = "{CALL EDITAR_ROL(?,?,?)}";
    private static final String PROCEDURE_DELETE_ROL = "{CALL ElIMINAR_ROL(?)}";
    
    private static final int PROCEDURE_INSERTAR_ID_ROL_INDEX = 1;
    private static final int PROCEDURE_INSERTAR_NOMBRE_ROL_INDEX = 2;
    private static final int PROCEDURE_INSERTAR_DESCRIPCION_ROL_INDEX = 3;
    
    private static final int PROCEDURE_UPDATE_ID_ROL_INDEX = 1;
    private static final int PROCEDURE_UPDATE_NOMBRE_ROL_INDEX = 2;
    private static final int PROCEDURE_UPDATE_DESCRIPCION_ROL_INDEX = 3;
    
    private static final int PROCEDURE_DELETE_ID_ROL_INDEX = 1;

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
     * @param rol
     * @return Retorna Null si el Rol no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Rol.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean InsertarRol(Rol_Bean rol) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_INSERT_ROL);
        statement.setLong(PROCEDURE_INSERTAR_ID_ROL_INDEX, rol.getId_rol());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_INSERTAR_NOMBRE_ROL_INDEX, rol.getNombre_rol());
        statement.setString(PROCEDURE_INSERTAR_DESCRIPCION_ROL_INDEX, rol.getDescripcion_rol());        
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * @param rol
     * @return Retorna Null si el Rol no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Rol.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean UpdateRol(Rol_Bean rol) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall("{CALL EDITAR_ROL(?,?,?)}");
        statement.setLong(PROCEDURE_UPDATE_ID_ROL_INDEX, rol.getId_rol());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_UPDATE_NOMBRE_ROL_INDEX, rol.getNombre_rol());
        statement.setString(PROCEDURE_UPDATE_DESCRIPCION_ROL_INDEX, rol.getDescripcion_rol());        
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * @param rol
     * @return Retorna Null si el Rol no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Rol.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean DeleteRol(Rol_Bean rol) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_DELETE_ROL);
        statement.setLong(PROCEDURE_DELETE_ID_ROL_INDEX, rol.getId_rol());//asigna los valores necesarios para ejecutar el QUERY        
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {//se cancela el registro cuando se agrega mas o menos de 1 una fila
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

}
