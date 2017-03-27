/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.bean.Notificacion;

/**
 *
 * @author Juan David Segura
 */
public class MessageGenerator {

    public static String menssageRole(Notificacion notificacion) {
        String result = "";
        if (notificacion.getVersion() == null) {
            result = "Una notificacion";
        } else {
            String text = notificacion.getMensaje().getTexto();
            result = String.format(text, notificacion.getVersion().getProducto().getNombre(), notificacion.getVersion().getNumero());
        }

        return result;
    }
}
