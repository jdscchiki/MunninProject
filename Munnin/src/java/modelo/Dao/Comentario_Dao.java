package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import util.ClassConexion;
import modelo.Beans.Comentario_Bean;
import util.ConexionBD;

 //cosas a tener en cuenta:
//  documentar los metodos, es facil con la herramienta javadoc
//  traten de ser lo mas explicitos posibles en la descripcion de los metodos
/**
 * Esta clase realiza y procesa las consultas a bases de datos, de las tablas
 * Comentario.
 *
 * @version 1.3
 * @author Monica <JBadCode>
 */

public class Comentario_Dao extends ConexionBD  {

    private static final String COL_ID_COMENTARIO = "id_comentario";
    private static final String COL_VALORACION_COMENTARIO = "valoracion_comentario";
    private static final String COL_PUNTUACION_COMENTARIO = "puntuacion_comentario";
    private static final String COL_FECHA_COMENTARIO = "fecha_comentario";
    private static final String COL_ID_PRODUCTO_COMENTARIO = "id_producto_comentario";
    private static final String COL_ID_FUNCIONARIO_COMENTARIO= "id_funcionario_comentario";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public Comentario_Dao() throws NamingException, SQLException {
        super();
    }

    /**
     *
     * @param comentario
     * @return Retorna Null si el Comentario no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Comentario.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean InsertarComentario(Comentario_Bean comentario) throws SQLException {
        boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query ="{CALL INSERTAR_COMENTARIO(?,?,?,?,?,?)}";
        int indexIdComentario = 1;
        int indexValoracioncomentario = 2;
        int indexPuntuacioncomentario = 3;
        int indexFechaComentario = 4;
        int indexIdProductoComentario = 5;
        int indexIdFuncionarioComentario = 6;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdComentario, comentario.getId_comentario());
        statement.setString(indexValoracioncomentario, comentario.getValoracion_comentario());
        statement.setInt(indexPuntuacioncomentario, comentario.getPuntuacion_comentario()); 
        statement.setDate(indexFechaComentario,(java.sql.Date) comentario.getFecha_comentario());
        statement.setLong(indexIdProductoComentario, comentario.getId_producto_comentario()); 
        statement.setLong(indexIdFuncionarioComentario, comentario.getId_funcionario_comentario());
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
     * @param comentario
     * @return Retorna Null si el Comentario no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Comentario.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean UpdateComentario(Comentario_Bean comentario) throws SQLException {
        boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query ="{CALL EDITAR_COMENTARIO(?,?,?,?,?,?)}";
        int indexIdComentario = 1;
        int indexValoracioncomentario = 2;
        int indexPuntuacioncomentario = 3;
        int indexFechaComentario = 4;
        int indexIdProductoComentario = 5;
        int indexIdFuncionarioComentario = 6;
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdComentario, comentario.getId_comentario());
        statement.setString(indexValoracioncomentario, comentario.getValoracion_comentario());
        statement.setInt(indexPuntuacioncomentario, comentario.getPuntuacion_comentario()); 
        statement.setDate(indexFechaComentario,(java.sql.Date) comentario.getFecha_comentario());
        statement.setLong(indexIdProductoComentario, comentario.getId_producto_comentario()); 
        statement.setLong(indexIdFuncionarioComentario, comentario.getId_funcionario_comentario());
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
     * @param comentario
     * @return Retorna Null si el Comentario no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Comentario.
     * @version 1.3
     * @throws java.sql.SQLException
     */
    public boolean DeleteComentario(Comentario_Bean comentario) throws SQLException {
        boolean resultado;//esta es la futura respuesta
        
        //datos de la consulta en base de datos
        String query ="{CALL ELIMINAR_COMENTARIO(?)}";
        int indexIdComentario = 1;
        
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setLong(indexIdComentario, comentario.getId_comentario());
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
