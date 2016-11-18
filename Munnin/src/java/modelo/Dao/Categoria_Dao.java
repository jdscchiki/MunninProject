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
 * @version 1.3
 * @author Monica <JBadCode>
 */
public class Categoria_Dao extends ConexionBD{ 

    private static final String COL_ID_CATEGORIA = "id_categoria";
    private static final String COL_NOMBRE_CATEGORIA = "nombre_categoria";
    private static final String COL_ID_CENTRO_CATEGORIA = "id_centro_categoria";


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
     * @param categoria
     * @return Retorna Null si la Categoria no se encuetra en la base de datos, de lo
     * contrario retorna los datos de la categoria.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean InsertarCategoria(Categoria_Bean categoria) throws SQLException {
        boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en la base de datoos
        String query ="{CALL INSERTAR_CATEGORIA(?,?,?)}";
        int indexIdCategoria=1;
        int indexNombreCategoria =2;
        int indexIdCentroCategoria =3;
        
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdCategoria, categoria.getId_categoria());
        statement.setString(indexNombreCategoria, categoria.getNombre_categoria());
        statement.setString(indexIdCentroCategoria, categoria.getId_centro_categoria());        
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
     * @param categoria
     * @return Retorna Null si la categoria no se encuetra en la base de datos, de lo
     * contrario retorna los datos de la Categoria.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean UpdateCategoria(Categoria_Bean categoria) throws SQLException {
        boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en la base de datoos
        String query ="{CALL EDITAR_CATEGORIA(?,?,?)}";
        int indexIdCategoria=1;
        int indexNombreCategoria =2;
        int indexIdCentroCategoria =3;
        
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdCategoria, categoria.getId_categoria());
        statement.setString(indexNombreCategoria, categoria.getNombre_categoria());
        statement.setString(indexIdCentroCategoria, categoria.getId_centro_categoria());        
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
     * @param categoria
     * @return Retorna Null si  la Categoria no se encuetra en la base de datos, de lo
     * contrario retorna los datos de la Categoria.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean DeleteCategoria(Categoria_Bean categoria) throws SQLException {
        boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en la base de datoos
        String query ="{CALL ELIMINAR_CATEGORIA(?)}";
        int indexIdCategoria=1;
        
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdCategoria, categoria.getId_categoria());       
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
