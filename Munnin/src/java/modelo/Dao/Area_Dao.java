/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Dao;

import java.sql.*;
import java.sql.Statement;
import util.ClassConexion;
import modelo.Beans.Area_Bean;

/**
 *
 * @author Administrador
 */
public class Area_Dao extends ClassConexion {

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_area;
    public String nombre_area;
    public String id_centro_area;

    public Area_Dao(Area_Bean Area) {
        super();
        conn = this.obtenerConexion();
        id_area = Area.getId_area();
        nombre_area = Area.getNombre_area();
        id_centro_area = Area.getId_centro_area();

    }

    public boolean insertar_area() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_area (?,?,?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_area);
            cst.setString(2, nombre_area);
            cst.setString(3, id_centro_area);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_area() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_area (?,?,?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_area);
            cst.setString(2, nombre_area);
            cst.setString(3, id_centro_area);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_area() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_area (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_area);
            // Ejecuta el procedimiento almacenado
            cst.execute();
        } catch (SQLException e) {
        }
        return listo;
    }

    public Area_Bean ver_area() {
        Area_Bean ab = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_area (?)}");
            // Se envian parametros del procedimiento almacenado
            cst.setLong(1, id_area);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado                
            ab = new Area_Bean(id_area, cst.getString(2), cst.getString(3));
        } catch (SQLException e) {
        }
        return ab;
    }
}
