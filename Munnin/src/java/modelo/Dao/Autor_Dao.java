package modelo.Dao;

import java.sql.*;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.Area_Bean;
import modelo.Beans.Autor_Bean;
import util.ClassConexion;
import util.ConexionBD;


  //cosas a tener en cuenta:
//  documentar los metodos, es facil con la herramienta javadoc
//  traten de ser lo mas explicitos posibles en la descripcion de los metodos
/**
 * Esta clase realiza y procesa las consultas a bases de datos, de las tablas
 * Area.
 *
 * @version 1.2
 * @author Monica <JBadCode>
 */
public class Autor_Dao extends ConexionBD {

    private static final String COL_ID_FUNCIONARIO_AUTOR = "id_funcionario_autor";
    private static final String COL_ID_VERSION_AUTOR = "id_version_autor";


    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Autor_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param autor
     * @return Retorna Null si el Autor no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Autor.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean InsertarAutor(Autor_Bean autor) throws SQLException {
        boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en base de datos
        
        String query ="{CALL INSERTAR_AUTOR(?,?)}";
        int indexIdFuncionarioAutor =1;
        int indexIdversionAutor =2;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdFuncionarioAutor, autor.getId_funcionario_autor());
        statement.setLong(indexIdversionAutor, autor.getId_version_autor());        
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
     * @param autor
     * @return Retorna Null si el Autor no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Autor.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean UpdateAutor(Autor_Bean autor) throws SQLException {
       boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en base de datos
        
        String query ="{CALL EDITAR_AUTOR(?,?)}";
        int indexIdFuncionarioAutor =1;
        int indexIdversionAutor =2;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdFuncionarioAutor, autor.getId_funcionario_autor());
        statement.setLong(indexIdversionAutor, autor.getId_version_autor());        
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
     * @param autor
     * @return Retorna Null si el Autor no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Autor.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean DeleteAutor(Autor_Bean autor) throws SQLException {
        boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en base de datos
        
        String query ="{CALL ELIMINAR_AUTOR(?)}";
        int indexIdFuncionarioAutor =1;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdFuncionarioAutor, autor.getId_funcionario_autor());     
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
