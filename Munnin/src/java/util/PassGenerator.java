/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.security.SecureRandom;


/*
el codigo original fue obtenido de la pagina:
http://www.programacionenjava.com/blog/2008/04/09/javabasico/generacion-de-contrasenas-passwords/
y fue adaptado para las necesidades del proyecto.
 */
/**
 * clase dedicada a la generacion de contraseñas
 *
 * @author Juan David Segura Castro
 */
public class PassGenerator {

    public static final String NUMEROS = "0123456789";

    public static final String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";

    public static final String ESPECIALES = "ñÑ'\"/\\";//los deben definir despues... igual nadie los mira :v

    /**
     * Genera contraseñas aleatorias de 4 caracteres con numeros
     *
     * @return Contaseña de 4 caracteres
     */
    public static String getPinNumber() {
        return getPassword(NUMEROS, 4);
    }

    /**
     * Genera contraseñas aleatorias de 8 caracteres con numeros, mayusculas y
     * minusculas
     *
     * @return Contaseña de 8 caracteres
     */
    public static String getPassword() {
        return getPassword(8);
    }

    /**
     * Genera contraseñas aleatorias de una cantidad determinada de caracteres
     * con numeros, mayusculas y minusculas
     *
     * @param length Largo de la contraseña generada
     * @return Contraseña
     */
    public static String getPassword(int length) {
        return getPassword(NUMEROS + MAYUSCULAS + MINUSCULAS, length);
    }

    /**
     * Genera contraseñas aleatorias de una cantidad determinada de caracteres.
     *
     * @param key String de caracteres que puede contener la contraseña
     * @param length Largo de la contraseña generada
     * @return Contaseña
     */
    public static String getPassword(String key, int length) {
        String pswd = "";
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int charAtNumber = random.nextInt(key.length());
            pswd += (key.charAt(charAtNumber));
        }

        return pswd;
    }

    public static boolean hasNumber(String password) {
        for (int i = 0; i < password.length(); i++) {
            for (int j = 0; j < NUMEROS.length(); j++) {
                if (password.charAt(i) == NUMEROS.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasUppercase(String password) {
        for (int i = 0; i < password.length(); i++) {
            for (int j = 0; j < MAYUSCULAS.length(); j++) {
                if (password.charAt(i) == MAYUSCULAS.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasLowercase(String password) {
        for (int i = 0; i < password.length(); i++) {
            for (int j = 0; j < MINUSCULAS.length(); j++) {
                if (password.charAt(i) == MINUSCULAS.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean isSecureLong(String password) {
        
        return password.length() >= 8;
    }


    /**
     * Evalua si la contraseña posee minusculas, mayusculas, numeros y
     * caracteres especiales
     *
     * @param password contaseña a evaluar
     * @return valores de 1 a 4 dependiendo de que tipo de caracteres tenga la
     * contraseña
     */
    public static int evaluatePassword(String password) {
        int lvlSecurity = 0;

        if(hasNumber(password)){
            lvlSecurity++;
        }
        if(hasUppercase(password)){
            lvlSecurity++;
        }
        if(hasLowercase(password)){
            lvlSecurity++;
        }
        if(isSecureLong(password)){
            lvlSecurity++;
        }

        return lvlSecurity;
    }

    /**
     * Evalua si la contraseña tiene un minimo de seguridad
     *
     * @param password contaseña a evaluar
     * @return true si la contraseña tiene un nivel de seguridad mayor o igual a
     * 3
     * @see util.PassGenerator#evaluatePassword(java.lang.String)
     */
    public static boolean isSecure(String password) {

        return evaluatePassword(password) >= 4;

    }

    /**
     * Retorna una contraseña segura
     *
     * @return contraseña
     * @see util.PassGenerator#isSecure(java.lang.String)
     */
    public static String getSecurePassword() {
        String pass = "";

        while (true) {
            pass = getPassword();
            if (isSecure(pass)) {
                break;

            }
        }
        return pass;
    }

}
