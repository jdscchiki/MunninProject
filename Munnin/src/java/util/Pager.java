/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

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
     * @param pagesShown cantidad de paginas que van a ser mostradas en el
     * paginador
     * @return la primera pagina la cual va a ser linkeada en el paginador
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

}
