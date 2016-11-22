package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.RolBean;
import util.ClassConexion;
import util.ConexionBD;

/**
 * Esta clase realiza y procesa las consultas a bases de datos, de la tabla
 * Rol.
 *
 * @version 1.3
 * @author Monica <JBadCode>
 */

public class RolDao extends ConexionBD {

    private static final String COL_ID_ROL = "id_rol";
    private static final String COL_NOMBRE_ROL = "nombre_rol";
    private static final String COL_DESCRIPCION_ROL = "id_descripcion_rol";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public RolDao() throws NamingException, SQLException {
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
    public boolean InsertarRol(RolBean rol) throws SQLException {
        boolean resultado;// esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query = "{CALL INSERTAR_ROL(?,?,?)}";
        int indexIdRol =1;
        int indexNombreRol =2;
        int indexDescripcionRol =3;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdRol, rol.getId_rol());
        statement.setString(indexNombreRol, rol.getNombre_rol());
        statement.setString(indexDescripcionRol, rol.getDescripcion_rol());        
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
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean UpdateRol(RolBean rol) throws SQLException {
        boolean resultado;// esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query = "{CALL EDITAR_ROL(?,?,?)}";
        int indexIdRol =1;
        int indexNombreRol =2;
        int indexDescripcionRol =3;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdRol, rol.getId_rol());
        statement.setString(indexNombreRol, rol.getNombre_rol());
        statement.setString(indexDescripcionRol, rol.getDescripcion_rol());        
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
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean DeleteRol(RolBean rol) throws SQLException {
       boolean resultado;// esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query = "{CALL ELIMINAR_ROL(?)}";
        int indexIdRol =1;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdRol, rol.getId_rol());       
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
