package modelo.Dao;

import java.sql.*;
import java.sql.Statement;
import javax.naming.NamingException;
import modelo.Beans.Autor_Bean;
import util.ClassConexion;
import util.ConexionBD;
import modelo.Beans.Autor_Bean; 


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
   
    private static final String PROCEDURE_INSERT_AUTOR = "{CALL INSERTAR_AUTOR(?,?)}";
    //private static final int PROCEDURE_INGR_CORREO_INDEX = 1;
    private static final String PROCEDURE_UPDATE_AUTOR = "{CALL EDITAR_AUTOR(?,?)}";
    private static final String PROCEDURE_DELETE_AUTOR = "{CALL ElIMINAR_AUTOR(?,?)}";
     private static final String PROCEDURE_SEE_AUTOR = "{CALL VER_AREA(?,?)}";

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
     * @param Id_funcionario_autor Id del Area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Autor_Bean InsertarAutor(Long Id_funcionario_autor) throws SQLException {
        Autor_Bean autor = new Autor_Bean();//el objeto en donde se guardan los resultados de la consulta
        autor.setId_funcionario_autor(Id_funcionario_autor);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERTAR_AUTOR(?,?)}");
        statement.setLong(PROCEDURE_INSERT_AUTOR, Id_funcionario_autor);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(1, COL_ID_VERSION_AUTOR);
        
       
        return autor;
    }

    /**
     * @param Id_funcionario_autor  Id del Autor
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Autor_Bean UpdateAutor(Long Id_funcionario_autor) throws SQLException {
        Autor_Bean autor = new Autor_Bean();//el objeto en donde se guardan los resultados de la consulta
        autor.setId_funcionario_autor(Id_funcionario_autor);
        CallableStatement statement = this.getConexion().prepareCall("{CALL EDITAR_AUTOR(?,?,?)}");
        statement.setLong(PROCEDURE_UPDATE_AUTOR, Id_funcionario_autor);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_ID_VERSION_AUTOR);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
     
        return autor;
    }

    /**
     * @param Id_funcionario_autor _ Id del AUTOR
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public  Autor_Bean DeleteAutor(long Id_funcionario_autor) throws SQLException {
        Autor_Bean autor = new Autor_Bean();//el objeto en donde se guardan los resultados de la consulta
        autor.setId_funcionario_autor(Id_funcionario_autor);
        CallableStatement statement = this.getConexion().prepareCall("{CALL ELIMINAR_AUTOR(?,?,?)}");
        statement.setLong(PROCEDURE_DELETE_AUTOR, Id_funcionario_autor);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_ID_VERSION_AUTOR);
       
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return autor;
    }

}
