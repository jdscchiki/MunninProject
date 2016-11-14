
package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.naming.NamingException;
import modelo.Beans.Lista_Chequeo_Bean;
import util.ClassConexion;
import util.ConexionBD;


public class Lista_Chequeo_Dao extends ConexionBD {

    private static final String COL_ID_LISTA = "id_lista";
    private static final String COL_NOMBRE_LISTA = "nombre_lista";
    private static final String COL_DESCRIPCION_LISTA = "descripcion_lista";
    private static final String COL_FECHA_LISTA = "fecha_lista";
    private static final String COL_TIPO_LISTA = "tipo_lista";
    private static final String COL_ID_AUTOR_LISTA = "id_autor_lista";

    private static final String PROCEDURE_INSERT_LISTA = "{CALL INSERTAR_LISTA_CHEQUEO(?,?,?,?,?,?)}";    
    private static final String PROCEDURE_UPDATE_LISTA = "{CALL EDITAR_LISTA_CHEQUEO(?,?,?,?,?,?)}";
    private static final String PROCEDURE_DELETE_LISTA = "{CALL ElIMINAR_LISTA_CHEQUEO(?)}";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Lista_Chequeo_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param Id_lista Id del Lista_Chequeo
     * @return Retorna Null si el Lista_Chequeo no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Lista_Chequeo.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Lista_Chequeo_Bean InsertarLista(Long Id_lista) throws SQLException {
        Lista_Chequeo_Bean lista = new Lista_Chequeo_Bean();//el objeto en donde se guardan los resultados de la consulta
        lista.setId_lista(Id_lista);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERTAR_LISTA(?,?,?,?,?,?))}");
        statement.setLong(PROCEDURE_INSERT_LISTA, Id_lista);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_LISTA);
        statement.setString(3, COL_DESCRIPCION_LISTA);
        statement.setString(4, COL_FECHA_LISTA);
        statement.setString(5, COL_TIPO_LISTA);
        statement.setString(6, COL_ID_AUTOR_LISTA);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta

       
        return lista;
    }

    /**
     * @param Id_lista Id del Lista_chequeo
     * @return Retorna Null si el Lista_chequeo no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Lista_chequeo.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Lista_Chequeo_Bean  UpdateLista(Long Id_lista) throws SQLException {
        Lista_Chequeo_Bean  lista = new Lista_Chequeo_Bean ();//el objeto en donde se guardan los resultados de la consulta
        lista.setId_lista(Id_lista);
        CallableStatement statement = this.getConexion().prepareCall("{CALL EDITAR_LISTA(?,?,?,?,?,?)}");
        statement.setLong(PROCEDURE_UPDATE_LISTA, Id_lista);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_LISTA);
        statement.setString(3, COL_DESCRIPCION_LISTA);
        statement.setString(4, COL_FECHA_LISTA);
        statement.setString(5, COL_TIPO_LISTA);
        statement.setString(6, COL_ID_AUTOR_LISTA);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
     
        return lista;
    }

    /**
     * @param Id_lista Id del Lista_chequeo
     * @return Retorna Null si el Lista_chequeo no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Lista_chequeo.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public  Lista_Chequeo_Bean DeleteLista(long Id_lista) throws SQLException {
        Lista_Chequeo_Bean lista = new Lista_Chequeo_Bean();//el objeto en donde se guardan los resultados de la consulta
        lista.setId_lista(Id_lista);
        CallableStatement statement = this.getConexion().prepareCall("{CALL ELIMINAR_LISTA(?,?,?,?,?,?)}");
        statement.setLong(PROCEDURE_DELETE_LISTA, Id_lista);//asigna los valores necesarios para ejecutar el QUERY
         statement.setString(2, COL_NOMBRE_LISTA);
        statement.setString(3, COL_DESCRIPCION_LISTA);
        statement.setString(4, COL_FECHA_LISTA);
        statement.setString(5, COL_TIPO_LISTA);
        statement.setString(6, COL_ID_AUTOR_LISTA);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return lista;
    }

}
