/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.naming.NamingException;
import model.bean.Estado;
import model.bean.EvaluacionItem;
import model.bean.EvaluacionLista;
import model.bean.Funcionario;
import model.bean.Item;
import model.bean.Lista;
import model.bean.TipoLista;
import model.bean.Version;
import model.dao.EvaluacionItemDAO;
import model.dao.EvaluacionListaDAO;
import model.dao.ItemDAO;
import model.dao.ListaDAO;
import model.dao.NotificacionDAO;
import model.dao.VersionDAO;

/**
 *
 * @author Sergio
 */
public class Technical {

    public static int countPagesFilesCenter(String idCentro, int cantXpag, String search) throws NamingException, SQLException {
        int paginas;
        int countAreas;
        VersionDAO versionDAO = new VersionDAO();
        countAreas = versionDAO.countFilesCenter(idCentro, search);
        versionDAO.closeConnection();
        paginas = countAreas / cantXpag;
        if (countAreas % cantXpag != 0) {
            paginas++;
        }

        return paginas;
    }

    public static ArrayList<Version> viewFilesCenter(String idCentro, int pagina, int cantXpag, String search) throws NamingException, SQLException {
        ArrayList<Version> version;
        VersionDAO versionDAO = new VersionDAO();
        version = versionDAO.selectSomeFilesCenter(idCentro, pagina, cantXpag, search);

        versionDAO.closeConnection();

        return version;
    }

    public static int countPagesCheckList(int idAutor, int cantXpag, String search) throws NamingException, SQLException {
        int paginas;
        int cantFuncionarios;
        ListaDAO listaDAO = new ListaDAO();
        cantFuncionarios = listaDAO.countCheckListFunctionay(idAutor, search, true, 1);
        listaDAO.closeConnection();

        paginas = cantFuncionarios / cantXpag;
        if (cantFuncionarios % cantXpag != 0) {
            paginas++;
        }

        return paginas;
    }

    public static ArrayList<Lista> viewCheckListFunctionary(int idAutor, int pagina, int cantXpag, String search) throws NamingException, SQLException {
        ArrayList<Lista> lista;
        ListaDAO listaDAO = new ListaDAO();
        lista = listaDAO.selectSomeCheckListFunctionary(idAutor, pagina, cantXpag, search, 1, true);
        listaDAO.closeConnection();

        return lista;
    }

    public static Version viewAllInfoVersion(int idVersion) throws NamingException, SQLException {
        Version resultado = new Version();
        VersionDAO versionDAO = new VersionDAO();
        resultado.setId(idVersion);
        resultado = versionDAO.select(resultado);

        versionDAO.closeConnection();

        return resultado;
    }

    public static Lista viewAllInfoLista(int idLista) throws NamingException, SQLException {
        Lista resultado = new Lista();
        ListaDAO listaDAO = new ListaDAO();
        resultado.setId(idLista);
        resultado = listaDAO.select(resultado);

        listaDAO.closeConnection();

        return resultado;
    }

    public static ArrayList<Item> viewItems(int idItem) throws NamingException, SQLException {
        ArrayList<Item> items;
        Item item = new Item();
        item.setId(idItem);
        ItemDAO itemDAO = new ItemDAO();
        items = itemDAO.selectItems(item);
        itemDAO.closeConnection();

        return items;
    }

    public static boolean AssignLista(int idVer, int idList, Funcionario funcionario) throws NamingException, SQLException {
        boolean resultado = false;
        Version version = new Version();
        Lista lista = new Lista();
        version.setId(idVer);
        lista.setId(idList);
        EvaluacionLista evaluacionLista = new EvaluacionLista();
        evaluacionLista.setEvaluador(funcionario);
        evaluacionLista.setLista(lista);
        evaluacionLista.setVersion(version);
        evaluacionLista.setObservaciones("bueno");
        evaluacionLista.setCalificacion(1);
        //se realizan la operaciones en la base de datos
        EvaluacionListaDAO evaluacionListaDAO = new EvaluacionListaDAO();
        resultado = evaluacionListaDAO.agregarListaVersion(evaluacionLista);
        evaluacionListaDAO.closeConnection();

        return resultado;
    }

    public static EvaluacionLista datosLista(int idVer, int idList, Funcionario funcionario) throws NamingException, SQLException {
        Version version = new Version();
        Lista lista = new Lista();
        version.setId(idVer);
        lista.setId(idList);
        EvaluacionLista evaluacionLista = new EvaluacionLista();
        evaluacionLista.setEvaluador(funcionario);
        evaluacionLista.setLista(lista);
        evaluacionLista.setVersion(version);
        EvaluacionListaDAO evListDAO = new EvaluacionListaDAO();
        evaluacionLista = evListDAO.selectEvList(evaluacionLista);
        evListDAO.closeConnection();
        return evaluacionLista;
    }

    public static boolean AssignItems(int idEvalucionLista, ArrayList<String> strIdItems, ArrayList<String> strComents) throws NamingException, SQLException {
        boolean resultado = false;
        int calificacion = 1, d=0;
        ArrayList<String> comentarios = new ArrayList<>();
        for (int i = 0; i < strComents.size(); i++) {
            if ("coment".equals(strComents.get(i).substring(0, 6))) {
                if ((strIdItems.get(d)).equals(strComents.get(i).substring(6, 7))) {
                    StringTokenizer tokens = new StringTokenizer(strComents.get(i), "=");
                    System.out.println(tokens.nextToken());
                    comentarios.add(tokens.nextToken());
                }
                d++;
            }
        }
        EvaluacionLista evList = new EvaluacionLista();
        evList.setId(idEvalucionLista);
        EvaluacionItem evItem;
        Item item;
        EvaluacionItemDAO evItemDAO = new EvaluacionItemDAO();
        for (int i = 0; i < strIdItems.size(); i++) {
            evItem = new EvaluacionItem();
            evItem.setCalificacion(calificacion);
            evItem.setObservarcion(comentarios.get(i));
            evItem.setEvaluacionLista(evList);
            item = new Item();
            item.setId(Integer.parseInt(strIdItems.get(i)));
            evItem.setItem(item);
            resultado = evItemDAO.AsignEvaluacionItem(evItem);
        }
        evItemDAO.closeConnection();

        return resultado;
    }

    public static boolean cambioEstado(int idVer) throws NamingException, SQLException {
        VersionDAO versionDAO = new VersionDAO();
        Estado estado = new Estado();
        estado.setId(4);
        Version version = new Version();
        version.setId(idVer);
        version.setEstado(estado);
        boolean resultado = false;
        if (versionDAO.updateEstado(version)) {
            resultado = true;
        }
        versionDAO.closeConnection();
        
        NotificacionDAO notificacionDAO = new NotificacionDAO();
        notificacionDAO.sendNotification(4, idVer);
        notificacionDAO.sendNotification(2, idVer);
        notificacionDAO.closeConnection();
        return resultado;
    }

    public static boolean cambioEstadoRechazado(int idVer) throws NamingException, SQLException {
        VersionDAO versionDAO = new VersionDAO();
        Estado estado = new Estado();
        estado.setId(1);
        Version version = new Version();
        version.setId(idVer);
        version.setEstado(estado);
        boolean resultado = false;
        if (versionDAO.updateEstado(version)) {
            resultado = true;
        }
        versionDAO.closeConnection();
        NotificacionDAO notificacionDAO = new NotificacionDAO();
        notificacionDAO.sendNotification(7, idVer);
        notificacionDAO.closeConnection();
        return resultado;
    }
    
    public static int guardarLista(Lista lista) throws NamingException, SQLException {
        lista.setTipoLista(new TipoLista());
        lista.getTipoLista().setId(1);
        
        ListaDAO listaDAO = new ListaDAO();
        int result = 0;
        listaDAO.newList(lista);
        boolean resultCreatelist = listaDAO.newList(lista);
        listaDAO.closeConnection();
        
        if(resultCreatelist){
            ItemDAO itemDAO = new ItemDAO();
            for (int i = 0; i < lista.getItems().size(); i++) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(lista.getIdAutor());
                lista.getItems().get(i).setAutor(funcionario);
                itemDAO.Insert(lista.getItems().get(i));
            }
            itemDAO.closeConnection();
            result = 1;
        }else{
            result = 2;
        }
        return result;
    }
    
    public static int changeActiveList(int idList, boolean active) throws SQLException, NamingException{
        int result = 0;
        
        ListaDAO listaDAO = new ListaDAO();
        if(listaDAO.changeActive(idList, active)){
            result = 1;
        }
        
        return result;
    }
}
