/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import modelo.bean.TipoDocumento;
import modelo.dao.TipoDocumentoDAO;

/**
 *
 * @author Juan David Segura Castro <JBadCode>
 */
public class NegocioCoordinador {
    
    public static ArrayList<TipoDocumento> verTiposDocumentos() throws NamingException, SQLException{
        ArrayList<TipoDocumento> tiposDoc;
        TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
        tiposDoc = tipoDocumentoDAO.verTodos();
        return tiposDoc;
    }
}
