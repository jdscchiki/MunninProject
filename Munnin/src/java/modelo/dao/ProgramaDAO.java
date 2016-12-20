/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import modelo.bean.Programa;
import util.ConexionBD;

/**
 *
 * @author Juan David Segura
 */
public class ProgramaDAO extends ConexionBD {

    private static final String COL_ID = "id_programa";
    private static final String COL_NOMBRE = "nombre_programa";
    private static final String COL_ID_AREA = "id_area_programa";

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     */
    public ProgramaDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Metodo para insertar un programa en la base de datos
     *
     * @deprecated
     * @param programa Datos del programa insertado
     * @return True si la insercion fue completada exitosamente
     * @throws SQLException
     */
    public boolean Insert(Programa programa) throws SQLException {
        boolean resultado;

        String query = "{CALL INSERTAR_PROGRAMA(?,?,?)}";
        int indexId = 1;
        int indexNombre = 2;
        int indexIdArea = 3;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, programa.getId());
        statement.setString(indexNombre, programa.getNombre());
        statement.setInt(indexIdArea, programa.getIdArea());
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
     * Metodo para actualizar una programa en la base de datos
     *
     * @deprecated
     * @param programa Datos del programa a ser modificado
     * @return True si la modificacion fue completada exitosamente
     * @throws SQLException
     */
    public boolean update(Programa programa) throws SQLException {
        boolean resultado;

        String query = "{CALL EDITAR_PROGRAMA(?,?,?)}";
        int indexId = 1;
        int indexNombre = 2;
        int indexIdArea = 3;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, programa.getId());
        statement.setString(indexNombre, programa.getNombre());
        statement.setInt(indexIdArea, programa.getIdArea());
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
     * Metodo para borrar un programa en la base de datos
     *
     * @deprecated
     * @param programa Datos del programa
     * @return True si fue borrada exitosamente
     * @throws SQLException
     */
    public boolean delete(Programa programa) throws SQLException {
        boolean resultado;

        String query = "{CALL ELIMINAR_PROGRAMA(?)}";
        int indexId = 1;

        CallableStatement statement = getConexion().prepareCall(query);
        statement.setInt(indexId, programa.getId());

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
     * Metodo para ver los datos de un programa
     *
     * @param programa Objeto de tipo Programa que en el atributo id tiene el
     * valor del id a ser consultado
     * @return los valores almacenados en la tabla programa de la base de datos
     * @throws SQLException
     */
    public Programa select(Programa programa) throws SQLException {

        String query = "{CALL VER_PROGRAMA(?)}";
        int indexId = 1;

        CallableStatement statement = this.getConexion().prepareCall(query);
        statement.setInt(indexId, programa.getId());
        ResultSet rs = statement.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            programa.setId(rs.getInt(COL_ID));
            programa.setNombre(rs.getString(COL_NOMBRE));
            programa.setIdArea(rs.getInt(COL_ID_AREA));
        }
        if (!encontrado) {
            programa = null;
        }

        return programa;
    }
}
