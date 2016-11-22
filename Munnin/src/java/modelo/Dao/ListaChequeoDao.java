
package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.naming.NamingException;
import modelo.Beans.ListaChequeoBean;
import util.ClassConexion;
import util.ConexionBD;

/**
 * Esta clase realiza y procesa las consultas a bases de datos, de la tabla
 * ListaChequeo.
 *
 * @version 1.3
 * @author Monica <JBadCode>
 */

public class ListaChequeoDao extends ConexionBD {

    private static final String COL_ID_LISTA = "id_lista";
    private static final String COL_NOMBRE_LISTA = "nombre_lista";
    private static final String COL_DESCRIPCION_LISTA = "descripcion_lista";
    private static final String COL_FECHA_LISTA = "fecha_lista";
    private static final String COL_TIPO_LISTA = "tipo_lista";
    private static final String COL_ID_AUTOR_LISTA = "id_autor_lista";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public ListaChequeoDao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param Id_lista Id del Lista_Chequeo
     * @return Retorna Null si el Lista_Chequeo no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Lista_Chequeo.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean InsertarLista(ListaChequeoBean lista) throws SQLException {
        boolean resultado;// esta es la futura respuesta
        
        //datos en la consulta en base de datos
        String query = "{CALL INSERTAR_LISTA(?,?,?,?,?,?)}";
        int indexIdLista = 1;
        int indexNombreLista = 2 ;
        int indexDescripcionLista = 3;
        int indexFechaLista = 4;
        int indexTipoLista = 5;
        int indexIdAutorLista = 6;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdLista, lista.getId_lista());
        statement.setString(indexNombreLista,lista.getNombre_lista());
        statement.setString(indexDescripcionLista, lista.getDescripcion_lista());
        statement.setDate(indexFechaLista, (java.sql.Date) lista.getFecha_lista());
        statement.setString(indexTipoLista,lista.getTipo_lista());
        statement.setLong(indexIdAutorLista, lista.getId_autor_lista());
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
     * @param Id_lista Id del Lista_chequeo
     * @return Retorna Null si el Lista_chequeo no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Lista_chequeo.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean  UpdateLista(ListaChequeoBean lista) throws SQLException {
        boolean resultado;// esta es la futura respuesta
        
        //datos en la consulta en base de datos
        String query = "{CALL EDITAR_LISTA(?,?,?,?,?,?)}";
        int indexIdLista = 1;
        int indexNombreLista = 2 ;
        int indexDescripcionLista = 3;
        int indexFechaLista = 4;
        int indexTipoLista = 5;
        int indexIdAutorLista = 6;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdLista, lista.getId_lista());
        statement.setString(indexNombreLista,lista.getNombre_lista());
        statement.setString(indexDescripcionLista, lista.getDescripcion_lista());
        statement.setDate(indexFechaLista, (java.sql.Date) lista.getFecha_lista());
        statement.setString(indexTipoLista,lista.getTipo_lista());
        statement.setLong(indexIdAutorLista, lista.getId_autor_lista());
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
     * @param Id_lista Id del Lista_chequeo
     * @return Retorna Null si el Lista_chequeo no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Lista_chequeo.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean  DeleteLista(ListaChequeoBean lista) throws SQLException {
        boolean resultado;// esta es la futura respuesta
        
        //datos en la consulta en base de datos
        String query = "{CALL ELIMINAR_LISTA(?)}";
        int indexIdLista = 1;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdLista, lista.getId_lista());
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
