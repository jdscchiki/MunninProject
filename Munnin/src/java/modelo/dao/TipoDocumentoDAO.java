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
 * @author Juan David Segura Castro <JBadCode>
 */
public class TipoDocumentoDAO extends ConexionBD {

    private static final String COL_ID = "id_tipo_documento";
    private static final String COL_NOMBRE = "nombre_tipo_documento";

    private static final String PROCEDURE_VERTODOS = "{CALL VERTODOS_TIPO_DOCUMENTO()}";

    /**
     * Establece conexion con la base de datos
     *
     * @throws NamingException
     * @throws SQLException
     */
    public TipoDocumentoDAO() throws NamingException, SQLException {
        super();
    }

    /**
     * Consulta en la base de datos todos los tipos de documentos permitidos en
     * el aplicativo
     *
     * @return ArrayList de objetos TipoDocumento
     * @throws SQLException
     */
    public ArrayList<TipoDocumento> verTodos() throws SQLException {
        ArrayList<TipoDocumento> tiposDoc = new ArrayList<>();
        CallableStatement statement = this.getConexion().prepareCall(PROCEDURE_VERTODOS);
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
