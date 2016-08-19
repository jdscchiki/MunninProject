package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Tipo_Archivo_Bean;
import util.ClassConexion;


public class Tipo_Archivo_Dao extends ClassConexion  {

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_tipo_archivo;
    public String extencion_tipo_archivo;

    public Tipo_Archivo_Dao(Tipo_Archivo_Bean Tipo_Archivo) {
        super();
            conn = this.obtenerConexion();

            id_tipo_archivo = Tipo_Archivo.getId_tipo_archivo();
            extencion_tipo_archivo = Tipo_Archivo.getExtencion_tipo_archivo();
    }
    
    public boolean insertar_tipo_archivo() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_tipo_archivo (?,?)}");
            cst.setLong(1, id_tipo_archivo);
            cst.setString(2, extencion_tipo_archivo);

            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_tipo_archivo() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_tipo_archivo (?,?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_tipo_archivo);
            cst.setString(2, extencion_tipo_archivo);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_tipo_archivo() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_tipo_archivo (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_tipo_archivo);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public Tipo_Archivo_Bean ver_regional() {
        Tipo_Archivo_Bean tab = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_regional (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_tipo_archivo);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            tab = new Tipo_Archivo_Bean(id_tipo_archivo, cst.getString(2));
        } catch (SQLException e) {
        }
        return tab;
    }
}
