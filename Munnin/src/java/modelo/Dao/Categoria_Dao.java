package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;
import javax.naming.NamingException;
import modelo.Beans.Categoria_Bean;
import util.ClassConexion;
import util.ConexionBD;
import modelo.Beans.Categoria_Bean;

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
public class Categoria_Dao extends ConexionBD{ 

    private static final String COL_ID_CATEGORIA = "id_categoria";
    private static final String COL_NOMBRE_CATEGORIA = "nombre_categoria";
    private static final String COL_ID_CENTRO_CATEGORIA = "id_centro_categoria";
   
    private static final String PROCEDURE_INSERT_CATEGORIA = "{CALL INSERTAR_CATEGORIA(?,?)}";
    //private static final int PROCEDURE_INGR_CORREO_INDEX = 1;
    private static final String PROCEDURE_UPDATE_CATEGORIA = "{CALL EDITAR_CATEGORIA(?,?)}";
    private static final String PROCEDURE_DELETE_CATEGORIA = "{CALL ElIMINAR_CATEGORIA(?,?)}";
    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Categoria_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param Id_categoria  Id de LA CATEGORIA
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Categoria_Bean InsertarCategoria(Long Id_categoria) throws SQLException {
        Categoria_Bean categoria = new Categoria_Bean();//el objeto en donde se guardan los resultados de la consulta
        categoria.setId_categoria(Id_categoria);
        CallableStatement statement = this.getConexion().prepareCall("{CALL INSERTAR_CATEGORIA(?,?)}");
        statement.setLong(PROCEDURE_INSERT_CATEGORIA, Id_categoria);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(1, COL_NOMBRE_CATEGORIA);
        statement.setString(2, COL_ID_CENTRO_CATEGORIA);
        
       
        return categoria;
    }

    /**
     * @param Id_categoria   Id de la categoria
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public Categoria_Bean UpdateAutor(Long Id_categoria) throws SQLException {
        Categoria_Bean categoria = new Categoria_Bean();//el objeto en donde se guardan los resultados de la consulta
        categoria.setId_categoria(Id_categoria);
        CallableStatement statement = this.getConexion().prepareCall("{CALL EDITAR_CATEGORIA(?,?,?)}");
        statement.setLong(PROCEDURE_UPDATE_CATEGORIA, Id_categoria);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_CATEGORIA);
        statement.setString(3, COL_ID_CENTRO_CATEGORIA);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
     
        return categoria;
    }

    /**
     * @param Id_categoria  _ Id de la categoria
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public  Categoria_Bean DeleteAutor(long Id_categoria) throws SQLException {
        Categoria_Bean categoria = new Categoria_Bean();//el objeto en donde se guardan los resultados de la consulta
        categoria.setId_categoria(Id_categoria);
        CallableStatement statement = this.getConexion().prepareCall("{CALL ELIMINAR_CATEGORIA(?,?,?)}");
        statement.setLong(PROCEDURE_DELETE_CATEGORIA, Id_categoria);//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(2, COL_NOMBRE_CATEGORIA);
         statement.setString(3, COL_ID_CENTRO_CATEGORIA);
       
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
      
        return categoria;
    }
   

}
