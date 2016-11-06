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
        boolean lvl1 = false;
        boolean lvl2 = false;
        boolean lvl3 = false;
        boolean lvl4 = false;

        bucle:
        for (int i = 0; i < password.length(); i++) {
            if (!lvl1) {
                for (int j = 0; j < NUMEROS.length(); j++) {
                    if (password.charAt(i) == NUMEROS.charAt(j)) {
                        lvlSecurity++;
                        lvl1 = true;
                        continue bucle;
                    }
                }
            }
            if (!lvl2) {
                for (int j = 0; j < MAYUSCULAS.length(); j++) {
                    if (password.charAt(i) == MAYUSCULAS.charAt(j)) {
                        lvlSecurity++;
                        lvl2 = true;
                        continue bucle;
                    }
                }
            }
            if (!lvl3) {
                for (int j = 0; j < MINUSCULAS.length(); j++) {
                    if (password.charAt(i) == MINUSCULAS.charAt(j)) {
                        lvlSecurity++;
                        lvl3 = true;
                        continue bucle;
                    }
                }
            }
            if (!lvl4) {
                for (int j = 0; j < ESPECIALES.length(); j++) {
                    if (password.charAt(i) == ESPECIALES.charAt(j)) {
                        lvlSecurity++;
                        lvl4 = true;
                        continue bucle;
                    }
                }
            }
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
        if (evaluatePassword(password) >= 3) {
            return true;
        }
        return false;
    }

    /**
     * Retorna una contraseña segura
     *
     * @return contraseña
     * @see util.PassGenerator#isSecure(java.lang.String)
     */
    public static String getSecurePassword() {
        String pass = "";
        boolean flag = true;
        while (flag) {
            pass = getPassword();
            if (isSecure(pass)) {
                flag = false;
            }
        }
        return pass;
    }
}
