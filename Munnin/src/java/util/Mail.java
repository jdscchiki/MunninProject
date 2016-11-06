/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import modelo.bean.Funcionario;

/**
 * clase dedicada para operaciones de envio de datos via eMail
 *
 * @author Juan David Segura Castro 
 */
public class Mail {

    private static final String CORREO_DE = "MunninProject@gmail.com";//poner un correo con los permisos
    private static final String NOMBRE_DE = "Munnin";
    private static final String USUARIO = "MunninProject@gmail.com";//poner un usuario con los permisos, en gmail es el mismo correo
    private static final String CONTRASENA = "fr9imDHi";//contraseña del correo

    private static final String MENSAJE_ASUNTO = "Contraseña Munnin";
    private static final String MENSAJE_CONTENIDO_1 = "Este correo ha sido registrado en la base de datos de Munnin con los siguientes datos.";
    private static final String MENSAJE_CONTENIDO_2 = "/n Nombre completo: ";
    private static final String MENSAJE_CONTENIDO_3 = "/n Documento: ";
    private static final String MENSAJE_CONTENIDO_4 = "/n Contraseña: ";

    private static final String PROTOCOLO = "smtps";
    private static final String HOST = "smtp.gmail.com";

    /**
     * Metodo dedicado al envio de correos con la contraseña para ingresar a la
     * plataforma
     *
     * @param destinatario Funcionario al cual se le envia el correo
     * @param Contrasena Contraseña sin encriptar que sera enviada al correo
     * @return True si se envio correctamente la contraseña, False en caso contrario
     */
    public static boolean enviarPrimeraContrasena(Funcionario destinatario, String Contrasena) {
        boolean resultado = true;

        String nombreCompleto = destinatario.getNombre() + " " + destinatario.getApellido();
        String textoMensaje = MENSAJE_CONTENIDO_1
                + MENSAJE_CONTENIDO_2 + nombreCompleto
                + MENSAJE_CONTENIDO_3 + destinatario.getDocumento()
                + MENSAJE_CONTENIDO_4 + Contrasena;

        Properties properties = new Properties();
        Session session = Session.getInstance(properties);
        MimeMessage msg = new MimeMessage(session);

        Transport t = null;
        try {
            Address origen = new InternetAddress(CORREO_DE, NOMBRE_DE);
            Address destino = new InternetAddress(destinatario.getCorreo());

            msg.setText(textoMensaje);
            msg.setFrom(origen);
            msg.setRecipient(Message.RecipientType.TO, destino);
            msg.setSubject(MENSAJE_ASUNTO);

            t = session.getTransport(PROTOCOLO);
            t.connect(HOST, USUARIO, CONTRASENA);
            t.sendMessage(msg, msg.getAllRecipients());

            resultado = true;
        } catch (MessagingException | UnsupportedEncodingException ex) {
            System.out.println("Error al enviar el correo con la contraseña.");
            System.out.println("Error: " + ex);
        } finally {
            if (t != null) {
                try {
                    t.close();
                } catch (MessagingException ex) {
                    System.out.println("Error al cerrar la conexion con el correo");
                }
            }
        }

        return resultado;
    }
}
