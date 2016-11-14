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



public class Comentario_Dao extends ClassConexion  {

    private static final String COL_ID_COMENTARIO = "id_comentario";
    private static final String COL_VALORACION_COMENTARIO = "valoracion_comentario";
    private static final String COL_PUNTUACION_COMENTARIO = "puntuacion_comentario";
    private static final String COL_FECHA_COMENTARIO = "fecha_comentario";
    private static final String COL_ID_PRODUCTO_COMENTARIO = "id_producto_comentario";
    private static final String COL_ID_FUNCIONARIO_COMENTARIO= "id_funcionario_comentario";

    private static final String PROCEDURE_INSERT_COMENTARIO = "{CALL INSERTAR_COMENTARIO(?,?,?,?,?,?)}";
    //private static final int PROCEDURE_INGR_CORREO_INDEX = 1;
    private static final String PROCEDURE_UPDATE_COMENTARIO = "{CALL EDITAR_COMENTARIO(?,?,?,?,?,?)}";
    private static final String PROCEDURE_DELETE_COMENTARIO = "{CALL ElIMINAR_COMENTARIO(?)}";
    
    private static final int PROCEDURE_INSERTAR_COMENTARIO_ID_COMENTARIO_INDEX = 1;
    private static final int PROCEDURE_INSERTAR_COMENTARIO_VALORACION_COMENTARIO_INDEX = 2;
    private static final int PROCEDURE_INSERTAR_COMENTARIO_PUNTUACION_COMENTARIO_INDEX = 3;
    private static final int PROCEDURE_INSERTAR_COMENTARIO_FECHA_COMENTARIO_INDEX = 4;
    private static final int PROCEDURE_INSERTAR_COMENTARIO_ID_PRODUCTO_COMENTARIO_INDEX = 5;
    private static final int PROCEDURE_INSERTAR_COMENTARIO_ID_FUNCIONARIO_COMENTARIO_INDEX = 6;
    private static final int PROCEDURE_UPDATE_COMENTARIO_ID_COMENTARIO_INDEX = 1;
    private static final int PROCEDURE_UPDATE_COMENTARIO_VALORACION_COMENTARIO_INDEX= 2;
    private static final int PROCEDURE_UPDATE_COMENTARIO_PUNTUACION_COMENTARIO_INDEX = 3;
    private static final int PROCEDURE_UPDATE_COMENTARIO_FECHA_COMENTARIO_INDEX= 4;
    private static final int PROCEDURE_UPDATE_COMENTARIO_ID_PRODUCTO_COMENTARIO_INDEX = 5;
    private static final int PROCEDURE_UPDATE_COMENTARIO_ID_FUNCIONARIO_COMENTARIO_INDEX = 6;
    private static final int PROCEDURE_ELIMINAR_COMENTARIO_ID_COMENTARIO_INDEX = 1;

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
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean InsertarComentario(Comentario_Bean comentario) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_INSERT_COMENTARIO);
        statement.setLong(PROCEDURE_INSERTAR_COMENTARIO_ID_COMENTARIO_INDEX, comentario.getId_comentario());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_INSERTAR_COMENTARIO_VALORACION_COMENTARIO_INDEX, comentario.getValoracion_comentario());
        statement.setInt(PROCEDURE_INSERTAR_COMENTARIO_PUNTUACION_COMENTARIO_INDEX, comentario.getPuntuacion_comentario()); 
        statement.setDate(PROCEDURE_INSERTAR_COMENTARIO_FECHA_COMENTARIO_INDEX,(java.sql.Date) comentario.getFecha_comentario());
        statement.setLong(PROCEDURE_INSERTAR_COMENTARIO_ID_PRODUCTO_COMENTARIO_INDEX, comentario.getId_producto_comentario()); 
        statement.setLong(PROCEDURE_INSERTAR_COMENTARIO_ID_FUNCIONARIO_COMENTARIO_INDEX, comentario.getId_funcionario_comentario());
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
     * @param area
     * @return Retorna Null si el Area no se encuetra en la base de datos, de lo
     * contrario retorna los datos del Area.
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean UpdateComentario(Comentario_Bean comentario) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_UPDATE_COMENTARIO);
        statement.setLong(PROCEDURE_UPDATE_COMENTARIO_ID_COMENTARIO_INDEX, comentario.getId_comentario());//asigna los valores necesarios para ejecutar el QUERY
        statement.setString(PROCEDURE_UPDATE_COMENTARIO_VALORACION_COMENTARIO_INDEX, comentario.getValoracion_comentario());
        statement.setInt(PROCEDURE_UPDATE_COMENTARIO_PUNTUACION_COMENTARIO_INDEX, comentario.getPuntuacion_comentario()); 
        statement.setDate(PROCEDURE_UPDATE_COMENTARIO_FECHA_COMENTARIO_INDEX, comentario.getFecha_comentario());
        statement.setLong(PROCEDURE_UPDATE_COMENTARIO_ID_PRODUCTO_COMENTARIO_INDEX, comentario.getId_producto_comentario()); 
        statement.setLong(PROCEDURE_UPDATE_COMENTARIO_ID_FUNCIONARIO_COMENTARIO_INDEX, comentario.getId_funcionario_comentario());
        if (statement.executeUpdate() == 1) {
            this.getConxion().commit();
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
     * @version 1.0
     * @throws java.sql.SQLException
     */
    public boolean DeleteComentario(Comentario_Bean comentario) throws SQLException {
        boolean resultado;
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_DELETE_COMENTARIO);
        statement.setLong(PROCEDURE_ELIMINAR_COMENTARIO_ID_COMENTARIO_INDEX, comentario.getId_comentario());//asigna los valores necesarios para ejecutar el QUERY
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
