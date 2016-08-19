/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import modelo.Beans.Visita_Bean;

/**
 *
 * @author Administrador
 */
public class Visita_Dao {

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public boolean encontrado = false;
    public boolean listo = false;

    public Date fecha_visita;
    public long id_producto_visita_visita;
    public long id_funcionario_visita;

    public Visita_Dao(Visita_Bean Visita) {
        super();
        try {
            //conn = this.obtenerConexion();
            st = conn.createStatement();

            fecha_visita = Visita.getFecha_visita();
            id_producto_visita_visita = Visita.getId_producto_visita_visita();
            id_funcionario_visita = Visita.getId_funcionario_visita();

        } catch (SQLException e) {
        }
    }

}
