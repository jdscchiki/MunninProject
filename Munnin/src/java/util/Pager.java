/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Juan David Segura
 */
public class Pager {

    /**
     * Metodo para definir la primera pagina en un paginador
     *
     * @param actualPage pagina en la que se encuentra
     * @param totalPages cantidad total de paginas
     * @param pagesShown cantidad de redirecciones a otras paginas que van a ser
     * mostradas en el paginador
     * @return la primera pagina a linkear en el paginador
     */
    public static int firstPage(int actualPage, int totalPages, int pagesShown) {
        int result = 1;

        if (totalPages > pagesShown) {
            if (actualPage > totalPages - (pagesShown / 2)) {
                result = totalPages - pagesShown;
            } else if (actualPage > 5) {
                result = actualPage - (pagesShown / 2);
            }
        }

        return result;
    }

    /**
     * Metodo para definir la ultima pagina en un paginador
     *
     * @param actualPage pagina en la que se encuentra actualmente
     * @param totalPages cantidad de paginas en total
     * @param pagesShown cantidad de redirecciones a otras paginas que van a ser
     * mostradas en el paginador
     * @return la ultima pagina a linkear en el paginador
     */
    public static int lastPage(int actualPage, int totalPages, int pagesShown) {
        int result = pagesShown;

        if (totalPages > pagesShown) {

            if (actualPage > totalPages - (pagesShown / 2)) {
                result = totalPages;
            } else if (actualPage > pagesShown / 2) {
                result = actualPage + (pagesShown / 2);
            }
        } else {
            result = totalPages;
        }

        return result;
    }

    public static ArrayList<Integer> showLinkedPages(int actualPage, int totalPages, int pagesShown) {
        ArrayList<Integer> result = new ArrayList<>();

        if (totalPages == 0) {
            return null;
        }

        int start = firstPage(actualPage, totalPages, pagesShown);
        int end = lastPage(actualPage, totalPages, pagesShown);

        for (int i = start; i <= end; i++) {
            result.add(i);
        }

        return result;
    }

    public static String getSearchParameters(HttpServletRequest request) {
        String result = "";

        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            if (!"page".equals(parameterName)) {
                String[] parameterValues = request.getParameterValues(parameterName);
                for (String parameterValue : parameterValues) {
                    result += parameterName + "=" + parameterValue + "&";
                }
            }
        }

        return result;
    }

}
