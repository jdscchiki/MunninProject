
package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import modelo.Beans.Version_Bean;


public class Version_Dao {
    
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_version;
    public long numero_version;
    public String url_version;
    public boolean notificacion_version;
    public Date fecha_version;
    public Date fecha_caducidad_version;
    public Date flecha_aprovacion_version;
    public int id_estdo_version;
    public int id_tipo_archivo_version;
    public int id_producto_version;
    public String id_centro_version;


    public Version_Dao(Version_Bean Version) {
        super();
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();

            id_version = Version.getId_version();
            numero_version = Version.getNumero_version();
            url_version = Version.getUrl_version();
            //notificacion_version = Version.getNotificacion_Version();
            fecha_version = Version.getFecha_version();
            fecha_caducidad_version = Version.getFecha_caducidad_version();
            flecha_aprovacion_version = Version.getFlecha_aprovacion_version();
            id_estdo_version = Version.getId_estdo_version();
            id_tipo_archivo_version = Version.getId_tipo_archivo_version();
            id_producto_version = Version.getId_producto_version();
            id_centro_version = Version.getId_centro_version();

        } catch (SQLException e) {
        }
    }
    
}
