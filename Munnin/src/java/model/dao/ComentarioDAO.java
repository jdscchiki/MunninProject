/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import model.bean.Comentario;
import model.bean.Funcionario;
import model.bean.Producto;
import util.database.ConexionBD;

/**
 *
 * @author Juan David Segura
 */
public class ComentarioDAO extends ConexionBD {

    private static final String COL_ID = "id_comentario";
    private static final String COL_VALORACION = "valoracion_comentario";
    private static final String COL_PUNTUACION = "puntuacion_comentario";
    private static final String COL_FECHA = "fecha_comentario";
    private static final String COL_ID_PRODUCTO = "id_producto_comentario";
    private static final String COL_ID_FUNCIONARIO = "id_funcionario_comentario";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     */
    public ComentarioDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar un comentario en la base de datos
     *
     * @deprecated
     * @param comentario Datos del comentario insertado
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(Comentario comentario) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_COMENTARIO(?,?,?,?,?)}";
        int indexValoracion = 1;
        int indexPuntuacion = 2;
        int indexFecha = 3;
        int indexIdProducto = 4;
        int indexIdFuncionario = 5;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setString(indexValoracion, comentario.getValoracion());
        statement.setInt(indexPuntuacion, comentario.getPuntuacion());
        statement.setDate(indexFecha, (Date) comentario.getFecha());
        statement.setInt(indexIdProducto, comentario.getProducto().getId());
        statement.setInt(indexIdFuncionario, comentario.getFuncionario().getId());
        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * Metodo para actualizar un comentario en la base de datos
     *
     * @deprecated
     * @param comentario Datos del comentario a ser modificado
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(Comentario comentario) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_COMENTARIO(?,?,?,?,?,?)}";
        int indexId = 1;
        int indexValoracion = 2;
        int indexPuntuacion = 3;
        int indexFecha = 4;
        int indexIdProducto = 5;
        int indexIdFuncionario = 6;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, comentario.getId());
        statement.setString(indexValoracion, comentario.getValoracion());
        statement.setInt(indexPuntuacion, comentario.getPuntuacion());
        statement.setDate(indexFecha, (Date) comentario.getFecha());
        statement.setInt(indexIdProducto, comentario.getProducto().getId());
        statement.setInt(indexIdFuncionario, comentario.getFuncionario().getId());

        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * Metodo para borrar un comentario en la base de datos
     *
     * @deprecated
     * @param comentario Datos del comentario
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(Comentario comentario) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_COMENTARIO(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, comentario.getId());

        if (statement.executeUpdate() == 1) {
            this.getConexion().commit();
            resultado = true;
        } else {
            this.getConexion().rollback();
            resultado = false;
        }
        return resultado;
    }

    /**
     * Metodo para ver los datos de un comentario
     *
     * @param comentario Objeto de tipo Comentario que en el atributo id tiene
     * el valor del id a ser consultado
     * @return los valores almacenados en la tabla comentario de la base de
     * datos
     * @throws SQLException
     */
    public Comentario select(Comentario comentario) throws SQLException {

        String query = "{CALL VER_CATEGORIA(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, comentario.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            comentario.setId(rs.getInt(COL_ID));
            comentario.setValoracion(rs.getString(COL_VALORACION));
            comentario.setPuntuacion(rs.getInt(COL_PUNTUACION));
            comentario.setFecha(rs.getDate(COL_FECHA));
            Producto producto = new Producto();
            producto.setId(rs.getInt(COL_ID_PRODUCTO));
            comentario.setProducto(producto);
            Funcionario funcionario = new Funcionario();
            funcionario.setId(rs.getInt(COL_ID_FUNCIONARIO));
            comentario.setFuncionario(funcionario);
        }
        if (!encontrado) {
            comentario = null;
        }

        return comentario;
    }

    public ArrayList<Comentario> selectAll() throws SQLException {
        ArrayList<Comentario> result = new ArrayList<>();

        String query = "{CALL VER_TODOS_CATEGORIA()}";

        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Comentario comentario = new Comentario();
            comentario.setId(rs.getInt(COL_ID));
            comentario.setValoracion(rs.getString(COL_VALORACION));
            comentario.setPuntuacion(rs.getInt(COL_PUNTUACION));
            comentario.setFecha(rs.getDate(COL_FECHA));
            Producto producto = new Producto();
            producto.setId(rs.getInt(COL_ID_PRODUCTO));
            comentario.setProducto(producto);
            Funcionario funcionario = new Funcionario();
            funcionario.setId(rs.getInt(COL_ID_FUNCIONARIO));
            comentario.setFuncionario(funcionario);
            result.add(comentario);
        }

        return result;
    }
}
