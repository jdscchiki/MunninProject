package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.ProgramaProductoBean;
import util.ClassConexion;

public class ProgramaProductoDao extends ClassConexion {

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_producto_prog_prod;
    public long id_programa_prog_prod;

    public ProgramaProductoDao(ProgramaProductoBean Programa_Prod) {
        super();
        conn = this.obtenerConexion();
        id_producto_prog_prod = Programa_Prod.getId_producto_prog_prod();
        id_programa_prog_prod = Programa_Prod.getId_programa_prog_prod();

    }

    public boolean insertar_programa_producto() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_programa_producto (?,?)}");
            cst.setLong(1, id_producto_prog_prod);
            cst.setLong(2, id_programa_prog_prod);
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_programa_producto() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_programa_producto (?,?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_producto_prog_prod);
            cst.setLong(2, id_programa_prog_prod);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_programa_producto() {
        try {
            CallableStatement cst = conn.prepareCall("{call elimina_programa_producto (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_producto_prog_prod);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public ProgramaProductoBean ver_programa_producto() {
        ProgramaProductoBean pp = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_programa_producto (?)}");
            
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_producto_prog_prod);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            pp = new ProgramaProductoBean(id_producto_prog_prod, cst.getLong(2));
        } catch (SQLException e) {
        }
        return pp;
    }
}
