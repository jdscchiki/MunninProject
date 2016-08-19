/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Beans.Autor_Bean;
import modelo.Beans.Detalle_Lista_Bean;
import util.ClassConexion;

/**
 *
 * @author Administrador
 */
public class Detalle_Lista_Dao extends ClassConexion {

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public long id_detalle_lista;
    public long id_lista_detalle_lista;
    public long id_item_detalle_lista;

    public Detalle_Lista_Dao(Detalle_Lista_Bean Detalle_Lista) {
        super();
        conn = this.obtenerConexion();
        id_detalle_lista = Detalle_Lista.getId_detalle_lista();
        id_lista_detalle_lista = Detalle_Lista.getId_detalle_lista();
        id_item_detalle_lista = Detalle_Lista.getId_item_detalle_lista();
    }
    
    public boolean insertar_detalle_lista() {
        try {
            CallableStatement cst = conn.prepareCall("{call insertar_detalle_lista (?,?,?)}");
            } catch (SQLException e) {
        }
        return listo;
    }

    public boolean editar_detalle_lista() {
        try {
            CallableStatement cst = conn.prepareCall("{call editar_detalle_lista (?,?,?)}");
            } catch (SQLException e) {
        }
        return listo;
    }

    public boolean eliminar_detalle_lista() {
        try {
            CallableStatement cst = conn.prepareCall("{call eliminar_detalle_lista (?)}");
            } catch (SQLException e) {
        }
        return listo;
    }

    public Detalle_Lista_Bean ver_detalle_lista() {
        Detalle_Lista_Bean ab = null;
        try {
            CallableStatement cst = conn.prepareCall("{call ver_detalle_lista (?)}");
        } catch (SQLException e) {
        }
        return ab;
    }
}
