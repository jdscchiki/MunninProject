/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import util.ConexionBD;
import modelo.bean.TipoDocumento;

/**
 *
 * @author Juan David Segura Castro 
 */
public class TipoDocumentoDAO extends ConexionBD {

    private static final String COL_ID = "id_tipo_documento";
    private static final String COL_NOMBRE = "nombre_tipo_documento";

    /**
     * Establece conexion con la base de datos
     *
     * @throws NamingException Error en el constructor ConexionBD
     * @throws SQLException Error en el constructor ConexionBD
     */
    public TipoDocumentoDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Consulta en la base de datos todos los tipos de documentos permitidos en
     * el aplicativo
     *
     * @return ArrayList de objetos TipoDocumento
     * @throws SQLException Error al realizar la consulta, revisar el procedimiento almacenado
     */
    public ArrayList<TipoDocumento> verTodos() throws SQLException {
        ArrayList<TipoDocumento> tiposDoc = new ArrayList<>();//el objeto en donde se guardan los resultados de la consulta
        
        //datos de la consulta en base de datos
        String query = "{CALL VERTODOS_TIPO_DOCUMENTO()}";
        
        CallableStatement statement = this.getConexion().prepareCall(query);
        ResultSet rs = statement.executeQuery();//ejecuta la consulta
        while (rs.next()) {
            TipoDocumento td = new TipoDocumento();
            td.setId(rs.getInt(COL_ID));
            td.setNombre(rs.getString(COL_NOMBRE));
            tiposDoc.add(td);
        }

        return tiposDoc;
    }

}
